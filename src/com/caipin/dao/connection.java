package com.caipin.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static Connection getConnection() {
		Connection connect=null;
		   try {
		          Class.forName("com.mysql.jdbc.Driver");   //�����������ݿ������
		         System.out.println("Success loading Mysql Driver!");
		        }
		        catch (Exception e) {
		          System.out.print("Error loading Mysql Driver!");
		          e.printStackTrace();
		        }
			 
		  try {
			     connect = DriverManager.getConnection(
	         		 "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8","root","1234"); //ʹ�á�root���û���������Ϊte�����ݿ�                                                                                  

        }catch (SQLException e) {
               e.printStackTrace();
           }
		  System.out.println("Success connect Mysql server!");
		  return connect;
	}
}
