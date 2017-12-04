import java.util.Arrays;

public class CharDisTest {
	//private String test = "H<}L^X:R`,UT%PQA&L?e.&(?pg}_x&d;?m]&X*kbv=i,mgONDF@P9x:K:U.JB,R<u}/kkT@!_%H)\\r:B8s~]BI'mC!F:{?=^#h}O9(Wtjj>6W=\\\"pa\\tnow,}3:O3K(<z{$.Fp5ffu(zÇWrxa,^zH{>©Q)\\n?-uJn\\nn+N++M>;$.kh*i[E03d@3<_B)1\\\"dy$©Ja3N~C).5-{D&B,'^X>\\\\+\\tA-f)R-[_^vyl\\n'z6=T<v;{zz<gc4ijbCeN$E3Fi< ^Cm\\nwY_a.$<>sVlT[rgm`o4X?Yx_;F4\\rk?tvWxcBQ\\r] K:%-kI@<ktBBAHWNO\\\\iyRoNjZGrD39L;WIDW3|d\\\"ejUIt(tB#I)d'9Ñe(9KoI6©bDEs1V©2ux*-tYNr+wDP,}9>EvÑjH\\n\\n?sz\\\"\\\"qxX'M\\\\TJ";
	//public static void main(String args[]) {
		// TODO Auto-generated method stub
		public static double[] computeDistribution(final String corpus) {
			//test = this.test;
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
	            distribution[i] = count[i] / sum;
	        }
	        for (double dis: distribution)
	        		System.out.println(dis);
	    }	
		
}

