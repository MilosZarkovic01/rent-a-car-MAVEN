package rentacar.server.service;

import java.util.List;

import rentacar.common_lib.model.PDV;

/**
 * 
 * The PdvService interface defines methods for handling PDV (Value Added Tax)
 * related operations. It provides functionality for retrieving all PDV entries.
 */
public interface PdvService {
	/**
	 * Retrieves a list of all PDV entries in the system.
	 * 
	 * @return a list of all PDV entries
	 */
	List<PDV> getAll();
}
