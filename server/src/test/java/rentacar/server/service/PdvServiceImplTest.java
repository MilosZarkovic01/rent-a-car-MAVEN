package rentacar.server.service;

import rentacar.server.service.impl.PdvServiceImpl;

class PdvServiceImplTest extends PdvServiceTest{


	@Override
	protected PdvService createPdvService() {
		return new PdvServiceImpl(pdvDao);
	}

}
