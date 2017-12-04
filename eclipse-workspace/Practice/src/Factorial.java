
public class Factorial {
	
    public static final int FACTORIAL_MIN = 0;

    /**
     * Maximum valid factorial input.
     * <p>
     * Do not change this value.
     */
    public static final int FACTORIAL_MAX = 20;

    /**
     * Invalid factorial return value.
     * <p>
     * Do not change this value.
     */
    public static final int FACTORIAL_INVALID = -1;
	
    public static int factorial(final int input) {
        int factorial;
        int curProduct = 1;
        if (input > FACTORIAL_MAX || input < FACTORIAL_MIN) {
            factorial = FACTORIAL_INVALID;
        }   else    {
            int i = 1;
            while (i <= input) {
                curProduct = curProduct * i;
                i++;
            }
            factorial = curProduct;
        }

        return factorial;
    }

}
