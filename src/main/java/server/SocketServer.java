package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        //���� �������
        int portNumber = 43555;


        try {
            //��������� �����
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("������ �������; ����:" + portNumber);

            //�������� �����������
            while (true) {
                Socket clientSocket = serverSocket.accept();

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                System.out.println("����� ������� �������");
                Thread thread = new Thread(clientHandler);
                System.out.println("������ ���������");
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("������: " + e.getMessage());
        }
    }
}
