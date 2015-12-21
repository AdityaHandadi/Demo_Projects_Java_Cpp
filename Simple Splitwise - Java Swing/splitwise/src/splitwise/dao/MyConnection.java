/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitwise.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Statement;

/**
 *
 * @author adityahandadi
 */
public class MyConnection {
    
    /*
    static final String USER = "root";
    static final String PASS = "";
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/splitw";
    static Connection conn = null;
    static Statement stmt = null;

    */
    static String USER;
    static String PASS;
	
    static String JDBC_DRIVER;
    static String DB_URL;
    static Connection conn = null;
    static Statement stmt = null;
    
    public MyConnection() {
        Properties props = new Properties();
        
        try{
            FileInputStream in = 
               new FileInputStream("db.properties");
            props.load(in);
            in.close();
            
            System.out.println(props.getProperty("JDBC_DRIVER"));

            String driver = props.getProperty("JDBC_DRIVER");
            if (driver != null) {
                Class.forName(driver) ;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        JDBC_DRIVER = props.getProperty("JDBC_DRIVER");
        DB_URL = props.getProperty("DB_URL");
        USER = props.getProperty("USER");
        PASS = props.getProperty("PASS");
       
    }
        
        
	
	public Connection getConnection(){
        try{
			//Step 2
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			
			//stmt= conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
    
}
