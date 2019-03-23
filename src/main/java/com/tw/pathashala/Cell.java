package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

//Represents a space in the universe
class Cell {
    static final int Dead = 0;
    static final int Alive = 1;

    private Integer status;
    private Boolean isGoingToDie;
    private Boolean isGoingToBorn;
    private final Integer xCoordinate;
    private final Integer yCoordinate;
    private List<Cell> activeNeighbours;

    Cell(Integer xCoordinate, Integer yCoordinate, Integer status) {
        this.status = status;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isGoingToDie = false;
        this.isGoingToBorn = false;
        this.activeNeighbours = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return status.equals(cell.status) &&
                xCoordinate.equals(cell.xCoordinate) &&
                yCoordinate.equals(cell.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, xCoordinate, yCoordinate);
    }

    void checkIfGoingToDieOrBorn(List<List<Cell>> grid, Boolean isActive) {
        Cell cell = this;
        cell.findActiveNeighbours(grid);
        int activeNeighbours = cell.getActiveNeighbours().size();

        if (isActive) {
            if (activeNeighbours > 3 || activeNeighbours < 2) {
                cell.setIsGoingToDie(true);
            }
        }

        if (!isActive) {
            if (activeNeighbours == 3) {
                cell.setIsGoingToBorn(true);
            }
        }
    }

    void setStatus(Integer status) {
        this.status = status;
    }

    Integer getStatus() {
        return status;
    }

    Integer getXCoordinate() {
        return xCoordinate;
    }

    Integer getYCoordinate() {
        return yCoordinate;
    }

    Boolean getIsGoingToDie() {
        return isGoingToDie;
    }

    Boolean getIsGoingToBorn() {
        return isGoingToBorn;
    }

    private void setIsGoingToDie(Boolean goingToDie) {
        isGoingToDie = goingToDie;
    }

    private void setIsGoingToBorn(Boolean goingToBorn) {
        isGoingToBorn = goingToBorn;
    }

    private List<Cell> getActiveNeighbours() {
        return activeNeighbours;
    }

    private Boolean validateRangeOfNeighbours(int i, int j, List<List<Cell>> grid) {
        Integer x = this.getXCoordinate();
        Integer y = this.getYCoordinate();
        if (i < 0 || i >= grid.size()) {
            return false;
        }
        if (j < 0 || j >= grid.get(i).size()) {
            return false;
        }
        return i != x || j != y;
    }

    private void findActiveNeighbours(List<List<Cell>> grid) {
        //TODO : Refactor and remove multiple indentation
        Integer x = this.getXCoordinate();
        Integer y = this.getYCoordinate();
        Cell cell;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (validateRangeOfNeighbours(i, j, grid)) {
                    cell = grid.get(i).get(j);
                    if (cell.getStatus() == Alive) {
                        activeNeighbours.add(cell);
                    }
                }
            }
        }
    }
}