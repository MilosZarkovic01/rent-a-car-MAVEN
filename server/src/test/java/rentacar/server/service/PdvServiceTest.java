package rentacar.server.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rentacar.server.persistence.dao.PdvDao;
import rentacar.common_lib.model.PDV;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

abstract class PdvServiceTest {

    @Mock
    protected PdvDao pdvDao;

    protected PdvService pdvService;
    protected abstract PdvService createPdvService();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        pdvService = createPdvService();
    }

    @Test
    public void testGetAllPDVEntries() throws Exception {
        List<PDV> expectedPDVs = new ArrayList<>();
        PDV pdv1 = new PDV();
        pdv1.setId(1L);
        pdv1.setPercent(20.0);
        
        expectedPDVs.add(pdv1);
        
        PDV pdv2 = new PDV();
        pdv2.setId(2L);
        pdv2.setPercent(15.0);
        
        expectedPDVs.add(pdv2);
        
        when(pdvDao.getAll()).thenReturn(expectedPDVs);

        List<PDV> actualPDVEntries = pdvService.getAll();

        assertNotNull(actualPDVEntries);
        assertEquals(expectedPDVs, actualPDVEntries);
        assertTrue(actualPDVEntries.contains(pdv1));
        assertEquals(2, actualPDVEntries.size());

        verify(pdvDao, times(1)).getAll();
        verifyNoMoreInteractions(pdvDao);
    }
    
    @Test
    public void testGetAllPDVEntries_EmptyList() throws Exception {
        List<PDV> expectedPDVs = new ArrayList<>();
        when(pdvDao.getAll()).thenReturn(expectedPDVs);

        List<PDV> actualPDVEntries = pdvService.getAll();

        assertNotNull(actualPDVEntries);
        assertTrue(actualPDVEntries.isEmpty());

        verify(pdvDao, times(1)).getAll();
        verifyNoMoreInteractions(pdvDao);
    }
}

