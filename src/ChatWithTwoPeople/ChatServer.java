package ChatWithTwoPeople;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static final int PORT = 5000;
    private List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new ChatServer().startServer();
    }

    private void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server is listening on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
                clients.add(socket);
                new Thread(() -> handleClient(socket)).start();
            }
        }
    }

    private void handleClient(Socket socket) {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);
                broadcastMessage(message, socket);
            }
            System.out.println("User disconnected");
            clients.remove(socket);
            broadcastMessage("User disconnected", socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message, Socket sender) {
        for (Socket client : clients) {
            if (client != sender) {
                try {
                    client.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

