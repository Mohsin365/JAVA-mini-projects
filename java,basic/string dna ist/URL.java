
/**
 * Write a description of part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
public class URL {
    String findURL(String url){
    URLResource ur=new URLResource("url");
    
    for(String s: ur.words()){
        if(s.contains("YouTube")){
            return s;
        }
       
    }
      return "no";  

  }
  void testfindURL(){
      String x="https://www.whitehouse.gov";
      System.out.println(findURL("x"));
    }
}
