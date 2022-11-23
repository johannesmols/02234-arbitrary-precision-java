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
        System.out.println("--- SINGLE MULTIPLICATION ---");
        TestSingleMultiplication();
        System.out.println("--- MULTIPLICATION ---");
        TestMultiplication();
    }

    public static void TestAddition() {
        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });

        long[] res32Digits = new long[Math.max(a32.digits.length, b32.digits.length)];
        long carry32 = Operations.add_n(res32Digits, a32.digits, b32.digits, res32Digits.length, mols.johannes.Main.BASE_32_BIT);

        BigInteger res32 = new BigInteger(res32Digits);
        BigInteger correctRes32 = new BigInteger(new long[] { 691622735, 1823494860, 1167368877, 1268594072, 902747267, 625345864, 1258739 });

        System.out.println("32-bit: Addition, Number 1: " + Arrays.toString(a32.digits));
        System.out.println("32-bit: Addition, Number 2: " + Arrays.toString(b32.digits));
        System.out.println("32-bit: Added: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Additional carry: " + carry32);
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));
    }

    public static void TestSingleMultiplication() {
        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 1337 });

        long[] res32Digits = new long[a32.digits.length];
        long carry32 = Operations.mul_1(res32Digits, a32.digits, b32.digits[0], Main.BASE_32_BIT);

        BigInteger res32 = new BigInteger(res32Digits);
        BigInteger correctRes32 = new BigInteger(new long[] { 1220184012, 779208589, 1384211915, 865814662, 1286904644, 1868459693, 1682934418 });

        System.out.println("32-bit: Multiplication, Number 1: " + Arrays.toString(a32.digits));
        System.out.println("32-bit: Multiplication, Number 2: " + Arrays.toString(b32.digits));
        System.out.println("32-bit: Single multiplied: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Additional carry: " + carry32);
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));
    }

    public static void TestMultiplication() {
        BigInteger a32 = new BigInteger(new long[] { 2027931598, 434255641, 566416197, 1590781320, 100546664, 603720888, 1258739 });
        BigInteger b32 = new BigInteger(new long[] { 811174784, 1389239218, 600952680, 1825296399, 802200602, 21624976 });

        long[] res32Digits = new long[a32.digits.length + b32.digits.length];
        Operations.mul(res32Digits, a32.digits, b32.digits, Main.BASE_32_BIT);

        BigInteger res32 = new BigInteger(res32Digits);
        BigInteger correctRes32 = new BigInteger(new long[] { 900152130, 197668725, 776425567, 67217174, 612263391, 1948055784, 1430562636, 395302314, 308734505, 1280985670, 690865435, 851989163, 12675 });

        System.out.println("32-bit: Multiplication, Number 1: " + Arrays.toString(a32.digits));
        System.out.println("32-bit: Multiplication, Number 2: " + Arrays.toString(b32.digits));
        System.out.println("32-bit: Multiplied: " + Arrays.toString(res32.digits));
        System.out.println("32-bit: Correct result: " + Arrays.toString(correctRes32.digits));
        System.out.println("32-bit: Is correct: " + res32.equals(correctRes32));
    }
}