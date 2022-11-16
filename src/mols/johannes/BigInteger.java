package mols.johannes;

import java.util.Arrays;

public class BigInteger {
    long[] digits;

    public BigInteger(long[] digits) {
        this.digits = digits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigInteger that = (BigInteger) o;

        for (int i = 0; i < Math.max(this.digits.length, that.digits.length); i++) {
            // If both arrays still have digits to give, compare them
            if (i < this.digits.length && i < that.digits.length) {
                if (this.digits[i] != that.digits[i]) {
                    return false;
                }
            } else if (i < this.digits.length && this.digits[i] == 0L) {
                continue;
            } else if (i < that.digits.length && that.digits[i] == 0L) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
