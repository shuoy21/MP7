package inheritance;
import java.awt.Rectangle;
public class Square extends Rectangle{

	public Square(int x, int y, int sideLength) {
		super(x, y, sideLength, sideLength);
	}
	public void setLocation(int x, int y) {
		super.setLocation(x, y);
		//System.out.println(getLocation());
	}
	public void setSize(int size) {
		super.setSize(size, size);
	}
	public double getArea() {
		return getWidth() * getHeight();
	}
}
