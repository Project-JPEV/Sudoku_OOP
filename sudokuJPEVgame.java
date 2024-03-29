import java.util.Scanner;

public class sudokuJPEVgame{
    public static void main(String[] args) 
    {
        Level easyLevel = levelMaker.createEasylevel();
        Level mediumLevel = levelMaker.createMediumlevel();
        Level hardLevel = levelMaker.createHardlevel();
        
        int level = 1;
        switch(level)
        {
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
        }
    }
}