package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;

import static com.tw.pathashala.Cell.Alive;
import static com.tw.pathashala.Cell.Dead;

class Universe {
    private List<List<Cell>> grid;
    private List<Cell> seed;

    Universe() {
        grid = new LinkedList<>();
        seed = new LinkedList();
    }

    List<List<Cell>> getGrid() {
        return this.grid;
    }

    List<Cell> getSeeds() {
        return this.seed;
    }

    void provideSeed(List<List<Cell>> grid, List<Cell> seeds) {
        int xCoordinate, yCoordinate;
        Cell cell;
        for (Cell seed : seeds) {
            xCoordinate = seed.getXCoordinate();
            yCoordinate = seed.getYCoordinate();
            cell = grid.get(xCoordinate).get(yCoordinate);
            cell.setStatus(Alive);
        }
    }

    void nextGeneration(List<List<Cell>> grid) {
        this.markCellsGoingToBornAndDie(grid);
        this.populateAndUnpopulate(grid);
    }

    private void markCellsGoingToBornAndDie(List<List<Cell>> grid) {
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == Dead) {
                    cell.checkIfGoingToDieOrBorn(grid, false);
                } else if (cell.getStatus() == Alive) {
                    cell.checkIfGoingToDieOrBorn(grid, true);
                }
            }
        }
    }

    private void populateAndUnpopulate(List<List<Cell>> grid) {
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getIsGoingToDie()) {
                    cell.setStatus(Dead);
                } else if (cell.getIsGoingToBorn()) {
                    cell.setStatus(Alive);
                }
            }
        }
    }
}