package rentacar.server.service;

import rentacar.server.service.impl.PriceListItemServiceImpl;

class PriceListItemServiceImplTest extends PriceListItemServiceTest{


	@Override
	protected PriceListItemService createPriceListItemService() {
		return new PriceListItemServiceImpl(priceListItemDao);
	}

}
