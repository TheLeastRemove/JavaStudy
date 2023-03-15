package Solutions;
//导入套接字类
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.ServerSocket;


public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket clientSocket = serverSocket.accept();
        // 获取客户端输出流
        OutputStream outputStream = clientSocket.getOutputStream();

        // 发送数据
        outputStream.write("Hello, World!".getBytes());

        // 获取客户端输入流
        InputStream inputStream = clientSocket.getInputStream();
        // 接收数据
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        String data = new String(buffer, 0, length);

        clientSocket.close();
        serverSocket.close();
    }
}
