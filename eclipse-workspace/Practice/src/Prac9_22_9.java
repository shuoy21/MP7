
public class Prac9_22_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0;
		int count = 0;
		
		/*System.out.println("enter a value");
		int input = TextIO.getlnInt();
		while(input != 0) {
			sum += input;
			count++;
			System.out.println("enter a value");
			input = TextIO.getlnInt();
		}*/
		int input = 0;
		mainloop: while(true) {
			System.out.println("enter a value");
			input = TextIO.getlnInt();
			if(input == 0)
				break mainloop;
			sum+= input;
			count++;
		} 
		
		if(count!= 0)
			System.out.println(sum / count);
		else
			System.out.println("no number entered");
	}

}
