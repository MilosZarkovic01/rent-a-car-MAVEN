package rentacar.server.service;

import rentacar.common_lib.model.Administrator;

public interface AdministatorService {
	Administrator login(String username, String password);
}
