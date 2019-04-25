package panels;

import DataBase.AttandanceUploader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AttendanceMembers extends javax.swing.JPanel {

    DefaultTableModel setTABLE_MODEL = new DefaultTableModel();
    JButton ADD_DATABASE, ADD_HOLIDAY;
    JTable LOGS_LIST;
    JScrollPane LOGS_PANE;
    JPanel ATTENDANCE_LOGS;
    JTextField SEARCH;

    private static AttendanceMembers instance = null;

    public static AttendanceMembers getInstance() {
        if (instance == null) {
            instance = new AttendanceMembers();
        }
        return instance;
    }

    public AttendanceMembers() {
        initComponents();
//         this.setBackground(Color.BLACK);

        ATTENDANCE_TBL.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        ATTENDANCE_TBL.getTableHeader().setOpaque(false);
        ATTENDANCE_TBL.getTableHeader().setBackground(new Color(48, 173, 95));
        ATTENDANCE_TBL.getTableHeader().setForeground(new Color(255, 255, 255));
        ATTENDANCE_TBL.setRowHeight(25);
        ATTENDANCE_TBL.getTableHeader().setReorderingAllowed(false);
    }

    void setTable() {
        setTABLE_MODEL = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] columnName = new Object[6];
        columnName[0] = "ID";
        columnName[1] = "NAME";
        columnName[2] = "TIME IN";
        columnName[3] = "TIME OUT";
        columnName[4] = "TOTAL";
        columnName[5] = "DATE";
//        columnName[6] = "STATUS";

        setTABLE_MODEL.setColumnIdentifiers(columnName);
        LOGS_LIST.setModel(setTABLE_MODEL);
        LOGS_LIST.getColumnModel().getColumn(0).setResizable(false);
        LOGS_LIST.setAutoCreateRowSorter(true);
        LOGS_LIST.setIntercellSpacing(new Dimension(0, 0));
        LOGS_LIST.getTableHeader().setOpaque(false);
        LOGS_LIST.getTableHeader().setBackground(new Color(0, 0, 0, 0.6f));
        LOGS_LIST.getTableHeader().setForeground(Color.white);
        LOGS_LIST.setShowGrid(false);
        LOGS_LIST.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        LOGS_LIST.getColumn("ID").setMaxWidth(100);
        LOGS_LIST.getColumn("TIME IN").setMaxWidth(150);
        LOGS_LIST.getColumn("TIME OUT").setMaxWidth(150);
        LOGS_LIST.getColumn("TOTAL").setMaxWidth(100);
        LOGS_LIST.getColumn("DATE").setMaxWidth(150);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ATTENDANCE_TBL = new javax.swing.JTable();
        IMPORT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        ATTENDANCE_TBL = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ATTENDANCE_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "TIME IN", "TIME OUT", "DATE"
            }
        ));
        jScrollPane1.setViewportView(ATTENDANCE_TBL);

        IMPORT.setText("IMPORT");
        IMPORT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPORTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setText("ATTENDANCE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IMPORT, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(IMPORT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IMPORTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMPORTActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Import");

        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println(chooser.getSelectedFile().getAbsolutePath());
            AttandanceUploader au = AttandanceUploader.getInstance();

//            try {
//                au.scanFile(fileChooser.getSelectedFile().getAbsolutePath());
//            } catch (IOException ex) {
//                Logger.getLogger(Attendance_logs.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            setDataBase sd = setDataBase.getInstance();
//            sd.filterData_attendanceLogs();
//        }

    }
    }//GEN-LAST:event_IMPORTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ATTENDANCE_TBL;
    private javax.swing.JButton IMPORT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
