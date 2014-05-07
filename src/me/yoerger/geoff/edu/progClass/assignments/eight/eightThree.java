package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;

/**
 * Assignment 8.3
 *
 */
public class eightThree implements Analysis{
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.println("Please select a folder with your tiled pictures");
		System.out.println("Your pictures will be stiched together from left to right \n in alphabetical order.");
		File file = new File(FileChooser.pickADirectory());
		if(file.listFiles() == null) {
			System.out.println("Please restart, but pick something this time.");
			throw new IllegalArgumentException("Please pick a file");
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
			System.out.println("Amending picture @ " + pic.getFileName());
			for(Pixel picPix : pic.getPixels()) {
				panorama.setBasicPixel(xLoc + picPix.getX(), picPix.getY(), picPix.getColor().getRGB());
			}
			xLoc += pic.getWidth();
		}
		System.out.printf("Showing the final stiched picture made from %d originals", pictures.size());
		panorama.show();
		
	}

	/* (non-Javadoc)
	 * @see me.yoerger.geoff.edu.progClass.assignments.Analysis#printQuestions(me.yoerger.geoff.edu.progClass.assignments.Printer)
	 */
	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the main point of this assignment. (Required)");
		printer.printAnswer("Stitch together a collection of images");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Panoramas are made by doing just this");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how make and order a set of objects based on one of its attributes");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Getting the pictures together in order; I was using a list "
				+ "that was ordered based on a random hash, which isnt really ordering at all");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Allow the user to order the pictures");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("Add a way to overlap images that have a common border");
		
		printer.print("How could you modify this program to produce a collage of separate images?");
		printer.printAnswer("Have an option to split the images?");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to order a java.util.List");
		
		printer.print("What unanswered question(s) do you have after writing this program?  ");
		printer.printAnswer("How to detect if an image overlaps? Whats the best algorithm?");
		
		
	}
}
