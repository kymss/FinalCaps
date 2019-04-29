package panels;

import DataBase.Database;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import fitnesscampsystem.userLogs;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class MRincome extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public MRincome() {
        initComponents();

        con = Database.ConnectDB();
        Table_view();
        sum();
//        payment();
        income.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        income.getTableHeader().setOpaque(false);
        income.getTableHeader().setBackground(new Color(48, 173, 95));
        income.getTableHeader().setForeground(new Color(255, 255, 255));
        income.setRowHeight(25);
        income.getTableHeader().setReorderingAllowed(false);
    }

    

public void Table_view() {
        try {
//             select * from table where strftime('%m', created_date) == strftime('%m','now')
            String sql = "SELECT members_id, mfirstName, mlastName, Payment from Members_Tbl WHERE  strftime('%m', Start) == strftime('%m', 'now')";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            income.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
            System.out.print(e);
        }
    }

    public void sum() {
        int sum = 0;

        for (int i = 0; i < income.getRowCount(); i++) {
            sum = sum + Integer.parseInt(income.getValueAt(i, 3).toString());
            {
                jTextField1.setText(Integer.toString(sum));
            }
        }
    }
//
//    public void getSum() {
//        int sum = 0;
//        for (int i = 0; i < income.getRowCount(); i++) {
//            sum = sum + Integer.parseInt(table.getValueAt(i, 3).toString);
//
//        }
//        field.setText(Integer.toString(num));
//    }

//    public void payment() {
//        try {
//            String sql = "SELECT SUM(Payment) FROM Members_Tbl";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            if (rs.next()) {
//                String sum = rs.getString("SUM(Payment)");
////                num_label.setText(sum);
//                jTextField1.setText(sum);
//            }
//            pst.close();
//            rs.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        income = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        income = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        income.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Last Name", "Start", " End"
            }
        ));
        income.setSelectionBackground(new java.awt.Color(51, 210, 102));
        jScrollPane1.setViewportView(income);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total income");

        jButton1.setText("Generate Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                  
        String path = "";
        
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x= j.showSaveDialog(this);
        
        
        if (x== JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"MonthIncome.pdf"));
            
            doc.open();
            PdfPTable tbl = new PdfPTable(5);
            
            
            tbl.addCell("FIRSTNAME");
            tbl.addCell("LASTNAME");
            tbl.addCell("GENDER");
            tbl.addCell("START");
            tbl.addCell("END");
            tbl.addCell("PAYMENT");
            
            
            for (int i = 0; i < income.getRowCount(); i++) {
                String fname = income.getValueAt(i, 0).toString();
                String lname = income.getValueAt(i, 1).toString();
                String gender = income.getValueAt(i, 2).toString();
                String start = income.getValueAt(i, 3).toString();
                String end = income.getValueAt(i, 4).toString();
                String pay = income.getValueAt(i, 5).toString();
                
                tbl.addCell(fname);
                tbl.addCell(lname);
                tbl.addCell(gender);
                tbl.addCell(start);
                tbl.addCell(end);
                tbl.addCell(pay);
            }
            
            doc.add(tbl);
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(userLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(userLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable income;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
