package com.tw.pathashala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class CellTest {
    @Test
    @DisplayName("Should find all neighbours of a cell with coordinate 1,1")
    void expectsNeighbours() {
        Cell cell = new Cell(1, 1);
        List<Cell> expectedNeighbours = new LinkedList<>();
        expectedNeighbours.add(new Cell(0, 0));
        expectedNeighbours.add(new Cell(0, 1));
        expectedNeighbours.add(new Cell(0, 2));
        expectedNeighbours.add(new Cell(1, 0));
        expectedNeighbours.add(new Cell(1, 2));
        expectedNeighbours.add(new Cell(2, 0));
        expectedNeighbours.add(new Cell(2, 1));
        expectedNeighbours.add(new Cell(2, 2));

        List<Cell> neighbours = cell.neighbours();

        Assertions.assertEquals(expectedNeighbours, neighbours);
    }

    @Test
    @DisplayName("Should compare two Cells with same coordinates")
    void expectsTwoCellsEqualWithSameCoordinates() {
        Cell cell = new Cell(1, 1);
        Cell anotherCell = new Cell(1, 1);

        Assertions.assertTrue(cell.equals(anotherCell));
    }

    @Test
    @DisplayName("Should compare two Cells with same coordinates")
    void expectsTwoCellsNotEqualWithDifferentCoordinates() {
        Cell cell = new Cell(1, 1);
        Cell anotherCell = new Cell(1, 2);

        Assertions.assertFalse(cell.equals(anotherCell));
    }
}
