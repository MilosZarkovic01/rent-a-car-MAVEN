package rentacar.server.service;

import rentacar.server.service.impl.PriceListServiceImpl;

class PriceListServiceImplTest extends PriceListServiceTest{


	@Override
	protected PriceListService createPriceListService() {
		return new PriceListServiceImpl(priceListDao);
	}

}
