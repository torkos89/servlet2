package edu.dmacc.javaee;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// create set servlet 
public class ListItems {
 // protected final HashMap<String,LinkedList<String>> M = new HashMap(String,LinkedList<String>);
  public static LinkedList<String> l = new LinkedList<String>();
  public static ListItems li = new ListItems();
  public ListItems() {
     
  }
  public ListItems addItem(String s) {
    l.add(s);
    return this;
  }
}