package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService implements IService {
    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAll() {
        List<Compte> all = compteRepository.findAll();
        return CollectionUtils.isEmpty(all) ? null : all;
    }

    public Compte getCompteByNr(String nr) throws CompteNonExistantException {
        return Optional.ofNullable(compteRepository.findByNrCompte(nr)).orElseThrow(() -> new CompteNonExistantException("Compte Non existant"));
    }

    public void updateSolde(Compte compte, BigDecimal montant) {
        compte.setSolde(compte.getSolde().add(montant));
    }
}
