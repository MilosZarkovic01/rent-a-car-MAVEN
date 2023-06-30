package rentacar.common_lib.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceListTest {

	private PriceList priceList;
	private List<PriceListItem> priceListItems;

	@BeforeEach
	public void setUp() {
		priceList = new PriceList();
		priceListItems = new ArrayList<>();
	}

	@AfterEach
	public void tearDown() {
		priceList = null;
		priceListItems = null;
	}

	@Test
	public void testPriceListConstructor() {
		assertNull(priceList.getId());
		assertNull(priceList.getDateFrom());
		assertNull(priceList.getDateTo());
		assertNotNull(priceList.getPriceListItems());
		assertTrue(priceList.getPriceListItems().isEmpty());
	}

	@Test
	public void testGetId() {
		assertNull(priceList.getId());
	}

	@Test
	public void testSetId() {
		priceList.setId(1L);
		assertEquals(1L, priceList.getId());
	}

	@Test
	public void testGetDateFrom() {
		assertNull(priceList.getDateFrom());
	}

	@Test
	public void testSetDateFrom() {
		LocalDate dateFrom = LocalDate.of(2023, 1, 1);
		priceList.setDateFrom(dateFrom);
		assertEquals(dateFrom, priceList.getDateFrom());
	}

	@Test
	public void testSetDateFromWithNull() {
		assertThrows(NullPointerException.class, () -> {
			priceList.setDateFrom(null);
		});
	}

	@Test
	public void testGetDateTo() {
		assertNull(priceList.getDateTo());
	}

	@Test
	public void testSetDateTo() {
		LocalDate dateFrom = LocalDate.of(2023, 1, 1);
		LocalDate dateTo = LocalDate.of(2023, 12, 31);
		priceList.setDateFrom(dateFrom);
		priceList.setDateTo(dateTo);
		assertEquals(dateTo, priceList.getDateTo());
	}

	@Test
	public void testSetDateToWithNull() {
		assertThrows(NullPointerException.class, () -> {
			priceList.setDateTo(null);
		});
	}

	@Test
	public void testSetDateToBeforeDateFrom() {
		LocalDate dateFrom = LocalDate.of(2023, 1, 1);
		LocalDate dateTo = LocalDate.of(2022, 12, 31);
		priceList.setDateFrom(dateFrom);
		assertThrows(IllegalArgumentException.class, () -> {
			priceList.setDateTo(dateTo);
		});
	}

	@Test
	public void testGetPriceListItems() {
		assertNotNull(priceList.getPriceListItems());
		assertTrue(priceList.getPriceListItems().isEmpty());
	}

	@Test
	public void testSetPriceListItemsWithNull() {
		assertThrows(NullPointerException.class, () -> {
			priceList.setPriceListItems(null);
		});
	}

	@ParameterizedTest
	@CsvSource({
	        "1, 2023-01-01, 2023-12-31, 1, 2023-01-01, 2023-12-31, true",
	        "1, 2023-01-01, 2023-12-31, 1, 2023-01-01, 2024-12-31, true",
	        "1, 2023-01-01, 2023-12-31, 2, 2023-01-01, 2023-12-31, false",
	        "1, 2023-01-01, 2023-12-31, 2, 2023-01-01, 2024-12-31, false"
	})
	public void testEquals(Long id1, LocalDate dateFrom1, LocalDate dateTo1,
	                       Long id2, LocalDate dateFrom2, LocalDate dateTo2,
	                       boolean expected) {
	    PriceList priceList1 = new PriceList(id1, dateFrom1, dateTo1);
	    PriceList priceList2 = new PriceList(id2, dateFrom2, dateTo2);
	    assertEquals(expected, priceList1.equals(priceList2));
	}


}
