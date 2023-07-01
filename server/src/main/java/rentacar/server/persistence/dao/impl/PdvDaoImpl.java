/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.persistence.dao.impl;

import rentacar.common_lib.model.PDV;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import rentacar.server.persistence.conn.DBConnectionFactory;
import rentacar.server.persistence.dao.PdvDao;

/**
 *
 * @author Somika
 */
public class PdvDaoImpl implements PdvDao {

    @Override
    public List<PDV> getAll() throws Exception {
        try {
            String sql = "SELECT * FROM pdv";

            List<PDV> pdvs = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PDV pdv = new PDV();
                pdv.setId(rs.getLong("id"));
                pdv.setPercent(rs.getDouble("percent"));
                pdvs.add(pdv);
            }
            rs.close();
            statement.close();
            connection.close();
            return pdvs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
