import java.util.Scanner;

////////////////////////////////////////////////////////////////////////
// Programmed by:
//   - Pierre-Olivier Trottier (40059235)
//   - Nimit Jaggi (40032159)
////////////////////////////////////////////////////////////////////////

public class Main {
	private static final int MAX_LENGTH = 19; // The real max length is effectively 20 because of the +2
	private static final int MAX_VALUE = 9;
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    // Start new games until the player doesn't want to play anymore
    do {
      startGame();
    } while (playAgain());
  }

  private static void startGame() {
    // Just a proxy method to simplify the main
    System.out.println("\n===========================================================================================");
    System.out.println("Welcome to a new Score Far Right Game!");
    System.out.println("===========================================================================================");
    System.out.println("- If the randomly generated problem is solvable, you will be able to play.");
    System.out.println("- To play, simply enter \"l\" or \"r\" to move the cursor to the left of right, respectively.");
    System.out.println("- The goal of the game is to reach the \"0\" at the right-most position.");
    System.out.println("- Good luck!\n");
    int[] array = generateRandomArray();
    int position = generateRandomPosition(array);
    // Stop the game right away if the problem is not solvable
    if (isSolvable(array, position)) {
      play(array, position, false);
    } else {
      System.out.println("Sorry, the randomly generated problem is not solvable...");
      printArray(array, position);
    }
}

  private static void play(int[] array, int position, boolean gameOver) {
    System.out.println("Current Position:");
    printArray(array, position);

    if (gameOver) {
      if (position == array.length - 1) {
        System.out.println("Congratulations, you won the game!");
        return;
      } else {
        System.out.println("Oh no! You lost that one...");
        return;
      }
    }

    System.out.print("Would you like to go left (l) or right (r)? ");
    position = moveCursor(array, position);

    if (position < 0 || position >= array.length - 1)
      play(array, position, true);
    else
      play(array, position, false);
  }

  private static boolean playAgain() {
    // Just a proxy method to ask the user if he wants to play again
    System.out.print("\nWould you like to play again ? (y/n) ");
    String input = SCANNER.nextLine().toLowerCase();
    while (!input.equals("n") && !input.equals("y")) {
      System.out.print("Sorry, I didn't get that... Please enter \"y\" for YES and \"n\" for NO: ");
      input = SCANNER.nextLine().toLowerCase();
    }
    return input.equals("y");
  }

  private static int[] generateRandomArray() {
    // Generate a random length between 2 and 20 for the array
    int length = (int) Math.floor(Math.random() * MAX_LENGTH) + 2;
    int[] array = new int[length];
    // Generate a random value between 1 and 9 for each element
    for (int i = 0; i < length - 1; i++) {
      array[i] = (int) Math.floor(Math.random() * MAX_VALUE) + 1;
		}
    	// Set the last element to 0
    	array[length - 1] = 0;
    	return array;
	}

	private static int generateRandomPosition(int[] array) {
    	// Generate a random position between 0 and the last index of the array -1
		return (int) Math.floor(Math.random() * (array.length - 1));
	}

	private static boolean isSolvable(int[] array, int position) {

        int size = array.length;
        int left;
        int right;
        int[] binaryArray = new int[3*size];
        binaryArray[0] = position;
        int currentValue;
        int tracker;

        for(int i = 0; i<binaryArray.length; i++){

            if(binaryArray[i] == -1)
                return false;
            else if(binaryArray[i] == -1){

                tracker = binaryArray[i+1];
                i++;

            }
            else
            tracker = binaryArray[i];

            currentValue = array[tracker];
            right = size - tracker - 1;
            left = tracker;

            if(right == currentValue)
                return true;

            if((left -  currentValue) < 0 && right < currentValue)
                return false;

            if((left - currentValue) > 0)
                binaryArray[(2*i)+1] = left - currentValue;
            else
                binaryArray[(2*i)+1] = -1;

            if(right >= currentValue)
                binaryArray[(2*i)+2] = left - currentValue;
            else
                binaryArray[(2*i)+2] = -1;


        }


        return false;
  }

	private static void printArray(int[] array, int position) {
		System.out.print("  ");
		// Print the numbers in the array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(" | ");
		}
		System.out.print("\n");
		// Print the arrow to the current position
		for (int i = 0; i < array.length; i++) {
			System.out.print("  ");
			if (position == i)
				System.out.print("^");
			else
				System.out.print("  ");
		}
		System.out.print("\n");
	}

  private static int moveCursor(int[] array, int position) {
    String movement = SCANNER.nextLine().toLowerCase();
    while (!movement.equals("l") && !movement.equals("r")) {
      System.out.print("Sorry, I didn't get that... Please enter \"l\" for LEFT and \"r\" for RIGHT: ");
      movement = SCANNER.nextLine().toLowerCase();
    }
    System.out.print("\n");
    if (movement.equals("l")) {
      return position - array[position];
    } else {
      return position + array[position];
    }
  }
}

