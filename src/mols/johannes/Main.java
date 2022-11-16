package mols.johannes;

public class Main {

    public static long BASE = (2L << 62L) - 1L;

    public static void main(String[] args) {
        // In Base 10: 123456789123456789123456789123456789123456789123456789123456789
        BigInteger a = new BigInteger(new long[] { 497017313360941710L, 8371747259953841529L, 3778830014700828830L, 157342L });
        // In Base 10: 987654321987654321987654321987654321987654321987654321
        BigInteger b = new BigInteger(new long[] { 4261302582211177503L, 3381573805932972480L, 11609820760617042L });

        // Test addition (Result in Base 10: 123456790111111111111111111111111111111111111111111111111111110)
        BigInteger added = Addition.Add(a, b);
        BigInteger correctResult = new BigInteger(new long[] { 4758319895572119213L, 2529949029032038202L, 3790439835461445873L, 157342L });
        System.out.println("Addition correct: " + added.equals(correctResult));
    }
}
