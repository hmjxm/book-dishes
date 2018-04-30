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
import com.caipin.entiey.location;

public class selectLocationServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
        
        String uname= new String(request.getParameter("uname").getBytes("iso-8859-1"),"GB2312");
        System.out.println(uname);
        try{  
            PrintWriter out = response.getWriter();  
            List<location> locations = caipinService.getlocation(uname);//返回JsonService的数据    
            System.out.println(locations);
  
            StringBuffer sb = new StringBuffer();//数据缓存  
            sb.append('[');  
  
            for (location location : locations) {  
            	sb.append('{').append("\"lid\":").append("\""+location.getLid()+"\"").append(",");  
            	sb.append("\"lper\":").append("\""+location.getLper()+"\"").append(","); 
                sb.append("\"ltel\":").append("\""+location.getLtel()+"\"").append(",");
                sb.append("\"loc\":").append("\""+location.getLoc()+"\"");
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