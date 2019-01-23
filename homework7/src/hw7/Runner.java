package hw7;

import hw7.client.Client;
import hw7.server.MyServer;
import javafx.application.Application;

public class Runner {
    public static void main(String[] args) {
        new Thread(() -> new MyServer()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        new Thread(() -> Application.launch(Client.class, args)).start();
    }
}