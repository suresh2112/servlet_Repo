package com.createiq.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstHttpSessionServlet
 */
public class FirstHttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstHttpSessionServlet() {
        super();
       
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		String username=request.getParameter("username");
		printWriter.println("welcome"+username);
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		printWriter.println("<a href='./SecondHttpSessionServlet'>httpsecondservlet</a>");
		
		

	
	}

}
