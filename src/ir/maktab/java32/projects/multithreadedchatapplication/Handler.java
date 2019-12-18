package ir.maktab.java32.projects.multithreadedchatapplication;

import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {
    private Socket client;

    public Handler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = client.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            InputStream inputStream = client.getInputStream();
            BufferedReader received = new BufferedReader(new InputStreamReader(inputStream));

            String receivedMessage, sendMessage;

            while (true) {
                if ((receivedMessage = received.readLine()) != null)
                    System.out.println("Client " + Thread.currentThread().getId() + " :" + receivedMessage);
                sendMessage = keyReader.readLine();
                printWriter.println(sendMessage);
            }
        } catch (IOException ignored) {
        }
    }
}
