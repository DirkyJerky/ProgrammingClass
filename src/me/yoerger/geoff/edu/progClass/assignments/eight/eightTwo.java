package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.util.HashMap;
import java.util.Map;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.mod8.Effects;

public class eightTwo implements Analysis{

	public static void main(String[] args) {
//		System.out.println("Close window to go onto the next picture");
		System.out.println("Please select your picture"); 
//		System.out.println("P:\\Programming\\Externals\\Refs\\Effects.jpg"); //Meee
		String picLocation = FileChooser.pickAFile();
		
        Picture picture = new Picture(picLocation); 
        Effects effects = new Effects(picture);
        
		Map<String, String> effectStrings = new HashMap<>();
		
		effectStrings.put("Regular","0, 0, 0");
		effectStrings.put("Sunset","0, -75, -75");
		effectStrings.put("Inverted","inv");
		effectStrings.put("Moonlight", "-125, -125, 0");
		
		for(String effectName : effectStrings.keySet()) {
			System.out.println(effectName);
			effects.apply(effectStrings.get(effectName)).show();
		}
		
	}

	@Override
	public void printQuestions(Printer printer) {

		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printAnswer("Apply color effects to pictures");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("This could be used to help partially color blind people see color in pictures they wouldnt otherwise.");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to initialize and use a 'Factory', a class that you instantate and then with one method generates an object of value.");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Figuring out how to allow pictures to be inverted and changed at the same time.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Add a optional option to the Effect.apply to make it accept a boolean representing if it should be inverted");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("Make it support grayscaling");
		
		printer.print("What other special effect(s) might be possible?");
		printer.printAnswer("Dimming a picture, brightining one, etc.");
		
		printer.print("How could you combine two special effects?");
		printer.printAnswer("Take the applied picture, make another Effects factory from it, and apply some more.");
				
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to make a static factory.");
				
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("Is using string parameters like in Effects.apply() a good idea?");
	}

}
