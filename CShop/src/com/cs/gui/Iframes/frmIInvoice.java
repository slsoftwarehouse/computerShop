/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.gui.Iframes;

import com.cs.dao.Accounts;
import com.cs.dao.ApplicationConstants;
import com.cs.dao.CreditNote;
import com.cs.dao.Entity;
import com.cs.dao.GrnLines;
import com.cs.dao.Product;
import com.cs.gui.frmMain;
import com.cs.util.ButtonColumn;
import com.cs.util.Utills;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author home
 */
public class frmIInvoice extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInvoice
     */
    private final EntityManager em = frmMain.emf.createEntityManager();

    static String CUSTOMER_QUERY = "SELECT e FROM Entity e WHERE e.entityType =0 and e.active=1";
    static String PRODUCT_QUERY = "SELECT p FROM Product p WHERE p.name like :name";
    private List<Entity> customerList = new ArrayList<Entity>();
    private List<ApplicationConstants> paymentMethodList = new ArrayList<ApplicationConstants>();
    Entity selectedCustomer;

    public frmIInvoice() {

        initComponents();
        ((DefaultComboBoxModel) cboCTitle.getModel()).addElement("Miss");
        ((DefaultComboBoxModel) cboCTitle.getModel()).addElement("Mrs");
        ((DefaultComboBoxModel) cboCTitle.getModel()).addElement("Mr");
        ((DefaultComboBoxModel) cboCTitle.getModel()).addElement("Rev");
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                ((DefaultTableModel) table.getModel()).removeRow(modelRow);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tblMain, delete, 10);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        Query createQueryP = em.createNamedQuery("ApplicationConstants.findByFieldName");
        createQueryP.setParameter("fieldName", "payment_method");
        createQueryP.setMaxResults(5);
        List<ApplicationConstants> paymentMethods = (List<ApplicationConstants>) createQueryP.getResultList();
        for (ApplicationConstants pm : paymentMethods) {
            ((DefaultComboBoxModel) cboPaymentMethod.getModel()).addElement(pm);
        }

    }

    void setCustomerFileds(Entity e) {
        txtCContactNumber.setText(e.getContactNumber());
        txtCCreditLimit.setText(Utills.formatDecimal(e.getCreditLimit()));
        txtCEmail.setText(e.getEmail());
        txtCName.setText(e.getName());
        txtCNIC.setText(e.getBrn());
        txtCLandLine.setText(e.getLandLine());
        cboCTitle.setSelectedItem(e.getTitile());
        txtAddress.setText(e.getAddress());
        List<Accounts> accountsList = e.getAccountsList();
        double totalCredit = 0;
        for (Accounts acc : accountsList) {
            totalCredit += acc.getCredit() - acc.getDebit();
        }
        txtCCredit.setText("" + Utills.formatDecimal(totalCredit));
    }

    void searchCustomer(String searchString, String paraName, String paraValue) {
        clearCustomerFields();
        Query createQuery = em.createQuery(CUSTOMER_QUERY + searchString);
        createQuery.setParameter(paraName, paraValue);
        createQuery.setMaxResults(1);
        List<Entity> entity = (List<Entity>) createQuery.getResultList();
        for (Entity e : entity) {
            selectedCustomer = e;
            setCustomerFileds(e);
            Query createQueryC = em.createNamedQuery("CreditNote.findByEntityReferance");
            createQueryC.setParameter("entityReferance", selectedCustomer.getId());
            createQueryC.setMaxResults(5);
            List<CreditNote> creditNotes = (List<CreditNote>) createQueryC.getResultList();
            for (CreditNote crn : creditNotes) {
                if (crn.getCreditNoteStatus().getValue() == 0) {
                    ((DefaultComboBoxModel) cboCNote.getModel()).addElement(crn);
                }

            }
        }

    }

    void searchCustomerByName(String searchString) {
        clearCustomerFields();
        Query createQuery = em.createQuery(CUSTOMER_QUERY + searchString);
        createQuery.setMaxResults(15);
        List<Entity> entity = (List<Entity>) createQuery.getResultList();
        for (Entity e : entity) {
            //((DefaultComboBoxModel) cboCName.getModel()).addElement(e);
        }
    }

    void clearCustomerFields() {
        txtCContactNumber.setText("");
        txtCCreditLimit.setText("");
        txtCEmail.setText("");
        txtCName.setText("");
        txtCNIC.setText("");
        txtCLandLine.setText("");
        cboCTitle.setSelectedItem("");
        txtCCredit.setText("");
        txtAddress.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtInvoiceNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboCTitle = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtDisscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboCNote = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboPaymentMethod = new javax.swing.JComboBox<>();
        btnCreateInvoice = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCNoteAmount = new javax.swing.JTextField();
        txtProductSrial = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCContactNumber = new javax.swing.JTextField();
        txtCLandLine = new javax.swing.JTextField();
        txtCEmail = new javax.swing.JTextField();
        txtCNIC = new javax.swing.JTextField();
        txtCCreditLimit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtProductCode = new javax.swing.JTextField();
        chkNewCustomer = new javax.swing.JCheckBox();
        chkShowOnBill = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSearchDetails = new javax.swing.JTable();
        txtCCredit = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtCName = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Invoice");

        jLabel1.setText("Invoice Number");

        txtInvoiceNumber.setEditable(false);

        jLabel2.setText("Customer Name");

        jLabel3.setText("Code");

        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Serial", "Name", "QTY", "Cost", "End User", "Dealer", "Selling", "Warranty", "Total", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMain);
        if (tblMain.getColumnModel().getColumnCount() > 0) {
            tblMain.getColumnModel().getColumn(0).setResizable(false);
            tblMain.getColumnModel().getColumn(1).setResizable(false);
            tblMain.getColumnModel().getColumn(2).setResizable(false);
            tblMain.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblMain.getColumnModel().getColumn(3).setResizable(false);
            tblMain.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblMain.getColumnModel().getColumn(4).setResizable(false);
            tblMain.getColumnModel().getColumn(5).setResizable(false);
            tblMain.getColumnModel().getColumn(6).setResizable(false);
            tblMain.getColumnModel().getColumn(7).setResizable(false);
            tblMain.getColumnModel().getColumn(8).setResizable(false);
            tblMain.getColumnModel().getColumn(9).setResizable(false);
            tblMain.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel5.setText("Disscount");

        jLabel6.setText("Total");

        jLabel7.setText("SubTotal");

        jLabel8.setText("Credit Notes");

        cboCNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCNoteActionPerformed(evt);
            }
        });

        jLabel9.setText("Payment Method");

        btnCreateInvoice.setText("Create Invoice");

        jLabel10.setText("Credit Note Amount");

        txtProductSrial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductSrialActionPerformed(evt);
            }
        });

        jLabel11.setText("Serial");

        txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductNameKeyReleased(evt);
            }
        });

        jLabel12.setText("Name");

        jLabel4.setText("Mobile");

        jLabel13.setText("Land Line");

        jLabel14.setText("Email");

        jLabel15.setText("NIC");

        txtCContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCContactNumberActionPerformed(evt);
            }
        });

        txtCLandLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCLandLineActionPerformed(evt);
            }
        });

        txtCEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEmailActionPerformed(evt);
            }
        });

        txtCNIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCNICActionPerformed(evt);
            }
        });

        jLabel16.setText("Credit Limit");

        txtProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductCodeActionPerformed(evt);
            }
        });

        chkNewCustomer.setText("New Customer");
        chkNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNewCustomerActionPerformed(evt);
            }
        });

        chkShowOnBill.setText("Show Price On Bill");
        chkShowOnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowOnBillActionPerformed(evt);
            }
        });

        tblSearchDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Serial", "Name", "Cost", "End User", "Dealer", "Warranty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSearchDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSearchDetails);
        if (tblSearchDetails.getColumnModel().getColumnCount() > 0) {
            tblSearchDetails.getColumnModel().getColumn(0).setResizable(false);
            tblSearchDetails.getColumnModel().getColumn(1).setResizable(false);
            tblSearchDetails.getColumnModel().getColumn(2).setResizable(false);
            tblSearchDetails.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblSearchDetails.getColumnModel().getColumn(3).setResizable(false);
            tblSearchDetails.getColumnModel().getColumn(4).setResizable(false);
            tblSearchDetails.getColumnModel().getColumn(5).setResizable(false);
            tblSearchDetails.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel17.setText("Credit");

        jLabel18.setText("Address");

        txtCName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(14, 14, 14)
                        .addComponent(cboCNote, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCNoteAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDisscount, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateInvoice)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(txtCContactNumber))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtInvoiceNumber)
                                            .addComponent(cboCTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCCreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCLandLine, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCCredit))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCEmail)
                                                .addComponent(txtCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txtCName))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkShowOnBill)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chkNewCustomer))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAddress)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProductSrial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProductName))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(txtProductSrial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkNewCustomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkShowOnBill))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboCTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtCEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCLandLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtCCreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtCCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtCNoteAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboCNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtDisscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateInvoice)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNewCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkNewCustomerActionPerformed

    private void chkShowOnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowOnBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkShowOnBillActionPerformed

    private void txtCContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCContactNumberActionPerformed

        if (txtCContactNumber.getText().length() > 0) {
            searchCustomer(" and e.contactNumber = :contactNumber", "contactNumber", txtCContactNumber.getText());
        }
    }//GEN-LAST:event_txtCContactNumberActionPerformed

    private void txtCEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEmailActionPerformed

        if (txtCEmail.getText().length() > 0) {
            searchCustomer(" and e.email = :email", "email", txtCEmail.getText());
        }
    }//GEN-LAST:event_txtCEmailActionPerformed

    private void txtCLandLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCLandLineActionPerformed

        if (txtCLandLine.getText().length() > 0) {
            searchCustomer(" and e.landLine = :landLine", "landLine", txtCLandLine.getText());
        }
    }//GEN-LAST:event_txtCLandLineActionPerformed

    private void txtCNICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCNICActionPerformed

        if (txtCNIC.getText().length() > 0) {
            searchCustomer(" and e.brn = :brn", "brn", txtCNIC.getText());
        }
    }//GEN-LAST:event_txtCNICActionPerformed

    protected JOptionPane getOptionPane(JComponent parent) {
        JOptionPane pane = null;
        if (!(parent instanceof JOptionPane)) {
            pane = getOptionPane((JComponent) parent.getParent());
        } else {
            pane = (JOptionPane) parent;
        }
        return pane;
    }
    private void txtCNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCNameActionPerformed

        final JButton okay = new JButton("Ok");
        okay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = getOptionPane((JComponent) e.getSource());
                pane.setValue(okay);
                if (txtCName.getText().length() > 0) {
                    searchCustomer(" and e.name = :name", "name", txtCName.getText());
                }
            }
        });
        JPanel p = new pnlSearch(CUSTOMER_QUERY + " and e.name LIKE :name", txtCName, "name", okay);
        JOptionPane.showOptionDialog(null, p, "Search Customer", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{okay}, okay);
