package recursion;

public class Change {
	public static double[] coins = {10, 5, 2, 1, 0.5, 0.25, 0.1, 0.01};
	public static int ways(double amount, int index) {
		if (amount < 0) {
			return 0;
		}
		if (amount == 0) {
			return 1;
		}
		return ways(amount - coins[index], index) + ways(amount, index + 1);
	}
	public static void main(String args[]) {
		System.out.println("a" + ways(10 ));
	}
}
