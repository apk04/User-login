package loginProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forget")
public class ForgotPassword extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String id,dob,qr,psw="";
		id=request.getParameter("email");
		dob=request.getParameter("date");
		psw=id.substring(0,3)+dob.substring(8,10);
		qr="update user set pass='"+psw+"'where id=? and dob=?";
		
		try
		{
			Connection con=null;
			PreparedStatement ps=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/practice?user=root&password=root");
			ps=con.prepareStatement(qr);
			ps.setString(1, id);
			ps.setString(2, dob);
			int n=ps.executeUpdate();
			
			if(n>0)
			{
				out.println("<html><body bgcolor=#A15890><center>");
				out.println("Password updated successfully!!!");
				out.println("<a href='index.html'>Home</a>");
			}
			else
			{
				out.println("<html><body bgcolor=#A15890><center>");
				out.println("Sorry! Try again");
				out.println("<a href='index.html'>Home</a>");
			}
			ps.close();
			con.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
