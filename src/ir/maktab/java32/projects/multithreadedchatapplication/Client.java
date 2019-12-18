package ir.maktab.java32.projects.multithreadedchatapplication;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    private final static String ipAddress = "127.0.0.1";
    private final static int portAddress = 3000;

    public static void main(String[] args) throws IOException {
        List<User> userList = new ArrayList<>();
        User shahabUser = new User("shahab", "1234");
        User mahdiUser = new User("mahdi", "0000");
        User aliUser = new User("ali", "1111");
        boolean login = false;
        boolean ipCheck = false;
        boolean portCheck = false;
        userList.add(aliUser);
        userList.add(shahabUser);
        userList.add(mahdiUser);

        System.out.println("Please enter username : ");
        String username = scanner.nextLine();
        System.out.println("Please enter password : ");
        String password = scanner.nextLine();
        System.out.println("Please enter ip address : ");
        String ip = scanner.nextLine();
        System.out.println("Please enter port : ");
        String port = scanner.nextLine();

        User loginUser = new User(username, password);

        for (User user : userList) {
            if (user.equals(loginUser)) {
                login = true;
                break;
            }
        }
        if (!login)
            System.out.println("Username or password is not true !");
        if (!ip.equals(ipAddress))
            System.out.println("Ip address is not true !");
        else
            ipCheck = true;

        if (portAddress != Integer.parseInt(port))
            System.out.println("Port is not true !");
        else
            portCheck = true;

        if (login && portCheck && ipCheck) {
            Socket socket = new Socket(ipAddress, portAddress);
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
                    System.out.println("Server: " + receivedMessage);
            }
        } else
            System.out.println("Please try again later !!!");
    }
}
