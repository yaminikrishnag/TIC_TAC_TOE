package tictactoe;

import java.util.ArrayList;
import java.util.Random;

//this class represents computer move when difficulty level is DIFFICULT
public class CompPlayerDiff3  extends Player {
	 
	   // this is the pre defined list of moves which computer will play
	   // Assumption is that from past experience these moves result in win
	  // private int[][] preferredMoves = {
	        // {1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2},
	        // {0, 1}, {1, 0}, {1, 2}, {2, 1}};
	 
	int[][] preferredMoves ; 

	public void initializePreDefinedMoves() {
		
		   int loopSize = (Board.ROWS*Board.COLS)+5 ;
		   double midPoint = (long)Board.ROWS/2;
		   preferredMoves = new int[loopSize][2]; 
			
			int[] move0 = {(int)midPoint,(int)midPoint};
			int[] move1 = {0,0};
			int[] move2 = {0,Board.ROWS-1};
			int[] move3 = {Board.ROWS-1,0};
			int[] move4 = {Board.ROWS-1,Board.ROWS-1};
			
			preferredMoves[0]= move0;
			preferredMoves[1]= move1;
			preferredMoves[2]= move2;
			preferredMoves[3]= move3;
			preferredMoves[4]= move4;
			int currItem=5;

			for(int i=0; i<Board.ROWS; i++){
				for(int j=0; j<Board.ROWS; j++){
				        int[] move = {i,j};
					    if(currItem!= (loopSize-1)){
					     preferredMoves[currItem] = move;
					     currItem = currItem+1;
					     }
				}
			 }

    }
	
 //Irrespective of the move of user computer player these moves and tries to win the match or draw the match
	   @Override
	   public int[] move(Board currboard,Moves theSeed) {
		  Random rand = new Random();
		  HasWon h = new HasWon();
		  ArrayList<Integer> number = new ArrayList<Integer>();
		  int n = Board.ROWS, row, col, i, Select, loc,k=0;
		  int size=n*n;
		  int[] moves = new int[2]; 
	      for(i=0;i<size;i++){
	             number.add(i);
	      }
	      for(i=0;i<size;i++){
	    	  Select = rand.nextInt(number.size());
		      loc = number.get(Select);
		      number.remove(Select);   
		      row = (int)loc/n;
		      col = (int)loc%n;
		      if(row >= 0 && row < n && col >= 0 && col < n
		               && currboard.cells[row][col].userMove == Moves.EMPTY && h.canWin(currboard, row, col, Moves.CROSS,n)){
	        	  moves[0]=row;
	        	  moves[1]=col;
	        	  k=1;
	        	  break;
		      }
	      }
	      if(k==1){
	    	  return moves;
	      }
	      else{
	    	  for (int[] move : preferredMoves) {
	 	         if (currboard.cells[move[0]][move[1]].userMove == Moves.EMPTY) {
	 	            return move;
	 	         }
	 	      }
	 	      assert false : "No empty cell?!";
	 	      return null;
	      }
	   }
}