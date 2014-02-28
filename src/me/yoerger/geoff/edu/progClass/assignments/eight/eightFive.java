package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.util.Scanner;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;
import me.yoerger.geoff.edu.progClass.mod8.Grayscale;

public class eightFive implements Analysis{

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

	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printTab("Apply color scales to a grayscale picture.");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printTab("This could be used in art programs to colorize a previously grayscale picture, like an older one.");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printTab("I learned how to test to see if a string that represents a certain file has a certain extension");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printTab("Making the Grayscale class, I had to do a lot of repetitiveness and iteration.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printTab("Have the program detect if the selected picture is already grayscaled or not.");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printTab("Have it apply alpha values too.");
		
		printer.print("How could you apply a meaningful color palette to a weather satellite image showing temperatures or pressures?");
		printer.printTab("By using this!");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printTab("How do determine if a file selecter was closed or not.");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printTab("Is there a way to have the GPU do this task?");
		
	}

	
	

}
