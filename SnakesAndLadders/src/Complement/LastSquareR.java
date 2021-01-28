package Complement;
/* Class that assigns the role of the last square to the last square.
*/
public final class LastSquareR extends SquareR {
	/* @constructor
	*/
	public LastSquareR(Square s) {
		super(s);
	}
	/* @return boolean returns true because this role is assigned only to the last square, so it's always the last element on a board.
	*/
	@Override
	public boolean isLastSquare () {
		return true;
	}
	
}
