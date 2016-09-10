/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.gui.Iframes;

import com.cs.dao.Supplier;
import com.cs.gui.frmMain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author home
 */
public class frmISupplier extends javax.swing.JInternalFrame {

    private final EntityManager em = frmMain.emf.createEntityManager();

    private List<Supplier> supList = new ArrayList<>();
    Supplier selectedSupplier;

    /**
     * Creates new form frmICustomer
     */
    public frmISupplier() {
        initComponents();
        Query query = em.createNamedQuery("Supplier.findAll");
        supList = (List<Supplier>) query.getResultList();
        loadSupplierTable(null);
        tblMain.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!optAdd.isSelected() && tblMain.getSelectedRow() > -1) {
                    String name = (String) tblMain.getValueAt(tblMain.getSelectedRow(), 0);
                    selectedSupplier = findSupplier(name);
                    txtAddress.setText(selectedSupplier.getSupplierAddress());
                    txtName.setText(selectedSupplier.getSupplierName());
                    txtMobile.setText(selectedSupplier.getSupplierMobile());
                    txtTell.setText(selectedSupplier.getSupplierPhone1());
                    txtAccountID.setText(selectedSupplier.getSupplierAccountId() + "");
                    txtEmail.setText(selectedSupplier.getSupplierEmail());
                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        txtEmail = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFindBy = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        optAdd = new javax.swing.JRadioButton();
        optDelete = new javax.swing.JRadioButton();
        optUpdate = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtTell = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAccountID = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Supplier");

        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Mobile", "E-mail", "Phone", "Account ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMain);

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        jLabel3.setText("Mobile");

        jLabel4.setText("Tell");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel6.setText("Find By Name");

        txtFindBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindByActionPerformed(evt);
            }
        });
        txtFindBy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindByKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFindByKeyTyped(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        buttonGroup1.add(optAdd);
        optAdd.setSelected(true);
        optAdd.setText("Add");
        optAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAddActionPerformed(evt);
            }
        });

        buttonGroup1.add(optDelete);
        optDelete.setText("Delete");
        optDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDeleteActionPerformed(evt);
            }
        });

        buttonGroup1.add(optUpdate);
        optUpdate.setText("Update");
        optUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optUpdateActionPerformed(evt);
            }
        });

        jLabel8.setText("E-Mail");

        jLabel10.setText("Account ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optAdd)
                    .addComponent(jLabel6))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(optDelete)
                        .addGap(40, 40, 40)
                        .addComponent(optUpdate)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFindBy)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtTell, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)
                        .addComponent(txtAccountID)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optAdd)
                    .addComponent(optDelete)
                    .addComponent(optUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFindBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtTell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtFindByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindByActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtName.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "You Must Provide A Supplier Name");
            return;
        }

        if (txtMobile.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "You Must Provide A Mobile number");
            return;
        }

        if (optAdd.isSelected()) {
            em.getTransaction().begin();
            Supplier sup = new Supplier();

            sup.setSupplierAddress(txtAddress.getText().trim());
            sup.setSupplierMobile(txtMobile.getText().trim());
            sup.setSupplierName(txtName.getText().trim());
            sup.setSupplierAccountId((txtAccountID.getText().length() == 0 ? null : Integer.parseInt(txtAccountID.getText().trim())));
            sup.setSupplierEmail(txtEmail.getText().trim());
            sup.setSupplierPhone1(txtTell.getText().trim());

            em.persist(sup);
            em.getTransaction().commit();
            supList.add(sup);
            loadSupplierTable(null);
            JOptionPane.showMessageDialog(this, "Supplier Added", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        if (optUpdate.isSelected() && selectedSupplier != null) {
            em.getTransaction().begin();

            selectedSupplier.setSupplierAddress(txtAddress.getText().trim());
            selectedSupplier.setSupplierMobile(txtMobile.getText().trim());
            selectedSupplier.setSupplierName(txtName.getText().trim());
            selectedSupplier.setSupplierAccountId(Integer.parseInt(txtAccountID.getText().trim()));
            selectedSupplier.setSupplierEmail(txtEmail.getText().trim());
            selectedSupplier.setSupplierPhone1(txtTell.getText().trim());

            em.persist(selectedSupplier);
            em.getTransaction().commit();
            supList.remove(selectedSupplier);
            supList.add(selectedSupplier);
            loadSupplierTable(null);
            JOptionPane.showMessageDialog(this, "Supplier Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
            selectedSupplier = null;
        }

        if (optDelete.isSelected() && selectedSupplier != null) {
            em.getTransaction().begin();

            em.remove(selectedSupplier);
            em.getTransaction().commit();
            supList.remove(selectedSupplier);
            loadSupplierTable(null);
            JOptionPane.showMessageDialog(this, "Supplier Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            selectedSupplier = null;
        }
        clearALl();

    }//GEN-LAST:event_btnSaveActionPerformed


    private void optAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAddActionPerformed
        btnSave.setText("Add");
        clearALl();
    }//GEN-LAST:event_optAddActionPerformed

    private void optDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDeleteActionPerformed
        btnSave.setText("Delete");
    }//GEN-LAST:event_optDeleteActionPerformed

    private void optUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optUpdateActionPerformed
        btnSave.setText("Update");
    }//GEN-LAST:event_optUpdateActionPerformed

    private void tblMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainMouseClicked
        if (!optAdd.isSelected() && tblMain.getSelectedRow() > -1) {
            String name = (String) tblMain.getValueAt(tblMain.getSelectedRow(), 0);
            selectedSupplier = findSupplier(name);
            txtAddress.setText(selectedSupplier.getSupplierAddress());
            txtName.setText(selectedSupplier.getSupplierName());
            txtMobile.setText(selectedSupplier.getSupplierMobile());
            txtTell.setText(selectedSupplier.getSupplierPhone1());
            txtAccountID.setText(selectedSupplier.getSupplierAccountId() + "");
            txtEmail.setText(selectedSupplier.getSupplierEmail());

        }
    }//GEN-LAST:event_tblMainMouseClicked

    private void txtFindByKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindByKeyTyped

    }//GEN-LAST:event_txtFindByKeyTyped

    private void txtFindByKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindByKeyReleased
        loadSupplierTable(txtFindBy.getText());

    }//GEN-LAST:event_txtFindByKeyReleased

    Supplier findSupplier(String name) {
        for (Supplier supplier : supList) {
            if (supplier.getSupplierName().equals(name)) {
                return supplier;
            }
        }
        return null;
    }

    void loadSupplierTable(String name) {

        DefaultTableModel tblModel = (DefaultTableModel) tblMain.getModel();
        tblModel.setRowCount(0);
        for (Supplier supplier : supList) {
            if (name == null) {
                tblModel.addRow(new Object[]{supplier.getSupplierName(), supplier.getSupplierPhone1(), supplier.getSupplierMobile(), supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierAccountId()});

            } else if (supplier.getSupplierName().toLowerCase().startsWith(name.toLowerCase())) {

                tblModel.addRow(new Object[]{supplier.getSupplierName(), supplier.getSupplierPhone1(), supplier.getSupplierMobile(), supplier.getSupplierAddress(), supplier.getSupplierEmail(), supplier.getSupplierAccountId()});
            }
        }

    }

    void enableALl() {
        txtAddress.setEnabled(true);
        txtFindBy.setEnabled(true);
        txtMobile.setEnabled(true);
        txtTell.setEnabled(true);
        txtAccountID.setEnabled(true);
        txtEmail.setEnabled(true);
    }

    void desableALl() {
        txtAddress.setEnabled(false);
        txtFindBy.setEnabled(false);
        txtMobile.setEnabled(false);
        txtTell.setEnabled(false);
        txtAccountID.setEnabled(false);
        txtEmail.setEnabled(false);
    }

    void clearALl() {
        txtName.setText("");
        txtAddress.setText("");
        txtFindBy.setText("");
        txtMobile.setText("");
        txtTell.setText("");
        txtAccountID.setText("");
        txtEmail.setText("");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton optAdd;
    private javax.swing.JRadioButton optDelete;
    private javax.swing.JRadioButton optUpdate;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtAccountID;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFindBy;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTell;
    // End of variables declaration//GEN-END:variables
}
