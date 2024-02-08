package server;

import java.io.*;
import java.net.Socket;

//������ ����������. ���������� � ��� ���� ������. ��� ������ ������ ������������, �������� ����� ������ ��������� � ������������ � ������� ���������

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
            //������ ����� ������
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            //�������� ������
            boolean auth = false;
            System.out.println("�������� ������: ������ " + auth);

            while (auth == false){
                login = in.readLine();
               auth = Authenticator.auth(login, login);
            }
            System.out.println("������ "+auth);
            //�������� ����������� � ��������
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("������ ����������� �������: " + e.getMessage());
        }
    }
}
