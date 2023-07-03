package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.Renting;
import rentacar.server.persistence.dao.ClientDao;
import rentacar.server.service.ClientService;

/**
 * 
 * The implementation of the ClientService interface. It provides functionality
 * for client-related operations, such as retrieving all clients, updating
 * client information, saving new clients, and retrieving rentings for a client.
 */
public class ClientServiceImpl implements ClientService {

	private final ClientDao clientDao;

	/**
	 * Constructs a ClientServiceImpl object with the specified ClientDao.
	 * 
	 * @param clientDao the ClientDao implementation
	 */
	public ClientServiceImpl(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * Retrieves all clients from the data source.
	 * 
	 * @return a list of all clients
	 */
	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	/**
	 * Updates the information of a client.
	 * 
	 * @param client the client object to update
	 */
	@Override
	public void update(Client client) {
		try {
			clientDao.update(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves a new client to the data source.
	 * 
	 * @param client the new client object to save
	 */
	@Override
	public void saveNewClient(Client client) {
		try {
			clientDao.add(client);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Retrieves the rentings for a specific client.
	 * 
	 * @param client the client object to retrieve rentings for
	 * @return a list of rentings associated with the client
	 */
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
