package ir.maktab.java32.projects.multithreadedchatapplication;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);
        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        InputStream inputStream = socket.getInputStream();
        BufferedReader received = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("Start the chat");

        String receivedMessage, sendMessage;

        while (true) {
            sendMessage = keyReader.readLine();
            printWriter.println(sendMessage);
            if ((receivedMessage = received.readLine()) != null)
                System.out.println("Server: " +receivedMessage);
        }


    }
}
