package fr.kata.gameoflife;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FileReaderTest {


    @Test
    public void readLines_success() {
        List<String> lines = FileReader.readLines(Paths.get("/home/lez/projects/kata/gameoflife/src/test/resources/simpleGrid_4x8"));
        assertEquals(lines.get(0), "4 8");
        assertEquals(lines.get(1), "........");
        assertEquals(lines.get(2), "....*...");
        assertEquals(lines.get(3), "...**...");
        assertEquals(lines.get(4), "........");
    }


}
