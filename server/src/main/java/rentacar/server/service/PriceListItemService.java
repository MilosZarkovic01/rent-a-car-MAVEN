package rentacar.server.service;

import java.util.Date;
import java.util.List;

import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.TypeOfVehicle;

public interface PriceListItemService {
	List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception;
	void savePriceListItem(PriceListItem item);
}
