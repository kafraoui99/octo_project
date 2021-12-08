package ma.octo.assignement.web.controllers;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    public CompteService compteService;

    @GetMapping
    public List<Compte> loadAllComptes() {
        return compteService.getAll();
    }
}
