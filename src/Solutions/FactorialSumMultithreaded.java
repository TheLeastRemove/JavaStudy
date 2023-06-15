package Solutions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongArray;

public class FactorialSumMultithreaded {

    private static final int THREAD_COUNT = 10;
    private static final int NUM_DIGITS = 9;
    private static final long FACTORIAL_LIMIT = 202320232023L;

    public static void main(String[] args) throws InterruptedException {
        AtomicLongArray digits = new AtomicLongArray(NUM_DIGITS);
        digits.set(0, 1);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 1; i <= THREAD_COUNT; i++) {
            long start = (FACTORIAL_LIMIT / THREAD_COUNT) * (i - 1) + 1;
            long end = i == THREAD_COUNT ? FACTORIAL_LIMIT : (FACTORIAL_LIMIT / THREAD_COUNT) * i;
            executor.execute(new FactorialCalculator(start, end, digits));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long sum = 0;
        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            sum = (sum * 1000000000 + digits.get(i)) % 1000000000;
        }
        System.out.println(sum);
    }

    private static class FactorialCalculator implements Runnable {

        private final long start;
        private final long end;
        private final AtomicLongArray digits;

        public FactorialCalculator(long start, long end, AtomicLongArray digits) {
            this.start = start;
            this.end = end;
            this.digits = digits;
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                int carry = 0;
                for (int j = 0; j < NUM_DIGITS; j++) {
                    long product = digits.get(j) * i + carry;
                    digits.set(j, product % 1000000000);
                    carry = (int) (product / 1000000000);
                }
            }
        }
    }
}











/**
 * public class FactorialOfLargeNumbers {
 *     public static void main(String[] args) {
 *         int[] digits = new int[1000];
 *         digits[0] = 1;
 *         int len = 1;
 *         for (int i = 2; i <= 202320232023L; i++) {
 *             int carry = 0;
 *             for (int j = 0; j < len; j++) {
 *                 int product = digits[j] * i + carry;
 *                 digits[j] = product % 10;
 *                 carry = product / 10;
 *             }
 *             while (carry != 0) {
 *                 digits[len] = carry % 10;
 *                 carry /= 10;
 *                 len++;
 *             }
 *         }
 *         long sum = 0;
 *         for (int i = len - 1, count = 0; i >= 0 && count < 9; i--, count++) {
 *             sum = sum * 10 + digits[i];
 *         }
 *         System.out.println(sum);
 *     }
 * }
 * */



/**
 * public class FactorialOfLargeNumbers {
 *     public static void main(String[] args) {
 *         int[] digits = new int[9];
 *         digits[0] = 1;
 *         for (int i = 2; i <= 202320232023L; i++) {
 *             int carry = 0;
 *             int k = i;
 *             for (int j = 0; j < digits.length && k > 0; j++) {
 *                 int product = digits[j] * (k & 0x1) + carry;
 *                 digits[j] = product % 1000000000;
 *                 carry = product >>> 30;
 *                 k >>>= 1;
 *             }
 *             while (k > 0) {
 *                 int newDigits[] = new int[digits.length];
 *                 carry = 0;
 *                 for (int j = 0; j < digits.length; j++) {
 *                     int product = digits[j] * (k & 0x1) + carry;
 *                     newDigits[j] = product % 1000000000;
 *                     carry = product >>> 30;
 *                 }
 *                 digits = newDigits;
 *                 k >>>= 1;
 *             }
 *         }
 *         long sum = 0;
 *         for (int i = digits.length - 1; i >= 0; i--) {
 *             sum = (sum * 1000000000 + digits[i]) % 1000000000;
 *         }
 *         System.out.println(sum);
 *     }
 * }
 * */

/**
 *import java.math.BigInteger;
 *
 * public class FactorialOfLargeNumbers {
 *     public static void main(String[] args) {
 *         BigInteger sum = BigInteger.ZERO;
 *         BigInteger factorial = BigInteger.ONE;
 *         for (long i = 2; i <= 202320232023L; i++) {
 *             factorial = factorial.multiply(BigInteger.valueOf(i));
 *             sum = sum.add(factorial);
 *         }
 *         String result = sum.toString();
 *         System.out.println(result.substring(result.length() - 9));
 *     }
 * }
 *
 * */