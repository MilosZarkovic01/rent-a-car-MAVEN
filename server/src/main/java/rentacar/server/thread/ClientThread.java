/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.thread;

import rentacar.common_lib.communication.Sender;
import rentacar.common_lib.model.Administrator;
import java.net.Socket;
import rentacar.common_lib.communication.Recеiver;
import rentacar.common_lib.communication.Request;
import rentacar.common_lib.communication.Response;
import rentacar.server.controller.Controller;
import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.PriceList;
import rentacar.common_lib.model.Renting;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import rentacar.common_lib.utils.JsonSerializationUtils;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 *
 * @author Somika
 */
public class ClientThread extends Thread {

    private final Socket socket;
    private final Sender sender;
    private final Recеiver recеiver;
    private boolean signal;
    private Administrator administrator;

    public ClientThread(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        recеiver = new Recеiver(socket);
        this.signal = true;
        start();
    }

    @Override
    public void run() {
        while (signal) {
            try {
                String jsonRequest = (String) recеiver.receive();
                Request request = JsonSerializationUtils.deserializeFromJson(jsonRequest, new TypeReference<Request>() {
				});
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOG_IN:
                            Administrator admin = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Administrator>() {
							});
                            response.setResult(Controller.getInstance().login(admin.getUsername(), admin.getPassword()));
                            
                            administrator = (Administrator) response.getResult();
                            boolean active = Controller.getInstance().isLogged(this.administrator);

                            if (active) {
                                response.setException(new Exception("Administrator is already logged"));
                            } else {
                                Controller.getInstance().addActiveAdministrator(this);
                                Controller.getInstance().getMainForm().addLoggedAdministrator(administrator);
                            }
                            break;
                        case LOG_OUT:
                            Administrator ad = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Administrator>() {
							});
                            Controller.getInstance().logout(ad);
                            Controller.getInstance().getActiveAdmins().remove(this);
                            break;
                        case GET_ALL_VEHICLES:
                            response.setResult(Controller.getInstance().getAllVehicles());
                            break;
                        case GET_AVAILABLE_VEHICLES:
                            response.setResult(Controller.getInstance().getAvailableVehicles());
                            break;
                        case GET_ALL_TYPES:
                            response.setResult(Controller.getInstance().getAllTypes());
                            break;
                        case DELETE_VEHICLE:
                        	Vehicle vehicleToDelete = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Vehicle>() {
							});
                            Controller.getInstance().deleteVehicle(vehicleToDelete);
                            break;
                        case ADD_VEHICLE:
                        	Vehicle newVehicle = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Vehicle>() {
							});
                            Controller.getInstance().saveVehicle(newVehicle);
                            break;
                        case UPDATE_VEHICLE:
                        	Vehicle vehicleToUpdate = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Vehicle>() {
							});
                            Controller.getInstance().updateVehicle(vehicleToUpdate);
                            break;
                        case GET_ALL_CLIENTS:
                            response.setResult(Controller.getInstance().getAllClients());
                            break;
                        case UPDATE_CLIENT:
                        	Client clientToUpdate = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Client>() {
							});
                            Controller.getInstance().updateClient(clientToUpdate);
                            break;
                        case ADD_CLIENT:
                        	Client newClient = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Client>() {
							});
                            Controller.getInstance().addClient(newClient);
                            break;
                        case GET_CLIENT_RENTINGS:
                        	Client clientR =  JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Client>() {
							});
                            response.setResult(Controller.getInstance().getClientRentings(clientR));
                            break;
                        case GET_ALL_RENTINGS:
                            response.setResult(Controller.getInstance().getAllRentings());
                            break;
                        case GET_PRICE_LIST_ITEMS:
                        	TypeOfVehicle tov = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<TypeOfVehicle>() {
							});
                        	Date date = JsonSerializationUtils.convertValue(request.getData2(), new TypeReference<Date>() {
							});
                            response.setResult(Controller.getInstance().getPriceListItems(tov,date));
                            break;
                        case ADD_RENTING:
                        	Renting newRenting = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Renting>() {
							});
                            Controller.getInstance().addRenting(newRenting);
                            break;
                        case DELETE_RENTING:
                        	Renting rentingToDelete = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Renting>() {
							});
                            Controller.getInstance().deleteRenting(rentingToDelete);
                            break;
                        case UPDATE_RENTING:
                        	Long id = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<Long>() {
							});
                        	BigDecimal newPrice = JsonSerializationUtils.convertValue(request.getData2(), new TypeReference<BigDecimal>() {
							});
                           Controller.getInstance().updateRenting(id,newPrice);
                            break;
                        case GET_ALL_PDVS:
                            response.setResult(Controller.getInstance().getAllPDVs());
                            break;
                        case ADD_PRICE_LIST:
                        	PriceList newPriceList = JsonSerializationUtils.convertValue(request.getData(), new TypeReference<PriceList>() {
							});
                            Controller.getInstance().savePriceList(newPriceList);
                            break;
                        case STOP_CLIENT_THREAD:
                            setSignal(false);
                            socket.close();
                            return;
                    }
                } catch (Exception ex) {
                    response.setException(ex);
                }
                String jsonResponse = JsonSerializationUtils.serializeToJson(response,new TypeReference<Response>() {
    			});
                System.out.println(jsonResponse);
                sender.send(jsonResponse);
            } catch (Exception ex) {
                System.out.println("One client disconnected!");
            }
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

}
