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


public class orderdetailServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8"); 

        String bid1= new String (request.getParameter("bid").getBytes("iso-8859-1"),"GB2312" );
        int bid=Integer.parseInt(bid1);
        String orderid= new String (request.getParameter("orderid").getBytes("iso-8859-1"),"GB2312" );
        String bname= new String (request.getParameter("bname").getBytes("iso-8859-1"),"GB2312" );
        String bprice1= new String (request.getParameter("bprice").getBytes("iso-8859-1"),"GB2312" );
        Double bprice=Double.parseDouble(bprice1);
        String bpic= new String (request.getParameter("bpic").getBytes("iso-8859-1"),"GB2312" );
        
        System.out.println(orderid);
        System.out.println(bname);
        System.out.println(bprice);
        System.out.println(bpic);
        
        PrintWriter out=response.getWriter();
        try{  
        	boolean flag=caipinService.insert8(bid,orderid,bname,bprice,bpic); 
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

