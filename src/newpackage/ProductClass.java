/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tedted29
 */
public class ProductClass {
    
    Connect con = new Connect();
    
    public int product(String P_Name, int Qty, Object price ){
   
    int x = 0;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(con.url, con.username, con.password);
        String sql = "insert into tblproducts values(null,?,?,?)";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        
        String np = price.toString();
        float newprice = Float.parseFloat(np);
        
        pstmt.setString(1, P_Name);
        pstmt.setInt(2, Qty);
        pstmt.setFloat(3,  newprice);
       
        
        x = pstmt.executeUpdate();
        
        //System.out.println(x);
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x; 
    }
    
    
    
     public int editProduct(Object id, String product_name, Object price){
        int r = 0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(con.url,con.username,con.password);
        
        String sql = "UPDATE tblproducts SET P_Name = ?, price = ? WHERE id = ?;";
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        
        pstmt.setString(1, product_name);
        float newprice = Float.parseFloat(price.toString());
        pstmt.setFloat(2, newprice);
        String newid = (String) id;
        pstmt.setString(3, newid);
        
        //System.out.println(pstmt);
        r = pstmt.executeUpdate();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    int addQuantity(Object id, Object qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}

    

