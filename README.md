# PROBLEM STATEMENT:

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

The inputs below represent the coordinates of the cells in the universe which are a alive cell.
The below inputs provide the pattern or initial cells in the universe.
The output is the state of the system in the next tick (one run of the application of all the rules), represented in the same format.

PS - Was using proper CI/CD on gitlab (refer .gitlab-ci.yml) but migrated project here on Github

# What the company is looking for?
They are looking for people who can write code that has flexibility built in, by adhering to the principles of Object Oriented Development, and have the ability to deal with the real-life constraints / trade-offs while designing a system.

It is important to note that they are not looking for a GUI and they are not assessing you on the capabilities around code required to do the I/O. The focus is on the overall design. So, while building a solution, it would be nicer if input to the code is provided either via unit tests or a file. Using command line (for input) can be tedious and difficult to test, so it is best avoided. Following is a list of things to keep in mind, before you submit your code:

Is behaviour of an object distinguished from its state and is the state encapsulated?

Have you applied SOLID principles to your code?

Have you applied principles of YAGNI and KISS (additional info here)?

Have you looked at basic refactoring to improve design of your code?

Finally, and foremost, are the principles applied in a pragmatic way.

Simplicity is the strongest of the trait of a piece of code. However, easily written code may not necessarily be simple code.

# Things I tried to follow:

1. Tried to create all the required domain entities/models as per problem statement

2. Tried not to break encapsulation by avoiding getters & setters (as much as possible)

3. Tried to have immutable state with value objects (as much as possible) so as to avoid concurrency issues (Thread safety)

4. Tried to have readable methods & variables naming so as to clear the intention (4 rules of simple design).

5. Tried to have small & logical commits

6. Tried to avoid code duplication by refactoring/reusing duplicate code (DRY) but still code duplication can be improved if given more time

7. Didn't make interfaces as per YAGNI principles because for now I don't feel the need for the same (Yes, I am aware of this principle also - "Program to interfaces rather than concrete implementation")

8. Tried to put some comments so as to make business logic more understandable

9. Wrote the job on every class so as to clear it's use case

# Things I could have done/improved if given more time :

1. TDD with 100% code coverage

2. Code duplication can be further reduced at some extent

3. Level of indentation can be further reduced in some methods by breaking them into smaller methods

4. Encapsulation of behaviour in some classes can be further improved

5. More mocking and stubbing of test data in unit tests


So this is a gradle project based on java. It's an Objected Oriented Design(OOD) problem generally asked in interviews. Main reason behind asking these kind of problems in interview is to see whether a candidate can do following :

1. Can a candidate write a working code in given short span of time.

2. Can a candidate write highly readable code. Intention must be clear by reading the code.

3. Can a candidate follow the principle the of DRY (Don't Repeat Yourself) and avoid to break encapsulation by following Domain Driven Design(DDD).

4. Can a candidate achieve the solution with minimum number of elements using YAGNI principle (that is without creating unnecessary interfaces etc).
