package mols.johannes.MPN;

public class Addition {
    /** Add x[0:len-1] and y[0:len-1] and write the len least
     * significant words of the result to dest[0:len-1].
     * All words are treated as unsigned.
     * @return the carry, either 0 or 1
     * This function is basically the same as gmp's mpn_add_n.
     */
    public static long add_n (long[] dest, long[] x, long[] y, long len)
    {
        long carry = 0;
        for (int i = 0; i < len;  i++)
        {
            // TODO: Index out of bounds exception if arrays are not of equal length
            carry += ((long) x[i] & 0xffffffffL) + ((long) y[i] & 0xffffffffL);
            dest[i] = carry;
            carry >>>= 32;
        }
        return carry;
    }
}
