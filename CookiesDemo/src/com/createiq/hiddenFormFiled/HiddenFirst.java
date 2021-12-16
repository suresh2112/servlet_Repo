package com.createiq.hiddenFormFiled;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenFirst
 */
public class HiddenFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenFirst() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		String username=request.getParameter("username");
		printWriter.println("username"+username);
		
		printWriter.print("<form action='./HiddenSecond'>");
		printWriter.print("<input type='hidden' name='username' value='"+username+"'>");
		printWriter.print("<input type='submit' value='go'>");
		printWriter.print("</form>");
	}

	

}
