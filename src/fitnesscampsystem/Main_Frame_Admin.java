package fitnesscampsystem;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import DataBase.Database;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import panels.DASHBOARD;
import panels.Members_Information;
import panels.Monthly_Reports;
import panels.NEW_MEMBERS;
import panels.Register;

public class Main_Frame_Admin extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    GridBagLayout layout = new GridBagLayout();
    DASHBOARD p1;
    NEW_MEMBERS p2;
    Register p3;
    Monthly_Reports p4;
    
//    static String setFirstname = "";
//    NEW_MEMBERS p6;

//    static boolean maximized = true;

 
    
    public Main_Frame_Admin() {
        initComponents();
        
       
        
        System.out.print("hi");
        con = Database.ConnectDB();
        
        ShowDate();
        
        countAllMembers();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tk.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();
        
        setSize(width, height);
        
//        int xsize = (int) tk.getScreenSize().getWidth();
//        int ysize = (int) tk.getScreenSize().getHeight();
//        this.setSize(xsize, ysize);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        p1 = new DASHBOARD();
        p2 = new NEW_MEMBERS();
        p3 = new Register();
        p4 = new Monthly_Reports();
//        p5 = new Members_Information();
//        p6 = new NEW_MEMBERS();

        DynamicPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p1, c);

        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p2, c);

        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p3, c);

        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p4, c);

        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
    }
    
 
    
