
public class Prac10_9_3_20 {

	public static void main(String[] args) {
		/*int[] a = {7,5,2,3};
		int[] b = {9, 3, 8, 2};
		for (int eleB: b) {
			for (int eleA: a) {
				if (eleB == eleA) {
					System.out.println(eleB);
					break;
				}
			}
		}
	}*/
		int[] a = {2, 3, 7, 9};
		int [] b = {1, 2, 4};
		int ai = 0;
		int bj = 0;
		int count = 0;
		int[] c = new int[a.length + b.length];
		while (ai < a.length && bj < b.length) {
			//System.out.println(ai + " " + bj);
			if (a[ai] <= b[bj]) {
				c[count] = a[ai];
				ai++;
			}
			else {
				c[count] = b[bj];
				bj++;
			}
			count++;
		}
		if (ai < a.length - 1) {
			for (; ai < a.length; ai++)
			c[count] = a[ai];
		}
		if (bj < b.length - 1) {
			for (; bj < b.length; bj++)
			c[count] = b[bj];
		}
		for (int i: c) {
			System.out.println(i);
		}
}
}
