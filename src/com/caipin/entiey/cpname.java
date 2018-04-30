
package com.caipin.entiey;

public class cpname {
	
	private String dname;  
	private String dtype; 
	private Integer dprice; 
    private String dpicture;
    private String dintro;
    private String dflag;
    
    public cpname() {  
        super();  
    }  
  
    public cpname(String dname, String dtype, Integer dprice,String dpicture,String dintro,String dflag) {  
        super();  
        this.dname = dname;  
        this.dtype = dtype;  
        this.dprice = dprice; 
        this.dpicture = dpicture;
        this.dintro=dintro;
        this.dflag=dflag;
    }  
  
    public String getDname() {  
        return dname;  
    }  
  
    public void setDname(String dname) {  
        this.dname = dname;  
    }  
  
    public String getDtype() {  
        return dtype;  
    }  
  
    public void setDtype(String dtype) {  
        this.dtype = dtype;  
    }  
  
    public Integer getDprice() {  
        return dprice;  
    }  
  
    public void setDprice(Integer dprice) {  
        this.dprice = dprice;  
    }  
   
    public String getDpicture() {  
        return dpicture;  
    }  
    
    public void setDpicture(String dpicture) {  
        this.dpicture=dpicture; 
    } 
    
    public void setDintro(String dintro) {  
        this.dintro= dintro;  
    }  
   
    public String getDintro() {  
        return dintro;  
    }  
    
    
    public void setDflag(String dflag) {  
        this.dflag = dflag;  
    }  
   
    public String getDflag() {  
        return dflag;  
    }  
  
}  