/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.persistence.dao.impl;

import rentacar.common_lib.model.TypeOfVehicle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rentacar.server.persistence.conn.DBConnectionFactory;
import rentacar.server.persistence.dao.TypeOfVehicleDao;

/**
 *
 * @author Somika
 */
public class TypeOfVehicleDaoImpl implements TypeOfVehicleDao {

    @Override
    public List<TypeOfVehicle> getAll() {
        try {
            String sql = "SELECT * FROM typeofvehicle";
            List<TypeOfVehicle> types = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                TypeOfVehicle type = new TypeOfVehicle();
                type.setId(rs.getLong("id"));
                type.setName(rs.getString("name"));
                types.add(type);
            }
            rs.close();
            statement.close();
            return types;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
