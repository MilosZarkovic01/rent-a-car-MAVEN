/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * The PriceList class represents a price list with a valid period and a list of
 * price list items.
 * 
 * It contains the ID, valid from date, valid to date, and a list of price list
 * items.
 * 
 * @author Somika
 */
public class PriceList implements Serializable {

	/**
	 * The unique identifier for the price list.
	 */
	private Long id;

	/**
	 * The starting date of the price list's validity.
	 */
	private LocalDate validFrom;

	/**
	 * The ending date of the price list's validity.
	 */
	private LocalDate validTo;

	/**
	 * The list of price list items associated with this price list.
	 */
	private List<PriceListItem> priceListItems;

	/**
	 * 
	 * Constructs an empty PriceList object with an empty list of price list items.
	 */
	public PriceList() {
		this.priceListItems = new ArrayList<>();
	}

	/**
	 * 
	 * Constructs a PriceList object with the specified ID, valid from date, valid
	 * to date, and an empty list of price list items.
	 * 
	 * @param id        the ID of the price list
	 * @param validFrom the valid from date of the price list
	 * @param validTo   the valid to date of the price list
	 */
	public PriceList(Long id, LocalDate validFrom, LocalDate validTo) {
		this.id = id;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.priceListItems = new ArrayList<>();
	}

	/**
	 * 
	 * Returns the ID of the price list.
	 * 
	 * @return the ID of the price list
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the ID of the price list.
	 * 
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Returns the valid from date of the price list.
	 * 
	 * @return the valid from date of the price list
	 */
	public LocalDate getDateFrom() {
		return validFrom;
	}

	/**
	 * 
	 * Sets the valid from date of the price list.
	 * 
	 * @throws NullPointerException if valid from is null
	 * @param validFrom the valid from date to set
	 */
	public void setDateFrom(LocalDate validFrom) {
		if (validFrom == null) {
			throw new NullPointerException("Valid from date cannot be null.");
		}
		this.validFrom = validFrom;
	}

	/**
	 * 
	 * Returns the valid to date of the price list.
	 * 
	 * @return the valid to date of the price list
	 */
	public LocalDate getDateTo() {
		return validTo;
	}

	/**
	 * 
	 * Sets the valid to date of the price list.
	 * 
	 * @param validTo the valid to date to set
	 * @throws NullPointerException     if valid to is null
	 * @throws IllegalArgumentException if the valid to date is before the valid
	 *                                  from date
	 */
	public void setDateTo(LocalDate validTo) {
		if (validTo == null) {
			throw new NullPointerException("Valid to date cannot be null.");
		}
		if (validTo.isBefore(validFrom)) {
			throw new IllegalArgumentException("Valid to date cannot be before valid from date.");
		}
		this.validTo = validTo;
	}

	/**
	 * 
	 * Returns the list of price list items.
	 * 
	 * @return the list of price list items
	 */
	public List<PriceListItem> getPriceListItems() {
		return priceListItems;
	}

	/**
	 * 
	 * Sets the list of price list items.
	 * 
	 * @param priceListItems the list of price list items to set
	 * @throws NullPointerException if the list of price list items is null
	 */
	public void setPriceListItems(List<PriceListItem> priceListItems) {
		if (priceListItems == null) {
			throw new NullPointerException("Price list items cannot be null.");
		}
		this.priceListItems = priceListItems;
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
		final PriceList other = (PriceList) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "PriceList{" + "id=" + id + ", validFrom=" + validFrom + ", validTo=" + validTo + ", priceListItems="
				+ priceListItems + '}';
	}

}
