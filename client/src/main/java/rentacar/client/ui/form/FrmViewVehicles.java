/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar.client.ui.form;

import rentacar.client.consts.VehicleFormModes;
import rentacar.client.controller.Controller;
import rentacar.common_lib.model.TypeOfVehicle;
import rentacar.common_lib.model.Vehicle;
import rentacar.client.ui.table.model.VehicleTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Somika
 */
public class FrmViewVehicles extends javax.swing.JFrame {
    
    private List<Vehicle> vehicles;
    private List<Vehicle> filters;
    
    public FrmViewVehicles() {
        initComponents();
        setLocationRelativeTo(null);
        vehicles = new ArrayList<>();
        populateForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehicles = new javax.swing.JTable();
        btnDetail = new javax.swing.JButton();
        jcbTypeOfVehicles = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVehicles.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblVehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVehicles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblVehicles);

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnFilter.setText("Filter:");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vehicles for renting");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDetail)
                        .addGap(66, 66, 66)
                        .addComponent(btnFilter)
                        .addGap(18, 18, 18)
                        .addComponent(jcbTypeOfVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addGap(79, 79, 79)
                        .addComponent(btnClose)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(jcbTypeOfVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter)
                    .addComponent(btnClose)
                    .addComponent(btnReset))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        int selectedRow = tblVehicles.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "You must select the row!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (filters != null) {
            new FrmVehicle(filters.get(selectedRow), this, VehicleFormModes.VIEW).setVisible(true);
        } else {
            new FrmVehicle(vehicles.get(selectedRow), this, VehicleFormModes.VIEW).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        try {
            if (jcbTypeOfVehicles.getSelectedItem() == null) {
                return;
            }
            vehicles = Controller.getInstance().getAllVehicles();
            
            ((VehicleTableModel) tblVehicles.getModel()).setVehicles(vehicles);
            TypeOfVehicle tov = (TypeOfVehicle) jcbTypeOfVehicles.getSelectedItem();
            
            filters = ((VehicleTableModel) tblVehicles.getModel()).filter(tov);
            ((VehicleTableModel) tblVehicles.getModel()).setVehicles(filters);
            ((VehicleTableModel) tblVehicles.getModel()).update();
        } catch (Exception ex) {
            Logger.getLogger(FrmViewVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        ((VehicleTableModel) tblVehicles.getModel()).setVehicles(vehicles);
        ((VehicleTableModel) tblVehicles.getModel()).update();
        jcbTypeOfVehicles.setSelectedIndex(-1);
        filters = null;
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<TypeOfVehicle> jcbTypeOfVehicles;
    private javax.swing.JTable tblVehicles;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        try {
            vehicles = Controller.getInstance().getAllVehicles();
            tblVehicles.setModel(new VehicleTableModel(vehicles));
            tblVehicles.setShowGrid(false);
            tblVehicles.setShowHorizontalLines(true);
            List<TypeOfVehicle> types = Controller.getInstance().getAllTypes();
            jcbTypeOfVehicles.setModel(new DefaultComboBoxModel(types.toArray()));
            jcbTypeOfVehicles.setSelectedIndex(-1);
        } catch (Exception ex) {
            Logger.getLogger(FrmViewVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remove(Vehicle vehicle) {
        ((VehicleTableModel) tblVehicles.getModel()).removeVehicle(vehicle);
    }
    
    public void update() throws Exception {
        ((VehicleTableModel) tblVehicles.getModel()).setVehicles(Controller.getInstance().getAllVehicles());
        ((VehicleTableModel) tblVehicles.getModel()).update();
    }
}
