package employee.dao;
import java.sql.*;

import admin.bean.Users;
import employee.bean.Request;
import employee_action.CreateRequestAction;
public class EmployeeRequestDao 
{
	public static Connection con;
	Date date = new Date(0);

	public static void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/amp","root","cscindia@123");  
	   }
		catch (Exception e)
		{
		System.out.println(e);
		}	
		}
	
	public static Request saveRequest(Request request)
	{
		try
		{
			PreparedStatement pmt=con.prepareStatement("insert into requests(empId,assetName,requestDate,status,requestType) values(?,?,?,?,?,?,?)");	
			pmt.setInt(1, request.getEmpId());
			pmt.setString(2, request.getManagerApprovedDate());
			pmt.setString(3, request.getAssetName());
			pmt.setString(4, request.getRequestDate());
			pmt.setString(5, request.getStatus());
			pmt.setString(6, request.getRequestType());
			
		int n=pmt.executeUpdate();
		if(n>0)return request;
		}
		catch(SQLException se) 
		{
		se.printStackTrace();
		}
		return null;
	}
	
	public static Users getUserById(int empId)
	{
		try
		{
			PreparedStatement pmt=con.prepareStatement("select * from users where emp_id=?" );
			pmt.setInt(1, empId);
			ResultSet rs=pmt.executeQuery();
			if(rs.next())
				return new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11));
		}
		
		catch(SQLException e){e.printStackTrace();}
		{
			
			
		}
		return null;
		
	}
}  
 
			
			
			
			
			
			