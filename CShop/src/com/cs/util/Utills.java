/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.util;

import java.text.DecimalFormat;

/**
 *
 * @author home
 */
public class Utills {
    public static String formatDecimal(double in){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(in);
    }
}
