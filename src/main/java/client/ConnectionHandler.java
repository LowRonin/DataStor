package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionHandler implements Runnable{

    private final int serverSocket;


    public ConnectionHandler(int Socket) {
        this.serverSocket = Socket;
    }


    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 43555);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Max");

            Scanner scanner = new Scanner(System.in);
            out.println(scanner.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //Сервер может находится на разных машинах. Обработчик соединения на стабильной.



}
