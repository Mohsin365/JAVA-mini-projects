import edu.duke.*;
import java.io.*;
public class Grayscale {	
	public ImageResource toGray(ImageResource inImage) {
		ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
		for(Pixel p:outImage.pixels()) {
			Pixel inP=inImage.getPixel(p.getX(), p.getY());
			int average=(inP.getRed()+inP.getGreen()+inP.getBlue())/3;
			p.setRed(average);
			p.setGreen(average);
			p.setBlue(average);
		}
		return outImage;
	}
	public void grayScale() {
		DirectoryResource dr= new DirectoryResource();
		for(File f: dr.selectedFiles()) {
			ImageResource image=new ImageResource(f);
			ImageResource grayImage=toGray(image);
			String name=image.getFileName();
			String newname="gray-"+name;
			grayImage.setFileName(newname);
			grayImage.save();
			image.draw();
			grayImage.draw();
		}
	}
	public static  void main(String[] args) {
		Grayscale gs=new Grayscale();
		gs.grayScale();
	}
}
