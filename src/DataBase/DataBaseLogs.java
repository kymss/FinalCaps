
package DataBase;

import static DataBase.Database.con;
import fitnesscampsystem.Add_a_Member;
import fitnesscampsystem.Add_a_User;
import fitnesscampsystem.Main_Frame_Admin;
import fitnesscampsystem.Update_Member;
import fitnesscampsystem.changepass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import panels.ADD_USER;
import panels.DASHBOARD;
import panels.Members;
import panels.Walk_In;


public class DataBaseLogs {
      
    private static DataBaseLogs instance = null;

    public static DataBaseLogs getInstance() {
        if (instance == null) {
            instance = new DataBaseLogs();
        }
        return instance;
    }
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     public void addMemberLog() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Add_a_Member am = Add_a_Member.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.description.getText());
            
            pst.executeUpdate();
            System.out.println("Added a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to Add");
        }
     }
//        
//         public void userLoggedIn() {
//        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
//        try {
//            con = Database.ConnectDB();
//            pst = con.prepareStatement(query);
//            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
//            Add_a_Member am = Add_a_Member.getInstance();
//            
//            pst.setString(1, mfa.USER_ID.getText());
//            pst.setString(2, mfa.USERNAME.getText());
//            pst.setString(3, mfa.date.getText());
//            pst.setString(4, mfa.time.getText());
//            pst.setString(5, mfa.log_description.getText());
//            pst.executeUpdate();
//            System.out.println(" pire");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("not logged, userloggedin");
//        }
//
//
//    }
     
      public void addUserLogs() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Add_a_User am = Add_a_User.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.descriptionuser.getText());
            
            pst.executeUpdate();
            System.out.println("New User Added");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("User not added");
        }
     } 
//      updateDescription
      
      public void updateMember() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Update_Member am = Update_Member.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.updateDescription.getText());
            
            pst.executeUpdate();
            System.out.println(" Updated a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to Update a Member");
        }
     } 
      
       public void deleteMember() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Members am = Members.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.deleteMem.getText());
            
            pst.executeUpdate();
            System.out.println("Deleted a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
       
        public void changePassLog() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            changepass am = changepass.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.pwdescription.getText());
            
            pst.executeUpdate();
            System.out.println("Deleted a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
        
        
        public void updateUserlog() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            ADD_USER am = ADD_USER.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.updateuser.getText());
            
            pst.executeUpdate();
            System.out.println("Deleted a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
        
        public void deleteUserlog() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            ADD_USER am = ADD_USER.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.deleteuser.getText());
            
            pst.executeUpdate();
            System.out.println("Deleted a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
        
        public void renewLog() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            DASHBOARD am = DASHBOARD.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.renewmember.getText());
            
            pst.executeUpdate();
            System.out.println("Deleted a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
//        
//         deletedmem
//        
        public void deleteMemberD() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            DASHBOARD am = DASHBOARD.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.deletedmem.getText());
            
            pst.executeUpdate();
            System.out.println("Deleted a Member");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
//        
        
        public void addWalkIn() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Walk_In am = Walk_In.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.addwalkin.getText());
            
            pst.executeUpdate();
            System.out.println("Added A Walkin");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
        
        public void updateWalkIn() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Walk_In am = Walk_In.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.updatewalkin.getText());
            
            pst.executeUpdate();
            System.out.println("Added A Walkin");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
        
        public void deleteWalkIn() {
        String query = "INSERT into Logs_Tbl( User_id, Username, Date, Time, Description ) values (?,?,?,?,?)";
        try {
            con = Database.ConnectDB();
            pst = con.prepareStatement(query);
            Main_Frame_Admin mfa = Main_Frame_Admin.getInstance();
            Walk_In am = Walk_In.getInstance();
            
            pst.setString(1, mfa.USER_ID.getText());
            pst.setString(2, mfa.USERNAME.getText());
            pst.setString(3, mfa.date.getText());
            pst.setString(4, mfa.time.getText());
            pst.setString(5, am.deletewalkin.getText());
            
            pst.executeUpdate();
            System.out.println("Walk in deleted");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable To Delete");
        }
     } 
}
