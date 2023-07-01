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
 * @author Somika
 */
public class Controller {

	private static Controller instance;
	private MainForm mainForm;
	private List<ClientThread> activeClients;

	private Controller() {
		this.activeClients = new ArrayList<>();
	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}

	public MainForm getMainForm() {
		return mainForm;
	}

	public void setMainForm(MainForm mainForm) {
		this.mainForm = mainForm;
	}

	public boolean isLogged(Administrator administrator) {
		for (ClientThread activeClient : activeClients) {
			if (activeClient.getAdministrator().equals(administrator)) {
				System.out.println("Administrator is already logged");
				return true;
			}
		}
		return false;
	}

	public void addActiveAdministrator(ClientThread client) {
		activeClients.add(client);
	}

	public Administrator login(String username, String password) throws Exception {
		Administrator admin = ((AdministatorService) ServiceProvider.getInstance()
				.getRequiredService(AdministatorService.class)).login(username, password);
		System.out.println(admin);
		return admin;
	}

	public List<ClientThread> getActiveAdmins() {
		return activeClients;
	}

	public void setActiveAdmins(List<ClientThread> activeClients) {
		this.activeClients = activeClients;
	}

	public void logout(Administrator admin) {
		for (ClientThread client : activeClients) {
			if (admin.equals(client.getAdministrator())) {
				mainForm.logout(admin);
			}
		}
	}

	public List<Vehicle> getAllVehicles() {
		return ((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).getAll();
	}

	public List<Vehicle> getAvailableVehicles() {
		return ((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).getAvailable();
	}

	public List<TypeOfVehicle> getAllTypes() {
		return ((TypeOfVehicleService) ServiceProvider.getInstance().getRequiredService(TypeOfVehicleService.class))
				.getAll();
	}

	public void deleteVehicle(Vehicle vehicle) throws Exception {
		((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).delete(vehicle);
	}

	public void saveVehicle(Vehicle vehicle) throws Exception {
		((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).add(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) throws Exception {
		((VehicleService) ServiceProvider.getInstance().getRequiredService(VehicleService.class)).update(vehicle);
	}

	public List<Client> getAllClients() {
		return ((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class)).getAllClients();
	}

	public void updateClient(Client client) throws Exception {
		((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class)).update(client);
	}

	public void addClient(Client client) throws Exception {
		((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class)).saveNewClient(client);
	}

	public List<Renting> getClientRentings(Client client) throws Exception {
		return ((ClientService) ServiceProvider.getInstance().getRequiredService(ClientService.class))
				.getClientRentings(client);
	}

	public List<Renting> getAllRentings() throws Exception {
		return ((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).getAll();
	}

	public List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception {
		return ((PriceListItemService) ServiceProvider.getInstance().getRequiredService(PriceListItemService.class))
				.getPriceListItems(tov, dateFrom);
	}

	public void addRenting(Renting renting) throws Exception {
		((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).save(renting);
	}

	public void deleteRenting(Renting renting) throws Exception {
		((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).delete(renting);
	}

	public List<PDV> getAllPDVs() throws Exception {
		return ((PdvService) ServiceProvider.getInstance().getRequiredService(PdvService.class)).getAll();
	}

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

	public void savePriceListItem(PriceListItem item) throws Exception {
		((PriceListItemService) ServiceProvider.getInstance().getRequiredService(PriceListItemService.class))
				.savePriceListItem(item);
	}

	public void updateRenting(Long id, BigDecimal newPrice) throws Exception {
		((RentingService) ServiceProvider.getInstance().getRequiredService(RentingService.class)).updatePrice(id,
				newPrice);
	}
}
