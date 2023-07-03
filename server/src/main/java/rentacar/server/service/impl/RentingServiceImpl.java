package rentacar.server.service.impl;

import java.math.BigDecimal;
import java.util.List;

import rentacar.common_lib.model.Renting;
import rentacar.server.persistence.dao.RentingDao;
import rentacar.server.service.RentingService;

/**
 * 
 * The implementation of the RentingService interface. It provides functionality
 * for Renting-related operations, such as retrieving all rentings, saving a
 * renting, deleting a renting, and updating the price of a renting.
 */
public class RentingServiceImpl implements RentingService {
	private final RentingDao rentingDao;

	/**
	 * Constructs a RentingServiceImpl object with the specified RentingDao.
	 * 
	 * @param rentingDao the RentingDao implementation
	 */
	public RentingServiceImpl(RentingDao rentingDao) {
		this.rentingDao = rentingDao;
	}

	/**
	 * Retrieves all rentings.
	 * 
	 * @return a list of all rentings
	 * @throws Exception if an error occurs while retrieving the rentings
	 */
	@Override
	public List<Renting> getAll() throws Exception {
		return rentingDao.getAll();
	}

	/**
	 * Saves a renting.
	 * 
	 * @param renting the renting to save
	 */
	@Override
	public void save(Renting renting) {
		try {
			rentingDao.add(renting);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a renting.
	 * 
	 * @param renting the renting to delete
	 */
	@Override
	public void delete(Renting renting) {
		try {
			rentingDao.delete(renting);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates the price of a renting.
	 * 
	 * @param id       the ID of the renting
	 * @param newPrice the new price to set
	 */
	@Override
	public void updatePrice(Long id, BigDecimal newPrice) {
		try {
			rentingDao.updatePrice(id, newPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
