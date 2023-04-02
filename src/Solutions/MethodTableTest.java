package Solutions;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

public class MethodTableTest implements Runnable{

    public void main(String[] args) {
        MethodTableTest mtt = new MethodTableTest();
        mtt.run();
    }

    /**
     * Returns the square of a number
     * @param x a number
     * @return x squared
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Prints a table with x- and y-values for a method
     * @param from the lower bound for the x-values
     * @param to the upper bound for the x-values
     * @param n the number of rows in the table
     * @param f a method with a double parameter and double return value
     */
    public static void printTable(double from, double to, int n, Method f) {
        // print out the method as table header
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Runnable hello = () -> {
            System.out.println("Hello");
        };
    }

    @Override
    public void run() {
        // get method pointers to the square and sqrt methods
        Method square = null;
        try {
            square = MethodTableTest.class.getMethod("square", double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Method sqrt = null;
        try {
            sqrt = Math.class.getMethod("sqrt", double.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // print tables of x- and y-values
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }
}