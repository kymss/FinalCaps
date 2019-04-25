package fitnesscampsystem;

import DataBase.Database;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import panels.Members;

public class Add_a_Member extends javax.swing.JFrame {

    private static Add_a_Member instance = null;

    public static Add_a_Member getInstance() {
        if (instance == null) {
            instance = new Add_a_Member();
        }
        return instance;
    }

    Members m = Members.getInstance();

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dm;

    public Add_a_Member() {
        initComponents();
        con = Database.ConnectDB();
        created_at.setVisible(false);
        start.setVisible(false);
        yu.setVisible(false);
        end.setVisible(false);

        lblfname.setVisible(false);
        jLabel23.setVisible(false);
        comn.setVisible(false);
        jLabel25.setVisible(false);
        jLabel4.setVisible(false);
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void computations() {
        SimpleDateFormat datefmt = new SimpleDateFormat("MM/dd/yyyy");
        String dates = ((JTextField) start.getDateEditor().getUiComponent()).getText();
        Date date = start.getDate();
        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);

        if (month.getSelectedItem().equals("1 month")) {
            cal.add(Calendar.MONTH, 1); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("2 months")) {
            cal.add(Calendar.MONTH, 2); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("3 months")) {
            cal.add(Calendar.MONTH, 3); // Add 30 day=
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("4 months")) {
            cal.add(Calendar.MONTH, 4); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("5 months")) {
            cal.add(Calendar.MONTH, 5); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("6 months")) {
            cal.add(Calendar.MONTH, 6); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        } else if (month.getSelectedItem().equals("1 year")) {
            cal.add(Calendar.MONTH, 12); // Add 30 days
            end.setText("" + datefmt.format(cal.getTime()));
        }
    }

