package Complement;

public class Player {
	
	private String name;
	private Square square = null;
	
	public Player (String name) {
		this.name = name;
	}
	
	public Player () {
		this.name = "Unknown player";
	}
	
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
	
	public boolean wins () {
		return square.isLastSquare();
	}
	
	public void moveForward (int moves) {
		assert moves > 0;
		square.leave(this);
		square = (Square) square.moveAndSettle(moves);
		square.enter(this);
	}
}
