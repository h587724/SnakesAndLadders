package Complement;

import java.util.LinkedList;

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
	
	private void createBoard (int nSquares, int [][] ladders, int [][] snakes) {
		board = new Board (nSquares, ladders, snakes);
	}
	
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
	
	private void startGame() {
		placePlayersAtFirstSquare();
		winner = null;
	}
	
	private void placePlayerAtFirstSquare (Player p) {

		board.firstSquare().enter(p);
	}
	
	private void placePlayersAtFirstSquare () {
		System.out.println("We are all set!");
		for (Player player : players) {
			board.firstSquare().enter(player);
		}
	}
	
	private boolean notOver () {
		return winner == null;
	}
	
	public Player current () {
		assert players.size() > 0;
		return players.peek();
	}
	
	private void movePlayer (int roll) {
		Player current = players.remove();
		current.moveForward(roll);
		players.add(current);
		if (current.wins()) {
			winner = current;
		}
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
