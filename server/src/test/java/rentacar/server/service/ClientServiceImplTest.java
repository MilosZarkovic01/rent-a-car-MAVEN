package rentacar.server.service;

import rentacar.server.service.impl.ClientServiceImpl;

class ClientServiceImplTest extends ClientServiceTest{

	@Override
	protected ClientService createClientService() {
		return new ClientServiceImpl(clientDao);
	}

}
