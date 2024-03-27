import java.util.Scanner;

public class JPEVsudokuGame {
    private static final int SIZE = 4;                           // size of the sudoku game
    private static final char EMPTY = 'X';                       // Character for the empty slot
    private static Scanner scanner = new Scanner(System.in);     // Scanner object for user input
    private static char[][] GRID = {                                        // Actual Sudoku grid
                                    {'2', 'X', '1', '3'},
                                    {'1', 'X', '2', '0'},
                                    {'X', '2', 'X', '1'},
                                    {'X', '1', '4', 'X'}
                                  };

    public static void main(String[] args) 
	{                   
        userVerification();
        printGame();
        solvingGame();
        printGame();
        scanner.close();                                        // Close the scanner
    }

    private static void printGame() 
	{
        System.out.println("Printing Sudoku Game:");

        

                        //FILE handling portion hereeee
						
        System.out.println("Hiding some values for user to guess...");
        System.out.println("------------");

        for (int i = 0; i < SIZE; i++) 
		{                       								 // Loop through each Row
            System.out.print("|");

            for (int j = 0; j < SIZE; j++) 
			{                    								// Loop through each Column
                if (GRID[i][j] == 0) 
				{                          						// If the slot is empty
                    System.out.print(EMPTY + " ");             // Print EMPTY Symbol X
                } 
				else 
				{
                    System.out.print(GRID[i][j] + " ");        // Print the value of the slot
                }
                if ((j + 1) % Math.sqrt(SIZE) == 0)
				{           									// Separate it vertically
                    System.out.print("| ");
                }
            }
            System.out.println();

            if ((i + 1) % Math.sqrt(SIZE) == 0) {               // Separate horizontally
                System.out.println("------------");
            }
        }
    }

    //private static 
    //Function to call the file here 

    private static void userVerification() 
	{
        System.out.println("\nAre you a new player or an existing player?\n");
    }

    private static void solvingGame() {
        System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
        System.out.println("R C G\n-----");

        while (true) {
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("Exit") || userInput.equalsIgnoreCase("Quit")) {
                System.out.println("Goodbye");
                break;
            }

            String[] parts = userInput.split(" ");

            if (parts.length != 3) {
                System.out.println("Invalid formatting try again");
                continue;
            }

            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;
            char guess = parts[2].charAt(0);

            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) 
            {
                System.out.println("Invalid row or column input try again");
                continue;
            }

        
            if (guess != EMPTY && (guess < '1' || guess > '4')) 
            {
                System.out.println("Invalid guess input try again");
                continue;
            }

            if (GRID[row][col] != EMPTY) 
            {
                System.out.println("Already filled, try again");
                continue;
            }

            if (!uniqueValue(row, col, guess)) 
            {
                System.out.println("Number already exists in row or column, try again");
                continue;
            }

            GRID[row][col] = guess;
            printGame();
            System.out.println("R C G\n-----");
        }
    }

    private static boolean uniqueValue(int row, int col, char guess)
    {
        for( int i = 0; i < SIZE; i++)
        {
            if( GRID[row][i] == guess) 
            {
                return false;
            }
        }

        for( int i = 0; i < SIZE; i++)
        {
            if (GRID[i][col] == guess)
            {
                return false;
            }
        }
        return true;
    }
}



   