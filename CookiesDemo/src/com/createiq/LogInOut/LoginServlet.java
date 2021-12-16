package com.createiq.LogInOut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter printWriter=response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		if(password.equals("suresh123")&&username.equals("ammulu")) {
			printWriter.print("<h1> WELCOME...."+username+"</h1>");
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			printWriter.print("<h2>login successfully</h2>");
		}
		else {
		printWriter.print("<h1>please enter correct detalis</h1>");
		request.getRequestDispatcher("login.html").include(request, response);
		
	}
	}
}
