package CSModernForNetWork.TCP;

import CSModernForNetWork.TCP.Client;
import CSModernForNetWork.TCP.Server;


public class TCPPullUp {
    public static void pullUp() {
        Thread serverThread = new Thread(() -> {
            System.out.println("Start Server Side...");
            Server.main(null);
        });

        Thread clientThread = new Thread(() -> {
            System.out.println("Start Client Side...");
            Client.main(null);
        });

        serverThread.start();
        clientThread.start();
    }
}

