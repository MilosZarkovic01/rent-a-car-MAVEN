/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.communication;

import java.io.Serializable;

/**
 * 
 * The Response class represents a communication response that includes a result
 * or an exception.
 * 
 * It is used for sending responses between client and server in a serialized
 * form.
 * 
 * The result holds the response data or the result of the requested operation,
 * while the exception represents any exception that occurred during the
 * processing of the request.
 * 
 * The Response class implements the Serializable interface, allowing objects of
 * this class to be serialized and deserialized for communication purposes.
 * </p>
 * 
 * 
 * @author Somika
 */
public class Response implements Serializable {

	private Object result;
	private Exception exception;

	public Response() {
	}

	/**
	 * 
	 * Constructs a Response object with the specified result and exception.
	 * 
	 * @param result    the result or response data
	 * @param exception the exception that occurred during processing, or null if no
	 *                  exception occurred
	 */
	public Response(Object result, Exception exception) {
		this.result = result;
		this.exception = exception;
	}

	/**
	 * 
	 * Retrieves the result of the response.
	 * 
	 * @return the result of the response
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * 
	 * Sets the result of the response.
	 * 
	 * @param result the result to be set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * 
	 * Retrieves the exception of the response.
	 * 
	 * @return the exception of the response
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * 
	 * Sets the exception of the response.
	 * 
	 * @param exception the exception to be set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "Response [result=" + result + ", exception=" + exception + "]";
	}

}
