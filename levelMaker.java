public class levelMaker 
{
    public static final int rowColumn = 4;
    public static Level createEasylevel() 
    {
        char[][] easyGrid = 
        {
            {'2', 'X', '1', '3'},
            {'1', 'X', '2', '0'},
            {'X', '2', 'X', '1'},
            {'X', '1', '3', 'X'}
        };
	char[][] easySolution =
	{
	        {'2', '4', '1', '3'},
            {'1', 'X', '2', '0'},
            {'X', '2', 'X', '1'},
            {'X', '1', '3', 'X'}
        };
		
        return new Level(rowColumn, rowColumn, 1, easyGrid, easySolution);
    }

    public static Level createMediumlevel() 
    {
        char[][] mediumGrid = 
        {
            {'X', 'X', '1', '3'},
            {'1', 'X', '2', '0'},
            {'X', '2', 'X', '1'},
            {'X', '1', 'X', 'X'}
        };
        char[][] mediumSolution = 
        {
            {'X', 'X', '1', '3'},
            {'1', 'X', '2', '0'},
            {'X', '2', 'X', '1'},
            {'X', '1', 'X', 'X'}
        };
        return new Level(rowColumn, rowColumn, 1, mediumGrid, mediumSolution );
    }

    public static Level createHardlevel() 
    {
        char[][] hardGrid = 
        {
            {'2', 'X', 'X', 'X'},
            {'X', 'X', 'X', '0'},
            {'X', '2', 'X', '1'},
            {'X', 'X', '3', 'X'}
        };
        char[][] hardSolution = 
        {
            {'2', 'X', 'X', 'X'},
            {'X', 'X', 'X', '0'},
            {'X', '2', 'X', '1'},
            {'X', 'X', '3', 'X'}
        };
        return new Level(rowColumn, rowColumn, 1, hardGrid,hardSolution);
    }

    public static void printLevel(Level level) {
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
