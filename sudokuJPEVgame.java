import java.util.Arrays;
import java.util.Scanner;

interface SudokuComponent  // Interface example
{
    boolean checkSolved(Level level);
    boolean playing(char[][] input, boolean solving);
}

public class sudokuJPEVgame implements SudokuComponent 
{

    private static final int SIZE = 4;                           // size of the sudoku game
    private static final char EMPTY = 'X';                       // Character for the empty slot
    private static Scanner scanner = new Scanner(System.in);  // Scanner object for user input

    public static void main(String[] args) 
    {
        
        int userLevel=-1;
        String userExisting;
        String userName = null;
        System.out.println("\nAre you a new player or an existing player?\n");
        userExisting = scanner.nextLine();
        if (userExisting.equalsIgnoreCase("New")) 
        {
            System.out.println("\nWelcome New User!, enter a user name:\n");
            userName = scanner.nextLine();
            UserManager.handleNewUser(userName);
            userLevel=UserManager.findAndDisplayUserInfo(userName);
            
        } 
        else if (userExisting.equalsIgnoreCase("Existing")) 
        {
            System.out.println("\nWelcome back! What is your username?");
            userName = scanner.nextLine();
            userLevel=UserManager.findAndDisplayUserInfo(userName);
            //UserManager.changeLevel(userName, 2); //for testing the overwriting of level info
        } 
        else 
        {
            System.out.println("Invalid input. Please type 'New' or 'Existing'.");
        }
        levelMaker levelMaker = new levelMaker();
        sudokuJPEVgame game = new sudokuJPEVgame();

        Level easyLevel = levelMaker.createLevel1();
        Level mediumLevel = levelMaker.createLevel2();
        Level hardLevel = levelMaker.createLevel3();
        boolean solving = true;

        //System.out.println("userLevel"+ userLevel); //for error checking
        if (userName != null)       //allows username to be used in the switch- idk why
        {
            switch (userLevel) 
            {
                case 1:
                    while (solving) 
                    {
                        
                        solving = game.checkSolved(easyLevel); //will currently return false with B so it stops the loop
                        if (solving == true)
                        {
                            System.out.println("Easy Level:");
                            levelMaker.printLevel(easyLevel);
                            System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
                            char input[][] = easyLevel.getGrid();
                            System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
                            System.out.println("R C G\n-----");
                            game.playing(input, solving);
                        }
                        else
                        {
                            System.out.println("Congratz you win");
                            System.out.println(".--'''''''''--.\n     .'      .---.      '.\n    /    .-----------.    \\\n   /        .-----.        \\\n   |       .-.   .-.       |\n   |      /   \\ /   \\      |\n    \\    | .-. | .-. |    /\n     '-._| | | | | | |_.-'\n         | '-' | '-' |\n          \\___/ \\___/ \n       _.-'  /   \\  `-._\n     .' _.--|     |--._ '.\n     ' _...-|     |-..._ '\n            |     |\n            '.___.'");
                            UserManager.changeLevel(userName, 2);
                        }
                    }
                    break;
                case 2:
                    while (solving)
                    {
                        solving = game.checkSolved(mediumLevel);
                        if (solving == true)
                        {
                            System.out.println("Medium Level:");
                            levelMaker.printLevel(mediumLevel);
                            System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
                            char input[][] = mediumLevel.getGrid();
                            System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
                            System.out.println("R C G\n-----");
                            game.playing(input, solving);
                        }
                        else
                        {
                            System.out.println("Congratz you win");
                            System.out.println(".-----.\n .' -   - '.\n/  .-. .-.  \\\n|  | | | |  |\n \\ \\o/ \\o/ / \n  _/    ^    \\_\n | \\  '---'  / |\n / /`--. .--`\\ \\ \n/ /'---` `---'\\ \\ \n'.__.       .__.'\n    `|     |`\n     |     |\n     |     \\\n     \\     '--.\n      '.        `\\\n        `'---.   |\n              ) /\n              \\/");
                            UserManager.changeLevel(userName, 3);
                        }
                    }
                        break;
                    case 3:
                    while (solving)
                    {
                        solving = game.checkSolved(hardLevel);
                        if (solving == true)
                        {
                            System.out.println("Easy Level:");
                            levelMaker.printLevel(hardLevel);
                            System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
                            char input[][] = hardLevel.getGrid();
                            System.out.println("\nEnter your guess in the format 'row column guess' example: '2 3 1': (Enter Exit or Quit to leave game)");
                            System.out.println("R C G\n-----");
                            game.playing(input, solving);
                        }
                        else
                        {
                            System.out.println("Congratz you win");
                            System.out.println("        .--..--..--..--..--..--.\n       .' \\  (`._   (_)     _   \\ \n      .'    |  '._)         (_)  | \n      \\ _.')\\      .----..---.   / \n      |(_.'  |    /    .-.-.  \\  | \n      \\     0|    |   ( O| O) | o| \n       |  _  |  .--.____.'._.-.  | \n       \\ (_) | o         -` .-`  | \n        |    \\   |`-._ _ _ _ _\\ / \n        \\    |   |  `. |_||_|   | \n        | o  |    \\_      \\     |     -.   .-. \n        |.-.  \\     `--..-'   O |     `.`-' .' \n      _.'  .' |     `-.-'      /-.__   ' .-' \n    .' `-.` '.|='=.='=.='=.='=|._/_ `-'.' \n    `-._  `.  |________/\\_____|    `-.' \n       .'   ).| '=' '='\\/ '=' | \n       `._.`  '---------------' \n                //___\\   //___\\ \n                  ||       || \n                  ||_.-.   ||_.-.\n                (_.--__) (_.--__)");
                        }
                    }
                    break;
                default:
                    System.out.println("\nGoodbye!:");
                    break;
            }
        }
    }

