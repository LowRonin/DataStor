package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                System.out.println("Место клиента создано");
                Thread thread = new Thread(clientHandler);
                System.out.println("Клиент подключен");
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
