package edu.dmacc.javaee;

import java.util.List;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addItemServlet")
public class AddItem extends HttpServlet {
  public static Map<String,String> m = new LinkedHashMap<>();

  private static final long serialVersionUID = 1L;
  public void AddITem() {
    
  } 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    //System.out.println("777- s = "+s);
    //ListItems.l.add("Store: "+s+"  Items: "+i);
    //getServletContext().getRequestDispatcher("/addItem.html").forward(request, response); 
    response.getWriter().write(format(m));
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    String s = request.getParameter("store");
    String i = request.getParameter("item");
    
    m.put(s, i);    
    doGet(request, response);
  }
  /*
  private String fo(Map<String,String> mp) {
    List<String> l = new LinkedList<>();
    for(String k : mp.keySet()){
      l.add("[\""+k+"\",\""+mp.get(k)+"\"]");
    }
    return l.toString();
  }
  */
  // TODO: create array for items, so 2 stores don't override the items
  private String format(Map<String,String> mp) { 
    String out = "";
    for(String k : mp.keySet()){
      out+=",[\""+k+"\",\""+mp.get(k)+"\"]";
    }
    return "["+(out.length()<1?"":out.substring(1))+"]";
  }
}