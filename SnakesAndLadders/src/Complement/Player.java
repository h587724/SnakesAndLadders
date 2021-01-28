package Complement;
/* Class that keeps the relevant information about current states of players.
 * 
 * @param name keeps a player's name
 * @param square keeps a square the player is at.
*/
public class Player {
	
	private String name;
	private Square square = null;
	/* @constructor
	*/
	public Player (String name) {
		this.name = name;
	}
	
	public Player () {
		this.name = "Unknown player";
	}
	/* Getters and setters
	*/
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public Square getSquare () {
		return square;
	}
	 
	public void setSquare (Square square) {
		this.square = square;
	}
	
	public int position () {
		return square.getPosition();
	}
	
	@Override
	public String toString () {
		return name + " ";
	}
	/* @return boolean if the player is at the last square and has won or not.
	*/
	public boolean wins () {
		return square.isLastSquare();
	}
	/* The player leaves his current square and moves to the next one distanced from the initial
	 * by the number drawn after throwing a die
	 * @param moves keeps the distance to the next square.
	*/
	public void moveForward (int moves) {
		assert moves > 0;
		square.leave(this);
		square = (Square) square.moveAndSettle(moves);
		square.enter(this);
	}
}
