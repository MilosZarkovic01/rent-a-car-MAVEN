package rentacar.server.service.impl;

import java.util.List;

import rentacar.common_lib.model.PDV;
import rentacar.server.persistence.dao.PdvDao;
import rentacar.server.service.PdvService;

public class PdvServiceImpl implements PdvService {

	private final PdvDao pdvDao;

	public PdvServiceImpl(PdvDao pdvDao) {
		this.pdvDao = pdvDao;
	}

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
