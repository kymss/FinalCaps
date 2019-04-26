package DataBase;

import fitnesscampsystem.Add_a_User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Database {

    PreparedStatement pst = null;

    private static Database instance = null;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    static Connection con = null;

    public static Connection ConnectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Documents\\NetBeansProjects\\FitnessCampSystem\\Database.db");
//            JOptionPane.showMessageDialog(null,"Connection Established!");
            System.out.println("success");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void updateUser(String firstNamex, String middleNamex, String lastNamex, String genderx, String Contactnumberx,
            String Occupationx, String addressx, String Hobbiesx, String Contactpersonx, String ContactPersonNox, String Relationshipx, String Healthconcernx,
            String Currentweightx, String Targetweightx, String members_idx) {

        String sql = "UPDATE Members_Tbl SET mfirstName = ? , mmiddleName = ?, mlastName = ?, gender = ?, ContactNumber = ?,  "
                + "Occupation = ? , address = ?, Hobbies = ?, Contactperson = ?,"
                + "ContactPersonNo = ?, Relationship = ?,Healthconcern = ? ,Currentweight = ? , Targetweight = ? WHERE members_id = ?";

        try {
            con = Database.ConnectDB();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param

            pstmt.setString(1, firstNamex);
            pstmt.setString(2, middleNamex);
            pstmt.setString(3, lastNamex);
            pstmt.setString(4, genderx);
            pstmt.setString(5, Contactnumberx);
            pstmt.setString(6, Occupationx);
            pstmt.setString(7, addressx);
            pstmt.setString(8, Hobbiesx);
            pstmt.setString(9, Contactpersonx);
            pstmt.setString(10, ContactPersonNox);
            pstmt.setString(11, Relationshipx);
            pstmt.setString(12, Healthconcernx);
            pstmt.setString(13, Currentweightx);
            pstmt.setString(14, Targetweightx);
            pstmt.setString(15, members_idx);
            // update
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "" + firstNamex + " successfuly updated");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("NOOOO");
        }
    }

    public void updateAccount(String usernamex, String firstnamex, String lastnamex, String rolex, String user_id) {

        String sql = "UPDATE Login_Tbl SET username = ? , firstname = ?, lastname = ?, role = ? WHERE user_id = ?";

        try {
            con = Database.ConnectDB();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param

            pstmt.setString(1, usernamex);
            pstmt.setString(2, firstnamex);
            pstmt.setString(3, lastnamex);
            pstmt.setString(4, rolex);
            pstmt.setString(5, user_id);

            // update
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "" + firstnamex + " successfuly updated");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("NOOOO");
        }
    }

    public void deleteMember(String mem_id) {

        String sql = "DELETE FROM Members_Tbl WHERE members_id = ?";

        try {
            con = Database.ConnectDB();
//            PreparedStatement pstmt = con.prepareStatement(sql);
            PreparedStatement pst = null;
            pst = con.prepareStatement(sql);
            pst.setString(1, mem_id);
            pst.executeUpdate();
            System.out.println(mem_id + " deleted");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void add_a_user(String uname, String fname, String lname, String pass, String cp, String role) {
        String query = "INSERT into Login_Tbl( username, firstname, lastname, password, confirm_password, role) values (?,?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            pst.setString(1, uname);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, pass);
            pst.setString(5, cp);
            pst.setString(6, role);
            pst.executeUpdate();
            System.out.println(" pire");
            
            Add_a_User aau = Add_a_User.getInstance();
            aau.clear_ops();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" new user not added");
        }
    }

    public void add_a_member(String firstname, String middlename, String lastname, String gender, String contactnum, String occupation, String address,
            String hobbies, String contactperson, String contactpersonno, String relationship, String healthconcern, String currentweight, String targetweight,
            String membership, String start, String end, String created_at, String payment) {
        try {
            String sql = "INSERT INTO Members_Tbl(mfirstName,mmiddleName,mlastName,gender,ContactNumber,Occupation,address,Hobbies,"
                    + "Contactperson,ContactPersonNo,Relationship,Healthconcern,Currentweight,Targetweight,Membership,Start,End,Created_at,Payment)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            con = Database.ConnectDB();
            pst = con.prepareStatement(sql);
            //PersonalInformation
            pst.setString(1, firstname);
            pst.setString(2, middlename);
            pst.setString(3, lastname);
//                String sex = sexComboBox.getSelectedItem().toString();//comboBox
            pst.setString(4, gender);
            pst.setString(5, contactnum);
            pst.setString(6, occupation);
            pst.setString(7, address);
            pst.setString(8, hobbies);
            //EmeergencyInformation
            pst.setString(9, contactperson);
            pst.setString(10, contactpersonno);
            pst.setString(11, relationship);
            pst.setString(12, healthconcern);
            pst.setString(13, currentweight);
            pst.setString(14, targetweight);
//                String hv = month.getSelectedItem().toString();//membership
            pst.setString(15, membership);
//                String dt = ((JTextField) start.getDateEditor().getUiComponent()).getText();
            pst.setString(16, start);
            pst.setString(17, end);
//                String ct = ((JTextField) created_at.getDateEditor().getUiComponent()).getText();
            pst.setString(18, created_at);
            pst.setString(19, payment);

            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved!");
            pst.close();
        } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
            System.out.println(e + "eto");
        }
    }

    public void addCustomer(String name, String middle, String lastname, String num, String gender, String health) {
        try {
            String sql = "INSERT into Customer_Tbl (firstname, middlename,lastname,ContactNo,Gender,HealthConcern)"
                    + "VALUES(?,?,?,?,?,?)";
            con = Database.ConnectDB();
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, middle);
            pst.setString(3, lastname);
            pst.setString(4, num);
            pst.setString(5, gender);
            pst.setString(6, health);
            pst.execute();

            JOptionPane.showMessageDialog(null, name + " Added!");
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Error!!!!!");
        }
    }

    public void deleteCustomer(String mem_id) {
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete this information?", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            String sql = "DELETE FROM Login_Tbl WHERE user_id = ? ";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, mem_id);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
                pst.close();

            } catch (Exception e) {
                e.printStackTrace();
                //                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void updateCustomer(String first, String middle, String last, String contact, String gender, String health, String id) {

        String sql = "UPDATE Customer_Tbl SET firstname = ? , middlename = ?, lastname = ?, ContactNo = ?, Gender = ?, HealthConcern = ? WHERE customer_id = ?";

        try {
            con = Database.ConnectDB();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param

            pstmt.setString(1, first);
            pstmt.setString(2, middle);
            pstmt.setString(3, last);
            pstmt.setString(4, contact);
            pstmt.setString(5, gender);
            pstmt.setString(6, health);
            pstmt.setString(7, id);
            
            // update
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "" + first + " successfuly updated");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("NOOOO");
        }
    }
    
    
    public void changePassword(String uname, String fname, String lname, String password, String conpassword, String role, String id) {

        String sql = "UPDATE Login_Tbl SET username = ? , firstname = ?, lastname = ?, password = ?, confirm_password = ?, role = ? WHERE user_id = ?";

        try {
            con = Database.ConnectDB();
            PreparedStatement pstmt = con.prepareStatement(sql);
            // set the corresponding param

            pstmt.setString(1, uname);
            pstmt.setString(2, fname);
            pstmt.setString(3, lname);
            pstmt.setString(4, password);
            pstmt.setString(5, conpassword);
            pstmt.setString(6, role);
            pstmt.setString(7, id);
            
            // update
            pstmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "" + uname + " Successfully change password");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("NOOOO");
        }
    }
    
    

    static String userPassword = null;

    public String getUserPassword() {
        return userPassword;
    }

    public static Connection getConn() {
        return con;
    }

    void UpdateRenewl(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
