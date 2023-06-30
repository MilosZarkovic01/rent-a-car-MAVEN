package rentacar.common_lib.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PDVTest {

	private PDV pdv;

	@BeforeEach
	public void setUp() {
		pdv = new PDV(1L, 20.0);
	}

	@AfterEach
	public void tearDown() {
		pdv = null;
	}

	@Test
	public void testGetId() {
		assertEquals(1L, pdv.getId().longValue());
	}

	@Test
	public void testSetId() {
		pdv.setId(2L);
		assertEquals(2L, pdv.getId().longValue());
	}

	@Test
	public void testGetPercent() {
		assertEquals(20.0, pdv.getPercent(), 0.0);
	}

	@Test
	public void testSetPercent() {
		pdv.setPercent(15.0);
		assertEquals(15.0, pdv.getPercent(), 0.0);
	}

	@Test
    public void testSetPercentNegative() {
        assertThrows(IllegalArgumentException.class, () -> pdv.setPercent(-10.0));
    }

	@Test
	public void testEquals() {
		PDV samePDV = new PDV(1L, 20.0);
		PDV differentPDV = new PDV(2L, 15.0);

		assertTrue(pdv.equals(samePDV));
		assertFalse(pdv.equals(differentPDV));
	}

	@Test
	public void testToString() {
		assertEquals("20.0", pdv.toString());
	}

}
