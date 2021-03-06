package fitnesscampsystem;

import DataBase.DataBaseLogs;
import DataBase.Database;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import panels.DASHBOARD;
import panels.Monthly_Reports;
import panels.Members;
import panels.ADD_USER;
import panels.AttendanceMembers;
import panels.Walk_In;

public class Main_Frame_Admin extends javax.swing.JFrame {

    private static Main_Frame_Admin instance = null;

    public static Main_Frame_Admin getInstance() {
        if (instance == null) {
            instance = new Main_Frame_Admin();
        }
        return instance;
    }

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    GridBagLayout layout = new GridBagLayout();
    DASHBOARD p1;
    Members p2;
    ADD_USER p3;
    Monthly_Reports p4;
    AttendanceMembers p5;
    Walk_In p6;

    public Main_Frame_Admin() {
        initComponents();
        
        con = Database.ConnectDB();
        log();
        ShowDate();
        ShowTime();
//        id.setVisible(false);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = new Dimension(tk.getScreenSize());
        int height = (int) dim.getHeight();
        int width = (int) dim.getWidth();

        setSize(width, height);

        p1 = new DASHBOARD();
        p2 = new Members();
        p3 = new ADD_USER();
        p4 = new Monthly_Reports();
        p5 = new AttendanceMembers();
        p6 = new Walk_In();

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

        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p5, c);

        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(p6, c);

        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);

        if (p1.isVisible()) {
            DASHBOARD_BTN.setBackground(new Color(20, 31, 42));
        } else {
            DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
        }
    }
    
    
    public void log(){
        if(this.isVisible()){
//            DataBaseLogs dbl = DataBaseLogs.getInstance();
//            dbl.userLoggedIn();
        }
    }
   

    public void exclusive() {
//        role.getText();
//        String user = "User";

        if (USER_ID.getText().equals("Admin")) {
            ADD_USER.setVisible(true);
        } else {
            ADD_USER.setVisible(false);

        }
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    void ShowDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
        date.setText(s.format(d));
    }

    void ShowTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                time.setText(s.format(d));
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SIDEBAR = new javax.swing.JPanel();
        DASHBOARD_BTN = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        REGISTER_BTN = new javax.swing.JPanel();
        members = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ADD_USER = new javax.swing.JPanel();
        adduser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MONTH_REPORT = new javax.swing.JPanel();
        monthly = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JPanel();
        LOG = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ATTENDANCE = new javax.swing.JPanel();
        adduser3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pass = new javax.swing.JPanel();
        adduser1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        WALK_IN = new javax.swing.JPanel();
        as = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TOPBAR = new javax.swing.JPanel();
        skl = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        USER_ID = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        USERNAME = new javax.swing.JLabel();
        log_description = new javax.swing.JLabel();
        DynamicPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        SIDEBAR.setBackground(new java.awt.Color(16, 22, 28));
        SIDEBAR.setLayout(null);

        DASHBOARD_BTN.setBackground(new java.awt.Color(16, 22, 28));
        DASHBOARD_BTN.setPreferredSize(new java.awt.Dimension(214, 60));
        DASHBOARD_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DASHBOARD_BTNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DASHBOARD_BTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DASHBOARD_BTNMouseExited(evt);
            }
        });

        dashboard.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setText("DASHBOARD");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11.png"))); // NOI18N

        javax.swing.GroupLayout DASHBOARD_BTNLayout = new javax.swing.GroupLayout(DASHBOARD_BTN);
        DASHBOARD_BTN.setLayout(DASHBOARD_BTNLayout);
        DASHBOARD_BTNLayout.setHorizontalGroup(
            DASHBOARD_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARD_BTNLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        DASHBOARD_BTNLayout.setVerticalGroup(
            DASHBOARD_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DASHBOARD_BTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DASHBOARD_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        SIDEBAR.add(DASHBOARD_BTN);
        DASHBOARD_BTN.setBounds(0, 160, 250, 50);

        REGISTER_BTN.setBackground(new java.awt.Color(16, 22, 28));
        REGISTER_BTN.setPreferredSize(new java.awt.Dimension(214, 60));
        REGISTER_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REGISTER_BTNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                REGISTER_BTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                REGISTER_BTNMouseExited(evt);
            }
        });

        members.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        members.setForeground(new java.awt.Color(255, 255, 255));
        members.setText("MEMBERS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.png"))); // NOI18N

        javax.swing.GroupLayout REGISTER_BTNLayout = new javax.swing.GroupLayout(REGISTER_BTN);
        REGISTER_BTN.setLayout(REGISTER_BTNLayout);
        REGISTER_BTNLayout.setHorizontalGroup(
            REGISTER_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, REGISTER_BTNLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(members, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        REGISTER_BTNLayout.setVerticalGroup(
            REGISTER_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, REGISTER_BTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(REGISTER_BTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(members, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        SIDEBAR.add(REGISTER_BTN);
        REGISTER_BTN.setBounds(0, 210, 250, 50);

        ADD_USER.setBackground(new java.awt.Color(16, 22, 28));
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
        adduser.setText("USER ACCOUNTS");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/10.png"))); // NOI18N

        javax.swing.GroupLayout ADD_USERLayout = new javax.swing.GroupLayout(ADD_USER);
        ADD_USER.setLayout(ADD_USERLayout);
        ADD_USERLayout.setHorizontalGroup(
            ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ADD_USERLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adduser)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        ADD_USERLayout.setVerticalGroup(
            ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ADD_USERLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ADD_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adduser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SIDEBAR.add(ADD_USER);
        ADD_USER.setBounds(0, 620, 250, 50);

        MONTH_REPORT.setBackground(new java.awt.Color(16, 22, 28));
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
        monthly.setText("MONTHLY REPORT");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/13.png"))); // NOI18N

        javax.swing.GroupLayout MONTH_REPORTLayout = new javax.swing.GroupLayout(MONTH_REPORT);
        MONTH_REPORT.setLayout(MONTH_REPORTLayout);
        MONTH_REPORTLayout.setHorizontalGroup(
            MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MONTH_REPORTLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monthly, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        MONTH_REPORTLayout.setVerticalGroup(
            MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MONTH_REPORTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MONTH_REPORTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monthly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SIDEBAR.add(MONTH_REPORT);
        MONTH_REPORT.setBounds(0, 360, 250, 50);

        LOGOUT.setBackground(new java.awt.Color(16, 22, 28));
        LOGOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGOUTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGOUTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGOUTMouseExited(evt);
            }
        });

        LOG.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        LOG.setForeground(new java.awt.Color(255, 255, 255));
        LOG.setText("LOGOUT");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16.png"))); // NOI18N

        javax.swing.GroupLayout LOGOUTLayout = new javax.swing.GroupLayout(LOGOUT);
        LOGOUT.setLayout(LOGOUTLayout);
        LOGOUTLayout.setHorizontalGroup(
            LOGOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGOUTLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LOG, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        LOGOUTLayout.setVerticalGroup(
            LOGOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGOUTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LOGOUTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LOG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SIDEBAR.add(LOGOUT);
        LOGOUT.setBounds(0, 670, 250, 50);

        ATTENDANCE.setBackground(new java.awt.Color(16, 22, 28));
        ATTENDANCE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ATTENDANCEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ATTENDANCEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ATTENDANCEMouseExited(evt);
            }
        });

        adduser3.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        adduser3.setForeground(new java.awt.Color(255, 255, 255));
        adduser3.setText("ATTENDANCE");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.png"))); // NOI18N

        javax.swing.GroupLayout ATTENDANCELayout = new javax.swing.GroupLayout(ATTENDANCE);
        ATTENDANCE.setLayout(ATTENDANCELayout);
        ATTENDANCELayout.setHorizontalGroup(
            ATTENDANCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ATTENDANCELayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adduser3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        ATTENDANCELayout.setVerticalGroup(
            ATTENDANCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ATTENDANCELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ATTENDANCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adduser3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SIDEBAR.add(ATTENDANCE);
        ATTENDANCE.setBounds(0, 310, 250, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.png"))); // NOI18N
        SIDEBAR.add(jLabel9);
        jLabel9.setBounds(0, -20, 250, 190);

        pass.setBackground(new java.awt.Color(16, 22, 28));
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passMouseExited(evt);
            }
        });

        adduser1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        adduser1.setForeground(new java.awt.Color(255, 255, 255));
        adduser1.setText("CHANGE PASSWORD");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/14.png"))); // NOI18N

        javax.swing.GroupLayout passLayout = new javax.swing.GroupLayout(pass);
        pass.setLayout(passLayout);
        passLayout.setHorizontalGroup(
            passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adduser1)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        passLayout.setVerticalGroup(
            passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adduser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SIDEBAR.add(pass);
        pass.setBounds(0, 570, 250, 50);

        WALK_IN.setBackground(new java.awt.Color(16, 22, 28));
        WALK_IN.setPreferredSize(new java.awt.Dimension(214, 60));
        WALK_IN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WALK_INMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                WALK_INMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                WALK_INMouseExited(evt);
            }
        });

        as.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        as.setForeground(new java.awt.Color(255, 255, 255));
        as.setText("WALK IN");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.png"))); // NOI18N

        javax.swing.GroupLayout WALK_INLayout = new javax.swing.GroupLayout(WALK_IN);
        WALK_IN.setLayout(WALK_INLayout);
        WALK_INLayout.setHorizontalGroup(
            WALK_INLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WALK_INLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(as, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        WALK_INLayout.setVerticalGroup(
            WALK_INLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WALK_INLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WALK_INLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(as, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SIDEBAR.add(WALK_IN);
        WALK_IN.setBounds(0, 260, 250, 50);

        getContentPane().add(SIDEBAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 250, 770));

        TOPBAR.setBackground(new java.awt.Color(16, 22, 28));

        skl.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        skl.setForeground(new java.awt.Color(255, 255, 255));
        skl.setText("jLabel3");

        welcome.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setText("Welcome");

        USER_ID.setForeground(new java.awt.Color(255, 255, 255));
        USER_ID.setText("userid");

        date.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 24)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("jLabel2");

        time.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("jLabel2");

        USERNAME.setForeground(new java.awt.Color(255, 255, 255));
        USERNAME.setText("username");

        log_description.setForeground(new java.awt.Color(255, 255, 255));
        log_description.setText("Logged in");

        javax.swing.GroupLayout TOPBARLayout = new javax.swing.GroupLayout(TOPBAR);
        TOPBAR.setLayout(TOPBARLayout);
        TOPBARLayout.setHorizontalGroup(
            TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(skl)
                .addGap(200, 200, 200)
                .addComponent(log_description)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TOPBARLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(USER_ID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(USERNAME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                .addComponent(date)
                .addGap(18, 18, 18)
                .addComponent(time)
                .addGap(66, 66, 66))
        );
        TOPBARLayout.setVerticalGroup(
            TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USER_ID)
                    .addComponent(USERNAME))
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TOPBARLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(welcome)
                            .addComponent(skl)))
                    .addGroup(TOPBARLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(log_description)))
                .addContainerGap())
            .addGroup(TOPBARLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TOPBARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date)
                    .addComponent(time))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(TOPBAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 24, 1120, 110));

        DynamicPanel.setBackground(new java.awt.Color(255, 255, 255));
        DynamicPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(DynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 1120, 660));

        getAccessibleContext().setAccessibleName("Main menu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DASHBOARD_BTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOARD_BTNMouseEntered
        DASHBOARD_BTN.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_DASHBOARD_BTNMouseEntered

    private void REGISTER_BTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REGISTER_BTNMouseEntered
        REGISTER_BTN.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_REGISTER_BTNMouseEntered

    private void ADD_USERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_USERMouseEntered
        ADD_USER.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_ADD_USERMouseEntered

    private void MONTH_REPORTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTH_REPORTMouseEntered
        MONTH_REPORT.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_MONTH_REPORTMouseEntered

    private void DASHBOARD_BTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOARD_BTNMouseExited
        DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
        if (p1.isVisible()) {
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
            DASHBOARD_BTN.setBackground(new Color(20, 31, 42));
            ADD_USER.setBackground(new Color(16, 22, 28));
            MONTH_REPORT.setBackground(new Color(16, 22, 28));
            ATTENDANCE.setBackground(new Color(16, 22, 28));
            WALK_IN.setBackground(new Color(16, 22, 28));
        } else {
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
        }
    }//GEN-LAST:event_DASHBOARD_BTNMouseExited

    private void REGISTER_BTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REGISTER_BTNMouseExited
        REGISTER_BTN.setBackground(new Color(16, 22, 28));

        if (p2.isVisible()) {
            REGISTER_BTN.setBackground(new Color(20, 31, 42));
            DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
            ADD_USER.setBackground(new Color(16, 22, 28));
            MONTH_REPORT.setBackground(new Color(16, 22, 28));
            ATTENDANCE.setBackground(new Color(16, 22, 28));
            WALK_IN.setBackground(new Color(16, 22, 28));
        } else {
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
        }
    }//GEN-LAST:event_REGISTER_BTNMouseExited

    private void ADD_USERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_USERMouseExited
        ADD_USER.setBackground(new Color(16, 22, 28));

        if (p3.isVisible()) {
            ADD_USER.setBackground(new Color(20, 31, 42));
            DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
            MONTH_REPORT.setBackground(new Color(16, 22, 28));
            ATTENDANCE.setBackground(new Color(16, 22, 28));
            WALK_IN.setBackground(new Color(16, 22, 28));
        } else {
            ADD_USER.setBackground(new Color(16, 22, 28));
        }
    }//GEN-LAST:event_ADD_USERMouseExited

    private void MONTH_REPORTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTH_REPORTMouseExited
        MONTH_REPORT.setBackground(new Color(16, 22, 28));

        if (p4.isVisible()) {
            ADD_USER.setBackground(new Color(16, 22, 28));
            DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
            MONTH_REPORT.setBackground(new Color(20, 31, 42));
            ATTENDANCE.setBackground(new Color(16, 22, 28));
            WALK_IN.setBackground(new Color(16, 22, 28));
        } else {
            ADD_USER.setBackground(new Color(16, 22, 28));
        }
    }//GEN-LAST:event_MONTH_REPORTMouseExited

    private void DASHBOARD_BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DASHBOARD_BTNMouseClicked
