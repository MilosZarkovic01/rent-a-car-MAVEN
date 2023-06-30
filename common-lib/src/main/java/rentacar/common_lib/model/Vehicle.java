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
public class Vehicle implements Serializable {

	private Long id;
	private String brand;
	private String model;
	private int mileage;
	private boolean availability;
	private TypeOfVehicle typeOfVehicle;

	public Vehicle() {
	}

	public Vehicle(Long id, String brand, String model, int mileage, boolean availability,
			TypeOfVehicle typeOfVehicle) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.mileage = mileage;
		this.availability = availability;
		this.typeOfVehicle = typeOfVehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		if (brand == null || brand.trim().isEmpty()) {
			throw new IllegalArgumentException("Brand cannot be null or empty.");
		}
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if (model == null || model.trim().isEmpty()) {
			throw new IllegalArgumentException("Model cannot be null or empty.");
		}
		this.model = model;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public TypeOfVehicle getTypeOfVehicle() {
		return typeOfVehicle;
	}

	public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
		if(typeOfVehicle == null) {
			throw new NullPointerException("Type of vehicle cannot be null.");
		}
		this.typeOfVehicle = typeOfVehicle;
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		final Vehicle other = (Vehicle) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Vehicle{" + "id=" + id + ", brand=" + brand + ", model=" + model + ", mileage=" + mileage
				+ ", availability=" + availability + ", typeOfVehicle=" + typeOfVehicle + '}';
	}

}
