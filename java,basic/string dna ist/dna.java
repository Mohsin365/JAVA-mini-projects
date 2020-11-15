import edu.duke.*;

public class dna {
	public String compare(String letter1) {
		int starti=0;
		FileResource fr=new FileResource();
		String dna2= fr.asString();
		while(starti!=-1) {
		
		String letter=dna2.substring(starti,starti+1);
		if(letter1.equals(letter)) {
			starti+=starti;
			return letter;
			
		}
		
			return "different";
		
		}
		return "END";
		
	}
	void testcompare() {
		int startindex=0;
		FileResource fr=new FileResource();
		String dna1=fr.asString();
		while(startindex!=-1) {
				String letter1=dna1.substring(startindex,startindex+1 );
				String letter2=compare(letter1);
				System.out.println(" "+letter1+" "+letter2);
			startindex+=startindex;
			}
		
	}
	public static void main(String[] args) {
		dna dnaObject=new dna();
		dnaObject.testcompare();
	}
}
