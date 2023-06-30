/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.communication;

import rentacar.common_lib.model.enumeration.Operation;
import java.io.Serializable;

/**
 *
 * @author Somika
 */
public class Request implements Serializable {

    private Operation operation;
    private Object data;

    public Request() {
    }

    public Request(Operation operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "Request [operation=" + operation + ", data=" + data + "]";
	}
    
}
