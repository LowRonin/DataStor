package server;

import java.io.*;
import java.net.Socket;

//Ввести авторизцию. Подключить к ней базу данных. Как только клиент авторизуется, получает адрес своего хранилища и подключается к серверу датастора

public class ConnectionHandler implements Runnable {
    private final Socket clientSocket;

    private String login;
    private String pass;
    public ConnectionHandler(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run(){
        try {
            //Потоки воода вывода
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            //Приемник данных
            boolean auth = false;
            System.out.println("Ожидание логина: доступ " + auth);

            while (auth == false){
                login = in.readLine();
               auth = Authenticator.auth(login, login);
            }
            System.out.println("доступ "+auth);
            //Закрытие соедениения с клиентом
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("Ошибка обработчика клиента: " + e.getMessage());
        }
    }
}
