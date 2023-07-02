/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacar.client.main;

import com.formdev.flatlaf.FlatLightLaf;

import rentacar.client.ui.form.FrmLogin;

/**
 *
 * @author Somika
 */
public class Start {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		new FrmLogin().setVisible(true);

	}
}
