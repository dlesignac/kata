package fr.kata.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private static final int NUMBER_OF_FRAMES = 10;

    private List<Frame> frames;

    public Game(List<Frame> frames) {
        this.frames = Objects.requireNonNull(frames);
    }

    public int getPoints() {
        return frames.stream()
                .mapToInt(Frame::getPoints)
                .sum();
    }

    public static Game of(String line) {
        line = Strings.removeSpaces(line);
        List<Frame> frames = new ArrayList<>();

        int remainingFrames = NUMBER_OF_FRAMES;

        while (remainingFrames > 0) {
            Roll first = Roll.of(line.charAt(0));
            Roll second = Roll.of(line.charAt(1));

            if (first == Roll.STRIKE) {
                frames.add(new Strike(second, Roll.of(line.charAt(2))));
                line = Strings.skip(line, 1);
            } else if (second == Roll.SPARE) {
                frames.add(new Spare(first, Roll.of(line.charAt(2))));
                line = Strings.skip(line, 2);
            } else {
                frames.add(new Simple(first, second));
                line = Strings.skip(line, 2);
            }

            remainingFrames--;
        }

        return new Game(frames);
    }

}
