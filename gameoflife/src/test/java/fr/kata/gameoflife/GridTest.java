package fr.kata.gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void toString_should_return_valid_representation() {
        Grid grid = new Grid("/home/lez/projects/kata/gameoflife/src/test/resources/simpleGrid_4x8");
        String representation = "Generation 1:\n" +
                "4 8\n" +
                "........\n" +
                "....*...\n" +
                "...**...\n" +
                "........";

        assertEquals(representation, grid.toString());
    }

    @Test
    public void next_generation_should_return_valid_representation() {
        Grid grid = new Grid("/home/lez/projects/kata/gameoflife/src/test/resources/simpleGrid_4x8");
        String representation = "Generation 2:\n" +
                "4 8\n" +
                "........\n" +
                "...**...\n" +
                "...**...\n" +
                "........";

        assertEquals(representation, grid.nextGeneration());
    }

}
