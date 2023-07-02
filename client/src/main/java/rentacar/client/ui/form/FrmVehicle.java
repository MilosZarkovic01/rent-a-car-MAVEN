/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar.client.ui.form;

import rentacar.client.consts.VehicleFormModes;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rentacar.client.controller.Controller;
import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Somika
 */
public class FrmVehicle extends javax.swing.JFrame {

    private Vehicle vehicle;
    private int mode;
    private FrmViewVehicles frmViewVehicles;

    public FrmVehicle() {
        initComponents();
    }

    public FrmVehicle(Vehicle vehicle, FrmViewVehicles frmViewVehicles, int mode) {
        initComponents();
        setLocationRelativeTo(null);
        this.vehicle = vehicle;
        this.frmViewVehicles = frmViewVehicles;
        this.mode = mode;
        prepareForm();
        populateForm();
    }

    public FrmVehicle(int mode) {
        initComponents();
        setLocationRelativeTo(null);
        this.mode = mode;
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        txtModel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMileage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancle = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jcbTypeOfVehicle = new javax.swing.JComboBox<>();
        jrbYes = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        btnUpdate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtModel.setBackground(new java.awt.Color(51, 153, 255));
        txtModel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtModel.setForeground(new java.awt.Color(255, 255, 255));
        txtModel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtModel.setOpaque(true);
        txtModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Vehicle");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID:");

