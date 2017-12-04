
public class Prac9_27_8am {
	
	public static void average(int order,int...numbers) {
		double sum = 0;
		int count = numbers.length;
		for (int num: numbers) {
			System.out.println(order + " " + num);
		}
	}
	public static void bufferTest(String...strings) {
		StringBuffer buffer = new StringBuffer("This is string buffer test.");
		for (String ele: strings) {
			buffer.append(ele);
		}
		System.out.println(buffer.charAt(0));
		System.out.println(buffer.toString());
		System.out.println(buffer.toString() + 1);
	}
	public static void main(String args[]) {
		//int[] arr1 = {1, 2, 3, 4, 5};
		//for (int num: arr1)
		//	System.out.println(num);
		//average(0, 2, 3, 4);
		//bufferTest("hello", "world!");
		int[] num1 = new int[] {1, 2, 3};
		int[] num2 = {1, 2, 3};
		int[] num3 = {1, 2, 3};
		System.out.println(new int[]{1, 2, 3} == new int[]{1, 2, 3});
	}
}
