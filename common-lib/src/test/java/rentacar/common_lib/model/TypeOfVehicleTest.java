package rentacar.common_lib.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TypeOfVehicleTest {

	private TypeOfVehicle vehicle;

	@BeforeEach
	void setUp() {
		vehicle = new TypeOfVehicle(1L, "Car");
	}

	@Test
	void testGetId() {
		assertEquals(1L, vehicle.getId());
	}

	@Test
	void testSetId() {
		vehicle.setId(2L);
		assertEquals(2L, vehicle.getId());
	}

	@Test
	void testGetName() {
		assertEquals("Car", vehicle.getName());
	}

	@Test
	void testSetName_ValidName() {
		vehicle.setName("SUV");
		assertEquals("SUV", vehicle.getName());
	}

	@Test
	void testSetName_NullName() {
		assertThrows(IllegalArgumentException.class, () -> vehicle.setName(null));
	}

	@Test
	void testSetName_EmptyName() {
		assertThrows(IllegalArgumentException.class, () -> vehicle.setName(""));
	}

	@ParameterizedTest
	@CsvSource({ "1, Car, 1, Car, true", "1, Car, 2, Car, false", "1, Car, 1, Motorcycle, true",
			"1, Car, 2, Motorcycle, false"

	})
	void testEquals(long id1, String name1, long id2, String name2, boolean expectedResult) {
		TypeOfVehicle vehicle1 = new TypeOfVehicle(id1, name1);
		TypeOfVehicle vehicle2 = new TypeOfVehicle(id2, name2);

		assertEquals(expectedResult, vehicle1.equals(vehicle2));
	}

	@Test
	void testToString() {
		assertEquals("Car", vehicle.toString());
	}
}
