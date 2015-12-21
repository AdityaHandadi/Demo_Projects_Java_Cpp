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
import splitwise.Expense;

/**
 *
 * @author adityahandadi
 */
public class ExpenseDao {
    private MyConnection connection;

    public ExpenseDao() {
    }

    public void addExpense(String paidby,Double amount,String owedBy,String groupname){
        
        String status = "";
        PreparedStatement prst;
        try{
            connection = new MyConnection();
           
            //stmt = connection.conn.createStatement();
            String query = "insert into expense(paidby,amount,owedby,groupname) values(?,?,?,?)";
            
            prst = connection.getConnection().prepareStatement(query);

            if(paidby!=null){
                prst.setString(1, paidby);
                prst.setDouble(2, amount);
                prst.setString(3, owedBy);
                prst.setString(4, groupname);
                
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
    
    
    
    public List<Expense> getListOfExpense(String groupname){
        String status = "";
        Statement stmt;
        List<Expense> explist = new ArrayList<Expense>();
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(groupname!=null){
                String query = "select paidby,amount,owedby from expense where groupname = '"+groupname+"'";
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next()){
                    //System.out.println("ResultSet dao "+rs.getString("name"));
                    Expense expense = new Expense(rs.getString("paidby"),rs.getDouble("amount"),rs.getString("owedby"),groupname);
                    explist.add(expense);
                }
            }
            else{
                status = "fail";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return explist;
    }
    
    
    
    
    /**
     * 
     * Functions for Populating DashboardFrame
     * condition paidBy = memberName
     */
    public Double getSpentByTot(String group,String memberName){
        Statement stmt;
        Double totalAmount = 0.0;
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(group!=null){
                String selectSpentBy = " select amount from expense where groupname = '"+group+"' "
                        + " and paidby='"+memberName+"' ";
                
                ResultSet rs = stmt.executeQuery(selectSpentBy);
                
                while(rs.next()){
                    Double amt = rs.getDouble("amount");
                    totalAmount += amt;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return totalAmount;
    }
    
    //Same as above but, condition owedBy = memberName
    public Double getOwedByTot(String group,String memberName){
        Statement stmt;
        Double totalAmount = 0.0;
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(group!=null){
                String selectSpentBy = " select amount from expense where groupname = '"+group+"' "
                        + " and owedby='"+memberName+"' ";
                
                ResultSet rs = stmt.executeQuery(selectSpentBy);
                
                while(rs.next()){
                    Double amt = rs.getDouble("amount");
                    totalAmount += amt;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return totalAmount;
    }
    
    /*
    Get list of all Members who are accountable for bill paid by one on behalf of EVERYONE
    Amount divided equally amongst group members
    */
    public List<Expense> getListOfSplitAllMem(String group){
        String status = "";
        Statement stmt;
        List<Expense> expList = new ArrayList<Expense>();
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(group!=null){
                String query = "select paidby,amount from expense where groupname = '"+group+"' and owedby='Everyone'";
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next()){
                    //System.out.println("ResultSet dao "+rs.getString("name"));
                    Expense exp = new Expense();
                    exp.setSpentBy(rs.getString("paidby"));
                    exp.setAmount(rs.getDouble("amount"));
                    expList.add(exp);
                }
            }
            else{
                status = "fail";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return expList;
        
    }
    
    /*
    * This method returns the outstanding amount after all expenses only between A & B
    * Also includes expenses on everyone either by A or B
    */
    public Double getAmountDue(String memA, String memB,String group,Integer groupSize){
        Statement stmt;
        Double totalAmount = 0.0;
        Double amountA = 0.0;
        Double amountB = 0.0;
        Double amountC = 0.0;
        Double amountD = 0.0;
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(group!=null){
                
                //Find the amount paid by A to B specifically
                String selectSpentBy = " select amount from expense where owedby != 'Everyone'"
                        + " and paidby = '"+memA+"' "
                        + " and owedby ='"+memB+"' "
                        + " and groupname = '"+group+"' ";
                System.out.println(selectSpentBy);
                ResultSet rs = stmt.executeQuery(selectSpentBy);
                
                while(rs.next()){
                    Double amt = rs.getDouble("amount");
                    System.out.println("Amount: "+ amt);
                    amountA += amt;
                }
                
                 //Find the amount paid by B to A specifically
                String selectSpentBy2 = " select amount from expense where owedby != 'Everyone'"
                        + " and paidby = '"+memB+"' "
                        + " and owedby ='"+memA+"' "
                        + " and groupname = '"+group+"' ";
                
                ResultSet rs2 = stmt.executeQuery(selectSpentBy2);
                System.out.println(selectSpentBy2);
                
                while(rs2.next()){
                    Double amt = rs2.getDouble("amount");
                    System.out.println("Amount: "+ amt);
                    amountB += amt;
                }
                
                //PaidBy A, Owed By EveryOne, So B's share is totalAmount/no.of Members 
                String selectSpentBy3 = " select amount from expense where owedby = 'Everyone'"
                        + " and paidby = '"+memA+"' "
                        //+ " and owedby ='"+memB+"' "
                        + " and groupname = '"+group+"' ";
                System.out.println(selectSpentBy3);
                
                ResultSet rs3 = stmt.executeQuery(selectSpentBy3);
                
                while(rs3.next()){
                    Double amt = rs3.getDouble("amount");
                    System.out.println("Amount: "+ amt);
                    amountC = amountC + amt/groupSize;
                }
                
                
                
                //PaidBy B, Owed By EveryOne, So A's share is totalAmount/no.of Members 
                String selectSpentBy4 = " select amount from expense where owedby = 'Everyone'"
                        + " and paidby = '"+memB+"' "
                        //+ " and owedby ='"+memA+"' "
                        + " and groupname = '"+group+"' ";
                System.out.println(selectSpentBy4);
                
                ResultSet rs4 = stmt.executeQuery(selectSpentBy4);
                
                while(rs4.next()){
                    Double amt = rs4.getDouble("amount");
                    System.out.println("Amount: "+ amt);
                    amountD += amt/groupSize;
                }
                
                //total Amount is amount totally paid by A to B, and A to B's share when A paid everybody
                //Deducted by amount paid by B to A, and if A's share owed to B, when B paid everybody
                totalAmount = (amountA+amountC) - (amountB+amountD) ;
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return totalAmount;
    }
    
    //returns list of all expense activities between A&B
    public List<Expense> getExpenseA_B(String memA, String memB,String group){
        String status = "";
        Statement stmt;
        List<Expense> expList = new ArrayList<Expense>();
        try{
            connection = new MyConnection();
            stmt = connection.getConnection().createStatement();
            
            if(group!=null){
                String query = "select paidby,amount,owedby from expense where groupname = '"+group+"' "
                        + "and owedby in ('"+memA+"','"+memB+"','Everyone')"
                        + "and paidby in ('"+memA+"','"+memB+"','Everyone')";
                System.out.println(query);
                ResultSet rs = stmt.executeQuery(query);
                
                while(rs.next()){
                    //System.out.println("ResultSet dao "+rs.getString("name"));
                    Expense exp = new Expense();
                    exp.setSpentBy(rs.getString("paidby"));
                    exp.setAmount(rs.getDouble("amount"));
                    exp.setSplitWith(rs.getString("owedby"));
                    expList.add(exp);
                }
            }
            else{
                status = "fail";
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return expList;
        
    }
    
}
