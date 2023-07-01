package rentacar.server.service;

import java.util.List;

import rentacar.common_lib.model.Vehicle;

public interface VehicleService {
    void add(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Vehicle vehicle);
    List<Vehicle> getAll();
    List<Vehicle> getAvailable();
}
