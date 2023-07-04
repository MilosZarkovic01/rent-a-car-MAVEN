package rentacar.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import rentacar.server.persistence.dao.VehicleDao;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Arrays;
import java.util.List;

abstract class VehicleServiceTest {

	@Mock
	protected VehicleDao vehicleDao;
	protected VehicleService vehicleService;
	protected abstract VehicleService createVehicleService();

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		vehicleService = createVehicleService();
	}

	@Test
	public void testGetAllVehicles() {
		List<Vehicle> mockVehicleList = Arrays.asList(
				new Vehicle(1L, "Toyota", "Corolla", 50000, true, new TypeOfVehicle()),
				new Vehicle(2L, "Honda", "Civic", 60000, true, new TypeOfVehicle()),
				new Vehicle(3L, "Ford", "Focus", 70000, false, new TypeOfVehicle()));

		Mockito.when(vehicleDao.getAll()).thenReturn(mockVehicleList);

		List<Vehicle> vehicles = vehicleService.getAll();

		Assertions.assertEquals(mockVehicleList.size(), vehicles.size());
		Assertions.assertTrue(vehicles.containsAll(mockVehicleList));
	}

	@Test
	public void testAddVehicle() throws Exception {
		Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", 50000, true, new TypeOfVehicle());

		vehicleService.add(vehicle);

		verify(vehicleDao, times(1)).add(vehicle);
		verifyNoMoreInteractions(vehicleDao);
	}

	@Test
	public void testUpdateVehicle() throws Exception {
		Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", 50000, true, new TypeOfVehicle());

		vehicleService.update(vehicle);

		verify(vehicleDao, times(1)).update(vehicle);
		verifyNoMoreInteractions(vehicleDao);
	}

	@Test
	public void testDeleteVehicle() throws Exception {
		Vehicle vehicle = new Vehicle(1L, "Toyota", "Corolla", 50000, true, new TypeOfVehicle());

		vehicleService.delete(vehicle);

		verify(vehicleDao, times(1)).delete(vehicle);
		verifyNoMoreInteractions(vehicleDao);
	}

	@Test
	public void testGetAvailableVehicles() {
		List<Vehicle> mockAvailableVehicles = Arrays.asList(
				new Vehicle(1L, "Toyota", "Corolla", 50000, true, new TypeOfVehicle()),
				new Vehicle(2L, "Honda", "Civic", 60000, true, new TypeOfVehicle()));

		Mockito.when(vehicleDao.getAvailable()).thenReturn(mockAvailableVehicles);

		List<Vehicle> availableVehicles = vehicleService.getAvailable();

		Assertions.assertEquals(mockAvailableVehicles.size(), availableVehicles.size());
		Assertions.assertTrue(availableVehicles.containsAll(mockAvailableVehicles));
	}
}
