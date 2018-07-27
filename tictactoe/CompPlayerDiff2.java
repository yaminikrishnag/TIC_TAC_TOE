package tictactoe;
//this class represents computer move when difficulty level is MEDIUM

import java.util.ArrayList;
import java.util.Random;


public class CompPlayerDiff2 extends Player // extends CompPlayer {
{
 //This function generates the random number from range 0 - board size for both row and column
 //Checks if the random cell is empty and for that cell if the computer is winning the game
 //If both condition is met returns that cell as the move.
	
	  // TODO - to be implemented
	   @Override
	   public int[] move(Board currboard,Moves theSeed) {
			Random rand = new Random();
			HasWon h = new HasWon();
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
		         //int row = (rand.nextInt((currboard.ROWS - 0) + 0) + 0) - 1;
		         //int col = (rand.nextInt((currboard.COLS - 0) + 0) + 0) - 1;
		    	 if(i<size){
		    		 Select = rand.nextInt(number.size());
			         loc = number.get(Select);
			         number.remove(Select);   
			         row = (int)loc/n;
			         col = (int)loc%n;
			         if (row >= 0 && row < n && col >= 0 && col < n
			               && currboard.cells[row][col].userMove == Moves.EMPTY && h.canWin(currboard, row, col, theSeed,n)) {
			        	  int[] move = new int[2];
			        	  move[0]=row;
			        	  move[1]=col;
			        	  validCell = true; // input okay, exit loop
		                return move;
			         } 
		    		 i++;
		    	 }		
		    	 if(i == size){
		    		 
		    		 Select = rand.nextInt(number1.size());
			         loc = number1.get(Select);
			         number1.remove(Select);   
			         row =(int) loc/n;
			         col = (int) loc%n;
			         if (row >= 0 && row < n && col >= 0 && col < n
			               && currboard.cells[row][col].userMove == Moves.EMPTY) {
			        	  int[] move = new int[2];
			        	  move[0]=row;
			        	  move[1]=col;
			        	  validCell = true; // input okay, exit loop
			        	  i=0;
		                return move;
		    	 }
		      } 
		     }while (!validCell); 
		     i=0;
		      return null;
		   }
	}
