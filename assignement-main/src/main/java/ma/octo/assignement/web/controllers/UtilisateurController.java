package ma.octo.assignement.web.controllers;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    @Autowired
    public UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> loadAllUtilisateurs() {
        return utilisateurService.getAll();
    }

}
