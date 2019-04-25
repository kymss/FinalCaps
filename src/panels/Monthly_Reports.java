package panels;

import DataBase.Database;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Monthly_Reports extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    GridBagLayout layout = new GridBagLayout();
    MRsubscriptions p1;
    MRex p2;
    MRincome p3;

    public Monthly_Reports() {
        initComponents();
        con = Database.ConnectDB();
//        Table_view();
//        exp();

        p1 = new MRsubscriptions();
        p2 = new MRex();
        p3 = new MRincome();

        Dpanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        Dpanel.add(p1, c);

        c.gridx = 0;
        c.gridy = 0;
        Dpanel.add(p2, c);

        c.gridx = 0;
        c.gridy = 0;
        Dpanel.add(p3, c);

        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);

        

//       Display();
    }
//    
//     private String getDateTime() {           
//    DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy", Locale.getDefault());
//    Date date = new Date();
//    return dateFormat.format(date);
//    }

//    public void dips() {
//        Date date = null; // your date
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//    }
//    
//    private void Display() {
//
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            Calendar c = Calendar.getInstance();
//            c.set(Calendar.DAY_OF_MONTH, 1);
//            c = Calendar.getInstance(); // reset
//            String today = dateFormat.format(c.getTime());
//            
//            int month = c.get(Calendar.MONTH) + 1;
//            
//            String sql = "SELECT Firstname FROM Members_Tbl WHERE MONTH(End) = %m";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            monthlyreports.setModel(DbUtils.resultSetToTableModel(rs));
//           
//            
//             pst.close();
//             rs.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//    public void Table_view() {
//        try {
//
////             select * from table where strftime('%m', created_date) == strftime('%m','now')
//            String sql = "select id, Firstname, Lastname from Members_Tbl WHERE  strftime('%m', Start) == strftime('%m', 'now')";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            monthlyreports.setModel(DbUtils.resultSetToTableModel(rs));
//
//            pst.close();
//            rs.close();
//        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e);
//            System.out.print("no");
//        }
//    }

