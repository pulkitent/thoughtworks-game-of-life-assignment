This is a gradle project based on java. It's an Objected Oriented Design(OOD) problem generally asked in interviews. Main reason behind asking these kind of problems in interview is to see whether a candidate can do following :
1. Can a candidate write a working code in given short span of time.
2. Can a candidate write highly readable code. Intention must be clear by reading the code.
3. Can a candidate follow the principle the of DRY (Don't Repeat Yourself) and avoid to break encapsulation by following Domain Driven Design(DDD).
4. Can a candidate achieve the solution with minimum number of elements using YAGNI principle (that is without creating unnecessary interfaces etc).

**PROBLEM STATEMENT**

**Game of Life**

The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states,live 
or dead.
Every cell interacts with its eight neighbours, which are the cells that are directly horizontally, vertically, or diagonally adjacent.

At each step in time, the following transitions occur:   

1.Any live cell with fewer than two live neighbours dies, as if by loneliness.
2.Any live cell with more than three live neighbours dies, as if by overcrowding.
3.Any live cell with two or three live neighbours lives, unchanged, to the next generation.
4.Any dead cell with exactly three live neighbours comes to life.

The initial pattern constitutes the 'seed' of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed 
births and deaths happen simultaneously, and the discrete moment at which this happens is sometimes called a tick.

(In other words, each generation is a pure function of the one before.) The rules continue to be applied repeatedly to create further generations.

Problem.
The inputs below represent the coordinates of the cells in the universe which are a alive cell.
The below inputs provide the pattern or initial cells in the universe .
The output is the state of the system in the next tick (one run of the application of all the rules) , represented in the same format.


PS - Was using proper CI/CD on gitlab (refer .gitlab-ci.yml) but migrated project here on Github
