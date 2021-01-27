package Complement;

import java.util.ArrayList;

public final class Board {
	
	private ArrayList<Square> squares = new ArrayList<Square>();
	
	public Board (int nSquares, int [][] ladders, int [][] snakes) {
		createSquares(nSquares);
		createLadders(ladders);
		createSnakes(snakes);
	}
	
	private void createSquares (int n) {
		for (int i = 0; i < n; i++) {
			Square square = new Square (i, this);
			square.setSquareRole(new RegularSquareR(square));
			squares.add(square);
		}
		firstSquare().setSquareRole(new FirstSquareR(firstSquare()));
		lastSquare().setSquareRole(new LastSquareR(lastSquare()));
	}
	
	public Square firstSquare () {
		return squares.get(0);
	}
	
	public Square lastSquare () {
		return squares.get(squares.size() - 1);
	}
	
	public Square findSquare (int n) { 
		assert (n > 0) && (n < squares.size()) : "out of the board!";
		return squares.get(n);
	}
	
	public int totalSquares() {
		assert !squares.isEmpty();
		return squares.size();
	}
	
	private void createSnakes(int [][] snakes) {
		for (int i = 0; i < snakes.length; i++) {
			assert snakes[i].length == 2;
			int from = snakes[i][0] - 1;//-1
			int to = snakes [i][1] - 1;//-1
			int transport = to - from;
			
			if (to < 0 || to > totalSquares()) {
				System.out.println("Wrong parameters for a snake! It exceeds the bounds! from " + from + ", and to " + to);
				break;
			}
			if (from < 0 || from > totalSquares()) {
				System.out.println("Wrong parameters for a snake! It exceeds the bounds! from " + from + ", and to " + to);
				break;
			}
			
			assert transport < 0 : "Snakes are ment to work another way!";
			
			Square snakeSquare = squares.get(from);
			snakeSquare.setSquareRole(new SnakeR(snakeSquare, transport));
			System.out.println("New snake registred from " + (from + 1) + " to " + (to + 1));
		}
	}
	
	private void createLadders(int [][] ladders) {
		for (int i = 0; i < ladders.length; i++) {
			assert ladders[i].length == 2;
			int from = ladders[i][0] - 1;
			int to = ladders [i][1] - 1;
			int transport = to - from;
			
			if (to < 0 || to > totalSquares()) {
				System.out.println("Wrong parameters for a ledder! It exceeds the bounds! from " + from + ", and to " + to);
				break;
			}
			if (from < 0 || from > totalSquares()) {
				System.out.println("Wrong parameters for a ledder! It exceeds the bounds! from " + from + ", and to " + to);
				break;
			}
			assert transport > 0 : "Ladders are ment to work another way!";
			
			Square ladderSquare = squares.get(from);
			ladderSquare.setSquareRole(new LadderR(ladderSquare, transport));
			System.out.println("New ladder registred from " + (from + 1) + " to " + (to + 1));
			
		}
	}	
}
