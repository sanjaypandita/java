
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.sql.DriverManager;
import java.sql.Connection ;
import java.sql.SQLException;

/**
 *
 * @author M3TAL H3AD
 */
public class MyConnection_1 {
    
    
    public Connection connection=null;
    public Connection getConnection;
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
        
    }
        catch(ClassNotFoundException e)
            
        {
            System.out.println("Where is mysql driver");
            e.printStackTrace();
        }
    
        System.out.println("Driver registered");
        Connection connection= null;
        try{
            Connection conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","bingo");
                    
        }
        catch(SQLException e)
               {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }  
         if(connection !=null){
             System.out.println("You did it");
         }
         else
         {
             System.out.println("Failed");
             
         }
         
}

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}