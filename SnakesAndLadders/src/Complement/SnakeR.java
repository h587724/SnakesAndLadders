package Complement;
/* A class that inherits the abstract class SquareR. Defines the role for a square as Snake,
 * thus it keeps an attribute that is responsible for the transport function of the snake square.
 * @param transport keeps the number of squares a player goes back if the snake is initiated
*/
public final class SnakeR extends SquareR {
	
	private int transport;
	/* @constructor 
	 * 
	 * @param s is an initial pre-created square which's role is being replaced with the snake role.
	 * @param t defines the transport function.
	*/
	public SnakeR(Square s, int t) {
		super(s);
		assert t < 0;
		this.transport = t;
	}
	/* Method that is responsible for handling the snake routine: check if the destination square is occupied or not.
	 * If the destination is occupied, players goes to the start.
	 * @return Square the square at which a player lands after the snake initiated.
	*/
	@Override
	public Square landHereOrGoHome () {
		System.out.println("Snake from " + (square.getPosition() + 1) + " to " + (destination().getPosition() + 1) + " has been initiated!");
		return destination().landHereOrGoHome();
	}
	/* Finds the destination square
	 * @return Square the target square after the transport 
	*/
	private Square destination () {
		return square.findRelativeSquare(transport);
	}
	
}
