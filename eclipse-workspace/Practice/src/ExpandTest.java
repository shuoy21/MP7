import java.util.Arrays;

public class ExpandTest {
	
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
	
    public static int[][] expand(final int[][] originalImage, final boolean isVertical,
            final boolean isHorizontal, final int factor) {
        int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];
        for (double x = 0; x < originalImage[0].length; x++) {
            for (double y = 0; y < originalImage.length; y++) {
            	 System.out.println("originalxy" + x + " " + y);
            		//center
                double[] centeredCoor =
                        center(x, y, originalImage[0].length, originalImage.length);
                x = centeredCoor[0];
                y = centeredCoor[1];
                double originalY = 0;
                double originalX = 0;
                //expand
                if (isHorizontal) {
                    originalX = x / factor;
                    originalY = y;
                }
                if (isVertical) {
                    originalX = x;
                    originalY = y / factor;
                }
                System.out.println("expandedxy" + originalX + " " + originalY);
                // undocenter
                int originalXLength = 0;
                int originalYLength = 0;
                if (isHorizontal) {
                		originalXLength = originalImage[0].length / factor;
                		originalYLength = originalImage.length;
                } else if (isVertical) {
                		originalXLength = originalImage[0].length;
                		originalYLength = originalImage.length / factor;
                }
                double[] origiCoor = undoCenter(originalX, originalY,
                        originalXLength , originalYLength);
                originalX = origiCoor[0];
                originalY = origiCoor[1];
                double[] coor = undoCenter(x, y,
                        originalImage[0].length, originalImage.length);
                x = coor[0];
                y = coor[1];
                
                System.out.println(x + " " + y);
                System.out.println(originalX + " " + originalY);
                
            if (0 <= originalY && originalY < originalImage.length
                    && 0 <= originalX
                    && originalX < originalImage[0].length) {
                shiftedImage[(int) y][(int) x] =
                        originalImage[(int) originalY][(int) originalX];
            } /*else {
                shiftedImage[(int) y][(int) x] = FILL_VALUE;
            }*/
            }
        }
        return shiftedImage;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] originalImage = {{0, 1, 1, 0}, {0, 1, 1, 0}};
		int[][] returnImage = expand(originalImage, false, true, 2);
		for (int[] rows: returnImage) {
			System.out.println(Arrays.toString(rows));
		}
	}

}
/*int[][] shiftedImage = new int[originalImage.length][originalImage[0].length];
for (double x = 0; x < originalImage[0].length; x++) {
    for (double y = 0; y < originalImage.length; y++) {

        double originalX = 0;
        double originalY = 0;
        if (isVertical) {
            originalY = (int) (y / factor);
            originalX = x;
            }
        if (isHorizontal) {
            originalY = y;
            originalX = (int) (x / factor);
            }
        double[] centeredCoor =
                center(x, y, originalImage[0].length, originalImage.length);
        x = centeredCoor[0];
        y = centeredCoor[1];
        double[] centeredOriCoor =
                center(originalX, originalY, originalImage[0].length / factor, originalImage.length / factor);

        if (isHorizontal) {
            originalX = x / factor;
            originalY = y;
            //originalXLength = originalImage[0].length / factor;
            //originalYLength = originalImage.length;
        }
        if (isVertical) {
            originalX = x;
            originalY = y / factor;
            //originalXLength = originalImage[0].length;
            //originalYLength = originalImage.length / factor;
        }
        // undocenter
        double originalXLen = 0;
        double originalYLen = 0;
        if (isHorizontal) {
            originalXLen = originalImage[0].length / factor;
            originalYLen = originalImage.length;
        } else if (isVertical) {
            originalXLen = originalImage[0].length;
            originalYLen = originalImage.length / factor;
        }
        double[] origiCoor = undoCenter(originalX, originalY,
               originalXLen, originalYLen);
        originalX = origiCoor[0];
        originalY = origiCoor[1];
        double[] coor = undoCenter(x, y,
                originalImage[0].length, originalImage.length);
        x = coor[0];
        y = coor[1];

    if (0 <= originalY && originalY < originalImage.length
            && 0 <= originalX
            && originalX < originalImage[0].length) {
        shiftedImage[(int) y][(int) x] =
                originalImage[(int) originalY][(int) originalX];
    }
}
}
return null;
}
/*for (double originalX = 0; originalX < originalImage[0].length; originalX++) {
    for (double originalY = 0; originalY < originalImage.length; originalY++) {
        double[] centeredCoor =
                center(originalX, originalY, originalImage[0].length, originalImage.length);
        originalX = centeredCoor[0];
        originalY = centeredCoor[1];
        double[] x;
        double[] y;
        if (isHorizontal) {
            for (int i = 0; i < factor; i++) {
                x[i] = originalX * factor;
                y[i] = originalY;
            }
        } else if (isVertical) {
            for (int i = 0; i < factor; i++) {
                x[i] = originalX;
                y[i] = originalY * factor;
            }
        }
        double[] origiCoor = undoCenter(originalX, originalY,
                originalImage[0].length, originalImage.length);
         originalX = origiCoor[0];
         originalY = origiCoor[1];
         int xLength = 0;
         int yLength = 0;
         if (isHorizontal) {
             xLength = originalImage[0].length * factor;
             yLength = originalImage.length;
         } else {
             xLength = originalImage[0].length;
             yLength = originalImage.length * factor;
         }
         double[] coor = undoCenter(x, y,
                 xLength, yLength);
         x = coor[0];
         y = coor[1];
         if (0 <= y && y < originalImage.length
                 && 0 <= x && x < originalImage[0].length) {
             shiftedImage[(int) y][(int) x] =
                     originalImage[(int) originalY][(int) originalX];
         }
    }
}
return shiftedImage;
}*/