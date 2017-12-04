
public class Lecture9_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] oddArray = new int[10];
		int[] oddArray2;
		for (int i = 0; i < oddArray.length;i++) {
			oddArray[i] = i * 2 + 1;
		}
		oddArray[4] = -999;
		oddArray2 = oddArray; // print same values as array, changing oddArray also make changes in oddArray2
		for(int num: oddArray2) { // only useful if your are traversing the entire array
			System.out.print(num + " ");
		}
	}

}
