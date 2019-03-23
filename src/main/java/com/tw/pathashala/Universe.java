package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;

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
        for (Cell seed : seeds) {
            xCoordinate = seed.getXCoordinate();
            yCoordinate = seed.getYCoordinate();
            Cell cell = grid.get(xCoordinate).get(yCoordinate);
            cell.setStatus(1);
        }
    }

    void nextGeneration(List<List<Cell>> grid) {
        markCellsGoingToBorn(grid);
        markCellsGoingToDie(grid);
        populateAndUnpopulate(grid);
    }

    private void populateAndUnpopulate(List<List<Cell>> grid) {
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getIsGoingToDie()) {
                    cell.setStatus(0);
                }
                if (cell.getIsGoingToBorn()) {
                    cell.setStatus(1);
                }
            }
        }
    }

    private void markCellsGoingToBorn(List<List<Cell>> grid) {
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == 0) {
                    cell.isGoingToBorn(grid);
                }
            }
        }
    }

    private void markCellsGoingToDie(List<List<Cell>> grid) {
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == 1) {
                    cell.isGoingToDie(grid);
                }
            }
        }
    }
}