import java.io.File;
import java.net.URI;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A class that determines the character distribution in string.
 * <p>
 * Analyzing character counts is a straightforward way to break any simple substitution cipher.
 * Given a large enough corpus, text in natural languages like English have extremely similar
 * distributions of characters. You can convince yourself of that using the main method below, which
 * compares Rent and Hamlet.
 * <p>
 * By computing the distribution of the characters in a ciphertext, a crytographer can begin the
 * process of breaking simple encryption schemes. (Letter frequency also has something to do with
 * the per-letter scores in Scrabble.)
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the unit tests in
 * <code>CharacterDistributionTest.java</code>.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/3/">MP3 Documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Letter_frequency">Letter frequency</a>
 */
public class CharDistribution {
    // use delimiter break into array. go through array fill frequency in another array
    // create another array and trim off the elements that are not numbers. nother array
    // count frequency

    /*
     * Take a single string argument. Return an array of doubles such that array[0] through
     * array[25] are the fractions of characters for 'a-z' and array[26] through array[51] are the
     * fractions for 'A-Z'. Other characters should not be included in the array or the count.
     * You'll want to review the ASCII character table carefully. Call this function
     * computeDistribution.
     */
    /**
     * Returns an array of doubles such that array[0] through array[25]
     * are the fractions of characters for 'a-z' and array[26] through
     * array[51] are the fractions for 'A-Z'. Other characters are not
     * included in the array or the count.
     * @param corpus the corpus given by the user
     * @return double[] array with the distribution of characters in the corpus
     */
    public static double[] computeDistribution(final String corpus) {
        final int letterNumber = 52;
        char[] characters = corpus.toCharArray();
        final int uniNumber = 225;

        int[] unicodeRepre = new int[uniNumber]; //255
        Arrays.fill(unicodeRepre, 0);
        /*
        for (char character: characters) {
            if (Character.isLetter(character)) {
                int unicode = (int) character;
                unicodeRepre[unicode] = unicodeRepre[unicode]++;
            }
        }*/
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
        if (Character.isLetter(character)) {
            int unicode = (int) character;
            unicodeRepre[unicode] = unicodeRepre[unicode] + 1;
        }
    }

        int[] count = new int[letterNumber];
        final int aIndex = 97;
        final int zIndex = 122;
        for (int i = aIndex, j = 0; i <= zIndex; i++, j++) {
            count[j] = unicodeRepre[i];
        }
        final int cAIndex = 65;
        final int cZIndex = 90;
        final int lowerStartIndex = 26;
        for (int i = cAIndex, j = lowerStartIndex; i <= cZIndex; i++, j++) {
            count[j] = unicodeRepre[i];
        }
        //for (int ele: count)//test
            //System.out.println(ele);//test
        double sum = 0;
        for (int uni: count) {
            sum += uni;
        }
        //System.out.println(sum);
        double[] distribution = new double[letterNumber];
        for (int i = 0; i < letterNumber; i++) {
            if (sum != 0) {
                distribution[i] = count[i] / sum;
            }
        }
        return distribution;
    }

    /** Text of Rent. Used for interactive testing. */
    private static final String RENT_FILE = "Rent.txt";

    /** Text of Hamlet. Used for interactive testing. */
    private static final String HAMLET_FILE = "Hamlet.txt";

    /**
     * Compare the character distributions in Rent.txt and Hamlet.txt.
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {

        String rentText, hamletText;
        try {
            String rentPath = CharDistribution.class.getClassLoader()
                    .getResource(RENT_FILE).getFile();
            rentPath = new URI(rentPath).getPath();
            File rentFile = new File(rentPath);
            Scanner rentScanner = new Scanner(rentFile, "UTF-8");
            rentText = rentScanner.useDelimiter("\\A").next();
            rentScanner.close();

            String hamletPath = CharDistribution.class.getClassLoader()
                    .getResource(HAMLET_FILE).getFile();
            hamletPath = new URI(hamletPath).getPath();
            File hamletFile = new File(hamletPath);
            Scanner hamletScanner = new Scanner(hamletFile, "UTF-8");
            hamletText = hamletScanner.useDelimiter("\\A").next();
            hamletScanner.close();
        } catch (Exception e) {
            throw new InvalidParameterException("Bad file path" + e);
        }

        double[] rentArray = computeDistribution(rentText);
        double[] hamletArray = computeDistribution(hamletText);
        if (rentArray.length != hamletArray.length) {
            throw new RuntimeException("Arrays should have the same length");
        }

        String charactersInOrder = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (charactersInOrder.length() != rentArray.length) {
            throw new RuntimeException("Wrong number of characters in returned array");
        }

        System.out.printf("%-10s%-10s%-10s\n", "Char", "Rent", "Hamlet");
        System.out.println("------------------------------");
        for (int characterIndex = 0; characterIndex < rentArray.length; characterIndex++) {
            System.out.printf("%-10s%-10.2f%-10.2f\n",
                    charactersInOrder.substring(characterIndex, characterIndex + 1),
                    rentArray[characterIndex], hamletArray[characterIndex]);

        }
    }
}
