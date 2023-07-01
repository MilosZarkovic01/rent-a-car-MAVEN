/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.common_lib.settings;

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
public class ConnectionConfig {

    private static ConnectionConfig instance;
    private Properties properties;

    private ConnectionConfig() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("../common-lib/config/connconfig.properties"));
        } catch (Exception ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionConfig getInstance() {
        if (instance == null) {
            instance = new ConnectionConfig();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setAddress(String address) {
        properties.setProperty("address", address);
        try {
            properties.store(new FileOutputStream(new File("../common-lib/config/connconfig.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPort(String port) {
        properties.setProperty("port", port);
        try {
            properties.store(new FileOutputStream(new File("../common-lib/config/connconfig.properties")), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
