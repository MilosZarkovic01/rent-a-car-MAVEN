/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Somika
 */
public class Client implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String telNumber;

    public Client() {
    }

    public Client(Long id, String firstName, String lastName, String telNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telNumber = telNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("First name cannot be null.");
        }
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("Last name cannot be null.");
        }
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public String getTelNumber() {
        return telNumber;
    }

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

    public boolean isEmpty() {
        return id == null && firstName == null && lastName == null && telNumber == null;
    }
}
