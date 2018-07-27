package tictactoe;
import java.util.ArrayList;
import java.util.Random;

// this class represents computer move when difficulty level is EASY
public class CompPlayerDiff1 extends Player {
	
//This function generates the random number from range 0 - boardsize for both row and column
//Checks if the random cell is empty and returns that cell as the move.
	
	@Override
	   public int[] move(Board currboard,Moves theSeed) {
		Random rand = new Random();
		boolean validCell = false;  // for validating input
		ArrayList<Integer> number = new ArrayList<Integer>();
		ArrayList<Integer> number1 = new ArrayList<Integer>();
		int n = Board.ROWS, row, col, i, Select, loc;
		int size=n*n;
         for(i=0;i<size;i++){
             number.add(i);
             number1.add(i);
         }
         i=0;
	     do {
	    	 if(i<size){
	    		 Select = rand.nextInt(number.size());
		         loc = number.get(Select);
		         number.remove(Select);   
		         row = (int)loc/n;
		         col = (int)loc%n;
		         if (row >= 0 && row < n && col >= 0 && col < n
		               && currboard.cells[row][col].userMove == Moves.EMPTY) {
		        	  int[] move = new int[2];
		        	  move[0]=row;
		        	  move[1]=col;
		        	  validCell = true; // input okay, exit loop
	                return move;
		         } 
	    		 i++;
	    	 }		
	     }while (!validCell); 
	     i=0;
	      return null;
	   }
}
