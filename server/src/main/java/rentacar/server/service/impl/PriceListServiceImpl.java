package rentacar.server.service.impl;

import rentacar.common_lib.model.PriceList;
import rentacar.server.persistence.dao.PriceListDao;
import rentacar.server.service.PriceListService;

public class PriceListServiceImpl implements PriceListService {
	private final PriceListDao priceListDao;

	public PriceListServiceImpl(PriceListDao priceListDao) {
		this.priceListDao = priceListDao;
	}

	@Override
	public Long savePriceList(PriceList pl) throws Exception {
		return priceListDao.save(pl);
	}

}
