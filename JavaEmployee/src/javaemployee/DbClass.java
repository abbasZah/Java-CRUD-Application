/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaemployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abbas Zaheer
 */
public class DbClass {

    
          private static final String USER = "root";
	private static final String PASS = "";
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
          private static final String ser_URL = "jdbc:mysql://localhost/";
          private static final String dbName = "javaemployee";
          private static final String db_URL = ser_URL+dbName;
          private static final String tableEmployee = "employee_info";
         
          
          
          
          
          
          public static Connection get_Connection()throws Exception{////////////////////
		try{
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(db_URL, USER, PASS);
			System.out.println("Connection Established!");
			return conn;
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
          }
          
          
          
          
          
          
          
          
          
          
          
          public static void insertData(Employee emp)
                            throws Exception{
		try{
			
			Connection conn = get_Connection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO "+tableEmployee+"" 
                              + "(id, name, gender, phone_no, designation)"
			+"VALUES (?, ?, ?, ?, ?)");
                              
                                stmt.setString(1, emp.getId());
                                stmt.setString(2, emp.getName());
                                stmt.setString(3, emp.getGender());
                                stmt.setString(4, emp.getPhone_no());
                                stmt.setString(5, emp.getDesignation());
          
			stmt.executeUpdate();	
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
          
          
          
          
          
          
          
          
          public static ArrayList<Employee> getEmployees(){
              ArrayList<Employee> empArray = new ArrayList<>();
		try{
			Connection conn = get_Connection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+tableEmployee);
			while(rs.next()){
				
                                            Employee emp2 = new Employee(rs.getString("id"), rs.getString("name"),  rs.getString("gender"), rs.getString("phone_no"), rs.getString("designation"));
                                            
                                            empArray.add(emp2);
			}
		}catch(Exception e){
                        e.printStackTrace();
		}
                    return empArray;
	}
          
          
          
          
          
          
          
          
          
          public static void removeEmployee(String id){
             try{
                 Connection conn = get_Connection();
                 String sql = "DELETE FROM "+tableEmployee+" WHERE id=?";
                 
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 stmt.setString(1, id);
                 
                 stmt.executeUpdate();
             }catch(Exception ex){
                 System.out.println(ex);
             }
         }
          
          
          
          
          
          
          
          
          public static void updateData(Employee emp)
                            throws Exception{
                       
		try{
			
			Connection conn = get_Connection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE "+tableEmployee+" SET name = ?, "
                                      + "gender = ?, phone_no = ?, designation = ? WHERE id = ?");
                                stmt.setString(1, emp.getName());
                                stmt.setString(2, emp.getGender());
                                stmt.setString(3, emp.getPhone_no());
                                stmt.setString(4, emp.getDesignation());
                                stmt.setString(5, emp.getId());
                              
			stmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e);
		}
          
          }
    
}
