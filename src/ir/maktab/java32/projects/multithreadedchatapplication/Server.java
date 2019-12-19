package ir.maktab.java32.projects.multithreadedchatapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static ArrayList<User> userList = new ArrayList<>();
    private final static String ipAddress = "127.0.0.1";
    private final static int portAddress = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(portAddress);
        System.out.println("Server is ready for chat");
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        while (true) {
            Socket client = server.accept();
            executorService.execute(new Handler(client));
        }

    }
}
