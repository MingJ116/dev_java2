package ch1.semiTest;

import java.io.*;
import java.net.*;

/**
 * 이 스레드는 사용자의 입력을 읽고 서버로 전송하는 역할을 합니다.
 * 사용자가 'bye'를 입력할 때까지 무한 루프에서 실행됩니다.
 */
public class WriteThread extends Thread {
	private PrintWriter writer;
	private Socket socket;
	private ChatClient client;
	
	public WriteThread(Socket socket, ChatClient client) {
		this.socket = socket;
		this.client = client;
		
		try {
			OutputStream output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
		} catch (IOException ex) {
			System.out.println("Error getting output stream: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void run() {
		
		Console console = System.console();
		
		String userName = console.readLine("\nEnter your name: ");
		client.setUserName(userName);
		writer.println(userName);
		
		String text;
		
		do {
			text = console.readLine("[" + userName + "]: ");
			writer.println(text);
			
		} while (!text.equals("bye"));
		
		try {
			socket.close();
		} catch (IOException ex) {
			
			System.out.println("Error writing to server: " + ex.getMessage());
		}
	}
}
