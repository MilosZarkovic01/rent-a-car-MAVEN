package rentacar.server.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import rentacar.server.persistence.dao.ClientDao;
import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.Renting;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

abstract class ClientServiceTest {

	@Mock
	protected ClientDao clientDao;

	protected ClientService clientService;
	protected abstract ClientService createClientService();
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		clientService = createClientService();
	}

	@Test
	public void testGetAllClients() {
		List<Client> expectedClients = new ArrayList<>();
		Client client1 = new Client();
		client1.setId(1L);
		client1.setFirstName("Milos");
		client1.setLastName("Zarkovic");
		client1.setTelNumber("123456789");
		expectedClients.add(client1);

		Client client2 = new Client();
		client2.setId(1L);
		client2.setFirstName("Mila");
		client2.setLastName("Zarkovic");
		client2.setTelNumber("987654321");
		expectedClients.add(client1);
		when(clientDao.getAllClients()).thenReturn(expectedClients);

		List<Client> actualClients = clientService.getAllClients();

		// Verify the results
		assertNotNull(actualClients);
		assertEquals(expectedClients, actualClients);

		verify(clientDao, times(1)).getAllClients();
		verifyNoMoreInteractions(clientDao);

	}

	@Test
	public void testUpdateClient() throws Exception {
		Client client = new Client();
		client.setId(1L);
		client.setFirstName("Marko");
		client.setLastName("Markovic");
		client.setTelNumber("123456789");

		clientService.update(client);

		verify(clientDao, times(1)).update(client);
		verifyNoMoreInteractions(clientDao);

	}

	@Test
    void testSaveNewClient() throws Exception {
        List<Client> clientList = new ArrayList<>();

        when(clientDao.getAllClients()).thenReturn(clientList);

        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Milos");
        client.setLastName("Zarkovic");
        client.setTelNumber("123456789");

        ArgumentCaptor<Client> clientCaptor = ArgumentCaptor.forClass(Client.class);

        clientService.saveNewClient(client);

        verify(clientDao, times(1)).add(clientCaptor.capture());
        verifyNoMoreInteractions(clientDao);

        Client capturedClient = clientCaptor.getValue();

        assertEquals(client, capturedClient);
    }

	@Test
	public void testGetClientRentings() throws Exception {
		Client client = new Client();
		client.setId(1L);
		client.setFirstName("Milos");
		client.setLastName("Zarkovic");
		client.setTelNumber("123456789");

		// Define the expected list of rentings
		List<Renting> expectedRentings = new ArrayList<>();
		Renting renting1 = new Renting();
		renting1.setClient(client);
		expectedRentings.add(renting1);
		when(clientDao.getClientRentings(client)).thenReturn(expectedRentings);

		List<Renting> actualRentings = clientService.getClientRentings(client);

		// Verify the results
		assertNotNull(actualRentings);
		assertEquals(expectedRentings, actualRentings);

		// Verify that the getClientRentings method of the mock object was called with
		// the correct client
		verify(clientDao, times(1)).getClientRentings(client);
		verifyNoMoreInteractions(clientDao);

	}
}
