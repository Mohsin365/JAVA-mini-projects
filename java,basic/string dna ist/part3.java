
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
public class part3 {
    boolean twoOccurrences(String stringA,String stringB){
        int istOccur=stringB.indexOf(stringA);
        int secOccur = stringB.indexOf(stringA,istOccur+stringA.length());
        if(secOccur!=-1){
            return true;
        }
        return false;
    }
    
    void testtwoOcurrences(){
        String ist ="mohsin";
        String sec ="mohsinakbarmohsinthoker";
        boolean check=twoOccurrences(ist,sec);
        System.out.println("is"+check);
        
    }
    String lastPart(String stringA,String stringB){
       int istOccur=stringB.indexOf(stringA);
       String part = stringB.substring(istOccur+(stringA.length()));
       if(istOccur==-1){
           return stringB;
        }
        return part;
    }
    void testlastPart(){
        String a="banana";
        String b="xy";
        System.out.println(lastPart(b,a));
    }

}
