package tictactoe;
// This is an abstract class which tell to be a player that class has to provide and implementation of moves.
public abstract class Player {

	   // Switch player
	/** Set/change the seed used by computer and opponent */
	   //abstract Moves setSeed(Moves seed);
	 
	   /** Abstract method to get next move. Return int[2] of {row, col} */
	   abstract int[] move(Board currboard,Moves theSeed);  // to be implemented by subclasses
	   
	 
}
