package fitnesscampsystem;

import DataBase.Database;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import panels.Members;
import fitnesscampsystem.Add_a_Member;

public class payment extends javax.swing.JFrame {
    
    Add_a_Member add = Add_a_Member.getInstance();
    
        PreparedStatement pst;
        ResultSet rs;
        Connection con;

    public payment() {
        initComponents();
        con = Database.ConnectDB();
        jTextField1.setEditable(false);
    }
    
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
//    public void Save() {
//
//        if ((firstnameField.getText().trim().isEmpty())) {
//            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
//        } else if (lastnameField.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
//        } else if (sexComboBox.getItemCount() == 0) {
//            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
//        }    else if (healthconcernField.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
//        } else if (month.getItemCount() == 0) {
//            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            try {
//                String sql = "INSERT INTO Members_Tbl(Firstname,Lastname,Sex,ContactNumber,Occupation,Address,Hobbies,"
//                        + "Contactperson,ContactPersonNo,Relationship,Healthconcern,Currentweight,Targetweight,Month,Start,End,Created_at,Payment)"
//                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//                pst = con.prepareStatement(sql);
//                //PersonalInformation
//                pst.setString(1, firstnameField.getText());
//                pst.setString(2, lastnameField.getText());
//                String sex = sexComboBox.getSelectedItem().toString();//comboBox
//                pst.setString(3, sex);
//                pst.setString(4, contactnumberField.getText());
//                pst.setString(5, occupationField.getText());
////                String bday = ((JTextField) birthdateDateChooser.getDateEditor().getUiComponent()).getText();//birthdatechooser
////                pst.setString(6, bday);
//                pst.setString(6, addressField.getText());
//                pst.setString(7, hobbiesField.getText());
//                //EmeergencyInformation
//                pst.setString(8, contactpersonField.getText());
//                pst.setString(9, contactPersonNumberField.getText());
//                pst.setString(10, relationshipField.getText());
//                pst.setString(11, healthconcernField.getText());
//                pst.setString(12, currentweightField.getText());
//                pst.setString(13, targetweightField.getText());
//                String hv = month.getSelectedItem().toString();//membership
//                pst.setString(14, hv);
//                String dt = ((JTextField) start.getDateEditor().getUiComponent()).getText();
//                pst.setString(15, dt);
//                pst.setString(16, end.getText());
//                String ct = ((JTextField) created_at.getDateEditor().getUiComponent()).getText();
//                pst.setString(17, ct);  
//                pst.setString(18, yu.getText());
//
//                pst.execute();
//                JOptionPane.showMessageDialog(null, "Saved!");
//                clear();
//                pst.close();
//            } catch (Exception e) {
////                JOptionPane.showMessageDialog(null, e);
//                    System.out.println(e+"eto");
//                    
//            }
//        }
//            Members b=new Members();
//            b.Table_view();
//    }
    
//      public void clear() {
//          //CLear the fields
//        firstnameField.setText("");
//        lastnameField.setText("");
//        sexComboBox.setSelectedIndex(0);
//        contactnumberField.setText("");
//        occupationField.setText("");
////        ((JTextField)  birthdateDateChooser.getDateEditor().getUiComponent()).setText("");
//        addressField.setText("");
//        hobbiesField.setText("");
//        
//        contactpersonField.setText("");
//        contactPersonNumberField.setText("");
//        relationshipField.setText("");
//        healthconcernField.setText("");
//        
//        currentweightField.setText("");
//        targetweightField.setText("");
//        contactpersonField.setText("");
//        month.setSelectedIndex(0);
//        
//        ((JTextField) created_at.getDateEditor().getUiComponent()).setText("");
//        ((JTextField) start.getDateEditor().getUiComponent()).setText("");
//        end.setText("");
//        yu.setText("");
//
//    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Payment = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        SEYB = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Payment.setText("Payment");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SEYB.setText("CONFIRM");
        SEYB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEYBActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Payment)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SEYB))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Payment)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SEYB)
                    .addComponent(jButton2))
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SEYBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEYBActionPerformed
        Add_a_Member c = Add_a_Member.getInstance();
        c.Save();
//
//
//
//            try {
//                String sql = "INSERT INTO Members_Tbl(Firstname,Lastname,Sex,ContactNumber,Occupation,Address,Hobbies,"
//                        + "Contactperson,ContactPersonNo,Relationship,Healthconcern,Currentweight,Targetweight,Month,Start,End,Created_at,Payment)"
//                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//                pst = con.prepareStatement(sql);
//                //PersonalInformation
//                pst.setString(1, firstnameField.getText());
//                pst.setString(2, lastnameField.getText());
//                String sex = sexComboBox.getSelectedItem().toString();//comboBox
//                pst.setString(3, sex);
//                pst.setString(4, contactnumberField.getText());
//                pst.setString(5, occupationField.getText());
////                String bday = ((JTextField) birthdateDateChooser.getDateEditor().getUiComponent()).getText();//birthdatechooser
////                pst.setString(6, bday);
//                pst.setString(6, addressField.getText());
//                pst.setString(7, hobbiesField.getText());
//                //EmeergencyInformation
//                pst.setString(8, contactpersonField.getText());
//                pst.setString(9, contactPersonNumberField.getText());
//                pst.setString(10, relationshipField.getText());
//                pst.setString(11, healthconcernField.getText());
//                pst.setString(12, currentweightField.getText());
//                pst.setString(13, targetweightField.getText());
//                String hv = month.getSelectedItem().toString();//membership
//                pst.setString(14, hv);
//                String dt = ((JTextField) start.getDateEditor().getUiComponent()).getText();
//                pst.setString(15, dt);
//                pst.setString(16, end.getText());
//                String ct = ((JTextField) created_at.getDateEditor().getUiComponent()).getText();
//                pst.setString(17, ct);  
//                pst.setString(18, yu.getText());
//
//                pst.execute();
//                JOptionPane.showMessageDialog(null, "Saved!");
////                clear();
//                pst.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
////                    System.out.println(e+"eto");
//                    
//            }
        
    }//GEN-LAST:event_SEYBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setDefaultCloseOperation(Main_Frame_Admin.DISPOSE_ON_CLOSE);
        close();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Payment;
    private javax.swing.JButton SEYB;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
