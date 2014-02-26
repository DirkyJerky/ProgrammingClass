package assignments.eight;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import mod8.Effects;
import assignments.Analysis;
import bookClasses.Picture;

public class eightTwo implements Analysis{

	public static void main(String[] args) {
//		System.out.println("Close window to go onto the next picture");
		Scanner in = new Scanner(System.in);
		System.out.println("Please insert the URI to your picture"); // TODO: Make relative to my picture
//		System.out.println("P:\\Programming\\Externals\\Refs\\Effects.jpg"); //Meee
		String picLocation = in.nextLine().trim();
		in.close();
		
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

}
