package ch1.semiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
	private BufferedReader reader;
	private Socket socket;
	private ChatClient client;
	
	public ReadThread (Socket socket, ChatClient client) {
		this.socket = socket;
		this.client = client;
		
		try {
			InputStream input = socket.getInputStream ();
			reader = new BufferedReader (new InputStreamReader (input));
		} catch (IOException ex) {
			System.out.println ("Error getting input stream: " + ex.getMessage ());
			ex.printStackTrace ();
		}
	}
	
	public void run () {
		while (true) {
			try {
				String response = reader.readLine ();
				System.out.println ("\n" + response);
				
				// 서버의 메시지를 표시한 후 사용자 이름을 출력합니다.
				if (client.getUserName () != null) {
					System.out.print ("[" + client.getUserName () + "]: ");
				}
			} catch (IOException ex) {
				System.out.println ("Error reading from server: " + ex.getMessage ());
				ex.printStackTrace ();
				break;
			}
		}
	}
}
