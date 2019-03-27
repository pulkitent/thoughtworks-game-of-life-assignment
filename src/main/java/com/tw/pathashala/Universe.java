package com.tw.pathashala;

import java.util.*;

import static java.util.stream.Collectors.toList;

class Universe {
    private final List<Cell> seeds;

    Universe(List<Cell> seeds) {
        this.seeds = seeds;
    }

    List<Cell> nextGeneration() {
        List<Cell> aliveCells = new LinkedList<>(seeds);
        for (Cell seed : seeds) {
            this.unPopulate(aliveCells, seed);
        }

        return aliveCells;
    }

    private void unPopulate(List<Cell> aliveCells, Cell seed) {
        int activeNeighbours = 0;
        List<Cell> neighbours = seed.neighbours();
        activeNeighbours = neighbours.stream()
                .filter(seeds::contains)
                .collect(toList())
                .size();
        if (activeNeighbours < 2 || activeNeighbours > 3) {
            aliveCells.remove(seed);
        }
    }
}
