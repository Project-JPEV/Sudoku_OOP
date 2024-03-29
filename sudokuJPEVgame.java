import java.util.Arrays;

public class sudokuJPEVgame {

    public static void main(String[] args) 
    {
        Level easyLevel = levelMaker.createEasylevel();
        Level mediumLevel = levelMaker.createMediumlevel();
        Level hardLevel = levelMaker.createHardlevel();

        boolean solving = true; //goes into the function
        while (solving) 
        {
            solving = checkSolved(easyLevel); //will currently return false with B so it stops the loop
            System.out.println("Is the level solved?: " + !solving); //not solved is opposite of solving
        }

        int level = 1;
        switch (level) {
            case 1:
                System.out.println("Easy Level:");
                levelMaker.printLevel(easyLevel);
                break;
            case 2:
                System.out.println("\nMedium Level:");
                levelMaker.printLevel(mediumLevel);
                break;
            case 3:
                System.out.println("\nHard Level:");
                levelMaker.printLevel(hardLevel);
                break;
            default:
                System.out.println("\nHard Level:");
                break;
        }
    }

    public static boolean checkSolved(Level easyLevel) {
        char[][] c = easyLevel.getSolution(); //this is the actual function call
        char[][] b = { 
            {'2', 'X', '1', '3'},
            {'1', 'X', '2', '0'},
            {'X', '2', 'X', '1'},
            {'X', '1', '3', 'X'}
        };
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
}
