package assignments.eight;

import java.util.Scanner;

import mod8.Grayscale;
import bookClasses.FileChooser;
import bookClasses.Picture;
import bookClasses.Pixel;

public class eightFive {

	public static void main(String[] args) {
		System.out.println("Select your grayscale picture or hit cancel to select a picture to be grayscaled.");
		String picLoc = FileChooser.pickAFile();
		if(picLoc == null) {
			String noGrayPicLoc = FileChooser.pickAFile();
			if(noGrayPicLoc == null || !noGrayPicLoc.matches(".*\\.jpe?g")) System.exit(1);
			picLoc = Grayscale.grayscale(noGrayPicLoc);
		}
		if(!picLoc.matches(".*\\.jpe?g")) System.exit(1);
		
		Picture pic = new Picture(picLoc);
		
		Scanner in = new Scanner(System.in);
		System.out.println("How much red scale do you want applied? (0 or more)");
		double redScale = in.nextDouble();
		System.out.println("Blue?");
		double blueScale = in.nextDouble();
		System.out.println("Green?");
		double greenScale = in.nextDouble();
		in.close();
		for(Pixel pixel : pic.getPixels()) {
			pixel.setRed((int) (pixel.getRed() * redScale));
			pixel.setGreen((int) (pixel.getGreen() * greenScale));
			pixel.setBlue((int) (pixel.getBlue() * blueScale));
		}
		pic.show();
		
	}
	

}
