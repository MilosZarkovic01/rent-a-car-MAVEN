package rentacar.common_lib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rentacar.common_lib.model.enumeration.Currency;

class RentingTest {

	private Renting renting1;
	private Renting renting2;
	private PriceListItem priceListItem;
	private Vehicle vehicle;
	private Client client;
	private Currency currency;

	@BeforeEach
	void setUp() {
		priceListItem = new PriceListItem();
		vehicle = new Vehicle();
		client = new Client();
		currency = Currency.EUR;

		renting1 = new Renting(1L, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 5), BigDecimal.valueOf(500.0),
				currency, vehicle, client, priceListItem);
		renting2 = new Renting(1L, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 5), BigDecimal.valueOf(500.0),
				currency, vehicle, client, priceListItem);
	}

	@AfterEach
	void tearDown() {
		renting1 = null;
		renting2 = null;
		priceListItem = null;
		vehicle = null;
		client = null;
		currency = null;
	}

	@Test
	void testGetId() {
		assertEquals(1L, renting1.getId());
	}

	@Test
	void testSetId() {
		renting1.setId(2L);
		assertEquals(2L, renting1.getId());
	}

	@Test
	void testGetDateFrom() {
		assertEquals(LocalDate.of(2023, 1, 1), renting1.getDateFrom());
	}

	@Test
	void testSetDateFrom() {
		LocalDate newDateFrom = LocalDate.of(2023, 2, 1);
		renting1.setDateFrom(newDateFrom);
		assertEquals(newDateFrom, renting1.getDateFrom());
	}

	@Test
	void testSetDateFrom_NullDateFrom() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setDateFrom(null);
		});
	}

	@Test
	void testGetDateTo() {
		assertEquals(LocalDate.of(2023, 1, 5), renting1.getDateTo());
	}

	@Test
	void testSetDateTo() {
		LocalDate newDateTo = LocalDate.of(2023, 2, 5);
		renting1.setDateTo(newDateTo);
		assertEquals(newDateTo, renting1.getDateTo());
	}

	@Test
	void testSetDateTo_NullDateTo() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setDateTo(null);
		});
	}

	@Test
	void testGetTotalAmount() {
		assertEquals(BigDecimal.valueOf(500.0), renting1.getTotalAmount());
	}

	@Test
	void testSetTotalAmount() {
		BigDecimal newTotalAmount = BigDecimal.valueOf(1000.0);
		renting1.setTotalAmount(newTotalAmount);
		assertEquals(newTotalAmount, renting1.getTotalAmount());
	}

	@Test
	void testSetTotalAmount_NullTotalAmount() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setTotalAmount(null);
		});
	}

	@Test
	void testSetTotalAmount_NegativeTotalAmount() {
		assertThrows(IllegalArgumentException.class, () -> {
			renting1.setTotalAmount(BigDecimal.valueOf(-500.0));
		});
	}

	@Test
	void testGetCurrency() {
		assertEquals(currency, renting1.getCurrency());
	}

	@Test
	void testSetCurrency() {
		Currency newCurrency = Currency.USD;
		renting1.setCurrency(newCurrency);
		assertEquals(newCurrency, renting1.getCurrency());
	}

	@Test
	void testSetCurrency_NullCurrency() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setCurrency(null);
		});
	}

	@Test
	void testGetVehicle() {
		assertEquals(vehicle, renting1.getVehicle());
	}

	@Test
	void testSetVehicle() {
		Vehicle newVehicle = new Vehicle();
		newVehicle.setId(1L);
		renting1.setVehicle(newVehicle);
		assertEquals(newVehicle, renting1.getVehicle());
	}

	@Test
	void testSetVehicle_NullVehicle() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setVehicle(null);
		});
	}

	@Test
	void testGetClient() {
		assertEquals(client, renting1.getClient());
	}

	@Test
	void testSetClient() {
		Client newClient = new Client();
		newClient.setId(1L);
		renting1.setClient(newClient);
		assertEquals(newClient, renting1.getClient());
	}

	@Test
	void testSetClient_NullClient_ThrowsNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setClient(null);
		});
	}

	@Test
	void testGetPriceListItem() {
		assertEquals(priceListItem, renting1.getPriceListItem());
	}

	@Test
	void testSetPriceListItem() {
		PriceListItem newPriceListItem = new PriceListItem();
		newPriceListItem.setId(1L);
		renting1.setPriceListItem(newPriceListItem);
		assertEquals(newPriceListItem, renting1.getPriceListItem());
	}

	@Test
	void testSetPriceListItem_NullPriceListItem() {
		assertThrows(NullPointerException.class, () -> {
			renting1.setPriceListItem(null);
		});
	}

	@Test
	void testEquals_SameObject_ReturnsTrue() {
		assertTrue(renting1.equals(renting1));
	}

	@Test
	void testEquals_NullObject_ReturnsFalse() {
		assertFalse(renting1.equals(null));
	}

	@Test
	void testEquals_DifferentClass_ReturnsFalse() {
		assertFalse(renting1.equals("not a Renting object"));
	}

	@Test
	void testEquals_EqualRentingObjects_ReturnsTrue() {
		assertTrue(renting1.equals(renting2));
	}

	@Test
	void testEquals_DifferentId_ReturnsFalse() {
		Renting differentRenting = new Renting(2L, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 5),
				BigDecimal.valueOf(500.0), currency, vehicle, client, priceListItem);
		assertFalse(renting1.equals(differentRenting));
	}

}
