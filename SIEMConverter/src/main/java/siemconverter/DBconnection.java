/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siemconverter;


import java.sql.*;
import javax.swing.JOptionPane;

public class DBconnection  {

    Connection connect=null;
    Statement statement=null;
    ResultSet result =null;
    public DBconnection()
    {
        try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load the driver
        String url ="jdbc:sqlserver://localhost:1433;DatabaseName=SIEM_CONVERTER";
        String username = "siem";
        String password = "maneno70";
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
