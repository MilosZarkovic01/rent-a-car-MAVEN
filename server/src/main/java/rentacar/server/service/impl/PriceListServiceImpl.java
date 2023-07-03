package rentacar.server.service.impl;

import rentacar.common_lib.model.PriceList;
import rentacar.server.persistence.dao.PriceListDao;
import rentacar.server.service.PriceListService;

/**
 * 
 * The implementation of the PriceListService interface. It provides
 * functionality for Price List-related operations, such as saving a price list.
 */
public class PriceListServiceImpl implements PriceListService {
	private final PriceListDao priceListDao;

	/**
	 * Constructs a PriceListServiceImpl object with the specified PriceListDao.
	 * 
	 * @param priceListDao the PriceListDao implementation
	 */
	public PriceListServiceImpl(PriceListDao priceListDao) {
		this.priceListDao = priceListDao;
	}

	/**
	 * Saves a price list.
	 * 
	 * @param pl the price list to save
	 * @return the ID of the saved price list
	 * @throws Exception if an error occurs while saving the price list
	 */
	@Override
	public Long savePriceList(PriceList pl) throws Exception {
		return priceListDao.save(pl);
	}

}
