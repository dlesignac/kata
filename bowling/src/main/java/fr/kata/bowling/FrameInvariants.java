package fr.kata.bowling;

public class FrameInvariants {

    private static void checkIsNotSpare(Roll roll) {
        if (roll == Roll.SPARE) throw new IllegalArgumentException();
    }

    private static void checkIsNotStrike(Roll roll) {
        if (roll == Roll.STRIKE) throw new IllegalArgumentException();
    }

    private static void checkSecondIsMoreThanFirst(Roll first, Roll second) {
        if (first.getPoints() - second.getPoints() > 0) throw new IllegalArgumentException();
    }

    static void checkAreValidSimpleRolls(Roll first, Roll second) {
        checkIsNotSpare(first);
        checkIsNotStrike(first);
        checkIsNotSpare(second);
        checkIsNotStrike(second);
        checkSecondIsMoreThanFirst(first, second);
    }

    static void checkAreValidSpareRolls(Roll first, Roll third) {
        checkIsNotSpare(first);
        checkIsNotStrike(first);
        checkIsNotSpare(third);
    }

    static void checkAreValidStrikeRolls(Roll second, Roll third) {
        checkIsNotSpare(second);
        if (second == Roll.STRIKE && third == Roll.SPARE) throw new IllegalArgumentException();
    }

}
