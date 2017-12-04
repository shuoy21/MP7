
public class Prac9_30_1_28 {
	
	public static double calculateAverage(int...number) {
		double sum = 0;
		int count = 0;
		for (int num : number) {
			sum += num;
			count++;
		}
		return sum/count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(calculateAverage(arr));
	}

}
