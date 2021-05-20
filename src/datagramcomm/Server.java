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
public class Server {
    
    public static void main(String[] args) throws Exception {
        try (DatagramSocket ds = new DatagramSocket(2000)) {
            byte b[] = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b, 1024);
            ds.receive(dp);
            
            String message = new String(dp.getData()).trim();
            System.out.println("From Client: " + message);
            
            StringBuffer sb = new StringBuffer(message).reverse();
            message = sb.toString();
            
            dp = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 2001);
            
            ds.send(dp);
        }
    }
    
}
