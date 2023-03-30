package ChatWithTwoPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 5000;

    private static final String EXIT_COMMAND = "exit";

    private static final String SERVER_DISCONNECTED_MESSAGE = "Server disconnected";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println(SERVER_DISCONNECTED_MESSAGE);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        System.out.print("Enter your username: ");
        String username = userInput.readLine();
        outputStream.write(username.getBytes());

        new Thread(() -> {
            byte[] buffer = new byte[1024];
            int bytesRead;
            try {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        String inputLine;
        while ((inputLine = userInput.readLine()) != null) {
            outputStream.write((username + ':' + inputLine).getBytes());
            if (EXIT_COMMAND.equals(inputLine)) {
                break;
            }
        }

        socket.close();
    }
}
