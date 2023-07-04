package rentacar.server.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rentacar.server.persistence.dao.PriceListItemDao;
import rentacar.common_lib.model.PDV;
import rentacar.common_lib.model.PriceList;
import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.enumeration.Currency;
import rentacar.common_lib.model.enumeration.TypeOfPriceListItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

abstract class PriceListItemServiceTest {

	@Mock
	protected PriceListItemDao priceListItemDao;

	protected PriceListItemService priceListItemService;
	protected abstract PriceListItemService createPriceListItemService();
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		priceListItemService = createPriceListItemService();
	}

	@Test
	public void testGetPriceListItems() throws Exception {
		TypeOfVehicle typeOfVehicle = new TypeOfVehicle();
		typeOfVehicle.setId(1L);
		typeOfVehicle.setName("Car");
		Date dateFrom = new Date();

		List<PriceListItem> expectedPriceListItems = new ArrayList<>();
		PriceListItem priceListItem1 = new PriceListItem();
		priceListItem1.setId(1L);
		priceListItem1.setTypeOfVehicle(typeOfVehicle);
		priceListItem1.setTypeOfPriceListItem(TypeOfPriceListItem.PERDAY);
		priceListItem1.setPdv(new PDV(1L, 0.2));
		priceListItem1.setCurrency(Currency.EUR);
		priceListItem1.setPrice(new BigDecimal(99));
		priceListItem1.setPriceList(new PriceList());

		expectedPriceListItems.add(priceListItem1);
		
		PriceListItem priceListItem2 = new PriceListItem();
		priceListItem2.setId(2L);
		priceListItem2.setTypeOfVehicle(typeOfVehicle);
		priceListItem2.setTypeOfPriceListItem(TypeOfPriceListItem.PERHOUR);
		priceListItem2.setPdv(new PDV(2L, 0.3));
		priceListItem2.setCurrency(Currency.RSD);
		priceListItem2.setPrice(new BigDecimal(9500));
		priceListItem2.setPriceList(new PriceList());

		expectedPriceListItems.add(priceListItem2);
		when(priceListItemDao.getPriceListItems(typeOfVehicle, dateFrom)).thenReturn(expectedPriceListItems);

		List<PriceListItem> actualPriceListItems = priceListItemService.getPriceListItems(typeOfVehicle, dateFrom);

		assertNotNull(actualPriceListItems);
		assertEquals(expectedPriceListItems, actualPriceListItems);

		verify(priceListItemDao, times(1)).getPriceListItems(typeOfVehicle, dateFrom);
		verifyNoMoreInteractions(priceListItemDao);
	}

	@Test
	public void testSavePriceListItem() throws Exception {
		PriceListItem priceListItem = new PriceListItem();
		priceListItem.setId(1L);
		priceListItem.setTypeOfVehicle(new TypeOfVehicle(1L,"Truck"));
		priceListItem.setTypeOfPriceListItem(TypeOfPriceListItem.PERDAY);
		priceListItem.setPdv(new PDV(1L, 0.2));
		priceListItem.setCurrency(Currency.EUR);
		priceListItem.setPrice(new BigDecimal(99));
		priceListItem.setPriceList(new PriceList());

		priceListItemService.savePriceListItem(priceListItem);

		verify(priceListItemDao, times(1)).savePriceListItem(priceListItem);
		verifyNoMoreInteractions(priceListItemDao);
	}
}
