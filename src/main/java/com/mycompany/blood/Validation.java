/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blood;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Validation {
    public boolean emailValid(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
    }

    public int integerValid(String data,String data1){
    int n=0;
    try{

    Integer.parseInt(data);
    }

    catch (NumberFormatException e){
    JOptionPane.showMessageDialog(null,"Enter a valid integer number for "+data1);
    n++;
    }
    return n;
    }
}
