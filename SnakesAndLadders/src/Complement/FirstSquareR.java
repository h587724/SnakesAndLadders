package Complement;

import java.util.ArrayList;

public final class FirstSquareR extends SquareR {

	private ArrayList<Player> players = new ArrayList<Player>();
	
	public FirstSquareR (Square s) {
		super(s);
	}
 
	@Override
	public boolean isFirstSquare () {
		return true;
	}
	
	@Override
	public boolean isOccupied () {
		return !players.isEmpty();
	}
	
	@Override
	public void enter (Player p) {
		players.add(p);
		p.setSquare(square);
	}
	
	@Override
	public void leave (Player p) {
		players.remove(p);
	}
	
}
