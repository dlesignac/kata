package fr.kata.bankocr;

import java.util.Set;

public class Digit {

    private DigitValue perfectMatch;
    private Set<DigitValue> potentielMatches;

    Digit(String representation) {
        DigitValue.findPerfectMatch(representation).ifPresent(digitValue -> this.perfectMatch = digitValue);
        this.potentielMatches = DigitValue.findPotentialMatches(representation);
    }

    Digit(DigitValue digitValue) {
        this.perfectMatch = digitValue;
    }

    DigitValue getPerfectMatch() {
        return perfectMatch;
    }

    Set<DigitValue> getPotentielMatches() {
        return potentielMatches;
    }

    @Override
    public String toString() {
        return perfectMatch == null ? "?" : perfectMatch.toString();
    }
}
