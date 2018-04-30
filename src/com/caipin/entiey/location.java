
package com.caipin.entiey;

public class location {
	private String lper;  
	private long ltel; 
    private String loc;
    private int lid;
    
    public location() {  
        super();  
    }  
  
    public location(int lid,String lper,long ltel,String loc) {  
        super(); 
        this.lper= lper; 
        this.ltel= ltel;
        this.loc=loc;
        this.lid=lid;
    }  
    
   public int getLid(){
	   return lid;
   }
   public void setLid(int lid){
	   this.lid=lid;
   }
  
    public String getLper() {  
        return lper;  
    }  
  
    public void setLper(String lper) {  
        this.lper = lper;  
    }  
  
    public long getLtel() {  
        return ltel;  
    }  
  
    public void setLtel(long ltel) {  
        this.ltel = ltel;  
    }  
  
    public String getLoc() {  
        return loc;  
    }  
  
    public void setLoc(String loc) {  
        this.loc = loc;  
    }  
   
  
}  