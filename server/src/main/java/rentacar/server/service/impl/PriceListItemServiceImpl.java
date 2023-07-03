package rentacar.server.service.impl;

import java.util.Date;
import java.util.List;

import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.server.persistence.dao.PriceListItemDao;
import rentacar.server.service.PriceListItemService;

/**
 * 
 * The implementation of the PriceListItemService interface. It provides
 * functionality for Price List Item-related operations, such as retrieving
 * price list items based on type of vehicle and date, and saving a price list
 * item.
 */
public class PriceListItemServiceImpl implements PriceListItemService {
	private final PriceListItemDao priceListItemDao;

	/**
	 * Constructs a PriceListItemServiceImpl object with the specified
	 * PriceListItemDao.
	 * 
	 * @param priceListItemDao the PriceListItemDao implementation
	 */
	public PriceListItemServiceImpl(PriceListItemDao priceListItemDao) {
		this.priceListItemDao = priceListItemDao;
	}

	/**
	 * Retrieves price list items based on the type of vehicle and date.
	 * 
	 * @param tov      the type of vehicle
	 * @param dateFrom the date from which to retrieve price list items
	 * @return a list of price list items
	 * @throws Exception if an error occurs while retrieving the price list items
	 */
	@Override
	public List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception {
		return priceListItemDao.getPriceListItems(tov, dateFrom);
	}

	/**
	 * Saves a price list item.
	 * 
	 * @param item the price list item to save
	 */
	@Override
	public void savePriceListItem(PriceListItem item) {
		try {
			priceListItemDao.savePriceListItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
