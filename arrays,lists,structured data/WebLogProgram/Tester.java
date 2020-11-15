
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import java.io.*;
public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    public void testIPsWithMostVisitsOnDay(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        String someday="Sep 30";
        System.out.println("\n IPs that most visited on "+someday+" are  ");
        for(String s: la.IPsWithMostVisitsOnDay(la.IPsForDays(),someday)){
        System.out.println(s);
        }
    }
    public void testIPsMostVisits(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        System.out.println("\n IPs that most visited(any day) :  ");
        for(String s: la.IPsMostVisits(la.countVisitsPerIP())){
        System.out.println(s);
        }
    }
    
    public void testIPsForDays(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        for(String dt: la.IPsForDays().keySet()){
        System.out.print("\n Date: "+dt+"\nIPs visited:  ");
         for(String IP: la.IPsForDays().get(dt)){
             System.out.print(IP+" | ");
         }
        }
    }
    
    public void testdayWithMostIPs(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        System.out.println("\n Day with most IPs: "+la.dayWithMostIPs(la.IPsForDays()));
    }
    
    void testuniqueIPVisitsOnDay(){
     File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        String strDt="Sep 30";
        System.out.println("\n IPs visited on "+strDt+" are:");
        ArrayList<String> alist=la.uniqueIPVisitsOnDay(strDt);
        for(String IP: alist){
            System.out.println(IP);
        }
        
    }
    
    public void testprintAllHigherThanNum(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        la.printAllHigherThanNum(200);
    }
    public void testcountVisitsPerIP(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");      
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        System.out.println(" \nIPs and their no.of visits: ");
            for(String key: la.countVisitsPerIP().keySet()){
                System.out.println("IP: "+key+"  Visits: " +la.countVisitsPerIP().get(key));
            }
        }
        
        
        
       public void testmostNumberVisitsByIP(){
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");       
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        System.out.println("\n most no. of visits by any IP: "+la.mostNumberVisitsByIP(la.countVisitsPerIP()));
        }
        
    public void testLogAnalyzer() {
        // complete method
        File f= new File("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\UniqueIPData/short-test_log");
        LogAnalyzer la=new LogAnalyzer();
        la.readFile(f.getName());
        la.printAll();
        
    }
}
