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

public class uploadServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 
        Double bprice = null;
        String uname= new String(request.getParameter("uname").getBytes("iso-8859-1"),"GB2312");
        String bname= new String(request.getParameter("bname").getBytes("iso-8859-1"),"GB2312" );
        System.out.println(uname);
        System.out.println(bname);
        String bintro= new String(request.getParameter("bintro").getBytes("iso-8859-1"),"GB2312");
        System.out.println(bintro);
        String bpic= new String(request.getParameter("bpic").getBytes("iso-8859-1"),"GB2312");
        System.out.println(bpic);
        String btime= new String(request.getParameter("btime").getBytes("iso-8859-1"),"GB2312");
        System.out.println(btime);
        String temp= new String(request.getParameter("bprice").getBytes("iso-8859-1"),"GB2312");
        String btype= new String(request.getParameter("btype").getBytes("iso-8859-1"),"GB2312");
        if(temp!=null)
		 {
			 bprice=Double.parseDouble(temp);
		 }
        System.out.println(bprice);
        
        String bstate= new String(request.getParameter("bstate").getBytes("iso-8859-1"),"GB2312" );

        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.insert4(uname,bname,btype,bprice,bintro,bpic,btime,bstate); 
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

