package recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(factorial(5));
		System.out.println(fib(3));
	}
	
	public static int factorial(int N) {
		if (N == 0) {
			return 1;
		} else {
			return N * factorial(N-1);
		}
	}
	public static int fib(int N) {
		int count = 2;
		int first = 1;
		int second = 1;
		while(count < N) {
			int third = first + second;	
			count ++;
			first = second;
			second = third;
		}
		return second;
	}

}
