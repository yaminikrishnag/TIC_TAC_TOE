package tictactoe;

//This class represents the instance of a board i.e. 2-D matrix

public class Board {  
	
   // Named-constants for the dimensions
   public static int ROWS = 0;
   public static int COLS = 0;
 
   Cell[][] cells;  //  board is made up of matrix of Cell 
   int currRow, currCol;  // the current row and column represent current cell
 
   /** Constructor to initialize the game board */
   public Board(int boardSize) {
	   ROWS = boardSize;
	   COLS = boardSize;
      cells = new Cell[ROWS][COLS];  // allocate the array
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col] = new Cell(row, col); // allocate element of the array
         }
      }
   }
 
   /** memory allocation for the board and clearing the content of board */
   public void init() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col].clear();  // clear the cell content
         }
      }
   }
 
 
   /** This function draws the lines and dashes to present user with 2-D board*/
   public void paint() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col].paint();   // each cell paints itself
            if (col < COLS - 1) System.out.print("|");
         }
         System.out.println();
         if (row < ROWS - 1) {
            for(int i=1; i<4*ROWS; i++){
            	System.out.print("-");
            }
            System.out.println();
         }
      }
      System.out.println();
   }
}