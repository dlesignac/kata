package fr.kata.bowling;

import java.util.Objects;

import static fr.kata.bowling.FrameInvariants.checkAreValidStrikeRolls;

public class Strike implements Frame {

    private Roll second;
    private Roll third;

    public Strike(Roll second, Roll third) {
        this.second = Objects.requireNonNull(second);
        this.third = Objects.requireNonNull(third);
        checkAreValidStrikeRolls(second, third);
    }

    private int pointsFromNextFrame() {
        if (second == Roll.STRIKE) return second.getPoints() + third.getPoints();
        return third.getPoints();
    }

    @Override
    public int getPoints() {
        return Roll.STRIKE.getPoints() + pointsFromNextFrame();
    }
}
