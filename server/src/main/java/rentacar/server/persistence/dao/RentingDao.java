/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rentacar.server.persistence.dao;

import rentacar.common_lib.model.Renting;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Somika
 */
public interface RentingDao {
    List<Renting> getAll() throws Exception;
    void add (Renting renting) throws Exception;
    void delete(Renting renting) throws Exception;
    void updatePrice(Long id, BigDecimal newPrice) throws Exception;
}
