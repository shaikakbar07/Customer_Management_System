package com.palle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.palle.dao.DataAccess;
import com.palle.model.Customer;
import com.palle.util.Successjsp;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path =request.getServletPath();
			switch(path)
			{
			case "/logCustomer":
				validateCustomer(request,response);
				break;
			
			
			case"/regCustomer":
				insertCustomer(request,response);
				break;
			
			case"/reg":
				getRegistration(request,response);
				break;
			
			
			
			case"/log":
				getLoginpage(request,response);
				break;
			default:
				getStartUpPage(request,response);
				break;
			}
			
		
	}


	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{

		 String e=request.getParameter("tbEmail");
		 String p=request.getParameter("tbpass");
		 
		boolean res= DataAccess.validateCustomer(e, p);
		
		if(res)
		{

			try 
			{
				RequestDispatcher rd=request.getRequestDispatcher("successjsp.jsp");
				
			
				Successjsp sp= new Successjsp();
				request.setAttribute("successDetails", sp);
				
				rd.forward(request, response);
			} 
			catch (ServletException e1) 
			{
				
				e1.printStackTrace();
			} catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}
		}
		else
		{
			getLoginpage(request,response);
			
		}
		
	}
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//read the data  from jsp pages
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbemail");
		Long m= Long.parseLong(request.getParameter("tbMobile"));
		String p=request.getParameter("tbpas");
		String s=request.getParameter("ddlStates");
		
		
	Customer c= new Customer (n,e,m,p,s);
	DataAccess.inertCustomer(c);
	
		
	
		
	try 
	    {
		RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
		rd.forward(request,response);
	    } 
	catch (ServletException e1) 
	    {
		
		e1.printStackTrace();
	    } 
	catch (IOException e1)
	    {
		 
		e1.printStackTrace();
	    }
 }


	private void getRegistration(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		    {
			RequestDispatcher rd=request.getRequestDispatcher("customer_registor.jsp");
			rd.forward(request,response);
		    } 
		catch (ServletException e) 
		    {
			
			e.printStackTrace();
		    } 
		catch (IOException e)
		    {
			 
			e.printStackTrace();
		    }
		
	}


	private void getLoginpage(HttpServletRequest request, HttpServletResponse response)
	{
		
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request,response);
		    } 
		catch (ServletException e) 
		    {
			
			e.printStackTrace();
		    } 
		catch (IOException e)
		    {
			 
			e.printStackTrace();
		    }
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		
		try {
			RequestDispatcher rd=request.getRequestDispatcher("customer_managements.jsp");
			rd.forward(request,response);
		    } 
		catch (ServletException e) 
		    {
			
			e.printStackTrace();
		    } 
		catch (IOException e)
		    {
			 
			e.printStackTrace();
		    }
	}  


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			doGet(request, response);
	}

}
