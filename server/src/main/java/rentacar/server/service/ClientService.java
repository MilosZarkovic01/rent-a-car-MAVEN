package rentacar.server.service;

import java.util.List;

import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.Renting;

/**
 * 
 * The ClientService interface defines methods for handling client-related
 * operations. It provides functionality for retrieving clients, updating client
 * information, saving new clients, and retrieving rentings for a specific
 * client.
 */
public interface ClientService {
	/**
	 * Retrieves a list of all clients in the system.
	 * 
	 * @return a list of all clients
	 */
	List<Client> getAllClients();

	/**
	 * Updates the information of the specified client.
	 * 
	 * @param client the client to update
	 */
	void update(Client client);

	/**
	 * Saves a new client in the system.
	 * 
	 * @param client the new client to save
	 */
	void saveNewClient(Client client);

	/**
	 * Retrieves a list of rentings associated with the specified client.
	 * 
	 * @param client the client for which to retrieve rentings
	 * @return a list of rentings for the specified client
	 */
	List<Renting> getClientRentings(Client client);
}
