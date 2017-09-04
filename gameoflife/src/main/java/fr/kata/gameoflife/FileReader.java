package fr.kata.gameoflife;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

class FileReader {

    static List<String> readLines(Path path) {
        try {
            return Files.lines(path).collect(Collectors.toList());
        } catch (NoSuchFileException e) {
            throw new IllegalArgumentException("No such file : " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Unexpected behavior");
        }
    }
}
