
package panels;

import DataBase.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JPanel {

    Connection con= null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Register() {
        initComponents();
        con = Database.ConnectDB();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RG_NAME = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelpw = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        RG_LASTNAME = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        SAVE = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        RG_USERNAME = new javax.swing.JTextField();
        RG_PASSWORD = new javax.swing.JPasswordField();
        RG_CONFIRMPASSWORD = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(RG_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 81, 400, -1));

        jLabel17.setText("Name");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 84, -1, -1));

        jLabel18.setText("Last Name");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 115, -1, -1));

        labelpw.setText("Password");
        add(labelpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 169, -1, -1));

        jLabel20.setText("Confirm Password");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 194, -1, -1));
        add(RG_LASTNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 112, 400, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Admin", "User" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 231, 400, -1));

        SAVE.setText("SAVE");
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });
        add(SAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 278, 400, -1));

        jLabel19.setText("Username");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 146, -1, -1));
        add(RG_USERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 143, 400, -1));
        add(RG_PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 169, 400, -1));
        add(RG_CONFIRMPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 195, 400, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
        String name = RG_NAME.getText();
        String lastname = RG_LASTNAME.getText();
        String username = RG_USERNAME.getText();
        String password = new String(RG_PASSWORD.getPassword());   
        String confirmpassword = new String(RG_CONFIRMPASSWORD.getPassword()); 
        String opt = jComboBox1.getSelectedItem().toString();
      
        
        if((RG_NAME.getText().trim().isEmpty())){
                          JOptionPane.showMessageDialog(null,"Fill out the important information","Error", JOptionPane.ERROR_MESSAGE);
                      }
                 else if(RG_LASTNAME.getText().trim().isEmpty()){
                          JOptionPane.showMessageDialog(null,"Fill out the important information","Error", JOptionPane.ERROR_MESSAGE);
                      }
                 else if(RG_USERNAME.getText().trim().isEmpty()){
                          JOptionPane.showMessageDialog(null,"Fill out the important information","Error", JOptionPane.ERROR_MESSAGE);
                      }
                 else if(RG_PASSWORD.getText().trim().isEmpty()){
                          JOptionPane.showMessageDialog(null,"Fill out the important information","Error", JOptionPane.ERROR_MESSAGE);
                      }
                 else if(RG_CONFIRMPASSWORD.getText().trim().isEmpty()){
                          JOptionPane.showMessageDialog(null,"Fill out the important information","Error", JOptionPane.ERROR_MESSAGE);
                      }
                 else
            
        try{
                pst=con.prepareStatement("INSERT into Login_Tbl(name, lastname, username, password, confirm_password, options) values (?,?,?,?,?,?)");
                
                pst.setString(1, RG_NAME.getText());
                pst.setString(2, RG_LASTNAME.getText());
                pst.setString(3, RG_USERNAME.getText());
                pst.setString(4, password);
                pst.setString(5, confirmpassword);
                pst.setString(6, opt);
                
                if(password.equals(confirmpassword)){
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this,"User Successfully Registered", "success",JOptionPane.INFORMATION_MESSAGE);
//                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"Username & Password did not matched!","User not registered",JOptionPane.ERROR_MESSAGE);
                }
                RG_NAME.setText(null);
                RG_LASTNAME.setText(null);
                RG_USERNAME.setText(null);
                RG_PASSWORD.setText(null);
                RG_CONFIRMPASSWORD.setText(null);
                
            }catch(Exception e){
                e.printStackTrace();         
            }
    }//GEN-LAST:event_SAVEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField RG_CONFIRMPASSWORD;
    private javax.swing.JTextField RG_LASTNAME;
    private javax.swing.JTextField RG_NAME;
    private javax.swing.JPasswordField RG_PASSWORD;
    private javax.swing.JTextField RG_USERNAME;
    private javax.swing.JButton SAVE;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel labelpw;
    // End of variables declaration//GEN-END:variables

   
}
