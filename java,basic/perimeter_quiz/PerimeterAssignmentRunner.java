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
    public int getNumPoints (Shape s) {
        //me
        int count1=0;
        for(Point p:s.getPoints())
        {
            count1+=1;
        
        
    }
    return count1;
}
    public double getAverageLength(Shape s) {
        //me
        double AvgLength= getPerimeter(s)/getNumPoints(s);
        return AvgLength;
    }

    public double getLargestSide(Shape s) {
        // me
        double Glength=0;
        Point prevPt=s.getLastPoint();
        for(Point currPt:s.getPoints()){
        Glength=prevPt.distance(currPt);
        break;
        }
        for (Point currPt : s.getPoints()) {
        double L = prevPt.distance(currPt);
        if(L>Glength){
            Glength=L;
        }
        prevPt = currPt;
        }
        return Glength;
    }
        public double getLargestX(Shape s) {
    double bigX=0;
    
    for(Point p:s.getPoints()){
      bigX=p.getX();
      break;
    }
    for(Point p:s.getPoints()){
        if(p.getX()>bigX){
        bigX=p.getX();
        }
    }
    return bigX;
  }
   
    public void testPerimeter() {
        //me
        
        FileResource f=new FileResource(); 
        Shape s=new Shape(f);
        System.out.println("no. of points="+ getNumPoints(s));
        System.out.println("Average length="+ getAverageLength(s));
        System.out.println("Largest x-coordinate="+ getLargestX(s));
        System.out.println("Largest side="+ getLargestSide(s));
        System.out.println("Perimeter="+ getPerimeter(s));
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
