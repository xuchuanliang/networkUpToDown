package capter02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args){
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            byte[] send = new byte[1024];
            byte[] receive = new byte[1024];
            while (true){
                DatagramPacket recive = new DatagramPacket(receive,receive.length);
                datagramSocket.receive(recive);
                String receiveString = new String(receive);
                System.out.println(receiveString);
                InetAddress inetAddress = recive.getAddress();
                int port = recive.getPort();
                send = "我收到了".getBytes();
                DatagramPacket sendP = new DatagramPacket(send,send.length,inetAddress,port);
                datagramSocket.send(sendP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
