interface SudokuLevel  // Interface for representing a Sudoku level
{
    Level createLevel1(); //easy
    Level createLevel2(); //medium
    Level createLevel3(); //hard
}
public class levelMaker implements SudokuLevel 
{
    public static final int rowColumn = 4;
    @Override
    public Level createLevel1() 
    {
        // For example, let's create an easy level
        return createEasylevel();
    }
    @Override
    public Level createLevel2() 
    {
        // For example, let's create an easy level
        return createMediumlevel();
    }
    @Override
    public Level createLevel3() 
    {
        // For example, let's create an easy level
        return createHardlevel();
    }
    
    public Level createEasylevel() 
    {
        char[][] easyGrid = 
        {
            {'3', '2', 'X', '1'},
            {'X', 'X', '3', '2'},
            {'X', '4', '2', 'X'},
            {'2', 'X', 'X', 'X'}
        };
	char[][] easySolution =
	{
	        {'3', '2', '4', '1'},
            {'4', '1', '3', '2'},
            {'1', '4', '2', '3'},
            {'2', '3', '1', '4'}
        };
		
        return new Level(rowColumn, rowColumn, 1, easyGrid, easySolution);
    }

    public Level createMediumlevel() 
    {
        char[][] mediumGrid = 
        {
            {'X', 'X', '4', '1'},
            {'4', 'X', 'X', 'X'},
            {'X', '4', 'X', '1'},
            {'X', '3', '2', 'X'}
        };
        char[][] mediumSolution = 
        {
            {'3', '2', '4', '1'},
            {'4', '1', '3', '2'},
            {'1', '4', '2', '3'},
            {'2', '3', '1', '4'}
        };
        return new Level(rowColumn, rowColumn, 1, mediumGrid, mediumSolution );
    }

    public Level createHardlevel() 
    {
        char[][] hardGrid = 
        {
            {'2', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', '2', 'X', '1'},
            {'X', 'X', '3', 'X'}
        };
        char[][] hardSolution = 
        {
            {'2', '4', '1', '3'},
            {'1', '3', '2', '4'},
            {'3', '2', '4', '1'},
            {'4', '1', '3', '2'}
        };
        return new Level(rowColumn, rowColumn, 1, hardGrid,hardSolution);
    }

    public void printLevel(Level level) {
        System.out.println("Hiding some values for user to guess...");
        System.out.println("------------");
        char[][] grid = level.getGrid();
        for (int i = 0; i < level.getRow(); i++) 
        {
            System.out.print("|");
            for (int j = 0; j < level.getColumn(); j++) 
            {
                System.out.print(grid[i][j] + " ");
                if ((j + 1) % Math.sqrt(rowColumn) == 0)
				{           									// Separate it vertically
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % Math.sqrt(rowColumn) == 0) {               // Separate horizontally
                System.out.println("------------");
            }
        }
    }

}
