Written by:
  - Pierre-Olivier Trottier (40059235)
  - Nimit Jaggi (40032159)

A) Time complexities for the following methods are:

      - startGame():                O(2^n) because the method by by itself is O(1), but it
                                    relies on isSolvable, which internally relies on
                                    navigateBinaryTree() which is O(2^n), making the
                                    complexity of this method O(1 + 2^n) which is O(2^n)

      - play():                     O(n) because the method by by itself is O(1), but it
                                    relies on printArray() which is O(n), making the complexity
                                    of this method O(n + 1) which is O(n). That said, the method
                                    also recursively calls itself 'x' amount of times depending
                                    on the moves the player makes. It is therefore O(x*n) which
                                    is also O(n)

      - playAgain():                O(1) because the method is independent of n and only
                                    executes 1

      - generateRandomArray():      O(n) because we only generate a random number based on
                                    the current seed for the length making if O(1), but then
                                    we need to fill every element making is O(n + 1) which is
                                    also O(n).

      - generateRandomPosition():   O(1) because we only generate a random number based on
                                    the current seed.

      - isSolvable():               O(2^n) because the method by by itself is O(n), but it
                                    relies on navigateBinaryTree() which is O(2^n), making
                                    the complexity of this method O(n + 2^n) which is O(2^n)

      - navigateBinaryTree():       O(2^n) because we a evaluating 2 possible solutions for
                                    every element, effectively creating a binary tree. We
                                    are therefore creating 2^n nodes, which all need to be
                                    evaluated, making this method's complexity O(2^n).

      - printArray():               O(n) because we need to go through every element of the array
                                    and print them one after the other. The complexity is
                                    actually 2n because we also loop through every element
                                    to print out the current position cursor.

      - moveCursor():               O(1) because it the effective logic is as simple as a single
                                    calculation which is independent of the size of the array.



  Space complexities for the following methods are:

      - startGame():                O(1) because the method by by itself is O(1), and the
                                    method isSolvable() on which it relies is also O(1).

      - play():                     O(1) because the method by by itself is O(1), and the
                                    method printArray() on which it relies is also O(1).

      - playAgain():                O(1) because it's a single instruction.

      - generateRandomArray():      O(1) because 'for loops' can be transformed very easily to
                                    tail recursive algorithm which are always O(1).

      - generateRandomPosition():   O(1) because it's a single instruction.

      - isSolvable():               O(1) because the method by by itself is O(1), and the
                                    method navigateBinaryTree() on which it relies is also O(1).

      - navigateBinaryTree():       O(1) because it is tail recursive and all tail recursive
                                    algorithms have space complexities of 1.

      - printArray():               O(1) because 'for loops' can be transformed very easily to
                                    tail recursive algorithm which are always O(1).

      - moveCursor():               O(1) because it's a single instruction.


B)  In all recursive algorithms, we used tail recursion. This means that all our algorithms have
    space complexities of 1. As for time complexity, we believe that the solutions offered are the
    the most optimized versions, meaning that the time complexities are also probably the best we
    could have developed considering the situation.

C)  The logs for 20 consecutive games can be found in the file "GameLog.txt".
    There are multiple examples of unsolvable problems, a few examples of
    game that were successfully played and one example of a game where the
    player lost.

D)  See isSolvable() method in the Main Class. There is however a know bug.
    If we have initial values such as:
      array = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0};
      initialPosition = 0;
    Where there are an infinite number of solutions to the problem, the algorithm
    will reach the maximum number of step allowed and will deem the problem unsolvable.