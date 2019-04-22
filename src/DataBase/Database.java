
package DataBase;

import fitnesscampsystem.Update_Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class Database {
    
    private static Database instance = null;    
    public static Database getInstance() {
      if(instance == null) {
         instance = new Database();
      }
      return instance;
    }
    
    
    static Connection con = null;
    
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User1\\Documents\\NetBeansProjects\\FitnessCampSystem\\Database.db");
//            JOptionPane.showMessageDialog(null,"Connection Established!");
            System.out.println("success");
            return con;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
                    return null; 
        }
}
    
    public void updateUser( String firstNamex, String middleNamex, String lastNamex, String genderx, String Contactnumberx,
            String Occupationx, String addressx, String Hobbiesx, String Contactpersonx, String ContactPersonNox, String Relationshipx, String Healthconcernx, 
            String Currentweightx, String Targetweightx, String members_idx){

        String sql = "UPDATE Members_Tbl SET mfirstName = ? , mmiddleName = ?, mlastName = ?, gender = ?, ContactNumber = ?,  "
                    +"Occupation = ? , address = ?, Hobbies = ?, Contactperson = ?,"
                    +"ContactPersonNo = ?, Relationship = ?,Healthconcern = ? ,Currentweight = ? , Targetweight = ? WHERE members_id = ?";
        
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
            JOptionPane.showMessageDialog(null,""+firstNamex+" successfuly updated");
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("NOOOO");
        }
    }
    
    public static Connection getConn(){
    return con;
}    
    
    void UpdateRenewl(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
