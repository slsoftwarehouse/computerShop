/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.gui.Iframes;

import com.cs.gui.frmMain;
import com.cs.util.RequestFocusListener;
import java.awt.event.KeyEvent;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author home
 */
public class pnlSearch extends javax.swing.JPanel {

    JTextField inputField;
    String searchQuery;
    String paramName;
    JButton okay;
    private DefaultListModel listModel;

    /**
     * Creates new form pnlSearch
     */
    public pnlSearch(String searchQuery, JTextField inputField, String paramName, JButton okay) {
        initComponents();
        this.inputField = inputField;
        this.searchQuery = searchQuery;
        this.paramName = paramName;
        this.okay = okay;
        InputMap im = lstSearchResult.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "selectNextRow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "selectPreviousRow");
        lstSearchResult.setInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW, im);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearchFiled = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listModel = new DefaultListModel();
        lstSearchResult = new javax.swing.JList<>(listModel);

        txtSearchFiled.addAncestorListener( new RequestFocusListener() );
        txtSearchFiled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchFiledActionPerformed(evt);
            }
        });
        txtSearchFiled.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchFiledKeyReleased(evt);
            }
        });

        lstSearchResult.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lstSearchResultKeyReleased(evt);
            }
        });
        lstSearchResult.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSearchResultValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstSearchResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(txtSearchFiled)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtSearchFiled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstSearchResultKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstSearchResultKeyReleased
//        if(evt.getKeyCode()==13){
//            inputField.setText(lstSearchResult.getModel().getElementAt(lstSearchResult.getSelectedIndex()));
//            
//        }
    }//GEN-LAST:event_lstSearchResultKeyReleased

    private void lstSearchResultValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSearchResultValueChanged

        if (evt.getValueIsAdjusting() == false) {

            if (lstSearchResult.getSelectedIndex() != -1) {
                inputField.setText(listModel.getElementAt(lstSearchResult.getSelectedIndex()).toString());

            }
        }


    }//GEN-LAST:event_lstSearchResultValueChanged

    private void txtSearchFiledKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFiledKeyReleased
       if(evt.getKeyCode()==40 || evt.getKeyCode()==38){
           return;
       }
        
        listModel.clear();
        Query createQuery = frmMain.emf.createEntityManager().createQuery(searchQuery);
        createQuery.setParameter(paramName, txtSearchFiled.getText() + "%");
        createQuery.setMaxResults(8);
        List entity = createQuery.getResultList();
        for (Object e : entity) {
            listModel.addElement(e);
        }
        if (listModel.getSize() > 0) {
            lstSearchResult.setSelectedIndex(0);
        }

    }//GEN-LAST:event_txtSearchFiledKeyReleased

    private void txtSearchFiledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchFiledActionPerformed
        okay.doClick();
    }//GEN-LAST:event_txtSearchFiledActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Object> lstSearchResult;
    private javax.swing.JTextField txtSearchFiled;
    // End of variables declaration//GEN-END:variables
}