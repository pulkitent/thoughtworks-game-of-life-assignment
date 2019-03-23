package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;

class Cell {
    private Integer status;
    private Integer xCoordinate;
    private Integer yCoordinate;
    private Boolean isGoingToDie;
    private Boolean isGoingToBorn;
    private List<Cell> activeNeighbours;

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

    private void setIsGoingToDie(Boolean goingToDie) {
        isGoingToDie = goingToDie;
    }

    Boolean getIsGoingToBorn() {
        return isGoingToBorn;
    }

    private void setIsGoingToBorn(Boolean goingToBorn) {
        isGoingToBorn = goingToBorn;
    }

    private List<Cell> getActiveNeighbours() {
        return activeNeighbours;
    }

    Cell(Integer xCoordinate, Integer yCoordinate, Integer status) {
        this.status = status;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.isGoingToDie = false;
        this.isGoingToBorn = false;
        this.activeNeighbours = new LinkedList<>();
    }

    private void findActiveNeighbours(List<List<Cell>> grid) {
        int x = this.getXCoordinate();
        int y = this.getYCoordinate();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < grid.size()) {
                    if (j >= 0 && j < grid.get(i).size()) {
                        if (i != x || j != y) {
                            if (grid.get(i).get(j).getStatus() == 1) {
                                activeNeighbours.add(grid.get(i).get(j));
                            }
                        }
                    }
                }
            }
        }
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
}