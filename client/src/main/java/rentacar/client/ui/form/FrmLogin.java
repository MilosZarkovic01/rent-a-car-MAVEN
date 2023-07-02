/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar.client.ui.form;

import rentacar.client.controller.Controller;
import rentacar.common_lib.model.Administrator;
import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rentacar.client.session.Session;

/**
 *
 * @author Somika
 */
public class FrmLogin extends javax.swing.JFrame {

	public FrmLogin() {
		initComponents();
		scaleImage();
		setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtUser = new javax.swing.JTextField();
		txtPassword = new javax.swing.JPasswordField();
		jCheckBox1 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(51, 153, 255));
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(242, 242, 242));
		jLabel1.setText("Username:");

		jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("Password:");

		txtUser.setBackground(new java.awt.Color(51, 153, 255));
		txtUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		txtUser.setForeground(new java.awt.Color(255, 255, 255));
		txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
		txtUser.setOpaque(true);

		txtPassword.setBackground(new java.awt.Color(51, 153, 255));
		txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		txtPassword.setForeground(new java.awt.Color(255, 255, 255));
		txtPassword
				.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
		txtPassword.setOpaque(true);

		jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
		jCheckBox1.setText("Show password");
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
		jButton1.setText("Login");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel3.setText("jLabel3");

		jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("LOGIN");

		jLabel5.setText("jLabel3");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(11, 11, 11)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(jLabel2))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(
														txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jCheckBox1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 275,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(136, 136, 136)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(
						jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(15, 15, 15)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(8, 8, 8)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel1)))
						.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)))
				.addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jCheckBox1).addComponent(jButton1))
				.addGap(0, 44, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox1ActionPerformed
		if (jCheckBox1.isSelected()) {
			txtPassword.setEchoChar((char) 0);
		} else {
			txtPassword.setEchoChar('*');
		}
	}// GEN-LAST:event_jCheckBox1ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		String username = txtUser.getText().trim();
		String password = new String(txtPassword.getPassword());
		if (username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter the credentials!", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			Administrator administrator = Controller.getInstance().login(username, password);
			if (administrator == null) {
				JOptionPane.showMessageDialog(this, "Invalid username or password", "", JOptionPane.ERROR_MESSAGE);
				resetForm();
				return;
			}

			if (administrator.getUsername().equals("logged")) {
				JOptionPane.showMessageDialog(this, "Administrator is already logged!", "", JOptionPane.ERROR_MESSAGE);
				resetForm();
				return;
			}
			Session.getInstance().setAttribute("admin", administrator);
			JOptionPane.showMessageDialog(this, "Login success. Welcome " + administrator.getUsername());
			FrmMain mainForm = new FrmMain();
			Controller.getInstance().setMainForm(mainForm);
			mainForm.setVisible(true);
			this.dispose();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Server not working, exit and try again later!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
		try {
			Controller.getInstance().closeLoginForm();
			JOptionPane.showMessageDialog(this, "Goodbye!");
		} catch (Exception ex) {
			Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_formWindowClosing

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPasswordField txtPassword;
	private javax.swing.JTextField txtUser;
	// End of variables declaration//GEN-END:variables

	private void scaleImage() {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("login.jpg"));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(jLabel3.getWidth(), jLabel3.getWidth(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		jLabel3.setIcon(scaledIcon);

		ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("lock.jpg"));
		Image img1 = icon1.getImage();
		Image imgScale1 = img1.getScaledInstance(jLabel5.getWidth(), jLabel5.getWidth(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
		jLabel5.setIcon(scaledIcon1);

		this.getContentPane().setBackground(new Color(51, 153, 255));
	}

	private void resetForm() {
		txtUser.setText("");
		txtPassword.setText("");
	}
}
