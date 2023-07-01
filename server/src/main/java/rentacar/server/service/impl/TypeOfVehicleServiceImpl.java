package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.server.persistence.dao.TypeOfVehicleDao;
import rentacar.server.service.TypeOfVehicleService;

public class TypeOfVehicleServiceImpl implements TypeOfVehicleService {
	private final TypeOfVehicleDao typeOfVehicleDao;

	public TypeOfVehicleServiceImpl(TypeOfVehicleDao typeOfVehicleDao) {
		this.typeOfVehicleDao = typeOfVehicleDao;
	}

	@Override
	public List<TypeOfVehicle> getAll() {
		return typeOfVehicleDao.getAll();
	}

}
