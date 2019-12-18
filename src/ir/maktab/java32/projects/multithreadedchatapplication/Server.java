package ir.maktab.java32.projects.multithreadedchatapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server is ready for chat");
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        while (true) {
            Socket client = server.accept();
            executorService.execute(new Handler(client));
        }

    }
}