//        LBL_DASHBOARD.setBackground(new Color(255, 255, 255));
//
//        LBL_MEMBERS.setBackground(new Color(51, 51, 51));
//        LBL_ADD_USER.setBackground(new Color(51, 51, 51));
//        LBL_MonthlyReports.setBackground(new Color(51, 51, 51));

        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);

    }//GEN-LAST:event_DASHBOARD_BTNMouseClicked

    private void REGISTER_BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REGISTER_BTNMouseClicked
//        LBL_MEMBERS.setBackground(new Color(255, 255, 255));
//
//        LBL_DASHBOARD.setBackground(new Color(51, 51, 51));
//        LBL_ADD_USER.setBackground(new Color(51, 51, 51));
//        LBL_MonthlyReports.setBackground(new Color(51, 51, 51));

        p1.setVisible(false);
        p2.setVisible(true);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
    }//GEN-LAST:event_REGISTER_BTNMouseClicked

    private void ADD_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADD_USERMouseClicked
//        LBL_ADD_USER.setBackground(new Color(255, 255, 255));
//
//        LBL_DASHBOARD.setBackground(new Color(51, 51, 51));
//        LBL_MEMBERS.setBackground(new Color(51, 51, 51));
//        LBL_MonthlyReports.setBackground(new Color(51, 51, 51));

        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(true);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(false);
    }//GEN-LAST:event_ADD_USERMouseClicked

    private void MONTH_REPORTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MONTH_REPORTMouseClicked
