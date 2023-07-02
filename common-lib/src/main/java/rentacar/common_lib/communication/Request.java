/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.communication;

import rentacar.common_lib.model.enumeration.Operation;
import java.io.Serializable;

/**
 * 
 * The Request class represents a communication request that includes an
 * operation and data.
 * 
 * It is used for sending requests between client and server in a serialized
 * form.
 * 
 * The operation specifies the type of operation to be performed, and the data
 * holds the relevant information or parameters for the operation.
 * 
 * The Request class implements the Serializable interface, allowing objects of
 * this class to be serialized and deserialized for communication purposes.
 * 
 * @author Somika
 */
public class Request implements Serializable {

	private Operation operation;
	private Object data;
	private Object data2;

	public Request() {
	}

	/**
	 * 
	 * Constructs a Request object with the specified operation and data.
	 * 
	 * @param operation the operation to be performed
	 * @param data      the data associated with the operation
	 */
	public Request(Operation operation, Object data) {
		this.operation = operation;
		this.data = data;
	}

	/**
	 * 
	 * Retrieves the operation of the request.
	 * 
	 * @return the operation of the request
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * 
	 * Sets the operation of the request.
	 * 
	 * @param operation the operation to be set
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * 
	 * Retrieves the data of the request.
	 * 
	 * @return the data of the request
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 
	 * Sets the data of the request.
	 * 
	 * @param data the data to be set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 
	 * Retrieves the data2 of the request.
	 * 
	 * @return the data of the request
	 */
	public Object getData2() {
		return data2;
	}

	/**
	 * 
	 * Sets the data2 of the request.
	 * 
	 * @param data the data to be set
	 */
	public void setData2(Object data2) {
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "Request [operation=" + operation + ", data=" + data + "]";
	}

}
