/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import rentacar.common_lib.model.enumeration.Currency;
import rentacar.common_lib.model.enumeration.TypeOfPriceListItem;

/**
 * 
 * The PriceListItem class represents an item in a price list.
 * 
 * It contains the ID, price list, price, PDV, type of price list item,
 * currency, and type of vehicle.
 * 
 * @author Somika
 */
public class PriceListItem implements Serializable {

	/**
	 * The unique identifier for the price list item.
	 */
	private Long id;

	/**
	 * The price list to which this item belongs.
	 */
	private PriceList priceList;

	/**
	 * The price of the item.
	 */
	private BigDecimal price;

	/**
	 * The pdv rate for the item.
	 */
	private PDV pdv;

	/**
	 * The type of the price list item.
	 */
	private TypeOfPriceListItem typeOfPriceListItem;

	/**
	 * The currency of the item's price.
	 */
	private Currency currency;

	/**
	 * The type of vehicle associated with the item.
	 */
	private TypeOfVehicle typeOfVehicle;

	/**
	 * 
	 * Constructs an empty PriceListItem object.
	 */
	public PriceListItem() {
	}

	/**
	 * 
	 * Constructs a PriceListItem object with the specified ID, price list, price,
	 * PDV, type of price list item, currency, and type of vehicle.
	 * 
	 * @param id                  the ID of the price list item
	 * @param priceList           the price list of the item
	 * @param price               the price of the item
	 * @param pdv                 the PDV (Value Added Tax) of the item
	 * @param typeOfPriceListItem the type of the price list item
	 * @param currency            the currency of the item price
	 * @param typeOfVehicle       the type of the vehicle
	 */
	public PriceListItem(Long id, PriceList priceList, BigDecimal price, PDV pdv,
			TypeOfPriceListItem typeOfPriceListItem, Currency currency, TypeOfVehicle typeOfVehicle) {
		this.id = id;
		this.priceList = priceList;
		this.price = price;
		this.pdv = pdv;
		this.typeOfPriceListItem = typeOfPriceListItem;
		this.currency = currency;
		this.typeOfVehicle = typeOfVehicle;
	}

	/**
	 * 
	 * Returns the price list of the item.
	 * 
	 * @return the price list of the item
	 */
	public PriceList getPriceList() {
		return priceList;
	}

	/**
	 * 
	 * Sets the price list of the item.
	 * 
	 * @param priceList the price list to set
	 */
	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	/**
	 * 
	 * Returns the price of the item.
	 * 
	 * @return the price of the item
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 
	 * Sets the price of the item.
	 * 
	 * @param price the price to set
	 * @throws NullPointerException     if the price is null
	 * @throws IllegalArgumentException if the price is negative
	 */
	public void setPrice(BigDecimal price) {
		if (price == null) {
			throw new NullPointerException("Price cannot be null.");
		}
		if (price.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.price = price;
	}

	/**
	 * 
	 * Returns the PDV (Value Added Tax) of the item.
	 * 
	 * @return the PDV of the item
	 */
	public PDV getPdv() {
		return pdv;
	}

	/**
	 * 
	 * Sets the PDV (Value Added Tax) of the item.
	 * 
	 * @param pdv the PDV to set
	 * @throws NullPointerException if the PDV is null
	 */
	public void setPdv(PDV pdv) {
		if (pdv == null) {
			throw new NullPointerException("PDV cannot be null.");
		}
		this.pdv = pdv;
	}

	/**
	 * 
	 * Returns the type of the price list item.
	 * 
	 * @return the type of the price list item
	 */
	public TypeOfPriceListItem getTypeOfPriceListItem() {
		return typeOfPriceListItem;
	}

	/**
	 * 
	 * Sets the type of the price list item.
	 * 
	 * @param typeOfPriceListItem the type of the price list item to set
	 * @throws NullPointerException if the type of price list item is null
	 */
	public void setTypeOfPriceListItem(TypeOfPriceListItem typeOfPriceListItem) {
		if (typeOfPriceListItem == null) {
			throw new NullPointerException("Type of price list item cannot be null.");
		}
		this.typeOfPriceListItem = typeOfPriceListItem;
	}

	/**
	 * 
	 * Returns the currency of the item price.
	 * 
	 * @return the currency of the item price
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * 
	 * Sets the currency of the item price.
	 * 
	 * @param currency the currency to set
	 * @throws NullPointerException if the currency is null
	 */
	public void setCurrency(Currency currency) {
		if (currency == null) {
			throw new NullPointerException("Currency cannot be null.");
		}
		this.currency = currency;
	}

	/**
	 * 
	 * Returns the type of the vehicle.
	 * 
	 * @return the type of the vehicle
	 */
	public TypeOfVehicle getTypeOfVehicle() {
		return typeOfVehicle;
	}

	/**
	 * 
	 * Sets the type of the vehicle.
	 * 
	 * @param typeOfVehicle the type of the vehicle to set
	 * @throws NullPointerException if the type of vehicle is null
	 */
	public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
		if (typeOfVehicle == null) {
			throw new NullPointerException("Type of vehicle cannot be null.");
		}
		this.typeOfVehicle = typeOfVehicle;
	}

	/**
	 * 
	 * Returns the ID of the price list item.
	 * 
	 * @return the ID of the price list item
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Sets the ID of the price list item.
	 * 
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		return hash;
	}

	/**
	 * 
	 * Compares this PriceListItem to the specified object for equality. Returns
	 * true if and only if the given object is also a PriceListItem and both objects
	 * have the same ID.
	 * 
	 * @param obj the object to compare for equality
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
		final PriceListItem other = (PriceListItem) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return price + " " + currency + " " + typeOfPriceListItem;
	}

}
