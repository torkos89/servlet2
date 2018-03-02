package edu.dmacc.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewAllItemsServlet")
public class ViewAllItemsServlet extends HttpServlet { 
  private static final long serialVersionUID = 1L;
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //response.sendRedirect(request.getScheme()+"://"+request.getServerName()+"/");
    
    PrintWriter writer = response.getWriter();
    for(String s:ListItems.l) {
      writer.println(s);   
    }
    writer.close();
    
   // getServletContext().getRequestDispatcher("/viewAllItems.html").forward(request, response); 
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    doGet(request, response);
  }
}