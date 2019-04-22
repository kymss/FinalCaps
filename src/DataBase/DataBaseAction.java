
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DataBaseAction {
//    static Connection con;
//    static String URL = "jdbc:mysql://localhost:3306/fitness_camp?zeroDateTimeBehavior=convertToNull";
//    
//    
//    private static DataBaseAction instance = null;
//    public static DataBaseAction getInstance(){
//        if(instance == null){
//            instance = new DataBaseAction();
//        }
//        return instance;
    }
     //Creates database and db connection..
//    public DataBaseAction(){
//
//        Connection conn = null;
//        Statement stmt = null;
//        
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(URL, "root", "");
//
//            System.out.println("Creating database...");
//            stmt = conn.createStatement();
//
//            String sql = "CREATE DATABASE IF NOT EXISTS timeclock";
//            stmt.executeUpdate(sql);
//            System.out.println("Database created successfully...");
//   
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
//        
//        try{
//          Class.forName("com.mysql.jdbc.Driver");
//          con = (Connection) DriverManager.getConnection(URL);
//          System.out.println("Successfully connected to mysql database!");
//        } catch ( Exception e ){
//            JOptionPane.showMessageDialog(null,e);
//        }
//    }
// 
//    //LOGIN
//     public boolean setAccountIndex(String admin,String password){
//        try{           
//        PreparedStatement pst = con.prepareStatement("SELECT * FROM login_tbl WHERE username = ? and password = ?");
//        pst.setString(1, admin); 
//        pst.setString(2, password);
//        ResultSet rs = pst.executeQuery();                        
//        if(rs.next()){
////           JOptionPane.showMessageDialog(null,"Welcome "+admin+"");
//           return true;
//        }
//        else{
//           JOptionPane.showMessageDialog(null,"Incorrect username or password");
//           return false;
//        }
//    }
//        catch(Exception e){
//        e.printStackTrace();
//    }       
//        return false;
//    }
//     
//     public void determinePosition(String username,JLabel position){
//        String id = null;
//        String pos = null;
//        
//        try{
//            
//        Statement stmt = (com.mysql.jdbc.Statement) con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM login_tbl WHERE USERNAME = '"+username+"'");
//        
//        while(rs.next()){
//            id = rs.getString("user_id");
//            position.setText(rs.getString("POSITION"));
//        }   
//        
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//     
//     
//     //ADD MEMBER
//     
//     public void addMember(String firstName, String middleName,String lastName,String gender,
//            String ContactNumber,String Occupation,String Address,String Hobbies,String Contactperson,
//            String ContactPersonNo,String Relationship,String Healthconcern,
//            String Currentweight,String Targetweight,String Membership,String creation,
//            String Start,String End,String Payment){
//        
//        String sql = "INSERT INTO members_tbl (mfirstName,mmiddleName,mlastName,"
//                + "gender, ContactNumber ,Occupation ,Address ,Hobbies,"
//                + "Contactperson ,ContactPersonNo ,Relationship ,Healthconcern ,Currentweight,Targetweight,"
//                + "Membership ,creation ,Start ,End ,Payment)VALUES"
//                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            pstmt.setString(1,firstName);
//            pstmt.setString(2,middleName);
//            pstmt.setString(3,lastName);
//            pstmt.setString(4,gender);
//            pstmt.setString(5,ContactNumber);
//            pstmt.setString(6,Occupation);
//            pstmt.setString(7,Address);
//            pstmt.setString(8,Hobbies);
//            pstmt.setString(9,Contactperson);
//            pstmt.setString(10,ContactPersonNo);
//            pstmt.setString(11,Relationship);
//            pstmt.setString(12,Healthconcern);
//            pstmt.setString(13,Currentweight);
//            pstmt.setString(14,Targetweight);
//            pstmt.setString(15,Membership);
//            pstmt.setString(16,creation);
//            pstmt.setString(17,Start);
//            pstmt.setString(18,End);
//            pstmt.setString(19,Payment);
//           
//            
//            pstmt.executeUpdate();
//            JOptionPane.showMessageDialog(null,firstName+" Successfuly Added");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//     
//     public void displayMembers(DefaultTableModel model){
//        
//        try {
//        
//            Statement stmt = (com.mysql.jdbc.Statement) con.createStatement();
//            String sql= "SELECT member_id, mfirstName, mmiddleName, mlastName, gender, ContactNumber, Occupation,Address, Hobbies FROM members_tbl";
//            ResultSet rs;
//            rs = stmt.executeQuery(sql);
//               
//            while(rs.next()){
//            
//            String ID = rs.getString("member_id");
//            String FIRSTNAME = rs.getString("mfirstName");
//            String MIDDLE = rs.getString("mmiddleName");
//            String LAST = rs.getString("mlastName");
//            String GEN = rs.getString("gender");
//            String NUM = rs.getString("ContactNumber");
//            String OCCUPATION = rs.getString("Occupation");
//            String ADDRESS = rs.getString("Address");
//            String HOBBIES = rs.getString("Hobbies");
//            
//            model.addRow(new Object[]{ID,FIRSTNAME,MIDDLE,LAST,
//                GEN,NUM,OCCUPATION,ADDRESS});
//            
//        }}catch (Exception e) {
//          e.printStackTrace();
//        }
//    }    
//     //UPDATE MEMBER
//     public void updateMember(String firstName, String middleName,String lastName,String gender,
//            String ContactNumber,String Occupation,String Address,String Hobbies,String Contactperson,
//            String ContactPersonNo,String Relationship,String Healthconcern,
//            String Currentweight,String Targetweight,String Membership,String creation,
//            String Start,String End,String Payment, String id){
//        
//        String sql = "UPDATE PATIENTS SET mfirstName = ? , mmiddleName = ? ,"
//                + " mlastName = ?, gender = ?,ContactNumber = ?,Occupation = ?,"
//                + " Address = ?,Hobbies = ?, Contactperson = ?,"
//                + " ContactPersonNo = ?, Relationship = ?, Healthconcern = ?,Currentweight = ?,"
//                + " Targetweight = ?,Membership = ?,creation = ?,Start = ?,"
//                + " End = ?,Payment = ?, WHERE member_id = ?";
//
//        try {
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            pstmt.setString(1,firstName);
//            pstmt.setString(2,middleName);
//            pstmt.setString(3,lastName);
//            pstmt.setString(4,gender);
//            pstmt.setString(5,ContactNumber);
//            pstmt.setString(6,Occupation);
//            pstmt.setString(7,Address);
//            pstmt.setString(8,Hobbies);
//            pstmt.setString(9,Contactperson);
//            pstmt.setString(10,ContactPersonNo);
//            pstmt.setString(11,Relationship);
//            pstmt.setString(12,Healthconcern);
//            pstmt.setString(13,Currentweight);
//            pstmt.setString(14,Targetweight);
//            pstmt.setString(15,Membership);
//            pstmt.setString(16,creation);
//            pstmt.setString(17,Start);
//            pstmt.setString(18,End);
//            pstmt.setString(19,Payment);
//            pstmt.setString(20, id);
//            
//            pstmt.executeUpdate();
//            JOptionPane.showMessageDialog(null,""+lastName+", "+firstName+" successfuly updated");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
     
     
     
//}
