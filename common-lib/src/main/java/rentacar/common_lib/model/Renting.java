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
 * @author Somika
 */
public class Renting implements Serializable {

	private Long id;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BigDecimal totalAmount;
	private Currency currency;
	private Vehicle vehicle;
	private Client client;
	private PriceListItem priceListItem;

	public Renting() {
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		if (dateFrom == null) {
			throw new NullPointerException("Date from cannot be null.");
		}
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		if (dateTo == null) {
			throw new NullPointerException("Date to cannot be null.");
		}
		this.dateTo = dateTo;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		if (totalAmount == null) {
			throw new NullPointerException("Total amount cannot be null.");
		}
		if (totalAmount.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Total amount cannot be negative.");
		}
		this.totalAmount = totalAmount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		if (currency == null) {
			throw new NullPointerException("Currency cannot be null.");
		}
		this.currency = currency;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		if (vehicle == null) {
			throw new NullPointerException("Vehicle cannot be null.");
		}
		this.vehicle = vehicle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		if (client == null) {
			throw new NullPointerException("Client cannot be null.");
		}
		this.client = client;
	}

	public PriceListItem getPriceListItem() {
		return priceListItem;
	}

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
