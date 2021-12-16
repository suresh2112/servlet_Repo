package com.createiq.LogInOut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username=request.getParameter("username");
		PrintWriter printWriter=response.getWriter();
		
		request.getRequestDispatcher("index.html").include(request, response);
		HttpSession httpSession=request.getSession(false);
		if(httpSession!=null) {
			printWriter.print("<h1> home page..."+httpSession.getAttribute("username")+"....loaded</h1>");
			
		}
		else {
			printWriter.print("please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
	
	}

}
