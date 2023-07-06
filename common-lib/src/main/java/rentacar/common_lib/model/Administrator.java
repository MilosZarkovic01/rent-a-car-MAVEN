/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * The Administrator class represents an administrator in the system.
 * 
 * It stores information such as ID, username, password, and email.
 * 
 * @author Somika
 */
public class Administrator implements Serializable {

	/**
	 * The unique identifier for the administrator.
	 */
	private Long id;
	/**
	 * The username of the administrator.
	 */

	private String username;
	/**
	 * The password of the administrator.
	 */

	private String password;
	/**
	 * The email address of the administrator.
	 */

	private String email;

	/**
	 * 
	 * Constructs an empty Administrator object.
	 */
	public Administrator() {
	}

	/**
	 * 
	 * Constructs an Administrator object with the specified ID, username, password,
	 * and email.
	 * 
	 * @param id       the ID of the administrator
	 * @param username the username of the administrator
	 * @param password the password of the administrator
	 * @param email    the email of the administrator
	 */
	public Administrator(Long id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/**
	 * 
	 * Returns the ID of the administrator.
	 * 
	 * @return the ID of the administrator
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the ID of the administrator.
	 * 
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Returns the username of the administrator.
	 * 
	 * @return the username of the administrator
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * Sets the username of the administrator.
	 * 
	 * @param username the username to set
	 * @throws NullPointerException     if the username is null
	 * @throws IllegalArgumentException if the username is empty
	 */
	public void setUsername(String username) {
		if (username == null) {
			throw new NullPointerException("Username cannot be null.");
		}
		if (username.isEmpty()) {
			throw new IllegalArgumentException("Username cannot be empty.");
		}
		this.username = username;
	}

	/**
	 * 
	 * Returns the password of the administrator.
	 * 
	 * @return the password of the administrator
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * Sets the password of the administrator.
	 * 
	 * @param password the password to set
	 * @throws NullPointerException     if the password is null
	 * @throws IllegalArgumentException if the password is empty
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new NullPointerException("Password cannot be null.");
		}
		if (password.isEmpty()) {
			throw new IllegalArgumentException("Password cannot be empty.");
		}
		this.password = password;
	}

	/**
	 * 
	 * Returns the email of the administrator.
	 * 
	 * @return the email of the administrator
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * Sets the email of the administrator.
	 * 
	 * @param email the email to set
	 * @throws NullPointerException     if the email is null
	 * @throws IllegalArgumentException if the email is empty
	 */
	public void setEmail(String email) {
		if (email == null) {
			throw new NullPointerException("Email cannot be null.");
		}
		if (email.isEmpty()) {
			throw new IllegalArgumentException("Email cannot be empty.");
		}
		this.email = email;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	/**
	 * Checks if the administrator is equal to another object.
	 *
	 * @param obj the object to compare
	 * @return true if the administrator is equal to the other object, false
	 *         otherwise
	 */
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
		final Administrator other = (Administrator) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Administrator{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ '}';
	}

}
