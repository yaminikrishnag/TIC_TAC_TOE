package tictactoe;
import java.util.Scanner;

// This class represent moves of user
public  class HumanPlayer extends Player {
	private static Scanner in = new Scanner(System.in);
	
	//This function takes user input and checks if the user input is correct or not 
	// if user input is fine it will check for empty cell and if cell is empty it will return the move
	// if cell is not empty will ask user another input
	 @Override
	   public int[] move(Board currboard,Moves theSeed) {
	      boolean validCell = false;  // for validating input
	      do {
	         if (theSeed == Moves.CROSS) {
	            System.out.print("Player 'X', enter your move (row[1-"+currboard.cells.length+"] column[1-"+currboard.cells.length+"]): ");
	         }
	         try
	         {
		         int row = in.nextInt() - 1;
		         int col = in.nextInt() - 1;
		         if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
		               && currboard.cells[row][col].userMove == Moves.EMPTY) {
		        	  int[] move = new int[2];
		        	  move[0]=row;
		        	  move[1]=col;
		        	  validCell = true; // input okay, exit loop
	                  return move;
		         } else {
		            System.out.println("This cell (" + (row + 1) + "," + (col + 1)
		                  + ") isn't free or doesnt belong to the board. Please provide another set of inputs");
		         }
	         }
	         catch(Exception exception)
	         {
	           System.out.println("This is not an integer");
	           break;
	         }
	      } while (!validCell);   // repeat until input is valid   
	      return null;
	      
	   }
	 /*@Override
	 public Moves setSeed(Moves seed) {
	      Moves oppSeed;
	      oppSeed = (seed == Moves.CROSS) ? Moves.NOUGHT : Moves.CROSS;
	      return oppSeed;
	   }*/

}