//     public void exp(){
//         try {
//             
////             select * from table where strftime('%m', created_date) == strftime('%m','now')
//            String sql = "select id, Firstname, Lastname from Members_Tbl WHERE  strftime('%m', Start) == strftime('%m', 'now')";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            expi.setModel(DbUtils.resultSetToTableModel(rs));
//
//            pst.close();
//            rs.close();
//        } catch (Exception e) {
////            JOptionPane.showMessageDialog(null, e);
//                System.out.print("no");
//        }
//    }
//    
//    public void Table_View() {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            Calendar c = Calendar.getInstance();
//            c.set(Calendar.DAY_OF_MONTH, 1);
//            c = Calendar.getInstance(); // reset
//            String today = dateFormat.format(c.getTime());
//            String sql = "SELECT Firstname, Lastname, End FROM Members_Tbl WHERE End =  '" + today + "'";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            monthlyreports.setModel(DbUtils.resultSetToTableModel(rs));
//
//            pst.close();
//            rs.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SUBSCRIPTIONS = new javax.swing.JButton();
        EXPIREDSUBSCRIPTIONS = new javax.swing.JButton();
        INCOME = new javax.swing.JButton();
        Dpanel = new javax.swing.JPanel();
        lbl_sbs = new javax.swing.JLabel();
        lbl_xp = new javax.swing.JLabel();
        lbl_inc = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setText("Monthly Reports");

        SUBSCRIPTIONS.setBackground(new java.awt.Color(48, 173, 95));
        SUBSCRIPTIONS.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        SUBSCRIPTIONS.setForeground(new java.awt.Color(255, 255, 255));
        SUBSCRIPTIONS.setText("Subscriptions");
        SUBSCRIPTIONS.setContentAreaFilled(false);
        SUBSCRIPTIONS.setOpaque(true);
        SUBSCRIPTIONS.setPreferredSize(new java.awt.Dimension(147, 25));
        SUBSCRIPTIONS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SUBSCRIPTIONSMouseExited(evt);
            }
        });
        SUBSCRIPTIONS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBSCRIPTIONSActionPerformed(evt);
            }
        });

        EXPIREDSUBSCRIPTIONS.setBackground(new java.awt.Color(48, 173, 95));
        EXPIREDSUBSCRIPTIONS.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        EXPIREDSUBSCRIPTIONS.setForeground(new java.awt.Color(255, 255, 255));
        EXPIREDSUBSCRIPTIONS.setText("Expired Subscriptions");
        EXPIREDSUBSCRIPTIONS.setContentAreaFilled(false);
        EXPIREDSUBSCRIPTIONS.setOpaque(true);
        EXPIREDSUBSCRIPTIONS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXPIREDSUBSCRIPTIONSActionPerformed(evt);
            }
        });

        INCOME.setBackground(new java.awt.Color(48, 173, 95));
        INCOME.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        INCOME.setForeground(new java.awt.Color(255, 255, 255));
        INCOME.setText("Income");
        INCOME.setContentAreaFilled(false);
        INCOME.setOpaque(true);
        INCOME.setPreferredSize(new java.awt.Dimension(147, 25));
        INCOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INCOMEActionPerformed(evt);
            }
        });

        Dpanel.setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout DpanelLayout = new javax.swing.GroupLayout(Dpanel);
        Dpanel.setLayout(DpanelLayout);
        DpanelLayout.setHorizontalGroup(
            DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        DpanelLayout.setVerticalGroup(
            DpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        lbl_sbs.setBackground(new java.awt.Color(48, 173, 95));
        lbl_sbs.setOpaque(true);

        lbl_xp.setBackground(new java.awt.Color(255, 255, 255));
        lbl_xp.setOpaque(true);

        lbl_inc.setBackground(new java.awt.Color(255, 255, 255));
        lbl_inc.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_sbs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUBSCRIPTIONS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EXPIREDSUBSCRIPTIONS)
                            .addComponent(lbl_xp, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(INCOME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_inc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUBSCRIPTIONS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXPIREDSUBSCRIPTIONS)
                    .addComponent(INCOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_inc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_sbs, javax.swing.GroupLayout.DEFAULT_SIZE, 4, Short.MAX_VALUE)
                    .addComponent(lbl_xp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Dpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        Dpanel.getAccessibleContext().setAccessibleName("");
        Dpanel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void SUBSCRIPTIONSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBSCRIPTIONSActionPerformed
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        
        
        if (p1.isVisible()) {
            lbl_sbs.setBackground(new Color(48,173,95));
            lbl_xp.setBackground(new Color(255,255, 255));
            lbl_inc.setBackground(new Color(255,255, 255));
        } else {
            lbl_sbs.setBackground(new Color(48,173,95));
        }
    }//GEN-LAST:event_SUBSCRIPTIONSActionPerformed

    private void EXPIREDSUBSCRIPTIONSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXPIREDSUBSCRIPTIONSActionPerformed
        p1.setVisible(false);
        p2.setVisible(true);
        p3.setVisible(false);
        
        if (p2.isVisible()) {
            lbl_sbs.setBackground(new Color(255,255, 255));
            lbl_xp.setBackground(new Color(48,173,95));
            lbl_inc.setBackground(new Color(255,255, 255));
        } else {
            lbl_xp.setBackground(new Color(48,173,95));
        }
    }//GEN-LAST:event_EXPIREDSUBSCRIPTIONSActionPerformed

    private void INCOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INCOMEActionPerformed
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(true);
        
        if (p3.isVisible()) {
            lbl_sbs.setBackground(new Color(255,255, 255));
            lbl_xp.setBackground(new Color(255,255, 255));
            lbl_inc.setBackground(new Color(48,173,95));
        } else {
            lbl_inc.setBackground(new Color(48,173,95));
        }
    }//GEN-LAST:event_INCOMEActionPerformed

    private void SUBSCRIPTIONSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUBSCRIPTIONSMouseExited
        
    }//GEN-LAST:event_SUBSCRIPTIONSMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dpanel;
    private javax.swing.JButton EXPIREDSUBSCRIPTIONS;
    private javax.swing.JButton INCOME;
    private javax.swing.JButton SUBSCRIPTIONS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_inc;
    private javax.swing.JLabel lbl_sbs;
    private javax.swing.JLabel lbl_xp;
    // End of variables declaration//GEN-END:variables
}
