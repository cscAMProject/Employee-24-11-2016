package employee_action;


import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import employee.bean.Request;
import employee.dao.*;


public final class CreateRequestAction extends ActionSupport implements ModelDriven
{
	

employee.bean.Request request=new Request();
public String execute()throws Exception
{ 	
	EmployeeRequestDao.connect();
	 if((request=EmployeeRequestDao.saveRequest(request))!=null)
	 { 
		 
		 return "success";
	 }
	 else
		 return "error";
}

public Object getModel()
{
return request;	
}
}