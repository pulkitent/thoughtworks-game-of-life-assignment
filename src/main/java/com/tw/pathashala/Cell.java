package com.tw.pathashala;

class Cell {
    Integer status;
    Boolean isGoingToBeBorn;
    Boolean isGoingToDie;

    Cell(Integer status) {
        this.status = status;
        this.isGoingToBeBorn = false;
        this.isGoingToDie = false;
    }

}