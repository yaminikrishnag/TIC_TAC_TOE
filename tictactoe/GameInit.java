package tictactoe;

import java.util.Scanner;


public class GameInit {
   private Board board;            // the game board
   private GameState currentState; // the current state of the game (of enum GameState)
   private Moves currentPlayer;     // the current player (of enum Moves)
   private static DiffLevel difficultyLevel; // sets player difficulty (of enum)
   
   private HasWon haswon = new HasWon(); 
   private HumanPlayer hplayer = new HumanPlayer();
   private CompPlayerDiff1 cPlayerDiff1 = new CompPlayerDiff1();
   private CompPlayerDiff2 cPlayerDiff2 = new CompPlayerDiff2(); 
   private CompPlayerDiff3 cPlayerDiff3 = new CompPlayerDiff3(); 
   
   static int humanWinCounter = 0;
   static int compWinCounter = 0;
   static int drawCounter = 0;
   
   private static Boolean gameStop = false;
   private static Boolean firstChance = true;
   private static Moves gameTurn ;
   
   private static Scanner in = new Scanner(System.in);  // input Scanner
 
   public GameInit(int boardSize, DiffLevel difficultyLevel) {
      board = new Board(boardSize);  // allocate game-board
      
      // Initialize the game-board and current status
      initGame();
      if(difficultyLevel==DiffLevel.DIFFICULT){
    	  cPlayerDiff3.initializePreDefinedMoves();
      }
      try
      {
	      // Play the game once. Players CROSS and NOUGHT move alternately.
	      do {
	    	  int[] currmove = new int[2];
		  	   if(currentPlayer==Moves.CROSS){
		    	  currmove = hplayer.move(board,currentPlayer); // update the content, currentRow and currentCol
		  	    }
		  	   else{
		  		   if(difficultyLevel==DiffLevel.EASY){
		  			 currmove = cPlayerDiff1.move(board,currentPlayer); // update the content, currentRow and currentCol   
		  		   }
		  		   else if(difficultyLevel==DiffLevel.MEDIUM){
		  			 currmove = cPlayerDiff2.move(board,currentPlayer); // update the content, currentRow and currentCol 
		  		   }
		  		 else if(difficultyLevel==DiffLevel.DIFFICULT){
		  			 currmove = cPlayerDiff3.move(board,currentPlayer); // update the content, currentRow and currentCol 
		  		   }
		  	   }
	    	  board.cells[currmove[0]][currmove[1]].userMove = currentPlayer;
	          board.currRow = currmove[0];
	          board.currCol = currmove[1];
	    	  board.paint();             // ask the board to paint itself
	          updateGame(currentPlayer); // update currentState
	         // Print message if game-over
	         if (currentState == GameState.X_WON) {
	            System.out.println("'X' won! Bye!");
	            humanWinCounter++;
	         } else if (currentState == GameState.O_WON) {
	            System.out.println("'O' won! Bye!");
	            compWinCounter++;
	         } else if (currentState == GameState.DRAW) {
	            System.out.println("It's a Draw! Bye!");
	            drawCounter++;
	         }

	         // Switch player
	         currentPlayer = (currentPlayer == Moves.CROSS) ? Moves.NOUGHT : Moves.CROSS;
	      } while (currentState == GameState.PLAYING);  // repeat until game-over
      }

      catch(Exception exception)
      {
        System.out.println("Some problem happened please start again");
      }
   }

   public void initGame() {
      board.init();  // clear the board contents
      if(firstChance){
        currentPlayer = Moves.CROSS;      // CROSS plays first
        gameTurn = Moves.CROSS; 
      }
      else{
    	  if(gameTurn == Moves.CROSS){
    		  currentPlayer = Moves.NOUGHT;      // CROSS plays first
    	      gameTurn = Moves.NOUGHT; 
    	  }
    	  else
    	  {
    		  currentPlayer = Moves.CROSS;      // CROSS plays first
    	      gameTurn = Moves.CROSS; 
    	  }
      }
      currentState = GameState.PLAYING; // ready to play
   }
 
 
   public void updateGame(Moves theSeed) {
	  Boolean won = haswon.hasWon(board,board.currRow ,board.currCol,theSeed);
      if (won) {  // check for win
         currentState = (theSeed == Moves.CROSS) ? GameState.X_WON : GameState.O_WON;
      } else if (haswon.isDraw(board)) {  // check for draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
   public static void main(String[] args) {
	 try{
	   do {
				  System.out.print("Enter number to declare board Size : \n");
				  int bSize = in.nextInt();//Integer.parseInt(System.console().readLine());
				  System.out.println("Enter the level of Difficulty: 1 for Easy, 2 for Medium, 3 for Hard");
				  int diff=in.nextInt();
				  switch (diff){
					  case 1:
						  difficultyLevel = DiffLevel.EASY;
						  break;
					  case 2:
						  difficultyLevel = DiffLevel.MEDIUM;
						  break;
					  case 3:
						  difficultyLevel = DiffLevel.DIFFICULT;
						  break;
						  
					  default:
						  System.out.println("Invalid input");
						  break;
				  }
				  new GameInit(bSize, difficultyLevel);  // Let the constructor do the job
				  firstChance = false;
				  System.out.print("Do you want to play another game: 1 for Yes , 0 for NO");
				  int gameConti=in.nextInt();
				  if(gameConti==0){
					  gameStop = false; 
					  System.out.print("-----------Game Statistics----------");
					  String result = String.format("You Won: %1$d Computer Won: %2$d Draw: %3$d",humanWinCounter,compWinCounter,drawCounter);
					  System.out.print(result);
					  if(humanWinCounter>compWinCounter)
					  {
						  System.out.print("\n\n You won the championship");
					  }
					  else if(humanWinCounter<compWinCounter){
						  System.out.print("\n\n Computer won the championship.");
					  }
					  else
					  {
						  System.out.print("\n\n Championship was draw.");
					  }
					  break;
				  }
	   }while(!gameStop);
	 }

     catch(Exception exception)
     {
       System.out.println("Some problem happened please start again");
     }
	 
	  
   }
}
