package mols.johannes;

import java.util.Arrays;

public class Main {

    public static long BASE_16_BIT = (2L << 14L) - 1L;
    public static long BASE_32_BIT = (2L << 30L) - 1L;
    public static long BASE_64_BIT = (2L << 62L) - 1L;

    public static void main(String[] args) {
        System.out.println("--- ADDITION ---");
        TestAddition();
        System.out.println("--- MULTIPLICATION ---");
        TestMultiplication();
        System.out.println("--- SHORT DIVISION ---");
        TestShortDivision();
        System.out.println("--- LONG DIVISION ---");
        TestLongDivision();
    }

    public static void TestAddition() {
        /* --- 16-BIT --- */

        /* --- 32-BIT --- */

        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });

        BigInteger res32 = Addition.Add(a32, b32, BASE_32_BIT);
        BigInteger correctRes32 = new BigInteger(new long[] { 691622735, 1823494860, 1167368877, 1268594072, 902747267, 625345864, 1258739 });

        System.out.println("32-bit: Added: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));

        /* --- 64-BIT --- */

        BigInteger a64 = new BigInteger(new long[] { 497017313360941710L, 8371747259953841529L, 3778830014700828830L, 157342L });
        BigInteger b64 = new BigInteger(new long[] { 4261302582211177503L, 3381573805932972480L, 11609820760617042L });

        BigInteger res64 = Addition.Add(a64, b64, BASE_64_BIT);
        BigInteger correctRes64 = new BigInteger(new long[] { 4758319895572119213L, 2529949029032038202L, 3790439835461445873L, 157342L });

        System.out.println("64-bit: Added: " + Arrays.toString(res64.digits));
        System.out.println("64-bit: Correct result: " + Arrays.toString(correctRes64.digits));
        System.out.println("64-bit: Is correct: " + res64.equals(correctRes64));
    }

    public static void TestMultiplication() {
        /* --- 16-BIT --- */

        /* --- 32-BIT --- */

        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });

        BigInteger res32 = Multiplication.Multiply(a32, b32, BASE_32_BIT);
        BigInteger correctRes32 = new BigInteger(new long[] { 900152130, 197668725, 776425567, 67217174, 612263391, 1948055784, 1430562636, 395302314, 308734505, 1280985670, 690865435, 851989163, 12675 });

        System.out.println("32-bit: Multiplied: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));

        /* --- 64-BIT --- */

        BigInteger a64 = new BigInteger(new long[] { 497017313360941710L, 8371747259953841529L, 3778830014700828830L, 157342L });
        BigInteger b64 = new BigInteger(new long[] { 4261302582211177503L, 3381573805932972480L, 11609820760617042L });

        BigInteger res64 = Multiplication.Multiply(a64, b64, BASE_64_BIT);
        BigInteger correctRes64 = new BigInteger(new long[] { 6667738644563045105L, 7776242508209248303L, 7354801544318048113L, 4445168259071336541L, 1063683437967272298L, 489511381567339649L, 198L });

        System.out.println("64-bit: Multiplied: " + Arrays.toString(res64.digits));
        System.out.println("64-bit: Correct result: " + Arrays.toString(correctRes64.digits));
        System.out.println("64-bit: Is correct: " + res64.equals(correctRes64));
    }

    public static void TestShortDivision() {
        /* --- 16-BIT --- */

        /* --- 32-BIT --- */
        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 133742069 });
        BigInteger res32 = Division.Divide(a32, b32, BASE_32_BIT);
        BigInteger correctRes32 = new BigInteger(new long[] { 1834410904, 941594408, 1878536921, 1926532381, 1270415181, 20211456 });

        System.out.println("32-bit: Divided: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));

        /* --- 64-BIT --- */
    }

    public static void TestLongDivision() {
        /* --- 16-BIT --- */

        /* --- 32-BIT --- */
        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });
        BigInteger res32 = Division.Divide(a32, b32, BASE_32_BIT);
        BigInteger correctRes32 = new BigInteger(new long[] { 124999998 });

        System.out.println("32-bit: Divided: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));

        /* --- 64-BIT --- */
    }
}
