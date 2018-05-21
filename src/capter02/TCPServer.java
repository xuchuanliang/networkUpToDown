package capter02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class TCPServer {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
                Socket socket = serverSocket.accept();
                if(null!=socket){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                System.out.println("接收到socket");
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                String fromClient = bufferedReader.readLine();
                                System.out.println(fromClient);
                                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                                dataOutputStream.writeBytes("hahaha,我收到了 88"+"\n");
                                dataOutputStream.flush();
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
