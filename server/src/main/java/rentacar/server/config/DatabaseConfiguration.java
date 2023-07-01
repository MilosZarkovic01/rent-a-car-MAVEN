/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Somika
 */
public class DatabaseConfiguration {

    private static DatabaseConfiguration instance;
    private Properties properties;

    private DatabaseConfiguration() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("../server/config/dbconfig.properties"));
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DatabaseConfiguration getInstance() {
        if (instance == null) {
            instance = new DatabaseConfiguration();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "n/a");
    }

    public void setUrl(String url) {
        try {
            properties.setProperty("url", url);
            properties.store(new FileOutputStream(new File("../server/config/dbconfig.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUsername(String user) {
        try {
            properties.setProperty("username", user);
            properties.store(new FileOutputStream(new File("../server/config/dbconfig.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPassword(String password) {
        try {
            properties.setProperty("password", password);
            properties.store(new FileOutputStream(new File("../server/config/dbconfig.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
