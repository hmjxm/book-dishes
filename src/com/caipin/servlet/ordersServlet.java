package com.caipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caipin.dao.caipinService;


public class ordersServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String orderid= new String (request.getParameter("orderid").getBytes("iso-8859-1"),"GB2312");
        String uname= new String (request.getParameter("uname").getBytes("iso-8859-1"),"GB2312" );
        String ordertime= new String (request.getParameter("ordertime").getBytes("iso-8859-1"),"GB2312" );
        String lper= new String (request.getParameter("lper").getBytes("iso-8859-1"),"GB2312" );
        String ltel1= new String (request.getParameter("ltel").getBytes("iso-8859-1"),"GB2312" );
        long ltel=Long.parseLong(ltel1);
        String loc= new String (request.getParameter("loc").getBytes("iso-8859-1"),"GB2312" );
        
        System.out.println(orderid);
        System.out.println(uname);
        System.out.println(ordertime);
        
        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.insert7(orderid,uname,ordertime,lper,ltel,loc); 
        	if(flag)
			{
				out.println("yes");
			}
			else
			{
				out.println("no");
			}
        }catch(Exception e){  
            e.printStackTrace();  
            
        }  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doGet(request, response);  
    }  
} 

