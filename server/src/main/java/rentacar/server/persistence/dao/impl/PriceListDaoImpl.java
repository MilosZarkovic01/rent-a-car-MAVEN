/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.persistence.dao.impl;

import rentacar.common_lib.model.PriceList;
import java.sql.*;
import rentacar.server.persistence.conn.DBConnectionFactory;
import rentacar.server.persistence.dao.PriceListDao;

/**
 *
 * @author Somika
 */
public class PriceListDaoImpl implements PriceListDao {

    @Override
    public Long save(PriceList pl) throws Exception {
        Long priceListId = null;
        try {
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            String query = "INSERT INTO pricelist(dateFrom, dateTo) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, Date.valueOf(pl.getDateFrom()));
            preparedStatement.setDate(2, Date.valueOf(pl.getDateTo()));
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                priceListId = rs.getLong(1);
            } else {
                throw new Exception("PriceList id is not generated!");
            }

            rs.close();
            preparedStatement.close();
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return priceListId;
    }
}
