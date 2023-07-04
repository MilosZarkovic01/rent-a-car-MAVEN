package rentacar.server.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rentacar.server.persistence.dao.RentingDao;
import rentacar.common_lib.model.Renting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

abstract class RentingServiceTest {

    @Mock
    protected RentingDao rentingDao;

    protected RentingService rentingService;
    protected abstract RentingService createRentingService();
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        rentingService = createRentingService();
    }

    @Test
    public void testGetAll() throws Exception {
        List<Renting> expectedRentings = new ArrayList<>();
        Renting renting1 = new Renting();
        // Set the properties of renting1
        
        expectedRentings.add(renting1);
        when(rentingDao.getAll()).thenReturn(expectedRentings);

        List<Renting> actualRentings = rentingService.getAll();

        assertNotNull(actualRentings);
        assertEquals(expectedRentings, actualRentings);
        assertEquals(actualRentings.size(), 1);

        verify(rentingDao, times(1)).getAll();
        verifyNoMoreInteractions(rentingDao);
    }

    @Test
    public void testSave() throws Exception {
        Renting renting = new Renting();
        
        rentingService.save(renting);

        verify(rentingDao, times(1)).add(renting);
        verifyNoMoreInteractions(rentingDao);
    }

    @Test
    public void testDelete() throws Exception {
    	Long id = 1L;
        Renting renting = new Renting();
        renting.setId(id);

        rentingService.delete(renting);

        try {
			verify(rentingDao, times(1)).delete(renting);
		} catch (Exception e) {
			e.printStackTrace();
		}
        verifyNoMoreInteractions(rentingDao);
    }

    @Test
    public void testUpdatePrice() throws Exception {
        Long id = 1L;
        BigDecimal newPrice = new BigDecimal(150);

        Renting originalRenting = new Renting();
        originalRenting.setId(1L);
        originalRenting.setTotalAmount(new BigDecimal(200));

        when(rentingDao.getById(id)).thenReturn(originalRenting);

        rentingService.updatePrice(id, newPrice);

        verify(rentingDao, times(1)).updatePrice(id, newPrice);
        assertEquals(new BigDecimal(200), rentingDao.getById(id).getTotalAmount());
    }
        
}

