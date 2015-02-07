import java.io.*;
import java.net.*;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",1234);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF("Hola desde el Cliente!");
			System.out.println(input.readUTF());
			socket.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}