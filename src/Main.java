import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int[][] matrix = new int[6][6];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
