package rentacar.server.service;

import java.math.BigDecimal;
import java.util.List;

import rentacar.common_lib.model.Renting;

/**
 * 
 * The RentingService interface defines methods for managing rentings. It
 * provides functionality for retrieving all rentings, saving new rentings,
 * deleting rentings, and updating the price of a renting.
 */
public interface RentingService {
	/**
	 * Retrieves all rentings.
	 * 
	 * @return a list of all rentings
	 * @throws Exception if an error occurs during the retrieval process
	 */
	List<Renting> getAll() throws Exception;

	/**
	 * Saves a new renting.
	 * 
	 * @param renting the renting to be saved
	 */
	void save(Renting renting);

	/**
	 * Deletes a renting.
	 * 
	 * @param renting the renting to be deleted
	 */
	void delete(Renting renting);

	/**
	 * Updates the price of a renting.
	 * 
	 * @param id       the ID of the renting
	 * @param newPrice the new price to be updated
	 */
	void updatePrice(Long id, BigDecimal newPrice);
}