//        public Main_Frame_Admin(String uname) {
//        initComponents();
////        here.setText(uname + "!!");
//        System.out.print("hi");
//        con = Database.ConnectDB();
//    }
    
       void ShowDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
        date.setText(s.format(d));
    }


    public void countAllMembers() {
        try {

            String sql = "SELECT count(Firstname) FROM Members_tbl ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String sum = rs.getString("count(FirstName)");
                total_mem.setText(sum);

            }

            pst.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SIDEBAR = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        DASHBOARD = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        LBL_DASHBOARD = new javax.swing.JLabel();
        MEMBERS = new javax.swing.JPanel();
        members = new javax.swing.JLabel();
        LBL_MEMBERS = new javax.swing.JLabel();
        ADD_USER = new javax.swing.JPanel();
        adduser = new javax.swing.JLabel();
        LBL_ADD_USER = new javax.swing.JLabel();
        MONTH_REPORT = new javax.swing.JPanel();
        monthly = new javax.swing.JLabel();
        LBL_MonthlyReports = new javax.swing.JLabel();
        TOPBAR = new javax.swing.JPanel();
        Total_Members = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        total_mem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        new_mems2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        new_mems = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        new_mems1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        DynamicPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("fitnesscamp");
        setBackground(new java.awt.Color(0, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1440, 900));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1414, 791));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit1.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize1.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize2.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setText("Fitness Camp Information System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1051, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 24));

        SIDEBAR.setBackground(new java.awt.Color(51, 51, 51));

        welcome.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(204, 204, 204));
        welcome.setText("Welcome");

        name.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(204, 204, 204));
        name.setText("jLabel3");

        DASHBOARD.setBackground(new java.awt.Color(51, 51, 51));
        DASHBOARD.setPreferredSize(new java.awt.Dimension(214, 60));
        DASHBOARD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DASHBOARDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DASHBOARDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DASHBOARDMouseExited(evt);
            }
        });

        dashboard.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setText("DASHBOARD");

        LBL_DASHBOARD.setBackground(new java.awt.Color(255, 255, 255));
        LBL_DASHBOARD.setOpaque(true);

        javax.swing.GroupLayout DASHBOARDLayout = new javax.swing.GroupLayout(DASHBOARD);
        DASHBOARD.setLayout(DASHBOARDLayout);
        DASHBOARDLayout.setHorizontalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARDLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LBL_DASHBOARD, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(dashboard)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        DASHBOARDLayout.setVerticalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARDLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboard)
                    .addComponent(LBL_DASHBOARD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        MEMBERS.setBackground(new java.awt.Color(51, 51, 51));
        MEMBERS.setPreferredSize(new java.awt.Dimension(214, 60));
        MEMBERS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MEMBERSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MEMBERSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MEMBERSMouseExited(evt);
            }
        });

        members.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        members.setForeground(new java.awt.Color(255, 255, 255));
        members.setText("MEMBERS");

        LBL_MEMBERS.setBackground(new java.awt.Color(255, 255, 255));
        LBL_MEMBERS.setOpaque(true);

        javax.swing.GroupLayout MEMBERSLayout = new javax.swing.GroupLayout(MEMBERS);
        MEMBERS.setLayout(MEMBERSLayout);
        MEMBERSLayout.setHorizontalGroup(
            MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MEMBERSLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LBL_MEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(members)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MEMBERSLayout.setVerticalGroup(
            MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MEMBERSLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(members, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_MEMBERS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        ADD_USER.setBackground(new java.awt.Color(51, 51, 51));
        ADD_USER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADD_USERMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADD_USERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ADD_USERMouseExited(evt);
            }
        });

        adduser.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        adduser.setForeground(new java.awt.Color(255, 255, 255));
        adduser.setText("ADD USER");

        LBL_ADD_USER.setBackground(new java.awt.Color(255, 255, 255));
        LBL_ADD_USER.setOpaque(true);

        javax.swing.GroupLayout ADD_USERLayout = new javax.swing.GroupLayout(ADD_USER);
        ADD_USER.setLayout(ADD_USERLayout);
        ADD_USERLayout.setHorizontalGroup(
            ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADD_USERLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LBL_ADD_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(adduser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ADD_USERLayout.setVerticalGroup(
            ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADD_USERLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LBL_ADD_USER, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adduser))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        MONTH_REPORT.setBackground(new java.awt.Color(51, 51, 51));
        MONTH_REPORT.setPreferredSize(new java.awt.Dimension(214, 60));
        MONTH_REPORT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MONTH_REPORTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MONTH_REPORTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MONTH_REPORTMouseExited(evt);
            }
        });

        monthly.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        monthly.setForeground(new java.awt.Color(255, 255, 255));
        monthly.setText("MONTHLY ");

        LBL_MonthlyReports.setBackground(new java.awt.Color(255, 255, 255));
        LBL_MonthlyReports.setOpaque(true);

        javax.swing.GroupLayout MONTH_REPORTLayout = new javax.swing.GroupLayout(MONTH_REPORT);
        MONTH_REPORT.setLayout(MONTH_REPORTLayout);
        MONTH_REPORTLayout.setHorizontalGroup(
            MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MONTH_REPORTLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LBL_MonthlyReports, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(monthly)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MONTH_REPORTLayout.setVerticalGroup(
            MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MONTH_REPORTLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(monthly)
                    .addComponent(LBL_MonthlyReports, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SIDEBARLayout = new javax.swing.GroupLayout(SIDEBAR);
        SIDEBAR.setLayout(SIDEBARLayout);
        SIDEBARLayout.setHorizontalGroup(
            SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD_USER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MONTH_REPORT, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
            .addComponent(MEMBERS, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
            .addGroup(SIDEBARLayout.createSequentialGroup()
                .addGroup(SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addGroup(SIDEBARLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SIDEBARLayout.setVerticalGroup(
            SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SIDEBARLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcome)
                    .addComponent(name))
                .addGap(68, 68, 68)
                .addComponent(DASHBOARD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ADD_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MONTH_REPORT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        getContentPane().add(SIDEBAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, -1, -1));

        TOPBAR.setBackground(new java.awt.Color(219, 219, 219));
        TOPBAR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Total_Members.setBackground(new java.awt.Color(245, 104, 84));
        Total_Members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Total_MembersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Total_MembersMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total of Members");

        total_mem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        total_mem.setForeground(new java.awt.Color(255, 255, 255));
        total_mem.setText("0");

        javax.swing.GroupLayout Total_MembersLayout = new javax.swing.GroupLayout(Total_Members);
        Total_Members.setLayout(Total_MembersLayout);
        Total_MembersLayout.setHorizontalGroup(
            Total_MembersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Total_MembersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Total_MembersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(total_mem))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        Total_MembersLayout.setVerticalGroup(
            Total_MembersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Total_MembersLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(total_mem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        TOPBAR.add(Total_Members, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 110, 175));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Monthly Income");

        new_mems2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        new_mems2.setForeground(new java.awt.Color(255, 255, 255));
        new_mems2.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(new_mems2))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(new_mems2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        TOPBAR.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

        jPanel6.setBackground(new java.awt.Color(9, 192, 239));
        jPanel6.setPreferredSize(new java.awt.Dimension(235, 69));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Members");

        new_mems.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        new_mems.setForeground(new java.awt.Color(255, 255, 255));
        new_mems.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(new_mems)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(new_mems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        TOPBAR.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, 70));

        jPanel7.setBackground(new java.awt.Color(0, 163, 89));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New Members");

        new_mems1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        new_mems1.setForeground(new java.awt.Color(255, 255, 255));
        new_mems1.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(new_mems1))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(new_mems1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        TOPBAR.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(date)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date)
                .addContainerGap())
        );

        TOPBAR.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        getContentPane().add(TOPBAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 24, 1069, -1));

        DynamicPanel.setBackground(new java.awt.Color(250, 250, 250));
        DynamicPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(DynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 154, 1070, 637));

        getAccessibleContext().setAccessibleName("Main menu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton2MouseClicked

    private void Total_MembersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Total_MembersMouseEntered
        Total_Members.setBackground(new Color(212, 61, 26));
    }//GEN-LAST:event_Total_MembersMouseEntered

    private void Total_MembersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Total_MembersMouseExited
        Total_Members.setBackground(new Color(245, 104, 84));
    }//GEN-LAST:event_Total_MembersMouseExited

    private void DASHBOARDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOARDMouseEntered
        DASHBOARD.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_DASHBOARDMouseEntered

    private void MEMBERSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEMBERSMouseEntered
        MEMBERS.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_MEMBERSMouseEntered

    private void ADD_USERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_USERMouseEntered
        ADD_USER.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_ADD_USERMouseEntered

    private void MONTH_REPORTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTH_REPORTMouseEntered
        MONTH_REPORT.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_MONTH_REPORTMouseEntered

    private void DASHBOARDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOARDMouseExited
        DASHBOARD.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_DASHBOARDMouseExited

    private void MEMBERSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEMBERSMouseExited
        MEMBERS.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_MEMBERSMouseExited

    private void ADD_USERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_USERMouseExited
        ADD_USER.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_ADD_USERMouseExited

    private void MONTH_REPORTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTH_REPORTMouseExited
        MONTH_REPORT.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_MONTH_REPORTMouseExited

    private void DASHBOARDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOARDMouseClicked
        LBL_DASHBOARD.setBackground(new Color(255, 255, 255));

        LBL_MEMBERS.setBackground(new Color(51, 51, 51));
        LBL_ADD_USER.setBackground(new Color(51, 51, 51));
        LBL_MonthlyReports.setBackground(new Color(51, 51, 51));
        
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        
        
    }//GEN-LAST:event_DASHBOARDMouseClicked

    private void MEMBERSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MEMBERSMouseClicked
        LBL_MEMBERS.setBackground(new Color(255, 255, 255));

        LBL_DASHBOARD.setBackground(new Color(51, 51, 51));
        LBL_ADD_USER.setBackground(new Color(51, 51, 51));
        LBL_MonthlyReports.setBackground(new Color(51, 51, 51));
        
        p1.setVisible(false);
        p2.setVisible(true);
        p3.setVisible(false);
        p4.setVisible(false);
    }//GEN-LAST:event_MEMBERSMouseClicked

    private void ADD_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_USERMouseClicked
        LBL_ADD_USER.setBackground(new Color(255, 255, 255));

        LBL_DASHBOARD.setBackground(new Color(51, 51, 51));
        LBL_MEMBERS.setBackground(new Color(51, 51, 51));
        LBL_MonthlyReports.setBackground(new Color(51, 51, 51));
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(true);
        p4.setVisible(false);
    }//GEN-LAST:event_ADD_USERMouseClicked

    private void MONTH_REPORTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTH_REPORTMouseClicked
        LBL_MonthlyReports.setBackground(new Color(255, 255, 255));

        LBL_DASHBOARD.setBackground(new Color(51, 51, 51));
        LBL_MEMBERS.setBackground(new Color(51, 51, 51));
        LBL_ADD_USER.setBackground(new Color(51, 51, 51));
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(true);
    }//GEN-LAST:event_MONTH_REPORTMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Frame_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADD_USER;
    private javax.swing.JPanel DASHBOARD;
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JLabel LBL_ADD_USER;
    private javax.swing.JLabel LBL_DASHBOARD;
    private javax.swing.JLabel LBL_MEMBERS;
    private javax.swing.JLabel LBL_MonthlyReports;
    private javax.swing.JPanel MEMBERS;
    private javax.swing.JPanel MONTH_REPORT;
    private javax.swing.JPanel SIDEBAR;
    private javax.swing.JPanel TOPBAR;
    private javax.swing.JPanel Total_Members;
    private javax.swing.JLabel adduser;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel members;
    private javax.swing.JLabel monthly;
    private javax.swing.JLabel name;
    private javax.swing.JLabel new_mems;
    private javax.swing.JLabel new_mems1;
    private javax.swing.JLabel new_mems2;
    private javax.swing.JLabel total_mem;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
