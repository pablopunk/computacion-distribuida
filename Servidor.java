import java.io.*;
import java.net.*;

public class Servidor implements Runnable {

	static ServerSocket s;
	static Socket socket;
	static String cadena = "";

	public static void main(String[] args) {

		try {
			s = new ServerSocket(1234);
			socket = new Socket();
			socket.setReuseAddress(true);

			while (!cadena.equals("stop")) {
				socket = s.accept();
				(new Thread(new Servidor())).start();
			}
			s.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public void run() { // Codigo del hilo
		try {
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			cadena = input.readUTF();
			System.out.println(cadena);
			output.writeUTF("Hola desde el Servidor!");
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}