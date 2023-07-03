package rentacar.server.service;

import java.util.Date;
import java.util.List;

import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.TypeOfVehicle;

/**
 * 
 * The PriceListItemService interface defines methods for managing price list
 * items. It provides functionality for retrieving price list items based on a
 * type of vehicle and a specific date, as well as saving new price list items.
 */
public interface PriceListItemService {
	/**
	 * Retrieves a list of price list items based on the given type of vehicle and
	 * date.
	 * 
	 * @param tov      the type of vehicle
	 * @param dateFrom the date from which the price list items should be retrieved
	 * @return a list of price list items
	 * @throws Exception if an error occurs during the retrieval process
	 */
	List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception;

	/**
	 * Saves a new price list item.
	 * 
	 * @param item the price list item to be saved
	 */
	void savePriceListItem(PriceListItem item);
}
