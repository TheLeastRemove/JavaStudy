package CSModernForNetWork.TCP;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // 连接服务器
            Socket socket = new Socket("localhost", 8888);

            // 获取输入流和输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // 从控制台读取两个整数
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter the first integer: ");
            int num1 = Integer.parseInt(consoleInput.readLine());
            System.out.print("Please enter the second integer: ");
            int num2 = Integer.parseInt(consoleInput.readLine());

            // 发送整数到服务器
            out.println(num1);
            out.println(num2);

            // 接收服务器返回的结果
            System.out.println("Calculation results:");
            while (true) {
                String result = in.readLine();
                if (result == null) {
                    break;
                }
                System.out.println(result);
            }

            // 关闭连接
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

