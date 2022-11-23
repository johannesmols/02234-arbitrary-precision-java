package mols.johannes.MPN;

import mols.johannes.BigInteger;

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
    }

    public static void TestAddition() {
        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });

        long[] res32Digits = new long[Math.max(a32.digits.length, b32.digits.length)];
        long carry32 = Addition.add_n(res32Digits, a32.digits, b32.digits, res32Digits.length);

        BigInteger res32 = new BigInteger(res32Digits);
        BigInteger correctRes32 = new BigInteger(new long[] { 691622735, 1823494860, 1167368877, 1268594072, 902747267, 625345864, 1258739 });

        System.out.println("32-bit: Added: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Additional carry: " + carry32);
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));
    }

    public static void TestMultiplication() {
        /* --- 16-BIT --- */

        /* --- 32-BIT --- */

        /* --- 64-BIT --- */
    }
}