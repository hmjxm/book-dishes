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

public class insertLocationServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String uname= new String(request.getParameter("uname").getBytes("iso-8859-1"),"GB2312");
        System.out.println(uname);
        String lper= new String(request.getParameter("lper").getBytes("iso-8859-1"),"GB2312" );
        System.out.println(lper);
        String ltel1= new String(request.getParameter("ltel").getBytes("iso-8859-1"),"GB2312");
        Long ltel=Long.valueOf(ltel1);
        String loc= new String(request.getParameter("loc").getBytes("iso-8859-1"),"GB2312");
        System.out.println(ltel);
        System.out.println(loc);

        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.insert6(uname,lper,ltel,loc); 
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

