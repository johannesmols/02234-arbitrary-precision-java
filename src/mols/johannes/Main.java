package mols.johannes;

import java.util.Arrays;

public class Main {

    public static long BASE =(2L << 30L) - 1;

    public static void main(String[] args) {
        // In Base 10: 123456789123456789123456789123456789123456789123456789123456789
        //64-bit
//        BigInteger a = new BigInteger(new long[] { 497017313360941710L, 8371747259953841529L, 3778830014700828830L, 157342L });
        //32-bit
        BigInteger a = new BigInteger(new long[] {2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739});
//        System.out.println(Arrays.toString(a.digits));
        // In Base 10: 987654321987654321987654321987654321987654321987654321

//        BigInteger b = new BigInteger(new long[] { 4261302582211177503L, 3381573805932972480L, 11609820760617042L });
        BigInteger b = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });
//        System.out.println(Arrays.toString(b.digits));

        // Test addition (Result in Base 10: 123456790111111111111111111111111111111111111111111111111111110)
        BigInteger added = Addition.Add(a, b);
        System.out.println(Arrays.toString(added.digits));

//        BigInteger correctResult = new BigInteger(new long[] { 4758319895572119213L, 2529949029032038202L, 3790439835461445873L, 157342L});
        BigInteger correctResult = new BigInteger(new long[] { 691622735, 1823494860, 1167368877, 1268594072, 902747267, 625345864, 1258739 });
//        System.out.println("Addition correct: " + added.equals(correctResult));
        System.out.println(Arrays.toString(correctResult.digits));

//        BigInteger multiplied = Multiplication.Multiply(a,b);
//        System.out.println(Arrays.toString(multiplied.digits));
        // Test short division (Result in Base 10: )
//        BigInteger oneDigitDividend = new BigInteger(new long[] { 1337L });
//        BigInteger divided = Division.Divide(a, oneDigitDividend);
//        BigInteger correctShortDivisionResult = new BigInteger(new long[] { });
//        System.out.println("Short division correct: " + divided.equals(correctResult));
    }
}
