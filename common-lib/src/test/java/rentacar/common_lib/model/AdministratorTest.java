package rentacar.common_lib.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


class AdministratorTest {

private Administrator administrator;
    
    @BeforeEach
    public void setUp() {
        administrator = new Administrator(1L, "admin", "password", "admin@gmail.com");
    }
    
    @AfterEach
    public void tearDown() {
        administrator = null;
    }
    
    @Test
    public void testGetId() {
        assertEquals(1L, administrator.getId());
    }
    
    @Test
    public void testSetId() {
        administrator.setId(2L);
        assertEquals(2L, administrator.getId());
    }
    
    @Test
    public void testGetUsername() {
        assertEquals("admin", administrator.getUsername());
    }
    
    @Test
    public void testSetUsername() {
        administrator.setUsername("newadmin");
        assertEquals("newadmin", administrator.getUsername());
    }
    
    @Test
    public void testSetUsername_NullValue() {
        assertThrows(NullPointerException.class, () -> {
            administrator.setUsername(null);
        });
    }
    
    @Test
    public void testSetUsername_EmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            administrator.setUsername("");
        });
    }
    
    @Test
    public void testGetPassword() {
        assertEquals("password", administrator.getPassword());
    }
    
    @Test
    public void testSetPassword() {
        administrator.setPassword("newpassword");
        assertEquals("newpassword", administrator.getPassword());
    }
    
    @Test
    public void testSetPassword_NullValue() {
        assertThrows(NullPointerException.class, () -> {
            administrator.setPassword(null);
        });
    }
    
    @Test
    public void testSetPassword_EmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            administrator.setPassword("");
        });
    }
    
    @Test
    public void testGetEmail() {
        assertEquals("admin@gmail.com", administrator.getEmail());
    }
    
    @Test
    public void testSetEmail() {
        administrator.setEmail("newadmin@example.com");
        assertEquals("newadmin@example.com", administrator.getEmail());
    }
    
    @Test
    public void testSetEmail_NullValue() {
        assertThrows(NullPointerException.class, () -> {
            administrator.setEmail(null);
        });
    }
    
    @Test
    public void testSetEmail_EmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            administrator.setEmail("");
        });
    }
    
    @Test
    public void testToString() {
        String expectedString = "Administrator{id=1, username=admin, password=password, email=admin@gmail.com}";
        assertEquals(expectedString, administrator.toString());
    }

}
