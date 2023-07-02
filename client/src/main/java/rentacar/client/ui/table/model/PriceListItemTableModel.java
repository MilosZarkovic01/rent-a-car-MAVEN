/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.ui.table.model;

import rentacar.common_lib.model.PriceListItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Somika
 */
public class PriceListItemTableModel extends AbstractTableModel {

    private List<PriceListItem> items;
    private final String[] columns = {"Price", "Currency", "Type", "PDV", "Type of vehicle"};

    public PriceListItemTableModel() {
        items = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PriceListItem item = items.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getPrice();
            case 1:
                return item.getCurrency();
            case 2:
                return item.getTypeOfPriceListItem();
            case 3:
                return item.getPdv();
            case 4:
                return item.getTypeOfVehicle().getName();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void add(PriceListItem item) {
        items.add(item);
        fireTableDataChanged();
    }

    public void remove(int index) {
        items.remove(index);
        fireTableDataChanged();
    }

    public List<PriceListItem> getItems() {
        return items;
    }
}
