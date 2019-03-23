package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Cell {
    static final int Dead = 0;
    static final int Alive = 1;

    private Integer status;
    private Integer xCoordinate;
    private Integer yCoordinate;
    private Boolean isGoingToDie;
    private Boolean isGoingToBorn;
    private List<Cell> activeNeighbours;

    Cell(Integer xCoordinate, Integer yCoordinate, Integer status) {
        this.status = status;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isGoingToDie = false;
        this.isGoingToBorn = false;
        this.activeNeighbours = new LinkedList<>();
    }

    void isGoingToBorn(List<List<Cell>> grid) {
        Cell cell = this;
        cell.findActiveNeighbours(grid);
        int activeNeighbours = cell.getActiveNeighbours().size();
        if (activeNeighbours == 3) {
            cell.setIsGoingToBorn(true);
        }
    }

    void isGoingToDie(List<List<Cell>> grid) {
        Cell cell = this;
        cell.findActiveNeighbours(grid);
        int activeNeighbours = cell.getActiveNeighbours().size();
        if (activeNeighbours > 3 || activeNeighbours < 2) {
            cell.setIsGoingToDie(true);
        }
    }

    Integer getStatus() {
        return status;
    }

    void setStatus(Integer status) {
        this.status = status;
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

    private void setIsGoingToDie(Boolean goingToDie) {
        isGoingToDie = goingToDie;
    }

    private void setIsGoingToBorn(Boolean goingToBorn) {
        isGoingToBorn = goingToBorn;
    }

    private List<Cell> getActiveNeighbours() {
        return activeNeighbours;
    }

    private void findActiveNeighbours(List<List<Cell>> grid) {
        //TODO : Refactor and remove multiple indentation
        int x = this.getXCoordinate();
        int y = this.getYCoordinate();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < grid.size()) {
                    if (j >= 0 && j < grid.get(i).size()) {
                        if (i != x || j != y) {
                            if (grid.get(i).get(j).getStatus() == Alive) {
                                activeNeighbours.add(grid.get(i).get(j));
                            }
                        }
                    }
                }
            }
        }
    }
}