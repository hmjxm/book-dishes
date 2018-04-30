
package com.caipin.entiey;

public class book {
	private int bid;
	private String uname;  
	private String touxiang; 
    private String bname;
    private Double bprice;
    private String bintro;
    private String bpic;
    private String btime;
    private String orderid;
    private String ordertime;
    private String lper;
    private long ltel;
    private String loc;
    private String bstate;
    private String temp;
    private String stime;  
    private int temp1;
    
    
    public book() {  
        super();  
    }  
  
    public book(int bid,String bname,Double bprice,String bpic,String temp) {  
        super(); 
        this.bid=bid;
        this.bname= bname; 
        this.bprice = bprice;
        this.bpic=bpic;
        this.temp=temp;
    }
    
    public book(int bid,String bname,Double bprice,String bintro,String bpic,String btime,String bstate) {  
        super(); 
        this.bid=bid;
        this.bname= bname; 
        this.bprice = bprice;
        this.bintro=bintro;
        this.bpic=bpic;
        this.btime=btime;
        this.bstate=bstate;
    }
    
    
    public book(String uname, String touxiang, String bname,Double bprice,String bintro,String bpic,String btime,int bid,String bstate) {  
        super();  
        this.uname = uname;  
        this.touxiang = touxiang;  
        this.bname= bname; 
        this.bprice = bprice;
        this.bintro=bintro;
        this.bpic=bpic;
        this.btime=btime;
        this.bid=bid;
        this.bstate=bstate;
    }  
    
    public book(String orderid,String ordertime,String lper,long ltel,String loc) {  
        super(); 
        this.orderid=orderid;
        this.ordertime=ordertime;
        this.lper=lper;
        this.ltel=ltel;
        this.loc=loc;
        
    }  
    
    public book(String orderid,String stime,String lper,long ltel,String loc,int temp1) {  
        super(); 
        this.orderid=orderid;
        this.stime=stime;
        this.lper=lper;
        this.ltel=ltel;
        this.loc=loc;
        this.temp1=temp1;
        
    }  
  
    
    public book(int bid,String bname,Double bprice,String bpic) {  
        super(); 
        this.bid=bid;
        this.bname= bname; 
        this.bprice = bprice;
        this.bpic=bpic;
    }
    
    public int getBid() {  
        return bid;  
    }  
  
    public void setBid(int bid) {  
        this.bid = bid;  
    }
    
    public String getUname() {  
        return uname;  
    }  
  
    public void setUname(String uname) {  
        this.uname = uname;  
    }  
  
    public String getTouxiang() {  
        return touxiang;  
    }  
  
    public void setTouxiang(String touxiang) {  
        this.touxiang = touxiang;  
    }  
  
    public String getBname() {  
        return bname;  
    }  
  
    public void setBname(String bname) {  
        this.bname = bname;  
    }  
   
    public Double getBprice() {  
        return bprice;  
    }  
    
    public void setBprice(Double bprice) {  
        this.bprice=bprice; 
    } 
    
    public void setBintro(String bintro) {  
        this.bintro= bintro;  
    }  
   
    public String getBintro() {  
        return bintro;  
    }  
    
    
    public void setBpic(String bpic) {  
        this.bpic = bpic;  
    }  
   
    public String getBpic() {  
        return bpic;  
    }  
    
    public void setBtime(String btime) {  
        this.btime = btime;  
    }  
   
    public String getBtime() {  
        return btime;  
    } 
    
    public void setOrderid(String orderid) {  
        this.orderid = orderid;  
    }  
    public String getOrderid() {  
        return orderid;  
    }
  
    public void setOrdertime(String ordertime) {  
        this.ordertime = ordertime;  
    }  
    public String getOrdertime() {  
        return ordertime;  
    }
    
    
    public String getStime() {  
        return stime;  
    }
    
    public void setStime(String stime) {  
        this.stime = stime;  
    }  
    
    
    public void setLper(String lper) {  
        this.lper = lper;  
    }  
    public String getLper() {  
        return lper;  
    }
    
    public void setLtel(long ltel) {  
        this.ltel = ltel;  
    }  
    public long getLtel() {  
        return ltel;  
    }
    
    public void setLoc(String loc) {  
        this.loc =loc;  
    }  
    public String getLoc() {  
        return loc;  
    }
    
    public void setBstate(String bstate) {  
        this.bstate=bstate;  
    }  
    public String getBstate() {  
        return bstate;  
    }
}  