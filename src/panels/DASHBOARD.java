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
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class DASHBOARD extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public DASHBOARD() {
        initComponents();
        con = Database.ConnectDB();
//        expired_today();
        all_expired();

        END.setVisible(false);
        START.setVisible(false);
        ID.setVisible(false);
        
        
        allexpired_tbl.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14 ));
        allexpired_tbl.getTableHeader().setOpaque(false);
        allexpired_tbl.getTableHeader().setBackground(new Color(48,173,95));
        allexpired_tbl.getTableHeader().setForeground(new Color(255, 250, 250));
        allexpired_tbl.setRowHeight(25);
        
        
        
//        END1.setVisible(false);
//        START1.setVisible(false);
//        ID1.setVisible(false);

    }

//    private void expired_today() {
//
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            Calendar c = Calendar.getInstance();
//            c.set(Calendar.DAY_OF_MONTH, 1);
//            c = Calendar.getInstance(); // reset
//            String today = dateFormat.format(c.getTime());
//            String sql = "SELECT Firstname, Lastname, End FROM Members_Tbl WHERE End = '" + today + "'";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            today_tbl.setModel(DbUtils.resultSetToTableModel(rs));
//
//            pst.close();
//            rs.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

    public void renewal() {
        DefaultTableModel model = (DefaultTableModel) allexpired_tbl.getModel();
        int row = allexpired_tbl.getSelectedRow();

        String tc = allexpired_tbl.getModel().getValueAt(row, 0).toString();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//            startdate.setText(""+ df.format(d));

        Calendar xdate = Calendar.getInstance();
        xdate.add(Calendar.MONTH, 1);

        try {

            String sql = "SELECT * FROM Members_Tbl WHERE Firstname = '" + tc + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String id = rs.getString("id");
                ID.setText(id);

                String Start = rs.getString("Start");
                START.setText(Start);

                String End = rs.getString("End");
                END.setText("" + df.format(xdate.getTime()));
//                END.setText(End);

            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
        all_expired();
    }

    public void renewClicked(String Start, String End, String id) {
        String sql = "UPDATE Members_Tbl SET Start = ?, End = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            con = Database.ConnectDB();
            // set the corresponding param
            pstmt.setString(1, Start);
            pstmt.setString(2, End);
            pstmt.setString(3, id);
            // update
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            all_expired();
        }
    }

    private void all_expired() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, 1);
            c = Calendar.getInstance(); // reset
            String today = dateFormat.format(c.getTime());
            String sql = "SELECT Firstname, Lastname, End FROM Members_Tbl WHERE End <=  '" + today + "'";
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
        jScrollPane2 = new javax.swing.JScrollPane();
        allexpired_tbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        START = new javax.swing.JTextField();
        END = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(250, 250, 250));

        RENEW.setBackground(new java.awt.Color(135, 135, 135));
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

        allexpired_tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        allexpired_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        allexpired_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Firstname", "Lastname", "Start", "End"
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
        jScrollPane2.setViewportView(allexpired_tbl);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setText("Expired Memberships");

        jButton4.setBackground(new java.awt.Color(227, 23, 13));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DELETE");
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(RENEW))
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(START, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(END, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(RENEW)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(START, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(END, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RENEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RENEWActionPerformed

        renewClicked(START.getText(), END.getText(), ID.getText());
        all_expired();

    }//GEN-LAST:event_RENEWActionPerformed

    private void allexpired_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allexpired_tblMouseClicked

        renewal();

    }//GEN-LAST:event_allexpired_tblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField END;
    private javax.swing.JTextField ID;
    private javax.swing.JButton RENEW;
    private javax.swing.JTextField START;
    private javax.swing.JTable allexpired_tbl;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
