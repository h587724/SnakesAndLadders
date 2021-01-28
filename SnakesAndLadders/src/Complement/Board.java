package Complement;

import java.util.ArrayList;
/* A supplementary class for the class Game. A board of 100 squares being created. 
 * Each square has assigned role such as First square where players land at the beginning, 
 * in case of throwing three 6's, or landing on the square occupied by an opponent.
 * @param squares is a list of 100 squares contained by a Board.
*/
public final class Board {
	
	private ArrayList<Square> squares = new ArrayList<Square>();
	/* @constructor
	 * @param nSquares specifies how many squares there are at the board
	 * @param ladders specifies ladders at the board
	 * @param snakes specifies snakes at the board
	*/
	public Board (int nSquares, int [][] ladders, int [][] snakes) {
		createSquares(nSquares);
		createLadders(ladders);
		createSnakes(snakes);
	}
	/* Creates 100 squares and adds them to the list of squares (@param squares).
	 * Assigns roles for the first added square as firstSquare and to the last respectively.
	 * @param n number of squares added (100 in this case).
	*/
	private void createSquares (int n) {
		for (int i = 0; i < n; i++) {
			Square square = new Square (i, this);
			square.setSquareRole(new RegularSquareR(square));
			squares.add(square);
		}
		firstSquare().setSquareRole(new FirstSquareR(firstSquare()));
		lastSquare().setSquareRole(new LastSquareR(lastSquare()));
	}
	
	/* Setters and getters for key elements in the list
	 * @return the key element
	*/ 
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
	/* Assigns the role of snakes to particular squares parsed in the class Game. Called through the constructor.
	 * @param snakes a two dimensional array of snakes with transport property for the sub-arrays. From and To square respectively
	*/
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
	/* Assigns the role of ladders to particular squares parsed in the class Game. Called through the constructor.
	 * @param ladders a two dimensional array of snakes with transport property for the sub-arrays. From and To square respectively
	*/
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
