package Complement;

import java.util.ArrayList;
/* The role FirstSquare made to acknowledge a square as the first on a board.
 * @param players keeps players at the first square.
*/
public final class FirstSquareR extends SquareR {

	private ArrayList<Player> players = new ArrayList<Player>();
	
	public FirstSquareR (Square s) {
		super(s);
	}
	/* @return true since this role is assigned particularly for the first square.
	*/
	@Override
	public boolean isFirstSquare () {
		return true;
	}
	/* @return value with corresponsively to if one of the players is staying at the first square.
	*/
	@Override
	public boolean isOccupied () {
		return !players.isEmpty();
	}
	/* @param p player that enters the first square that is added to the list.
	*/
	@Override
	public void enter (Player p) {
		players.add(p);
		p.setSquare(square);
	}
	/* @param p player that is going to leave the first square
	*/
	@Override
	public void leave (Player p) {
		players.remove(p);
	}
	
}
