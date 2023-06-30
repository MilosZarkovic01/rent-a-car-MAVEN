/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.communication;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * 
 * The Receiver class is responsible for receiving objects over a socket
 * connection.
 * 
 * It uses an ObjectInputStream to read the objects from the input stream of the
 * socket.
 * 
 * 
 * Note: The socket connection must be established before creating an instance
 * of the Receiver class.
 * 
 * @author Somika
 */
public class Recеiver {

	private Socket socket;

	/**
	 * 
	 * Constructs a Receiver object with the specified socket.
	 * 
	 * @param socket the socket for receiving objects
	 */
	public Recеiver(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 
	 * Receives an object from the input stream of the socket.
	 * 
	 * @return the received object
	 * @throws Exception if an error occurs while receiving the object
	 */
	public Object receive() throws Exception {
		try {
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			return in.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error receiving object!\n" + ex.getMessage());
		}
	}
}
