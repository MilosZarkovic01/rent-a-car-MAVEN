/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import rentacar.common_lib.model.enumeration.Currency;

/**
 * 
 * Represents a renting transaction in the car rental system.
 * 
 * It contains information such as the renting ID, dates, total amount,
 * 
 * currency, vehicle, client, and price list item associated with the renting.
 * 
 * The Renting class implements the Serializable interface to support
 * 
 * serialization and deserialization of Renting objects.
 * 
 * @author Somika
 */
public class Renting implements Serializable {

	/**
	 * The unique identifier for the renting transaction.
	 */
	private Long id;

	/**
	 * The starting date of the renting period.
	 */
	private LocalDate dateFrom;

	/**
	 * The ending date of the renting period.
	 */
	private LocalDate dateTo;

	/**
	 * The total amount charged for the renting transaction.
	 */
	private BigDecimal totalAmount;

	/**
	 * The currency used for the transaction's amount.
	 */
	private Currency currency;

	/**
	 * The vehicle that is being rented.
	 */
	private Vehicle vehicle;

	/**
	 * The client who is renting the vehicle.
	 */
	private Client client;

	/**
	 * The price list item associated with the renting transaction.
	 */
	private PriceListItem priceListItem;

	/**
	 * 
	 * Constructs an empty Renting object.
	 */
	public Renting() {
	}

	/**
	 * 
	 * Constructs a Renting object with the specified parameters.
	 * 
	 * @param id            the renting ID
	 * @param dateFrom      the starting date of the renting
	 * @param dateTo        the ending date of the renting
	 * @param totalAmount   the total amount for the renting
	 * @param currency      the currency of the renting amount
	 * @param vehicle       the rented vehicle
	 * @param client        the client who rented the vehicle
	 * @param priceListItem the price list item associated with the renting
	 */
	public Renting(Long id, LocalDate dateFrom, LocalDate dateTo, BigDecimal totalAmount, Currency currency,
			Vehicle vehicle, Client client, PriceListItem priceListItem) {
		this.id = id;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.totalAmount = totalAmount;
		this.currency = currency;
		this.vehicle = vehicle;
		this.client = client;
		this.priceListItem = priceListItem;
	}

	/**
	 * 
	 * Returns the renting ID.
	 * 
	 * @return the renting ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the renting ID.
	 * 
	 * @param id the renting ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Returns the starting date of the renting.
	 * 
	 * @return the starting date of the renting
	 */
	public LocalDate getDateFrom() {
		return dateFrom;
	}

	/**
	 * 
	 * Sets the starting date of the renting.
	 * 
	 * @param dateFrom the starting date of the renting to set
	 * @throws NullPointerException if the dateFrom is null
	 */
	public void setDateFrom(LocalDate dateFrom) {
		if (dateFrom == null) {
			throw new NullPointerException("Date from cannot be null.");
		}
		this.dateFrom = dateFrom;
	}

	/**
	 * 
	 * Returns the ending date of the renting.
	 * 
	 * @return the ending date of the renting
	 */
	public LocalDate getDateTo() {
		return dateTo;
	}

	/**
	 * 
	 * Sets the ending date of the renting.
	 * 
	 * @param dateTo the ending date of the renting to set
	 * @throws NullPointerException if the dateTo is null
	 */
	public void setDateTo(LocalDate dateTo) {
		if (dateTo == null) {
			throw new NullPointerException("Date to cannot be null.");
		}
		this.dateTo = dateTo;
	}

	/**
	 * 
	 * Returns the total amount for the renting.
	 * 
	 * @return the total amount for the renting
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 
	 * Sets the total amount for the renting.
	 * 
	 * @param totalAmount the total amount for the renting to set
	 * @throws NullPointerException     if the totalAmount is null
	 * @throws IllegalArgumentException if the totalAmount is negative
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		if (totalAmount == null) {
			throw new NullPointerException("Total amount cannot be null.");
		}
		if (totalAmount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Total amount cannot be negative.");
		}
		this.totalAmount = totalAmount;
	}

	/**
	 * Returns the currency of the renting amount.
	 * 
	 * @return the currency of the renting amount
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency of the renting amount.
	 * 
	 * @param currency the currency of the renting amount to set
	 * @throws NullPointerException if the currency is null
	 */
	public void setCurrency(Currency currency) {
		if (currency == null) {
			throw new NullPointerException("Currency cannot be null.");
		}
		this.currency = currency;
	}

	/**
	 * Returns the rented vehicle.
	 * 
	 * @return the rented vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Sets the rented vehicle.
	 * 
	 * @param vehicle the rented vehicle to set
	 * @throws NullPointerException if the vehicle is null
	 */
	public void setVehicle(Vehicle vehicle) {
		if (vehicle == null) {
			throw new NullPointerException("Vehicle cannot be null.");
		}
		this.vehicle = vehicle;
	}

	/**
	 * Returns the client who rented the vehicle.
	 * 
	 * @return the client who rented the vehicle
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the client who rented the vehicle.
	 * 
	 * @param client the client who rented the vehicle to set
	 * @throws NullPointerException if the client is null
	 */
	public void setClient(Client client) {
		if (client == null) {
			throw new NullPointerException("Client cannot be null.");
		}
		this.client = client;
	}

	/**
	 * Returns the price list item associated with the renting.
	 * 
	 * @return the price list item associated with the renting
	 */
	public PriceListItem getPriceListItem() {
		return priceListItem;
	}

	/**
	 * Sets the price list item associated with the renting.
	 * 
	 * @param priceListItem the price list item associated with the renting to set
	 * @throws NullPointerException if the priceListItem is null
	 */
	public void setPriceListItem(PriceListItem priceListItem) {
		if (priceListItem == null) {
			throw new NullPointerException("Price list item cannot be null.");
		}
		this.priceListItem = priceListItem;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	/**
	 * Compares this Renting object to the specified object. The result is true if
	 * and only if the argument is not null and is a Renting object with the same ID
	 * as this Renting object.
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
		final Renting other = (Renting) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Renting{" + "id=" + id + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", totalAmount="
				+ totalAmount + ", currency=" + currency + ", vehicle=" + vehicle + ", client=" + client
				+ ", priceListItem=" + priceListItem + '}';
	}

}
