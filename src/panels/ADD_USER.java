package panels;

import DataBase.DataBaseLogs;
import DataBase.Database;
import fitnesscampsystem.Add_a_User;
import fitnesscampsystem.Main_Frame_Admin;
import fitnesscampsystem.userLogs;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class ADD_USER extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    
    private static ADD_USER instance = null;

    public static ADD_USER getInstance() {
        if (instance == null) {
            instance = new ADD_USER();
        }
        return instance;
    }
    

    public ADD_USER() {
        initComponents();
        con = Database.ConnectDB();

        USERS.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        USERS.getTableHeader().setOpaque(false);
        USERS.getTableHeader().setBackground(new Color(48, 173, 95));
        USERS.getTableHeader().setForeground(new Color(255, 250, 250));
        USERS.setRowHeight(25);
        USERS.getTableHeader().setReorderingAllowed(false);
        Table_View();
    }

    public void Table_View() {

        try {
            String sql = "SELECT user_id, username, firstname, lastname, role FROM Login_Tbl ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            USERS.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void clear() {
        id.setText("");
        uname.setText("");
        fname.setText("");
        lname.setText("");
        role.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        USERS = new javax.swing.JTable();
        ADDUSER = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        asdsad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        LOGS = new javax.swing.JButton();
        updateuser = new javax.swing.JLabel();
        deleteuser = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 26)); // NOI18N
        jLabel1.setText("New User Account");

        USERS = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        USERS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        USERS.setOpaque(false);
        USERS.setSelectionBackground(new java.awt.Color(51, 210, 102));
        USERS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                USERSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(USERS);

        ADDUSER.setBackground(new java.awt.Color(48, 173, 95));
        ADDUSER.setForeground(new java.awt.Color(255, 255, 255));
        ADDUSER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/15.png"))); // NOI18N
        ADDUSER.setText("Add User Account");
        ADDUSER.setContentAreaFilled(false);
        ADDUSER.setOpaque(true);
        ADDUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDUSERActionPerformed(evt);
            }
        });

        UPDATE.setBackground(new java.awt.Color(48, 173, 95));
        UPDATE.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        UPDATE.setForeground(new java.awt.Color(255, 255, 255));
        UPDATE.setText("Update");
        UPDATE.setContentAreaFilled(false);
        UPDATE.setOpaque(true);
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        UPDATE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UPDATEKeyReleased(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(255, 3, 13));
        DELETE.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        DELETE.setForeground(new java.awt.Color(255, 255, 255));
        DELETE.setText("Delete");
        DELETE.setContentAreaFilled(false);
        DELETE.setOpaque(true);
        DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DELETEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DELETEMouseExited(evt);
            }
        });
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        id.setText("jLabel2");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Username");

        asdsad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        asdsad.setText("Firstname");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Lastname");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Role");

        jLabel2.setText("User No.");

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        LOGS.setBackground(new java.awt.Color(48, 173, 95));
        LOGS.setForeground(new java.awt.Color(255, 255, 255));
        LOGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/15.png"))); // NOI18N
        LOGS.setText("User Logs");
        LOGS.setContentAreaFilled(false);
        LOGS.setOpaque(true);
        LOGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGSActionPerformed(evt);
            }
        });

        updateuser.setText("Updated a User");

        deleteuser.setText("Deleted a User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(286, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ADDUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LOGS, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218)
                                .addComponent(deleteuser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateuser)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lname, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(asdsad)
                                                .addGap(42, 42, 42)
                                                .addComponent(fname))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel2))
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(id)
                                                    .addComponent(uname, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(ADDUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(LOGS, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(updateuser)
                                    .addComponent(deleteuser)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asdsad)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ADDUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDUSERActionPerformed
        Main_Frame_Admin mf = Main_Frame_Admin.getInstance();
        mf.setEnabled(false);
        Add_a_User a = Add_a_User.getInstance();
        a.setVisible(true);
    }//GEN-LAST:event_ADDUSERActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        
        
            Database db = Database.getInstance();
            db.updateAccount(
                    
            uname.getText(),
            fname.getText(),
            lname.getText(),
            role.getSelectedItem().toString(),
            id.getText()  
            );
             Table_View();
             
            DataBaseLogs dbl = DataBaseLogs.getInstance();
            dbl.updateUserlog();
             

    }//GEN-LAST:event_UPDATEActionPerformed

    private void DELETEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseEntered
        DELETE.setBackground(new Color(212, 26, 31));
    }//GEN-LAST:event_DELETEMouseEntered

    private void DELETEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseExited
        UPDATE.setBackground(new Color(255, 3, 13));
    }//GEN-LAST:event_DELETEMouseExited

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String sql = "DELETE FROM Login_Tbl WHERE user_id = ? ";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, id.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                pst.close();
                rs.close();
//                clear();
                Table_View();
                DataBaseLogs dbl = DataBaseLogs.getInstance();
                dbl.deleteUserlog();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //        Table_view();

    }//GEN-LAST:event_DELETEActionPerformed

    private void USERSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_USERSMouseClicked
        int index = USERS.getSelectedRow();
        TableModel model = USERS.getModel();

        String uid = model.getValueAt(index, 0).toString();
        String username = model.getValueAt(index, 1).toString();
        String firstname = model.getValueAt(index, 2).toString();
        String lastname = model.getValueAt(index, 3).toString();
        String rol = model.getValueAt(index, 4).toString();

        id.setText(uid);
        uname.setText(username);
        fname.setText(firstname);
        lname.setText(lastname);
        role.setSelectedItem(rol);
    }//GEN-LAST:event_USERSMouseClicked

    private void UPDATEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UPDATEKeyReleased
       if (JOptionPane.showConfirmDialog(null, "Save?", "WARNING",
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                   System.exit(0);
           } else {
           }
    }//GEN-LAST:event_UPDATEKeyReleased

    private void LOGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGSActionPerformed
        userLogs ul = userLogs.getInstance();
        ul.setVisible(true);
        
        
    }//GEN-LAST:event_LOGSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDUSER;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton LOGS;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTable USERS;
    private javax.swing.JLabel asdsad;
    public javax.swing.JLabel deleteuser;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lname;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JTextField uname;
    public javax.swing.JLabel updateuser;
    // End of variables declaration//GEN-END:variables

}