        txtMileage.setBackground(new java.awt.Color(51, 153, 255));
        txtMileage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMileage.setForeground(new java.awt.Color(255, 255, 255));
        txtMileage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Brand:");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Model:");

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Enable edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mileage (in km):");

        btnCancle.setText("Cancel");
        btnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Availability");

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Type of vehicle:");

        txtBrand.setBackground(new java.awt.Color(51, 153, 255));
        txtBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBrand.setForeground(new java.awt.Color(255, 255, 255));
        txtBrand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtBrand.setOpaque(true);

        txtId.setBackground(new java.awt.Color(51, 153, 255));
        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtId.setOpaque(true);

        jcbTypeOfVehicle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbTypeOfVehicle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTypeOfVehicleItemStateChanged(evt);
            }
        });

        jrbYes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jrbYes.setForeground(new java.awt.Color(255, 255, 255));
        jrbYes.setText("Yes");
        jrbYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbYesActionPerformed(evt);
            }
        });

        jrbNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jrbNo.setForeground(new java.awt.Color(255, 255, 255));
        jrbNo.setText("No");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancle, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrbYes)
                                        .addGap(29, 29, 29)
                                        .addComponent(jrbNo))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnEdit)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jcbTypeOfVehicle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMileage)
                                            .addComponent(txtId)
                                            .addComponent(txtBrand)
                                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete)
                                .addGap(48, 48, 48)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)))
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbYes)
                            .addComponent(jrbNo))
                        .addGap(31, 31, 31)
                        .addComponent(jcbTypeOfVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnEdit))
                .addGap(5, 5, 5)
                .addComponent(btnCancle)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbYesActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtBrand.setEditable(true);
        txtModel.setEditable(true);
        txtMileage.setEditable(true);
        jrbYes.setEnabled(true);
        jrbNo.setEnabled(true);
        jcbTypeOfVehicle.setEnabled(true);
     }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int choice = JOptionPane.showConfirmDialog(this, "Are you absolutely sure?", "Deleting a vehicle", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                return;
            }
            if (Controller.getInstance().deleteVehicle(vehicle)) {
                JOptionPane.showMessageDialog(this, "The vehicle was successfully deleted!");
                frmViewVehicles.remove(vehicle);
            }
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "This vehicle is currently rented and can't be deleted!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancleActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if(txtBrand.getText().isEmpty() || txtModel.getText().isEmpty()||txtMileage.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter all values!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Controller.getInstance().saveVehicle(getInputData())) {
                JOptionPane.showMessageDialog(this, "The vehicle has been successfully saved!");
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateForm();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            //validate
            if (Controller.getInstance().updateVehicle(getInputData())) {
                JOptionPane.showMessageDialog(this, "Update successful!");
                frmViewVehicles.update();
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jcbTypeOfVehicleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTypeOfVehicleItemStateChanged
        TypeOfVehicle tov = (TypeOfVehicle) jcbTypeOfVehicle.getSelectedItem();
        ImageIcon icon = null;
        Image img = null;
        Image imgScale = null;
        switch (tov.getName()) {
            case "car":
                icon = new ImageIcon(getClass().getClassLoader().getResource("car.jpg"));
                img = icon.getImage();
                imgScale = img.getScaledInstance(jLabel8.getWidth(), jLabel8.getWidth(), Image.SCALE_SMOOTH);
                break;
            case "motorcycle":
                icon = new ImageIcon(getClass().getClassLoader().getResource("motorcycle.jpg"));
                img = icon.getImage();
                imgScale = img.getScaledInstance(450, 240, Image.SCALE_SMOOTH);
                break;
            case "truck":
                icon = new ImageIcon(getClass().getClassLoader().getResource("truck.jpg"));
                img = icon.getImage();
                imgScale = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
                break;
            default:
                throw new AssertionError();
        }

        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel8.setIcon(scaledIcon);
    }//GEN-LAST:event_jcbTypeOfVehicleItemStateChanged

    private void txtModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<TypeOfVehicle> jcbTypeOfVehicle;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbYes;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMileage;
    private javax.swing.JTextField txtModel;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {

        buttonGroup1.add(jrbYes);
        buttonGroup1.add(jrbNo);

        if (mode == VehicleFormModes.VIEW) {
            btnSave.setVisible(false);

            txtId.setEditable(false);
            txtBrand.setEditable(false);
            txtModel.setEditable(false);
            txtMileage.setEditable(false);
            jrbYes.setEnabled(false);
            jrbNo.setEnabled(false);
            jcbTypeOfVehicle.setEnabled(false);
        }

        if (mode == VehicleFormModes.ADD) {
            btnDelete.setVisible(false);
            btnUpdate.setVisible(false);
            btnEdit.setVisible(false);

            jLabel2.setVisible(false);
            txtId.setVisible(false);
        }
        try {
            jcbTypeOfVehicle.setModel(new DefaultComboBoxModel(Controller.getInstance().getAllTypes().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.getContentPane().setBackground(new Color(51, 153, 255));

        ImageIcon icon1 = new ImageIcon(getClass().getClassLoader().getResource("car.jpg"));
        Image img1 = icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(jLabel8.getWidth(), jLabel8.getWidth(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
        jLabel8.setIcon(scaledIcon1);
    }

    private void populateForm() {

        if (mode == VehicleFormModes.VIEW) {
            txtId.setText(vehicle.getId().toString());
            txtBrand.setText(vehicle.getBrand());
            txtModel.setText(vehicle.getModel());
            txtMileage.setText(vehicle.getMileage() + "");
            if (vehicle.isAvailability()) {
                jrbYes.setSelected(true);
            } else {
                jrbNo.setSelected(true);
            }
            jcbTypeOfVehicle.setSelectedItem(vehicle.getTypeOfVehicle());
        } else if (mode == VehicleFormModes.ADD) {
            txtBrand.setText("");
            txtModel.setText("");
            txtMileage.setText("");
            jrbNo.setSelected(true);
            jcbTypeOfVehicle.setSelectedItem(-1);
        }

    }

    private Vehicle getInputData() {
        Vehicle inputVehicle = new Vehicle();
        if (mode == VehicleFormModes.VIEW) {
            Long id = Long.parseLong(txtId.getText());
            inputVehicle.setId(id);
        }
        inputVehicle.setBrand(txtBrand.getText().trim());
        inputVehicle.setModel(txtModel.getText().trim());
        inputVehicle.setMileage(Integer.parseInt(txtMileage.getText().trim()));

        boolean availability;
        availability = jrbYes.isSelected();
        inputVehicle.setAvailability(availability);

        TypeOfVehicle tov = (TypeOfVehicle) jcbTypeOfVehicle.getSelectedItem();
        inputVehicle.setTypeOfVehicle(tov);
        return inputVehicle;
    }
}
