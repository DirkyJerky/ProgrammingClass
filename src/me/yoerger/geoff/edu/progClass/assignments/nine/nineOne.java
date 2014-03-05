package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;
import me.yoerger.geoff.edu.progClass.mod9.SafeCloser;

import com.google.common.base.Preconditions;

public class nineOne implements Analysis{
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		Scanner in = new Scanner(System.in);
		printer.print("Please select the picture with a 'green screen' background.");
//		Picture greenScreenedPic = new Picture(FileChooser.pickAFile());
		Picture greenScreenedPic = new Picture("P:\\Programming\\Workspace\\ProgrammingClass\\util\\Maze_Background.jpg");
		printer.print("Please select the picture that you want to be applied as a background to the other picture.");
//		Picture backgroundPic = new Picture(FileChooser.pickAFile());
		Picture backgroundPic = new Picture("P:\\Programming\\Workspace\\ProgrammingClass\\util\\BeauPicture.jpg");
		Preconditions.checkArgument(greenScreenedPic.getHeight() <= backgroundPic.getHeight(), "Background picture has to small height.");
		Preconditions.checkArgument(greenScreenedPic.getWidth() <= backgroundPic.getWidth(), "Background picture has to small width.");
		Picture combinedPicture = new Picture(backgroundPic.getWidth(), backgroundPic.getHeight());
		combinedPicture.setAllPixelsToAColor(Color.WHITE);
		printer.print("How much error do you think is in your picture? (integer, example is 10)");
		int ERROR_TRESH = in.nextInt();
		
		// Figure out the padding for the picture to be applied.
		int limitLeft = (int) trunc((backgroundPic.getWidth() - greenScreenedPic.getWidth())/2);
		int limitTop = (int) trunc((backgroundPic.getHeight() - greenScreenedPic.getHeight())/2);
		
		// TODO Refactor out
		// Find the main color of the green screen
		Map<Color, Integer> numColors = new HashMap<>();
		
		for(Pixel pixel : greenScreenedPic.getPixels()) {
			Color pixColor = pixel.getColor();
			if(!numColors.containsKey(pixColor)) {
				numColors.put(pixColor, 1);
			}
			int currNum = numColors.get(pixColor);
			numColors.remove(pixColor);
			numColors.put(pixColor, currNum + 1);
		}
		
		int highest = 0;
		Color highestColor = Color.WHITE; // The color of our green screen
		for(Color highestLocalColor : numColors.keySet()) {
			int numOfColors = numColors.get(highestLocalColor);
			if(numOfColors > highest) {
				highest = numOfColors;
				highestColor = highestLocalColor;
			}
		}
		System.out.printf("Using color as chroma key (R,G,B): %1$s,%2$s,%3$s", highestColor.getRed(), highestColor.getGreen(), highestColor.getBlue());
		
		
		// Make the magic
		for(Pixel combinedPixel : combinedPicture.getPixels()) {
			int x = combinedPixel.getX();
			int y = combinedPixel.getY();
			try {
				Pixel appliedPixel = greenScreenedPic.getPixel(x - limitLeft, y - limitTop);
				if(appliedPixel.colorDistance(highestColor) < ERROR_TRESH) {
					throw new ArrayIndexOutOfBoundsException("Catch me!");
				} else {
					combinedPixel.setColor(appliedPixel.getColor());
				}
			} catch (ArrayIndexOutOfBoundsException arioobe) {
				Color backgroundColor = backgroundPic.getPixel(x, y).getColor();
				combinedPixel.setColor(backgroundColor);
			}
			
//			if(x < limitLeft || x > limitRight || y > limitBottom || y < limitTop) {
//				combinedPixel.setColor(backgroundPic.getPixel(x, y).getColor());
//			} else {
//				if (greenScreenedPic.getPixel(x - limitLeft, y - limitTop).getColor().equals(highestColor)){
//					combinedPixel.setColor(backgroundPic.getPixel(x, y).getColor());
//					i++;
//				} else {
//					combinedPixel.setColor(greenScreenedPic.getPixel(x - limitLeft, y - limitTop).getColor());
//					System.out.println(x + ", " + y);
//				}
//			}
		}
		
		SafeCloser.safelyClose(in);
		combinedPicture.show(); // Show the magic
	}
	
	public static double trunc(double d) {
	    BigDecimal bd = new BigDecimal(d);
	    bd = bd.setScale(0, BigDecimal.ROUND_DOWN);
	    return bd.doubleValue();
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("How did you delete the background from your original image?");
		printer.printAnswer("I used premade pictures, but they are made using industry algortihms that are much better and more efficient at removing backgrounds.");
		
		printer.print("In general, how could you add a second image (e.g., another dolphin or an alien creature) to the new background?");
		printer.printAnswer("Have the program run the image overlapping algorthim multiple times.");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to use exceptions to an advantage");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to remove the stragling pixels around the non-green screen ones?");
		
		printer.print("Describe the main point of this assignment. (Required)");
		printer.printAnswer("Make a chroma key algoritm.");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Green screens are used in nearly all movies now");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned that theres something in the Picture class thats disrupting the pixels a little, I need to figure that out");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Figuring out when to use the colors from each picture.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Refactor out the methods as I write it, and see what difference it makes.");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("By having it remove all the stragling white pixels... somehow.");
		
		
		
	}
}
