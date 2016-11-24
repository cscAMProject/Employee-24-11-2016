package login_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import admin.bean.Users;
import login.dao.LoginDao;
public final  class LoginAction extends ActionSupport implements ModelDriven,ServletRequestAware
{
	HttpSession session;
Users user=new Users();//Don't delete this until you fix names-
private static final long serialVersionUID = 1L;

public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}  

public String execute()throws Exception
{ 	
	LoginDao.connect();
		
	Users user1=LoginDao.getUserById(user);
	if(user1!=null)
	{
		
		 user.setEmpId(user1.getEmpId());
		 user.setFirstName(user1.getFirstName());
		 session.setAttribute("userName",user1.getFirstName());
		 user.setLastName(user1.getLastName());
		 user.setEmailId(user1.getEmailId());
		 user.setShortId(user1.getShortId());
		 user.setPassword(user1.getPassword());
		 user.setMobile(user1.getMobile());
		 user.setManagerId(user1.getManagerId());
		 user.setDesignation(user1.getDesignation());
		 user.setDateOfJoining(user1.getDateOfJoining());
		 user.setActive(user1.getActive());
			
		if(user.getActive().equals("Active") || user.getActive().equals("active"))
		{
		if(user.getDesignation().equals("employee"))
			 		 return "successEmployee";
		 
		 else if(user.getDesignation().equals("Admin"))
			 		 return "sucsessAdmin";
		 
		 else if(user.getDesignation().equals("Manager"))
			 		 return "successManager";
		 
		 else if(user.getDesignation().equals("Support"))
			 		 return "successSupport";
		}
		return "errorActive";
	}	
	
	return "error";
}
public String logout()throws Exception
{ 	
	
	if(session!=null)
	{
session.invalidate();
	}
return "success";
	

}

public Object getModel()
{
return user;	
}

@Override
public void setServletRequest(HttpServletRequest request) {
	// TODO Auto-generated method stub
	this.session=request.getSession();
	
}




}