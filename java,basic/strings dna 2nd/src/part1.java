/**
* Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import static java.lang.System.out;;
public class part1 {
    
    public int findStopCodon(String dna,int startCindex,String stopCodon){
        int stopCindex=dna.indexOf(stopCodon,startCindex+3);
        while(stopCindex!=-1){
        	int diff=stopCindex-startCindex;
        if(diff%3==0){
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
        return dna.substring(startCindex,stopCindex+3);
    }
    
    public int calculateCount(String dna,String x) {
    	int index=dna.indexOf(x);
    	int count=0;
    	while(index!=-1) {
    		count+=1;
    		index=dna.indexOf(x,index+1);
    		if(index==-1) {
        		break;
        	}
    	}
    	return count;
    }
     
    public void cgRatio() {
    	String dna="atgacttga";
    	
    	int countC=calculateCount(dna,"c");
    	int countG=calculateCount(dna,"g");
    	//int sumcg=countC+countG;
    	double ratio=(countC+countG)/(double)dna.length();
    	out.println(ratio);
    	//return (double)((count+countG)/dna.length());
    	
    }
    public int printAllGenes(){
        FileResource fr=new FileResource();
        String dna=fr.asString();
        String dnaLower=dna.toLowerCase();
        int startCindex=dna.indexOf("atg");
        int countGenes=0;
        System.out.println("\nLENGTH OF DNA:"+dna.length());
        while(true){
            String currGene=findGene(dnaLower,startCindex);
            if(currGene.isEmpty()){
                System.out.println("end of dna");
                break;
            }
            countGenes+=1;
            System.out.println("\nGENE"+countGenes+": "+currGene);
            System.out.println("\nLENGTH OF GENE:"+currGene.length());
            System.out.println("START CODON INDEX OF GENE:"+startCindex);
            System.out.println("STOP CODON INDEX OF GENE:"+(startCindex+currGene.length()-3));
            
           
           
           // startCindex=dna.indexOf(currGene,startCindex)+currGene.length();
           startCindex=dna.indexOf("atg",startCindex+currGene.length());
        }
        return countGenes;
    }
    public void testprintAllGenes() {
    	
    	 System.out.println(printAllGenes());
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
           // startCindex=dna.indexOf("atg",startCindex)+currGene.length(); or
            startCindex=dna.indexOf("atg",startCindex+currGene.length());        }
        return store;
    }
    public int IndexOf(String dna){
        int index=dna.indexOf("atg");
        
        return index;
    }
    public void allGenes(){
         FileResource fr=new FileResource();
         String dna=fr.asString();
         String dnaLower=dna.toLowerCase();
         
         StorageResource sr=getAllGenes(dnaLower);
         for(String gene:sr.data()){
             
             System.out.println("gene:");
             System.out.println(gene);
             System.out.println("LENGTH OF GENE:"+gene.length() +"\n");


            }
        
         
         
    }
    public static void main(String[] args) {
		part1 p1=new part1();
		p1.testprintAllGenes();
		//p1.cgRatio();
		//p1.allGenes();
	}
}

