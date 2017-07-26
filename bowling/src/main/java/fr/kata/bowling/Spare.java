package fr.kata.bowling;

import java.util.Objects;

import static fr.kata.bowling.FrameInvariants.checkAreValidSpareRolls;

public class Spare implements Frame {

    private Roll first;
    private Roll third;

    public Spare(Roll first, Roll third) {
        this.first = Objects.requireNonNull(first);
        this.third = Objects.requireNonNull(third);
        checkAreValidSpareRolls(first, third);
    }

    @Override
    public int getPoints() {
        return Roll.SPARE.getPoints() + third.getPoints();
    }
}
