package panels;

import DataBase.Database;
import java.awt.Color;
import java.awt.Font;
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

public class ADD_MEMBER extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    static String setFirstname = "";

    public ADD_MEMBER() {
        initComponents();

        con = Database.ConnectDB();
        start.setVisible(false);
        end.setVisible(false);
        update_table();
        
        
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14 ));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(14, 191, 233));
        table.getTableHeader().setForeground(new Color(135, 135, 135));
        table.setRowHeight(25);
        
        
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
        cal.setTime(date);

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

    public void clear_operation() {
        firstnameField1.setText("");
        lastnameField.setText("");
        occupationField.setText("");
        addressField.setText("");
        contactnumberField.setText("");
        healthconcernField.setText("");
        hobbiesField.setText("");
        currentweightField.setText("");
        targetweightField.setText("");
        contactpersonField.setText("");
        month.setSelectedIndex(0);
        ((JTextField)start.getDateEditor().getUiComponent()).setText("");
        end.setText("");

    }
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
        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        SAVE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(250, 250, 250));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstnameField1.setBackground(new java.awt.Color(250, 250, 250));
        firstnameField1.setForeground(new java.awt.Color(46, 46, 46));
        firstnameField1.setBorder(null);
        firstnameField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstnameField1.setOpaque(false);
        firstnameField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstnameField1MouseClicked(evt);
            }
        });
        add(firstnameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 221, 25));

        jLabel1.setText("First Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, 221, 10));

        jLabel2.setText("Last Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        lastnameField.setBackground(new java.awt.Color(250, 250, 250));
        lastnameField.setForeground(new java.awt.Color(46, 46, 46));
        lastnameField.setBorder(null);
        lastnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lastnameField.setOpaque(false);
        add(lastnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 221, 25));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 221, 10));

        jLabel3.setText("Occupation");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        occupationField.setBackground(new java.awt.Color(250, 250, 250));
        occupationField.setForeground(new java.awt.Color(46, 46, 46));
        occupationField.setBorder(null);
        occupationField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        occupationField.setOpaque(false);
        add(occupationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 221, 25));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 221, 10));

        jLabel4.setText("Address");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        addressField.setBackground(new java.awt.Color(250, 250, 250));
        addressField.setForeground(new java.awt.Color(46, 46, 46));
        addressField.setBorder(null);
        addressField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        addressField.setOpaque(false);
        add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 221, 25));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 221, 10));

        jLabel6.setText("Contact Number");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 221, 10));

        contactnumberField.setBackground(new java.awt.Color(250, 250, 250));
        contactnumberField.setForeground(new java.awt.Color(46, 46, 46));
        contactnumberField.setBorder(null);
        contactnumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactnumberField.setOpaque(false);
        add(contactnumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 221, 25));

        jLabel5.setText("Health Concern?");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        healthconcernField.setBackground(new java.awt.Color(250, 250, 250));
        healthconcernField.setForeground(new java.awt.Color(46, 46, 46));
        healthconcernField.setBorder(null);
        healthconcernField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        healthconcernField.setOpaque(false);
        healthconcernField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                healthconcernFieldActionPerformed(evt);
            }
        });
        add(healthconcernField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 221, 25));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 221, 10));

        jLabel7.setText("Hobbies");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, -1, -1));

        hobbiesField.setBackground(new java.awt.Color(250, 250, 250));
        hobbiesField.setForeground(new java.awt.Color(46, 46, 46));
        hobbiesField.setBorder(null);
        hobbiesField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        hobbiesField.setOpaque(false);
        add(hobbiesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 221, 25));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 221, 10));

        jLabel8.setText("Current Weight");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, -1, -1));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 221, 10));

        currentweightField.setBackground(new java.awt.Color(250, 250, 250));
        currentweightField.setForeground(new java.awt.Color(46, 46, 46));
        currentweightField.setBorder(null);
        currentweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        currentweightField.setOpaque(false);
        currentweightField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentweightFieldActionPerformed(evt);
            }
        });
        add(currentweightField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 221, 25));

        jLabel16.setText("Target Weight");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, -1, -1));

        targetweightField.setBackground(new java.awt.Color(250, 250, 250));
        targetweightField.setForeground(new java.awt.Color(46, 46, 46));
        targetweightField.setBorder(null);
        targetweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        targetweightField.setOpaque(false);
        add(targetweightField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 221, 25));
        add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 221, 10));

        contactpersonField.setBackground(new java.awt.Color(250, 250, 250));
        contactpersonField.setForeground(new java.awt.Color(46, 46, 46));
        contactpersonField.setBorder(null);
        contactpersonField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactpersonField.setOpaque(false);
        add(contactpersonField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 221, 25));
        add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 221, 10));

        jLabel20.setText("Membership");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, -1, -1));
        add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 126, 20));

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "1 year" }));
        month.setToolTipText("");
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 220, 28));

        end.setEditable(false);
        add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 126, 20));

        DELETE.setBackground(new java.awt.Color(255, 102, 102));
        DELETE.setText("Delete");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 84, 36));

        UPDATE.setBackground(new java.awt.Color(204, 255, 255));
        UPDATE.setText("Update");
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        add(UPDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, 84, 34));

        CLEAR.setBackground(new java.awt.Color(204, 255, 255));
        CLEAR.setText("Clear");
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });
        add(CLEAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 84, 34));

        SAVE.setBackground(new java.awt.Color(204, 255, 204));
        SAVE.setText("Save");
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });
        add(SAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 84, 34));

        table = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
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
        table.setGridColor(new java.awt.Color(153, 51, 0));
        table.setMinimumSize(new java.awt.Dimension(80, 0));
        table.setSelectionBackground(new java.awt.Color(0, 204, 102));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 531, 433));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 220, 26));

        jLabel21.setText("Contact Person");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel9.setText("Add a Member ");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));
        add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 540, -1));
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

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
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
    }//GEN-LAST:event_DELETEActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
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
    }//GEN-LAST:event_UPDATEActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        clear_operation();
    }//GEN-LAST:event_CLEARActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        computations();
    }//GEN-LAST:event_monthActionPerformed

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
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
    }//GEN-LAST:event_SAVEActionPerformed

    private void firstnameField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstnameField1MouseClicked
        DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
        Date date = new Date();
        start.setDate(date);
    }//GEN-LAST:event_firstnameField1MouseClicked

    private void healthconcernFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_healthconcernFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_healthconcernFieldActionPerformed

    private void currentweightFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentweightFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentweightFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton SAVE;
    private javax.swing.JButton UPDATE;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField contactnumberField;
    private javax.swing.JTextField contactpersonField;
    private javax.swing.JTextField currentweightField;
    public javax.swing.JTextField end;
    private javax.swing.JTextField firstnameField1;
    private javax.swing.JTextField healthconcernField;
    private javax.swing.JTextField hobbiesField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
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
    private javax.swing.JTable table;
    private javax.swing.JTextField targetweightField;
    // End of variables declaration//GEN-END:variables
}