    public void Save() {
        if (firstnameField.getText().equals("") || lastnameField.getText().equals("")
                || sexComboBox.getSelectedItem().equals("Select") || healthconcernField.getText().equals("")
                || month.getSelectedItem().equals("Select")) {

//            JOptionPane.showMessageDialog(null, "Please fill up all the forms....");
            lblfname.setVisible(true);
            jLabel23.setVisible(true);
            comn.setVisible(true);
            jLabel25.setVisible(true);
            jLabel4.setVisible(true);

        }  if ((firstnameField.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
            lblfname.setVisible(true);
        } else if (lastnameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
            jLabel23.setVisible(true);
        } else if (sexComboBox.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
            comn.setVisible(true);
        } else if (healthconcernField.getText().trim().isEmpty()) {
            jLabel25.setVisible(true);
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (month.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Fill out the important information", "Error", JOptionPane.ERROR_MESSAGE);
            jLabel4.setVisible(true);
        } else {

            Database db = Database.getInstance();
            db.add_a_member(
                    //PersonalInformation
                    firstnameField.getText(),
                    middlenameField.getText(),
                    lastnameField.getText(),
                    sexComboBox.getSelectedItem().toString(),//comboBox
                    contactnumberField.getText(),
                    occupationField.getText(),
                    addressField.getText(),
                    hobbiesField.getText(),
                    //EmeergencyInformation
                    contactpersonField.getText(),
                    contactPersonNumberField.getText(),
                    relationshipField.getText(),
                    healthconcernField.getText(),
                    currentweightField.getText(),
                    targetweightField.getText(),
                    month.getSelectedItem().toString(),
                    ((JTextField) start.getDateEditor().getUiComponent()).getText(),
                    end.getText(),
                    ((JTextField) created_at.getDateEditor().getUiComponent()).getText(),
                    yu.getText()
            );
            clear_ops();
        }
    }

   
    public void pay() {
//        payment p = new payment();
//        p.setVisible(true);
        if (month.getSelectedItem().equals("1 month")) {
//           p.jTextField1.setText("500");
            yu.setText("500");
        } else if (month.getSelectedItem().equals("2 months")) {
//           p.jTextField1.setText("1000");
            yu.setText("1000");
        } else if (month.getSelectedItem().equals("3 months")) {
//          p.jTextField1.setText("1500");
            yu.setText("1500");
        } else if (month.getSelectedItem().equals("4 months")) {
//           p.jTextField1.setText("2000");
            yu.setText("2000");
        } else if (month.getSelectedItem().equals("5 months")) {
//           p.jTextField1.setText("2500");
            yu.setText("2500");
        } else if (month.getSelectedItem().equals("6 months")) {
//            p.jTextField1.setText("3000");
            yu.setText("3000");
        } else if (month.getSelectedItem().equals("1 year")) {
//            p.jTextField1.setText("6000");
            yu.setText("6000");
//            }
        }
    }
    
    
    
    public void clear_ops() {
                    firstnameField.setText("");
                    middlenameField.setText("");
                    lastnameField.setText("");
                    sexComboBox.setSelectedIndex(0);;
                    contactnumberField.setText("");
                    occupationField.setText("");
                    addressField.setText("");
                    hobbiesField.setText("");
                    //EmeergencyInformation
                    contactpersonField.setText("");
                    contactPersonNumberField.setText("");
                    relationshipField.setText("");
                    healthconcernField.setText("");
                    currentweightField.setText("");
                    targetweightField.setText("");
                    month.setSelectedIndex(0);
//                    ((JTextField) start.getDateEditor().getUiComponent()).getText();
                    end.setText("");
//                    ((JTextField) created_at.getDateEditor().getUiComponent()).getText();
                    yu.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        middlenameField = new javax.swing.JTextField();
        sexComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contactnumberField = new javax.swing.JTextField();
        firstnameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        hobbiesField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        contactpersonField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        contactPersonNumberField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        relationshipField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        healthconcernField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        currentweightField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        occupationField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        targetweightField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ExMember = new javax.swing.JRadioButton();
        ThruFriends = new javax.swing.JRadioButton();
        ViaPromo = new javax.swing.JRadioButton();
        JustWalkIn = new javax.swing.JRadioButton();
        Internet = new javax.swing.JRadioButton();
        CANCEL = new javax.swing.JButton();
        SAVEmem = new javax.swing.JButton();
        month = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        yu = new javax.swing.JTextField();
        end = new javax.swing.JTextField();
        lastnameField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        start = new com.toedter.calendar.JDateChooser();
        created_at = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        lblfname = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        comn = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel1.setText("Address");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 190, 60, 30);

        addressField.setBackground(new java.awt.Color(227, 229, 233));
        addressField.setForeground(new java.awt.Color(46, 46, 46));
        addressField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        addressField.setPreferredSize(new java.awt.Dimension(8, 20));
        addressField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressFieldMouseClicked(evt);
            }
        });
        jPanel1.add(addressField);
        addressField.setBounds(40, 170, 370, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Emergency Contact Information");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 240, 180, 16);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 260, 560, 10);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel5.setText("Middle name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 70, 70, 30);

        middlenameField.setBackground(new java.awt.Color(227, 229, 233));
        middlenameField.setForeground(new java.awt.Color(46, 46, 46));
        middlenameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        middlenameField.setPreferredSize(new java.awt.Dimension(8, 20));
        middlenameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                middlenameFieldMouseClicked(evt);
            }
        });
        jPanel1.add(middlenameField);
        middlenameField.setBounds(230, 50, 170, 25);

        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        sexComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sexComboBoxKeyPressed(evt);
            }
        });
        jPanel1.add(sexComboBox);
        sexComboBox.setBounds(430, 110, 120, 25);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(470, 130, 40, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel7.setText("Contact Number");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 140, 90, 15);

        contactnumberField.setBackground(new java.awt.Color(227, 229, 233));
        contactnumberField.setForeground(new java.awt.Color(46, 46, 46));
        contactnumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactnumberField.setPreferredSize(new java.awt.Dimension(8, 20));
        contactnumberField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactnumberFieldMouseClicked(evt);
            }
        });
        contactnumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactnumberFieldKeyPressed(evt);
            }
        });
        jPanel1.add(contactnumberField);
        contactnumberField.setBounds(40, 110, 180, 25);

        firstnameField.setBackground(new java.awt.Color(227, 229, 233));
        firstnameField.setForeground(new java.awt.Color(46, 46, 46));
        firstnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstnameField.setPreferredSize(new java.awt.Dimension(8, 20));
        firstnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstnameFieldMouseClicked(evt);
            }
        });
        firstnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameFieldActionPerformed(evt);
            }
        });
        firstnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnameFieldKeyPressed(evt);
            }
        });
        jPanel1.add(firstnameField);
        firstnameField.setBounds(40, 50, 180, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel8.setText("First Name");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 70, 60, 30);

        hobbiesField.setBackground(new java.awt.Color(227, 229, 233));
        hobbiesField.setForeground(new java.awt.Color(46, 46, 46));
        hobbiesField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        hobbiesField.setPreferredSize(new java.awt.Dimension(8, 20));
        hobbiesField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hobbiesFieldMouseClicked(evt);
            }
        });
        jPanel1.add(hobbiesField);
        hobbiesField.setBounds(430, 170, 120, 25);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel9.setText("Hobbies");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(470, 190, 60, 30);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(20, 30, 560, 10);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Personal Information");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 10, 120, 16);

        contactpersonField.setBackground(new java.awt.Color(227, 229, 233));
        contactpersonField.setForeground(new java.awt.Color(46, 46, 46));
        contactpersonField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactpersonField.setPreferredSize(new java.awt.Dimension(8, 20));
        contactpersonField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactpersonFieldMouseClicked(evt);
            }
        });
        jPanel1.add(contactpersonField);
        contactpersonField.setBounds(40, 280, 170, 25);

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel11.setText("Contact Person");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(90, 300, 80, 30);

        contactPersonNumberField.setBackground(new java.awt.Color(227, 229, 233));
        contactPersonNumberField.setForeground(new java.awt.Color(46, 46, 46));
        contactPersonNumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactPersonNumberField.setPreferredSize(new java.awt.Dimension(8, 20));
        contactPersonNumberField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactPersonNumberFieldMouseClicked(evt);
            }
        });
        contactPersonNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactPersonNumberFieldKeyPressed(evt);
            }
        });
        jPanel1.add(contactPersonNumberField);
        contactPersonNumberField.setBounds(220, 280, 170, 25);

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel12.setText("Contact Number");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(260, 300, 80, 30);

        relationshipField.setBackground(new java.awt.Color(227, 229, 233));
        relationshipField.setForeground(new java.awt.Color(46, 46, 46));
        relationshipField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        relationshipField.setPreferredSize(new java.awt.Dimension(8, 20));
        relationshipField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relationshipFieldMouseClicked(evt);
            }
        });
        jPanel1.add(relationshipField);
        relationshipField.setBounds(400, 280, 170, 25);

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel13.setText("Relationship");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(460, 300, 60, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel14.setText("Health Concern");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(180, 360, 80, 30);

        healthconcernField.setBackground(new java.awt.Color(227, 229, 233));
        healthconcernField.setForeground(new java.awt.Color(46, 46, 46));
        healthconcernField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        healthconcernField.setPreferredSize(new java.awt.Dimension(8, 20));
        healthconcernField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                healthconcernFieldMouseClicked(evt);
            }
        });
        healthconcernField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                healthconcernFieldKeyPressed(evt);
            }
        });
        jPanel1.add(healthconcernField);
        healthconcernField.setBounds(40, 340, 350, 25);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Additional Information");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(40, 410, 180, 16);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(20, 430, 560, 10);

        currentweightField.setBackground(new java.awt.Color(227, 229, 233));
        currentweightField.setForeground(new java.awt.Color(46, 46, 46));
        currentweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        currentweightField.setPreferredSize(new java.awt.Dimension(8, 20));
        currentweightField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentweightFieldMouseClicked(evt);
            }
        });
        jPanel1.add(currentweightField);
        currentweightField.setBounds(40, 450, 120, 25);

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel16.setText("How did you know about us?");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(40, 510, 150, 30);

        occupationField.setBackground(new java.awt.Color(227, 229, 233));
        occupationField.setForeground(new java.awt.Color(46, 46, 46));
        occupationField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        occupationField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(occupationField);
        occupationField.setBounds(230, 110, 180, 25);

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel17.setText("Occupation");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(280, 130, 60, 30);

        targetweightField.setBackground(new java.awt.Color(227, 229, 233));
        targetweightField.setForeground(new java.awt.Color(46, 46, 46));
        targetweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        targetweightField.setPreferredSize(new java.awt.Dimension(8, 20));
        targetweightField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                targetweightFieldMouseClicked(evt);
            }
        });
        jPanel1.add(targetweightField);
        targetweightField.setBounds(180, 450, 120, 25);

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel18.setText("Membership");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(380, 470, 80, 30);

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel19.setText("Current Weight");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(60, 470, 80, 30);

        ExMember.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ExMember);
        ExMember.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        ExMember.setText("Ex-Member");
        jPanel1.add(ExMember);
        ExMember.setBounds(420, 540, 93, 23);

        ThruFriends.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ThruFriends);
        ThruFriends.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        ThruFriends.setText("Thru Friends");
        jPanel1.add(ThruFriends);
        ThruFriends.setBounds(90, 540, 83, 23);

        ViaPromo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ViaPromo);
        ViaPromo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        ViaPromo.setText("Via Promo");
        jPanel1.add(ViaPromo);
        ViaPromo.setBounds(180, 540, 80, 23);

        JustWalkIn.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JustWalkIn);
        JustWalkIn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        JustWalkIn.setText("Just walk-in");
        jPanel1.add(JustWalkIn);
        JustWalkIn.setBounds(260, 540, 90, 23);

        Internet.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Internet);
        Internet.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        Internet.setText("Internet");
        jPanel1.add(Internet);
        Internet.setBounds(350, 540, 70, 23);

        CANCEL.setText("Cancel");
        CANCEL.setContentAreaFilled(false);
        CANCEL.setOpaque(true);
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });
        jPanel1.add(CANCEL);
        CANCEL.setBounds(110, 590, 170, 30);

        SAVEmem.setBackground(new java.awt.Color(48, 173, 95));
        SAVEmem.setForeground(new java.awt.Color(255, 255, 255));
        SAVEmem.setText("Save");
        SAVEmem.setContentAreaFilled(false);
        SAVEmem.setOpaque(true);
        SAVEmem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEmemActionPerformed(evt);
            }
        });
        jPanel1.add(SAVEmem);
        SAVEmem.setBounds(320, 590, 170, 30);

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "1 year" }));
        month.setToolTipText("");
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        month.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                monthKeyPressed(evt);
            }
        });
        jPanel1.add(month);
        month.setBounds(320, 450, 170, 25);

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel20.setText("Target Weight");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(200, 470, 80, 30);
        jPanel1.add(yu);
        yu.setBounds(490, 490, 90, 20);

        end.setEditable(false);
        jPanel1.add(end);
        end.setBounds(490, 520, 90, 20);

        lastnameField.setBackground(new java.awt.Color(227, 229, 233));
        lastnameField.setForeground(new java.awt.Color(46, 46, 46));
        lastnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lastnameField.setPreferredSize(new java.awt.Dimension(8, 20));
        lastnameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastnameFieldMouseClicked(evt);
            }
        });
        lastnameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastnameFieldKeyPressed(evt);
            }
        });
        jPanel1.add(lastnameField);
        lastnameField.setBounds(410, 50, 160, 25);

        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel21.setText("Last Name");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(470, 70, 60, 30);

        start.setDateFormatString("YYYY-MM-dd");
        jPanel1.add(start);
        start.setBounds(440, 370, 89, 20);

        created_at.setDateFormatString("YYYY-MM-dd");
        jPanel1.add(created_at);
        created_at.setBounds(440, 340, 89, 20);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText(" *");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(310, 450, 10, 20);

        lblfname.setBackground(new java.awt.Color(255, 255, 255));
        lblfname.setForeground(new java.awt.Color(255, 0, 0));
        lblfname.setText("*");
        jPanel1.add(lblfname);
        lblfname.setBounds(30, 50, 10, 20);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText(" *");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(400, 50, 10, 20);

        comn.setBackground(new java.awt.Color(255, 255, 255));
        comn.setForeground(new java.awt.Color(255, 0, 0));
        comn.setText(" *");
        jPanel1.add(comn);
        comn.setBounds(420, 110, 10, 20);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText(" *");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(30, 340, 10, 20);

        jPanel2.setBackground(new java.awt.Color(48, 173, 95));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enthusiast's Profile");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(230, 10, 130, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addressFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressFieldMouseClicked

    }//GEN-LAST:event_addressFieldMouseClicked

    private void middlenameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_middlenameFieldMouseClicked

    }//GEN-LAST:event_middlenameFieldMouseClicked

    private void contactnumberFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactnumberFieldMouseClicked

    }//GEN-LAST:event_contactnumberFieldMouseClicked

    private void firstnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstnameFieldMouseClicked

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        start.setDate(date);
        created_at.setDate(date);
    }//GEN-LAST:event_firstnameFieldMouseClicked

    private void hobbiesFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hobbiesFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hobbiesFieldMouseClicked

    private void contactpersonFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpersonFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_contactpersonFieldMouseClicked

    private void contactPersonNumberFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactPersonNumberFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_contactPersonNumberFieldMouseClicked

    private void relationshipFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relationshipFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_relationshipFieldMouseClicked

    private void healthconcernFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_healthconcernFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_healthconcernFieldMouseClicked

    private void currentweightFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentweightFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_currentweightFieldMouseClicked

    private void targetweightFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_targetweightFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_targetweightFieldMouseClicked

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        computations();
        pay();

    }//GEN-LAST:event_monthActionPerformed

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        this.setDefaultCloseOperation(Main_Frame_Admin.DISPOSE_ON_CLOSE);
        close();

        Main_Frame_Admin mf = Main_Frame_Admin.getInstance();
        mf.setEnabled(true);

        Members m = Members.getInstance();
        m.Table_view();

