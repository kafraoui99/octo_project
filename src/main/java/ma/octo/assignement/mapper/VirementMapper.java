package ma.octo.assignement.mapper;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;

public class VirementMapper {

    private static VirementDto virementDto;

    public static VirementDto mapVirementToDto(Virement virement) {
        virementDto = new VirementDto();
        virementDto.setNrCompteEmetteur(virement.getCompteEmetteur().getNrCompte());
        virementDto.setDate(virement.getDateExecution());
        virementDto.setMotif(virement.getMotifVirement());

        return virementDto;

    }

    public static VirementDto mapDtoToVirement(Virement virement) {
        virementDto = new VirementDto();
        virementDto.setNrCompteEmetteur(virement.getCompteEmetteur().getNrCompte());
        virementDto.setDate(virement.getDateExecution());
        virementDto.setMotif(virement.getMotifVirement());

        return virementDto;

    }
}
