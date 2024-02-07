package server;
import java.io.*;
import java.net.*;

public class SocketServer {

    public static void main(String[] args) {
        //Порт сервера
        int portNumber = 43555;


        try {
            //Серверный сокет
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Сервер запущен; Порт:" + portNumber);

            //Ожидание подключения
            while (true) {
                Socket clientSocket = serverSocket.accept();

            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
