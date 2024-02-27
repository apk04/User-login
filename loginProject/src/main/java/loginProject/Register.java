package loginProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String uid,ps,nm,dob,qr;
		uid=request.getParameter("email");
		ps=request.getParameter("psw");
		nm=request.getParameter("name");
		dob=request.getParameter("date");
		qr="insert into user values(?,?,?,?)";
		
		try
		{
			Connection con=null;
			PreparedStatement pst=null;
			//ResultSet rs=null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/practice?user=root&password=root");
			pst=con.prepareStatement(qr);
			pst.setString(1, uid);
			pst.setString(2, ps);
			pst.setString(3, nm);
			pst.setString(4, dob);
			int n=pst.executeUpdate();
			if(n>0)
			{
				out.println("<html><body bgcolor=#A15890><center>");
				out.println("User data added successfully!!!");
				out.println("<a href='index.html'>Home</a>");
			}
			else
			{
				out.println("<html><body bgcolor=#A15890><center>");
				out.println("Sorry! Try again");
				out.println("<a href='index.html'>Home</a>");
			}
			pst.close();
			con.close();
		}
		catch (Exception e)
		{
			out.println("<br><br><center><h1>Please recheck<br>Enter valid date or birth or Email id</h1>");
			e.printStackTrace();
		}
		out.close();
	}

}
