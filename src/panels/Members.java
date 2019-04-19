package panels;

import DataBase.Database;
import fitnesscampsystem.Add_a_Member;
import fitnesscampsystem.Update_Member;
import java.awt.Color;       
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Members extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    static String setFirstname = "";

    public Members() {
        initComponents();
        con = Database.ConnectDB();
        Table_view();
        ID.setVisible(false);

        MEMBERSTABLE.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        MEMBERSTABLE.getTableHeader().setOpaque(false);
        MEMBERSTABLE.getTableHeader().setBackground(new Color(48, 173, 95));
        MEMBERSTABLE.getTableHeader().setForeground(new Color(255, 250, 250));
        MEMBERSTABLE.setRowHeight(25);
//        pay();
    }
    
    Update_Member jtRowData = new Update_Member();

//    public void pay() {
////        payment p = new payment();
////        p.setVisible(true);
//
//        if (month.getSelectedItem().equals("1 month")) {
////           p.jTextField1.setText("500");
//            yu.setText("500");
//        } else if (month.getSelectedItem().equals("2 months")) {
////           p.jTextField1.setText("1000");
//            yu.setText("1000");
//        } else if (month.getSelectedItem().equals("3 months")) {
////          p.jTextField1.setText("1500");
//            yu.setText("1500");
//        } else if (month.getSelectedItem().equals("4 months")) {
////           p.jTextField1.setText("2000");
//            yu.setText("2000");
//        } else if (month.getSelectedItem().equals("5 months")) {
////           p.jTextField1.setText("2500");
//            yu.setText("2500");
//        } else if (month.getSelectedItem().equals("6 months")) {
////            p.jTextField1.setText("3000");
//            yu.setText("3000");
//        } else if (month.getSelectedItem().equals("1 year")) {
////            p.jTextField1.setText("6000");
//            yu.setText("6000");
//        }
//    }
    public void Table_view() {
        try {

//             select * from table where strftime('%m', created_date) == strftime('%m','now')
            String sql = "select id, Firstname, Lastname,Sex, ContactNumber, Occupation, Address, Hobbies, Contactperson, "
                    + "ContactPersonNo, Relationship, Healthconcern, Currentweight, Targetweight, Month from Members_Tbl";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            MEMBERSTABLE.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            System.out.print(e);
        }
    }
    
//
    
    public void pasadon(){
        int index = MEMBERSTABLE.getSelectedRow();
        TableModel model = MEMBERSTABLE.getModel();
        
        String firstname = model.getValueAt(index, 1).toString();
        String lastname = model.getValueAt(index, 2).toString();
        String sex = model.getValueAt(index, 3).toString();
        String contactnum = model.getValueAt(index, 4).toString();
        String occupation = model.getValueAt(index, 5).toString();
        String address = model.getValueAt(index, 6).toString();
        String hobbies = model.getValueAt(index, 7).toString();        
        String cperson = model.getValueAt(index, 8).toString(); 
        String cpersonnum = model.getValueAt(index, 9).toString(); 
        String relationship = model.getValueAt(index, 10).toString(); 
        String healthconcern = model.getValueAt(index, 11).toString(); 
        String curweight = model.getValueAt(index, 12).toString(); 
        String tarweight = model.getValueAt(index, 13).toString();
        String membership = model.getValueAt(index, 14).toString(); 

        
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.firstnameField.setText(firstname);
        jtRowData.lastnameField.setText(lastname);
        jtRowData.sexComboBox.setSelectedItem(sex);
        jtRowData.contactnumberField.setText(contactnum);
        jtRowData.occupationField.setText(occupation);
        jtRowData.addressField.setText(address);
        jtRowData.hobbiesField.setText(hobbies);
        jtRowData.contactpersonField.setText(cperson);
        jtRowData.contactPersonNumberField.setText(cpersonnum);
        jtRowData.relationshipField.setText(relationship);
        jtRowData.healthconcernField.setText(healthconcern);
        jtRowData.currentweightField.setText(curweight);
        jtRowData.targetweightField.setText(tarweight);
        jtRowData.month.setSelectedItem(membership);

    }



