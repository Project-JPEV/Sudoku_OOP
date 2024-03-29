public class Level 
{
    private int row;
    private int column;
    private char[][] grid;
    private int difficulty;

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

    public Level(int row, int column, int difficulty,char[][] grid) 
    {
        this.row = row;
        this.column = column;
        this.difficulty = difficulty;
        this.grid = grid;
    }
}
