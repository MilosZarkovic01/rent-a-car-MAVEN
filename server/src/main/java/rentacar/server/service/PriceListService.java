package rentacar.server.service;

import rentacar.common_lib.model.PriceList;

/**
 * 
 * The PriceListService interface defines methods for managing price lists. It
 * provides functionality for saving new price lists.
 */
public interface PriceListService {
	/**
	 * Saves a new price list.
	 * 
	 * @param pl the price list to be saved
	 * @return the ID of the saved price list
	 * @throws Exception if an error occurs during the saving process
	 */
	Long savePriceList(PriceList pl) throws Exception;
}
