package edu.dmacc.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloServlet(){
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String f = request.getParameter("first").length()==0?"n":request.getParameter("first");
		String l = request.getParameter("last").length()==0?"a":request.getParameter("last");
		PrintWriter writer = response.getWriter();
		writer.println("Hello, "+format(f)+" "+format(l));
		writer.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	private String format(String s) {
	  String fn = s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
	  return fn;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
}