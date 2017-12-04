import java.util.Arrays;
public class Prac9_30_3_39_DynamicArray {
	// add element to the end
	//remove element at a specific location
	//get value of one of the elements
	//set value of one of the elements
	//get number of elements in the array
	
	private int[] arr = new int[10];
	private int arraySize = 0;
	
	public void add(int input) {
		if (arraySize <= arr.length)
			arr[arraySize] = input; 
		else {
			int[] tempt = Arrays.copyOf(arr, arr.length * 2);
			arr = tempt;
			arr[arraySize] = input;// this is a redundant method. note that this line is executed twice.
									// set arr = arr[2 * length] first if size = length
		}
		arraySize++;
	}
	
	public void remove(int index) {
		for (int i = index; i < arraySize - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arraySize--;
	}
	
	public int getValue(int index) {
		return arr[index];
	}
	
	public void setValue(int index, int value) {
		arr[index] = value;
	}
	
	public int length() {
		return arraySize;
	}
}
