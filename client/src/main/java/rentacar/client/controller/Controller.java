/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.controller;

import rentacar.common_lib.model.Administrator;
import rentacar.common_lib.communication.Request;
import rentacar.common_lib.communication.Response;
import rentacar.common_lib.communication.Sender;
import rentacar.common_lib.model.Vehicle;
import rentacar.common_lib.model.enumeration.Operation;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rentacar.common_lib.communication.Recеiver;
import rentacar.common_lib.model.Client;
import rentacar.common_lib.model.PDV;
import rentacar.common_lib.model.PriceList;
import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.Renting;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.enumeration.Currency;
import rentacar.common_lib.model.enumeration.TypeOfPriceListItem;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import rentacar.client.session.Session;
import rentacar.common_lib.settings.ConnectionConfig;
import rentacar.client.ui.form.FrmMain;

/**
 *
 * @author Somika
 */
public class Controller {

    private Socket socket;
    private Sender sender;
    private Recеiver receiver;
    private static Controller instance;
    private FrmMain mainForm;

    private Controller() {
        try {
            socket = new Socket(ConnectionConfig.getInstance().getProperty("address"), Integer.parseInt(ConnectionConfig.getInstance().getProperty("port")));
            sender = new Sender(socket);
            receiver = new Recеiver(socket);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void setMainForm(FrmMain mainForm) {
        this.mainForm = mainForm;
    }

    public Administrator login(String username, String password) throws Exception {
        Administrator administrator = new Administrator();
        administrator.setUsername(username);
        administrator.setPassword(password);

        Request request = new Request(Operation.LOG_IN, administrator);
        sender.send(request);
        Response response = (Response) receiver.receive();

        if (response.getException() == null) {
            return (Administrator) response.getResult();
        } else if (response.getException().getMessage().equals("Administrator is already logged")) {
            administrator.setUsername("logged");
            return administrator;
        } else {
            return null;
        }
    }

    public void logout() throws Exception {
        try {
            Administrator admin = (Administrator) Session.getInstance().getAttribute("admin");
            Request request = new Request(Operation.LOG_OUT, admin);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
        }

    }

    public List<Vehicle> getAllVehicles() {
        try {
            Request request = new Request();
            request.setOperation(Operation.GET_ALL_VEHICLES);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<Vehicle>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public List<Vehicle> getAvailableVehicle() {
        try {
            Request request = new Request();
            request.setOperation(Operation.GET_AVAILABLE_VEHICLES);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<Vehicle>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public List<TypeOfVehicle> getAllTypes() {
        try {
            Request request = new Request();
            request.setOperation(Operation.GET_ALL_TYPES);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<TypeOfVehicle>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public boolean updateVehicle(Vehicle inputData) {
        try {
            Request request = new Request(Operation.UPDATE_VEHICLE, inputData);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            } else {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public boolean deleteVehicle(Vehicle vehicle) throws Exception {
        Request request = new Request(Operation.DELETE_VEHICLE, vehicle);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() != null) {
            throw response.getException();
        } else {
            return true;
        }
    }

    public boolean saveVehicle(Vehicle inputData) {
        try {
            Request request = new Request(Operation.ADD_VEHICLE, inputData);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            } else {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public List<Client> getAllClients() {
        try {
            Request request = new Request();
            request.setOperation(Operation.GET_ALL_CLIENTS);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<Client>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public boolean updateClient(Client client) {
        try {
            Request request = new Request(Operation.UPDATE_CLIENT, client);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            } else {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public void addClient(Client client) {
        try {
            Request request = new Request(Operation.ADD_CLIENT, client);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public List<Client> searchClients(String firstname, String lastname, TypeOfVehicle tov) throws Exception {
        List<Client> allClients = getAllClients();
        List<Client> matchingClients = allClients.stream()
                .filter(client -> (firstname.isEmpty() || client.getFirstName().contains(firstname)))
                .filter(client -> (lastname.isEmpty() || client.getLastName().contains(lastname)))
                .filter(client -> {
                    try {
                        return (tov == null || hasRentingWithType(client, tov));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return false;
                    }
                })
                .collect(Collectors.toList());

        return matchingClients;
    }

    private boolean hasRentingWithType(Client client, TypeOfVehicle tov) throws Exception {
        List<Renting> clientRentings = getClientRentings(client);
        return clientRentings.stream()
                .anyMatch(renting -> renting.getVehicle().getTypeOfVehicle().equals(tov));
    }

    public List<Renting> getClientRentings(Client client) throws Exception {
        try {
            Request request = new Request(Operation.GET_CLIENT_RENTINGS, client);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<Renting>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public List<Renting> getAllRentings() {
        try {
            Request request = new Request();
            request.setOperation(Operation.GET_ALL_RENTINGS);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<Renting>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) {
        try {
            Request request = new Request(Operation.GET_PRICE_LIST_ITEMS, tov);
            request.setData2(dateFrom);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<PriceListItem>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public BigDecimal getTotalAmount(Date dateFrom, Date dateTo, TypeOfPriceListItem type, BigDecimal price, int numberOfHours) {
        long diff = dateTo.getTime() - dateFrom.getTime();
        long duration = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
        switch (type.toString()) {
            case "PERDAY":
                return price.multiply(new BigDecimal(duration));
            case "PERHOUR":
                return price.multiply(new BigDecimal(duration)).multiply(new BigDecimal(numberOfHours));
            default:
                throw new AssertionError();
        }
    }

    public void addRenting(Renting renting) {
        try {
            Request request = new Request(Operation.ADD_RENTING, renting);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteRenting(Renting renting) {
        try {
            Request request = new Request(Operation.DELETE_RENTING, renting);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public BigDecimal ExchangeRate(BigDecimal amount, Currency currency) {
        switch (currency.toString()) {
            case "USD":
                return amount.multiply(new BigDecimal(110.80));
            case "EUR":
                return amount.multiply(new BigDecimal(117.33));
            case "RSD":
            default:
                return amount;
        }
    }

    public List<PDV> getAllPDVs() {
        try {
            Request request = new Request();
            request.setOperation(Operation.GET_ALL_PDVS);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() == null) {
                return (List<PDV>) response.getResult();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public void addPriceList(PriceList pl) {
        try {
            Request request = new Request(Operation.ADD_PRICE_LIST, pl);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void closeLoginForm() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.STOP_CLIENT_THREAD);
        sender.send(request);
    }

    public void updateRenting(Long id, BigDecimal newPrice) {
        try {
            Request request = new Request(Operation.UPDATE_RENTING, id);
            request.setData2(newPrice);
            sender.send(request);
            Response response = (Response) receiver.receive();
            if (response.getException() != null) {
                throw response.getException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainForm, "Server stopped, try again later!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
