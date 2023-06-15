package CSModernForNetWork.TCP;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientScanner {
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 8888;
    private static final int SCAN_INTERVAL = 5000; // 扫描间隔时间，单位：毫秒

    public static void main(String[] args) {
        while (true) {
            boolean isServerOnline = checkServerOnline();
            if (isServerOnline) {
                System.out.println("Server is online.");
                break;
            } else {
                System.out.println("Server is offline. Waiting for the server to come online...");
                try {
                    Thread.sleep(SCAN_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean checkServerOnline() {
        try {
            SocketAddress serverAddress = new InetSocketAddress(SERVER_HOST, SERVER_PORT);
            Socket socket = new Socket();
            socket.connect(serverAddress, SCAN_INTERVAL);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}


