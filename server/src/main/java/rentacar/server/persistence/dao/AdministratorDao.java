/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rentacar.server.persistence.dao;

import rentacar.common_lib.model.Administrator;

import java.util.List;

/**
 *
 * @author Somika
 */
public interface AdministratorDao {
    List<Administrator> getAll();
    Administrator getAdminByUsernameAndPassword(String username, String password);
}
