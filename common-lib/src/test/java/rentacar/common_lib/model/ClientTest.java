package rentacar.common_lib.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class ClientTest {

	private Client client;

	@BeforeEach
	public void setUp() {
		client = new Client(1L, "Milos", "Zarković", "123456789");
	}

	@AfterEach
	public void tearDown() {
		client = null;
	}

	@Test
	public void testGetId() {
		assertEquals(1L, client.getId().longValue());
	}

	@Test
	public void testSetId() {
		client.setId(2L);
		assertEquals(2L, client.getId().longValue());
	}

	@Test
	public void testGetFirstName() {
		assertEquals("Milos", client.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		client.setFirstName("Mila");
		assertEquals("Mila", client.getFirstName());
	}

	@Test
	public void testSetFirstNameNull() {
		assertThrows(NullPointerException.class, () -> client.setFirstName(null));
	}

	@Test
	public void testSetFirstNameEmpty() {
		assertThrows(IllegalArgumentException.class, () -> client.setFirstName(""));
	}

	@Test
	public void testGetLastName() {
		assertEquals("Zarković", client.getLastName());
	}

	@Test
	public void testSetLastName() {
		client.setLastName("Zarkovic");
		assertEquals("Zarkovic", client.getLastName());
	}

	@Test
	public void testSetLastNameNull() {
		assertThrows(NullPointerException.class, () -> client.setLastName(null));
	}

	@Test
	public void testSetLastNameEmpty() {
		assertThrows(IllegalArgumentException.class, () -> client.setLastName(""));
	}

	@Test
	public void testGetTelNumber() {
		assertEquals("123456789", client.getTelNumber());
	}

	@Test
	public void testSetTelNumber() {
		client.setTelNumber("987654321");
		assertEquals("987654321", client.getTelNumber());
	}

	@Test
	public void testSetTelNumberNull() {
		assertThrows(NullPointerException.class, () -> client.setTelNumber(null));
	}

	@Test
	public void testSetTelNumberEmpty() {
		assertThrows(IllegalArgumentException.class, () -> client.setTelNumber(""));
	}

	@Test
	public void testEquals() {
		Client sameClient = new Client(1L, "Milos", "Zarković", "123456789");
		Client differentClient = new Client(2L, "Mila", "Zarković", "987654321");

		assertTrue(client.equals(sameClient));
		assertFalse(client.equals(differentClient));
	}

	@Test
	public void testToString() {
		assertEquals("Milos Zarković", client.toString());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(client.isEmpty());

		Client emptyClient = new Client();
		assertTrue(emptyClient.isEmpty());
	}

}
