package CSModernForNetWork.TCP;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // 创建服务器端Socket，监听指定端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server started waiting for client connection...");

            // 接受客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // 获取输入流和输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 读取客户端发送的两个整数
            int num1 = Integer.parseInt(in.readLine());
            int num2 = Integer.parseInt(in.readLine());

            // 计算和、差、积、商
            int sum = num1 + num2;
            int difference = num1 - num2;
            int product = num1 * num2;
            double quotient = (double) num1 / num2;

            // 将结果发送回客户端
            out.println("And:" + sum);
            out.println("Poor:" + difference);
            out.println("Product:" + product);
            out.println("Business:" + quotient);

            // 关闭连接
            System.out.println("Close connection.");
            clientSocket.close();
            serverSocket.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

