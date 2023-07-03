package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.PDV;
import rentacar.server.persistence.dao.PdvDao;
import rentacar.server.service.PdvService;

/**
 * 
 * The implementation of the PdvService interface. It provides functionality for
 * PDV-related operations, such as retrieving all PDVs.
 */
public class PdvServiceImpl implements PdvService {

	private final PdvDao pdvDao;

	/**
	 * Constructs a PdvServiceImpl object with the specified PdvDao.
	 * 
	 * @param pdvDao the PdvDao implementation
	 */
	public PdvServiceImpl(PdvDao pdvDao) {
		this.pdvDao = pdvDao;
	}

	/**
	 * Retrieves all PDVs from the data source.
	 * 
	 * @return a list of all PDVs
	 */
	@Override
	public List<PDV> getAll() {
		try {
			return pdvDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
