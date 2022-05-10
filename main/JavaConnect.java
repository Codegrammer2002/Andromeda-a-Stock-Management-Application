/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_application_ia;

/**
 *
 * @author Parv
 */
import java.sql.*;
import javax.swing.*;


public class JavaConnect {
            Connection conn= null;

    public static Connection ConnecrDb () {
        // TODO code application logic here
        try{
        Class.forName("org.sqlite.JDBC");
         Connection  conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\DELL\\Appdbms.db");
        // C:\\Users\\DELL\\Appdbms.db
              // JOptionPane.showMessageDialog(null,"Connection established");
                 return conn;
                 

       
    }   catch (ClassNotFoundException | SQLException e ) {
      // TODO Auto-generated catch block
      
      System.out.println(e+"");
      return null;
      
    }
      
    }/*
    public static void main(String args[]){
        ConnecrDb();
        
    }
    */ 
}