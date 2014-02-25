package assignments.eight;

import java.util.Scanner;

import mod8.PictureEncoder;
import bookClasses.FileChooser;

public class eightFour {

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
}
