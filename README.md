**Game of Life**

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in oneof two possible states,live 
or dead.
Every cell interacts with its eight neighbours, which are thecells that aredirectly horizontally, vertically, or diagonally adjacent.

At each step in time, the followingtransitions occur:   

1.Any live cell with fewer than two live neighbours dies, as if by loneliness.
2.Any live cell with more than three live neighbours dies, as if by overcrowding.
3.Any live cell with two or three live neighbours lives, unchanged, to the next generation.
4.Any dead cell with exactly three live neighbours comes to life.

The initial pattern constitutes the 'seed' of the system. The first generation is created by applyingthe above rulessimultaneously to every cell in the seed 
births and deaths happen simultaneously, and thediscrete moment at whichthis happens is sometimes called a tick.

(In other words, each generation is a pure function ofthe one before.) The rules continue to be applied repeatedly to create further generations.

Problem.
The inputs below represent the coordinates of the cells in the universe which are a alive cell.
The below inputs provide the pattern or initial cells in the universe .
The output is the state of thesystemin the next tick (one run of the application of all the rules) , represented in the same format.


PS - for lastest code refer hotfix branch
