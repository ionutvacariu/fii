package eu.unicredit.fii.practic.fii.miscellaneous;

public class NotEnoughFondsException extends RuntimeException {
    public NotEnoughFondsException(Double amount) {
        super("Not enough fonds " + amount);
    }
}
