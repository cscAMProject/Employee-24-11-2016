package login_action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import admin.bean.Users;
import login.dao.LoginDao;
public final class LoginCheckAction extends ActionSupport implements ModelDriven
{
Users user=new Users();//Don't delete this until you fix names-
private static final long serialVersionUID = 1L;

public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}  
public String execute() throws Exception
{ 	
	 LoginDao.connect();
	 Users user1=LoginDao.getUserById(user);
	
	 user.setEmpId(user1.getEmpId());
	 user.setFirstName(user1.getFirstName());
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
	 
	return "Error";
	
}



public Object getModel()
{
return user;	
}
}