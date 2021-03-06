package panels;

import DataBase.DataBaseLogs;
import DataBase.Database;
import fitnesscampsystem.Main_Frame_Admin;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class DASHBOARD extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel MODEL;

    private static DASHBOARD instance = null;

    public static DASHBOARD getInstance() {
        if (instance == null) {
            instance = new DASHBOARD();
        }
        return instance;
    }

    public DASHBOARD() {
        initComponents();
        con = Database.ConnectDB();

        all_expired();

//
//        END.setVisible(false);
//        START.setVisible(false);
//        ID.setVisible(false);
//        
        allexpired_tbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        allexpired_tbl.getTableHeader().setOpaque(false);
        allexpired_tbl.getTableHeader().setBackground(new Color(48, 173, 95));
        allexpired_tbl.getTableHeader().setForeground(new Color(255, 250, 250));
        allexpired_tbl.setRowHeight(25);
        allexpired_tbl.getTableHeader().setReorderingAllowed(false);
    }

    public void populate() {
        int index = allexpired_tbl.getSelectedRow();
        TableModel model = allexpired_tbl.getModel();

        String id = model.getValueAt(index, 0).toString();
        String firstname = model.getValueAt(index, 1).toString();
        String lastname = model.getValueAt(index, 2).toString();
        String gen = model.getValueAt(index, 3).toString();
        String number = model.getValueAt(index, 4).toString();
        String start = model.getValueAt(index, 5).toString();
        String end = model.getValueAt(index, 6).toString();

        ID.setText(id);
        fname.setText(firstname);
        lname.setText(lastname);
        gender.setText(gen);
        contactno.setText(number);

        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        START.setText(s.format(d));
//        START.setText(start);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Calendar xdate = Calendar.getInstance();
        xdate.add(Calendar.MONTH, 1);
        END.setText("" + df.format(xdate.getTime()));
    }

