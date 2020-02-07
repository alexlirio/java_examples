package br.com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {

	private static ServerSocket server;
	private static int port = 25000;

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		server = new ServerSocket(port);
		while (true) {
			System.out.println("Waiting for client request");
			Socket socket = server.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String messageReceived = (String) ois.readObject();
			System.out.println("Message Received from client: " + messageReceived);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject("Hi Client, we received your message: " + messageReceived);
			ois.close();
			oos.close();
			socket.close();
		}
	}

}