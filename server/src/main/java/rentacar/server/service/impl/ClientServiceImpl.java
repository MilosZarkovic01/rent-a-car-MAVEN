package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.Renting;
import rentacar.server.persistence.dao.ClientDao;
import rentacar.server.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private final ClientDao clientDao;

	public ClientServiceImpl(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	@Override
	public void update(Client client) {
		try {
			clientDao.update(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveNewClient(Client client) {
		try {
			clientDao.add(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Renting> getClientRentings(Client client) {
		try {
			return clientDao.getClientRentings(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
