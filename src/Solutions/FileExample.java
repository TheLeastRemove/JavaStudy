package Solutions;

import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        // 指定文件路径
        File file = new File("example.txt");

        try {
            // 创建输入流对象
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // 创建输出流对象
            PrintWriter writer = new PrintWriter(new FileWriter(file));

            // 读取文件内容
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            // 写入文件内容
            writer.write("Hello, world!");
            writer.println("This is a new line.");
            writer.print("The end.");

            // 关闭输入流和输出流对象
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
