package mols.johannes.MPN;

import mols.johannes.Main;

public class Addition {
    /** Add x[0:len-1] and y[0:len-1] and write the len least
     * significant words of the result to dest[0:len-1].
     * All words are treated as unsigned.
     * @return the carry, either 0 or 1
     * This function is basically the same as gmp's mpn_add_n.
     */
    public static long add_n (long[] dest, long[] x, long[] y, long len)
    {
        // Input numbers are 32-bit with 32-bits of zeroes

        long carry = 0;
        for (int i = 0; i < len;  i++)
        {
            long x_val = (i < x.length) ? x[i] : 0;
            long y_val = (i < y.length) ? y[i] : 0;

            // Get the values and add them together (binary and is to pad 32-bit ints to 64-bits and set last 32-bit's to zero)
            carry += x_val + y_val;

            // Original solution: takes first 32-bits (by casting to int), and then shifts remaining 32-bits into position on the left so that it also is an integer
            // dest[i] = (int) carry;
            // carry >>>= 32;

            // Our solution: Use modulo base to get value that fits into 32-bit int, and divide by base to get carry value
            dest[i] = carry % Main.BASE_32_BIT;
            carry = carry / Main.BASE_32_BIT;
        }

        return carry;
    }
}
