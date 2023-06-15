package Solutions;

import java.math.BigInteger;

public class FactorialOfLargeNumbers {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger factor = BigInteger.ONE;
        BigInteger tenPowNine = BigInteger.valueOf(1000000000L);

        for (int i = 1; i <= 100; i++) {
            factor = factor.multiply(BigInteger.valueOf(i));
            sum = sum.add(factor);
            System.out.println(sum.mod(BigInteger.valueOf(1000000000)));
        }

        BigInteger lastNineDigits = sum.mod(tenPowNine);
        System.out.println(lastNineDigits);
    }
}
