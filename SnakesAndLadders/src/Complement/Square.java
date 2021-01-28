package Complement;
/* Class which is responsible for registering squares on a board as well as squares' roles.
 * 
 * @param board the board a game is played, and squares located at.
 * @param player a player that is on a square.
 * @param position the square's index at the board.
 * @param SquareR defines the square's role in the game.
*/
public class Square {

	private Board board = null;
	private Player player = null;
	private int position;
	private SquareR squareRole = null;
	/* @constructor
	 * @param pos defines the square's index at the board.
	 * @param b defines the board the square belongs to.
	*/
	public Square (int pos, Board b) {
		assert pos > 0;
		this.position = pos;
		this.board = b;
	}
	/* Getters and Setters
	*/
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player; 
	}

	public SquareR getSquareRole() {
		return squareRole;
	}

	public void setSquareRole(SquareR squareRole) {
		assert squareRole != null;
		this.squareRole = squareRole;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	/* @return boolean respective to if the square's role is defined as the last square at the board.
	*/
	public boolean isLastSquare() {
		return squareRole.isLastSquare();
	}
	/* @return boolean respective to if the square is occupied or not
	*/
	public boolean isOccupied() {
		return squareRole.isOccupied();
	}
	/* @param moves the number that shows the distance to the next square a player land at.
	 * 
	 * @return Square returns the next square after a move performed.
	 * The role of a square is taken into consideration and triggered afterwards.
	*/
	public Square moveAndSettle (int moves) {
		return squareRole.moveAndSettle(moves);
	}
	/* Checks the next square after the transition (triggered by moveAndSettle) for availability and decides 
	 * to either settle at the new square or go to the first square.
	 * 
	 * @return Square at which a player land at eventually.
	*/
	public Square landHereOrGoHome () {
		return squareRole.landHereOrGoHome();
	}
	/* Makes a square occupied as a player has entered that square.
	 * 
	 * @param p the player that enters the square.
	*/
	public void enter (Player p) {
		squareRole.enter(p);
	}
	/* Removes a player from a square. Makes it available for other players to enter.
	 * 
	 * @param p the player that leaves the square.
	*/
	public void leave (Player p) {
		squareRole.leave(p);
	}
	/* Finds a square distanced from the current square by the given moves to check its availability and role later.
	 * 
	 * @param moves defines the distance to the next square a player want to land at.
	 * @return Square returns the next square.
	*/
	public Square findRelativeSquare (int moves) {
		return board.findSquare(moves + position);
	}
	/* @return Square returns the first square at the board.
	*/
	public Square findFirstSquare () {
		return board.firstSquare();
	}
	/* @return Square returns the last square at the board.
	*/
	public Square findLastSquare () {
		return board.lastSquare();
	}
	
}
