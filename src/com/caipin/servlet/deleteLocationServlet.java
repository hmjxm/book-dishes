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

public class deleteLocationServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String lid1= new String(request.getParameter("lid").getBytes("iso-8859-1"),"GB2312");
        int lid=Integer.parseInt(lid1);
      
        System.out.println(lid);

        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.deleteLocation(lid); 
			out.println(flag);
			out.flush();  
            out.close();//�ر�  
			
        }catch(Exception e){  
            e.printStackTrace();    
        }  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doGet(request, response);  
    }  
} 

