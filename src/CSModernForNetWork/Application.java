package CSModernForNetWork;

import CSModernForNetWork.TCP.TCPPullUp;
import CSModernForNetWork.UDP.UDPPullUp;
public class Application {
    public static void main(String[] args) {
        System.out.println("Choose the mode:");
        System.out.println("1. TCP");
        System.out.println("2. UDP");

        int mode = 2; // 设置模式，1为TCP，2为UDP

        switch (mode) {
            case 1:
                startTCP();
                break;
            case 2:
                startUDP();
                break;
            default:
                System.out.println("Invalid mode.");
        }
    }

    private static void startTCP() {
        TCPPullUp.pullUp();
    }
    private static void startUDP() {
        UDPPullUp.pullUp();
    }
}
