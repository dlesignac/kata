package fr.kata.gameoflife;

public class Cell {

    private static final char ALIVE_REPRESENTATION = '*';

    private boolean alive;
    private char representation;

    public Cell(char c) {
        this.alive = c == ALIVE_REPRESENTATION;
        this.representation = c;
    }

    @Override
    public String toString() {
        return String.valueOf(this.representation);
    }
}
