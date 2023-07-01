package rentacar.server.service;

import rentacar.common_lib.model.PriceList;

public interface PriceListService {
	Long savePriceList(PriceList pl) throws Exception;
}
