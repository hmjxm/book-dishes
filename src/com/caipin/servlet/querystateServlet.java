package com.caipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caipin.dao.caipinService;

public class querystateServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 
        String bid1= new String(request.getParameter("bid").getBytes("iso-8859-1"),"GB2312");
        int bid=Integer.parseInt(bid1);
        PrintWriter out=response.getWriter();
        try{  
        	String flag=caipinService.querystate(bid); 
        	System.out.println(flag);
			out.println(flag);
			out.flush();  
            out.close();//¹Ø±Õ  
			
        }catch(Exception e){  
            e.printStackTrace();    
        }  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doGet(request, response);  
    }  
} 

