package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.Vehicle;
import rentacar.server.persistence.dao.VehicleDao;
import rentacar.server.service.VehicleService;

public class VehicleServiceImpl implements VehicleService{
	private final VehicleDao vehicleDao;

	public VehicleServiceImpl(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	@Override
	public void add(Vehicle vehicle) {
		try {
			vehicleDao.add(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Vehicle vehicle) {
		try {
			vehicleDao.update(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Vehicle vehicle) {
		try {
			vehicleDao.delete(vehicle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Vehicle> getAll() {
		return vehicleDao.getAll();
	}

	@Override
	public List<Vehicle> getAvailable() {
		return vehicleDao.getAvailable();
	}
	
	
}
