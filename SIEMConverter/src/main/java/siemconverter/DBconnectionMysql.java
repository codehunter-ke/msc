/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siemconverter;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author mark.meli
 */
public class DBconnectionMysql {
    
    
    Connection connect=null;
    Statement statement=null;
    ResultSet result =null;
    public DBconnectionMysql()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver"); //load the driver
        String url ="jdbc:mysql://localhost:3306/sentrifugo";
        String username = "root";
        String password = "kenya123*";
        connect = DriverManager.getConnection(url, username, password);//establishes a connection
        statement = connect.createStatement();
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        //method to handle inserting data and updating data in the database
       public void update(String query)
       {
           try
           {
                 statement.executeUpdate(query);
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }
       //method to handle retrieving data from the database
       public ResultSet retrieve(String query)
       {
           try
           {
           result = statement.executeQuery(query);
           }
           catch(SQLException e)
           {
               JOptionPane.showMessageDialog(null,e.getMessage());
           }
           return result;
       }
       //garbage collector
    
}
