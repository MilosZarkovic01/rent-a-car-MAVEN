/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * The Client class represents a client in the car rental system.
 * 
 * It stores information such as the client's ID, first name, last name, and
 * telephone number.
 * 
 * The class provides methods for setting and retrieving these values, as well
 * as overriding
 * 
 * the equals, hashCode, and toString methods.
 * 
 * @author Somika
 */
public class Client implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private String telNumber;

	/**
	 * 
	 * Constructs an empty Client object.
	 */
	public Client() {
	}

	/**
	 * 
	 * Constructs a Client object with the specified ID, first name, last name, and
	 * telephone number.
	 * 
	 * @param id        the client's ID
	 * @param firstName the client's first name
	 * @param lastName  the client's last name
	 * @param telNumber the client's telephone number
	 */
	public Client(Long id, String firstName, String lastName, String telNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
	}

	/**
	 * 
	 * Returns the client's ID.
	 * 
	 * @return the client's ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the client's ID.
	 * 
	 * @param id the client's ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Returns the client's first name.
	 * 
	 * @return the client's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * Sets the client's first name.
	 * 
	 * @param firstName the client's first name to set
	 * @throws NullPointerException     if the first name is null
	 * @throws IllegalArgumentException if the first name is empty
	 */
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new NullPointerException("First name cannot be null.");
		}
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("First name cannot be empty.");
		}
		this.firstName = firstName;
	}

	/**
	 * 
	 * Returns the client's last name.
	 * 
	 * @return the client's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * Sets the client's last name.
	 * 
	 * @param lastName the client's last name to set
	 * @throws NullPointerException     if the last name is null
	 * @throws IllegalArgumentException if the last name is empty
	 */
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new NullPointerException("Last name cannot be null.");
		}
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("Last name cannot be empty.");
		}
		this.lastName = lastName;
	}

	/**
	 * 
	 * Returns the client's telephone number.
	 * 
	 * @return the client's telephone number
	 */
	public String getTelNumber() {
		return telNumber;
	}

	/**
	 * 
	 * Sets the client's telephone number.
	 * 
	 * @param telNumber the client's telephone number to set
	 * @throws NullPointerException     if the telephone number is null
	 * @throws IllegalArgumentException if the telephone number is empty
	 */
	public void setTelNumber(String telNumber) {
		if (telNumber == null) {
			throw new NullPointerException("Telephone number cannot be null.");
		}
		if (telNumber.isEmpty()) {
			throw new IllegalArgumentException("Telephone number cannot be empty.");
		}
		this.telNumber = telNumber;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Client other = (Client) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	/**
	 * Checks whether the Client object is empty. An empty Client object has all
	 * attributes set to null.
	 *
	 * @return true if the Client object is empty, false otherwise
	 */
	@JsonIgnore
	public boolean isEmpty() {
		return id == null && firstName == null && lastName == null && telNumber == null;
	}
}
