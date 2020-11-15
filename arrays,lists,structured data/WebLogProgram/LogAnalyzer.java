
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
       records= new ArrayList<LogEntry>();
     }
     
     public int countUniqueIPs(){
         ArrayList<String> list=new ArrayList<String>();
         for(LogEntry log:records){
             if(!list.contains(log.getIpAddress())){
                 list.add(log.getIpAddress());
                }
            }
            return list.size();
        }
     
        public void printAllHigherThanNum(int number){
            System.out.println("Log Entries with status code greater than "+number+" are: ");
            for(LogEntry log:records){
                if(log.getStatusCode()>number){
             System.out.println(log);
            }
          }
        }
        
        public ArrayList<String> uniqueIPVisitsOnDay(String someday){
            ArrayList<String> alist=new ArrayList<String>();
            for(LogEntry log:records){
                String str=log.getAccessTime().toString();               
                String strDay=str.substring(4,10);
                if(strDay.equals(someday)){
             alist.add(log.getIpAddress());
            }
        }
        return alist;
    }
    
    
     
   public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String,Integer> hmap=new HashMap<String,Integer>();
        for(LogEntry log:records){
            String s=log.getIpAddress();
            if(!hmap.containsKey(s)){
                hmap.put(s,1);
            }
            else{
                hmap.put(s,hmap.get(s)+1);
            }
        }
        return hmap;
        
    }
       public int mostNumberVisitsByIP(HashMap<String,Integer> hmap){
                int mostVisitsBy=0;
                
                for(String key: hmap.keySet()){
                    int currMost=hmap.get(key);
                    if(currMost>mostVisitsBy){
                        mostVisitsBy=currMost;
                    }
                }
           return mostVisitsBy;
        }
        
       public ArrayList<String> IPsMostVisits(HashMap<String,Integer> hmap){
            ArrayList<String> alist=new ArrayList<String>();
            int mostVisits=mostNumberVisitsByIP(hmap);
            for(String key:hmap.keySet()){
                int currVisits=hmap.get(key);
                    if(currVisits>=mostVisits){
                        alist.add(key);
                    }
            }
            return alist;
        }
        
        public HashMap<String,ArrayList<String>> IPsForDays(){
            HashMap<String,ArrayList<String>> dayIPs= new HashMap<String,ArrayList<String>>();
                ArrayList<String> alist=new ArrayList<String>();
            for(LogEntry log:records){
                String strDt=log.getAccessTime().toString();
                String dt=strDt.substring(4,10);
                ArrayList<String> list=uniqueIPVisitsOnDay(dt);
                dayIPs.put(dt,list);   
            }
            return dayIPs;
        }
        
        public String dayWithMostIPs(HashMap<String,ArrayList<String>> dayIPs){
            String TheDay="";
            for(String DateKey:dayIPs.keySet()){
                if(dayIPs.get(DateKey).size()>TheDay.length()){
                    TheDay=DateKey;
                }
            }
            return TheDay;
        }
        
        public ArrayList<String> IPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> dayIPs,String someday){
            ArrayList<String> uIPsDay=uniqueIPVisitsOnDay(someday);
            HashMap<String,Integer> hmap=new HashMap<String,Integer>();
               for(String s: dayIPs.get(someday)){ //gives arraylist and iterate over that
                   if(!hmap.containsKey(s)){
                       hmap.put(s,1);
                    }
                    else{
                        hmap.put(s,hmap.get(s)+1);
                    }
                } 
                ArrayList<String> alist=IPsMostVisits(hmap);
           return alist;
       }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr=new FileResource(filename);
         for(String row: fr.lines()){
            LogEntry currLog=new WebLogParser().parseEntry(row);
            records.add(currLog);
            }
     }
     
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
