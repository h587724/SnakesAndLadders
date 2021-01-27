package Complement;

public final class SnakeR extends SquareR {
	
	private int transport;
	
	public SnakeR(Square s, int t) {
		super(s);
		assert t < 0;
		this.transport = t;
	}

	@Override
	public Square landHereOrGoHome () {
		System.out.println("Snake from " + (square.getPosition() + 1) + " to " + (destination().getPosition() + 1) + " has been initiated!");
		return destination().landHereOrGoHome();
	}
	
	private Square destination () {
		return square.findRelativeSquare(transport);
	}
	
}
