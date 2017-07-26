package fr.kata.diamond;

public class Diamond {

    private static final int BASE_ASCII_VALUE = (int) 'A';

    private int widest;

    public Diamond(char widest) {
        if (widest < 'A' || widest > 'Z') {
            throw new IllegalArgumentException("illegal widest letter : " + widest);
        }

        this.widest = widest - BASE_ASCII_VALUE;
    }

    private String peek() {
        return blank(widest) + "A\n";
    }

    private String top() {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= widest; i++) {
            result.append(line(i));
        }

        return result.toString();
    }

    private String bottom() {
        StringBuilder result = new StringBuilder();

        for (int i = widest - 1; i >= 1; i--) {
            result.append(line(i));
        }

        return result.toString();
    }

    private String line(int currentValue) {
        char currentChar = currentChar(currentValue);

        String line = "";
        line += blank(widest - currentValue);
        line += currentChar;
        line += blank(2 * (currentValue - 1) + 1);
        line += currentChar;
        line += "\n";

        return line;
    }

    private char currentChar(int currentValue) {
        return (char) (BASE_ASCII_VALUE + currentValue);
    }

    private String blank(int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(" ");
        }

        return result.toString();
    }

    @Override
    public String toString() {
        if (widest == 0) {
            return "A\n";
        }

        return peek() + top() + bottom() + peek();
    }

}
