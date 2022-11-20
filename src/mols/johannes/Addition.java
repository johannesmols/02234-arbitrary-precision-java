package mols.johannes;

import java.util.Arrays;

public class Addition {
    public static BigInteger Add(BigInteger a, BigInteger b) {
        // Temporary variables for addition
//        long carry;
        long carry = 0;


        boolean a_is_larger = a.digits.length > b.digits.length;
        int largest_size = (a_is_larger) ? a.digits.length : b.digits.length;
        int smallest_size = (a_is_larger) ? b.digits.length : a.digits.length;

        int i = 0 ;
        int j = 0 ;
        int k = 0 ;

        int a_i = (a_is_larger)? i : j;
        int b_i = (a_is_larger)? j : i;

        BigInteger result = new BigInteger( new long[largest_size + 1] );


        while(a_i <= largest_size || b_i <= smallest_size ||  carry != 0) {
            long a_val = (a_i <= largest_size - 1) ? a.digits[a_i] : 0;
            long b_val = (b_i <= smallest_size - 1) ? b.digits[b_i] : 0;

            long sum = a_val + b_val + carry;

            long tmp_res = sum % Main.BASE;
            if (tmp_res < 0){
                tmp_res = Main.BASE + tmp_res + 2;
            }
            result.digits[k] = tmp_res;

            carry = sum / Main.BASE;
            System.out.println(carry);
            ++a_i;
            b_i++;
            ++k;
        }
        return result;

    }
}
