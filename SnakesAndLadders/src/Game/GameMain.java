package Game;

import Complement.Game;

public class GameMain {

	public static void main(String[] args) {
		
		String[] players = {"Me", "You"};
		int[][] laddersFromTo = {{12, 20}, {25, 32}, {55, 79}, {66, 99}};
		int[][] snakesFromTo = {{10, 5}, {11, 6}, {44, 23}, {77, 46}, {95, 83}, {98, 94}};
		
		Game play = new Game (players, laddersFromTo, snakesFromTo);
		play.play();
	}

}