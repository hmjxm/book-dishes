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
import com.caipin.entiey.cpname;
import com.caipin.entiey.logininfo;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8"); 
		
		try{  
            PrintWriter out = response.getWriter();  
            List<logininfo> logininfoes = caipinService.getlogin();//返回JsonService的数据       
  
            StringBuffer sb = new StringBuffer();//数据缓存  
            sb.append('[');  
  
            for (logininfo logininfo: logininfoes) {
            	sb.append('{').append("\"uname\":").append("\""+logininfo.getUname()+"\"").append(",");  
                sb.append("\"pwd\":").append("\""+logininfo.getPwd()+"\"").append(",");  
                sb.append("\"touxiang\":").append("\""+logininfo.getTouxiang()+"\""); 
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
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	}

