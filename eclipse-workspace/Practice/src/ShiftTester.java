
public class ShiftTester {
	private static int[][] shiftedImage;
	public static final int FILL_VALUE = 0x00FFFFFF;
	
	    public static void shift(final int[][] originalImage, final int amount,
	            final int isLeftshift, final int isRightshift,
	            final int isUpshift, final int isDownshift) {
	        shiftedImage = new int[originalImage.length][originalImage[0].length];
	        int startColumn = isLeftshift * amount;
	        int endColumn = originalImage[0].length - isRightshift * amount;
	        int startRow = isUpshift * amount;
	        int endRow = originalImage.length - isDownshift * amount;
	        int row = 0, column = 0;
	        if (isLeftshift == 1) {
	        		row = 0;
	        		column = 0;
	        } else if (isRightshift == 1) {
	        		row = 0;
	        		column = amount;
	        } else if (isDownshift == 1){
	        		row = amount;
	        		column = 0;
	        } else if( isUpshift == 1) {
	        		row = 0;
	        		column = 0;
	        } else {	
	        	;
	        }
	        for (int i = startRow, realRow = row; i < endRow; i++, realRow++) {
	            for (int j = startColumn, realColumn = column; j < endColumn; j++, realColumn++) {
	            	//System.out.print(realRow);
	            	//System.out.println(realColumn);
	                shiftedImage[realRow][realColumn] = originalImage[i][j];
	            }
	        }
	        for (int i = 0; i < shiftedImage.length; i++) {
	            for (int j = 0; j < shiftedImage[0].length; j++) {
	                if (shiftedImage[i][j] == 0) {
	                    shiftedImage[i][j] = 0;//FILL_VALUE;
	                }
	            }
	        }
	        /*for (int i = 0; i < originalImage.length;i++) {
	            for (int j = originalImage[0].length - amount; j < originalImage[0].length; j++) {
	            	System.out.println("test" + i + ' ' + j);
	                shiftedImage[i][j] = 0;
	            }
	        }*/
	    }
	    /////////////////test
	    public static void main(String[] args) {
	    int[][] originalImage = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
	    shift(originalImage, 2, 0, 1, 0, 0
	    		);
	    for (int[] row: shiftedImage) {
	    	for (int ele: row)
	    		System.out.print(ele);
	    		System.out.println();
	    		//break;
	    }
	    }
	}

