package CSModernForNetWork.UDP;

import CSModernForNetWork.UDP.Client;
import CSModernForNetWork.UDP.Server;

public class UDPPullUp {
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



