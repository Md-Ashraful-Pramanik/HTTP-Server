package server;

import common.CONSTANT;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket=new ServerSocket(CONSTANT.PORT);

            while (true){
                System.out.println("Waiting for connecting Client...");
                Socket socket=serverSocket.accept();
                Worker worker=new Worker(socket);
                new Thread(worker).start();
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Server not worked.");
        }
    }
}
