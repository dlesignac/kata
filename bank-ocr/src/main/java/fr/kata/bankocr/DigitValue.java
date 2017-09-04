package fr.kata.bankocr;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static fr.kata.bankocr.StringComparator.numberOfDifferences;

public enum DigitValue {

    ZERO(0, " _ | ||_|"),
    ONE(1, "     |  |"),
    TWO(2, " _  _||_ "),
    THREE(3, " _  _| _|"),
    FOUR(4, "   |_|  |"),
    FIVE(5, " _ |_  _|"),
    SIX(6, " _ |_ |_|"),
    SEVEN(7, " _   |  |"),
    EIGHT(8, " _ |_||_|"),
    NINE(9, " _ |_| _|");

    private int intRepresentation;
    private String stringRepresentation;

    DigitValue(int intRepresentation, String stringRepresentation) {
        this.intRepresentation = intRepresentation;
        this.stringRepresentation = stringRepresentation;
    }

    int toInt() {
        return this.intRepresentation;
    }

    @Override
    public String toString() {
        return String.valueOf(toInt());
    }

    static Optional<DigitValue> findPerfectMatch(String representation) {
        return Arrays.stream(DigitValue.values())
                .filter(value -> value.stringRepresentation.equals(representation))
                .findFirst();
    }

    static Set<DigitValue> findPotentialMatches(String representation) {
        return Arrays.stream(DigitValue.values())
                .filter(value -> numberOfDifferences(value.stringRepresentation, representation) == 1)
                .collect(Collectors.toSet());
    }
}
