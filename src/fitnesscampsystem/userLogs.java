package fitnesscampsystem;

import DataBase.Database;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
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
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class userLogs extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    DefaultTableModel MODEL;

    private static userLogs instance = null;

    public static userLogs getInstance() {
        if (instance == null) {
            instance = new userLogs();
        }
        return instance;
    }

    public userLogs() {
        initComponents();
        con = Database.ConnectDB();
        display();

        TABLE.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        TABLE.getTableHeader().setOpaque(false);
        TABLE.getTableHeader().setBackground(new Color(48, 173, 95));
        TABLE.getTableHeader().setForeground(new Color(255, 250, 250));
        TABLE.setRowHeight(25);
        TABLE.getTableHeader().setReorderingAllowed(false);
    }

    public void display() {
        try {

            String sql = "SELECT User_id, Username, Date, Time, Description from LOGS_TBL";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            TABLE.setModel(DbUtils.resultSetToTableModel(rs));

            pst.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        generate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        TABLE = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };

        TABLE.getTableHeader().setReorderingAllowed(false);
        TABLE.setSelectionBackground(new java.awt.Color(51, 210, 102));
        jScrollPane1.setViewportView(TABLE);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 30, 820, 402);

        generate.setText("Generate Report");
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });
        jPanel1.add(generate);
        generate.setBounds(650, 440, 210, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 990, 550);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
            
        String path = "";
        
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x= j.showSaveDialog(this);
        
        
        if (x== JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"UserLogs.pdf"));
            
            doc.open();
            PdfPTable tbl = new PdfPTable(5);
            
            
            tbl.addCell("User_Id");
            tbl.addCell("Username");
            tbl.addCell("Date");
            tbl.addCell("Time");
            tbl.addCell("Description");
            
            
            for (int i = 0; i < TABLE.getRowCount(); i++) {
                String ID = TABLE.getValueAt(i, 0).toString();
                String uname = TABLE.getValueAt(i, 1).toString();
                String date = TABLE.getValueAt(i, 2).toString();
                String time = TABLE.getValueAt(i, 3).toString();
                String desc = TABLE.getValueAt(i, 4).toString();
                
                tbl.addCell(ID);
                tbl.addCell(uname);
                tbl.addCell(date);
                tbl.addCell(time);
                tbl.addCell(desc);
                
            }
            
            doc.add(tbl);
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(userLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(userLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
        
        
        
    }//GEN-LAST:event_generateActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(userLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userLogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLE;
    private javax.swing.JButton generate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
