package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private final Socket clientSocket;

    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run(){
        try {
            //Потоки воода вывода
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            //Приемник данных
            String inputLine;
            while ((inputLine = in.readLine())!=null){
                System.out.println("Ответ клтенту: " + inputLine);
                out.println("Ответ сервер: " + inputLine);
            }

            //Закрытие соедениения с клиентом
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("Ошибка обработчика клиента: " + e.getMessage());
        }
    }
}
