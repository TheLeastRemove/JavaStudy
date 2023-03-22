package Solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookReader {
    public static void main(String[] args) {
        String FILEADDRESS="sourceMaterial/books.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILEADDRESS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String title = tokens[0];
                String author = tokens[1];
                int year = Integer.parseInt(tokens[2]);
                double price = Double.parseDouble(tokens[3]);

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Year: " + year);
                System.out.println("Price: " + price);
                System.out.println("-----------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