//    public void update_table() {
//
//        try {
//            String sql = "SELECT Firstname, Lastname, Start, End FROM Members_Tbl ";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//
//            pst.close();
//            rs.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//    public  void createdat(){
//        DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
//        Date s = new Date();
//        created_at.setDate(s);
//    }
//    private void computations() {
//        SimpleDateFormat datefmt = new SimpleDateFormat("MM/dd/yyyy");
//        String dates = ((JTextField) start.getDateEditor().getUiComponent()).getText();
//        Date date = start.getDate();
//        Calendar cal = Calendar.getInstance();
////        cal.setTime(date);
//
//        if (month.getSelectedItem().equals("1 month")) {
//            cal.add(Calendar.MONTH, 1); // Add 30 days
//            end.setText("" + datefmt.format(cal.getTime()));
//        } else if (month.getSelectedItem().equals("2 months")) {
//            cal.add(Calendar.MONTH, 2); // Add 30 days
//            end.setText("" + datefmt.format(cal.getTime()));
//        } else if (month.getSelectedItem().equals("3 months")) {
//            cal.add(Calendar.MONTH, 3); // Add 30 day=
//            end.setText("" + datefmt.format(cal.getTime()));
//        } else if (month.getSelectedItem().equals("4 months")) {
//            cal.add(Calendar.MONTH, 4); // Add 30 days
//            end.setText("" + datefmt.format(cal.getTime()));
//        } else if (month.getSelectedItem().equals("5 months")) {
//            cal.add(Calendar.MONTH, 5); // Add 30 days
//            end.setText("" + datefmt.format(cal.getTime()));
//        } else if (month.getSelectedItem().equals("6 months")) {
//            cal.add(Calendar.MONTH, 6); // Add 30 days
//            end.setText("" + datefmt.format(cal.getTime()));
//        } else if (month.getSelectedItem().equals("1 year")) {
//            cal.add(Calendar.MONTH, 12); // Add 30 days
//            end.setText("" + datefmt.format(cal.getTime()));
//        }
//    }
//    public void clear_operation() {
//        firstnameField1.setText("");
//        lastnameField.setText("");
//        occupationField.setText("");
//        addressField.setText("");
//        contactnumberField.setText("");
//        healthconcernField.setText("");
//        hobbiesField.setText("");
//        currentweightField.setText("");
//        targetweightField.setText("");
//        contactpersonField.setText("");
//        month.setSelectedIndex(0);
//        ((JTextField) start.getDateEditor().getUiComponent()).setText("");
//        end.setText("");
//        ((JTextField) created_at.getDateEditor().getUiComponent()).setText("");
//
//    }
// 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MEMBERSTABLE = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, 84, 34));

        UPDATE.setBackground(new java.awt.Color(48, 173, 95));
        UPDATE.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        UPDATE.setForeground(new java.awt.Color(255, 255, 255));
        UPDATE.setText("Update");
        UPDATE.setContentAreaFilled(false);
        UPDATE.setOpaque(true);
        UPDATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UPDATEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UPDATEMouseExited(evt);
            }
        });
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        add(UPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 550, 84, 34));

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 220, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel9.setText("Add a Member ");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));
        add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 540, -1));

        jButton1.setBackground(new java.awt.Color(48, 173, 95));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/15.png"))); // NOI18N
        jButton1.setText("Add Member ");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 150, 40));

        MEMBERSTABLE = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        MEMBERSTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Last Name", "Sex", "Contact No.", "Occupation", "Birthdate", "Start", "End"
            }
        ));
        MEMBERSTABLE.setSelectionBackground(new java.awt.Color(48, 173, 95));
        MEMBERSTABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MEMBERSTABLEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MEMBERSTABLEMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(MEMBERSTABLE);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1010, -1));
        add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 110, -1));

        jLabel1.setBackground(new java.awt.Color(171, 173, 179));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search (1).png"))); // NOI18N
        jLabel1.setOpaque(true);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        final TableRowSorter rowSorter = new TableRowSorter<>(MEMBERSTABLE.getModel());
        //        rowSorter = new TableRowSorter<>(table.getModel());
        MEMBERSTABLE.setRowSorter(rowSorter);
        search.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                String text = search.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            public void removeUpdate(DocumentEvent e) {
                String text = search.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            public void changedUpdate(DocumentEvent e) {
            }
        });
    }//GEN-LAST:event_searchKeyPressed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

    }//GEN-LAST:event_searchKeyReleased

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String sql = "DELETE FROM Members_Tbl WHERE id = ? ";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, ID.getText());
                pst.execute();
                //                JOptionPane.showMessageDialog(null,"Deleted")
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        Table_view();


    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed


//        String sql = "UPDATE Members_Tbl SET Firstname=?,Lastname= ?, Occupation= ?, Address = ?, ContactNumber= ?, Healthconcern= ?,"
//                + "Hobbies = ?, Currentweight= ?, Targetweight= ?, Contactperson= ?, Month= ?, Start= ?, End=? WHERE Firstname=? ";
//        try {
//            con = Database.ConnectDB();
//            PreparedStatement pst = con.prepareStatement(sql);
//            //
//            pst.setString(1, firstnameField1.getText());
//            pst.setString(2, lastnameField.getText());
//            pst.setString(3, occupationField.getText());
//            pst.setString(4, addressField.getText());
//            pst.setString(5, contactnumberField.getText());
//            pst.setString(6, healthconcernField.getText());
//            pst.setString(7, hobbiesField.getText());
//            pst.setString(8, currentweightField.getText());
//            pst.setString(9, targetweightField.getText());
//            pst.setString(10, contactpersonField.getText());
//            pst.setString(11, month.getSelectedItem().toString());
//            pst.setString(12, ((JTextField) start.getDateEditor().getUiComponent()).getText());
//            pst.setString(13, end.getText());
//            pst.setString(14, setFirstname);
//            pst.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "UPDATED!");
//            update_table();
//
//            pst.close();
//            rs.close();
//        } catch (SQLException e) {
//
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_UPDATEActionPerformed

    private void UPDATEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDATEMouseEntered
        UPDATE.setBackground(new Color(56, 176, 222));
    }//GEN-LAST:event_UPDATEMouseEntered

    private void UPDATEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDATEMouseExited
        UPDATE.setBackground(new Color(11, 181, 255));
    }//GEN-LAST:event_UPDATEMouseExited

    private void DELETEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseEntered
        DELETE.setBackground(new Color(212, 26, 31));
    }//GEN-LAST:event_DELETEMouseEntered

    private void DELETEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseExited
        UPDATE.setBackground(new Color(255, 3, 13));
    }//GEN-LAST:event_DELETEMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Add_a_Member add = new Add_a_Member();
        add.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MEMBERSTABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEMBERSTABLEMouseClicked
        
            pasadon();
            
//        int row = MEMBERSTABLE.getSelectedRow();
//        TableModel model = MEMBERSTABLE.getModel();
//        ID.setText(model.getValueAt(row, 0).toString());
    
    }//GEN-LAST:event_MEMBERSTABLEMouseClicked

    private void MEMBERSTABLEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEMBERSTABLEMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_MEMBERSTABLEMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JTextField ID;
    public javax.swing.JTable MEMBERSTABLE;
    private javax.swing.JButton UPDATE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
