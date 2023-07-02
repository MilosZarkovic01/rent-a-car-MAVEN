/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.session;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Somika
 */
public class Session {

    private static Session instance;
    private final Map<String, Object> sessionData;

    private Session() {
        sessionData = new HashMap<>();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void setAttribute(String key, Object value) {
        sessionData.put(key, value);
    }

    public Object getAttribute(String key) {
        return sessionData.get(key);
    }

    public void removeAttribute(String key) {
        sessionData.remove(key);
    }

    public void clear() {
        sessionData.clear();
    }
}
