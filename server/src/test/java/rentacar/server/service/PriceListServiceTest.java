package rentacar.server.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rentacar.server.persistence.dao.PriceListDao;
import rentacar.common_lib.model.PriceList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

abstract class PriceListServiceTest {

    @Mock
    protected PriceListDao priceListDao;

    protected PriceListService priceListService;
    protected abstract PriceListService createPriceListService();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        priceListService = createPriceListService();
    }

    @Test
    public void testSavePriceList() throws Exception {
        PriceList priceList = new PriceList();
        // Set the properties of the price list

        Long expectedId = 1L;
        when(priceListDao.save(priceList)).thenReturn(expectedId);

        Long actualId = priceListService.savePriceList(priceList);

        assertNotNull(actualId);
        assertEquals(expectedId, actualId);

        verify(priceListDao, times(1)).save(priceList);
        verifyNoMoreInteractions(priceListDao);
    }
}

