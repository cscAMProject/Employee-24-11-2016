package login.dao;
import java.sql.*;

import admin.bean.Users;

public class LoginDao 
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

	public static Users getUserById(Users user)
	{
		try
		{
			PreparedStatement pmt=con.prepareStatement("select * from users where emp_id=? && password=?");
			pmt.setInt(1, user.getEmpId());
			pmt.setString(2, user.getPassword());
			ResultSet rs=pmt.executeQuery();
			
			if(rs.next())
			{
				Users u= new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11));
				 
				 return u;
			}
		}
		
		catch(SQLException e){e.printStackTrace();}
		
		return null;		
	}
}  
 