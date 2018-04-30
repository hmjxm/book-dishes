package com.caipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caipin.dao.caipinService;
import com.caipin.entiey.book;
import com.caipin.entiey.cpname;

public class getMySaleServlet1 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
        
        String bid1= new String(request.getParameter("bid").getBytes("iso-8859-1"),"GB2312");
        int bid=Integer.parseInt(bid1);
        try{  
            PrintWriter out = response.getWriter();  
            List<book> books = caipinService.getmysale1(bid);//返回JsonService的数据       
            System.out.println("books为："+books);
            StringBuffer sb = new StringBuffer();//数据缓存  
            sb.append('[');  
  
            for (book book : books) {  
            	sb.append('{').append("\"orderid\":").append("\""+book.getOrderid()+"\"").append(",");
            	sb.append("\"stime\":").append("\""+book.getStime()+"\"").append(",");
            	sb.append("\"lper\":").append("\""+book.getLper()+"\"").append(",");
            	sb.append("\"ltel\":").append("\""+book.getLtel()+"\"").append(",");
            	sb.append("\"loc\":").append("\""+book.getLoc()+"\"");
                sb.append('}').append(",");  
            }  
            sb.deleteCharAt(sb.length() - 1);  
            sb.append(']');  
            out.write(new String(sb));  
            out.flush();  
            out.close();//关闭  
        }catch(Exception e){  
            System.out.println(e);  
            e.printStackTrace();  
        }  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doGet(request, response);  
    }  
  
  
} 