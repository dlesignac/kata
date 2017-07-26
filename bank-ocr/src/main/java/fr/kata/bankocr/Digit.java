package fr.kata.bankocr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Digit {

    ZERO("0") {
        @Override
        public List<Digit> findAlternatives() {
            return Collections.singletonList(Digit.EIGHT);
        }
    },
    ONE("1") {
        @Override
        public List<Digit> findAlternatives() {
            return Collections.singletonList(Digit.SEVEN);
        }
    },
    TWO("2"),
    THREE("3") {
        @Override
        public List<Digit> findAlternatives() {
            return Collections.singletonList(Digit.NINE);
        }
    },
    FOUR("4"),
    FIVE("5") {
        @Override
        public List<Digit> findAlternatives() {
            return Arrays.asList(Digit.SIX, Digit.NINE);
        }
    },
    SIX("6"){
        @Override
        public List<Digit> findAlternatives() {
            return Arrays.asList(Digit.FIVE, Digit.EIGHT);
        }
    },
    SEVEN("7") {
        @Override
        public List<Digit> findAlternatives() {
            return Collections.singletonList(Digit.ONE);
        }
    },
    EIGHT("8") {
        @Override
        public List<Digit> findAlternatives() {
            return Arrays.asList(Digit.ZERO, Digit.SIX, Digit.NINE);
        }
    },
    NINE("9") {
        @Override
        public List<Digit> findAlternatives() {
            return Arrays.asList(Digit.EIGHT, Digit.THREE, Digit.FIVE);
        }
    },
    UNKNOWN("?");

    private static final String STR_ZERO = " _ | ||_|";
    private static final String STR_ONE = "     |  |";
    private static final String STR_TWO = " _  _||_ ";
    private static final String STR_THREE = " _  _| _|";
    private static final String STR_FOUR = "   |_|  |";
    private static final String STR_FIVE = " _ |_  _|";
    private static final String STR_SIX = " _ |_ |_|";
    private static final String STR_SEVEN = " _   |  |";
    private static final String STR_EIGHT = " _ |_||_|";
    private static final String STR_NINE = " _ |_| _|";

    private String value;

    Digit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getValueAsInt() {
        if (this == UNKNOWN) {
            throw new UnsupportedOperationException("no int value for unrecognized digit");
        }

        return Integer.parseInt(value);
    }

    public List<Digit> findAlternatives() {
        return Collections.emptyList();
    }

    public static Digit of(String input) {
        Digit digit;

        switch (input) {
            case STR_ZERO:
                digit = ZERO;
                break;
            case STR_ONE:
                digit = ONE;
                break;
            case STR_TWO:
                digit = TWO;
                break;
            case STR_THREE:
                digit = THREE;
                break;
            case STR_FOUR:
                digit = FOUR;
                break;
            case STR_FIVE:
                digit = FIVE;
                break;
            case STR_SIX:
                digit = SIX;
                break;
            case STR_SEVEN:
                digit = SEVEN;
                break;
            case STR_EIGHT:
                digit = EIGHT;
                break;
            case STR_NINE:
                digit = NINE;
                break;
            default:
                digit = UNKNOWN;
                break;
        }

        return digit;
    }

    public static Digit of(char digitAsChar) {
        Digit digit;

        switch (digitAsChar) {
            case '0':
                digit = Digit.ZERO;
                break;
            case '1':
                digit = Digit.ONE;
                break;
            case '2':
                digit = Digit.TWO;
                break;
            case '3':
                digit = Digit.THREE;
                break;
            case '4':
                digit = Digit.FOUR;
                break;
            case '5':
                digit = Digit.FIVE;
                break;
            case '6':
                digit = Digit.SIX;
                break;
            case '7':
                digit = Digit.SEVEN;
                break;
            case '8':
                digit = Digit.EIGHT;
                break;
            case '9':
                digit = Digit.NINE;
                break;
            default:
                digit = Digit.UNKNOWN;
                break;
        }

        return digit;
    }
}
