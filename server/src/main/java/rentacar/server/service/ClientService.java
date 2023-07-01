package rentacar.server.service;

import java.util.List;

import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.Renting;

public interface ClientService {
	List<Client> getAllClients();
	void update(Client client);
	void saveNewClient(Client client);
	List<Renting> getClientRentings(Client client);
}
