
public class Dice {
	private int die1;
	private int die2;
	private int total;
	public Dice() {
		die1 = (int)(Math.random() * 6 + 1);
		die2 = (int)(Math.random() * 6 + 1);
	}
	public int total() {
		total = die1 + die2;
		return total;
	}
}
