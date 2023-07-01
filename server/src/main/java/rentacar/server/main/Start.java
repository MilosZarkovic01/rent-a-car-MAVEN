/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.server.main;

import com.formdev.flatlaf.FlatLightLaf;
import rentacar.server.ui.form.MainForm;

/**
 *
 * @author Somika
 */
public class Start {

    public static void main(String[] args) {
    	FlatLightLaf.setup();
		(new MainForm()).setVisible(true);
    }
}
