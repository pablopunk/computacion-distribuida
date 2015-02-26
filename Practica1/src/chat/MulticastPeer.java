package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import javax.swing.JTextArea;

public class MulticastPeer implements Runnable {

    private MulticastSocket s;
    public JTextArea textArea;
    private final int port = 2345;
    private InetAddress group;
    private final String host = "224.0.0.100";

    public MulticastPeer() {
        try {
            group = InetAddress.getByName(host);
            s = new MulticastSocket(port);
            s.joinGroup(group);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public MulticastPeer(JTextArea ta) {
        try {
            group = InetAddress.getByName(host);
            s = new MulticastSocket(port);
            s.joinGroup(group);
            this.textArea = ta;
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        (new Thread(new MulticastPeer(this.textArea))).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket msgIn = new DatagramPacket(buffer, buffer.length);
                s.receive(msgIn);

                InputStreamReader input = new InputStreamReader(new ByteArrayInputStream(msgIn.getData()), Charset.forName("UTF-8"));
                StringBuilder str = new StringBuilder();
                for (int value; (value = input.read()) != -1;) {
                    str.append((char) value);
                }

                String loquehabia = textArea.getText();
                if (loquehabia == null) {
                    loquehabia = "";
                }
                String nuevo = loquehabia + "\n" + msgIn.getAddress() + ": " + str;
                nuevo = nuevo.trim(); // Quitar espacios finales
                //System.out.println(str); // consola
                textArea.setText(nuevo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
