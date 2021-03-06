package fitnesscampsystem;

import DataBase.DataBaseLogs;
import DataBase.Database;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Add_a_User extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private static Add_a_User instance = null;

    public static Add_a_User getInstance() {
        if (instance == null) {
            instance = new Add_a_User();
        }
        return instance;
    }

    public Add_a_User() {
        initComponents();
        con = Database.ConnectDB();

    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public boolean checkUsername(String username) {
        boolean checkUser = false;

        String sql = "SELECT * FROM Login_Tbl WHERE username = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                checkUser = true;
            }
        } catch (Exception e) {
        }
        return checkUser;
    }
    
    public void clear_ops() {
                    RG_NAME.setText("");
                    RG_LASTNAME.setText("");
                    RG_USERNAME.setText("");
                    RG_PASSWORD.setText("");
                    RG_CONFIRMPASSWORD.setText("");
                    jComboBox1.setSelectedIndex(0);;
                    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        RG_NAME = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelpw = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        RG_LASTNAME = new javax.swing.JTextField();
        CANCEL = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        RG_USERNAME = new javax.swing.JTextField();
        RG_PASSWORD = new javax.swing.JPasswordField();
        RG_CONFIRMPASSWORD = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SAVE1 = new javax.swing.JButton();
        descriptionuser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(null);

        RG_NAME.setBackground(new java.awt.Color(227, 229, 233));
        RG_NAME.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        RG_NAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RG_NAMEActionPerformed(evt);
            }
        });
        jPanel2.add(RG_NAME);
        RG_NAME.setBounds(190, 120, 170, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel17.setText("Name");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(90, 130, 36, 20);

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel18.setText("Last Name");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(80, 170, 70, 22);

        labelpw.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelpw.setText("Password");
        jPanel2.add(labelpw);
        labelpw.setBounds(80, 270, 58, 20);

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel20.setText("Confirm Password");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(60, 320, 111, 20);

        RG_LASTNAME.setBackground(new java.awt.Color(227, 229, 233));
        RG_LASTNAME.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel2.add(RG_LASTNAME);
        RG_LASTNAME.setBounds(190, 170, 170, 22);

        CANCEL.setBackground(new java.awt.Color(227, 229, 233));
        CANCEL.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CANCEL.setText("CANCEL");
        CANCEL.setContentAreaFilled(false);
        CANCEL.setOpaque(true);
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });
        jPanel2.add(CANCEL);
        CANCEL.setBounds(190, 490, 170, 29);

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel19.setText("Username");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(80, 220, 61, 20);

        RG_USERNAME.setBackground(new java.awt.Color(227, 229, 233));
        RG_USERNAME.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel2.add(RG_USERNAME);
        RG_USERNAME.setBounds(190, 220, 170, 22);

        RG_PASSWORD.setBackground(new java.awt.Color(227, 229, 233));
        RG_PASSWORD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel2.add(RG_PASSWORD);
        RG_PASSWORD.setBounds(190, 270, 170, 22);

        RG_CONFIRMPASSWORD.setBackground(new java.awt.Color(227, 229, 233));
        RG_CONFIRMPASSWORD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel2.add(RG_CONFIRMPASSWORD);
        RG_CONFIRMPASSWORD.setBounds(190, 320, 170, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "User", "Admin", " " }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(190, 370, 170, 27);

        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel21.setText("Role");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(90, 380, 26, 20);

        jPanel3.setBackground(new java.awt.Color(48, 173, 95));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add User Account");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(193, 193, 193))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 530, 50);

        SAVE1.setBackground(new java.awt.Color(48, 173, 95));
        SAVE1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        SAVE1.setForeground(new java.awt.Color(255, 255, 255));
        SAVE1.setText("SAVE");
        SAVE1.setContentAreaFilled(false);
        SAVE1.setOpaque(true);
        SAVE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVE1ActionPerformed(evt);
            }
        });
        jPanel2.add(SAVE1);
        SAVE1.setBounds(190, 450, 170, 29);

        descriptionuser.setText("Added a User");
        jPanel2.add(descriptionuser);
        descriptionuser.setBounds(210, 550, 120, 14);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        this.setDefaultCloseOperation(Main_Frame_Admin.DISPOSE_ON_CLOSE);
        close();
        Main_Frame_Admin mf = Main_Frame_Admin.getInstance();
        mf.setEnabled(true);
    }//GEN-LAST:event_CANCELActionPerformed

    private void RG_NAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RG_NAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RG_NAMEActionPerformed

    private void SAVE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVE1ActionPerformed
        String fname = RG_NAME.getText();
        String lastname = RG_LASTNAME.getText();
        String username = RG_USERNAME.getText();
        String password = new String(RG_PASSWORD.getPassword());
        String confirmpassword = new String(RG_CONFIRMPASSWORD.getPassword());
        String rl = jComboBox1.getSelectedItem().toString();

        if ((RG_NAME.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (RG_LASTNAME.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (RG_USERNAME.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (RG_PASSWORD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (RG_CONFIRMPASSWORD.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (checkUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
         

        Database db = Database.getInstance();
        db.add_a_user(
                RG_USERNAME.getText(),
                RG_NAME.getText(),
                RG_LASTNAME.getText(),
                RG_PASSWORD.getText().toString(),
                RG_CONFIRMPASSWORD.getText().toString(),
                jComboBox1.getSelectedItem().toString()       
        );
        clear_ops();
        DataBaseLogs dbl = DataBaseLogs.getInstance();
        dbl.addUserLogs();
//
        if (password.equals(confirmpassword)) {
            JOptionPane.showMessageDialog(this, "User Successfully Registered", "success", JOptionPane.INFORMATION_MESSAGE);
//                    this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username & Password did not matched!", "User not registered", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_SAVE1ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_a_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_a_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_a_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_a_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_a_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCEL;
    private javax.swing.JPasswordField RG_CONFIRMPASSWORD;
    private javax.swing.JTextField RG_LASTNAME;
    private javax.swing.JTextField RG_NAME;
    private javax.swing.JPasswordField RG_PASSWORD;
    private javax.swing.JTextField RG_USERNAME;
    private javax.swing.JButton SAVE1;
    public javax.swing.JLabel descriptionuser;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelpw;
    // End of variables declaration//GEN-END:variables
}
