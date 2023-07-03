package rentacar.server.service.impl;

import rentacar.common_lib.model.Administrator;
import rentacar.server.persistence.dao.AdministratorDao;
import rentacar.server.service.AdministatorService;

/**
 * 
 * The implementation of the AdministatorService interface. It provides
 * functionality for administrator-related operations, such as login.
 */
public class AdministatorServiceImpl implements AdministatorService {

	private final AdministratorDao adminDao;

	/**
	 * Constructs an AdministatorServiceImpl object with the specified
	 * AdministratorDao.
	 * 
	 * @param adminDao the AdministratorDao implementation
	 */
	public AdministatorServiceImpl(AdministratorDao adminDao) {
		this.adminDao = adminDao;
	}

	/**
	 * Authenticates an administrator by performing a login operation.
	 * 
	 * @param username the administrator's username
	 * @param password the administrator's password
	 * @return the authenticated Administrator object, or null if the login is
	 *         unsuccessful
	 */
	@Override
	public Administrator login(String username, String password) {
		Administrator admin = adminDao.getAdminByUsernameAndPassword(username, password);
		return admin;
	}

}
