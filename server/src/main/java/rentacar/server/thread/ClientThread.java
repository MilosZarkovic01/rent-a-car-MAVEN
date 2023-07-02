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
import java.math.BigDecimal;
import java.util.Date;

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
                Request request = (Request) recеiver.receive();
                Response response = new Response();
                try {
                    switch (request.getOperation()) {
                        case LOG_IN:
                            Administrator admin = (Administrator) request.getData();
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
                            Administrator ad = (Administrator) request.getData();
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
                            Controller.getInstance().deleteVehicle((Vehicle) request.getData());
                            break;
                        case ADD_VEHICLE:
                            Controller.getInstance().saveVehicle((Vehicle) request.getData());
                            break;
                        case UPDATE_VEHICLE:
                            Controller.getInstance().updateVehicle((Vehicle) request.getData());
                            break;
                        case GET_ALL_CLIENTS:
                            response.setResult(Controller.getInstance().getAllClients());
                            break;
                        case UPDATE_CLIENT:
                            Controller.getInstance().updateClient((Client) request.getData());
                            break;
                        case ADD_CLIENT:
                            Controller.getInstance().addClient((Client) request.getData());
                            break;
                        case GET_CLIENT_RENTINGS:
                            response.setResult(Controller.getInstance().getClientRentings((Client) request.getData()));
                            break;
                        case GET_ALL_RENTINGS:
                            response.setResult(Controller.getInstance().getAllRentings());
                            break;
                        case GET_PRICE_LIST_ITEMS:
                            response.setResult(Controller.getInstance().getPriceListItems((TypeOfVehicle) request.getData(), (Date) request.getData2()));
                            break;
                        case ADD_RENTING:
                            Controller.getInstance().addRenting((Renting) request.getData());
                            break;
                        case DELETE_RENTING:
                            Controller.getInstance().deleteRenting((Renting) request.getData());
                            break;
                        case UPDATE_RENTING:
                           Controller.getInstance().updateRenting((Long) request.getData(), (BigDecimal) request.getData2());
                            break;
                        case GET_ALL_PDVS:
                            response.setResult(Controller.getInstance().getAllPDVs());
                            break;
                        case ADD_PRICE_LIST:
                            Controller.getInstance().savePriceList((PriceList) request.getData());
                            break;
                        case STOP_CLIENT_THREAD:
                            setSignal(false);
                            socket.close();
                            return;
                    }
                } catch (Exception ex) {
                    response.setException(ex);
                }
                sender.send(response);
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
