
public class calculator {

	public static void main(String[] args) {
		/*int x = -1;
		int y = -1;
		double z = Math.pow(x,4) + Math.pow(y,4) - 4 * x * y + 4;
		System.out.println(z);
	}*/
	double max = Double.MIN_NORMAL;
	double current = 0;
	double x = 0;
	double y = 0;
	for (double i = 0; i <= 3;  i += 0.001) {
		for (double j = 0; j <= 2; j+= 0.01) {
			current = Math.pow(i,4) + Math.pow(j ,4) - 4 * i * j + 4;
			if (current > max) {
				max = current;
				x = i;
				y = j;
			}
			}
		}
	System.out.println(x + " " + y);
	}
}

