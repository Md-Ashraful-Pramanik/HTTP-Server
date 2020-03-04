package server;

import common.CONSTANT;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Worker implements Runnable {
    ObjectOutputStream ous;
    ObjectInputStream ois;

    Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ous=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());

            Object receivedObject;

            while (true){

            }

        } catch (Exception e) {
            //e.printStackTrace();
            return;
        }

    }
}
