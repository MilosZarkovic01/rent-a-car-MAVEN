package rentacar.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.server.persistence.dao.TypeOfVehicleDao;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

abstract class TypeOfVehicleServiceTest {
	
	@Mock
	protected TypeOfVehicleDao typeOfVehicleDao;
	protected TypeOfVehicleService typeOfVehicleService;
	protected abstract TypeOfVehicleService createTypeOfVehicleService();

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		typeOfVehicleService = createTypeOfVehicleService();
	}

	@Test
	public void testGetAll() {
		List<TypeOfVehicle> expectedTypes = new ArrayList<>();
		expectedTypes.add(new TypeOfVehicle(1L, "Car"));
		expectedTypes.add(new TypeOfVehicle(2L, "Truck"));
		expectedTypes.add(new TypeOfVehicle(3L, "Motorcycle"));

		when(typeOfVehicleDao.getAll()).thenReturn(expectedTypes);

		List<TypeOfVehicle> actualTypes = typeOfVehicleService.getAll();

		Assertions.assertEquals(expectedTypes.size(), actualTypes.size());

		for (int i = 0; i < expectedTypes.size(); i++) {
			Assertions.assertEquals(expectedTypes.get(i), actualTypes.get(i));
		}
	}
}
