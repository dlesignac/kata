package fr.kata.bankocr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DigitsReader {

    private static List<String> readLines(Path path) {
        try {
            return Files.lines(path).limit(3).collect(Collectors.toList());
        } catch (NoSuchFileException e) {
            throw new IllegalArgumentException("No such file : " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Unexpected behavior");
        }
    }

    private static List<String> readDigitsAsString(List<String> digitsAsLines, int numberOfDigits) {
        try {
            return IntStream.range(0, numberOfDigits)
                    .mapToObj(i -> {
                        int start = 3 * i;
                        int end = start + 3;
                        return digitsAsLines.get(0).substring(start, end) +
                                digitsAsLines.get(1).substring(start, end) +
                                digitsAsLines.get(2).substring(start, end);
                    })
                    .collect(Collectors.toList());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid input file content");
        }
    }

    static List<Digit> readDigits(Path path, int numberOfDigits) {
        List<String> lines = readLines(path);
        List<String> digitsAsString = readDigitsAsString(lines, numberOfDigits);
        return digitsAsString.stream()
                .map(Digit::new)
                .collect(Collectors.toList());
    }
}