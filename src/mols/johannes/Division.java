package mols.johannes;

public class Division {
    /**
     * See https://en.wikipedia.org/wiki/Long_division and https://github.com/nickelcarbide/arbitrary-precision-arithmetic-demo/blob/master/episode-6-long-division/biguint.py
     * Assumes that A and B have no empty redundant digits (requires that they are sanitized before passing in,
     * probably by looping through them and checking how many digits are 0, and if more than 0 (unless its the only one),
     * then create a new array with only those digits that are not 0.)
     */
    public static BigInteger Divide(BigInteger a, BigInteger b) {
        long[] quotient = new long[a.digits.length];
        long[] remainder = new long[a.digits.length];

        // Attempting to divide by zero, not allowed
        if (b.digits.length == 1 && b.digits[0] == 0L) {
            return new BigInteger(new long[0]);
        }

        // If the amount of digits in first number is less than second number,
        // the quotient is 0 and the remainder is the same as the first number
        if (a.digits.length < b.digits.length) {
            for (int i = 0; i < quotient.length; i++) {
                quotient[i] = 0; // Set all digits to 0
            }
            return new BigInteger(quotient);
        }

        if (b.digits.length <= 1) {
            // Short division algorithm
            long[] res = new long[a.digits.length];
            long i = 0;
            while (i < res.length) {

                i++;
            }
        } else {
            // Long Division algorithm
        }

        return null;
    }
}
