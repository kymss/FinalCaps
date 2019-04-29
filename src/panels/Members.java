package panels;

import DataBase.DataBaseLogs;
import DataBase.Database;
import fitnesscampsystem.Add_a_Member;
import fitnesscampsystem.Main_Frame_Admin;
import fitnesscampsystem.Update_Member;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Members extends javax.swing.JPanel {

    JLabel FNAME, MNAME, LNAME, GENDER, CONTACTNUMBER, OCCUPATION, ADDRESS, HOBBIES, CONTACTPERSON, CONTACTPERSONNO, RELATIONSHIP;
    JLabel HEALTHCONCERN, CURRENTWEIGHT, TARGETWEIGHT, MEMBERSHIP, START, END, CREATED_AT, PAYMENT;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel MODEL; 
//    static String setFirstname = "";
    private static Members instance = null;

    public static Members getInstance() {
        if (instance == null) {
            instance = new Members();
        }
        return instance;
    }

    public Members() {
        initComponents();
        MID.setVisible(false);
        con = Database.ConnectDB();
        
        ID.setVisible(false);
        MODEL = new DefaultTableModel();
        MEMBERSTABLE.setModel(MODEL);
        MEMBERSTABLE.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        MEMBERSTABLE.getTableHeader().setOpaque(false);
        MEMBERSTABLE.getTableHeader().setBackground(new Color(48, 173, 95));
        MEMBERSTABLE.getTableHeader().setForeground(new Color(255, 250, 250));
        MEMBERSTABLE.setRowHeight(25);
        MEMBERSTABLE.getTableHeader().setReorderingAllowed(false);
//        displayEmployeeList(MODEL);
        
        Table_view();
//        MID = new JLabel();
//        MID.setBounds(0,0,0,0);
        FNAME = new JLabel();
        FNAME.setBounds(0, 0, 0, 0);

        MNAME = new JLabel();
        MNAME.setBounds(0, 0, 0, 0);

        LNAME = new JLabel();
        LNAME.setBounds(0, 0, 0, 0);

        GENDER = new JLabel();
        GENDER.setBounds(0, 0, 0, 0);

        CONTACTNUMBER = new JLabel();
        CONTACTNUMBER.setBounds(0, 0, 0, 0);

        OCCUPATION = new JLabel();
        OCCUPATION.setBounds(0, 0, 0, 0);

        ADDRESS = new JLabel();
        ADDRESS.setBounds(0, 0, 0, 0);

        HOBBIES = new JLabel();
        HOBBIES.setBounds(0, 0, 0, 0);

        CONTACTPERSON = new JLabel();
        CONTACTPERSON.setBounds(0, 0, 0, 0);

        CONTACTPERSONNO = new JLabel();
        CONTACTPERSONNO.setBounds(0, 0, 0, 0);

        RELATIONSHIP = new JLabel();
        RELATIONSHIP.setBounds(0, 0, 0, 0);

        HEALTHCONCERN = new JLabel();
        HEALTHCONCERN.setBounds(0, 0, 0, 0);

        CURRENTWEIGHT = new JLabel();
        CURRENTWEIGHT.setBounds(0, 0, 0, 0);

        TARGETWEIGHT = new JLabel();
        TARGETWEIGHT.setBounds(0, 0, 0, 0);

        MEMBERSHIP = new JLabel();
        MEMBERSHIP.setBounds(0, 0, 0, 0);

        START = new JLabel();
        START.setBounds(0, 0, 0, 0);

        END = new JLabel();
        END.setBounds(0, 0, 0, 0);

        CREATED_AT = new JLabel();
        CREATED_AT.setBounds(0, 0, 0, 0);

        PAYMENT = new JLabel();
        PAYMENT.setBounds(0, 0, 0, 0);
    }

    Update_Member jtRowData = new Update_Member();

    
    public void Table_view() {
        try {
            String sql = "SELECT mfirstName, mmiddleName, mlastName, gender, ContactNumber, Occupation  from Members_Tbl";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
//         
            MEMBERSTABLE.setModel(DbUtils.resultSetToTableModel(rs));   
            
            pst.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populate_label() {
        DefaultTableModel model = (DefaultTableModel) MEMBERSTABLE.getModel();
        int row = MEMBERSTABLE.getSelectedRow();

        String tc = MEMBERSTABLE.getModel().getValueAt(row, 0).toString();

        try {
            String sql = "SELECT * FROM Members_Tbl WHERE members_id = '" + tc + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String mid = rs.getString("members_id");
                MID.setText(mid);
                String fname = rs.getString("mfirstName");
                FNAME.setText(fname);
                String mname = rs.getString("mmiddleName");
                MNAME.setText(mname);
                String lname = rs.getString("mlastName");
                LNAME.setText(lname);
                String gender = rs.getString("gender");
                GENDER.setText(gender);
                String cnumber = rs.getString("ContactNumber");
                CONTACTNUMBER.setText(cnumber);
                String occupation = rs.getString("Occupation");
                OCCUPATION.setText(occupation);
                String address = rs.getString("Address");
                ADDRESS.setText(address);
                String hobby = rs.getString("Hobbies");
                HOBBIES.setText(hobby);
                String cperson = rs.getString("Contactperson");
                CONTACTPERSON.setText(cperson);
                String cpersonnum = rs.getString("ContactPersonNo");
                CONTACTPERSONNO.setText(cpersonnum);
                String rel = rs.getString("Relationship");
                RELATIONSHIP.setText(rel);
                String hc = rs.getString("Healthconcern");
                HEALTHCONCERN.setText(hc);
                String cw = rs.getString("Currentweight");
                CURRENTWEIGHT.setText(cw);
                String tw = rs.getString("Targetweight");
                TARGETWEIGHT.setText(tw);
                String m = rs.getString("Membership");
                MEMBERSHIP.setText(m);
                String ms = rs.getString("Start");
                START.setText(ms);
                String msE = rs.getString("End");
                END.setText(msE);
                String create = rs.getString("Created_at");
                CREATED_AT.setText(create);
                String PAY = rs.getString("Payment");
                PAYMENT.setText(PAY);

            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DELETE = new javax.swing.JButton();
        UPDATE = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        ADDMEMBERS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MEMBERSTABLE = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        MID = new javax.swing.JLabel();
        deleteMem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel9.setText("Add a Member ");

        ADDMEMBERS.setBackground(new java.awt.Color(48, 173, 95));
        ADDMEMBERS.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ADDMEMBERS.setForeground(new java.awt.Color(255, 255, 255));
        ADDMEMBERS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/15.png"))); // NOI18N
        ADDMEMBERS.setText("Add Member ");
        ADDMEMBERS.setContentAreaFilled(false);
        ADDMEMBERS.setOpaque(true);
        ADDMEMBERS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDMEMBERSActionPerformed(evt);
            }
        });

        MEMBERSTABLE = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        MEMBERSTABLE.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        MEMBERSTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MEMBERSTABLE.setGridColor(new java.awt.Color(255, 255, 255));
        MEMBERSTABLE.setSelectionBackground(new java.awt.Color(51, 210, 102));
        MEMBERSTABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MEMBERSTABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MEMBERSTABLE);

        jLabel1.setBackground(new java.awt.Color(171, 173, 179));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search (1).png"))); // NOI18N
        jLabel1.setOpaque(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refreshing (1).png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        MID.setText("jLabel2");

        deleteMem.setText("Deleted a Member");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(730, 730, 730)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(MID))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ADDMEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(deleteMem)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ADDMEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(deleteMem)
                .addGap(42, 42, 42))
        );
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

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed

        int row = MEMBERSTABLE.getSelectedRow();
        if (row >= 0) {
            int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
            if (opt == 0) {
                String id = MEMBERSTABLE.getModel().getValueAt(row, 0).toString();
                Database db = Database.getInstance();
                db.deleteMember(id);
//                Table_view();

                DataBaseLogs dbl = DataBaseLogs.getInstance();
                dbl.deleteMember();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a Member first!");
        }

    }//GEN-LAST:event_DELETEActionPerformed


    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        Update_Member uw = Update_Member.getInstance();
        uw.setVisible(true);
