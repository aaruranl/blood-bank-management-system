/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blood;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author User
 */
public class Bloodt extends javax.swing.JFrame {

    /**
     * Creates new form Bloodt
     */
    public Bloodt() {
        initComponents();
        viewcombo();
    }
    
    Validation validation=new Validation();
    
    private void search(String sql){
        try{
                    DBconnection cd=new DBconnection();
                    Connection c=cd.getDBConnection();
                    Statement stmt=c.createStatement();
                    //String sql="SELECT blood.*,donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and donor.D_blood_group='"+jTextField7.getText()+"')";
                    ResultSet rs=stmt.executeQuery(sql);
                    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                    model.setRowCount(0);
                    JTableHeader th = jTable1.getTableHeader();
                    th.setFont(new Font("Serif", Font.BOLD, 15));
                    while(rs.next()){
                        String id=rs.getString("blood_id");
                        String bid=rs.getString("blood_bank_id");
                        String did=rs.getString("donor_id");
                        String bq=rs.getString("blood_quantity");
                        String bg=rs.getString("d_blood_group");
                        String ddate=rs.getString("d_date");
                        String edate=rs.getString("exp_date");
                        String tbData[]={id,bid,did,bg,bq,ddate,edate};
                        
                        
                        model.addRow(tbData);
                    }
                    c.close();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                } 
    }
    
    private void view(){
            try{
            DBconnection cd=new DBconnection();
            Connection c=cd.getDBConnection();
            Statement stmt=c.createStatement();
            String sql="Select blood.*,donor.d_blood_group from blood,donor where donor.donor_id=blood.donor_id";
            ResultSet rs=stmt.executeQuery(sql);
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            JTableHeader th = jTable1.getTableHeader();
            th.setFont(new Font("Serif", Font.BOLD, 15));
            while(rs.next()){
            String id=rs.getString("blood_id");
            String bid=rs.getString("blood_bank_id");
            String did=rs.getString("donor_id");
            String bg=rs.getString("d_blood_group");
            String bq=rs.getString("blood_quantity");
            String ddate=rs.getString("d_date");
            String edate=rs.getString("exp_date");
            String tbData[]={id,bid,did,bg,bq,ddate,edate};


            model.addRow(tbData);
            }
            c.close();
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
        }
    
    
    
    private void viewcombo(){
        try{
        DBconnection cd=new DBconnection();
        Connection c=cd.getDBConnection();
        Statement stmt=c.createStatement();

        String sql="Select * from blood_bank";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){

            jComboBox2.addItem(rs.getString("Blood_bank_id"));
        }
        c.close();
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Id", "Bank Id", "Donor Id", "Blood Group", "Quantity", "Donated Date", "Expriry Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 350, 170));

        jLabel2.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel2.setText("Blood Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 70, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 120, -1));

        jLabel3.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel3.setText("Bank Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 80, -1));

        jLabel4.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel4.setText("Donor Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 120, -1));

        jLabel5.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 80, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 120, -1));

        jLabel6.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel6.setText("Donated Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, -1));

        jLabel7.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel7.setText("Expiry Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, -1));

        btnAdd.setBackground(new java.awt.Color(255, 0, 0));
        btnAdd.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 73, -1));

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 80, -1));

        btnHome.setBackground(new java.awt.Color(255, 0, 0));
        btnHome.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        jLabel8.setText("Search By :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 100, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blood Group", "Blood ID", "Donor Id", "Blood bank Id", "Donated Date", "Expiry Date" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        btnSearch.setBackground(new java.awt.Color(255, 0, 0));
        btnSearch.setFont(new java.awt.Font("Nexa Light", 0, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 80, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 130, 30));

        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 120, -1));

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 120, -1));

        jDateChooser2.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 120, -1));

        jLabel9.setFont(new java.awt.Font("Nexa Light", 0, 10)); // NOI18N
        jLabel9.setText("Search and click the Item to Delete ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\2nd semi\\Database Design and Development\\project\\interface\\blood page 2.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 402));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try{
            DBconnection cd=new DBconnection();
            Connection c=cd.getDBConnection();
            Statement stmt=c.createStatement();
            String blood_id=jTextField1.getText();
            String Bank_id=jComboBox2.getSelectedItem().toString();
            String donor_id= jTextField3.getText();
            String quantity=jTextField4.getText();
            String Donated_date=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
            String Expriry_date=((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
           
            
             if(validation.integerValid(quantity,"blood quantity")==0){
            String sql1="insert into blood (blood_id,Blood_bank_Id,donor_id,blood_quantity,d_date,exp_date) VALUES ('"+blood_id+"','"+Bank_id+"', '"+donor_id+"', '"+quantity+"','"+Donated_date+"','"+Expriry_date+"');";
            
            stmt.executeUpdate(sql1);
                    JOptionPane.showMessageDialog(this,"1 ITEM ADDED");
            view();
             }
            c.close();
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
            
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
      
        
        if(!(jTable1.isCellSelected(NORMAL, NORMAL))){
            JOptionPane.showMessageDialog(this,"Please search And click the record in the table");
            }
            else{

            //viewDELETE();

            int dialogButton=JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this,"Delete this data","Delete",dialogButton);
            if(dialogResult==0){
            try{
            DBconnection cd=new DBconnection();
            Connection c=cd.getDBConnection();
            Statement stmt=c.createStatement();

            String sql1="delete from blood where blood_id='"+jTextField1.getText()+"'";
            stmt.executeUpdate(sql1);
            JOptionPane.showMessageDialog(this,"RECORD DELETED");
            c.close();
            }

            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
            }
            this.setVisible(false);
            new Bloodt().setVisible(true);
            view();

}


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                search("SELECT blood.*,donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and donor.D_blood_group='"+jTextField7.getText()+"')");
                 break;
            case 1:
                search("SELECT blood.*, donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and blood.blood_id='"+jTextField7.getText()+"')");
                break;
            case 2:
                search("SELECT blood.*, donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and blood.donor_id='"+jTextField7.getText()+"')");
                break;
                
            case 3:
                search("SELECT blood.*, donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and blood.blood_bank_id='"+jTextField7.getText()+"')");
                break;    
            case 4:
                search("SELECT blood.*, donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and blood.d_date='"+jTextField7.getText()+"')" );
                break;
            case 5:
                search("SELECT blood.*, donor.d_blood_group from BLOOD,donor where (blood.donor_id=donor.donor_id and blood.exp_date='"+jTextField7.getText()+"')");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        try{
        
        jTextField1.setEditable(false);
        AutoIncrement aid=new AutoIncrement();
        String blood_id=aid.getPrimaryKey("BL","SELECT blood_id FROM blood ORDER BY blood_id DESC LIMIT 1");
        jTextField1.setText(blood_id);
        view();
        }

        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        

    }//GEN-LAST:event_formComponentShown

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row,col;
        row = jTable1.getSelectedRow();
        DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();

        col = jTable1.getColumnCount();
        jTextField1.setText(dtm.getValueAt(row,0).toString());
        jComboBox1.setSelectedItem(dtm.getValueAt(row,1).toString());
        jTextField3.setText(dtm.getValueAt(row, 2).toString());
        jTextField4.setText(dtm.getValueAt(row, 4).toString());
        ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(dtm.getValueAt(row, 5).toString());
        ((JTextField)jDateChooser2.getDateEditor().getUiComponent()).setText(dtm.getValueAt(row, 6).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bloodt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bloodt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bloodt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bloodt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bloodt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}