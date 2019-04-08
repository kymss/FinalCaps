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
import java.awt.event.WindowEvent;
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
import panels.ADD_MEMBER;
import panels.Register;

public class Main_Frame_Admin extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    GridBagLayout layout = new GridBagLayout();
    DASHBOARD p1;
    ADD_MEMBER p2;
    Register p3;
    Monthly_Reports p4;

//    static String setFirstname = "";
//    NEW_MEMBERS p6;
//    static boolean maximized = true;
    
    
    public Main_Frame_Admin() {
        initComponents();
//        name.setText(uname + "!!");

        con = Database.ConnectDB();
        ShowDate();
        countAllMembers();

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tk.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();

        setSize(width, height);

        p1 = new DASHBOARD();
        p2 = new ADD_MEMBER();
        p3 = new Register();
        p4 = new Monthly_Reports();

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

    public Main_Frame_Admin(String uname) {
        initComponents();
        name.setText(uname + "!!");

       
    }

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
        jLabel7 = new javax.swing.JLabel();
        TOPBAR = new javax.swing.JPanel();
        Total_Members = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        total_mem = new javax.swing.JLabel();
        MONTHLY_INCOME = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        new_mems2 = new javax.swing.JLabel();
        RECENT_MEMBERS = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        new_mems = new javax.swing.JLabel();
        USERS = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        new_mems1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
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
        jLabel1.setText("Fitness Camp Members Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 983, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
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
        LBL_DASHBOARD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home (1).png"))); // NOI18N

        javax.swing.GroupLayout DASHBOARDLayout = new javax.swing.GroupLayout(DASHBOARD);
        DASHBOARD.setLayout(DASHBOARDLayout);
        DASHBOARDLayout.setHorizontalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARDLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LBL_DASHBOARD)
                .addGap(26, 26, 26)
                .addComponent(dashboard)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DASHBOARDLayout.setVerticalGroup(
            DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARDLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(DASHBOARDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LBL_DASHBOARD)
                    .addComponent(dashboard))
                .addGap(14, 14, 14))
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
        members.setText("REGISTER");

        LBL_MEMBERS.setBackground(new java.awt.Color(255, 255, 255));
        LBL_MEMBERS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/writing.png"))); // NOI18N

        javax.swing.GroupLayout MEMBERSLayout = new javax.swing.GroupLayout(MEMBERS);
        MEMBERS.setLayout(MEMBERSLayout);
        MEMBERSLayout.setHorizontalGroup(
            MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MEMBERSLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LBL_MEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(members)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MEMBERSLayout.setVerticalGroup(
            MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MEMBERSLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(members, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_MEMBERS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
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
        LBL_ADD_USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-user (3).png"))); // NOI18N

        javax.swing.GroupLayout ADD_USERLayout = new javax.swing.GroupLayout(ADD_USER);
        ADD_USER.setLayout(ADD_USERLayout);
        ADD_USERLayout.setHorizontalGroup(
            ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADD_USERLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LBL_ADD_USER)
                .addGap(29, 29, 29)
                .addComponent(adduser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ADD_USERLayout.setVerticalGroup(
            ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADD_USERLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adduser)
                    .addComponent(LBL_ADD_USER))
                .addContainerGap(13, Short.MAX_VALUE))
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
        monthly.setText("MEMBERS MONTHLY REPORT");

        LBL_MonthlyReports.setBackground(new java.awt.Color(255, 255, 255));
        LBL_MonthlyReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendar.png"))); // NOI18N

        javax.swing.GroupLayout MONTH_REPORTLayout = new javax.swing.GroupLayout(MONTH_REPORT);
        MONTH_REPORT.setLayout(MONTH_REPORTLayout);
        MONTH_REPORTLayout.setHorizontalGroup(
            MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MONTH_REPORTLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(LBL_MonthlyReports)
                .addGap(18, 18, 18)
                .addComponent(monthly)
                .addGap(13, 13, 13))
        );
        MONTH_REPORTLayout.setVerticalGroup(
            MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MONTH_REPORTLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LBL_MonthlyReports)
                    .addComponent(monthly))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fitnesscampsystem/1.png"))); // NOI18N

        javax.swing.GroupLayout SIDEBARLayout = new javax.swing.GroupLayout(SIDEBAR);
        SIDEBAR.setLayout(SIDEBARLayout);
        SIDEBARLayout.setHorizontalGroup(
            SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ADD_USER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MONTH_REPORT, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addComponent(MEMBERS, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addComponent(DASHBOARD, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addGroup(SIDEBARLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SIDEBARLayout.setVerticalGroup(
            SIDEBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SIDEBARLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DASHBOARD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ADD_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MONTH_REPORT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        getContentPane().add(SIDEBAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 290, 770));

        TOPBAR.setBackground(new java.awt.Color(219, 219, 219));

        Total_Members.setBackground(new java.awt.Color(245, 104, 84));
        Total_Members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Total_MembersMouseClicked(evt);
            }
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

        MONTHLY_INCOME.setBackground(new java.awt.Color(0, 110, 175));
        MONTHLY_INCOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MONTHLY_INCOMEMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Monthly Income");

        new_mems2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        new_mems2.setForeground(new java.awt.Color(255, 255, 255));
        new_mems2.setText("0");

        javax.swing.GroupLayout MONTHLY_INCOMELayout = new javax.swing.GroupLayout(MONTHLY_INCOME);
        MONTHLY_INCOME.setLayout(MONTHLY_INCOMELayout);
        MONTHLY_INCOMELayout.setHorizontalGroup(
            MONTHLY_INCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MONTHLY_INCOMELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MONTHLY_INCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(new_mems2))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        MONTHLY_INCOMELayout.setVerticalGroup(
            MONTHLY_INCOMELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MONTHLY_INCOMELayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(new_mems2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        RECENT_MEMBERS.setBackground(new java.awt.Color(9, 192, 239));
        RECENT_MEMBERS.setPreferredSize(new java.awt.Dimension(235, 69));
        RECENT_MEMBERS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RECENT_MEMBERSMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Members");

        new_mems.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        new_mems.setForeground(new java.awt.Color(255, 255, 255));
        new_mems.setText("0");

        javax.swing.GroupLayout RECENT_MEMBERSLayout = new javax.swing.GroupLayout(RECENT_MEMBERS);
        RECENT_MEMBERS.setLayout(RECENT_MEMBERSLayout);
        RECENT_MEMBERSLayout.setHorizontalGroup(
            RECENT_MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RECENT_MEMBERSLayout.createSequentialGroup()
                .addGroup(RECENT_MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RECENT_MEMBERSLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(RECENT_MEMBERSLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(new_mems)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        RECENT_MEMBERSLayout.setVerticalGroup(
            RECENT_MEMBERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RECENT_MEMBERSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(new_mems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        USERS.setBackground(new java.awt.Color(0, 163, 89));
        USERS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                USERSMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Users");

        new_mems1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        new_mems1.setForeground(new java.awt.Color(255, 255, 255));
        new_mems1.setText("0");

        javax.swing.GroupLayout USERSLayout = new javax.swing.GroupLayout(USERS);
        USERS.setLayout(USERSLayout);
        USERSLayout.setHorizontalGroup(
            USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(USERSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(new_mems1))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        USERSLayout.setVerticalGroup(
            USERSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, USERSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(new_mems1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

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
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(date)
                .addContainerGap())
        );

        name.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        name.setForeground(new java.awt.Color(51, 51, 51));
        name.setText("jLabel3");

        welcome.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(51, 51, 51));
        welcome.setText("Welcome");

        javax.swing.GroupLayout TOPBARLayout = new javax.swing.GroupLayout(TOPBAR);
        TOPBAR.setLayout(TOPBARLayout);
        TOPBARLayout.setHorizontalGroup(
            TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TOPBARLayout.createSequentialGroup()
                        .addComponent(Total_Members, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(RECENT_MEMBERS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(USERS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TOPBARLayout.createSequentialGroup()
                        .addComponent(welcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name)))
                .addGap(20, 20, 20)
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MONTHLY_INCOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        TOPBARLayout.setVerticalGroup(
            TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name)
                        .addComponent(welcome)))
                .addGap(8, 8, 8)
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Total_Members, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(USERS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MONTHLY_INCOME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RECENT_MEMBERS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(TOPBAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 24, 1080, -1));

        DynamicPanel.setBackground(new java.awt.Color(250, 250, 250));
        DynamicPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(DynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 154, 1080, 637));

        getAccessibleContext().setAccessibleName("Main menu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void Total_MembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Total_MembersMouseClicked
        Btn_All_Members a = new Btn_All_Members();
        a.setVisible(true);
    }//GEN-LAST:event_Total_MembersMouseClicked

    private void RECENT_MEMBERSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RECENT_MEMBERSMouseClicked
        Btn_Recent_Members b = new Btn_Recent_Members();
        b.setVisible(true);
    }//GEN-LAST:event_RECENT_MEMBERSMouseClicked

    private void USERSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_USERSMouseClicked
        Btn_All_Users c = new Btn_All_Users();
        c.setVisible(true);
    }//GEN-LAST:event_USERSMouseClicked

    private void MONTHLY_INCOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTHLY_INCOMEMouseClicked
        Btn_Monthly_Income d = new Btn_Monthly_Income();
        d.setVisible(true);
    }//GEN-LAST:event_MONTHLY_INCOMEMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JPanel MONTHLY_INCOME;
    private javax.swing.JPanel MONTH_REPORT;
    private javax.swing.JPanel RECENT_MEMBERS;
    private javax.swing.JPanel SIDEBAR;
    private javax.swing.JPanel TOPBAR;
    private javax.swing.JPanel Total_Members;
    private javax.swing.JPanel USERS;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel members;
    private javax.swing.JLabel monthly;
    public javax.swing.JLabel name;
    private javax.swing.JLabel new_mems;
    private javax.swing.JLabel new_mems1;
    private javax.swing.JLabel new_mems2;
    private javax.swing.JLabel total_mem;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
