package com.palle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.palle.model.Customer;

public class DataAccess 
{
	   private static final String dbUrl ="jdbc:mysql://localhost:3306/akbar";
	   private static final String dbUsername="root";
	   private static final String dbPassword="admin";
	    
	   private static Connection con=null;
	   private static Statement s =null;
	   private static PreparedStatement ps=null;
	   private static  ResultSet rs=null;
	   
	   
	   private static final String insertqry ="insert into customer(name, email, mobile, password, state) values(?,?,?,?,?)";
	   
	   private static final String validateqry="select email from customer where email=?and password=?";
	   
	   
	   public static boolean validateCustomer(String email, String password) 
	   {
		   boolean b =false;
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
				
				ps=con.prepareStatement(validateqry);
				ps.setString(1, email);
				ps.setString(2, password);
				
				rs=ps.executeQuery();
				
				b=rs.next();
				
			} 
			catch (ClassNotFoundException e2) 
			{
				
				e2.printStackTrace();
			}
			catch (SQLException e2) 
			{
				
				e2.printStackTrace();
			}
			finally
			{
				try 
				{
					if(rs!=null)
					{
						rs.close();	
					}
					if(ps!=null)
					{
						ps.close();
					}
					if(con!=null)
					{
						con.close();
					}
					
				}
				catch (SQLException e2) 
				{
					
					e2.printStackTrace();
				}
			}
			return b;
		}
			
	
	 
	   
	   
	   
	    
	   public static void inertCustomer(Customer customer)
	   {
		   try
		   {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			
			ps=con.prepareStatement(insertqry);
			
			ps.setString(1,customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			ps.setString(4, customer.getPassword());
			ps.setString(5,customer.getState());
			
			ps.executeUpdate();
			
			
		    }
		   catch (ClassNotFoundException e) 
		   {
			e.printStackTrace();
		    } 
		   catch (SQLException e) 
		   {   
			e.printStackTrace();
	    	}
		   
		   finally
		   {
			   try 
			   {
				   if(ps!=null)
				   {
					   ps.close();
				   }
				   if(con!=null)
				   {
					   con.close();
				   }
				
			   } 
			   catch (SQLException e) 
			   {
			
				e.printStackTrace();
			}
			   
				  
			   
			   
		   }
	   
	   }

	
	
	   
}
