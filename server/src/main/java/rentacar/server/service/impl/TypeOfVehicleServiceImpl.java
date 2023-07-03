package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.server.persistence.dao.TypeOfVehicleDao;
import rentacar.server.service.TypeOfVehicleService;

/**
 * 
 * The implementation of the TypeOfVehicleService interface. It provides
 * functionality for TypeOfVehicle-related operations, such as retrieving all
 * types of vehicles.
 */
public class TypeOfVehicleServiceImpl implements TypeOfVehicleService {
	private final TypeOfVehicleDao typeOfVehicleDao;

	/**
	 * Constructs a TypeOfVehicleServiceImpl object with the specified
	 * TypeOfVehicleDao.
	 * 
	 * @param typeOfVehicleDao the TypeOfVehicleDao implementation
	 */
	public TypeOfVehicleServiceImpl(TypeOfVehicleDao typeOfVehicleDao) {
		this.typeOfVehicleDao = typeOfVehicleDao;
	}

	/**
	 * Retrieves all types of vehicles.
	 * 
	 * @return a list of all types of vehicles
	 */
	@Override
	public List<TypeOfVehicle> getAll() {
		return typeOfVehicleDao.getAll();
	}

}