//
        uw.setText(
                MID.getText(),
                FNAME.getText(),
                MNAME.getText(),
                LNAME.getText(),
                GENDER.getText(),
                CONTACTNUMBER.getText(),
                OCCUPATION.getText(),
                ADDRESS.getText(),
                HOBBIES.getText(),
                CONTACTPERSON.getText(),
                CONTACTPERSONNO.getText(),
                RELATIONSHIP.getText(),
                HEALTHCONCERN.getText(),
                CURRENTWEIGHT.getText(),
                TARGETWEIGHT.getText(),
                MEMBERSHIP.getText()
        //                        START.getText(),
        //                        END.getText(),
        //                        CREATED_AT.getText(),
        //                        PAYMENT.getText()
        );
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

    private void ADDMEMBERSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDMEMBERSActionPerformed
        Main_Frame_Admin o = Main_Frame_Admin.getInstance();
        o.setEnabled(false);
//        this.setEnabled(false);
        Add_a_Member add = Add_a_Member.getInstance();
//        this.setEnabled(false);
//        add.show();
        add.setVisible(true);
//        Table_view();


    }//GEN-LAST:event_ADDMEMBERSActionPerformed

    private void MEMBERSTABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEMBERSTABLEMouseClicked
//
        populate_label();

    }//GEN-LAST:event_MEMBERSTABLEMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        Table_view();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDMEMBERS;
    private javax.swing.JButton DELETE;
    public javax.swing.JTextField ID;
    public javax.swing.JTable MEMBERSTABLE;
    private javax.swing.JLabel MID;
    private javax.swing.JButton UPDATE;
    public javax.swing.JLabel deleteMem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
