package rentacar.server.service;

import java.util.List;

import rentacar.common_lib.model.Vehicle;

/**
 * 
 * The VehicleService interface defines methods for managing vehicles. It
 * provides functionality for adding, updating, deleting, and retrieving
 * vehicles. It also provides methods for retrieving all vehicles and available
 * vehicles.
 */
public interface VehicleService {
	/**
	 * Adds a new vehicle.
	 * 
	 * @param vehicle the vehicle to add
	 */
	void add(Vehicle vehicle);

	/**
	 * Updates an existing vehicle.
	 * 
	 * @param vehicle the vehicle to update
	 */
	void update(Vehicle vehicle);

	/**
	 * Deletes a vehicle.
	 * 
	 * @param vehicle the vehicle to delete
	 */
	void delete(Vehicle vehicle);

	/**
	 * Retrieves all vehicles.
	 * 
	 * @return a list of all vehicles
	 */
	List<Vehicle> getAll();

	/**
	 * Retrieves all available vehicles.
	 * 
	 * @return a list of all available vehicles
	 */
	List<Vehicle> getAvailable();
}
