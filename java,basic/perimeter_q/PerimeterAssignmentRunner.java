import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        //me
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }
   
    public double getLargestPerimeterMultipleFiles() {
        //me
        double LargestPerimeter=0;
        double Perimeter=0;
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
              Shape s=new Shape(fr);
              LargestPerimeter=getPerimeter(s);
              break;
        }
        for (File f : dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
              Shape s=new Shape(fr);
              Perimeter=getPerimeter(s);
              if(Perimeter>LargestPerimeter){
                    LargestPerimeter=Perimeter;
                }
             
        }
        
        return  LargestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        //me
        double LargestPerimeter=0;
        double Perimeter=0;
        DirectoryResource dr = new DirectoryResource();
        File temp = null;    // repl
        
        for (File f : dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
              Shape s=new Shape(fr);
              Perimeter=getPerimeter(s);
              if(Perimeter>LargestPerimeter){
                  LargestPerimeter=Perimeter;
                   temp=f ;
                }
            }
        return temp.getName();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    public void testPerimeterMultipleFiles() {
        //me
        
        printFileNames();
        System.out.println("Largest Perimeter in Multiple Files="+ getLargestPerimeterMultipleFiles());
        System.out.println(" File with Largest Perimeter="+ getFileWithLargestPerimeter());
        
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeterMultipleFiles();
    }
}
