package rentacar.server.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import rentacar.common_lib.model.Administrator;
import rentacar.server.persistence.dao.AdministratorDao;

abstract class AdministratorServiceTest {
    
    @Mock
    protected AdministratorDao administratorDao;
    
    protected AdministatorService administratorService;
    protected abstract AdministatorService createAdministatorService();
    
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        administratorService = createAdministatorService();
    }


	@Test
    public void testLogin() {
    	// Define the expected behavior of the administratorDao mock object
    	String username = "admin";
        String password = "password";
        Administrator expectedAdministrator = new Administrator();
        expectedAdministrator.setId(1L);
        expectedAdministrator.setUsername(username);
        expectedAdministrator.setPassword(password);
        expectedAdministrator.setEmail("admin@gmail.com");
        when(administratorDao.getAdminByUsernameAndPassword(username,password)).thenReturn(expectedAdministrator);
        
        Administrator loggedInAdministrator = administratorService.login(username, password);
        
        assertNotNull(loggedInAdministrator);
        assertEquals(expectedAdministrator, loggedInAdministrator);
        
        // Verify that the methods of the mock object were called as expected
        verify(administratorDao, times(1)).getAdminByUsernameAndPassword(username, password);
    }
}
