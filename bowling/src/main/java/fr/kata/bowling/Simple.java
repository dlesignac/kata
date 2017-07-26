package fr.kata.bowling;

import java.util.Objects;

import static fr.kata.bowling.FrameInvariants.checkAreValidSimpleRolls;

public class Simple implements Frame {

    private Roll first;
    private Roll second;

    public Simple(Roll first, Roll second) {
        this.first = Objects.requireNonNull(first);
        this.second = Objects.requireNonNull(second);
        checkAreValidSimpleRolls(first, second);
    }

    @Override
    public int getPoints() {
        return second.getPoints();
    }
}
