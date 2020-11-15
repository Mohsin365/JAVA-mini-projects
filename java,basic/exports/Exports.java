import org.apache.commons.csv.*;
import edu.duke.*;
public class Exports {
	public String countryInfo(CSVParser parser,String country) {
		
		for(CSVRecord rec: parser) {
			if(rec.get("Country").equals(country)) {
				//System.out.println(country+": "+rec.get("Exports")+" : "+rec.get("Value (dollars)"));
				return (rec.get("Country")+"  :  "+rec.get("Exports")+"  :  "+rec.get("Value (dollars)"));
			}			
		}
		return "no country in file";
	}
	public void testcountryInfo() {
		FileResource fr=new FileResource("D:\\MOHSIN\\duke\\coursera\\exports/exportsmall.csv");
		CSVParser parser=fr.getCSVParser();
		String country="Malawi";
		System.out.println(countryInfo(parser,country));
	}
	public void twoProductExportors(CSVParser parser,String expItem1,String expItem2) {
		for(CSVRecord rec: parser) {
			String export=rec.get("Exports");
			if(export.contains(expItem1)&&export.contains(expItem2)) {
				System.out.println(rec.get("Country"));		
				}			
		}
		System.out.println(" no country which exports both "+expItem1+" and "+expItem2);		

	}
	public void testtwoProductExportors() {
		FileResource fr=new FileResource("D:\\MOHSIN\\duke\\coursera\\exports/exportsmall.csv");
		CSVParser parser=fr.getCSVParser();
		String expItem1="cotton";
		String expItem2="textiles";
		twoProductExportors(parser,expItem1,expItem2);
	}
	public int numOfExportors(CSVParser parser,String expItem) {
		int count=0;
		for(CSVRecord rec: parser) {
			if(rec.get("Exports").contains(expItem)) {
				count+=1;
			}			
		}
		return count;
	}
	public void testnumOfExportors() {
		FileResource fr=new FileResource("D:\\MOHSIN\\duke\\coursera\\exports/exportsmall.csv");
		CSVParser parser=fr.getCSVParser();
		String expItem="coffee";
		System.out.println("number of countries exporting "+expItem+" is "+numOfExportors(parser,expItem));		
	}
	public void bigExportors(CSVParser parser,String amount) {
		for(CSVRecord rec: parser) {
			String value=rec.get("Value (dollars)");
			if(value.length()>amount.length()) {
				System.out.println(rec.get("Country"));		

			}			
		}
	}
	public void testbigExportors() {
		FileResource fr=new FileResource();
		CSVParser parser=fr.getCSVParser();
		String amount="$1,999,964,800,000";
		System.out.println("big exportors are:");		
		bigExportors(parser,amount);
	}
	public static void main(String[] args) {
		Exports exports =new Exports();
		//exports.testcountryInfo();
		//exports.testtwoProductExportors();
		//exports.testnumOfExportors();
		exports.testbigExportors();
	}
}