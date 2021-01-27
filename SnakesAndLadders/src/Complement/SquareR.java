package Complement;

public abstract class SquareR {

	protected Square square = null;
	
	public SquareR (Square s) {
		assert s != null;
		square = s;
	}
	
	public boolean isOccupied() {
		return square.getPlayer() != null;
	}
	
	public boolean isFirstSquare () {
		return false;
	}
	
	public boolean isLastSquare () {
		return false;
	}
	
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
	
	public Square landHereOrGoHome() {
		if (square.isOccupied()) {
			System.out.println("square " + (square.getPosition() + 1) + " is already occupied! You go back!");
		} else {
			System.out.println("landing at " + (square.getPosition() + 1));
		}
		return square.isOccupied() ? square.findFirstSquare() : square;//findFirstSquare()
	}
	
	public void enter (Player p) {
		square.setPlayer(p);
		p.setSquare(square);
	}
	
	public void leave (Player p) {
		square.setPlayer(null);
	}
}
