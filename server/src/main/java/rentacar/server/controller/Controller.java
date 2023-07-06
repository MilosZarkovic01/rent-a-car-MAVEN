/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.controller;

import rentacar.common_lib.model.Administrator;
import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.PDV;
import rentacar.common_lib.model.PriceList;
import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.Renting;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rentacar.server.service.AdministatorService;
import rentacar.server.service.ClientService;
import rentacar.server.service.PdvService;
import rentacar.server.service.PriceListItemService;
import rentacar.server.service.PriceListService;
import rentacar.server.service.RentingService;
import rentacar.server.service.TypeOfVehicleService;
import rentacar.server.service.VehicleService;
import rentacar.server.service.provider.ServiceProvider;
import rentacar.server.thread.ClientThread;
import rentacar.server.ui.form.MainForm;

/**
 *
 * The Controller class serves as the central control unit for the application.
 * It manages various functionalities and interactions between the UI, services,
 * and data models.
 *
 * @author Somika
 */
public class Controller {

	private static Controller instance;
	private MainForm mainForm;
	private List<ClientThread> activeClients;

	/**
	 * Constructs a new instance of the Controller class. Initializes the list of
	 * active clients.
	 */
	private Controller() {
		this.activeClients = new ArrayList<>();
	}

	/**
	 * Returns the singleton instance of the Controller class.
	 *
	 * @return The singleton instance of the Controller class.
	 */
	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	/**
	 * Returns the main form of the application.
	 *
	 * @return The main form of the application.
	 */
	public MainForm getMainForm() {
		return mainForm;
	}

	/**
	 * Sets the main form of the application.
	 *
	 * @param mainForm The main form of the application.
	 */
	public void setMainForm(MainForm mainForm) {
		this.mainForm = mainForm;
	}

