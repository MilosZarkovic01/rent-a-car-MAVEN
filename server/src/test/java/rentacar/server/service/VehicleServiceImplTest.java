package rentacar.server.service;

import rentacar.server.service.impl.VehicleServiceImpl;

class VehicleServiceImplTest extends VehicleServiceTest{


	@Override
	protected VehicleService createVehicleService() {
		return new VehicleServiceImpl(vehicleDao);
	}

}
