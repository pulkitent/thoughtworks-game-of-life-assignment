package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Cell {
    private final int xCoordinate;
    private final int yCoordinate;

    Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    private void findColumnNeighbours(int row, List<Cell> neighbours) {
        int y = this.yCoordinate;
        int x = this.xCoordinate;
        for (int column = y - 1; column <= y + 1; column++) {
            if (row != x || column != y) {
                neighbours.add(new Cell(row, column));
            }
        }
    }

    List<Cell> neighbours() {
        int x = this.xCoordinate;
        List<Cell> neighbours = new LinkedList<>();
        for (int row = x - 1; row <= x + 1; row++) {
            this.findColumnNeighbours(row, neighbours);
        }
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate &&
                yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}