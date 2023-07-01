/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.persistence.dao.impl;

import rentacar.common_lib.model.Administrator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rentacar.server.persistence.conn.DBConnectionFactory;
import rentacar.server.persistence.dao.AdministratorDao;

/**
 *
 * @author Somika
 */
public class AdministratorDaoImpl implements AdministratorDao {

    @Override
    public List<Administrator> getAll() {
        try {
            String sql = "SELECT * FROM administrator";
            List<Administrator> administrators = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Administrator administrator = new Administrator();
                administrator.setId(rs.getLong("id"));
                administrator.setUsername(rs.getString("username"));
                administrator.setPassword(rs.getString("password"));
                administrator.setEmail(rs.getString("email"));

                administrators.add(administrator);
            }
            rs.close();
            statement.close();
            return administrators;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
