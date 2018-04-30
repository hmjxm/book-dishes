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

public class getcpServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");  
  
        try{  
            PrintWriter out = response.getWriter();  
            List<cpname> dishes = caipinService.getcaipin();//返回JsonService的数据       
  
            StringBuffer sb = new StringBuffer();//数据缓存  
            sb.append('[');  
  
            for (cpname dish : dishes) {
            	sb.append('{').append("\"dname\":").append("\""+dish.getDname()+"\"").append(",");  
                sb.append("\"dtype\":").append("\""+dish.getDtype()+"\"").append(",");  
                sb.append("\"dprice\":").append("\""+dish.getDprice()+"\"").append(","); 
                sb.append("\"dpicture\":").append("\""+dish.getDpicture()+"\"").append(",");
                sb.append("\"dintro\":").append("\""+dish.getDintro()+"\"").append(",");
                sb.append("\"dflag\":").append("\""+dish.getDflag()+"\"").append(",");
                sb.append("\"dnum\":").append("\""+ 0 +"\"");
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