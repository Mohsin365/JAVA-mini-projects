
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
import edu.duke.*;

public class part1 {
    
    public int findStopCodon(String dna,int startCindex,String stopCodon){
        int stopCindex=dna.indexOf(stopCodon,startCindex+3);
        while(stopCindex!=-1){
        if((stopCindex-startCindex)%3==0){
            return stopCindex;
        }
        else{
            stopCindex=dna.indexOf(stopCodon,stopCindex+1);
        }
      }
        return -1;
    }
    public String findGene(String dna,int startCindex){
        
        if(startCindex==-1){
            return "";
        }
        
        int indexTAA=findStopCodon(dna,startCindex,"taa");
        int indexTAG=findStopCodon(dna,startCindex,"tag");
        int indexTGA=findStopCodon(dna,startCindex,"tga");
        // check
        int stopCindex=0;
        if(indexTAA==-1||(indexTGA!=-1&&(indexTGA<indexTAA))){
            stopCindex=indexTGA;
        }
        else{
            stopCindex=indexTAA;
        }
        if(stopCindex==-1||(indexTAG!=-1&&(indexTAG<stopCindex))){
            stopCindex=indexTAG;
        }
        if(stopCindex==-1){
            return "";
        }
        String gene=dna.substring(startCindex,stopCindex+3);
        return gene;
    }
        public void printAllGenes(){
        FileResource fr=new FileResource();
        String dna=fr.asString();
        int startCindex=dna.indexOf("atg");
        
        while(true){
            String currGene=findGene(dna,startCindex);
            if(currGene.isEmpty()){
                System.out.println("end of dna/no stop codon");
                break;
            }
            System.out.println("LENGTH OF DNA:"+dna.length()+"\n");
            System.out.println("\nGENE:"+currGene);
            System.out.println("LENGTH OF GENE:"+currGene.length());
            System.out.println("START INDEX OF GENE:"+dna.indexOf(currGene));
            
            //startCindex=dna.indexOf(currGene,startCindex)+currGene.length();
            startCindex=dna.indexOf("atg",startCindex+currGene.length());
        }
    }
    public StorageResource getAllGenes(String dna){
        StorageResource store=new StorageResource();
        int startCindex=dna.indexOf("atg");
        
        while(true){
            String currGene=findGene(dna,startCindex);
            if(currGene.isEmpty()){
                //System.out.println("end of dna/no stop codon");
                break;
            }
            
            store.add(currGene);
            startCindex=dna.indexOf("ATG",startCindex+currGene.length());
        }
        return store;
    }
    public int IndexOf(String dna){
        int index=dna.indexOf("atg");
        
        return index;
    }
    public void allGenes(){
         FileResource fr=new FileResource();
         String dna=(fr.asString()).toLowerCase();
         System.out.println("index starting of gene:"+IndexOf(dna));
         StorageResource sr=getAllGenes(dna);
         for(String genes:sr.data()){
             
             System.out.println("gene:");
             System.out.println(genes +"\n \n \n \n ");
             
            }
         
    }

}
