package fr.kata.bowling;

public enum Roll {

    STRIKE('X', 10),
    SPARE('/', 10),
    NINE('9', 9),
    EIGHT('8', 8),
    SEVEN('7', 7),
    SIX('6', 6),
    FIVE('5', 5),
    FOUR('4', 4),
    THREE('3', 3),
    TWO('2', 2),
    ONE('1', 1),
    MISS('-', 0);

    private char output;
    private int points;

    Roll(char output, int points) {
        this.output = output;
        this.points = points;
    }

    public char getOutput() {
        return output;
    }

    public int getPoints() {
        return points;
    }

    public static Roll of(char c) {
        for (Roll roll : values()) {
            if (roll.output == c) {
                return roll;
            }
        }

        throw new IllegalArgumentException();
    }

}
