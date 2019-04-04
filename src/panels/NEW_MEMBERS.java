package panels;

import DataBase.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class NEW_MEMBERS extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    static String setFirstname = "";

    public NEW_MEMBERS() {
        initComponents();

        con = Database.ConnectDB();
    }

    private void update_table() {

        try {
            String sql = "SELECT FirstName, LastName, Start, End FROM Members_Tbl ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    

    private void computations() {
        SimpleDateFormat datefmt = new SimpleDateFormat("MM/dd/yyyy");
        String dates = ((JTextField) start.getDateEditor().getUiComponent()).getText();
        Date date = start.getDate();
        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);

        if (month.getSelectedItem().equals("1 month")) {
            cal.add(Calendar.MONTH, 1); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
            cal.add(Calendar.MONTH, 2); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("3 months")) {
            cal.add(Calendar.MONTH, 3); // Add 30 day=
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("4 months")) {
            cal.add(Calendar.MONTH, 4); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("5 months")) {
            cal.add(Calendar.MONTH, 5); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("6 months")) {
            cal.add(Calendar.MONTH, 6); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("1 year")) {
            cal.add(Calendar.MONTH, 12); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        }
    }

//    public void clear_operation() {
//        fname.setText("");
//        mname.setText("");
//        lname.setText("");
//        age.setText("");
//        gender.setSelectedIndex(0);
//        contact.setText("");
//        email.setText("");
//        membership.setSelectedIndex(0);
//        date_ch.setCalendar(null);
////        ((JTextField)date_ch.getDateEditor().getUiComponent()).setText("");
//        Expiration.setText("");
//        xmonth.setSelectedIndex(0);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstnameField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lastnameField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        occupationField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        contactnumberField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        healthconcernField = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        hobbiesField = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        currentweightField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        targetweightField = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        contactpersonField = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        start = new com.toedter.calendar.JDateChooser();
        month = new javax.swing.JComboBox();
        end = new javax.swing.JTextField();
        Delete_btn = new javax.swing.JButton();
        UPDATE_BUTTON = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        superadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstnameField1.setBackground(new java.awt.Color(252, 252, 252));
        firstnameField1.setForeground(new java.awt.Color(46, 46, 46));
        firstnameField1.setBorder(null);
        firstnameField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstnameField1.setOpaque(false);
        firstnameField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstnameField1MouseClicked(evt);
            }
        });
        add(firstnameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 53, 221, 25));

        jLabel1.setText("First Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 64, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 78, 221, 10));

        jLabel2.setText("Last Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 105, -1, -1));

        lastnameField.setBackground(new java.awt.Color(252, 252, 252));
        lastnameField.setForeground(new java.awt.Color(46, 46, 46));
        lastnameField.setBorder(null);
        lastnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lastnameField.setOpaque(false);
        add(lastnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 94, 221, 25));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 119, 221, 10));

        jLabel3.setText("Occupation");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 146, -1, -1));

        occupationField.setBackground(new java.awt.Color(252, 252, 252));
        occupationField.setForeground(new java.awt.Color(46, 46, 46));
        occupationField.setBorder(null);
        occupationField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        occupationField.setOpaque(false);
        add(occupationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 135, 221, 25));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 160, 221, 10));

        jLabel4.setText("Address");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 187, -1, -1));

        addressField.setBackground(new java.awt.Color(252, 252, 252));
        addressField.setForeground(new java.awt.Color(46, 46, 46));
        addressField.setBorder(null);
        addressField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        addressField.setOpaque(false);
        add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 176, 221, 25));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 201, 221, 10));

        jLabel6.setText("Contact Number");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 228, -1, -1));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 242, 221, 10));

        contactnumberField.setBackground(new java.awt.Color(252, 252, 252));
        contactnumberField.setForeground(new java.awt.Color(46, 46, 46));
        contactnumberField.setBorder(null);
        contactnumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactnumberField.setOpaque(false);
        add(contactnumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 217, 221, 25));

        jLabel5.setText("Health Concern?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 269, -1, -1));

        healthconcernField.setBackground(new java.awt.Color(252, 252, 252));
        healthconcernField.setForeground(new java.awt.Color(46, 46, 46));
        healthconcernField.setBorder(null);
        healthconcernField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        healthconcernField.setOpaque(false);
        add(healthconcernField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 258, 221, 25));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 283, 221, 10));

        jLabel7.setText("Hobbies");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 310, -1, -1));

        hobbiesField.setBackground(new java.awt.Color(252, 252, 252));
        hobbiesField.setForeground(new java.awt.Color(46, 46, 46));
        hobbiesField.setBorder(null);
        hobbiesField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        hobbiesField.setOpaque(false);
        add(hobbiesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 299, 221, 25));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 324, 221, 10));

        jLabel8.setText("Current Weight");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 351, -1, -1));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 365, 221, 10));

        currentweightField.setBackground(new java.awt.Color(252, 252, 252));
        currentweightField.setForeground(new java.awt.Color(46, 46, 46));
        currentweightField.setBorder(null);
        currentweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        currentweightField.setOpaque(false);
        add(currentweightField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 340, 221, 25));

        jLabel16.setText("Target Weight");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 392, -1, -1));

        targetweightField.setBackground(new java.awt.Color(252, 252, 252));
        targetweightField.setForeground(new java.awt.Color(46, 46, 46));
        targetweightField.setBorder(null);
        targetweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        targetweightField.setOpaque(false);
        add(targetweightField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 381, 221, 25));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 406, 221, 10));

        contactpersonField.setBackground(new java.awt.Color(252, 252, 252));
        contactpersonField.setForeground(new java.awt.Color(46, 46, 46));
        contactpersonField.setBorder(null);
        contactpersonField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactpersonField.setOpaque(false);
        add(contactpersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 422, 221, 25));
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 447, 221, 10));

        jLabel20.setText("Contact Person");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 433, -1, -1));
        add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 126, 28));

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "1 year" }));
        month.setToolTipText("");
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 126, 28));

        end.setEditable(false);
        add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 126, 28));

        Delete_btn.setBackground(new java.awt.Color(255, 102, 102));
        Delete_btn.setText("Delete");
        Delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_btnActionPerformed(evt);
            }
        });
        add(Delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 418, 84, 36));

        UPDATE_BUTTON.setBackground(new java.awt.Color(204, 255, 255));
        UPDATE_BUTTON.setText("Update");
        UPDATE_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_BUTTONActionPerformed(evt);
            }
        });
        add(UPDATE_BUTTON, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 373, 84, 34));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 328, 84, 34));

        superadd.setBackground(new java.awt.Color(204, 255, 204));
        superadd.setText("Save");
        superadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superaddActionPerformed(evt);
            }
        });
        add(superadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(926, 283, 84, 34));

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FirstName", "LastName", "Date", "end"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        });
        table.setMinimumSize(new java.awt.Dimension(80, 0));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 53, 531, 433));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 16, 141, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();

        String tc = table.getModel().getValueAt(row, 0).toString();

        try {
            String sql = "SELECT * FROM Members_Tbl WHERE Firstname = '" + tc + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Firstname");
                firstnameField1.setText(name);
                String lastname = rs.getString("Lastname");
                lastnameField.setText(lastname);
                String occupation = rs.getString("Occupation");
                occupationField.setText(occupation);
                String address = rs.getString("Address");
                addressField.setText(address);
                String contactnumber = rs.getString("ContactNumber");
                contactnumberField.setText(contactnumber);
                String healthconcern = rs.getString("Healthconcern");
                healthconcernField.setText(healthconcern);
                String hobbies = rs.getString("Hobbies");
                hobbiesField.setText(hobbies);
                String currentweight = rs.getString("Currentweight");
                currentweightField.setText(currentweight);
                String targetweight = rs.getString("Targetweight");
                targetweightField.setText(targetweight);
                String contactperson = rs.getString("Contactperson");
                contactpersonField.setText(contactperson);
                String mo = rs.getString("Month");
                month.setSelectedItem(mo);
                String date = rs.getString("Start");
                ((JTextField) start.getDateEditor().getUiComponent()).setText(date);
                String ex = rs.getString("End");
                end.setText(ex);

                setFirstname = rs.getString("FirstName");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
        update_table();
    }//GEN-LAST:event_tableMouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        final TableRowSorter rowSorter = new TableRowSorter<>(table.getModel());
        //        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
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

    private void Delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_btnActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String sql = "DELETE FROM Members_Tbl WHERE Firstname = ? ";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, firstnameField1.getText());
                pst.execute();
                //                JOptionPane.showMessageDialog(null,"Deleted")

                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        update_table();
    }//GEN-LAST:event_Delete_btnActionPerformed

    private void UPDATE_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_BUTTONActionPerformed
        String sql = "UPDATE Members_Tbl SET Firstname=?,Lastname= ?, Occupation= ?, Address = ?, ContactNumber= ?, Healthconcern= ?,"
                + "Hobbies = ?, Currentweight= ?, Targetweight= ?, Contactperson= ?, Month= ?, Start= ?, End=? WHERE Firstname=? ";
        try {
            con = Database.ConnectDB();
            PreparedStatement pst = con.prepareStatement(sql);
            //
            pst.setString(1, firstnameField1.getText());
            pst.setString(2, lastnameField.getText());
            pst.setString(3, occupationField.getText());
            pst.setString(4, addressField.getText());
            pst.setString(5, contactnumberField.getText());
            pst.setString(6, healthconcernField.getText());
            pst.setString(7, hobbiesField.getText());
            pst.setString(8, currentweightField.getText());
            pst.setString(9, targetweightField.getText());
            pst.setString(10, contactpersonField.getText());
            pst.setString(11, month.getSelectedItem().toString());
            pst.setString(12, ((JTextField) start.getDateEditor().getUiComponent()).getText());
            pst.setString(13, end.getText());
            pst.setString(14, setFirstname);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "UPDATED!");
            update_table();

            pst.close();
            rs.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_UPDATE_BUTTONActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        clear_operation();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        computations();
    }//GEN-LAST:event_monthActionPerformed

    private void superaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superaddActionPerformed
        if ((firstnameField1.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (lastnameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (occupationField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (addressField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contactnumberField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (healthconcernField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contactpersonField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String sql = "INSERT INTO Members_Tbl(Firstname,Lastname,Occupation,Address,ContactNumber,Healthconcern,"
                        + "Hobbies,Currentweight,Targetweight,Contactperson,Month,Start,End)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

                pst = con.prepareStatement(sql);
                pst.setString(1, firstnameField1.getText());
                pst.setString(2, lastnameField.getText());
                pst.setString(3, occupationField.getText());
                pst.setString(4, addressField.getText());
                pst.setString(5, contactnumberField.getText());
                pst.setString(6, healthconcernField.getText());
                pst.setString(7, hobbiesField.getText());
                pst.setString(8, currentweightField.getText());
                pst.setString(9, targetweightField.getText());
                pst.setString(10, contactpersonField.getText());

                String hv = month.getSelectedItem().toString();
                pst.setString(11, hv);

                String dt = ((JTextField) start.getDateEditor().getUiComponent()).getText();
                pst.setString(12, dt);
                pst.setString(13, end.getText());

                pst.execute();

                JOptionPane.showMessageDialog(null, "saved");
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        update_table();
    }//GEN-LAST:event_superaddActionPerformed

    private void firstnameField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstnameField1MouseClicked
//        DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
//        Date date = new Date();
//        start.setDate(date);
    }//GEN-LAST:event_firstnameField1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete_btn;
    private javax.swing.JButton UPDATE_BUTTON;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField contactnumberField;
    private javax.swing.JTextField contactpersonField;
    private javax.swing.JTextField currentweightField;
    public javax.swing.JTextField end;
    private javax.swing.JTextField firstnameField1;
    private javax.swing.JTextField healthconcernField;
    private javax.swing.JTextField hobbiesField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField lastnameField;
    private javax.swing.JComboBox month;
    private javax.swing.JTextField occupationField;
    private javax.swing.JTextField search;
    private com.toedter.calendar.JDateChooser start;
    private javax.swing.JButton superadd;
    private javax.swing.JTable table;
    private javax.swing.JTextField targetweightField;
    // End of variables declaration//GEN-END:variables
}
