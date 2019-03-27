package com.tw.pathashala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class UniverseTest {
    @Test
    @DisplayName("Expects to find alive Cells that are going to die in the next generation")
    void expectsToFindCellsDyingInNextGeneration() {
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
        Universe universe = new Universe(seeds);

        List<Cell> nextGeneration = universe.nextGeneration();

        Assertions.assertEquals(expectedAliveCells, nextGeneration);
    }
}
