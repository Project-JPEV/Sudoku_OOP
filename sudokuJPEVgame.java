import java.util.Arrays;
import java.util.Scanner;

public class sudokuJPEVgame {

    private static final int SIZE = 4;                           // size of the sudoku game
    private static final char EMPTY = 'X';                       // Character for the empty slot
    private static Scanner scanner = new Scanner(System.in);  // Scanner object for user input

    public static void main(String[] args) 
    {
        Level easyLevel = levelMaker.createEasylevel();
        Level mediumLevel = levelMaker.createMediumlevel();
        Level hardLevel = levelMaker.createHardlevel();

        boolean solving = true; 
        
        System.out.print("Enter a number for level:"); // Prompt the user to enter a level number

        int level = scanner.nextInt();         // Read the number entered by the user
        switch (level) 
        {
            case 1:
                while (solving) 
                {
                    
                    solving = checkSolved(easyLevel); //will currently return false with B so it stops the loop
                    if (solving == true)
                    {
                        System.out.println("Easy Level:");
                        levelMaker.printLevel(easyLevel);
                        System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
                        char input[][] = easyLevel.getGrid();
                        System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
                        System.out.println("R C G\n-----");
                        playing(input, solving);
                    }
                    else
                    {
                        System.out.println("Congratz you win");
                    }
                }
                break;
            case 2:
                while (solving)
                {
                    solving = checkSolved(mediumLevel);
                    if (solving == true)
                    {
                        System.out.println("Medium LEvel:");
                        levelMaker.printLevel(mediumLevel);
                        System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
                        char input[][] = mediumLevel.getGrid();
                        System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
                        System.out.println("R C G\n-----");
                        playing(input, solving);
                    }
                    else
                    {
                        System.out.println("Congratz you win");
                    }
                }
                    break;
                case 3:
                while (solving)
                {
                    solving = checkSolved(hardLevel);
                    if (solving == true)
                    {
                        System.out.println("Easy Level:");
                        levelMaker.printLevel(hardLevel);
                        System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
                        char input[][] = hardLevel.getGrid();
                        System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
                        System.out.println("R C G\n-----");
                        playing(input, solving);
                    }
                    else
                    {
                        System.out.println("Congratz you win");
                    }
                }
                break;
            default:
                System.out.println("\nHard Level:");
                break;
        }
    }

    public static boolean checkSolved(Level easyLevel) 
    {
        //check user modified array vs solution
        char[][] b = easyLevel.getSolution(); //this is the actual function call
        //above is the a test to see if it works
        boolean isSolved = false;   
        char[][] a = easyLevel.getGrid();
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) { //replace b with C when working
             isSolved = true;
                break;
            }
            else{
             isSolved= false;
            }
        }
        return isSolved;
    }
    public static boolean playing(char [][] input, boolean solving)
    {
        
        char [][]GRID = input;
        String userInput = scanner.nextLine().trim();

        if (userInput.equalsIgnoreCase("Exit") || userInput.equalsIgnoreCase("Quit")) //Loop for game to start
        {
            System.out.println("Goodbye");
            return solving = false;
        }

        String[] parts = userInput.split(" ");                   //make user input into string and split into parts with spaces

        if (parts.length != 3) {                                        //only allow 3 parts from user input
            System.out.println("Invalid formatting try again");
            return solving = true;
        }

        int row = Integer.parseInt(parts[0]) - 1;                      
        int col = Integer.parseInt(parts[1]) - 1;
        char guess = parts[2].charAt(0);


        //make a 3 lives function to quit game 
    

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE)                   // check for valid rows and columns
        {
            System.out.println("Invalid row or column input try again");
            return solving = true;
        }

        if (guess != EMPTY && (guess < '1' || guess > '4'))                     // make sure to only allow 1-4 from user for guess attempt
        {
            System.out.println("Invalid guess input try again");
            return solving = true;
        }

        if (GRID[row][col] != EMPTY)                                           //check if slot already filled
        {
            System.out.println("Already filled, try again");
            return solving = true;
        }
        
        if (!uniqueValue(row, col, guess,GRID)) 
        {
            System.out.println("Number already exists in row or column, try again");       //check for specific number in that lot if already filled 
            return solving = true;
        }

        GRID[row][col] = guess;                                                             //print  updated game again 
        return solving = true;
    
    }
    private static boolean uniqueValue(int row, int col, char guess,char [][]GRID)                        //Check for duplicates
    {
        for( int i = 0; i < SIZE; i++)                                                      // checking for rows 
        {
            if( GRID[row][i] == guess)                                                  
            {
                return false;
            }
        }

        for( int i = 0; i < SIZE; i++)                                                    // checking for columns
        {
            if (GRID[i][col] == guess)
            {
                return false;
            }
        }
        return true;
    }


}
