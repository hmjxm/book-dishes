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


public class updateServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String uname= new String (request.getParameter("uname").getBytes("iso-8859-1"),"GB2312" );
        String touxiang= new String (request.getParameter("touxiang").getBytes("iso-8859-1"),"GB2312" );
        
        System.out.println(uname);
        System.out.println(touxiang);
        
        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.update(uname,touxiang);
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

