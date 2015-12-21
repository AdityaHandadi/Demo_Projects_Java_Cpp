/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitwise.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import splitwise.Member;

/**
 *
 * @author adityahandadi
 */
public class MemberDao {
    
    private MyConnection connection;

    public MemberDao() {
    }
    
    public void addMember(String name,String email,String groupname){
        
        String status = "";
        PreparedStatement prst;
        try{
            connection = new MyConnection();
           
            //stmt = connection.conn.createStatement();
            String query = "insert into members(groupname,name,email) values(?,?,?)";
            
            prst = connection.getConnection().prepareStatement(query);

            if(name!=null){
                prst.setString(1, groupname);
                prst.setString(2, name);
                prst.setString(3, email);
                
                int count = prst.executeUpdate();
                System.out.println(" Member Record inserted --> "+count);
                
            }
            else{
                System.out.println("No record for inserting");
            }
            

            prst.close();
            connection.conn.close();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
    
    public List<Member> getListOfMembers(String groupname){
        String status = "";
        Statement stmt;
        List<Member> memberlist = new ArrayList<Member>();
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(groupname!=null){
                String query = "select name,email from members where groupname = '"+groupname+"'";
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next()){
                    //System.out.println("ResultSet dao "+rs.getString("name"));
                    Member member = new Member(rs.getString("name"),rs.getString("email"));
                    memberlist.add(member);
                }
            }
            else{
                status = "fail";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return memberlist;
    }
    
    
}
