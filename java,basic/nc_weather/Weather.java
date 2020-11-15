import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Weather {
	public CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord largestSo=null;
		double currTemp=0;
		double coldestTemp=0;
		for(CSVRecord rec:parser) {
			if(largestSo==null) {
				largestSo=rec;
			}
			else {
				currTemp=Double.parseDouble(rec.get("TemperatureF"));
				coldestTemp=Double.parseDouble(largestSo.get("TemperatureF"));
			}
			if(currTemp<coldestTemp&&currTemp!=-9999) {
				largestSo=rec;
			}
		}
		return largestSo;
	}
	public void testcoldestHourInFile() {
		FileResource fr=new FileResource();
		CSVParser parser=fr.getCSVParser();
		CSVRecord coldest =coldestHourInFile(parser);
		System.out.println("coldest temperature is "+Double.parseDouble(coldest.get("TemperatureF")));
	}
	public String FileWithColdestTemp() {
		DirectoryResource dr=new DirectoryResource();
		double coldestSo=9999;
		File coldestFile=null;
		for(File f:dr.selectedFiles()) {
			FileResource fr=new FileResource(f);
			CSVParser parser=fr.getCSVParser();
			double coldestInFile=Double.parseDouble(coldestHourInFile(parser).get("TemperatureF"));
			if(coldestInFile<coldestSo) {
				coldestFile=f;
			}
		}
		return coldestFile.getName();
	}
	
	public void testFileWithColdestTemp() {
		System.out.println("file/day with coldest temperature is "+FileWithColdestTemp());
		FileResource fr=new FileResource(FileWithColdestTemp());
		CSVRecord rec=coldestHourInFile(fr.getCSVParser());
		System.out.println("all temperatures om the coldest day were: ");
		System.out.println("coldest temperature on that was "+rec.get("TemperatureF"));
		for(CSVRecord temps:fr.getCSVParser()) {
			System.out.println("time: "+temps.get("TimeEST")+" date: "+temps.get("DateUTC")+" temperature: "+temps.get("TemperatureF"));
		}
		

	}
	public static void main(String[] args) {
		Weather w=new Weather();
		//w.testcoldestHourInFile();
		w.testFileWithColdestTemp();
	}
}
