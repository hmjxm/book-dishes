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

public class getMyUploadServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
        
        String uname= new String(request.getParameter("uname").getBytes("iso-8859-1"),"GB2312");
        System.out.println(uname);
        try{  
            PrintWriter out = response.getWriter();  
            List<book> books = caipinService.getmyupload(uname);//返回JsonService的数据       
            System.out.println("books为："+books);
            StringBuffer sb = new StringBuffer();//数据缓存  
            sb.append('[');  
  
            for (book book : books) {  
            	sb.append('{').append("\"bid\":").append("\""+book.getBid()+"\"").append(",");
            	sb.append("\"bname\":").append("\""+book.getBname()+"\"").append(",");
            	sb.append("\"bprice\":").append("\""+book.getBprice()+"\"").append(",");
            	sb.append("\"bintro\":").append("\""+book.getBintro()+"\"").append(",");
            	sb.append("\"bpic\":").append("\""+book.getBpic()+"\"").append(",");
            	sb.append("\"btime\":").append("\""+book.getBtime()+"\"").append(",");
            	sb.append("\"bstate\":").append("\""+book.getBstate()+"\"");
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