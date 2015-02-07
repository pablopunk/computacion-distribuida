import java.io.*;
import java.net.*;

public class Servidor implements Runnable {

	ServerSocket s;
	Socket socket;

	public static void main(String[] args) {
		(new Thread(new Servidor())).start();
	}

	public void run() { // Codigo del server
		String cadena = "";

		try {
			s = new ServerSocket(1234);
			socket = new Socket();
			socket.setReuseAddress(true);
			while (!cadena.equals("stop")) {
				socket = s.accept();
				DataInputStream input = new DataInputStream(socket.getInputStream());
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				cadena = input.readUTF();
				System.out.println(cadena);
				output.writeUTF("Hola desde el Servidor!");
			}
			socket.close();
			s.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}