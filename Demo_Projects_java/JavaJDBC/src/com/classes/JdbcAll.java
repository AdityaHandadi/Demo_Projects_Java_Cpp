package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcAll {
	
	static final String USER = "root";
	static final String PASS = "";
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	static Connection conn = null;
	static Statement stmt = null;
	
	public static Statement getConnection(){
		
		
		try{
			//Step 2
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to the selected DB....");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected successfully ,");
			
			stmt= conn.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return stmt;
	}

	public static void createTable(String tableName,Statement stmt){
		/*
		 * String query = "create Table `test`."+tableName+" (`"; StringBuffer
		 * strbuf = new StringBuffer(query); int l = columns.length; for(int
		 * i=0;i<l-1;i++){ strbuf.append(columns[i]); strbuf.append("`,`"); }
		 * strbuf.append(columns[l]); strbuf.append("`)");
		 */
		try{
			String query = "create Table `test`."
					+ tableName
					+ " (`id` INT NULL,`name` VARCHAR(45) NULL,`address` VARCHAR(45) NULL)";
			
			stmt.execute(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void insertRecord(String table,int id,String name,String address,Statement stmt){
		try{
			String query = "INSERT INTO "+table+" VALUES("+id+",`"+name+"`,`"+address+"`)";
			stmt.executeUpdate(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void updateRecord(Statement stmt,String tableName,String column,int pk,String newVal){
		try{
			String query = "update `test`.`"+tableName+"` set `"+column+"`=`"+newVal+"` where `id` ="+pk;
			stmt.executeUpdate(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deleteRecord(Statement stmt,String tableName){
		try{
			String query = "delete from `test`.`"+tableName+"` ";
			stmt.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void sortRecAsc(String tableName,Statement stmt){
		try{
			String query ="select * from `test`.`"+tableName+"` sort by id asc";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				System.out.print("id: "+rs.getInt("id")+"---");
				System.out.print("name: "+rs.getInt("name")+"---");
				System.out.print("address: "+rs.getInt("address")+"----\n");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void sortRecDsc(String tableName,Statement stmt){
		try{
			String query ="select * from `test`.`"+tableName+"` sort by id desc";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				System.out.print("id: "+rs.getInt("id")+"---");
				System.out.print("name: "+rs.getInt("name")+"---");
				System.out.print("address: "+rs.getInt("address")+"----\n");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void display(String tableName,Statement stmt,String condition){
		try{
			String query = "select * from `test`.`"+tableName+"` "+condition;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				System.out.print("id: "+rs.getInt("id")+"---");
				System.out.print("name: "+rs.getInt("name")+"---");
				System.out.print("address: "+rs.getInt("address")+"----\n");
			}
			
		   }catch(Exception e){
		    e.printStackTrace();
		   }
	}
	

	
	public static void main(String args[]){
		Scanner scanner =  new Scanner(System.in);
		
		System.out
				.println("Enter 1 to createDB, "
						+ "2 to insert, 3 to update,"
						+ " 4 to delete, 5 to display all,"
						+ "6 to displayAll with condition,"
						+ "7 to display in asc, 8 to displayin desc");

		int n = scanner.nextInt();
		stmt = getConnection();
		switch(n){
		case(1):
				String tableName = "student";
				createTable(tableName, stmt);
			break;
		case(2):
			break;
		case(3):
			
			break;
		case(4):
			
			break;
		case(5):
			
			break;
		case(6):
			
			break;
		case(7):
			
			break;
		case(8):
			
			break;
		}
		
		scanner.close();
	}
}
