package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Complement.Game;

class snakesAndLeddersTests {
	
	private String[] players = {"blya", "You"};
	private int[][] laddersFromTo = {{12, 20}, {25, 32}, {55, 79}, {66, 99}};
	private int[][] snakesFromTo = {{10, 5}, {11, 6}, {44, 23}, {77, 46}, {95, 83}, {98, 94}};
	private Game play;
	
	@BeforeEach
	void setUp() throws Exception {
		play = new Game (players, laddersFromTo, snakesFromTo);
		play.playTest();
	}

	@Test
	void test1() {
		assertEquals(1, 1);
	}

}