    public boolean checkSolved(Level level)  
    {
        //check user modified array vs solution
        char[][] b = level.getSolution();
        boolean isSolved = false;   
        char[][] a = level.getGrid();
        for (int i = 0; i < a.length; i++) 
        {
            if (!Arrays.equals(a[i], b[i])) 
            { 
             isSolved = true;
                break;
            }
            else{
             isSolved= false;
            }
        }
        return isSolved;
    }
    public boolean playing(char[][] input, boolean solving) 
    {
        char[][] GRID = input;
        String userInput = scanner.nextLine().trim();
    
        if (userInput.equalsIgnoreCase("Exit") || userInput.equalsIgnoreCase("Quit")) //Loop for game to start
        {
            System.out.println("Goodbye");
            System.exit(0);
        }

        String[] parts = userInput.split(" ");                   //make user input into string and split into parts with spaces
    
        if (parts.length != 3) 
        {                                        //only allow 3 parts from user input
            System.out.println("Invalid formatting try again");
            return solving = true;
        }
    
        int row = Integer.parseInt(parts[0]) - 1;
        int col = Integer.parseInt(parts[1]) - 1;
        char guess = parts[2].charAt(0);
    
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
    
        if (!uniqueValue(row, col, guess, GRID)) 
        {
            System.out.println("Number already exists in row or column, try again");       //check for specific number in that lot if already filled
            return solving = true;
        }
    
        GRID[row][col] = guess;                                                             //print  updated game again
        return solving = true;
    
    }
    
    private boolean uniqueValue(int row, int col, char guess, char[][] GRID) 
    {
        for (int i = 0; i < SIZE; i++)                                                      // checking for rows
        {
            if (GRID[row][i] == guess) 
            {
                return false;
            }
        }
    
        for (int i = 0; i < SIZE; i++)                                                    // checking for columns
        {
            if (GRID[i][col] == guess) 
            {
                return false;
            }
        }

        int startRow = (row / 2) * 2;
        int startCol = (col / 2) * 2;
        for (int i = startRow; i < startRow + 2; i++) 
        {
            for (int j = startCol; j < startCol + 2; j++) 
            {
                if (GRID[i][j] == guess)
                 {
                    return false;
                }
            }
        }



        return true;
    }
}