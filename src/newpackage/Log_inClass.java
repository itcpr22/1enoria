/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tedted29
 */
public class Log_inClass {
    Connect con = new Connect();
    String fname = "";
    
    public int login(String username, String uPassword){
        int x = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection Connect = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
            
            String sql = "SELECT * FROM sign_up WHERE username = ? AND uPassword = MD5(?);";
            PreparedStatement pstmt = (PreparedStatement) Connect.prepareStatement(sql);
            
            pstmt.setString(1, username);
            pstmt.setString(2, uPassword);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                x = 1;
                fname = rs.getString("FirstName");
            }else{
                x = 0;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Log_inClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Log_inClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
    }
    
    
}
