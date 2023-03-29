package Solutions;

import java.util.ArrayList;
import java.util.List;


public class memoryReclamationTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                numbers.remove(number);
            }
        }
    }
}
