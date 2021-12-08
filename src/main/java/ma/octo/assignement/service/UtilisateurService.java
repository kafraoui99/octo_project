package ma.octo.assignement.service;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UtilisateurService implements IService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAll() {
        List<Utilisateur> all = utilisateurRepository.findAll();
        return CollectionUtils.isEmpty(all) ? null : all;
    }
}
