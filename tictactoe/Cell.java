package tictactoe;

	// this represents the most granular level of board that is each cell
	public class Cell {  

	   Moves userMove; // this represents the user input i.e X or O. New cell will be empty. Uses Enum Moves
	   int row, col; // coordinates of the cell in terms of row and column
	 
	   /** Constructor to initialize cell */
	   public Cell(int row, int col) {
	      this.row = row;
	      this.col = col;
	      clear();  // clear content
	   }
	 
	   /** Set content of cell to EMPTY */
	   public void clear() {
		   userMove = Moves.EMPTY;
	   }
	 
	   /** Set content of cell based on user input */
	   public void paint() {
		   if (userMove == Moves.CROSS){
			   System.out.print(" X "); 
		   }
		   else if (userMove == Moves.NOUGHT){
			   System.out.print(" O ");
		   }
		   else
		   {
			   System.out.print("   ");
		   }
	   }
	}

