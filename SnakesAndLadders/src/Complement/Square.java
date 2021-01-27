package Complement;

public class Square {

	private Board board = null;
	private Player player = null;
	private int position;
	private SquareR squareRole = null;

	public Square (int pos, Board b) {
		assert pos > 0;
		this.position = pos;
		this.board = b;
	}
	
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

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isLastSquare() {
		return squareRole.isLastSquare();
	}

	public boolean isOccupied() {
		return squareRole.isOccupied();
	}

	public int getPosition() {
		return position;
	}

	public Square moveAndSettle (int moves) {
		return squareRole.moveAndSettle(moves);
	}

	public Square landHereOrGoHome () {
		return squareRole.landHereOrGoHome();
	}
	
	public void enter (Player p) {
		squareRole.enter(p);
	}
	
	public void leave (Player p) {
		squareRole.leave(p);
	}
	
	public Square findRelativeSquare (int moves) {
		return board.findSquare(moves + position);
	}
	
	public Square findFirstSquare () {
		return board.firstSquare();
	}
	
	public Square findLastSquare () {
		return board.lastSquare();
	}
	
}
