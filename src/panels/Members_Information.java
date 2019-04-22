package panels;

import DataBase.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Members_Information extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    static String setFirstname = "";

    public Members_Information() {
        initComponents();
        con = Database.ConnectDB();
        update_table();
    }

    private void update_table() {

        try {
            String sql = "SELECT mfirstName, mlastName, Occupation, address, ContactNumber, Healthconcern, Hobbies,"
                    + " Currentweight, Targetweight, Contactperson, Start, End FROM Members_Tbl ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            Information_Table.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
//            System.out.println("");
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void populate_table() {

        DefaultTableModel model = (DefaultTableModel) Information_Table.getModel();
        int row = Information_Table.getSelectedRow();

        String tc = Information_Table.getModel().getValueAt(row, 0).toString();

        try {
            String sql = "SELECT * FROM Members_Tbl WHERE mfirstName = '" + tc + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("mfirstName");
                Dp_name.setText(name);
                String lastname = rs.getString("mlastName");
                Dp_lastname.setText(lastname);
                String occupation = rs.getString("Occupation");
                Dp_Occupation.setText(occupation);
                String address = rs.getString("address");
                Dp_address.setText(address);
                String contactnumber = rs.getString("ContactNumber");
                Dp_contactno.setText(contactnumber);
                String healthconcern = rs.getString("Healthconcern");
                Dp_healthconcern.setText(healthconcern);
                String hobbies = rs.getString("Hobbies");
                Dp_hobbies.setText(hobbies);
                String currentweight = rs.getString("Currentweight");
                Dp_currentweight.setText(currentweight);
                String targetweight = rs.getString("Targetweight");
                Dp_targetweight.setText(targetweight);
                String contactperson = rs.getString("Contactperson");
                Dp_contactperson.setText(contactperson);
                String start = rs.getString("Start");
                Dp_start.setText(start);
                String end = rs.getString("End");
                Dp_end.setText(end);

//                String gen = rs.getString("Gender");
//                gender.setSelectedItem(gen);
//                String number = rs.getString("ContactNo");
//                contact.setText(number);
//                String mail = rs.getString("Email");
//                email.setText(mail);
//                String mem = rs.getString("Membership");
//                membership.setSelectedItem(mem);
//                String date = rs.getString("Date");
//                ((JTextField) date_ch.getDateEditor().getUiComponent()).setText(date);
//                String ex = rs.getString("Expiration");
//                Expiration.setText(ex);
//                String mo = rs.getString("Month");
//                xmonth.setSelectedItem(mo);
//                setFirstname = rs.getString("FirstName");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
        update_table();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dp_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Dp_lastname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Dp_Occupation = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Dp_address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Dp_contactno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Dp_healthconcern = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Dp_hobbies = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Dp_currentweight = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Dp_targetweight = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Dp_contactperson = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Dp_start = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Dp_end = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Information_Table = new javax.swing.JTable();
        UPDATE_BTN = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(92, 92, 92));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1105, 542));

        jLabel1.setText("First Name");

        jLabel2.setText("Last Name");

        jLabel3.setText("Occupation");

        jLabel4.setText("Address");

        jLabel5.setText("Contact No.");

        jLabel6.setText("Health Concern");

        jLabel7.setText("Hobbies");

        jLabel8.setText("Current Weight");

        jLabel9.setText("Target Weight");

        jLabel10.setText("Contact Person");

        jLabel11.setText("Start");

        jLabel12.setText("End");

        Information_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Occupation", "Address", "Contact No.", "Health Concern", "Hobbies", "Current Weight", "Target Weight", "Contact Person", "Start", "End"
            }
        ));
        Information_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Information_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Information_Table);

        UPDATE_BTN.setText("UPDATE");
        UPDATE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_BTNActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Dp_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Dp_Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Dp_address, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(Dp_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(Dp_healthconcern, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54)
                        .addComponent(Dp_hobbies, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(Dp_currentweight, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(UPDATE_BTN)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(23, 23, 23)
                        .addComponent(Dp_targetweight, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(Dp_contactperson, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(68, 68, 68)
                        .addComponent(Dp_start, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(74, 74, 74)
                        .addComponent(Dp_end, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Dp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(Dp_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(Dp_Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(Dp_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(Dp_contactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(Dp_healthconcern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(Dp_hobbies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(Dp_currentweight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(UPDATE_BTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton2)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(Dp_targetweight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(Dp_contactperson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11))
                    .addComponent(Dp_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12))
                    .addComponent(Dp_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Information_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Information_TableMouseClicked
        populate_table();
    }//GEN-LAST:event_Information_TableMouseClicked

    private void UPDATE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_BTNActionPerformed

        String sql = "UPDATE Members_Tbl SET mfirstName= ?,mlastName = ?, Occupation = ?, address = ?, ContactNumber = ?, Healthconcern = ?,"
                + "Hobbies = ?, Currentweight = ?, Targetweight = ?, Contactperson = ?, Start = ?, End = ? WHERE mfirstName=? ";
        try {
            con = Database.ConnectDB();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, Dp_name.getText());
            pst.setString(2, Dp_lastname.getText());
            pst.setString(3, Dp_Occupation.getText());
            pst.setString(4, Dp_address.getText());
            pst.setString(5, Dp_contactno.getText());
            pst.setString(6, Dp_healthconcern.getText());
            pst.setString(7, Dp_hobbies.getText());
            pst.setString(8, Dp_currentweight.getText());
            pst.setString(9, Dp_targetweight.getText());
            pst.setString(10, Dp_contactperson.getText());
            pst.setString(11, Dp_start.getText());
            pst.setString(12, Dp_end.getText());
            pst.setString(13, setFirstname);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "UPDATED!");
            update_table();

            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Cant update");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_UPDATE_BTNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String sql = "DELETE FROM Members_Tbl WHERE Firstname = ? ";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, Dp_name.getText());
                pst.execute();
                //                JOptionPane.showMessageDialog(null,"Deleted")

                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        update_table();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Dp_Occupation;
    private javax.swing.JTextField Dp_address;
    private javax.swing.JTextField Dp_contactno;
    private javax.swing.JTextField Dp_contactperson;
    private javax.swing.JTextField Dp_currentweight;
    private javax.swing.JTextField Dp_end;
    private javax.swing.JTextField Dp_healthconcern;
    private javax.swing.JTextField Dp_hobbies;
    private javax.swing.JTextField Dp_lastname;
    private javax.swing.JTextField Dp_name;
    private javax.swing.JTextField Dp_start;
    private javax.swing.JTextField Dp_targetweight;
    private javax.swing.JTable Information_Table;
    private javax.swing.JButton UPDATE_BTN;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
