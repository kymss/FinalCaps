package fitnesscampsystem;

import DataBase.DataBaseLogs;
import DataBase.Database;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Log_in extends javax.swing.JFrame {

    Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();

    public Log_in() {
        initComponents();

        ROLE.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        usernameField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LOGIN = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        LOGIN1 = new javax.swing.JButton();
        ROLE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));

        usernameField.setBackground(new java.awt.Color(51, 51, 51));
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setBorder(null);
        usernameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameField.setOpaque(false);

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        LOGIN.setBackground(new java.awt.Color(102, 102, 102));
        LOGIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("Login");
        LOGIN.setContentAreaFilled(false);
        LOGIN.setOpaque(true);
        LOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGINMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGINMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LOGINMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LOGINMouseReleased(evt);
            }
        });
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });
        LOGIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LOGINKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LOGINKeyReleased(evt);
            }
        });

        passwordField.setBackground(new java.awt.Color(51, 51, 51));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aaaa.png"))); // NOI18N

        LOGIN1.setBackground(new java.awt.Color(102, 102, 102));
        LOGIN1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LOGIN1.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN1.setText("Cancel");
        LOGIN1.setContentAreaFilled(false);
        LOGIN1.setOpaque(true);
        LOGIN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGIN1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGIN1MouseExited(evt);
            }
        });
        LOGIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGIN1ActionPerformed(evt);
            }
        });

        ROLE.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(82, 82, 82)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LOGIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ROLE)
                        .addGap(177, 177, 177))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(LOGIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LOGIN1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ROLE)
                .addContainerGap(57, Short.MAX_VALUE))
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

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed

        PreparedStatement ps;
        ResultSet rs;
        Connection con;

        String uname = usernameField.getText();
        String password = String.valueOf(passwordField.getText());

        if (uname.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Some fields are empty", "error", 1);
        } else {
            try {
                String sql = ("SELECT * from Login_Tbl WHERE username= ?  and password = ? ");
                con = Database.ConnectDB();
                ps = con.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setString(2, password);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String r = rs.getString("role");
                    ROLE.setText(r);
                    mfa.setVisible(true);
                    mfa.pack();
                    mfa.skl.setText(uname);
                    String mid = rs.getString("user_id");
                    mfa.USER_ID.setText(mid);
                    String username = rs.getString("username");
                    mfa.USERNAME.setText(username);

//                    DataBaseLogs dbl = DataBaseLogs.getInstance();
//                    dbl.userLoggedIn();
//                    String r = rs.getString("options");
//                    y.role.setText(r);

                    changepass cp = changepass.getInstance();
                    String cid = rs.getString("user_id");
                    cp.cp_id.setText(cid);

                    mfa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.dispose();
                    setVisible(false);
//                    DataBaseLogs dbl = DataBaseLogs.getInstance();
//                    dbl.userLoggedIn();
                    if (ROLE.getText().equals("Admin")) {
                        mfa.ADD_USER.setVisible(true);
                    } else if (ROLE.getText().equals("User")) {
                        mfa.ADD_USER.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username and Password", "Login error", 1);
                }

                ps.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("wla");
                Logger.getLogger(Log_in.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }//GEN-LAST:event_LOGINActionPerformed

    private void LOGINMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseExited
        LOGIN.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_LOGINMouseExited

    private void LOGINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseEntered
        LOGIN.setBackground(new Color(0, 238, 0));
    }//GEN-LAST:event_LOGINMouseEntered

    private void LOGIN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGIN1MouseEntered
        LOGIN1.setBackground(new Color(0, 238, 0));
    }//GEN-LAST:event_LOGIN1MouseEntered

    private void LOGIN1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGIN1MouseExited
        LOGIN1.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_LOGIN1MouseExited

    private void LOGIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_LOGIN1ActionPerformed

    private void LOGINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LOGINKeyPressed
        
    }//GEN-LAST:event_LOGINKeyPressed

    private void LOGINKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LOGINKeyReleased
       
    }//GEN-LAST:event_LOGINKeyReleased

    private void LOGINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMousePressed
         LOGIN.setBackground(new Color(0, 205, 0));
    }//GEN-LAST:event_LOGINMousePressed

    private void LOGINMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseReleased
        LOGIN.setBackground(new Color(0, 238, 0));
    }//GEN-LAST:event_LOGINMouseReleased

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
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LOGIN;
    private javax.swing.JButton LOGIN1;
    private javax.swing.JLabel ROLE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
