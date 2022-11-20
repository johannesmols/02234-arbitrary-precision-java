package mols.johannes;

import java.util.Arrays;

public class Addition {
    public static BigInteger Add(BigInteger a, BigInteger b) {
        // Temporary variables for addition
        long carry = 0;

        int i = 0 ;
        int j = 0 ;
        int k = 0 ;

        BigInteger result = new BigInteger( new long[a.digits.length + 1] );

        while(i <= a.digits.length || j <= b.digits.length ||  carry != 0) {
            long a_val = (i <= a.digits.length - 1) ? a.digits[i] : 0;
            long b_val = (j <= b.digits.length - 1) ? b.digits[j] : 0;

            long sum = a_val + b_val + carry;

            long tmp_res = sum % Main.BASE;

            if (tmp_res < 0)
                tmp_res = Main.BASE + tmp_res + 2;
            carry = sum / Main.BASE;

            result.digits[k] = tmp_res;
            
            ++i;
            j++;
            ++k;
        }
        return result;

    }
}
