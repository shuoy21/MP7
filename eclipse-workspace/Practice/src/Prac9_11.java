
public class Prac9_11 {
	/*enum Table{GLASSES, CALCULATOR, PHONE};
	public static void main(String[] args) {
		Table gla = Table.GLASSES;
		System.out.println(gla.ordinal());
		System.out.print(gla);
	}*/
	public static void main(String[] args) {
	long startTime, endTime;
	startTime = System.currentTimeMillis();
	
	double sideOne = 11;
	double sideTwo = 19;
	double sideThree = Math.sqrt(sideOne * sideOne + sideTwo * sideTwo);
	System.out.println(sideThree);
	
	boolean triangle;
	double ang = 10;
	triangle = ((Math.sin(ang) * Math.sin(ang) + Math.cos(ang) * Math.cos(ang)) == 1);
	System.out.println(triangle);
	
	double num = Math.random();
	System.out.println(num);
	
	endTime = System.currentTimeMillis();
	long progTime = endTime - startTime;
	System.out.println(progTime);
	}
}
