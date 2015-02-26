/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.*;
import java.util.Arrays;

/**
 *
 * @author pablopunk
 */
public final class MulticastPeer implements Runnable {

    private MulticastSocket s;
    private static final int port = 1182;
    private InetAddress group;

    public MulticastPeer(String host) {
        try {
            group = InetAddress.getByName(host);
            s = new MulticastSocket(port);
            s.joinGroup(group);
            this.startListening();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private MulticastPeer() {
        if (s == null) {
            System.out.println("No se ha inicializado el servidor correctamente");
        }
    }

    public void sendMessage(String msg) {
        try {
            byte[] m = msg.getBytes();
            DatagramPacket messageOut = new DatagramPacket(m, m.length, group, port);
            s.send(messageOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void startListening() {
        (new Thread(new MulticastPeer("224.0.0.1"))).start();
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket msgIn = new DatagramPacket(buffer, buffer.length);
                s.receive(msgIn);
                System.out.println("Recibido: " + Arrays.toString(msgIn.getData()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
