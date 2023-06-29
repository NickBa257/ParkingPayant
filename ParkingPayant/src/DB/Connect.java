/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author NICK BA
 */
public class Connect {
    
    static Connection con=null;
    
    
    public Connect(){
    
    }
    
    public static Connection DbConnexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
            } catch (SQLException ex) {
              System.out.println(ex);
            }
            
        } catch (ClassNotFoundException ex) {
         System.out.println(ex);
        }
        
        return con;
    }
    
    public static ResultSet Affichage(String sql){
     
        ResultSet rs=null;
        Statement st;
        
        if(con==null){
        DbConnexion();    
        }
                 try {
		     st=con.createStatement();
		     rs=st.executeQuery(sql);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
		}
                 
         return rs;        
       }
    
    public static void UpdateDb(String sql){
      Statement s=null ;
      
     if(con==null){
        DbConnexion();
     } 
        try {
            s=con.createStatement();
            s.executeUpdate(sql);
        } catch (SQLException ex) {
            
          System.out.println(ex);  
        }
      
     }   
    
}
