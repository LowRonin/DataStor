package client;

import java.io.*;
import java.net.Socket;
import java.security.spec.RSAOtherPrimeInfo;

public class Client {



    public static void main(String[] args) {

        ConnectionHandler connectionHandler = new ConnectionHandler(43555);
        Thread thread = new Thread(connectionHandler);
        thread.start();
    }

}
