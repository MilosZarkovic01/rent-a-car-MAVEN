/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.ui.table.model;

import rentacar.common_lib.model.Client;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class ClientTableModel extends AbstractTableModel {

    private List<Client> clients;
    private final String[] columnNames = {"First name", "Last name", "Telephone number"};

    public ClientTableModel(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= clients.size()) {
            return "";
        }

        Client client = clients.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return client.getFirstName();
            case 1:
                return client.getLastName();
            case 2:
                return client.getTelNumber();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void update() {
        fireTableDataChanged();
    }

    public void add(int index, Client client) {
        clients.remove(index);
        clients.add(index, client);
        fireTableDataChanged();
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void insertEmptyRow() {
        clients.add(new Client());
        fireTableDataChanged();
    }
}
