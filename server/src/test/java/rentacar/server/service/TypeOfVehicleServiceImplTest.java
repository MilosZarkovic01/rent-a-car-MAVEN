package rentacar.server.service;

import rentacar.server.service.impl.TypeOfVehicleServiceImpl;

class TypeOfVehicleServiceImplTest extends TypeOfVehicleServiceTest{


	@Override
	protected TypeOfVehicleService createTypeOfVehicleService() {
		return new TypeOfVehicleServiceImpl(typeOfVehicleDao);
	}

}
