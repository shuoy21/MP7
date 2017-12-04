package inheritance;

public class InstanceFieldTester extends InstanceField{
	public int x = 1;
	public void computeX(int newX) {
		setX(newX);
		System.out.println(this.x);
		System.out.println(super.x);
	}
}
