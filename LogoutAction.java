package login_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import admin.bean.Users;
import employee.bean.Request;
import login.dao.LoginDao;
public final  class LogoutAction extends ActionSupport implements ServletRequestAware
{
	HttpSession session;

private static final long serialVersionUID = 1L;

@Override
public void setServletRequest(HttpServletRequest request)
{
	// TODO Auto-generated method stub
	this.session=request.getSession();
	
}
public String execute()throws Exception
{ 	
	if(session!=null)
	{
session.invalidate();
	}
return "success";
	

}


}



