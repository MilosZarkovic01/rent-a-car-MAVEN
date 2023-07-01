/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rentacar.server.persistence.dao;

import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.TypeOfVehicle;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Somika
 */
public interface PriceListItemDao {

    List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception;
    void savePriceListItem(PriceListItem item) throws Exception;
}
