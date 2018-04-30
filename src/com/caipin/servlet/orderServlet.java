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


public class orderServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String cpid= new String (request.getParameter("cpid").getBytes("iso-8859-1"),"GB2312" );
        String cpname= new String (request.getParameter("cpname").getBytes("iso-8859-1"),"GB2312" );
        String cpnum= new String (request.getParameter("cpnum").getBytes("iso-8859-1"),"GB2312" );
        String cpprice= new String (request.getParameter("cpprice").getBytes("iso-8859-1"),"GB2312" );
        
        System.out.println(cpid);
        System.out.println(cpname);
        System.out.println(cpnum);
        System.out.println(cpprice);
        
        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.insert(cpid,cpname,cpnum,cpprice); 
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

