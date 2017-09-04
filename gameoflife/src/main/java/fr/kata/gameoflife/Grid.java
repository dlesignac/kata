package fr.kata.gameoflife;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Grid {

    private static final int DIMENSIONS_LINE = 0;
    private static final String DIMENSIONS_SEPARATOR = " ";
    private static final int NUMBER_OF_LINES_INDEX = 0;
    private static final int NUMBER_OF_COLUMNS_INDEX = 1;

    private int generation;
    private Cell[][] cells;
    private int numberOfLines;
    private int numberOfColumns;

    public Grid(String path) {
        List<String> lines = FileReader.readLines(Paths.get(path));
        constructDimensionsFromLines(lines);
        constructCellsFromLines(getGridLines(lines));
        generation = 1;
    }

    private void constructDimensionsFromLines(List<String> lines) {
        String lineWithDimensions = getLineWithDimensions(lines);
        numberOfLines = getNumberOfLines(lineWithDimensions);
        numberOfColumns = getNumberOfColumns(lineWithDimensions);
    }

    private void constructCellsFromLines(List<String> gridLines) {
        cells = new Cell[numberOfColumns][numberOfLines];
        for (int y = 0; y < numberOfLines; y++) {
            for (int x = 0; x < numberOfColumns; x++) {
                cells[x][y] = new Cell(gridLines.get(y).charAt(x));
            }
        }
    }

    private String getLineWithDimensions(List<String> lines) {
        return lines.get(DIMENSIONS_LINE);
    }

    private int getNumberOfLines(String line) {
        return Integer.parseInt(line.split(DIMENSIONS_SEPARATOR)[NUMBER_OF_LINES_INDEX]);
    }

    private int getNumberOfColumns(String line) {
        return Integer.parseInt(line.split(DIMENSIONS_SEPARATOR)[NUMBER_OF_COLUMNS_INDEX]);
    }

    private List<String> getGridLines(List<String> lines) {
        List<String> gridLines = new ArrayList<>(lines);
        gridLines.remove(0);
        return gridLines;
    }

    @Override
    public String toString() {
        return generationRepresentation() + sizeRepresentation() + gridRepresentation();
    }

    private String generationRepresentation() {
        return String.format("Generation %d:\n", this.generation);
    }

    private String sizeRepresentation() {
        return String.format("%d %d\n", numberOfLines, numberOfColumns);
    }

    private String gridRepresentation() {
        StringBuilder gridRepresentation = new StringBuilder();

        for (int y = 0; y < numberOfLines; y++) {
            for (int x = 0; x < numberOfColumns; x++) {
                gridRepresentation.append(cells[x][y]);
            }

            gridRepresentation.append("\n");
        }

        return removeUselessBreakline(gridRepresentation);
    }

    private String removeUselessBreakline(StringBuilder grid) {
        return grid.deleteCharAt(grid.length() - 1).toString();
    }

    public String nextGeneration() {
        for(int x=0 ; x < numberOfColumns ; x++)
            for (int y = 0 ; y < numberOfLines ; y++){
            Cell = new Cell(cells[x][y]);
            //if()
            }
        return null;
    }
}
