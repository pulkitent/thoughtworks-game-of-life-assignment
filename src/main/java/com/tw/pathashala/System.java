package com.tw.pathashala;

import java.util.Scanner;

class Almighty {
    /*
Input A

//working

2
2

4

1
1
1
2
2
1
2
2

Input B

//working

2
2

5

0
1
1
0
2
1
0
2
1
2

Input C

//working

2
2

3


1
1
1
0
1
2

Input D

4
4

6

1
1
1
2
1
3
2
2
2
3
2
4

*/
    public static void main(String s[]) {
        System.out.println("Enter the size of the grid");
        Scanner console = new Scanner(System.in);
        int m = console.nextInt();
        int n = console.nextInt();
        Cell[][] grid = new Cell[m + 1][n + 1];
        System.out.println("Enter the size of seed population");
        int size = console.nextInt();
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                grid[i][j] = new Cell(0);
            }
        }

        System.out.println("Enter the coordinates of cell which is alive");
        int k = 0;
        while (k < size) {
            int o = console.nextInt();
            int p = console.nextInt();
            grid[o][p].status = 1;
            k++;
        }

        findCellsGoingToBeBorn(grid);
        findCellsGoingToDie(grid);
        LetTheBirthAndDeathBegin(grid);
        ShowNewPopulation(grid);
        ShowAlivePopulationCoordinateWise(grid);

    }

    private static void ShowAlivePopulationCoordinateWise(Cell[][] grid) {
        int i = 0;
        for (Cell[] cells : grid) {
            int j = 0;
            for (Cell cell : cells) {
                if (cell.status == 1) {
                    System.out.println(i + " " + j);
                }
                j++;
            }
            i++;
        }
    }

    private static void ShowNewPopulation(Cell[][] grid) {
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                System.out.print(" " + cell.status);
            }
            System.out.println("");
        }
    }


    private static void LetTheBirthAndDeathBegin(Cell[][] grid) {
        int m = grid.length;
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                if (cell.isGoingToDie) {
                    cell.status = 0;
                }
                if (cell.isGoingToBeBorn) {
                    cell.status = 1;
                }
            }
        }
    }

    private static void findCellsGoingToDie(Cell[][] grid) {
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].status == 1) {
                    isThisCellGoingGie(grid, i, j);
                }
            }
        }
    }

    private static void isThisCellGoingGie(Cell[][] grid, int i, int j) {
        int m = grid.length;
        int n;
        int count = 0;


        if (i - 1 >= 0 && i - 1 < m) {
            n = grid[i - 1].length;
            if (j - 1 >= 0 && j - 1 < n) {
                if (grid[i - 1][j - 1].status == 1) {
                    count++;
                }
            }
            if (j >= 0 && j < n) {
                if (grid[i - 1][j].status == 1) {
                    count++;
                }
            }
            if (j + 1 >= 0 && j + 1 < n) {
                if (grid[i - 1][j + 1].status == 1) {
                    count++;
                }
            }

        }

        if (i >= 0 && i < m) {
            n = grid[i].length;
            if (j - 1 >= 0 && j - 1 < n) {
                if (grid[i][j - 1].status == 1) {
                    count++;
                }
            }
            if (j + 1 >= 0 && j + 1 < n) {
                if (grid[i][j + 1].status == 1) {
                    count++;
                }
            }
        }

        if (i + 1 >= 0 && i + 1 < m) {
            n = grid[i + 1].length;
            if (j - 1 >= 0 && j - 1 < n) {
                if (grid[i + 1][j - 1].status == 1) {
                    count++;
                }
            }
            if (j >= 0 && j < n) {
                if (grid[i + 1][j].status == 1) {
                    count++;
                }
            }
            if (j + 1 >= 0 && j + 1 < n) {
                if (grid[i + 1][j + 1].status == 1) {
                    count++;
                }
            }
        }

        if (count > 3 || count < 2) {
            grid[i][j].isGoingToDie = true;
        }

    }

    private static void findCellsGoingToBeBorn(Cell[][] grid) {
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].status == 0) {
                    isThisCellGoingToBeBorn(grid, i, j);
                }
            }
        }

    }

    private static void isThisCellGoingToBeBorn(Cell[][] grid, int i, int j) {
        int m = grid.length;
        int n;
        int count = 0;


        if (i - 1 >= 0 && i - 1 < m) {
            n = grid[i - 1].length;
            if (j - 1 >= 0 && j - 1 < n) {
                if (grid[i - 1][j - 1].status == 1) {
                    count++;
                }
            }
            if (j > 0 && j < n) {
                if (grid[i - 1][j].status == 1) {
                    count++;
                }
            }
            if (j + 1 >= 0 && j + 1 < n) {
                if (grid[i - 1][j + 1].status == 1) {
                    count++;
                }
            }

        }

        if (i >= 0 && i < m) {
            n = grid[i].length;
            if (j - 1 >= 0 && j - 1 < n) {
                if (grid[i][j - 1].status == 1) {
                    count++;
                }
            }
            if (j + 1 >= 0 && j + 1 < n) {
                if (grid[i][j + 1].status == 1) {
                    count++;
                }
            }
        }

        if (i + 1 >= 0 && i + 1 < m) {
            n = grid[i + 1].length;
            if (j - 1 >= 0 && j - 1 < n) {
                if (grid[i + 1][j - 1].status == 1) {
                    count++;
                }
            }
            if (j >= 0 && j < n) {
                if (grid[i + 1][j].status == 1) {
                    count++;
                }
            }
            if (j + 1 >= 0 && j + 1 < n) {
                if (grid[i + 1][j + 1].status == 1) {
                    count++;
                }
            }
        }

        if (count == 3) {
            grid[i][j].isGoingToBeBorn = true;
        }
    }
}