//        LBL_MonthlyReports.setBackground(new Color(255, 255, 255));
//
//        LBL_DASHBOARD.setBackground(new Color(51, 51, 51));
//        LBL_MEMBERS.setBackground(new Color(51, 51, 51));
//        LBL_ADD_USER.setBackground(new Color(51, 51, 51));

        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(true);
        p5.setVisible(false);
        p6.setVisible(false);
    }//GEN-LAST:event_MONTH_REPORTMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jButton2MouseClicked

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked

        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to log out?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            close();
            Log_in lo = new Log_in();
            lo.setVisible(true);
        }
    }//GEN-LAST:event_LOGOUTMouseClicked

    private void LOGOUTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseEntered
        LOGOUT.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_LOGOUTMouseEntered

    private void LOGOUTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseExited
        LOGOUT.setBackground(new Color(16, 22, 28));

    }//GEN-LAST:event_LOGOUTMouseExited

    private void ATTENDANCEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ATTENDANCEMouseClicked
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(true);
        p6.setVisible(false);
    }//GEN-LAST:event_ATTENDANCEMouseClicked

    private void ATTENDANCEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ATTENDANCEMouseEntered
        ATTENDANCE.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_ATTENDANCEMouseEntered

    private void ATTENDANCEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ATTENDANCEMouseExited
        ATTENDANCE.setBackground(new Color(16, 22, 28));

        if (p5.isVisible()) {
            ADD_USER.setBackground(new Color(16, 22, 28));
            DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
            MONTH_REPORT.setBackground(new Color(16, 22, 28));
            ATTENDANCE.setBackground(new Color(20, 31, 42));
            WALK_IN.setBackground(new Color(16, 22, 28));
        } else {
            ATTENDANCE.setBackground(new Color(16, 22, 28));
        }
    }//GEN-LAST:event_ATTENDANCEMouseExited

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        changepass cp = changepass.getInstance();
        cp.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_passMouseClicked

    private void passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseEntered
        pass.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_passMouseEntered

    private void passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseExited

    }//GEN-LAST:event_passMouseExited

    private void WALK_INMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WALK_INMouseClicked
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);
        p6.setVisible(true);
    }//GEN-LAST:event_WALK_INMouseClicked

    private void WALK_INMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WALK_INMouseEntered
        WALK_IN.setBackground(new Color(20, 31, 42));
    }//GEN-LAST:event_WALK_INMouseEntered

    private void WALK_INMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WALK_INMouseExited
        ATTENDANCE.setBackground(new Color(16, 22, 28));

        if (p6.isVisible()) {
            ADD_USER.setBackground(new Color(16, 22, 28));
            DASHBOARD_BTN.setBackground(new Color(16, 22, 28));
            REGISTER_BTN.setBackground(new Color(16, 22, 28));
            MONTH_REPORT.setBackground(new Color(16, 22, 28));
            ATTENDANCE.setBackground(new Color(16, 22, 28));
            WALK_IN.setBackground(new Color(20, 31, 42));
        } else {
            WALK_IN.setBackground(new Color(16, 22, 28));
        }
    }//GEN-LAST:event_WALK_INMouseExited

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
    public javax.swing.JPanel ADD_USER;
    public javax.swing.JPanel ATTENDANCE;
    private javax.swing.JPanel DASHBOARD_BTN;
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JLabel LOG;
    public javax.swing.JPanel LOGOUT;
    private javax.swing.JPanel MONTH_REPORT;
    private javax.swing.JPanel REGISTER_BTN;
    private javax.swing.JPanel SIDEBAR;
    private javax.swing.JPanel TOPBAR;
    public javax.swing.JLabel USERNAME;
    public javax.swing.JLabel USER_ID;
    private javax.swing.JPanel WALK_IN;
    private javax.swing.JLabel adduser;
    private javax.swing.JLabel adduser1;
    private javax.swing.JLabel adduser3;
    private javax.swing.JLabel as;
    private javax.swing.JLabel dashboard;
    public javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel log_description;
    private javax.swing.JLabel members;
    private javax.swing.JLabel monthly;
    public javax.swing.JPanel pass;
    public javax.swing.JLabel skl;
    public javax.swing.JLabel time;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
