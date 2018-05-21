package capter02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * TCP套接字编程实例
 */
public class TCPClient {
    public static void main(String[] args){
        try {
            BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket("127.0.0.1",8888);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String userIn = fromUser.readLine();
            System.out.println(userIn);
            dataOutputStream.writeBytes(userIn+"\n");
            dataOutputStream.flush();
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverIn = fromServer.readLine();
            System.out.println("from server:"+serverIn+"\n");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
