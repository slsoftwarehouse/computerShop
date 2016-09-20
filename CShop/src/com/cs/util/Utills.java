/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.util;

import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author home
 */
public class Utills {
    public static String formatDecimal(double in){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(in);
    }
    
    public static void addRowToTable(JTable tbl, Object[] arr) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.addRow(arr);
    }

    public static void removeRowFromTable(JTable tbl, int rowIndex) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.removeRow(rowIndex);
    }
    
    public static void clearTable(JTable tbl){
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
    
    }
}
