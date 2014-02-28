package assignments.eight;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import assignments.Analysis;
import assignments.Printer;
import bookClasses.FileChooser;
import bookClasses.Picture;
import bookClasses.Pixel;

public class eightThree implements Analysis{
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Please select a folder with your pictures");
		System.out.println("Your pictures will be stiched together from left to right \n in alphabetical order.");
		File file = new File(FileChooser.pickADirectory());
		if(file.listFiles() == null) {
			System.out.println("Please restart, but pick something this time.");
			System.exit(-1);
		}
		
		List<Picture> pictures = new ArrayList<>();
		List<File> childrenFiles = Arrays.asList(file.listFiles());
		
		List<String> childrenPaths = new ArrayList<>();
		
		for (File f : childrenFiles) {
			childrenPaths.add(f.getPath());
		}
		
		Collections.sort(childrenPaths);
		for (String s : childrenPaths) {
			if(s.toLowerCase().endsWith(".jpg") || s.toLowerCase().endsWith(".jpeg")) {
				pictures.add(new Picture(s));
			}
		}
		int maxHeight = 0;
		int Width = 0;
		for(Picture pic : pictures) {
			if (pic.getHeight() > maxHeight) {
				maxHeight = pic.getHeight();
			}
			Width += pic.getWidth();
		}
		
		Picture panorama = new Picture(Width, maxHeight);
		panorama.setAllPixelsToAColor(Color.WHITE);
		int xLoc = 0;
		for(Picture pic : pictures) {
			for(Pixel picPix : pic.getPixels()) {
				panorama.setBasicPixel(xLoc + picPix.getX(), picPix.getY(), picPix.getColor().getRGB());
			}
			xLoc += pic.getWidth();
		}
		panorama.show();
		Thread.sleep(10000);
		System.exit(0);
		
	}

	@Override
	public void printQuestions(Printer printer) {
		
	}
}
