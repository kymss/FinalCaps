
package fitnesscampsystem;

import DataBase.Database;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import panels.Members;

public class Update_Member extends javax.swing.JFrame {
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
//    static String setFirstname = "";
    
    private static Update_Member instance = null;    
    public static Update_Member getInstance() {
      if(instance == null) {
         instance = new Update_Member();
      }
      return instance;
    }
    
    
    public Update_Member() {
        initComponents();
        con = Database.ConnectDB();
    }
    
     public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    public void setText(String members_id, String mfirstName, String mmiddleName, String mlastName, String gender, String ContactNumber,
            String Occupation, String address, String Hobbies, String Contactperson, String ContactPersonNo, String Relationship, String Healthconcern, 
            String Currentweight, String Targetweight, String Membership){
        Members m = Members.getInstance();
        
        aydi.setText(members_id);
        firstnameField.setText(mfirstName);
        middlenameField.setText(mmiddleName);
        lastnameField.setText(mlastName);
        sexComboBox.setSelectedItem(gender);
        contactnumberField.setText(ContactNumber);
        occupationField.setText(Occupation);
        addressField.setText(address);
        hobbiesField.setText(Hobbies);
        relationshipField.setText(Relationship);
        healthconcernField.setText(Healthconcern);
        contactpersonField.setText(Contactperson);
        contactPersonNumberField.setText(ContactPersonNo);
        currentweightField.setText(Currentweight);
        targetweightField.setText(Targetweight);
        month.setSelectedItem(Membership);
    }
    
//    public void updateUser( String firstNamex, String middleNamex, String lastNamex, String genderx, String Contactnumberx,
//            String Occupationx, String addressx, String Hobbiesx, String Contactpersonx, String ContactPersonNox, String Relationshipx, String Healthconcernx, 
//            String Currentweightx, String Targetweightx, String members_idx){
//
//        String sql = "UPDATE Members_Tbl SET mfirstName = ? , mmiddleName = ?, mlastName = ?, gender = ?, ContactNumber = ?  "
//                    +"Occupation = ? , address = ?, Hobbies = ?, Contactperson = ?"
//                    +"ContactPersonNo = ?, Relationship = ?,Healthconcern = ? ,Currentweight = ? , Targetweight = ? WHERE members_id = ?";
// 
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            // set the corresponding param
//            pstmt.setString(1, firstNamex);
//            pstmt.setString(2, middleNamex);
//            pstmt.setString(3, lastNamex);
//            pstmt.setString(4, genderx);
//            pstmt.setString(5, Contactnumberx);
//            pstmt.setString(6, Occupationx);
//            pstmt.setString(7, addressx);
//            pstmt.setString(8, Hobbiesx);
//            pstmt.setString(9, Contactpersonx);
//            pstmt.setString(10, ContactPersonNox);
//            pstmt.setString(11, Relationshipx);
//            pstmt.setString(12, Healthconcernx);
//            pstmt.setString(13, Currentweightx);
//            pstmt.setString(14, Targetweightx);
//            pstmt.setString(15, members_idx);
//            // update
//            pstmt.executeUpdate();
//            JOptionPane.showMessageDialog(null,""+firstNamex+" successfuly updated");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        UPDATE = new javax.swing.JButton();
        month = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        lastnameField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        aydi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel1.setText("Address");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 210, 60, 30);

        addressField.setBackground(new java.awt.Color(227, 229, 233));
        addressField.setForeground(new java.awt.Color(46, 46, 46));
        addressField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        addressField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(addressField);
        addressField.setBounds(40, 190, 370, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Emergency Contact Information");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 260, 180, 16);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 280, 560, 10);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel5.setText("Middle name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 90, 70, 30);

        middlenameField.setBackground(new java.awt.Color(227, 229, 233));
        middlenameField.setForeground(new java.awt.Color(46, 46, 46));
        middlenameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        middlenameField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(middlenameField);
        middlenameField.setBounds(230, 70, 170, 25);

        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        jPanel1.add(sexComboBox);
        sexComboBox.setBounds(430, 130, 120, 25);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(470, 150, 40, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel7.setText("Contact Number");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 160, 90, 15);

        contactnumberField.setBackground(new java.awt.Color(227, 229, 233));
        contactnumberField.setForeground(new java.awt.Color(46, 46, 46));
        contactnumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactnumberField.setPreferredSize(new java.awt.Dimension(8, 20));
        contactnumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactnumberFieldKeyPressed(evt);
            }
        });
        jPanel1.add(contactnumberField);
        contactnumberField.setBounds(40, 130, 180, 25);

        firstnameField.setBackground(new java.awt.Color(227, 229, 233));
        firstnameField.setForeground(new java.awt.Color(46, 46, 46));
        firstnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstnameField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(firstnameField);
        firstnameField.setBounds(40, 70, 180, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel8.setText("First Name");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 90, 60, 30);

        hobbiesField.setBackground(new java.awt.Color(227, 229, 233));
        hobbiesField.setForeground(new java.awt.Color(46, 46, 46));
        hobbiesField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        hobbiesField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(hobbiesField);
        hobbiesField.setBounds(430, 190, 120, 25);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel9.setText("Hobbies");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(470, 210, 60, 30);
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
        jPanel1.add(contactpersonField);
        contactpersonField.setBounds(40, 300, 170, 25);

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel11.setText("Contact Person");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(90, 320, 80, 30);

        contactPersonNumberField.setBackground(new java.awt.Color(227, 229, 233));
        contactPersonNumberField.setForeground(new java.awt.Color(46, 46, 46));
        contactPersonNumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        contactPersonNumberField.setPreferredSize(new java.awt.Dimension(8, 20));
        contactPersonNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactPersonNumberFieldKeyPressed(evt);
            }
        });
        jPanel1.add(contactPersonNumberField);
        contactPersonNumberField.setBounds(220, 300, 170, 25);

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel12.setText("Contact Number");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(260, 320, 80, 30);

        relationshipField.setBackground(new java.awt.Color(227, 229, 233));
        relationshipField.setForeground(new java.awt.Color(46, 46, 46));
        relationshipField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        relationshipField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(relationshipField);
        relationshipField.setBounds(400, 300, 170, 25);

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel13.setText("Relationship");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(460, 320, 60, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel14.setText("Health Concern");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(180, 380, 80, 30);

        healthconcernField.setBackground(new java.awt.Color(227, 229, 233));
        healthconcernField.setForeground(new java.awt.Color(46, 46, 46));
        healthconcernField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        healthconcernField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(healthconcernField);
        healthconcernField.setBounds(40, 360, 350, 25);

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
        occupationField.setBounds(230, 130, 180, 25);

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel17.setText("Occupation");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(280, 150, 60, 30);

        targetweightField.setBackground(new java.awt.Color(227, 229, 233));
        targetweightField.setForeground(new java.awt.Color(46, 46, 46));
        targetweightField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        targetweightField.setPreferredSize(new java.awt.Dimension(8, 20));
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
        ExMember.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        ExMember.setText("Ex-Member");
        jPanel1.add(ExMember);
        ExMember.setBounds(420, 540, 93, 23);

        ThruFriends.setBackground(new java.awt.Color(255, 255, 255));
        ThruFriends.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        ThruFriends.setText("Thru Friends");
        jPanel1.add(ThruFriends);
        ThruFriends.setBounds(90, 540, 83, 23);

        ViaPromo.setBackground(new java.awt.Color(255, 255, 255));
        ViaPromo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        ViaPromo.setText("Via Promo");
        jPanel1.add(ViaPromo);
        ViaPromo.setBounds(180, 540, 80, 23);

        JustWalkIn.setBackground(new java.awt.Color(255, 255, 255));
        JustWalkIn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        JustWalkIn.setText("Just walk-in");
        jPanel1.add(JustWalkIn);
        JustWalkIn.setBounds(260, 540, 90, 23);

        Internet.setBackground(new java.awt.Color(255, 255, 255));
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

        UPDATE.setBackground(new java.awt.Color(48, 173, 95));
        UPDATE.setForeground(new java.awt.Color(255, 255, 255));
        UPDATE.setText("Update");
        UPDATE.setContentAreaFilled(false);
        UPDATE.setOpaque(true);
        UPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEActionPerformed(evt);
            }
        });
        jPanel1.add(UPDATE);
        UPDATE.setBounds(320, 590, 170, 30);

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 month", "2 months", "3 months", "4 months", "5 months", "6 months", "1 year" }));
        month.setToolTipText("");
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        jPanel1.add(month);
        month.setBounds(320, 450, 170, 25);

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel20.setText("Target Weight");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(200, 470, 80, 30);

        lastnameField.setBackground(new java.awt.Color(227, 229, 233));
        lastnameField.setForeground(new java.awt.Color(46, 46, 46));
        lastnameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lastnameField.setPreferredSize(new java.awt.Dimension(8, 20));
        jPanel1.add(lastnameField);
        lastnameField.setBounds(410, 70, 160, 25);

        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel21.setText("Last Name");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(470, 90, 70, 30);

        aydi.setText("jLabel4");
        jPanel1.add(aydi);
        aydi.setBounds(40, 40, 34, 14);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void contactnumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactnumberFieldKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE) {
            contactnumberField.setEditable(true);

        } else {
            contactnumberField.setEditable(false);
        }
    }//GEN-LAST:event_contactnumberFieldKeyPressed

    private void contactPersonNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactPersonNumberFieldKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE) {
            contactPersonNumberField.setEditable(true);
        } else {
            contactPersonNumberField.setEditable(false);
        }
    }//GEN-LAST:event_contactPersonNumberFieldKeyPressed

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
        
        this.dispose();
        Main_Frame_Admin mf = Main_Frame_Admin.getInstance();
        mf.setEnabled(true);
        mf.setVisible(true);
        
    }//GEN-LAST:event_CANCELActionPerformed

    private void UPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEActionPerformed
        Database db = Database.getInstance();
                
        db.updateUser(
        firstnameField.getText(),
        lastnameField.getText(),
        sexComboBox.getSelectedItem().toString(),
        contactnumberField.getText(),
        occupationField.getText(),
        addressField.getText(),
        hobbiesField.getText(),
        contactpersonField.getText(),
        contactPersonNumberField.getText(),
        relationshipField.getText(),
        healthconcernField.getText(),
        currentweightField.getText(),
        targetweightField.getText(),
        month.getSelectedItem().toString(),
        aydi.getText()
        );
    }//GEN-LAST:event_UPDATEActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed

    }//GEN-LAST:event_monthActionPerformed

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
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCEL;
    private javax.swing.JRadioButton ExMember;
    private javax.swing.JRadioButton Internet;
    private javax.swing.JRadioButton JustWalkIn;
    private javax.swing.JRadioButton ThruFriends;
    public javax.swing.JButton UPDATE;
    private javax.swing.JRadioButton ViaPromo;
    public javax.swing.JTextField addressField;
    private javax.swing.JLabel aydi;
    public javax.swing.JTextField contactPersonNumberField;
    public javax.swing.JTextField contactnumberField;
    public javax.swing.JTextField contactpersonField;
    public javax.swing.JTextField currentweightField;
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
    private javax.swing.JLabel jLabel3;
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
    public javax.swing.JTextField middlenameField;
    public javax.swing.JComboBox month;
    public javax.swing.JTextField occupationField;
    public javax.swing.JTextField relationshipField;
    public javax.swing.JComboBox<String> sexComboBox;
    public javax.swing.JTextField targetweightField;
    // End of variables declaration//GEN-END:variables
}
