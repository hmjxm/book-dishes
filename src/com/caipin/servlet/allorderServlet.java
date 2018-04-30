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


public class allorderServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String cpid= new String (request.getParameter("cpid").getBytes("iso-8859-1"),"GB2312" );
        String cptime= new String (request.getParameter("cptime").getBytes("iso-8859-1"),"GB2312" );
        String cpamount= new String (request.getParameter("cpamount").getBytes("iso-8859-1"),"GB2312" );
        String cpstate= new String (request.getParameter("cpstate").getBytes("iso-8859-1"),"GB2312" );
        String cpdesk= new String (request.getParameter("cpdesk").getBytes("iso-8859-1"),"GB2312" );
        
        System.out.println(cpid);
        System.out.println(cptime);
        System.out.println(cpamount);
        System.out.println(cpstate);
        System.out.println(cpdesk);
        
        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.insert1(cpid,cptime,cpamount,cpstate,cpdesk); 
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

