package mols.johannes;

import java.util.Arrays;

public class Multiplication {
    public static BigInteger Multiply(BigInteger a, BigInteger b) {
        // Temporary variables for addition
//        long carry;
        long carry = 0;

        boolean a_is_larger = a.digits.length > b.digits.length;
        int largest_size = (a_is_larger) ? a.digits.length : b.digits.length;
        int smallest_size = (a_is_larger) ? b.digits.length : a.digits.length;

        // Temporary values for looping, reading in values, etc.
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;


        BigInteger result = new BigInteger( new long[a.digits.length + b.digits.length + 2] );


        while(i <= a.digits.length ||  carry != 0) {

            carry = 0;
            j= 0;
            long a_val = (i < a.digits.length) ? a.digits[i] : 0;
            while(j <= b.digits.length ||  carry != 0){
                k = i + j;
                long b_val = (j < b.digits.length) ? b.digits[j] : 0;

                long tmp_res = (a_val * b_val) + carry;
                if (tmp_res < 0)
                    tmp_res = Main.BASE + tmp_res + 2;


                result.digits[k] += tmp_res;

                carry = result.digits[k] / Main.BASE;
                result.digits[k] = result.digits[k] % Main.BASE;

                j++;
            }
            result.digits[a.digits.length + j] = carry;
            i++;

        }
        return result;

    }
}
