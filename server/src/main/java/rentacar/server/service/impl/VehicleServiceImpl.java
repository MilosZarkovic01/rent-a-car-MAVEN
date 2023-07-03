package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.Vehicle;
import rentacar.server.persistence.dao.VehicleDao;
import rentacar.server.service.VehicleService;

/**
 * 
 * The implementation of the VehicleService interface. It provides functionality
 * for Vehicle-related operations, such as adding, updating, and deleting
 * vehicles, as well as retrieving all vehicles and available vehicles.
 */
public class VehicleServiceImpl implements VehicleService {
	private final VehicleDao vehicleDao;

	/**
	 * Constructs a VehicleServiceImpl object with the specified VehicleDao.
	 * 
	 * @param vehicleDao the VehicleDao implementation
	 */
	public VehicleServiceImpl(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	/**
	 * Adds a new vehicle.
	 * 
	 * @param vehicle the vehicle to be added
	 */
	@Override
	public void add(Vehicle vehicle) {
		try {
			vehicleDao.add(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates an existing vehicle.
	 * 
	 * @param vehicle the vehicle to be updated
	 */
	@Override
	public void update(Vehicle vehicle) {
		try {
			vehicleDao.update(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a vehicle.
	 * 
	 * @param vehicle the vehicle to be deleted
	 */
	@Override
	public void delete(Vehicle vehicle) {
		try {
			vehicleDao.delete(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves all vehicles.
	 * 
	 * @return a list of all vehicles
	 */
	@Override
	public List<Vehicle> getAll() {
		return vehicleDao.getAll();
	}

	/**
	 * Retrieves all available vehicles.
	 * 
	 * @return a list of all available vehicles
	 */
	@Override
	public List<Vehicle> getAvailable() {
		return vehicleDao.getAvailable();
	}

}
