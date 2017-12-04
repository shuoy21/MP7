/**
 * A class that represents a DNA sequence.
 */
public class DNA {
    /**
     * sequence of DNA.
     */
    private String sequence = "";
    /**
     * Create a new DNA instance from the given sequence of base pairs.
     * The constructor should validate and normalize its inputs.
     * All characters in the string should be from the set A, D, C, and G (this in DNA, not RNA).
     * You should accept lower-case inputs but convert them
     * to upper-case for the purposes of later comparison.
     * @param setSequence the sequence of base pairs to initialize the instance with
     */
    public DNA(final String setSequence) {
        String tempSequence = setSequence.toUpperCase();
        for (int i = 0; i < tempSequence.length(); i++) {
            String base = tempSequence.substring(i, i + 1);
            if (base.equals("A") || base.equals("D")
                    || base.equals("C") || base.equals("G")) {
                    sequence += base;
            }
        }
    }
    /**
     * Gets the sequence of base pairs for this DNA instance.
     * @return the sequence of base pairs for this DNA instance
     */
    public java.lang.String getSequence() {
        return sequence;
    }

/*
    /**
     * Define equality for the DNA class.
     * @param obj other DNA sequence to compare with
     * @return if two sequences are equal
     */
    /*public boolean equals(final java.lang.Object obj) {
        DNA otherSequence;
        if (obj instanceof DNA) {
            otherSequence = (DNA) obj;
        } else {
            return false;
        }
        if (sequence.equals(otherSequence.getSequence())) {
            return true;
        } else {
            return false;
        }
    }*/

   /* private static String getSubsequence(final DNA firstSequence,
            final DNA secondSequence) {
        String commonSequence = "";
        DNA s1 = firstSequence;
        DNA s2 = secondSequence;
        if (s1.getSequence().equals("") || s2.getSequence().equals("")) {
            return commonSequence;
        }
        char s1Letter = s1.getSequence().charAt(0);
        char s2Letter = s2.getSequence().charAt(0);
        if (s1Letter == s2Letter) {
            s1 = new DNA(s1.getSequence().substring(1));
            s2 = new DNA(s2.getSequence().substring(1));
            commonSequence = s1Letter + getSubsequence(s1, s2);
            return commonSequence;
        } else {
            if (s1.getSequence().indexOf(s2Letter) == -1) {
                s2 = new DNA(s2.getSequence().substring(1));
                return getSubsequence(s1, s2);
            } else {
                s1 = new DNA(s1.getSequence().substring(1));
                return getSubsequence(s1, s2);
            }
        }
    }*/
    /**
     * helper function for get longest subsequence.
     * @param firstSequence first sequence
     * @param secondSequence second sequence
     * @return longest common subsequence
     */
    private static String getSubsequence(final DNA firstSequence,
            final DNA secondSequence) {
        String commonSequence = "";
        DNA s1 = firstSequence;
        DNA s2 = secondSequence;
        if (s1.getSequence().equals("") || s2.getSequence().equals("")) {
            return commonSequence;
        }
        char s1Letter = s1.getSequence().charAt(0);
        char s2Letter = s2.getSequence().charAt(0);
        if (s1Letter == s2Letter) {
            s1 = new DNA(s1.getSequence().substring(1));
            s2 = new DNA(s2.getSequence().substring(1));
            commonSequence = s1Letter + getSubsequence(s1, s2);
            return commonSequence;
        } else {
            DNA tempS1 = new DNA(s1.getSequence().substring(1));
            DNA tempS2 = new DNA(s2.getSequence().substring(1));
            return commonSequence + getLongerSequence(new DNA(getSubsequence(s1, tempS2)),
                    new DNA(getSubsequence(tempS1, s2)));
        }
    }

    /*private static DNA getLongerSequence(final DNA firstSequence,
            final DNA secondSequence) {
        int s1Length = firstSequence.getSequence().length();
        int s2Length = secondSequence.getSequence().length();
        if (s1Length > s2Length) {
            return firstSequence;
        } else {
            return secondSequence;
        }
    }*/
    /**
     * Return the longer subsequence of the two provided DNA sequences.
     * @param firstSequence first sequence
     * @param secondSequence second sequence
     * @return longer common subsequence
     */
    private static String getLongerSequence(final DNA firstSequence,
            final DNA secondSequence) {
        int s1Length = firstSequence.getSequence().length();
        int s2Length = secondSequence.getSequence().length();
        if (s1Length > s2Length) {
            return firstSequence.getSequence();
        } else {
            return secondSequence.getSequence();
        }
    }

    /**
     * get longest common subsequence of DNA.
     * @param firstSequence first sequence
     * @param secondSequence second sequence
     * @return longest common subsequence
     */
    public static DNA getLongestCommonSubsequence(final DNA firstSequence,
            final DNA secondSequence) {
        if (firstSequence == null || secondSequence == null) {
            return null;
        }
        /*DNA s1 = firstSequence;
        DNA s2 = secondSequence;
        DNA current = getLongerSequence
        (new DNA(getSubsequence(s1, s2)), new DNA(getSubsequence(s2, s1)));
        DNA longest = current;
        System.out.println(longest.getSequence());
        if (s1.getSequence().equals("")) {
            return longest;
        } else {
            s2 = new DNA(s2.getSequence().substring(1));
            DNA next = new DNA(getSubsequence(s1, s2));
            longest = getLongerSequence(current, next);
            return longest;
        }*/
        return new DNA(getSubsequence(firstSequence, secondSequence));
        }
}
