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
 * @author Somika
 */
public class PriceListItem implements Serializable {

	private Long id;
	private PriceList priceList;
	private BigDecimal price;
	private PDV pdv;
	private TypeOfPriceListItem typeOfPriceListItem;
	private Currency currency;
	private TypeOfVehicle typeOfVehicle;

	public PriceListItem() {
	}

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

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		if (price == null) {
			throw new NullPointerException("Price cannot be null.");
		}
		if (price.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.price = price;
	}

	public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		if (pdv == null) {
			throw new NullPointerException("PDV cannot be null.");
		}
		this.pdv = pdv;
	}

	public TypeOfPriceListItem getTypeOfPriceListItem() {
		return typeOfPriceListItem;
	}

	public void setTypeOfPriceListItem(TypeOfPriceListItem typeOfPriceListItem) {
		if (typeOfPriceListItem == null) {
			throw new NullPointerException("Type of price list item cannot be null.");
		}
		this.typeOfPriceListItem = typeOfPriceListItem;
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

	public TypeOfVehicle getTypeOfVehicle() {
		return typeOfVehicle;
	}

	public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
		if (typeOfVehicle == null) {
			throw new NullPointerException("Type of vehicle cannot be null.");
		}
		this.typeOfVehicle = typeOfVehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 3;
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
		final PriceListItem other = (PriceListItem) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return price + " " + currency + " " + typeOfPriceListItem;
	}

}
