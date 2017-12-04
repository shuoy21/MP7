
public class DiceRoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isUnique = false;
		int dice1;
		int dice2;
		int dice3;
		int count = 0;
		while (!isUnique) {
			dice1 = (int) (Math.random() * 6 + 1);
			dice2 = (int) (Math.random() * 6 + 1);
			dice3 = (int) (Math.random() * 6 + 1);
			isUnique = (dice1 != dice2) && (dice2 != dice3) && (dice3 != dice1);
			count++;
		}
		System.out.println(count);
	}

}
