package mols.johannes;

public class Division {
    /**
     * See https://en.wikipedia.org/wiki/Long_division and https://github.com/nickelcarbide/arbitrary-precision-arithmetic-demo/blob/master/episode-6-long-division/biguint.py
     * Assumes that A and B have no empty redundant digits (requires that they are sanitized before passing in,
     * probably by looping through them and checking how many digits are 0, and if more than 0 (unless its the only one),
     * then create a new array with only those digits that are not 0.)
     */
    public static BigInteger Divide(BigInteger dividend, BigInteger divisor, long base) {
        long[] quotient = new long[dividend.digits.length];
        long[] remainder = new long[dividend.digits.length];

        long tmpRemainder = 0;

        // Attempting to divide by zero, not allowed
        if (divisor.digits.length == 1 && divisor.digits[0] == 0L) {
            return new BigInteger(new long[0]);
        }

        // If the amount of digits in first number is less than second number,
        // the quotient is 0 and the remainder is the same as the first number
        if (dividend.digits.length < divisor.digits.length) {
            for (int i = 0; i < quotient.length; i++) {
                quotient[i] = 0; // Set all digits to 0
            }
            return new BigInteger(quotient);
        }

        if (divisor.digits.length == 1 && divisor.digits[0] < base) {
            // Short division algorithm
            long[] res = new long[dividend.digits.length];
            long i = 0;
            while (i < res.length) {

                i++;
            }
        } else {
            // Long Division algorithm (https://en.wikipedia.org/wiki/Long_division#Algorithm_for_arbitrary_base)
            long[] res = new long[dividend.digits.length];
            long k = dividend.digits.length;
            long l = divisor.digits.length;
            long i = k - l;
            long q, d, r, a, b = 0;
            while (i >= 0) {

                i--;
            }
        }

        return null;
    }
}
