import java.util.Arrays;
public class Prac10_28 {

	public static void swap(int[] board) {
		board = new int[2];
		board[0] = 2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] board = {1, 2, 3, 4};
		swap(board);
		System.out.println(Arrays.toString(board));
	}

}
