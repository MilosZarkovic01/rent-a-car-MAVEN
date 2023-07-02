/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar.client.ui.form;

import rentacar.client.consts.VehicleFormModes;
import rentacar.client.controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Somika
 */
public class FrmMain extends javax.swing.JFrame {

	public FrmMain() {
		initComponents();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel2 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("rent-a-car.jpg"))); // NOI18N

		jMenuBar1.setBackground(new java.awt.Color(220, 18, 18));
		jMenuBar1.setOpaque(true);

		jMenu1.setBackground(new java.awt.Color(220, 18, 18));
		jMenu1.setText("Vehicles");
		jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		jMenu1.setOpaque(true);

		jMenuItem1.setBackground(new java.awt.Color(220, 18, 18));
		jMenuItem1.setText(" View all");
		jMenuItem1.setOpaque(true);
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setBackground(new java.awt.Color(220, 18, 18));
		jMenuItem2.setText("Add new");
		jMenuItem2.setOpaque(true);
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Clients");
		jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu2MouseClicked(evt);
			}
		});
		jMenuBar1.add(jMenu2);

		jMenu3.setText("Renting");
		jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu3MouseClicked(evt);
			}
		});
		jMenuBar1.add(jMenu3);

		jMenu4.setText("Price List                              ");
		jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu4MouseClicked(evt);
			}
		});
		jMenuBar1.add(jMenu4);

		jMenu5.setText(" Log out");
		jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
		jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jMenu5MouseClicked(evt);
			}
		});
		jMenuBar1.add(jMenu5);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		new FrmViewVehicles().setVisible(true);
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
		new FrmVehicle(VehicleFormModes.ADD).setVisible(true);
	}// GEN-LAST:event_jMenuItem2ActionPerformed

	private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenu2MouseClicked
		new FrmClient().setVisible(true);
	}// GEN-LAST:event_jMenu2MouseClicked

	private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenu3MouseClicked
		new FrmRenting().setVisible(true);
	}// GEN-LAST:event_jMenu3MouseClicked

	private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenu4MouseClicked
		new FrmPriceList().setVisible(true);
	}// GEN-LAST:event_jMenu4MouseClicked

	private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenu5MouseClicked
		try {
			int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Log out",
					JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				Controller.getInstance().logout();
				this.dispose();
				new FrmLogin().setVisible(true);
			}
		} catch (Exception ex) {
			Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_jMenu5MouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	// End of variables declaration//GEN-END:variables

}
