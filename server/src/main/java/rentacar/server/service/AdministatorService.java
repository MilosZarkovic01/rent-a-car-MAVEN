package rentacar.server.service;

import rentacar.common_lib.model.Administrator;

/**
 * 
 * The AdministatorService interface defines methods for handling
 * administrator-related operations. It provides functionality for logging in an
 * administrator.
 */
public interface AdministatorService {
	/**
	 * Attempts to log in an administrator with the specified username and password.
	 * 
	 * @param username the username of the administrator
	 * @param password the password of the administrator
	 * @return the logged-in administrator if the login is successful, null
	 *         otherwise
	 */
	Administrator login(String username, String password);
}
