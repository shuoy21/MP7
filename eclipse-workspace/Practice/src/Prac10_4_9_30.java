
public class Prac10_4_9_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// generate a random day
		
		boolean[] used = new boolean[365];
		int count = 0;
		
		while(true) {
			int day = (int) (Math.random() * 365 + 1);
			count++; // count should be placed before break
			if (used[day - 1] == true)
				break;
			used[day-1] = true;
		}
	}

}
