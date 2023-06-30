/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * The PDV class represents the Value Added Tax (PDV) information.
 * 
 * It contains the ID and percentage value of the PDV.
 * 
 * @author Somika
 */
public class PDV implements Serializable {

	private Long id;
	private double percent;

	/**
	 * 
	 * Constructs an empty PDV object.
	 */
	public PDV() {
	}

	/**
	 * 
	 * Constructs a PDV object with the specified ID and percentage.
	 * 
	 * @param id      the ID of the PDV
	 * @param percent the percentage value of the PDV
	 */
	public PDV(Long id, double percent) {
		this.id = id;
		this.percent = percent;
	}

	/**
	 * 
	 * Returns the ID of the PDV.
	 * 
	 * @return the ID of the PDV
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the ID of the PDV.
	 * 
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Returns the percentage value of the PDV.
	 * 
	 * @return the percentage value of the PDV
	 */
	public double getPercent() {
		return percent;
	}

	/**
	 * 
	 * Sets the percentage value of the PDV.
	 * 
	 * @param percent the percentage value to set
	 * @throws IllegalArgumentException if the percentage value is negative
	 */
	public void setPercent(double percent) {
		if (percent < 0) {
			throw new IllegalArgumentException("Percentage cannot be negative.");
		}
		this.percent = percent;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	/**
	 * 
	 * Compares this PDV object to the specified object. The comparison is based on
	 * the equality of the ID values.
	 * 
	 * @param obj the object to compare to
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
		final PDV other = (PDV) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return percent + "";
	}

}
