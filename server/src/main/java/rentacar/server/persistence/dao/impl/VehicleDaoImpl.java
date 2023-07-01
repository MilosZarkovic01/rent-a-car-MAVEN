/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.persistence.dao.impl;

import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import rentacar.server.persistence.conn.DBConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import rentacar.server.persistence.dao.VehicleDao;

/**
 *
 * @author Somika
 */
public class VehicleDaoImpl implements VehicleDao {

    @Override
    public void add(Vehicle vehicle) throws Exception {
        String sql = "INSERT INTO vehicle(brand, model, mileage, availability, typeOfVehicle_fk) VALUES(?,?,?,?,?);";

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, vehicle.getBrand());
        preparedStatement.setString(2, vehicle.getModel());
        preparedStatement.setInt(3, vehicle.getMileage());
        preparedStatement.setBoolean(4, vehicle.isAvailability());
        preparedStatement.setLong(5, vehicle.getTypeOfVehicle().getId());

        preparedStatement.executeUpdate();
        connection.commit();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void update(Vehicle vehicle) throws Exception {
        String sql = "UPDATE vehicle SET "
                + "brand='" + vehicle.getBrand() + "', "
                + "model='" + vehicle.getModel() + "', "
                + "mileage=" + vehicle.getMileage() + ","
                + "availability=" + vehicle.isAvailability() + ","
                + "typeOfVehicle_fk=" + vehicle.getTypeOfVehicle().getId() + " "
                + "WHERE id=" + vehicle.getId();
        Connection connection = DBConnectionFactory.getInstance().getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.commit();
        statement.close();
        connection.close();

    }

    @Override
    public void delete(Vehicle vehicle) throws Exception {
        String sql = "DELETE FROM vehicle WHERE id = ?";

        Connection connection = DBConnectionFactory.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, vehicle.getId());
        preparedStatement.execute();
        connection.commit();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public List<Vehicle> getAll() {
        try {
            String sql = "SELECT v.id, brand, model, mileage, availability, typeOfVehicle_fk, tov.name FROM vehicle v INNER JOIN typeofvehicle tov ON v.typeOfVehicle_fk = tov.id";

            List<Vehicle> vehicles = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getLong("v.id"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setMileage(rs.getInt("mileage"));
                vehicle.setAvailability(rs.getBoolean("availability"));

                TypeOfVehicle tov = new TypeOfVehicle(rs.getLong("typeOfVehicle_fk"), rs.getString("tov.name"));
                vehicle.setTypeOfVehicle(tov);
                vehicles.add(vehicle);
            }
            rs.close();
            statement.close();
            connection.close();
            return vehicles;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Vehicle> getAvailable() {
        try {
            List<Vehicle> availableVehicles = new ArrayList<>();
            String sql = "SELECT * FROM vehicle v INNER JOIN typeofvehicle tov ON v.typeOfVehicle_fk = tov.id WHERE availability = true;";
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getLong("id"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setMileage(rs.getInt("mileage"));
                vehicle.setAvailability(rs.getBoolean("availability"));

                TypeOfVehicle tov = new TypeOfVehicle(rs.getLong("tov.id"), rs.getString("tov.name"));
                vehicle.setTypeOfVehicle(tov);

                availableVehicles.add(vehicle);
            }
            connection.commit();
            statement.close();
            connection.close();
            return availableVehicles;
        } catch (Exception ex) {
            Logger.getLogger(VehicleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
