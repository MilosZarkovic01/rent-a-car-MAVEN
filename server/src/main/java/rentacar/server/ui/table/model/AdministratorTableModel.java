package rentacar.server.ui.table.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import rentacar.common_lib.model.Administrator;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class AdministratorTableModel extends AbstractTableModel {

    private final String[] columnNames = {"username", "password", "email"};
    private ArrayList<Administrator> users;

    public AdministratorTableModel() {
        users = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Administrator a = users.get(row);
        switch (column) {
            case 0:
                return a.getUsername();
            case 1:
                return a.getPassword();
            case 2:
                return a.getEmail();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    public ArrayList<Administrator> getUsers() {
        return users;
    }

    public void setUseres(ArrayList<Administrator> users) {
        this.users = users;
    }

    
    public void add(Administrator user){
        users.add(user);
        fireTableDataChanged();
    }
    
    public void remove(Administrator user){
        users.remove(user);
        fireTableDataChanged();
    }
}
