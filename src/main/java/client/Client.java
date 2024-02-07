package client;

import java.io.*;
import java.net.Socket;

public class Client {



    public static void main(String[] args) {
        int portNumber = 43555;
        try {
            Socket socket = new Socket("localhost", portNumber);


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            out.println("hello");

            System.out.println(in);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
