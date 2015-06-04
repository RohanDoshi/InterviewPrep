import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SSock {

	public static void main(String args[]) {
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
