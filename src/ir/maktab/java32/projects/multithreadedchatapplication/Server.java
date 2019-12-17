package ir.maktab.java32.projects.multithreadedchatapplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is ready for chat");
        Socket socket = serverSocket.accept();
        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        InputStream inputStream = socket.getInputStream();
        BufferedReader received = new BufferedReader(new InputStreamReader(inputStream));

        String receivedMessage, sendMessage;

        while (true) {
            if ((receivedMessage = received.readLine()) != null)
                System.out.println("Client: " +receivedMessage);
            sendMessage = keyReader.readLine();
            printWriter.println(sendMessage);
        }
    }
}
