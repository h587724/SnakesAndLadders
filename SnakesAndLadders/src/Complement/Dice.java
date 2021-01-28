package Complement;

import java.util.Random;
/* Throw a die
*/
public final class Dice {
	
	private int maxValue;
	
	public Dice (int max) {
		this.maxValue = max;
	}
	/* Rolls a die
	 * @return an integer in the range from 1 to 6;
	*/
	public int Roll () {
		Random m = new Random();
		return m.nextInt(maxValue) + 1;
	}
	
}