	/**
	 * Checks if the specified administrator is already logged in.
	 *
	 * @param administrator The administrator to check.
	 * @return {@code true} if the administrator is already logged in, {@code false}
	 *         otherwise.
	 */
	public boolean isLogged(Administrator administrator) {
		for (ClientThread activeClient : activeClients) {
			if (activeClient.getAdministrator().equals(administrator)) {
				System.out.println("Administrator is already logged");
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the specified client thread to the list of active administrators.
	 *
	 * @param client The client thread to add.
	 */
	public void addActiveAdministrator(ClientThread client) {
		activeClients.add(client);
	}

	/**
	 * Authenticates the administrator with the specified username and password.
	 *
	 * @param username The username of the administrator.
	 * @param password The password of the administrator.
	 * @return The authenticated administrator.
	 * @throws Exception if an error occurs during the login process.
	 */
	public Administrator login(String username, String password) throws Exception {
		Administrator admin = ((AdministatorService) ServiceProvider.getInstance()
				.getRequiredService(AdministatorService.class)).login(username, password);
		return admin;
	}

	/**
	 * Returns the list of active administrators.
	 *
	 * @return The list of active administrators.
	 */
	public List<ClientThread> getActiveAdmins() {
		return activeClients;
	}

	/**
	 * Sets the list of active administrators.
	 *
	 * @param activeClients The list of active administrators.
	 */
	public void setActiveAdmins(List<ClientThread> activeClients) {
		this.activeClients = activeClients;
	}

	/**
	 * Logs out the specified administrator.
	 *
	 * @param admin The administrator to log out.
	 */
	public void logout(Administrator admin) {
		for (ClientThread client : activeClients) {
			if (admin.equals(client.getAdministrator())) {
				mainForm.logout(admin);
			}
		}
	}

	/**
	 * Retrieves all vehicles from the database.
	 *
	 * @return A list of all vehicles.
	 */
	public List<Vehicle> getAllVehicles() {
		return ((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).getAll();
	}

	/**
	 * Retrieves all available vehicles from the database.
	 *
	 * @return A list of available vehicles.
	 */
	public List<Vehicle> getAvailableVehicles() {
		return ((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).getAvailable();
	}

	/**
	 * Retrieves all types of vehicles from the database.
	 *
	 * @return A list of all types of vehicles.
	 */
	public List<TypeOfVehicle> getAllTypes() {
		return ((TypeOfVehicleService) ServiceProvider.getInstance().getRequiredService(TypeOfVehicleService.class))
				.getAll();
	}

	/**
	 * Deletes the specified vehicle from the database.
	 *
	 * @param vehicle The vehicle to delete.
	 * @throws Exception if an error occurs during the deletion process.
	 */
	public void deleteVehicle(Vehicle vehicle) throws Exception {
		((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).delete(vehicle);
	}

	/**
	 * Saves a new vehicle to the database.
	 *
	 * @param vehicle The vehicle to save.
	 * @throws Exception if an error occurs during the saving process.
	 */
	public void saveVehicle(Vehicle vehicle) throws Exception {
		((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).add(vehicle);
	}

	/**
	 * Updates an existing vehicle in the database.
	 *
	 * @param vehicle The vehicle to update.
	 * @throws Exception if an error occurs during the updating process.
	 */
	public void updateVehicle(Vehicle vehicle) throws Exception {
		((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).update(vehicle);
	}

	/**
	 * Retrieves all clients from the database.
	 *
	 * @return A list of all clients.
	 */
	public List<Client> getAllClients() {
		return ((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class)).getAllClients();
	}

	/**
	 * Updates an existing client in the database.
	 *
	 * @param client The client to update.
	 * @throws Exception if an error occurs during the updating process.
	 */
	public void updateClient(Client client) throws Exception {
		((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class)).update(client);
	}

	/**
	 * Adds a new client to the database.
	 *
	 * @param client The client to add.
	 * @throws Exception if an error occurs during the saving process.
	 */
	public void addClient(Client client) throws Exception {
		((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class)).saveNewClient(client);
	}

	/**
	 * Retrieves all rentings associated with a specific client from the database.
	 *
	 * @param client The client for which to retrieve the rentings.
	 * @return A list of rentings associated with the client.
	 * @throws Exception if an error occurs during the retrieval process.
	 */
	public List<Renting> getClientRentings(Client client) throws Exception {
		return ((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class))
				.getClientRentings(client);
	}

	/**
	 * Retrieves all rentings from the database.
	 *
	 * @return A list of all rentings.
	 * @throws Exception if an error occurs during the retrieval process.
	 */
	public List<Renting> getAllRentings() throws Exception {
		return ((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).getAll();
	}

	/**
	 * Retrieves price list items for a specific type of vehicle and starting date
	 * from the database.
	 *
	 * @param tov      The type of vehicle.
	 * @param dateFrom The starting date.
	 * @return A list of price list items for the specified type of vehicle and
	 *         starting date.
	 * @throws Exception if an error occurs during the retrieval process.
	 */
	public List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception {
		return ((PriceListItemService) ServiceProvider.getInstance().getRequiredService(PriceListItemService.class))
				.getPriceListItems(tov, dateFrom);
	}

	/**
	 * Adds a new renting to the database.
	 *
	 * @param renting The renting to add.
	 * @throws Exception if an error occurs during the saving process.
	 */
	public void addRenting(Renting renting) throws Exception {
		((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).save(renting);
	}

	/**
	 * Deletes the specified renting from the database.
	 *
	 * @param renting The renting to delete.
	 * @throws Exception if an error occurs during the deletion process.
	 */
	public void deleteRenting(Renting renting) throws Exception {
		((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).delete(renting);
	}

	/**
	 * Retrieves all PDVs (tax rates) from the database.
	 *
	 * @return A list of all PDVs.
	 * @throws Exception if an error occurs during the retrieval process.
	 */
	public List<PDV> getAllPDVs() throws Exception {
		return ((PdvService) ServiceProvider.getInstance().getRequiredService(PdvService.class)).getAll();
	}

	/**
	 * Saves a new price list to the database.
	 *
	 * @param pl The price list to save.
	 * @throws Exception if an error occurs during the saving process.
	 */
	public void savePriceList(PriceList pl) throws Exception {
		Long priceListId = ((PriceListService) ServiceProvider.getInstance().getRequiredService(PriceListService.class))
				.savePriceList(pl);
		pl.setId(priceListId);

		List<PriceListItem> priceListItems = pl.getPriceListItems();

		for (PriceListItem item : priceListItems) {
			item.setPriceList(pl);
			savePriceListItem(item);
		}
	}

	/**
	 * Saves a new price list item to the database.
	 *
	 * @param item The price list item to save.
	 * @throws Exception if an error occurs during the saving process.
	 */
	public void savePriceListItem(PriceListItem item) throws Exception {
		((PriceListItemService) ServiceProvider.getInstance().getRequiredService(PriceListItemService.class))
				.savePriceListItem(item);
	}

	/**
	 * Updates the price of a renting in the database.
	 *
	 * @param id       The ID of the renting.
	 * @param newPrice The new price of the renting.
	 * @throws Exception if an error occurs during the updating process.
	 */
	public void updateRenting(Long id, BigDecimal newPrice) throws Exception {
		((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).updatePrice(id,
				newPrice);
	}
}