//            Members o = Members.getInstance();              
//                o.Table_view();
    }//GEN-LAST:event_CANCELActionPerformed

    private void SAVEmemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEmemActionPerformed
//        payment i = new payment();
//        i.setVisible(true);  
        Save();


    }//GEN-LAST:event_SAVEmemActionPerformed

    private void lastnameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnameFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameFieldMouseClicked

    private void contactnumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactnumberFieldKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE) {
            contactnumberField.setEditable(true);
            contactnumberField.setBackground(Color.yellow);
        } else {
            contactnumberField.setEditable(false);
        }
        contactnumberField.setBackground(Color.white);
    }//GEN-LAST:event_contactnumberFieldKeyPressed

    private void contactPersonNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactPersonNumberFieldKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE) {
            contactPersonNumberField.setEditable(true);
            contactPersonNumberField.setBackground(Color.yellow);
        } else {
            contactPersonNumberField.setEditable(false);
        }
        contactPersonNumberField.setBackground(Color.white);
    }//GEN-LAST:event_contactPersonNumberFieldKeyPressed

    private void firstnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameFieldActionPerformed

    private void firstnameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameFieldKeyPressed
        lblfname.setVisible(false);

    }//GEN-LAST:event_firstnameFieldKeyPressed

    private void lastnameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameFieldKeyPressed

        jLabel23.setVisible(false);

    }//GEN-LAST:event_lastnameFieldKeyPressed

    private void sexComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sexComboBoxKeyPressed

        comn.setVisible(false);

    }//GEN-LAST:event_sexComboBoxKeyPressed

    private void healthconcernFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_healthconcernFieldKeyPressed
        jLabel25.setVisible(false);
    }//GEN-LAST:event_healthconcernFieldKeyPressed

    private void monthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthKeyPressed
        jLabel4.setVisible(false);
    }//GEN-LAST:event_monthKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Add_a_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_a_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_a_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_a_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_a_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCEL;
    private javax.swing.JRadioButton ExMember;
    private javax.swing.JRadioButton Internet;
    private javax.swing.JRadioButton JustWalkIn;
    public javax.swing.JButton SAVEmem;
    private javax.swing.JRadioButton ThruFriends;
    private javax.swing.JRadioButton ViaPromo;
    public javax.swing.JTextField addressField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel comn;
    public javax.swing.JTextField contactPersonNumberField;
    public javax.swing.JTextField contactnumberField;
    public javax.swing.JTextField contactpersonField;
    private com.toedter.calendar.JDateChooser created_at;
    public javax.swing.JTextField currentweightField;
    public javax.swing.JTextField end;
    public javax.swing.JTextField firstnameField;
    public javax.swing.JTextField healthconcernField;
    public javax.swing.JTextField hobbiesField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JTextField lastnameField;
    private javax.swing.JLabel lblfname;
    public javax.swing.JTextField middlenameField;
    public javax.swing.JComboBox month;
    public javax.swing.JTextField occupationField;
    public javax.swing.JTextField relationshipField;
    public javax.swing.JComboBox<String> sexComboBox;
    private com.toedter.calendar.JDateChooser start;
    public javax.swing.JTextField targetweightField;
    public javax.swing.JTextField yu;
    // End of variables declaration//GEN-END:variables
}
