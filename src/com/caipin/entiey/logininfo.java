
package com.caipin.entiey;

public class logininfo {
	
	private String uname;  
	private String pwd; 
    private String touxiang;
    
    public logininfo() {  
        super();  
    }  
  
    public logininfo(String uname, String pwd, String touxiang) {  
        super();  
        this.uname = uname;  
        this.pwd = pwd;  
        this.touxiang = touxiang; 
    }  
  
    public String getUname() {  
        return uname;  
    }  
  
    public void setUname(String uname) {  
        this.uname = uname;  
    }  
  
    public String getPwd() {  
        return pwd;  
    }  
  
    public void setPwd(String pwd) {  
        this.pwd = pwd;  
    }  
   
    public String getTouxiang() {  
        return touxiang;  
    }  
    
    public void setTouxiang(String touxiang) {  
        this.touxiang=touxiang; 
    }
}  