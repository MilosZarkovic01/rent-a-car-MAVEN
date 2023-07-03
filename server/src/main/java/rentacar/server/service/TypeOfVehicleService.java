package rentacar.server.service;

import java.util.List;

import rentacar.common_lib.model.TypeOfVehicle;

/**
 * 
 * The TypeOfVehicleService interface defines methods for managing types of
 * vehicles. It provides functionality for retrieving all types of vehicles.
 */
public interface TypeOfVehicleService {
	/**
	 * Retrieves all types of vehicles.
	 * 
	 * @return a list of all types of vehicles
	 */
	List<TypeOfVehicle> getAll();
}
