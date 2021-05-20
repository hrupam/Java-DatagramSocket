/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramcomm;

import java.net.*;
import java.io.*;

/**
 *
 * @author rupam
 */
public class DatagramComm {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        try (DatagramSocket ds = new DatagramSocket(2001)) {
            String message = "Hello World";
            DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 2000);
            ds.send(dp);

            byte b[] = new byte[1024];
            dp = new DatagramPacket(b, 1024);
            ds.receive(dp);

            message = new String(dp.getData()).trim();
            System.out.println("From Server: " + message);
        }

    }

}
