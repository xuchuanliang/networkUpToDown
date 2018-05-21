package capter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] sendData = new byte[1024];
            byte[] receiveBype = new byte[1024];
            String from = bufferedReader.readLine();
            sendData = from.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(sendData,sendData.length,InetAddress.getByName("localhost"),8888);
            datagramSocket.send(datagramPacket);
            DatagramPacket receive = new DatagramPacket(receiveBype,receiveBype.length);
            datagramSocket.receive(receive);
            String receiveString = new String(receiveBype);
            System.out.println(receiveString);
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
