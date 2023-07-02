/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.ui.table.model;

import rentacar.client.controller.Controller;
import rentacar.common_lib.model.Renting;
import rentacar.common_lib.model.TypeOfVehicle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class RentingTableModel extends AbstractTableModel {

    private final List<Renting> rentings;
    private final List<Renting> originalRentings;

    private final String[] columnNames = {"Id", "Date from", "Date to", "Total amount", "Currency", "Vehicle", "Client", "Price"};
    private final List<Renting> updatedRentings; // Lista za čuvanje izmenjenih rentiranja
    private final Set<Integer> updatedRows; // Skup za praćenje indeksa redova koji su izmenjeni

    public RentingTableModel(List<Renting> rentings) {
        this.rentings = rentings;
        this.originalRentings = new ArrayList<>(rentings);
        this.updatedRentings = new ArrayList<>();
        this.updatedRows = new HashSet<>();
    }

    @Override
    public int getRowCount() {
        return rentings.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Renting renting = rentings.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return renting.getId();
            case 1:
                return renting.getDateFrom();
            case 2:
                return renting.getDateTo();
            case 3:
                return renting.getTotalAmount();
            case 4:
                return renting.getCurrency();
            case 5:
                return renting.getVehicle().getBrand() + " " + renting.getVehicle().getModel();
            case 6:
                return renting.getClient().getFirstName() + " " + renting.getClient().getLastName();
            case 7:
                return renting.getPriceListItem().getTypeOfPriceListItem().toString() + " " + renting.getPriceListItem().getPrice() + " " + renting.getPriceListItem().getCurrency().toString();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Renting renting = rentings.get(rowIndex);
        if (updatedRows.contains(rowIndex)) {
            renting = updatedRentings.get(rowIndex);
        }

        switch (columnIndex) {
            case 3:
                renting.setTotalAmount(new BigDecimal(value.toString()));
                break;
            default:
                throw new AssertionError();
        }

        if (!updatedRentings.contains(renting)) {
            updatedRentings.add(renting);
            updatedRows.add(rowIndex);
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<Renting> getRentings() {
        return rentings;
    }

    public void update() {
        fireTableDataChanged();
    }

    public void remove(int index) {
        rentings.remove(index);
        fireTableDataChanged();
    }

    public void updateRenting(int rowIndex, Renting updatedRenting) {
        updatedRentings.set(rowIndex, updatedRenting);
        updatedRows.add(rowIndex);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void sendUpdatesToServer() throws Exception {
        for (Renting updatedRenting : updatedRentings) {
            Controller.getInstance().updateRenting(updatedRenting.getId(), updatedRenting.getTotalAmount());
        }

        // Reset
        updatedRentings.clear();
        updatedRows.clear();
    }

    public void filterRentingsByVehicleType(TypeOfVehicle vehicleType) {
        List<Renting> filteredRentings
                = originalRentings.stream()
                        .filter(renting -> renting.getVehicle().getTypeOfVehicle().equals(vehicleType))
                        .collect(Collectors.toList());

        rentings.clear();
        rentings.addAll(filteredRentings);

        fireTableDataChanged();
    }

    public void resetRentings() {
        rentings.clear();
        rentings.addAll(originalRentings);
        fireTableDataChanged();
    }

}
