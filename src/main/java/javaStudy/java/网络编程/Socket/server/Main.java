package javaStudy.java.网络编程.Socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dhslegen
 */
public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            serverSocket = new ServerSocket(4331);
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                int i = 0;
                i = dataInputStream.readInt();
                dataOutputStream.writeUTF("你说的数对应的字符为：" + int2emojiChar(i));
                System.out.println("服务器收到：" + i);
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String int2emojiChar(int num) throws UnsupportedEncodingException {
        byte[] result = new byte[4];
        result[0] = (byte) ((num >>> 24) & 0xff);//说明一
        result[1] = (byte) ((num >>> 16) & 0xff);
        result[2] = (byte) ((num >>> 8) & 0xff);
        result[3] = (byte) ((num >>> 0) & 0xff);

        String emojiChar = new String(result, "utf-32");
        return emojiChar;
    }
}
