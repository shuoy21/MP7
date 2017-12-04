
public class Prac9_16_a11 {
	public static void main(String[] args) {
	/*String s1 = "A";
	String s2 = "a";
	//System.out.println(s1.compareTo(s2));
	
	System.out.printf("%7.2f", 123.213); */
		System.out.println("Put in some values");
		String input1 = TextIO.getln();
		
		TextIO.writeFile("Prac9_16_p4.txt");
		
		TextIO.put(input1);
		
		System.out.println("read file");
		TextIO.readUserSelectedFile();
	}
}
