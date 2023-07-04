package rentacar.server.service;

import rentacar.server.service.impl.AdministatorServiceImpl;

class AdministatorServiceImplTest extends AdministratorServiceTest {


	@Override
	protected AdministatorService createAdministatorService() {
		return new AdministatorServiceImpl(administratorDao);
	}

}
