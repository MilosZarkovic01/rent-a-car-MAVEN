package rentacar.server.service.impl;

import rentacar.common_lib.model.Administrator;
import rentacar.server.persistence.dao.AdministratorDao;
import rentacar.server.service.AdministatorService;

public class AdministatorServiceImpl implements AdministatorService {

	private final AdministratorDao adminDao;

	public AdministatorServiceImpl(AdministratorDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public Administrator login(String username, String password) {
		Administrator admin = adminDao.getAdminByUsernameAndPassword(username, password);
		return admin;
	}

}
