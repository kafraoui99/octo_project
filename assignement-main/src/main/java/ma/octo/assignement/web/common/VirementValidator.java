package ma.octo.assignement.web.common;

import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.TransactionException;

import java.math.BigDecimal;

public class VirementValidator {
    public static final int MONTANT_MAXIMAL = 10000;

    public static void validate(VirementDto virementDto) throws TransactionException {
        BigDecimal montant = virementDto.getMontantVirement();
        if (montant == null) {
            throw new TransactionException("Montant vide");
        } else if (montant.intValue() == 0) {
            throw new TransactionException("Montant vide");
        } else if (montant.intValue() < 10) {
            throw new TransactionException("Montant minimal de virement non atteint");
        } else if (montant.intValue() > MONTANT_MAXIMAL) {
            throw new TransactionException("Montant maximal de virement dépassé");
        }
        if (virementDto.getMotif().length() < 0) {
            throw new TransactionException("Motif vide");
        }
    }
}
