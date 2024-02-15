
import java.util.Scanner;		//Import the Random class
import java.util.Random;		//Import the Scanner class 

public class JPEVsudokuGame
{



	private static final int SIZE = 4; 							//size of the sudoku game
	private static final char EMPTY = 'X';						//Character for the empty slot
	private static final int[][] Grid = new int[SIZE][SIZE];	//Actual susdoku grid
	private static final Random random = new Random();      	//Randomizer

	public static void main(String args[])						//Main
	{

	int i;
	int j;
	
	for( i = 0; i < SIZE; i++)						//Loop through each Row
	{
		for( j = 0; j < SIZE; j++)					//Loop through each Column
		{
			Grid[i][j] = random.nextInt(4) + 1;		//Create the ranom numbers from 1 through 4 
		}
	}

	System.out.println("______________");
	

	for(i = 0; i < SIZE; i++)					//Loop through each Row
	{
		System.out.print("|");

		for(j = 0; j < SIZE; j++)				//Loop through each Column
		{
			if(Grid[i][j] == 0)					//If the slot is empty
			{
				System.out.print(EMPTY + " ");	//Print EMPTY Symbol X
			}
				else
				{
					System.out.print(Grid[i][j] + " ");		//Print the value of the slot
				}
					if((j +1 ) % Math.sqrt(SIZE) == 0)		//Seprate it vertically
					{
						System.out.print("| ");
					}
		}
		System.out.println();

		if((i + 1) % Math.sqrt(SIZE) == 0)					// Seperate horizontally 
		{
			System.out.println("______________");
		}
			
	}
	

	}
}
