package javaStudy.java.网络编程.Socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author dhslegen
 */
public class Main {
    public static void main(String[] args) {
        String s = null;
        Socket socket;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        int i = 0x1F601;
        try {
            socket = new Socket("localhost", 4331);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeInt(i);
            while (true) {
                i = (i + 1);
                s = dataInputStream.readUTF();
                dataOutputStream.writeInt(i);
                System.out.println("客户收到：" + s);
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
