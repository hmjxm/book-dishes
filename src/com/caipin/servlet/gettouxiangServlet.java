package com.caipin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caipin.dao.caipinService;
import com.caipin.entiey.cpname;

public class gettouxiangServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
  
        try{  
            PrintWriter out = response.getWriter();  
            String touxiang= caipinService.gettouxiang();//返回JsonService的数据       
  
            StringBuffer sb = new StringBuffer();//数据缓存  
            sb.append('[');  
            sb.append('{').append("\"touxiang\":").append("\""+touxiang+"\"");  
            sb.append('}');  
             
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