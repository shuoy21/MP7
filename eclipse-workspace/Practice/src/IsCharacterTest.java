import java.util.Arrays;

public class IsCharacterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] characters = {'a','a','b','c','d'};
		final int uniNumber = 226;
        int[] unicodeRepre = new int[uniNumber]; //226
        Arrays.fill(unicodeRepre, 0);
        for (int i = 0; i < characters.length; i++) {
        		char character = characters[i];
            if (Character.isLetter(character)) {
                int unicode = (int) character;
                unicodeRepre[unicode] = unicodeRepre[unicode] + 1;
            }
        }
        for (int ele: unicodeRepre)
        		System.out.println(ele);
	}
}
