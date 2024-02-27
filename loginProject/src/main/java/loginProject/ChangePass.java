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
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String ps,cps,qr,id,psw="";
		ps=request.getParameter("cpsw");
		cps=request.getParameter("psw");
		
		HttpSession session=request.getSession();
		id=(String)session.getAttribute("userid");
		qr="select * from user where id=? and pass=?";
		
		try 
		{
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/practice?user=root&password=root");
			pst=con.prepareStatement(qr);
			pst.setString(1, id);
			pst.setString(2, ps);
			rs=pst.executeQuery();
			if(rs.next())
			{
				qr="update user set pass=? where id=?";
				PreparedStatement pst2;
				pst2=con.prepareStatement(qr);
				pst2.setString(1, cps);
				pst2.setString(2, id);
				int n=pst2.executeUpdate();
				if(n>0)
				{
					out.println("<body bgcolor=#A15890><center>");
					out.println("<h1>Password Updated Sucessfully!!!</h1>");
					out.println("<input type='button' value='Back' onclick='history.back()'>");
				}
				else
				{
					out.println("<body bgcolor=red><center>");
					out.println("<h1>Password Mismatched!!!</h1>");
					out.println("<input type='button' value='Back' onclick='history.back()'>");
				}
			}
			else
			{
				out.println("<body bgcolor=red><center>");
				out.println("<h1>Password Mismatched!!!</h1>");
				out.println("<input type='button' value='Back' onclick='history.back()'>");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		out.close();
		
		
		
	}
}
