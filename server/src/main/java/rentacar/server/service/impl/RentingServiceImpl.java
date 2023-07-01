package rentacar.server.service.impl;

import java.math.BigDecimal;
import java.util.List;

import rentacar.common_lib.model.Renting;
import rentacar.server.persistence.dao.RentingDao;
import rentacar.server.service.RentingService;

public class RentingServiceImpl implements RentingService {
	private final RentingDao rentingDao;

	public RentingServiceImpl(RentingDao rentingDao) {
		this.rentingDao = rentingDao;
	}

	@Override
	public List<Renting> getAll() throws Exception {
		return rentingDao.getAll();
	}

	@Override
	public void save(Renting renting) {
		try {
			rentingDao.add(renting);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Renting renting) {
		try {
			rentingDao.delete(renting);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePrice(Long id, BigDecimal newPrice) {
		try {
			rentingDao.updatePrice(id, newPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
