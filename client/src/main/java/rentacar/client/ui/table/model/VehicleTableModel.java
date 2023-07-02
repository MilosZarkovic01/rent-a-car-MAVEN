/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.ui.table.model;

import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class VehicleTableModel extends AbstractTableModel {

    private List<Vehicle> vehicles;

    public VehicleTableModel(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public int getRowCount() {
        return vehicles.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle vehicle = vehicles.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return vehicle.getBrand();
            case 1:
                return vehicle.getModel();
            case 2:
                return vehicle.getMileage();
            case 3:
                return vehicle.isAvailability();
            case 4:
                return vehicle.getTypeOfVehicle().getName();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Brand", "Model", "Mileage(km)", "Availability", "Type of vehicle"};
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        return Object.class;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        fireTableDataChanged();
    }

    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
        fireTableDataChanged();
    }

    public void update() {
        fireTableDataChanged();
    }

    public List<Vehicle> filter(TypeOfVehicle tov) {
        List<Vehicle> filterVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getTypeOfVehicle().equals(tov)) {
                filterVehicles.add(vehicle);
            }
        }
        return filterVehicles;
    }

    public TypeOfVehicle getTypeOfVehicle(int selectedRow) {
        return vehicles.get(selectedRow).getTypeOfVehicle();
    }
}
