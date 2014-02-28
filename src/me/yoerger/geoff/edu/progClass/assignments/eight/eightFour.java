package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.util.Scanner;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.mod8.PictureEncoder;

public class eightFour implements Analysis{

	public static void main(String[] args) {
		System.out.println("Please select a picture.");
		String pictureLoc = FileChooser.pickAFile();
		if (pictureLoc == null || !pictureLoc.matches(".*\\.jpe?g")) 	System.exit(1); 
		System.out.println("Do you want to Encode or Decode this image?");
		Scanner in = new Scanner(System.in);
		String input;
		outer:
		while(true) {
			input = in.nextLine().trim().toLowerCase();
			if (input.matches("(d.*|e.*)")) {
				break outer;
			} else {
				System.out.println("Wrong input, please try again.");
			}
		}
		
		PictureEncoder pe = new PictureEncoder(pictureLoc);
//		PictureEncoder pe = new PictureEncoder("P:\\Programming\\Workspace\\ProgrammingClass\\Refs\\Flowers.jpeg"); // Me
		if (input.matches("e.*")) {
			System.out.println("What message do you want encoded?");
			String message = in.next().trim();
			pe.encode(message);
			System.out.println("You encoded '" + pe.decode() + "'."); 
		} else {
			System.out.println("The message is:");
			System.out.println();
			System.out.println(pe.decode());
		}
		in.close();
		System.exit(0);
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printAnswer("Encode a secret message into an image");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Cryptography is a huge part in modern society, this shows just one method");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to easily get the code points of characters");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Figuring out why in one runtime it is able to decode it perfectly but in another it doesnt..."
				+ "I still need to fix this, if you see this, tell Geoff (me) please. TODO: try on a unix enviroment.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Encode it with indiviual bits, not the bytes");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("Find out a way to encode images without it ruining  a section of the image.");
		
		printer.print("Why isn’t the secret message actually visible in the image?");
		printer.printAnswer("Each image is one part of a pixel, pixels are only one color.");
		
		printer.print("How could you hide a solid white rectangle within an image?");
		printer.printAnswer("You can \"Hide\" one.... but you can loop over some pixels");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to create a static runtime of a file.");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to make it work all the time");
		
		
	}
}
