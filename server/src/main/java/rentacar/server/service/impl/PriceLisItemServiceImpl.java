package rentacar.server.service.impl;

import java.util.Date;
import java.util.List;

import rentacar.common_lib.model.PriceListItem;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.server.persistence.dao.PriceListItemDao;
import rentacar.server.service.PriceListItemService;

public class PriceLisItemServiceImpl implements PriceListItemService{
	private final PriceListItemDao priceListItemDao;

	public PriceLisItemServiceImpl(PriceListItemDao priceListItemDao) {
		this.priceListItemDao = priceListItemDao;
	}

	@Override
	public List<PriceListItem> getPriceListItems(TypeOfVehicle tov, Date dateFrom) throws Exception {
		return priceListItemDao.getPriceListItems(tov, dateFrom);
	}

	@Override
	public void savePriceListItem(PriceListItem item) {
		try {
			priceListItemDao.savePriceListItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
