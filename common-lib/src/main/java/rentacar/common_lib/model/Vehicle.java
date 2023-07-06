/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 *
 * The Vehicle class represents a vehicle with various attributes. It provides
 * information about the vehicle's brand, model, mileage, availability, and
 * type.
 *
 * @author Somika
 */
public class Vehicle implements Serializable {

	/**
	 * The unique identifier for the vehicle.
	 */
	private Long id;

	/**
	 * The brand of the vehicle.
	 */
	private String brand;

	/**
	 * The model of the vehicle.
	 */
	private String model;

	/**
	 * The mileage of the vehicle.
	 */
	private int mileage;

	/**
	 * The availability status of the vehicle.
	 */
	private boolean availability;

	/**
	 * The type of the vehicle.
	 */
	private TypeOfVehicle typeOfVehicle;

	/**
	 * Constructs a new Vehicle object with default values.
	 */
	public Vehicle() {
	}

	/**
	 * Constructs a new Vehicle object with the specified values.
	 *
	 * @param id            The unique identifier for the vehicle.
	 * @param brand         The brand of the vehicle.
	 * @param model         The model of the vehicle.
	 * @param mileage       The mileage of the vehicle.
	 * @param availability  The availability status of the vehicle.
	 * @param typeOfVehicle The type of the vehicle.
	 */
	public Vehicle(Long id, String brand, String model, int mileage, boolean availability,
			TypeOfVehicle typeOfVehicle) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.mileage = mileage;
		this.availability = availability;
		this.typeOfVehicle = typeOfVehicle;
	}

	/**
	 * Returns the unique identifier for the vehicle.
	 *
	 * @return The unique identifier for the vehicle.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the vehicle.
	 *
	 * @param id The unique identifier for the vehicle.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the brand of the vehicle.
	 *
	 * @return The brand of the vehicle.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand of the vehicle.
	 *
	 * @param brand The brand of the vehicle.
	 * @throws IllegalArgumentException if the brand is null or empty.
	 */
	public void setBrand(String brand) {
		if (brand == null || brand.trim().isEmpty()) {
			throw new IllegalArgumentException("Brand cannot be null or empty.");
		}
		this.brand = brand;
	}

	/**
	 * Returns the model of the vehicle.
	 *
	 * @return The model of the vehicle.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of the vehicle.
	 *
	 * @param model The model of the vehicle.
	 * @throws IllegalArgumentException if the model is null or empty.
	 */
	public void setModel(String model) {
		if (model == null || model.trim().isEmpty()) {
			throw new IllegalArgumentException("Model cannot be null or empty.");
		}
		this.model = model;
	}

	/**
	 * Returns the mileage of the vehicle.
	 *
	 * @return The mileage of the vehicle.
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * Sets the mileage of the vehicle.
	 *
	 * @param mileage The mileage of the vehicle.
	 */

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	/**
	 * Returns the availability status of the vehicle.
	 *
	 * @return The availability status of the vehicle.
	 */
	public boolean isAvailability() {
		return availability;
	}

	/**
	 * Sets the availability status of the vehicle.
	 *
	 * @param availability The availability status of the vehicle.
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	/**
	 * Returns the type of the vehicle.
	 *
	 * @return The type of the vehicle.
	 */
	public TypeOfVehicle getTypeOfVehicle() {
		return typeOfVehicle;
	}

	/**
	 * Sets the type of the vehicle.
	 *
	 * @param typeOfVehicle The type of the vehicle.
	 * @throws NullPointerException if the type of vehicle is null.
	 */
	public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
		if (typeOfVehicle == null) {
			throw new NullPointerException("Type of vehicle cannot be null.");
		}
		this.typeOfVehicle = typeOfVehicle;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	/**
	 * Checks if this vehicle is equal to the specified object.
	 *
	 * @param obj The object to compare with this vehicle.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Vehicle{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", mileage="
				+ mileage + ", availability=" + availability + ", typeOfVehicle=" + typeOfVehicle + '}';
	}

}
