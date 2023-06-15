package CSModernForNetWork.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            String input = "10,5"; // 输入的两个整数，用逗号分隔
            byte[] sendData = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);

            // 发送数据包，并等待确认
            boolean packetSent = false;
            while (!packetSent) {
                clientSocket.send(sendPacket);

                // 等待确认数据包
                byte[] ackData = new byte[1024];
                DatagramPacket ackPacket = new DatagramPacket(ackData, ackData.length);
                try {
                    clientSocket.receive(ackPacket);
                    packetSent = true; // 收到确认，跳出循环
                } catch (Exception e) {
                    System.out.println("Resending data packet...");
                }
            }

            System.out.println("Data sent to server.");

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Result from server: " + result);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

