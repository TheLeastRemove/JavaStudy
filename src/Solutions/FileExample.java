package Solutions;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FileExample {
    public static void main(String[] args) {
        // 指定文件路径
        String filePath = "sourceMaterial/example.txt";
//      Class cl = FileExample.class;
//      URL file = cl.getResource(filePath);
        File file = new File(filePath);
        try {
            // 创建输入流对象
            BufferedReader reader = new BufferedReader(new FileReader(file));

            // 创建输出流对象
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));

            // 读取文件内容
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            writer.println("Hello, world!");
            writer.println("This is a new line.");
            writer.println("The end.");

            // 关闭输入流和输出流对象
            reader.close();
            writer.close();

            // 写入文件内容

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
