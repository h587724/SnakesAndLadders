package Complement;
/* Abstract class that manages all the transitions made by players between children squares according to their roles.
 * 
 * @param square the current square
*/
public abstract class SquareR {

	protected Square square = null;
	/* @constructor
	 * 
	 * @param s a parsed square
	*/
	public SquareR (Square s) {
		assert s != null;
		square = s;
	}
	/* @return boolean if the square is occupied by a player or not.
	*/
	public boolean isOccupied() {
		return square.getPlayer() != null;
	}
	/* @return boolean false since the square's role is decided later and the respective squares return relevant information. 
	*/
	public boolean isFirstSquare () {
		return false;
	}
	/* @return boolean false since the square's role is decided later and the respective squares return relevant information. 
	*/
	public boolean isLastSquare () {
		return false;
	}
	/* First, the method checks if such transition can be performed or not by comparing the bounds to the current state of players.
	 * Then, the method sends a signal to other method to either perform the demanded transition or send the player to the first square.
	 * 
	 * @param m keeps the distance to the next square a player has to land at.
	 * 
	 * @return Square returns the square at which a player land eventually.
	*/
	public Square moveAndSettle (int m) {
		int lastPos = square.findLastSquare().getPosition();
		int currentPos = square.getPosition();
		if (currentPos + m > lastPos) {
			System.out.println("You are going off the bounds, to win the game you need to thow " + (lastPos - currentPos));
			return square;
		} else {
			System.out.println("Moving from " + (square.getPosition() + 1) + " to " + (square.findRelativeSquare(m).getPosition() + 1));
			return square.findRelativeSquare(m).landHereOrGoHome();
		} 
	}
	/* First, the method checks the availability of the square a player has to land at after a transition is performed.
	 * Second, depending on the output of the first check, returns the square player will land at eventually.
	 * 
	 * @return Square square at which a player is going to land after the check for availability is performed.
	*/
	public Square landHereOrGoHome() {
		if (square.isOccupied()) {
			System.out.println("square " + (square.getPosition() + 1) + " is already occupied! You go back!");
		} else {
			System.out.println("landing at " + (square.getPosition() + 1));
		}
		return square.isOccupied() ? square.findFirstSquare() : square;//findFirstSquare()
	}
	/* @param p the player that is going to settle at the square
	*/
	public void enter (Player p) {
		square.setPlayer(p);
		p.setSquare(square);
	}
	/* @param p the player that is going to leave the square, so the square becomes vacant.
	*/
	public void leave (Player p) {
		square.setPlayer(null);
	}
}
