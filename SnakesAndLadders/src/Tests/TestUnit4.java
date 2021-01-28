package Tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import Complement.Game;
import Complement.Player;

public class TestUnit4 {

	
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		String[] players = {"blya", "You"};
		int[][] laddersFromTo = {{12, 20}, {25, 32}, {55, 79}, {66, 99}};
		int[][] snakesFromTo = {{10, 5}, {11, 6}, {44, 23}, {77, 46}, {95, 83}, {98, 94}};
		Game play = new Game (players, laddersFromTo, snakesFromTo);
		play.playTest();
	}

}


