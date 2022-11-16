package mols.johannes;

public class Addition {
    public static BigInteger Add(BigInteger a, BigInteger b) {
        // Temporary variables for addition
        long carry;
        long largest_size;
        long a_val;
        long b_val;
        long tmp_res;

        // Temporary values for looping, reading in values, etc.
        long i = 0;

        // Addition of A and B
        carry = 0;
        largest_size = ((a.digits.length) >= (b.digits.length)) ? a.digits.length : b.digits.length;
        // If there is no carry at the end, the array unfortunately still gets an additional element
        // Can't resize arrays, so we would have to check at the end and copy the values to a new array
        long[] digits_res = new long[(int) largest_size + 1];
        while (i < largest_size) {
            // Check if A has more digits
            if (i < (a.digits.length)) {
                a_val = a.digits[(int) i];
            } else {
                a_val = 0;
            }

            // Check if B has more digits
            if (i < (b.digits.length)) {
                b_val = b.digits[(int) i];
            } else {
                b_val = 0;
            }

            tmp_res = (a_val + b_val) + carry;
            if ((tmp_res >= (Main.BASE + 1)) && (tmp_res < 0)) { // base + 1 gets the minimum possible value (in negative space)
                // Overflow occurred
                digits_res[(int) i] = (tmp_res + Main.BASE) + 2; // Overflow goes in negative numbers, so put it back into positive space
                carry = 1; // Set carry to 1
            } else {
                digits_res[(int) i] = tmp_res;
                carry = 0;
            }
            i++;
        }

        if (carry > 0) {
            digits_res[(int) largest_size] = carry;
        } else {
            // Accessing this index will otherwise throw a runtime exception (uninitialized)
            digits_res[(int) largest_size] = 0;
        }

        return new BigInteger(digits_res);
    }
}
