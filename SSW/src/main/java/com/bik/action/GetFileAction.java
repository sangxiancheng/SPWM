package com.bik.action;

import hadoop.HdfsOp; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
  
import org.apache.struts2.ServletActionContext;  
  
import com.opensymphony.xwork2.ActionSupport; 



public class GetFileAction  extends ActionSupport{  
  
    public String execute() throws Exception {  
      
    	HdfsOp hdfsOp = new HdfsOp();
        HttpServletRequest request=ServletActionContext.getRequest();
        //HttpServletRequest request1=ServletActionContext.getRequest();
        String username=(String)request.getSession().getAttribute("username");

        List<Files> filesList=hdfsOp.showFile("/user/"+username+"/");
        request.setAttribute("filesList", filesList);
        
        return SUCCESS;   
    }  
  
}  