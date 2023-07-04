package rentacar.server.service;

import rentacar.server.service.impl.RentingServiceImpl;

class RentingServiceImplTest extends RentingServiceTest{


	@Override
	protected RentingService createRentingService() {
		return new RentingServiceImpl(rentingDao);
	}

}
