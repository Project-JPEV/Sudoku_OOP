public class Level 
{
    private int row;
    private int column;
    private char[][] grid;
    private int difficulty;
    private char [][] solution; //solution Grid

    public int getRow() 
    {
        return row;
    }
    public int getColumn() 
    {
        return column;
    }
    public int getDifficulty() 
    {
        return difficulty;
    }
    public char [][] getGrid() 
    {
        return grid;
    }
    
    public void setRow(int row) 
    {
        this.row = row;
    }
    public void setColumn(int column) 
    {
        this.column = column;
    }
    public void setDifficulty(int difficulty) 
    {
        this.difficulty = difficulty;
    }
    public void setGrid(char [][] grid) 
    {
        this.grid = grid;
    }
    public char[][] getSolution()
    {
        return solution;
    }

    public Level(int row, int column, int difficulty,char[][] grid) 
    {
        this.row = row;
        this.column = column;
        this.difficulty = difficulty;
        this.grid = grid;
        this.solution = solution;
    }
    public Level(int rowcolumn, int rowcolumn2, int i, char[][] easyGrid, char[][] easySolution) {
        //TODO Auto-generated constructor stub
    }
}
