
public class HexTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int decimal = 3;
		System.out.println(Integer.toBinaryString(0x2d5b7d0f));
		System.out.println(Integer.toBinaryString(0x2d5b7d3f));
		//System.out.println(decimal<<1);
		//System.out.println(0x123 == 291);
		//int num1 = 0x2d5b7d0f >> 16;
		//int num2 = 0x2d5b7d3f >> 16;
		//System.out.println(num2 - num1);
		//System.out.println(0xd6b5f695);
		//System.out.println(0x285dd10);
		System.out.println(Integer.valueOf("110000",2));
		int sum = 0x76c456a3 + 164;
		if (sum > 225)
			sum = 225;
		System.out.println(Integer.toHexString(sum);
	}

}
