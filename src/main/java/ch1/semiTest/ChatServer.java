package ch1.semiTest;

import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer {
	private int port;
	private Set<String> userNames = new HashSet<>();
	private Set<UserThread> userThreads = new HashSet<>();
	
	public ChatServer(int port) {
		this.port = port;
	}
	
	public void execute() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			
			System.out.println("Chat Server is listening on port " + port);
			
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New user connected");
				
				UserThread newUser = new UserThread(socket, this);
				userThreads.add(newUser);
				newUser.start();
				
			}
			
		} catch (IOException ex) {
			System.out.println("Error in the server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Syntax: java ChatServer <port-number>");
			System.exit(0);
		}
		
		int port = Integer.parseInt(args[0]);
		
		ChatServer server = new ChatServer(port);
		server.execute();
	}
	
	/**
	 * 다른 사용자로부터 메시지를 전송합니다(broadcasting)
	 */
	void broadcast(String message, UserThread excludeUser) {
		for (UserThread aUser : userThreads) {
			if (aUser != excludeUser) {
				aUser.sendMessage(message);
			}
		}
	}
	
	/**
	 * 새로 연결된 클라이언트의 사용자 이름을 저장합니다.
	 */
	void addUserName(String userName) {
		userNames.add(userName);
	}
	
	/**
	 * 클라이언트와의 연결이 종료 될 때, 연결된 사용자 이름 및 사용자 스레드를 제거합니다.
	 */
	void removeUser(String userName, UserThread aUser) {
		boolean removed = userNames.remove(userName);
		if (removed) {
			userThreads.remove(aUser);
			System.out.println("The user " + userName + " quitted");
		}
	}
	
	Set<String> getUserNames() {
		return this.userNames;
	}
	
	/**
	 * 연결된 다른 사용자가 있으면 true를 반환합니다(현재 연결된 사용자는 계산하지 않음).
	 */
	boolean hasUsers() {
		return !this.userNames.isEmpty();
	}
}