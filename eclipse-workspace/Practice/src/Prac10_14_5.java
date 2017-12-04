import java.util.Scanner;
public class Prac10_14_5 {
	public  int test = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean play = false;
		int target = 10;
		do {
			System.out.println("do you want to play a game?");
			Scanner gene = new Scanner(System.in);
			if (gene.equals("yes"))
				play = false;
			//playGame(target);
		}while (play);
		System.out.println(test);
		}

	public static void playGame(int target) {
			for (int i = 0; i < 6; i++) {
			Scanner gene = new Scanner(System.in);
			System.out.println("guess a number");
			int input = gene.nextInt();
			if (input == target) {
				System.out.println("you won!");
				break;
			}	else if (input > target)
				System.out.println("too big");
			else 
			System.out.println("too small");
			}
	}

}
