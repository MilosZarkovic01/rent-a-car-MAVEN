package rentacar.common_lib.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

	private Vehicle vehicle;

	@BeforeEach
	void setUp() {
		vehicle = new Vehicle();
	}

	@AfterEach
	void tearDown() {
		vehicle = null;
	}

	@Test
	void testSetBrand_ValidBrand_Success() {
		vehicle.setBrand("Toyota");
		assertEquals("Toyota", vehicle.getBrand());
	}

	@Test
	void testSetBrand_NullBrand() {
		assertThrows(IllegalArgumentException.class, () -> vehicle.setBrand(null));
	}

	@Test
	void testSetBrand_EmptyBrand() {
		assertThrows(IllegalArgumentException.class, () -> vehicle.setBrand(""));
	}

	@Test
	void testSetModel() {
		vehicle.setModel("Camry");
		assertEquals("Camry", vehicle.getModel());
	}

	@Test
	void testSetModel_NullModel() {
		assertThrows(IllegalArgumentException.class, () -> vehicle.setModel(null));
	}

	@Test
	void testSetModel_EmptyModel() {
		assertThrows(IllegalArgumentException.class, () -> vehicle.setModel(""));
	}

	@Test
	void testSetMileage(){
		vehicle.setMileage(10000);
		assertEquals(10000, vehicle.getMileage());
	}

	@Test
	void testSetAvailability(){
		vehicle.setAvailability(true);
		assertTrue(vehicle.isAvailability());
	}

	@Test
	void testSetAvailability_False() {
		vehicle.setAvailability(false);
		assertFalse(vehicle.isAvailability());
	}

	@Test
	void testSetTypeOfVehicle() {
		TypeOfVehicle type = new TypeOfVehicle(1L, "Car");
		vehicle.setTypeOfVehicle(type);
		assertEquals(type, vehicle.getTypeOfVehicle());
	}

	@Test
	void testSetTypeOfVehicle_NullType() {
		assertThrows(NullPointerException.class, () -> vehicle.setTypeOfVehicle(null));
	}

	@ParameterizedTest
	@CsvSource({ "1, Toyota, Camry, 10000, true, 1, Toyota, Camry, 10000, true, true",
	            "1, Toyota, Camry, 10000, true, 1, Honda, Accord, 10000, true, true",
	            "1, Toyota, Camry, 10000, true, 2, Toyota, Camry, 20000, false, false",
	            "1, Toyota, Camry, 10000, true, 2, Honda, Accord, 20000, false, false" })
	void testEquals(long id1, String brand1, String model1, int mileage1, boolean availability1,
	                long id2, String brand2, String model2, int mileage2, boolean availability2,
	                boolean expectedResult) {
	    TypeOfVehicle type1 = new TypeOfVehicle(1L, "Car");
	    TypeOfVehicle type2 = new TypeOfVehicle(2L, "Car");

	    Vehicle vehicle1 = new Vehicle(id1, brand1, model1, mileage1, availability1, type1);
	    Vehicle vehicle2 = new Vehicle(id2, brand2, model2, mileage2, availability2, type2);

	    assertEquals(expectedResult, vehicle1.equals(vehicle2));
	}

	
	@Test
	void testToString() {
	    Vehicle vehicle = new Vehicle(1L, "Toyota", "Camry", 10000, true, new TypeOfVehicle(1L, "Car"));
	    String expected = "Vehicle{id=1, brand=Toyota, model=Camry, mileage=10000, availability=true, typeOfVehicle=Car}";
	    assertEquals(expected, vehicle.toString());
	}
}
