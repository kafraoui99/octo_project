package ma.octo.assignement.web.controllers;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.service.AuditService;
import ma.octo.assignement.service.VirementService;
import ma.octo.assignement.web.common.VirementValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virements")
class VirementController {
    @Autowired
    private VirementService virementService;

    @GetMapping
    public List<Virement> loadAllVirements() {
        return virementService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody VirementDto virementDto)
            throws Exception {
        VirementValidator.validate(virementDto);
        virementService.createTransaction(virementDto);
    }

}
