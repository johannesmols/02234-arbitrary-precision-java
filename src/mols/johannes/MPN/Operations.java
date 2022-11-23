package mols.johannes.MPN;

// Code adjusted from: https://opensource.apple.com/source/gcc/gcc-1435/libjava/gnu/java/math/MPN.java.auto.html

public class Operations {
    /** Add x[0:len-1] and y[0:len-1] and write the len least
     * significant words of the result to dest[0:len-1].
     * All words are treated as unsigned.
     * @return the carry, either 0 or 1
     * This function is basically the same as gmp's mpn_add_n.
     */
    public static long add_n (long[] dest, long[] x, long[] y, long len, long base)
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
            dest[i] = carry % base;
            carry = carry / base;
        }

        return carry;
    }

    /** Multiply x[0:len-1] by y, and write the len least
     * significant words of the product to dest[0:len-1].
     * Return the most significant word of the product.
     * All values are treated as if they were unsigned
     * (i.e. masked with 0xffffffffL).
     * OK if dest==x (not sure if this is guaranteed for mpn_mul_1).
     * This function is basically the same as gmp's mpn_mul_1.
     */
    public static long mul_1(long[] dest, long[] x, long y, long base)
    {
        // Input numbers are 32-bit with 32-bits of zeroes

        long carry = 0;
        for (int i = 0;  i < x.length; i++)
        {
            carry += x[i] * y;

            // Original solution: takes first 32-bits (by casting to int), and then shifts remaining 32-bits into position on the left so that it also is an integer
            // dest[i] = (int) carry;
            // carry >>>= 32;

            // Our solution: Use modulo base to get value that fits into 32-bit int, and divide by base to get carry value
            dest[i] = carry % base;
            carry = carry / base;
        }

        return carry;
    }

    /**
     * Multiply x[0:xlen-1] and y[0:ylen-1], and
     * write the result to dest[0:xlen+ylen-1].
     * The destination has to have space for xlen+ylen words,
     * even if the result might be one limb smaller.
     * This function requires that xlen >= ylen.
     * The destination must be distinct from either input operands.
     * All operands are unsigned.
     * This function is basically the same gmp's mpn_mul. */
    public static void mul(long[] dest, long[] x, long[] y, long base)
    {
        // Input numbers are 32-bit with 32-bits of zeroes

        dest[x.length] = mul_1(dest, x, y[0], base);

        for (int i = 1;  i < y.length; i++)
        {
            long carry = 0;
            for (int j = 0;  j < x.length; j++)
            {
                carry += x[j] * y[i] + dest[i+j];

                // Original solution: takes first 32-bits (by casting to int), and then shifts remaining 32-bits into position on the left so that it also is an integer
                // dest[i+j] = (int) carry;
                // carry >>>= 32;

                // Our solution: Use modulo base to get value that fits into 32-bit int, and divide by base to get carry value
                dest[i+j] = carry % base;
                carry = carry / base;
            }

            dest[i+x.length] = carry;
        }
    }
}
