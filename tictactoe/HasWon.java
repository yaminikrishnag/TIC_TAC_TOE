package tictactoe;

//This class check both winning and draw condition on current board and current user action

public class HasWon {
	
	// Checks if the board has consecutive marks with current user move
	//TODO - At present works only for 3X3 board need to update
	public boolean hasWon(Board currboard, int currentRow, int currentCol,Moves move) {
		int n= currboard.cells.length, i;
		Boolean status,rowCheck = true, colCheck = true, diaCheck = true, revDiaCheck = true;
		/*Boolean status = currboard.cells[currentRow][0].userMove == move         // 3-in-the-row
        && currboard.cells[currentRow][1].userMove == move
        && currboard.cells[currentRow][2].userMove == move
   || currboard.cells[0][currentCol].userMove == move      // 3-in-the-column
        && currboard.cells[1][currentCol].userMove == move
        && currboard.cells[2][currentCol].userMove == move
   || currentRow == currentCol            // 3-in-the-diagonal
        && currboard.cells[0][0].userMove == move
        && currboard.cells[1][1].userMove == move
        && currboard.cells[2][2].userMove == move
   || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
        && currboard.cells[0][2].userMove == move
        && currboard.cells[1][1].userMove == move
        && currboard.cells[2][0].userMove == move;*/
		for(i=0;i<n;i++){
			if(currboard.cells[currentRow][i].userMove == move){
				rowCheck = rowCheck&&true;
			}
			else{
				rowCheck = rowCheck&&false;
				break;
			}
		}
		for(i=0;i<n;i++){
			if(currboard.cells[i][currentCol].userMove == move){
				colCheck = colCheck&&true;
			}
			else{
				colCheck = colCheck&&false;
				break;
			}
		}
		for(i=0;i<n;i++){
			if(currboard.cells[i][i].userMove == move){
				diaCheck = diaCheck&&true;
			}
			else{
				diaCheck=rowCheck&&false;
				break;
			}
		}
		for(i=0;i<n;i++){
			if(currboard.cells[i][n-i-1].userMove == move){
				revDiaCheck=revDiaCheck&&true;
			}
			else{
				revDiaCheck=revDiaCheck&&false;
				break;
			}
		}
		status = rowCheck || colCheck || ((currentRow == currentCol)&& diaCheck) ||((currentRow + currentCol == n-1) && revDiaCheck);
       return status;
	}
	public boolean canWin(Board currboard, int currentRow, int currentCol,Moves move, int n){
		int i;
		Boolean status,rowCheck = true, colCheck = true, diaCheck = true, revDiaCheck = true;
		for(i=0;i<n;i++){
			if(i!=currentCol){
				if(currboard.cells[currentRow][i].userMove == move){
					rowCheck = rowCheck&&true;
				}
				else{
					rowCheck = rowCheck&&false;
					break;
				}
			}			
		}
		for(i=0;i<n;i++){
			if(i!=currentRow){
				if(currboard.cells[i][currentCol].userMove == move){
					colCheck = colCheck&&true;
				}
				else{
					colCheck = colCheck&&false;
					break;
				}
			}
		}
		for(i=0;i<n;i++){
			if(i!=currentCol&&i!=currentRow){
				if(currboard.cells[i][i].userMove == move){
					diaCheck = diaCheck&&true;
				}
				else{
					diaCheck=rowCheck&&false;
					break;
				}
			}
		}
		for(i=0;i<n;i++){
			if(n-1-i!=currentCol&&i!=currentRow){
				if(currboard.cells[i][n-i-1].userMove == move){
					revDiaCheck=revDiaCheck&&true;
				}
				else{
					revDiaCheck=revDiaCheck&&false;
					break;
				}
			}
		}
		status = rowCheck || colCheck || ((currentRow == currentCol)&& diaCheck) ||((currentRow + currentCol == n-1) && revDiaCheck);
		return status;
		
	}
	
	   //Checks if the game is draw
	   public boolean isDraw(Board currboard) {
	      for (int row = 0; row < Board.ROWS; ++row) {
	         for (int col = 0; col < Board.COLS; ++col) {
	            if (currboard.cells[row][col].userMove == Moves.EMPTY) {
	               return false; // game is not draw as there is an empty cell present on board
	            }
	         }
	      }
	      return true; // game is draw since there are no empty cells
	   }
	 

}