//
//        if (JOptionPane.showConfirmDialog(null, p, "Search Customer", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
//
//            
//
//        }

    }//GEN-LAST:event_txtCNameActionPerformed

    private void txtProductSrialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductSrialActionPerformed
        addBySerial(txtProductSrial.getText());

    }//GEN-LAST:event_txtProductSrialActionPerformed

    private void txtProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductCodeActionPerformed
        addByCode(txtProductCode.getText());

    }//GEN-LAST:event_txtProductCodeActionPerformed

    void addBySerial(String serial) {
        Query createQuery = em.createNamedQuery("GrnLines.findBySerial");
        createQuery.setParameter("serial", serial);
        createQuery.setMaxResults(1);
        List<GrnLines> grnLine = (List<GrnLines>) createQuery.getResultList();
        if (grnLine.size() > 0) {
            GrnLines grnl = grnLine.iterator().next();
            double costPrice = grnl.getPcode().getManagePriceGlobaly() == true ? grnl.getPcode().getGlobslCostPrice() : grnl.getCostPrice();
            double endUserPrice = grnl.getPcode().getManagePriceGlobaly() == true ? grnl.getPcode().getGlobalEnduserPrice() : grnl.getEndUserPrice();
            double dealerPrice = grnl.getPcode().getManagePriceGlobaly() == true ? grnl.getPcode().getGlobalDealerPrice() : grnl.getDealerPrice();

            Utills.addRowToTable(tblMain, new Object[]{grnl.getPcode().getId(), grnl.getSerial(), grnl.getPcode().getName(), 1, costPrice, endUserPrice, dealerPrice, grnl.getEndUserPrice(), grnl.getWarrantyInMonths(), endUserPrice, "-"});
        } else {
            JOptionPane.showMessageDialog(this, "Serial Not Found");
        }
    }

    void addByCode(String code) {
        Query createQuery = em.createNamedQuery("Product.findById");
        createQuery.setParameter("id", code);
        createQuery.setMaxResults(1);
        List<Product> prd = (List<Product>) createQuery.getResultList();

        if (prd.size() > 0) {
            Product pr = prd.iterator().next();
            try {
                int qty = Integer.parseInt(JOptionPane.showInputDialog("Please provide the qty"));
                double total = pr.getGlobalEnduserPrice() * qty;
                Utills.addRowToTable(tblMain, new Object[]{pr.getId(), "", pr.getName(), qty, pr.getGlobslCostPrice(), pr.getGlobalEnduserPrice(), pr.getGlobalDealerPrice(), pr.getGlobalEnduserPrice(), 0, total, "-"});

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Product Code Not Found");
        }
    }


    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyReleased
        String searchKey = txtProductName.getText();
        Query createQuery = frmMain.emf.createEntityManager().createQuery(PRODUCT_QUERY);
        createQuery.setParameter("name", searchKey + "%");
        createQuery.setMaxResults(20);
        List<Product> prdl = createQuery.getResultList();
        Utills.clearTable(tblSearchDetails);

        for (Product pr : prdl) {
            List<GrnLines> grnLine = pr.getGrnLinesList();

            if (grnLine.size() == 0) {
                Utills.addRowToTable(tblSearchDetails, new Object[]{pr.getId(), "", pr.getName(), pr.getGlobslCostPrice(), pr.getGlobalEnduserPrice(), pr.getGlobalDealerPrice(), 0});

            } else {

                for (GrnLines grnl : grnLine) {
                    double costPrice = pr.getManagePriceGlobaly() == true ? pr.getGlobslCostPrice() : grnl.getCostPrice();
                    double endUserPrice = pr.getManagePriceGlobaly() == true ? pr.getGlobalEnduserPrice() : grnl.getEndUserPrice();
                    double dealerPrice = pr.getManagePriceGlobaly() == true ? pr.getGlobalDealerPrice() : grnl.getDealerPrice();
                    Utills.addRowToTable(tblSearchDetails, new Object[]{grnl.getPcode().getId(), grnl.getSerial(), pr.getName(), costPrice, endUserPrice, dealerPrice, endUserPrice, grnl.getWarrantyInMonths()});
                }
            }

        }
    }//GEN-LAST:event_txtProductNameKeyReleased

    private void tblSearchDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchDetailsMouseClicked
        if (evt.getClickCount() == 2 && tblSearchDetails.getSelectedRow() > -1) {
            String code = tblSearchDetails.getModel().getValueAt(tblSearchDetails.getSelectedRow(), 0).toString();
            String serial = tblSearchDetails.getModel().getValueAt(tblSearchDetails.getSelectedRow(), 0).toString();
            if (serial.length() > 1) {
                addBySerial(serial);
            } else {
                addByCode(code);
            }
        }
    }//GEN-LAST:event_tblSearchDetailsMouseClicked

    private void cboCNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCNoteActionPerformed
        txtCNoteAmount.setText(Utills.formatDecimal(((CreditNote) cboCNote.getSelectedItem()).getTotal()));
    }//GEN-LAST:event_cboCNoteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateInvoice;
    private javax.swing.JComboBox<CreditNote> cboCNote;
    private javax.swing.JComboBox<String> cboCTitle;
    private javax.swing.JComboBox<ApplicationConstants> cboPaymentMethod;
    private javax.swing.JCheckBox chkNewCustomer;
    private javax.swing.JCheckBox chkShowOnBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMain;
    private javax.swing.JTable tblSearchDetails;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCContactNumber;
    private javax.swing.JTextField txtCCredit;
    private javax.swing.JTextField txtCCreditLimit;
    private javax.swing.JTextField txtCEmail;
    private javax.swing.JTextField txtCLandLine;
    private javax.swing.JTextField txtCNIC;
    private javax.swing.JTextField txtCName;
    private javax.swing.JTextField txtCNoteAmount;
    private javax.swing.JTextField txtDisscount;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextField txtProductCode;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductSrial;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
