package Complement;

import java.util.Random;

public final class Dice {
	
	private int maxValue;
	
	public Dice (int max) {
		this.maxValue = max;
	}
	
	public int Roll () {
		Random m = new Random();
		return m.nextInt(maxValue) + 1;
	}
	
}
