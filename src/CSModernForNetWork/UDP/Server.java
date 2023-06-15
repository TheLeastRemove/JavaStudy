package CSModernForNetWork.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);

            System.out.println("Server started. Waiting for client...");

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String input = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received data from client: " + input);

            String[] numbers = input.split(",");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);

            int sum = num1 + num2;
            int difference = num1 - num2;
            int product = num1 * num2;
            double quotient = (double) num1 / num2;

            String result = "Sum: " + sum + ", Difference: " + difference + ", Product: " + product + ", Quotient: " + quotient;

            byte[] sendData = result.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());

            // 发送数据包，并等待确认
            boolean packetSent = false;
            while (!packetSent) {
                serverSocket.send(sendPacket);

                // 等待确认数据包
                byte[] ackData = new byte[1024];
                DatagramPacket ackPacket = new DatagramPacket(ackData, ackData.length);
                try {
                    serverSocket.receive(ackPacket);
                    packetSent = true; // 收到确认，跳出循环
                } catch (Exception e) {
                    System.out.println("Resending data packet...");
                }
            }

            System.out.println("Result sent to client.");

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
