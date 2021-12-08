package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VirementService implements IService {
    @Autowired
    private VirementRepository virementRepository;
    @Autowired
    private CompteService compteService;
    @Autowired
    private AuditService auditService;

    public List<Virement> getAll() {
        List<Virement> all = virementRepository.findAll();
        return CollectionUtils.isEmpty(all) ? null : all;
    }

    public void createTransaction(VirementDto virementDto) throws Exception {
        Compte compteEmmeteur = compteService.getCompteByNr(virementDto.getNrCompteEmetteur());
        Compte compteBenificiaire = compteService.getCompteByNr(virementDto.getNrCompteBeneficiaire());
        BigDecimal montant = virementDto.getMontantVirement();

        if (compteEmmeteur.getSolde().intValue() - montant.intValue() < 0) {
            throw new SoldeDisponibleInsuffisantException("Solde insuffisant pour l'utilisateur: " + compteEmmeteur.getNrCompte());
        }
        compteService.updateSolde(compteEmmeteur, montant.negate());
        compteService.updateSolde(compteBenificiaire, montant);

        Virement virement = new Virement();
        virement.setDateExecution(virementDto.getDate());
        virement.setCompteBeneficiaire(compteBenificiaire);
        virement.setCompteEmetteur(compteEmmeteur);
        virement.setMontantVirement(montant);

        virementRepository.save(virement);

        auditService.auditVirement(virementDto);
    }
}
