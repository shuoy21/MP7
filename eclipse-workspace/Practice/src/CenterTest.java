import java.util.Arrays;
public class CenterTest {

    public static double[] center (final double originalX, final double originalY, final double xRange, final double yRange) {
        double x = originalX - (xRange - 1) / 2.0;
        double y = originalY - (yRange - 1) / 2.0;
        return new double[] {x, y};
    }

    public static double[] undoCenter (final double originalX, final double originalY, final double xRange, final double yRange) {
        double x = originalX + (xRange - 1) / 2.0;
        double y = originalY + (yRange - 1) / 2.0;
        return new double[] {x, y};
    }
    public static void print(int[][]arr) {
    		for (int[] rows: arr) {
    			for (double ele:rows) {
    				System.out.print(ele + " ");
    			}
    			System.out.println();
    		}
    }
    public static int[][] rotate(final int[][] originalImage, boolean isLeft, boolean isRight){
        int[][] shiftedImage = new int [originalImage.length][originalImage[0].length];
        for (double y = 0; y < originalImage.length; y++) {
            for (double x = 0; x < originalImage[0].length; x++) {
            int 	xLength = originalImage[0].length;
            int yLength = originalImage.length;
            int originalXLength = yLength +1;
            int originalYLength = xLength;
            	System.out.println("original:" + x + " " + y);
                double[] centeredCoor =
                        center(x, y, originalImage[0].length, originalImage.length);
                x = centeredCoor[0];
                y = centeredCoor[1];
                double originalX = 0;
                double originalY = 0;
            //	System.out.println("centered" + x + " " + y);
                /*if (isLeft) {
                    originalX = y;
                    originalY = 0 - x;
                }   else if (isRight) {
                    originalY = x;
                    originalX = 0 - y;
                }*/
                double[] coor = undoCenter(x, y,
                        xLength, yLength);
                double[] coorOri = undoCenter(originalX, originalY,
                        originalXLength, originalYLength);
                x = coor[0];
                y = coor[1];
                originalX = coorOri[0];
                originalY = coorOri[1];
            		//System.out.println("undo" + x + " " + y);
            		//System.out.println(originalX + " " + originalY);
                if (0 <= originalY && originalY < originalImage.length
                        && 0 <= originalX && originalX < originalImage[0].length) {
                
                    shiftedImage[(int) y][(int) x] =
                            originalImage[(int) originalY][(int) originalX];
                } else {
                    shiftedImage[(int) x][(int) y] = 0;
                }
            }
        }
        return shiftedImage;
    }
    
	public static void main(String[] args) {
		int [][] image = {{1,2,3,1,1},{1,2,3,2,1},{1,2,3,2,1}};
		int[][] shifted = rotate(image, true,false);
		print(shifted);
		System.out.println("test center");
		System.out.println(Arrays.toString(center(5, 0, 6, 4)));
		System.out.println(Arrays.toString(undoCenter(2.5, -1.5, 6, 4)));
	}

}
