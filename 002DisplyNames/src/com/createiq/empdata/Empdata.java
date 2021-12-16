package com.createiq.empdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

/**
 * Servlet implementation class Empdata
 */
public class Empdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter printWriter=response.getWriter();
	String ename=request.getParameter("ename");
	int eid=Integer.parseInt(request.getParameter("eid"));
	double salary=Double.parseDouble(request.getParameter("salary"));
	System.out.println(ename+" "+eid+" "+salary);
	
	
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root","root");
	preparedStatement=connection.prepareStatement("INSERT INTO EMPDATA(ENAME,EID,SALARY)VALUES(?,?,?)");
	preparedStatement.setString(1, ename);
	preparedStatement.setInt(2, eid);
	preparedStatement.setDouble(3, salary);
	preparedStatement.executeUpdate();
	System.out.println("INSERTED SUCCESSFULLY");
	preparedStatement=connection.prepareStatement("UPDATE EMPDATA SET ENAME=?,SALARY=? WHERE EID=?");
	preparedStatement.setString(1, ename);
	preparedStatement.setDouble(2, salary);
	preparedStatement.setInt(3, eid);
	
	preparedStatement.executeLargeUpdate();
	System.out.println("update suuceess");
	
	preparedStatement=connection.prepareStatement("delete from empdata where eid=");
	
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	}

}
