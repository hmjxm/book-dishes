package com.caipin.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.caipin.entiey.book;
import com.caipin.entiey.cpname;
import com.caipin.entiey.location;
import com.caipin.entiey.logininfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class caipinService {
	
	 public static List<cpname> getcaipin() throws SQLException{  
			
		 String sql="";
	        String a,b,d,e,f;
	        Integer c;
	        List<cpname> mLists = new ArrayList<cpname>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "select * from dishes";	
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {  
	            	a = rs.getString("DishesName");  
	                b = rs.getString("DishesType");  
	                c = rs.getInt("DishesPrice"); 
	                d=rs.getString("DishesPicture");
	                e=rs.getString("DishesIntro");
	                f=rs.getString("DishesFlag");
	                mLists.add(new cpname(a,b,c,d,e,f));//添加到List中  
	                System.out.println(a+b+c+d+e+f+'\n');
	            }  
	                
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getbook(String btype) throws SQLException{  			
		 String sql="";
	        String a,b,c,e,f,g,i;
	        Double d;
	        int h;
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select users.uname, users.touxiang,bname,bprice,bintro,bpic,btime,bid,bstate FROM users,uploadbook WHERE uploadbook.bstate=? and uploadbook.bflag=? and btype=? and users.uname=uploadbook.uname order by bid desc";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, "未卖出");
	        pstat.setString(2, "true");
	        pstat.setString(3,btype);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	        System.out.println("bbb");
            while(rs.next())  
            {      
            	System.out.println("aaa");
            	a = rs.getString("uname");  
                b = rs.getString("touxiang");  
                c = rs.getString("bname"); 
                d=rs.getDouble("bprice");
                e=rs.getString("bintro");
                f=rs.getString("bpic");
                g=rs.getString("btime");
                h=rs.getInt("bid");
                i=rs.getString("bstate");
                mLists.add(new book(a,b,c,d,e,f,g,h,i));//添加到List中  
                System.out.println(a+b+c+d+e+f+g+h+i+'\n');
            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> searchbook(String bkey) throws SQLException{  			
		 String sql="";
	        String a,b,c,e,f,g,i;
	        Double d;
	        int h;
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select users.uname, users.touxiang,bname,bprice,bintro,bpic,btime,bid,bstate FROM users,uploadbook WHERE uploadbook.bstate=? and uploadbook.bflag=? and bname like ? and users.uname=uploadbook.uname order by bid desc";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, "未卖出");
	        pstat.setString(2, "true");
	        pstat.setString(3, "%"+bkey+"%");
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {        
	            	a = rs.getString("uname");  
	                b = rs.getString("touxiang");  
	                c = rs.getString("bname"); 
	                d=rs.getDouble("bprice");
	                e=rs.getString("bintro");
	                f=rs.getString("bpic");
	                g=rs.getString("btime");
	                h=rs.getInt("bid");
	                i=rs.getString("bstate");
	                mLists.add(new book(a,b,c,d,e,f,g,h,i));//添加到List中  
	                System.out.println(c+'\n');
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getcart(String uname) throws SQLException{  			
		 String sql="";
	        String c,f,e;
	        int b;
	        Double d;
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select bid,bname,bprice,bpic FROM shopcart WHERE uname=?";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, uname);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	b=rs.getInt("bid");
	                c = rs.getString("bname"); 
	                d=rs.getDouble("bprice");
	                e="aa";
	                f=rs.getString("bpic");
	                mLists.add(new book(b,c,d,f,e));//添加到List中  
	                System.out.println(b+c+d+f+e+'\n');
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getmyorder(String uname) throws SQLException{  			
		    String sql="";
	        String a,b,c,e;
	        long d;
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select orderid,ordertime,lper,ltel,loc FROM book_orders WHERE uname=? ";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, uname);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	a = rs.getString("orderid");
	            	b = rs.getString("ordertime");
	            	c = rs.getString("lper");
	            	d=rs.getLong("ltel");
	            	e = rs.getString("loc");
	                System.out.println(a+b+c+d+e);
	                mLists.add(new book(a,b,c,d,e));//添加到List中  
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getmyorder1(String orderid) throws SQLException{  			
		    String sql="";
	        int a;
	        String b,d;
	        Double c;
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select bid,bname,bprice,bpic FROM book_orderdetail WHERE orderid=?";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, orderid);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	a = rs.getInt("bid");
	            	b = rs.getString("bname");
	            	c = rs.getDouble("bprice");
	            	d=rs.getString("bpic");
	                System.out.println(a+b+c+d);
	                mLists.add(new book(a,b,c,d));//添加到List中  
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getmyupload(String uname) throws SQLException{  			
		    String sql="";
		    int a;
	        String b,d,e,f,g;
	        Double c;
	        
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select bid,bname,bprice,bintro,bpic,btime,bstate FROM uploadbook WHERE uname=? and bstate=? and bflag=? order by bid desc";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, uname);
	        pstat.setString(2,"未卖出");
	        pstat.setString(3,"true");
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	a = rs.getInt("bid");
	            	b = rs.getString("bname");
	            	c = rs.getDouble("bprice");
	            	d=rs.getString("bintro");
	            	e=rs.getString("bpic");
	            	f = rs.getString("btime");
	            	g = rs.getString("bstate");
	                System.out.println(a+b+c+d+e+f+g);
	                mLists.add(new book(a,b,c,d,e,f,g));//添加到List中  
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getmysale(String uname) throws SQLException{  			
		    String sql="";
		    int a;
	        String b,d,e,f,g;
	        Double c;
	        
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select bid,bname,bprice,bintro,bpic,btime,bstate FROM uploadbook WHERE uname=? and bstate=? and bflag=? order by bid desc";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, uname);
	        pstat.setString(2,"已卖出");
	        pstat.setString(3,"true");
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	a = rs.getInt("bid");
	            	b = rs.getString("bname");
	            	c = rs.getDouble("bprice");
	            	d=rs.getString("bintro");
	            	e=rs.getString("bpic");
	            	f = rs.getString("btime");
	            	g = rs.getString("bstate");
	                System.out.println(a+b+c+d+e+f+g);
	                mLists.add(new book(a,b,c,d,e,f,g));//添加到List中  
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<book> getmysale1(int bid) throws SQLException{  			
		    String sql="";
	        String a,b,c,e;
	        long d;
	        List<book> mLists = new ArrayList<book>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select orderid,stime,lper,ltel,loc FROM book_saleinfo WHERE bid=?";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setInt(1, bid);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	a=rs.getString("orderid");
	            	b=rs.getString("stime");
	            	c=rs.getString("lper");
	            	d=rs.getLong("ltel");
	            	e=rs.getString("loc");
	                System.out.println(a+b+c+d+e);
	                mLists.add(new book(a,b,c,d,e,1));//添加到List中  
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 
	
	 
	 public static List<location> getlocation(String uname) throws SQLException{  			
		 String sql="";
	        String c,e;
	        int b;
			long d;
	        List<location> mLists = new ArrayList<location>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "Select lid,lper,ltel,loc FROM location WHERE uname=?";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1, uname);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {    
	            	b=rs.getInt("lid");
	                c = rs.getString("lper"); 
	                d=rs.getLong("ltel");
	                e=rs.getString("loc");
	                mLists.add(new location(b,c,d,e));//添加到List中  
	                System.out.println(b+c+d+e+'\n');
	            }  
	            conn.close();
	            return mLists;  
	        }
	 
	 public static List<logininfo> getlogin() throws SQLException{  
			
		 String sql="";
	        String a,b,c;
	        List<logininfo> mLists = new ArrayList<logininfo>();  
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "select * from users";	
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {  
	            	a = rs.getString("uname");  
	                b = rs.getString("pwd");  
	                c=rs.getString("touxiang");
	                mLists.add(new logininfo(a,b,c));//添加到List中  
	                System.out.println(a+b+c+'\n');
	            }  
                System.out.println("list为："+mLists);
	            conn.close();
	            return mLists;  
	        }
	 
	 public static String gettouxiang() throws SQLException{  
			
		 String sql="";
	        String a = null;
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "select * from touxiang";	
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        ResultSet rs= (ResultSet) pstat.executeQuery();
	            while(rs.next())  
	            {  
	            	a = rs.getString("touxiang");  
	                System.out.println(a+'\n');
	            }  
	                
	            conn.close();
	            return a;  
	        }
	 
	 public static boolean update(String uname,String touxiang) throws SQLException{   
	    	String sql="update users set touxiang=? where uname=?";
	    	Connection conn = (Connection) connection.getConnection();  
	    	PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setString(1,touxiang);
	    	pstat.setString(2,uname);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    
	    	
	  	}
	 
	 public static boolean updatebook(int bid) throws SQLException{   
	    	String sql="update uploadbook set bstate=? where bid=?";
	    	Connection conn = (Connection) connection.getConnection();  
	    	PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setString(1,"已卖出");
	    	pstat.setInt(2,bid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}

	 
	 public static  boolean insert(String cpid,String cpname,String cpnum,String cpprice) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into orderdetail(OrderID,Name,DetailQuantity,DetailPrice) values(?,?,?,?)";
	        Integer cpprice1=Integer.parseInt(cpprice);
	        Integer cpnum1=Integer.parseInt(cpnum);
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,cpid);
	     	   pstat.setString(2,cpname);
	     	    pstat.setInt(3,cpnum1);
	     	    pstat.setInt(4, cpprice1);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
     	    conn.close(); 
        	return flag;   
        	
	 }
	 
	 public static  boolean insert1(String cpid,String cptime,String cpamount,String cpstate,String cpdesk) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into orders(OrderID,OrderDate,OrderAmount,OrderState,DeskID) values(?,?,?,?,?)";
	        Integer cpamount1=Integer.parseInt(cpamount);
	        Integer cpdesk1=Integer.parseInt(cpdesk);
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,cpid);
	     	    pstat.setString(2,cptime);
	     	    pstat.setInt(3,cpamount1);
	     	   pstat.setString(4,cpstate);
	     	    pstat.setInt(5, cpdesk1);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
  	    conn.close(); 
     	return flag;   
     	
	 }
	 
	 
	 public static  boolean insert2(String touxiang) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into touxiang(touxiang) values(?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,touxiang);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
	    conn.close(); 
  	return flag;   
  	
	 }
	 
	 public static  boolean insert3(String uname,String pwd,String touxiang) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into users(uname,pwd,touxiang) values(?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=true;
	     	pstat.setString(1,uname);
	        pstat.setString(2,pwd);
	     	pstat.setString(3,touxiang);
	     	
	     	String sql1="select * from users";	//获取te数据库中users表中所有的数据
		    PreparedStatement pstat1=(PreparedStatement) conn.prepareStatement(sql1);//对sql1语句进行预处理
			ResultSet rs= (ResultSet) pstat1.executeQuery(); //执行sql1语句将获取的值放在rs集合中
		    while(rs.next())    //判断前端输入的用户名是否存在于数据库中
		    {
		            String userName = rs.getString("uname");
		            if((uname.equals(userName))) //若输入的用户名已经存在，则不可以进行注册，返回0；
		            {
		                   flag=false;
		            }
		    }	
		    if(flag==true)//若用户名不存在且密码长度>=6，则可以进行注册，返回1；
		    {
		    	pstat.executeUpdate();
		    }
	        pstat.close();
	    conn.close(); 
	return flag;   
	
	 }
	 
	 public static  boolean insert4(String uname,String bname,String btype,Double bprice,String bintro,String bpic,String btime, String bstate) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into uploadBook(uname,bname,btype,bprice,bintro,bpic,btime,bstate,bflag) values(?,?,?,?,?,?,?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,uname);
	     	    pstat.setString(2,bname);
	     	    pstat.setString(3,btype);
	     	    pstat.setDouble(4,bprice);
	     	    pstat.setString(5,bintro);
	     	    pstat.setString(6,bpic);
	     	   pstat.setString(7,btime);
	     	  pstat.setString(8,bstate);
	     	 pstat.setString(9,"true");
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
	    conn.close(); 
	return flag;   
	
	 }
	 
	 public static  int insert5(int bid,String uname,String bname,Double bprice,String bpic) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into shopCart(bid,uname,bname,bprice,bpic) values(?,?,?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        int flag=1;
        	pstat.setInt(1,bid);
     	    pstat.setString(2,uname);
     	    pstat.setString(3,bname);
     	    pstat.setDouble(4,bprice);
     	    pstat.setString(5,bpic);
     	    
     	    String sql1="select * from shopcart";	
		    PreparedStatement pstat1=(PreparedStatement) conn.prepareStatement(sql1);//对sql1语句进行预处理
			ResultSet rs= (ResultSet) pstat1.executeQuery(); //执行sql1语句将获取的值放在rs集合中
		    while(rs.next())    //判断前端输入的用户名是否存在于数据库中
		    {
		            String userName = rs.getString("uname");
		            int bid1=rs.getInt("bid");
		            if((uname.equals(userName))&&(bid1==bid)) //若输入的用户名已经存在，则不可以进行注册，返回0；
		            {
		                   flag=0;
		            }
		    }	
		    if(flag==1)
		    {
		    	pstat.executeUpdate();
		    }
	        pstat.close();
	        pstat1.close();
	    conn.close(); 
	return flag;  
	 }
	 
	 public static  boolean insert6(String uname,String lper,Long ltel,String loc) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into location(uname,lper,ltel,loc) values(?,?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,uname);
	     	    pstat.setString(2,lper);
	     	    pstat.setLong(3,ltel);
	     	    pstat.setString(4,loc);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
	    conn.close(); 
	return flag;   
	 }
	 
	 public static  boolean insert7(String orderid,String uname,String ordertime,String lper,long ltel,String loc) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into book_orders(orderid,uname,ordertime,lper,ltel,loc) values(?,?,?,?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,orderid);
	     	    pstat.setString(2,uname);
	     	    pstat.setString(3,ordertime);
	     	    pstat.setString(4,lper);
	     	    pstat.setLong(5, ltel);
	     	    pstat.setString(6, loc);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
	    conn.close(); 
  	return flag;   
  	
	 }
	 
	 public static  boolean insert8(int bid,String orderid,String bname,Double bprice,String bpic) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into book_orderdetail(bid,orderid,bname,bprice,bpic) values(?,?,?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	        	pstat.setInt(1,bid);
	     	    pstat.setString(2,orderid);
	     	    pstat.setString(3,bname);
	     	    pstat.setDouble(4,bprice);
	     	    pstat.setString(5, bpic);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
	    conn.close(); 
	return flag;   
	
	 }
	 
	 
	 public static  boolean insert9(String orderid,int bid,String ordertime,String lper,long ltel,String loc) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "insert into book_saleinfo(orderid,bid,stime,lper,ltel,loc) values(?,?,?,?,?,?)";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        boolean flag=false;
	        try{
	     	    pstat.setString(1,orderid);
	     	    pstat.setInt(2, bid);
	     	    pstat.setString(3,ordertime);
	     	    pstat.setString(4,lper);
	     	    pstat.setLong(5,ltel);
	     	    pstat.setString(6,loc);
	     	   if(pstat.executeUpdate()==1)
	        	{
	     		    flag=true;
		        	pstat.close();
		     	    conn.close(); 
	        	} 
	      	 }
	     	   catch(SQLException e){
	     	    e.printStackTrace();
	     	   }
	        pstat.close();
	    conn.close(); 
	return flag;   
	 }
	 
	 
	 public static boolean deleteCart(int bid,String uname) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="DELETE FROM shopcart WHERE bid=? and uname=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setInt(1, bid);
	    	pstat.setString(2,uname);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}

	 public static boolean deleteLocation(int lid) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="DELETE FROM location WHERE lid=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setInt(1, lid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}
	 
	 public static boolean deleteOrderDetail(int bid,String orderid) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="DELETE FROM book_orderdetail WHERE bid=? and orderid=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setInt(1, bid);
	    	pstat.setString(2, orderid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}
	 
	 public static boolean deleteOrder(String orderid) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="DELETE FROM book_orders WHERE orderid=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setString(1, orderid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}
	 
	 public static boolean deletemyupload(int bid) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="update uploadbook set bflag=? WHERE bid=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1,"false");
	    	pstat.setInt(2, bid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}
	 
	 public static boolean deleteSaleInfo(int bid,String orderid) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="DELETE FROM book_saleinfo WHERE bid=? and orderid=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setInt(1, bid);
	    	pstat.setString(2, orderid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}
	 
	 public static boolean deleteSale(int bid) throws SQLException{ 
		    String sql="";
	        Connection conn = (Connection) connection.getConnection(); 
	        sql="update uploadbook set bflag=? WHERE bid=?"; 
	        PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1,"false");
	    	pstat.setInt(2, bid);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    	 
	  	}
	 
	 public static  boolean query(int bid,String uname) throws SQLException{  
		    String sql2="select bid,uname from uploadbook";	
		    Connection conn = (Connection) connection.getConnection(); 
		    PreparedStatement pstat2=(PreparedStatement) conn.prepareStatement(sql2);
			ResultSet rs2= (ResultSet) pstat2.executeQuery(); 
			boolean flag=true;
		    while(rs2.next())    
		    {
		            String userName1 = rs2.getString("uname");
		            int bid2=rs2.getInt("bid");
		            if((uname.equals(userName1))&&(bid2==bid)) 
		            {
		                   flag=false;
		            }
		    }
	        pstat2.close();
	    conn.close(); 
	return flag;  
	 }
	 
	 public static  String querystate(int bid) throws SQLException{  
		    String sql="select bstate from uploadbook where bid=?";	
		    String bstate = null;
		    Connection conn = (Connection) connection.getConnection(); 
		    PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
		    pstat.setInt(1,bid);
			ResultSet rs= (ResultSet) pstat.executeQuery(); 
			while(rs.next()){
				bstate=rs.getString("bstate");
			}
			conn.close();
			return bstate;  
	 }
	 
	 public static  Boolean update1(String uname,String pwd) throws SQLException{  
		    String sql="";
	        Connection conn = (Connection) connection.getConnection();  
	        sql = "update users set pwd=? where uname=?";
	        PreparedStatement pstat = (PreparedStatement) conn.prepareStatement(sql);
	        pstat.setString(1,pwd);
	    	pstat.setString(2,uname);
	    	
	        Boolean flag=false;
  	    
  	        String sql1="select * from users";	
		    PreparedStatement pstat1=(PreparedStatement) conn.prepareStatement(sql1);//对sql1语句进行预处理
			ResultSet rs= (ResultSet) pstat1.executeQuery(); //执行sql1语句将获取的值放在rs集合中
		    while(rs.next())    //判断前端输入的用户名是否存在于数据库中
		    {
		            String userName = rs.getString("uname");
		            if(uname.equals(userName))
		            {
		                   flag=true;
		            }
		    }	
		    if(flag==true)
		    {
		    	pstat.executeUpdate();
		    }
	        pstat.close();
	        pstat1.close();
	    conn.close(); 
	return flag;  
	 }
	 
	 public static boolean updatepwd(String uname,String pwd) throws SQLException{   
	    	String sql="update users set pwd=? where uname=?";
	    	Connection conn = (Connection) connection.getConnection();  
	    	PreparedStatement pstat=(PreparedStatement) conn.prepareStatement(sql);
	    	pstat.setString(1,pwd);
	    	pstat.setString(2,uname);
	    	if(pstat.executeUpdate()==1)
	    	{
	    		conn.close();
	    		return true;
	    	}  	
	    	return false;    
	    	
	  	}
}
