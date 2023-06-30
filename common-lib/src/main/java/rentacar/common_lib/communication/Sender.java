/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.communication;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 
 * The Sender class is responsible for sending objects over a network socket.
 * 
 * It provides a method to send an object through the socket connection.
 * 
 * The send method takes an object as a parameter and sends it through the
 * socket's output stream. The object must be serializable in order to be sent.
 * 
 * 
 * The Sender class assumes that the socket has already been established and is
 * ready for communication.
 * 
 * 
 * @author Somika
 */
public class Sender {

	private Socket socket;

	/**
	 * 
	 * Constructs a Sender object with the specified socket.
	 * 
	 * @param socket the socket used for communication
	 */
	public Sender(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 
	 * Sends an object through the socket's output stream.
	 * 
	 * @param object the object to be sent
	 * @throws Exception if an error occurs while sending the object
	 */
	public void send(Object object) throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(object);
			out.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error sending object!\n" + ex.getMessage());
		}
	}
}
