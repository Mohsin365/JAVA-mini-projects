
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;

public class part1 {
    String findSimpleGene(String dna){
        int startCodon=dna.indexOf("ATG");
        if(startCodon==-1){
            return "no start codon";
        }
        int stopCodon=dna.indexOf("TAA",startCodon+3);
        if(stopCodon==-1){
            return "no stop codon";
        }
        String result=dna.substring(startCodon,stopCodon+3);
        if(result.length()%3==0){
            return result;
        }
        return "not found";

    }
    
    void testfindSimpleGene(){
        String dna="BJDDLATGAAAXYZTAANDJDJE";
        System.out.println(findSimpleGene(dna));
    }

}


