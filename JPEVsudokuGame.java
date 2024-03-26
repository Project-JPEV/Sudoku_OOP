
import java.util.Scanner;

public class JPEVsudokuGame 
{
    private static final int SIZE = 4;                           // size of the sudoku game
    private static final char EMPTY = 'X';                       // Character for the empty slot
    
    public static void main(String[] args) {   	                  // Main

        Scanner scanner = new Scanner(System.in);

		userVerification();

        printGame();

		System.out.println("");
        scanner.close();

        System.out.println("");

    }

    private static void printGame() 
	{
        System.out.println("Printing Sudoku Game:");		

		int[][] GRID = {                        // Actual Sudoku grid
							{2, 0, 1, 3},
							{1, 0, 2, 0},
							{0, 2, 0, 1},
							{0, 1, 4, 0}
	};
        System.out.println("Hiding some values for user to guess...");
		System.out.println("------------");
		
		for (int i = 0; i < SIZE; i++) 
		{                    								// Loop through each Row
            System.out.print("|");

            for (int j = 0; j < SIZE; j++) 
			{               								// Loop through each Column
                if (GRID[i][j] == 0) 
				{                      					    // If the slot is empty
                    System.out.print(EMPTY + " ");          // Print EMPTY Symbol X
                } 
				else 
				{
                    System.out.print(GRID[i][j] + " ");     // Print the value of the slot
                }
                if ((j + 1) % Math.sqrt(SIZE) == 0)
				{       // Separate it vertically
                    System.out.print("| ");
                }
            }
            System.out.println();

            if ((i + 1) % Math.sqrt(SIZE) == 0) 
			{         									  // Separate horizontally
                System.out.println("------------");
            }
        }


    }
	private static void userVerification()
	{
		System.out.println("\n");
		System.out.println("Are you a new player or existing player ");
		System.out.println("\n");

	}
}

	/*System.out.println("Enter your guess in the format 'row column value' example:  '2 3 1':");
	int row = scanner.nextInt();
	int col = scanner.nextInt();
	int guess = scanner.nextInt();
	*/

