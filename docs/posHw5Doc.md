# Homework 5: The Marvel Comics Universe

**Due: Monday, March 26 @ 1:59:59 pm**

# Introduction

This homework has two parts. In the first part (Problem 1), you will **practice concepts we discuss in class**.

In the second part, you will **put the graph you designed in Homework 4 to use** by modeling the Marvel Comics universe.
By trying out your ADT in a client application, you will be able to test the usability of your design as well as the correctness, efficiency, and scalability of your implementation.
**You may have to overhaul, or just tweak your implementation, once you try it with a larger load**.

The application builds a graph containing **thousands** of nodes and edges. At this size, you may discover **performance issues** that weren't revealed by your unit tests on smaller graphs. With a well-designed implementation, your program will run in a matter of seconds. Bugs or less ideal choices of data structures can increase the runtime to anywhere from several minutes to 30 minutes or more. If this is the case you may want to go back and revisit your graph implementation from Homework 4. Remember that different graph representations have widely varying time compelxities for various operations and this, not a coding bug, may explain the slowness.

### Problem 1: Written Exercises [10 points]

See hw5.html by Dr.Kuzmin :)

# The MarvelPaths Application

Use your graph ADT in hw4, model a social network among charcaters in the Marvel commic books.

Start hw5 code in a new package `hw5`, you can always `import hw4` to use existing code in your previous assignment.

**Each node should represent a character.**

**An Edge(Character alpha, Character bravo) represents that *alpha* appeared in a commic book where *bravo* also appeared in.**
There should be a **separate** edge for every comic book, labeled with the name of the book. And **NO REFLEXIVE** edges from characters to themselves should be stored.

    Alpha ----book 1----> Bravo
    Alpha ----book 2----> Bravo
    Alpha ----book 3----> Bravo
    Alpha ----book 1----> Alpha   // Bad! Don't store!
This means that Alpha and Bravo appeared together in book 1, 2 and 3.

In file **MarvelPaths.java** add a class `hw5.MarvelPaths` for this assignment. It reads the Marvel data from a file (marvel.csv), builds a graph, and finds paths between characters in the graph. You are not required to write a main method as a driver for your application; nevertheless, we encourage you to do so.

During your implementation, if you need to modify your ADT (e.g. changing representation, adding methods) you need to document it in **answers/hw5_changes.pdf** with 1~2 sentences per change.

## Input file

Download the file from [this link.](http://www.cs.rpi.edu/academics/courses/spring18/csci2600/marvel.csv)

**Instructor note: Do NOT commit this file to your repo, it's too large!**

Data format is shown as below:

    "Name","Book"

## Building the graph

Use helper class `MarvelParser` and its method `MarvelParser.readData()`

The method creates in-memory data structures: a **Set** of all characters and a **Map** from each book to a Set of characters in that book.

Input data is read in as command line argument, so make sure to add `marvel.csv` as a command line argument.

Class `MarvelParser` also includes a `main` method as a driver method. Be sure to comment it out when running coverage on tests for higher coverage.

Also, be sure to test the parser no matter if you made changes to it.

## Finding Paths

Tasking: Given the name of two characters, `MarvelPaths` searches for and returns a path through the graph connecting them. How the path is subsequently used, or the format in which it is printed out, depends on the requirements of the particular application using `MarvelPaths`.

Your program should return the **SHORTEST** path using **Breadth-First Search** . hw5.html includes a pesudo-code for the algorithm.

For the sake of the grading, the algorithm you implmented should return the **lexicographically (alphabetically) least** path. More precisely, it should pick the **lexicographically first** character at each next step in the path, and if those characters appear in several comic books together, it should print the **lexicographically lowest title** of a comic book that they both appear in.

Because of this requirment, it should be useful to modify the BFS so it visits the neighbors of each node in **increasing** order. Example:

    Node x; Children {"a", "c", "b"};
Then we first visit `"a"`, then `"b"`, then at last, `"c"`

Also it is better to implement this BFS in `MarvelPaths` rather than the `Graph` class, as other clients won't be using the same ordering.

### Performance

The expected running time of each test suite is **60 seconds** on submitty. If this limit is reached, better go back and look for a more efficient solution.
~~天下武功，唯快不破~~

Similarly to Homework 4, add an instance field that stores a Graph in `MarvelPaths`. For testing purposes, we require that you implement the following public methods in `MarvelPaths`. Otherwise, design class `MarvelPaths` as you wish and add operations as you wish.

    public void createNewGraph(String filename)
Creates new graph as the instance field(member variable) of `MarvelPaths`

    public String findPath(String node1, String node2)
Find the **shortest** path from node1 to node2 in the graph using your breadth-first search algorithm.

## Output of the path-finding algorithm

If path is found, return a `String` describing the following format:

    path from node_1 to node_n:
    node_1 to node_2 via BOOK_1
    node_2 to node_3 via BOOK_2
    ...
    node_n-1 to node_n via BOOK_N-1
If no path is found, the output should look something like this:

    path from node_1 to node_n:
    no path found
If any one of the input node, say `unknown_start` doe not exist in the Graph, output:

    unknown character unknown_start
If both arguments DNE, print the error message for both of them:

    unknown character unknown_start
    unknown character unknown_end
If node1 == node2, the output should look something like this:

    path from C to C:
btw a well-designed solution should **not** take this as another special case.

**In all cases the string should end with \n (newline), just like in the first case.**

## Testing

Use scalability testing when testing on the correctness of the code. But you probably want to test it on the full dataset to see if it meets the performance requirement. In addition, it is important to be able to test your parsing/graph-building and BFS operations in **separate** test files.

To construct scaled data sets, you need to write your own `.csv` files in the same format as `marvel.csv`, these files all go to the `data/` directory.

Put test files for this assignment in `src/test/java/hw5` **and specify that you want to put your test class in the hw5 package**. You also need to specify the data files to load in your implementation tests. See the following section for more detail.

Submitty will be testing on coverage again, but this time on a threshold of 90%, so good luck and have nice day!

## Paths to Files

Put test files in `data/`, then **_HARDCODE_** the relative path in your tests.

For example, if you use file `testfile1.csv` in directory data/, you can load the file using the following code snippet:

    BufferedReader reader = new BufferedReader(new FileReader("data/testfile1.csv"));
Behavior may vary from one version of Eclipse to another. As long as you hardcode your relative paths starting at data/ you will be fine on Submitty.

## Grade Breakdown, collaboration, reflection....
See hw5.html