//    public void renewal() {
//        DefaultTableModel model = (DefaultTableModel) allexpired_tbl.getModel();
//        int row = allexpired_tbl.getSelectedRow();
//        String tc = allexpired_tbl.getModel().getValueAt(row, 0).toString();
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        Calendar xdate = Calendar.getInstance();
//        xdate.add(Calendar.MONTH, 1);
//
//        try {
//            String sql = "SELECT * FROM Members_Tbl WHERE mfirstName = '" + tc + "'";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            if (rs.next()) {
//                String id = rs.getString("members_id");
//                ID.setText(id);
//                String Start = rs.getString("Start");
//                START.setText(Start);
//                String End = rs.getString("End");
//                END.setText("" + df.format(xdate.getTime()));
//            }
//            pst.close();
//            rs.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, e);
//        }
//        all_expired();
//    }
    public void renewClicked(String Start, String End, String members_id) {
        int opt = JOptionPane.showConfirmDialog(null, "Renew this member?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String sql = "UPDATE Members_Tbl SET Start = ?, End = ? WHERE members_id = ?";

            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                con = Database.ConnectDB();
                // set the corresponding param
                pstmt.setString(1, Start);
                pstmt.setString(2, End);
                pstmt.setString(3, members_id);
                // update
                pstmt.executeUpdate();

           JOptionPane.showMessageDialog(null,"Success");

            DataBaseLogs dbl = DataBaseLogs.getInstance();
            dbl.renewLog();
            all_expired();
            
        }catch (Exception e) {
            e.printStackTrace();
           
        }
      }
    }

    private void all_expired() {
        try {
            Object[] columns = {"ID", "Firstname", "Lastname", "Gender", "ContactNumber", "Membership", "Start", "End"};
            MODEL = new DefaultTableModel();
            MODEL.setColumnIdentifiers(columns);
            allexpired_tbl.setModel(MODEL);
            allexpired_tbl.getTableHeader().setReorderingAllowed(false);
            allexpired_tbl.getTableHeader().setResizingAllowed(false);
//            PANE = new JScrollPane(allexpired_tbl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//
//            allexpired_tbl.getColumnModel().getColumn(0).setPreferredWidth(50);//ID
//            allexpired_tbl.getColumnModel().getColumn(1).setPreferredWidth(170);//first
//            allexpired_tbl.getColumnModel().getColumn(2).setPreferredWidth(100);//last
//            allexpired_tbl.getColumnModel().getColumn(3).setPreferredWidth(100);//user
//            allexpired_tbl.getColumnModel().getColumn(4).setPreferredWidth(100);//pass
//            allexpired_tbl.getColumnModel().getColumn(5).setPreferredWidth(100);//pos
//            allexpired_tbl.getColumnModel().getColumn(6).setPreferredWidth(100);//question
//            allexpired_tbl.getColumnModel().getColumn(7).setPreferredWidth(100);//ans

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, 1);
            c = Calendar.getInstance(); // reset
            String today = dateFormat.format(c.getTime());
            String sql = "SELECT members_id, mfirstName, mlastName,  gender, ContactNumber, Start, End FROM Members_Tbl WHERE End <=  '" + today + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            allexpired_tbl.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RENEW = new javax.swing.JButton();
        PANE = new javax.swing.JScrollPane();
        allexpired_tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        DELETEBTN = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        START = new javax.swing.JTextField();
        END = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        gender = new javax.swing.JTextField();
        contactno = new javax.swing.JTextField();
        deletedmem = new javax.swing.JLabel();
        renewmember = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        RENEW.setBackground(new java.awt.Color(48, 173, 95));
        RENEW.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RENEW.setForeground(new java.awt.Color(255, 255, 255));
        RENEW.setText("RENEW");
        RENEW.setContentAreaFilled(false);
        RENEW.setOpaque(true);
        RENEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RENEWActionPerformed(evt);
            }
        });

        PANE.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        PANE.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        allexpired_tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        allexpired_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        allexpired_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Firstname", "Lastname", "End"
            }
        ));
        allexpired_tbl.setToolTipText("");
        allexpired_tbl.setIntercellSpacing(new java.awt.Dimension(0, 0));
        allexpired_tbl.setOpaque(false);
        allexpired_tbl.setRowHeight(25);
        allexpired_tbl.setSelectionBackground(new java.awt.Color(0, 204, 51));
        allexpired_tbl.setShowVerticalLines(false);
        allexpired_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allexpired_tblMouseClicked(evt);
            }
        });
        PANE.setViewportView(allexpired_tbl);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setText("Expired Memberships");

        DELETEBTN.setBackground(new java.awt.Color(227, 23, 13));
        DELETEBTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DELETEBTN.setForeground(new java.awt.Color(255, 255, 255));
        DELETEBTN.setText("DELETE");
        DELETEBTN.setContentAreaFilled(false);
        DELETEBTN.setOpaque(true);
        DELETEBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEBTNActionPerformed(evt);
            }
        });

        ID.setText("id");

        START.setText("start");

        END.setText("end");

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(171, 173, 179));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search (1).png"))); // NOI18N
        jLabel1.setOpaque(true);

        fname.setText("firstname");

        lname.setText("lname");

        gender.setText("gender");

        contactno.setText("contactno");

        deletedmem.setText("Deleted a Member");

        renewmember.setText("Renew a Member");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(START, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(END, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RENEW)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DELETEBTN))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(PANE, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(323, 323, 323)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(renewmember)
                                    .addComponent(deletedmem))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PANE, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(START, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(END, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DELETEBTN)
                        .addComponent(RENEW)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletedmem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(renewmember)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RENEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RENEWActionPerformed
        renewClicked(START.getText(), END.getText(), ID.getText());
        all_expired();
    }//GEN-LAST:event_RENEWActionPerformed

    private void allexpired_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allexpired_tblMouseClicked
//        renewal();
        populate();
    }//GEN-LAST:event_allexpired_tblMouseClicked

    private void DELETEBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEBTNActionPerformed
        int row = allexpired_tbl.getSelectedRow();
        if (row >= 0) {
            int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
            if (opt == 0) {
                String id = allexpired_tbl.getModel().getValueAt(row, 0).toString();
                Database db = Database.getInstance();
                db.deleteMember(id);
                all_expired();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a Member first!");
        }
    }//GEN-LAST:event_DELETEBTNActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        final TableRowSorter rowSorter = new TableRowSorter<>(allexpired_tbl.getModel());
        //        rowSorter = new TableRowSorter<>(table.getModel());
        allexpired_tbl.setRowSorter(rowSorter);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETEBTN;
    private javax.swing.JTextField END;
    private javax.swing.JTextField ID;
    private javax.swing.JScrollPane PANE;
    private javax.swing.JButton RENEW;
    private javax.swing.JTextField START;
    private javax.swing.JTable allexpired_tbl;
    private javax.swing.JTextField contactno;
    public javax.swing.JLabel deletedmem;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lname;
    public javax.swing.JLabel renewmember;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
