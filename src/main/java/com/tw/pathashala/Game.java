package com.tw.pathashala;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


//Represents an activity that one engages in for fun
class Game {
    private Scanner console;
    private Universe universe;

    private Game() {
        console = new Scanner(System.in);
        universe = new Universe();
    }

    public static void main(String s[]) {
        Game game = new Game();
        game.play();
    }

    private void play() {
        List<List<Cell>> grid = universe.getGrid();
        List<Cell> seeds = universe.getSeeds();

        int grideSize = getSeedsFromUser(seeds);
        createGrid(grideSize, grid);

        universe.provideSeed(grid, seeds);
        universe.nextGeneration(grid);
        display(grid);
        displayActiveCoordinates(grid);
    }

    private Integer getSeedsFromUser(List<Cell> seeds) {
        Cell cell;
        int xCoordinate, yCoordinate;
        int maxRow = -1, maxCol = -1;
        int counter = 0;
        System.out.println("Enter the size of seeds population");
        int size = console.nextInt();
        while (counter < size) {
            System.out.println("Enter the coordinates of seeds population");
            xCoordinate = console.nextInt();
            yCoordinate = console.nextInt();
            maxRow = Integer.max(maxRow, xCoordinate);
            maxCol = Integer.max(maxCol, yCoordinate);
            cell = new Cell(xCoordinate, yCoordinate, 1);
            seeds.add(cell);
            counter++;
        }
        return Integer.max(maxCol, maxRow);
    }

    private void createGrid(Integer grideSize, List<List<Cell>> grid) {
        for (int i = 0; i <= grideSize + 1; i++) {
            grid.add(new LinkedList<>());
            for (int j = 0; j <= grideSize + 1; j++) {
                grid.get(i).add(new Cell(i, j, 0));
            }
        }
    }

    private void display(List<List<Cell>> grid) {
        System.out.println("=============================================");
        System.out.println("System State :");
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                System.out.print(cell.getStatus() + " ");
            }
            System.out.println("");
        }
    }

    private void displayActiveCoordinates(List<List<Cell>> grid) {
        System.out.println("=============================================");
        System.out.println("Active Coordinates :");
        for (List<Cell> cells : grid) {
            for (Cell cell : cells) {
                if (cell.getStatus() == 1)
                    System.out.println(cell.getXCoordinate() + "," + cell.getYCoordinate());
            }
        }
    }
}