import java.util.*;
import edu.duke.*;
import java.io.*;
public class VigenereBreaker {
	
    public String sliceString(String message, int whichSlice, int totalSlices) {
    	StringBuilder sb=new StringBuilder();
    	for(int i=whichSlice;i<message.length();i+=totalSlices) {
    		sb=sb.append(message.charAt(i));	
    	}
    	return sb.toString();
    }
    //tester
    void testsliceString() {
    	System.out.println(sliceString("abcdefghijklm",4,5));
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for(int i=0;i<klength;i++) {
        	String slice=sliceString(encrypted,i,klength);
        	CaesarCracker cCrack=new CaesarCracker();
        	key[i]=cCrack.getKey(slice);	
        }
        return key;
    }
    //tester
    void testtryKeyLength() {
    	FileResource fr=new FileResource("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\VigenereTestData/athens_keyflute.txt");
    	String testString=fr.asString();
    	//flute {5,11,20,19,4}
    	int key[]=tryKeyLength(testString,5,'e');
    	for(int i=0;i<key.length;i++) {
    	System.out.println(key[i]);
    	}
    }
    
    public HashSet<String> readDictionary(FileResource fr){
    	HashSet<String> hset=new HashSet<String>();
    	for(String s:fr.lines()) {
    		hset.add(s.toLowerCase());
    	}
    	return hset;
    }
    void testreadDictionary() {
    	FileResource frD=new FileResource("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\VigenereProgram\\dictionaries/English");
    	HashSet<String> dictionaryHset=readDictionary(frD);
    	int i=0;
    	for(String s:dictionaryHset) {
    	//System.out.println(s);
    	i++;
    	}System.out.println(i);
    }
    public int countWords(String message,HashSet<String> hset) {
    	int count=0;
    	String[] messageArray=message.split("\\W+");
    	for(String word:messageArray) {
    		if(hset.contains(word)) {
    			count+=1;
    		}
    	}
    	return count;
    }
  public char mostCommonCharIn(HashSet<String> hset) {
	  CaesarCracker cCrack=new CaesarCracker();
	  StringBuilder sb=new StringBuilder();
	  String alpha="abcdefghijklmnopqrstuvwxyz";
	  for(String s:hset) {
		  sb=sb.append(s);
	  }
	  int maxCountIndex=cCrack.maxIndex(cCrack.countLetters(sb.toString()));
	  return alpha.charAt(maxCountIndex);
  }
  //tester
  void testmostCommonCharIn() {
  	FileResource frD=new FileResource("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\VigenereProgram\\dictionaries/English");

	  HashSet<String> hset=readDictionary(frD);
	  System.out.println(mostCommonCharIn(hset));
  }
  public String breakForLanguage(String encrypted,HashSet<String> hset) {
  	String realDecryption="";
  	int currNum=0;
  	int realNum=0;
  	for(int i=1;i<=100;i++) {
  		int[] keys=tryKeyLength(encrypted,i,mostCommonCharIn(hset));
  		VigenereCipher Vcipher=new VigenereCipher(keys);
  		String decrypted=Vcipher.decrypt(encrypted);
  		realNum=countWords(decrypted,hset);
  		if(realNum>currNum) {	
  			//didn't check if realNum=currNum
  			currNum=realNum;
  			realDecryption=decrypted;
  		}
  	}
  	return realDecryption;
  }
  public void breakForAllLanguages(String encrypted,HashMap<String,HashSet<String>> languages) {
	  String realDecryptedMessage="";
	  int currCount=0;
	  for(String key:languages.keySet()) {
		 String decryptedMessage= breakForLanguage(encrypted,languages.get(key));
		  int realCount=countWords(decryptedMessage,languages.get(key));
		  if(realCount>currCount) {
			  currCount=realCount;
			  realDecryptedMessage=decryptedMessage;
			  System.out.println("no. of real words in "+key+"iare : "+realCount);
		  }
	  }
	  System.out.println("DECRYPTED MESSAGE:\n"+realDecryptedMessage);
  }

    public void breakVigenere () {
    	FileResource frFile=new FileResource();
    	//FileResource frFile=new FileResource("D:\\MOHSIN\\cse\\duke workspace\\coursera\\arrays,lists,structured data\\VigenereTestData/athens_keyflute.txt");
    	String encrypted=frFile.asString();
    	HashMap<String,HashSet<String>> languages=new HashMap<String,HashSet<String>>();
    	DirectoryResource dr=new DirectoryResource();
    	for(File f:dr.selectedFiles()) {
        	FileResource frD=new FileResource(f);
        	languages.put(f.getName(),readDictionary(frD));
        	System.out.println(f.getName()+" read");
    	}
    	breakForAllLanguages(encrypted,languages);
    }
    public static void main(String[] args) {
    	VigenereBreaker Vbreaker=new VigenereBreaker();
    	//Vbreaker.testsliceString();
    	//Vbreaker.testtryKeyLength();
    	//Vbreaker.testreadDictionary();
    	//Vbreaker.testmostCommonCharIn();
    	Vbreaker.breakVigenere();
    	
    }
    
}
