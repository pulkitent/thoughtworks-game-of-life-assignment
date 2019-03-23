package com.tw.pathashala;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniverseTest {

    private void createGridAndInputSeeds(List<List<Cell>> grid, List<Cell> seeds) {
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

    private void createExpectedCellAlive(List<Cell> expectedCellsAlive) {
        expectedCellsAlive.add(new Cell(1, 1, 1));
        expectedCellsAlive.add(new Cell(1, 2, 1));
        expectedCellsAlive.add(new Cell(2, 1, 1));
        expectedCellsAlive.add(new Cell(2, 2, 1));
    }


    @Test
    @DisplayName("Find generation when seed is provided to universe with coordinates {1,1} {1,2} {2,1} {2,2}")
    void shouldFindNextGenerationWhenSeedIsProvided() {
        Universe universe = new Universe();
        List<List<Cell>> grid = universe.getGrid();
        List<Cell> seeds = universe.getSeeds();
        List<Cell> expectedCellsAlive = new LinkedList<>();
        createGridAndInputSeeds(grid, seeds);
        createExpectedCellAlive(expectedCellsAlive);
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