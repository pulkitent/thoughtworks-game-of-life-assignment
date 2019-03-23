package com.tw.pathashala;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniverseTest {

    private void createFourExpectedCellAlive(List<Cell> expectedCellsAlive) {
        expectedCellsAlive.add(new Cell(1, 1, 1));
        expectedCellsAlive.add(new Cell(1, 2, 1));
        expectedCellsAlive.add(new Cell(2, 1, 1));
        expectedCellsAlive.add(new Cell(2, 2, 1));
    }

    private void createGridAndFourInputSeeds(List<List<Cell>> grid, List<Cell> seeds) {
        seeds.add(new Cell(1, 1, 1));
        seeds.add(new Cell(1, 2, 1));
        seeds.add(new Cell(2, 1, 1));
        seeds.add(new Cell(2, 2, 1));

        for (int i = 0; i <= 3; i++) {
            grid.add(new LinkedList<>());
            for (int j = 0; j <= 3; j++) {
                grid.get(i).add(new Cell(i, j, 0));
            }
        }
    }


    @Test
    @DisplayName("Find generation when four seeds are provided with coordinates {1,1} {1,2} {2,1} {2,2}")
    void shouldFindNextGenerationWhenFourSeedsAreProvided() {
        Universe universe = new Universe();
        List<List<Cell>> grid = universe.getGrid();
        List<Cell> seeds = universe.getSeeds();
        List<Cell> expectedCellsAlive = new LinkedList<>();
        createGridAndFourInputSeeds(grid, seeds);
        createFourExpectedCellAlive(expectedCellsAlive);
        universe.provideSeed(grid, seeds);
        int k = 0;

        universe.nextGeneration(grid);

        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == 1) {
                    assertEquals(cell, expectedCellsAlive.get(k++));
                }
            }
        }

    }

    private void createFiveExpectedCellAlive(List<Cell> expectedCellsAlive) {
        expectedCellsAlive.add(new Cell(0, 1, 1));
        expectedCellsAlive.add(new Cell(0, 2, 1));
        expectedCellsAlive.add(new Cell(1, 0, 1));
        expectedCellsAlive.add(new Cell(1, 2, 1));
        expectedCellsAlive.add(new Cell(2, 1, 1));
    }

    private void createGridAndFiveInputSeeds(List<List<Cell>> grid, List<Cell> seeds) {
        seeds.add(new Cell(0, 1, 1));
        seeds.add(new Cell(0, 2, 1));
        seeds.add(new Cell(1, 0, 1));
        seeds.add(new Cell(1, 2, 1));
        seeds.add(new Cell(2, 1, 1));

        for (int i = 0; i <= 3; i++) {
            grid.add(new LinkedList<>());
            for (int j = 0; j <= 3; j++) {
                grid.get(i).add(new Cell(i, j, 0));
            }
        }
    }

    @Test
    @DisplayName("Find generation when five seeds are provided with coordinates {0,1} {0,2} {1,0} {1,2} {2,1}")
    void shouldFindNextGenerationWhenFiveSeedsAreProvided() {
        Universe universe = new Universe();
        List<List<Cell>> grid = universe.getGrid();
        List<Cell> seeds = universe.getSeeds();
        List<Cell> expectedCellsAlive = new LinkedList<>();
        createGridAndFiveInputSeeds(grid, seeds);
        createFiveExpectedCellAlive(expectedCellsAlive);
        universe.provideSeed(grid, seeds);
        int k = 0;

        universe.nextGeneration(grid);

        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == 1) {
                    assertEquals(cell, expectedCellsAlive.get(k++));
                }
            }
        }
    }

    private void createThreeExpectedCellAlive(List<Cell> expectedCellsAlive) {
        expectedCellsAlive.add(new Cell(1, 0, 1));
        expectedCellsAlive.add(new Cell(1, 1, 1));
        expectedCellsAlive.add(new Cell(1, 2, 1));
    }

    private void createGridAndThreeInputSeeds(List<List<Cell>> grid, List<Cell> seeds) {
        seeds.add(new Cell(0, 1, 1));
        seeds.add(new Cell(1, 1, 1));
        seeds.add(new Cell(2, 1, 1));

        for (int i = 0; i <= 3; i++) {
            grid.add(new LinkedList<>());
            for (int j = 0; j <= 3; j++) {
                grid.get(i).add(new Cell(i, j, 0));
            }
        }
    }

    @Test
    @DisplayName("Find generation when five seeds are provided with coordinates {1,0} {1,1} {1,2}")
    void shouldFindNextGenerationWhenThreeSeedsAreProvided() {
        Universe universe = new Universe();
        List<List<Cell>> grid = universe.getGrid();
        List<Cell> seeds = universe.getSeeds();
        List<Cell> expectedCellsAlive = new LinkedList<>();
        createGridAndThreeInputSeeds(grid, seeds);
        createThreeExpectedCellAlive(expectedCellsAlive);
        universe.provideSeed(grid, seeds);
        int k = 0;

        universe.nextGeneration(grid);

        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == 1) {
                    assertEquals(cell, expectedCellsAlive.get(k++));
                }
            }
        }
    }
}