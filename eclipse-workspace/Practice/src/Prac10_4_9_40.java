import java.util.Scanner;
public class Prac10_4_9_40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] storeNum = new int[100];
		boolean isFinished = false;
		int count = 0;
		while(true) {
			System.out.println("What's your input?");
			Scanner gene = new Scanner(System.in);
			int input = gene.nextInt();
			if (input < 0)
				break;
			storeNum[count] = input;
			count++;
		}
		
		for (int i = count - 1; i >= 0; i--) {
			System.out.print(storeNum[i] + " ");
		}
	}

}
