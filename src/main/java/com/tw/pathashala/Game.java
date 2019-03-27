package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;

class Game {
    public static void main(String s[]) {
        List<Cell> seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 2));
        seeds.add(new Cell(1, 3));
        seeds.add(new Cell(2, 2));
        seeds.add(new Cell(2, 3));
        seeds.add(new Cell(2, 4));
        Universe universe = new Universe(seeds);
        List<Cell> nextgeneration = universe.nextGeneration();
        nextgeneration.forEach(System.out::println);
        System.out.println("======================================");
        seeds = new LinkedList<>();
        seeds.add(new Cell(0, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(2, 1));
        seeds.add(new Cell(2, 2));
        universe = new Universe(seeds);
        nextgeneration = universe.nextGeneration();
        nextgeneration.forEach(System.out::println);
        System.out.println("======================================");
        seeds = new LinkedList<>();
        seeds.add(new Cell(0, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(2, 1));
        seeds.add(new Cell(0, 2));
        seeds.add(new Cell(1, 2));
        universe = new Universe(seeds);
        nextgeneration = universe.nextGeneration();
        nextgeneration.forEach(System.out::println);
        System.out.println("======================================");
        seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(1, 2));
        universe = new Universe(seeds);
        nextgeneration = universe.nextGeneration();
        nextgeneration.forEach(System.out::println);
    }
}
