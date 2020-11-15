import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Babynames {
	public void totalBirths(FileResource fr) {
		int totalbirths=0;
		int totalnames=0;
		int countgirls=0;
		int countboys=0;
		int totalboys=0;
		int totalgirls=0;
		
		for(CSVRecord rec:fr.getCSVParser(false)) {
			int totalborn=Integer.parseInt(rec.get(2));
			totalbirths+=totalborn;
			totalnames+=1;
			System.out.println("name: "+rec.get(0)+"\t gender: "+rec.get(1)+"\tno. of births: "+rec.get(2));
			
			if(rec.get(1).equalsIgnoreCase("M")) {
				totalboys+=totalborn;
				countboys+=1;
			}
			else {
				totalgirls+=totalborn;
				countgirls+=1;
			}
			
			
		}
		System.out.println("\n TOTAL BIRTHS: "+totalbirths+"\t total names: "
				+totalnames+"\nTOTAL BOYS BORN: "+totalboys
					+"\t total boys names: "+countboys+"\nTOTAL GIRLS BORN: "
					+totalgirls+"\t total gils names: "+countgirls);
	}
	public void testtotalBirths() {
		FileResource fr=new FileResource();
		totalBirths(fr);
	}
	
	public int getRank(String name,int year,String gender) {
		String yearFile="D:\\MOHSIN\\duke\\coursera\\us_babynames\\us_babynames_test/yob"+year+"short.csv";
		FileResource fr=new FileResource(yearFile);
		int rank=0;
		int births=999999999;
		for(CSVRecord rec:fr.getCSVParser(false)) {
			
			if(rec.get(1).equalsIgnoreCase(gender)) {
				int newLbirths=Integer.parseInt(rec.get(2));
				if(newLbirths<births) {
					rank+=1;
					births=newLbirths;
				}
				if(rec.get(0).equalsIgnoreCase(name)) {
					return rank;
				}
			}
		}
		return -1;
	}
	
	public void testgetRank() {
		String name="Ava";
		int year= 2012;
		String gender="F";
		System.out.println("Rank of "+name+" in the year "+year+" is "+getRank(name,year,gender));
	}
	
	public String getName(int rank,int year,String gender) {
		String yearFile="D:\\MOHSIN\\duke\\coursera\\us_babynames\\us_babynames_test/yob"+year+"short.csv";
		FileResource fr=new FileResource(yearFile);
for(CSVRecord rec:fr.getCSVParser(false)) {
			
			String name=rec.get(0);
			int rankFound=getRank(name,year,gender);
			if(rankFound==rank) {
				return name;
			}
		}
	return "NO NAME";
	}
	public void testgetName() {
		int rank=3;
		int year= 2012;
		String gender="F";
		System.out.println("baby with rank "+rank+" and gender "+gender+" in the year "+year+" is "+getName(rank,year,gender));
	}
	public void whatIsNameInYearBirthsBased(String name,int year,int newYear,String gender) {
		
	}
	public void whatIsNameInYearRankBased(String name,int year,int newYear,String gender) {
		int rank=getRank(name,year,gender);
		String newName=getName(rank,newYear,gender);
		System.out.println(name+" born in "+year+" would be " +newName+" if born in "+newYear);
	}
	public void testwhatIsNameInYearRankBased() {
		String name="Isabella";
		int year= 2012;
		int newYear=2014;
		String gender="F";
		whatIsNameInYearRankBased(name,year,newYear,gender);
	}
	public int yearWithHighestRank(String name,String gender) {
		DirectoryResource dr=new DirectoryResource();
		int yearIs=0;
		int currRank=999999;
		for(File f: dr.selectedFiles()) {
			//FileResource fr=new FileResource(f);
			String yearFile=f.getName();
			int year=Integer.parseInt(yearFile.substring(3,7));
			int rank=getRank(name,year,gender);
			if(rank<currRank) {
				yearIs=year;
				currRank=rank;
			}
		}
		//if(currRank==-1) {
		//	return -1;
		//}
		return yearIs;
	}
	public void testyearWithHighestRank() {
		String name="Ava";
		String gender="F";
		System.out.println("year of highest rank is "+yearWithHighestRank(name,gender));
	}
	public double getAverageRank(String name,String gender) {
		DirectoryResource dr=new DirectoryResource();
		int count=0;
		int sum=0;
		for(File f: dr.selectedFiles()) {
			String yearFile=f.getName();
			//int index=yearFile.indexOf("yob");
			//int year=Integer.parseInt(yearFile.substring(index+3,index+7);
			int year=Integer.parseInt(yearFile.substring(3,7));
			int rank=getRank(name,year,gender);
			if(rank!=-1) {
				sum +=rank;
			}
			count+=1;
		}
		return sum/(double)count;
	}
	public void testgetAverageRank() {
		String name="Isabella";
		String gender="F";
		System.out.println("average rank is "+getAverageRank(name,gender));
	}
	public int getTotalBirthsRankedHigher(String name,int year,String gender) {
		String yearFile="D:\\MOHSIN\\duke\\coursera\\us_babynames\\us_babynames_test/yob"+year+"short.csv";
		FileResource fr=new FileResource(yearFile);
		int rank=getRank(name,year,gender);
		int sum=0;
		int births=999999999;
		for(CSVRecord rec:fr.getCSVParser(false)) {
			String nameIs=rec.get(0);
			if(rec.get(1).equalsIgnoreCase(gender)) {
				int rankIs=getRank(nameIs,year,gender);
				if(rankIs<rank) {
					sum+=Integer.parseInt(rec.get(2));
				}
				
			}
		}
		return sum;
	}
	public void testgetTotalBirthsRankedHigher() {
		String name="Isabella";
		String gender="F";
		int year=2014;
		System.out.println("total births in "+year+ " ranked higher than "
		+name+" ,gender "+gender+" is "+getTotalBirthsRankedHigher(name,year,gender));
	}
	public static void main(String[] args) {
		Babynames bn=new Babynames();
		//bn.testtotalBirths(fr);
		//bn.testgetRank();
		//bn.testgetName();
		//bn.testwhatIsNameInYearRankBased();
		//bn.testyearWithHighestRank();
		//bn.testgetAverageRank();
		bn.testgetTotalBirthsRankedHigher();
	}	
}