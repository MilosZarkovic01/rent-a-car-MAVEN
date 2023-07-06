/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * Represents a type of vehicle in the car rental system.
 * 
 * It contains information such as the type ID and name.
 * 
 * The TypeOfVehicle class implements the Serializable interface to support
 * 
 * serialization and deserialization of TypeOfVehicle objects.
 * 
 * @author Somika
 */
public class TypeOfVehicle implements Serializable {

	/**
	 * The unique identifier for the type of vehicle.
	 */
	private Long id;

	/**
	 * The name of the type of vehicle.
	 */
	private String name;

	/**
	 * 
	 * Constructs an empty TypeOfVehicle object.
	 */
	public TypeOfVehicle() {
	}

	/**
	 * 
	 * Constructs a TypeOfVehicle object with the specified parameters.
	 * 
	 * @param id   the type ID
	 * @param name the type name
	 */
	public TypeOfVehicle(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 
	 * Returns the type ID.
	 * 
	 * @return the type ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the type ID.
	 * 
	 * @param id the type ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Returns the type name.
	 * 
	 * @return the type name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Sets the type name.
	 * 
	 * @param name the type name to set
	 * @throws IllegalArgumentException if the name is null or empty
	 */
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty.");
		}
		this.name = name;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		return hash;
	}

	/**
	 * 
	 * Compares this TypeOfVehicle object to the specified object. The result is
	 * true if and only if the argument is not null and is a TypeOfVehicle object
	 * with the same ID as this TypeOfVehicle object.
	 * 
	 * @param obj the object to compare
	 * @return true if the objects are equal, false otherwise
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
		final TypeOfVehicle other = (TypeOfVehicle) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return name;
	}

}
