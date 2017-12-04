
public class Prac9_17_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 'a';
		System.out.println(a == 'a');
		if (a != 0)
			if (a != 1)
				System.out.println("works!");
		System.out.println(4 % -3);
		int x = 3;
		//System.out.println(++x);
		
		int N = 3;
		double next = (N % 2 == 0) ? (N/2) : (3*N+1);
		System.out.print(next);
	}

}
