package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.io.IOException;
import java.util.Scanner;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.mod8.PictureEncoder;
import me.yoerger.geoff.edu.progClass.bookClasses.ImageFormatException;

/**
 * Assignment 8.4
 *
 */
public class eightFour implements Analysis {

	/**
	 * @param args
	 * @throws ImageFormatException if no file is selected or the file is not an image
	 * @throws IOException If bad stuff happens when writing to file
	 */
	public static void main(String[] args) throws ImageFormatException, IOException {
		System.out.println("Please select a picture.");
		String pictureLoc = FileChooser.pickAFile();
		System.out.println("Do you want to Encode or Decode this image?");
		Scanner in = new Scanner(System.in);
		String input;
		outer: while (true) {
			input = in.nextLine().trim().toLowerCase();
			if (input.matches("(d.*|e.*)")) {
				break outer;
			} else {
				System.out.println("Wrong input, please try again.");
			}
		}

		PictureEncoder pe = new PictureEncoder(pictureLoc);
		// PictureEncoder pe = new
		// PictureEncoder("P:\\Programming\\Workspace\\ProgrammingClass\\Refs\\Flowers.jpeg");
		// // Me
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
	}

	/*
	 * @see me.yoerger.geoff.edu.progClass.assignments.Analysis#printQuestions(me.yoerger.geoff.edu.progClass.assignments.Printer)
	 */
	@Override
	public void printQuestions(final Printer printer) {
		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printAnswer("Encode a secret message into an image");

		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Cryptography is a huge part in modern society, this shows just one method");

		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to easily get the code points of characters");

		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Figureing out the the JPEG format auto-smoothes the images _._; I converted it to PNG and it worked perfectly");

		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Encode it with indiviual bits, not the bytes");

		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("Find out a way to encode images without it ruining  a section of the image.");

		printer.print("Why isn't the secret message actually visible in the image?");
		printer.printAnswer("Each image is one part of a pixel, pixels are only one color.");

		printer.print("How could you hide a solid white rectangle within an image?");
		printer.printAnswer("You can \"Hide\" one.... but you can loop over some pixels");

		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to create a static runtime of a file.");

		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to make it work all the time");

	}
}
