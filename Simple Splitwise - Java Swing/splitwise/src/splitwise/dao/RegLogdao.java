/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitwise.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import splitwise.User;

/**
 *
 * @author adityahandadi
 */
public class RegLogdao {
    
    private MyConnection connection;

    public RegLogdao() {
        
    }
    
    public String registerRecord(User user){
        String status = "";
        PreparedStatement prst;
        try{
            connection = new MyConnection();
           
            //stmt = connection.conn.createStatement();
            String query = "insert into register(groupname,password) values(?,?)";
            
            prst = connection.getConnection().prepareStatement(query);

            if(user.getUserName()!=null){
               prst.setString(1, user.getUserName());
               prst.setString(2, user.getPassword());
               
               int count = prst.executeUpdate();
               
               System.out.println("Record Inserted "+ count);
               
               if(count>0){
                   status = "Registration success";
               }
            }
            else{
                
                status = "Registration failed";
            }

            prst.close();
            connection.conn.close();
            
            return status;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    
    public String authenticate(User user){
        String status = "";
        Statement stmt;
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(user.getUserName()!=null){
                String query = "select password as pass from register where groupname = '"+user.getUserName()+"'";
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next()){
                    System.out.println("ResultSet dao "+rs.getString("pass"));
                    if(user.getPassword().equals(rs.getString("pass"))){
                        status = "success";
                    }
                    else{
                        status = "fail";
                    }
                }
            }
            else{
                status = "fail";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    
}
