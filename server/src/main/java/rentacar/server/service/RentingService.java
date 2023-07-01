package rentacar.server.service;

import java.math.BigDecimal;
import java.util.List;

import rentacar.common_lib.model.Renting;

public interface RentingService {
	
	List<Renting> getAll() throws Exception;
    void save (Renting renting);
    void delete(Renting renting);
    void updatePrice(Long id, BigDecimal newPrice);
}
