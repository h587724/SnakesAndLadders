package Complement;

import java.util.LinkedList;
/* The crucial class that handles a creation of a board, registering players,
 * adding snakes, ladders, first, last, and regular squares
 * 
 * @param players a list of players added to the game
 * @param board creates a board of various squares
 * @param winner player that has won a game
 * @param NSQUARES keeps a number of squares on a board
 * @param rollCounter used only to check if a 6 has been thrown once, twice, or three times.
*/
public class Game {
	
	private LinkedList<Player> players = new LinkedList<Player>();
	private Board board = null;
	private Player winner;
	final int NSQUARES = 100;
	int rollCounter = 0;
	
	public Game (String[] names, int[][] ladders, int[][] snakes) {
		createPlayers(names);
		createBoard(NSQUARES, ladders, snakes);
	}
	/* Creates a board
	 * 
	 * @param nSquares keeps number of squares added to the board
	 * @param ladders keeps ladders to be added to the board
	 * @param snakes keeps snakes to be added to the board
	*/
	private void createBoard (int nSquares, int [][] ladders, int [][] snakes) {
		board = new Board (nSquares, ladders, snakes);
	}
	/* Registers players that play the game to the list of players
	 * 
	 * @param Splayers an array of strings containing players that desire to play the game
	*/
	private void createPlayers (String[] Splayers) {
		assert Splayers.length > 0;
		int i = 1;
		for (String name : Splayers) {
			Player player = new Player (name);
			players.add(player);
			System.out.println(i + ". " + name);
			i++;
		}
	}
	/* The essential method that handles the gameplay. A die is created. The players move respective to the roll count.
	 * The game goes on until a winner is defined.
	*/
	public void play () {
		assert !players.isEmpty() : "No players!";
		assert board != null : "Board hasn't been created!";
		Dice die = new Dice (6);
		startGame();
		
		System.out.println("Initial state: \n" + this);
		while (notOver()) {
			int roll = die.Roll();
			while (roll == 6 && rollCounter <=3) {
				rollCounter++;
				System.out.println("You threw a 6, if you get three 6's in the row you're screwed!");
				roll = die.Roll();
				while (roll == 6 && rollCounter <= 3) {
					System.out.println("you got another 6, one more and it's the end!");
					rollCounter++;
					roll = die.Roll();
				}
			}
			if (rollCounter == 3) {
				System.out.println("Good luck! You start all over!");
				placePlayerAtFirstSquare (current());
			} else {
			this.rollCounter = 0;
			System.out.println("Current player is " + current() + " rolls " + roll);
			movePlayer(roll);
			System.out.println("Current state: \n" + this); 
			}
		}
		System.out.println(winner.toString() + " has won");
	}
	/* A complementary method that helps to start the game. 
	*/
	private void startGame() {
		placePlayersAtFirstSquare();
		winner = null;
	}
	/* Sends a command to the first square to accept the player @param p
	*/
	private void placePlayerAtFirstSquare (Player p) {
		board.firstSquare().enter(p);
	}
	/* Used at the beginning. Sets the players at the first square.
	*/
	private void placePlayersAtFirstSquare () {
		System.out.println("We are all set!");
		for (Player player : players) {
			board.firstSquare().enter(player);
		}
	}
	/* A complementary method that returns either the winner is defined or not.
	 * @return winner if the winner defined or not.
	*/
	private boolean notOver () {
		return winner == null;
	}
	/* @return Player that should perform the next turn.
	*/
	public Player current () {
		assert players.size() > 0;
		return players.peek();
	}
	/* Moves the current player forward
	 * @param roll moves a player by the given outcome of a die roll
	*/
	private void movePlayer (int roll) {
		Player current = players.remove();
		current.moveForward(roll);
		players.add(current);
		if (current.wins()) {
			winner = current;
		}
	}
	/* Classes made for the test class to extract the players and register a game without initiating it
	*/
	public LinkedList getPlayersTest() {
		return players;
	}
	
	public void playTest () {
		assert !players.isEmpty() : "No players!";
		assert board != null : "Board hasn't been created!";
		startGame();
	}
	
	@Override
	public String toString() {
		String output = "";
		for (Player p : players) {
			output += p.getName() + " is at " + (p.position() + 1) + "\n";
		}
		return output;
	}
}
