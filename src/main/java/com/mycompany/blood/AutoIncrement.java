/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AutoIncrement {
    public String getPrimaryKey(String prefix,String query){
        String value=null;

        try{
        DBconnection cd=new DBconnection();
        Connection c=cd.getDBConnection();
        Statement stmt=c.createStatement();

        //String sql=query;
        ResultSet rs=stmt.executeQuery(query);
        String id=null;
        if(rs.next()){
        id=rs.getString(1);
        String getLastVal="0";
        int j=0;
        for(int i=2;i<id.length();i++){
        getLastVal+=id.charAt(i);
        j++;
        }
        // String data=String.valueOf(getLastVal);
        int num=Integer.parseInt(getLastVal);
        System.out.println(num);
        num++;
        if(prefix.equals("DN")){
        value="DN"+num;
        }
        else if(prefix.equals("BL") ){
        value="BL"+num;
        }
        else if(prefix.equals("HS") ){
        value="HS"+num;
        }
        else if(prefix.equals("OR") ){
        value="OR"+num;
        }
        else if(prefix.equals("EM") ){
        value="EM"+num;
        }
        else{

        }

        }else{
            String pr=prefix;
            value=pr+"1";
            
        }

        //System.out.print(id);
        //id=rs.getString(1);
        // int size=id.length();
        // System.out.println(size);
        
        c.close();
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        return value;
        }
}
