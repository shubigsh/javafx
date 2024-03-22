package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {

    
    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/car_rental","root","1234567890");
            return connect;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    
    

  

        	 
         }
}