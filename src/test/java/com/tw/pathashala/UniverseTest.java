package com.tw.pathashala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class UniverseTest {
    @Test
    @DisplayName("Expects to find alive Cells that are going to die in the next generation")
    void expectsToFindNextGeneration() {
        List<Cell> seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 2));
        seeds.add(new Cell(1, 3));
        seeds.add(new Cell(2, 2));
        seeds.add(new Cell(2, 3));
        seeds.add(new Cell(2, 4));
        List<Cell> expectedAliveCells = new LinkedList<>();
        expectedAliveCells.add(new Cell(1, 1));
        expectedAliveCells.add(new Cell(2, 4));
        expectedAliveCells.add(new Cell(0, 2));
        expectedAliveCells.add(new Cell(2, 1));
        expectedAliveCells.add(new Cell(1, 4));
        expectedAliveCells.add(new Cell(3, 3));
        Universe universe = new Universe(seeds);

        List<Cell> nextGeneration = universe.nextGeneration();

        Assertions.assertEquals(expectedAliveCells, nextGeneration);
    }

    @Test
    @DisplayName("Expects to find alive Cells that are going to die in the next generation")
    void expectsNotToFindCellsDyingInNextGeneration() {
        List<Cell> seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 2));
        seeds.add(new Cell(1, 3));
        List<Cell> expectedAliveCells = new LinkedList<>();
        expectedAliveCells.add(new Cell(1, 1));
        expectedAliveCells.add(new Cell(2, 4));
        expectedAliveCells.add(new Cell(2, 3));
        Universe universe = new Universe(seeds);

        List<Cell> nextGeneration = universe.nextGeneration();

        Assertions.assertNotEquals(expectedAliveCells, nextGeneration);
    }

    @Test
    @DisplayName("Expects to find alive Cells that are going to die in the next generation")
    void expectstToFindNextGenerationBlockPattern() {
        List<Cell> seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 2));
        seeds.add(new Cell(2, 1));
        seeds.add(new Cell(2, 2));
        List<Cell> expectedAliveCells = new LinkedList<>();
        expectedAliveCells.add(new Cell(1, 1));
        expectedAliveCells.add(new Cell(1, 2));
        expectedAliveCells.add(new Cell(2, 1));
        expectedAliveCells.add(new Cell(2, 2));
        Universe universe = new Universe(seeds);

        List<Cell> nextGeneration = universe.nextGeneration();

        Assertions.assertEquals(expectedAliveCells, nextGeneration);
    }

    @Test
    @DisplayName("Expects to find alive Cells that are going to die in the next generation")
    void expectstToFindNextGenerationBoatPattern() {
        List<Cell> seeds = new LinkedList<>();
        seeds.add(new Cell(0, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(2, 1));
        seeds.add(new Cell(0, 2));
        seeds.add(new Cell(1, 2));
        List<Cell> expectedAliveCells = new LinkedList<>();
        expectedAliveCells.add(new Cell(0, 1));
        expectedAliveCells.add(new Cell(1, 0));
        expectedAliveCells.add(new Cell(2, 1));
        expectedAliveCells.add(new Cell(0, 2));
        expectedAliveCells.add(new Cell(1, 2));
        Universe universe = new Universe(seeds);

        List<Cell> nextGeneration = universe.nextGeneration();

        Assertions.assertEquals(expectedAliveCells, nextGeneration);
    }
}
