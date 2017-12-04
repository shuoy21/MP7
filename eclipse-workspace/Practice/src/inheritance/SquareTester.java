package inheritance;

public class SquareTester {
	public static void main(String args[]) {
	Square obj = new Square(1, 1, 10);
	obj.setLocation(5, 5);
	obj.setSize(10);
	System.out.println(obj.getLocation());
	System.out.println(obj.getSize());
	System.out.println(obj.getArea());
	System.out.println(obj.toString());
	}
}
