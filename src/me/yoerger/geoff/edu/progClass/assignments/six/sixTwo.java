package me.yoerger.geoff.edu.progClass.assignments.six;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod6.AdultContactInfo;
import me.yoerger.geoff.edu.progClass.mod6.ContactInfo;

/**
 * Assignment 6.2
 * Print me and my parents contact information
 * @see ContactInfo, AdultContactInfo
 */
public class sixTwo implements Analysis {

	public static void main(String[] args) {
		// Me
		ContactInfo geoff = new ContactInfo("Geoff Yoerger", 6088826078L, 0);
		AdultContactInfo mom = new AdultContactInfo("Ann Larson", geoff.homePhone, 6084439950L, 0);
		AdultContactInfo dad = new AdultContactInfo("Quentin Yoerger", geoff.homePhone, 6084495261L, 0);
		// Dont know my parents work phone off the top of my head.
		geoff.print();
		mom.print();
		dad.print();
	}
	
	public void printQuestions(Printer p) {
		p.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment.");
		p.printAnswer("Make a simple contact information printer");
		p.print("Discuss how this assignment relates to a real-life situation.");
		p.printAnswer("If you need a contact placed anywhere, like on a letter.");
		p.print("Reflect on your growth as a programmer.");
		p.printAnswer("I learned how to make simple extensions to a type and how special primitives need suffixes, like long.");
		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printAnswer("Figuring out why it wasnt liking the phone number; It wasnt being treaded as a long.");
		p.print("Describe at least one thing that will be done differently in the future.");
		p.printAnswer("Split the phone number when its printed so you can distinguish the seperate parts");
		p.print("Suggest how this assignment could be extended.");
		p.printAnswer("Make a entire family contact page");
		p.print("What are your initial impressions of Java?");
		p.printAnswer("Flexable and very practical.");
		p.print("What question(s) of your own did you answer while writing this program?");
		p.printAnswer("How do you use longs in programs?");
		p.print("What unanswered question(s) do you have after writing this program?");
		p.printAnswer("How many premade types do the complier generate? (Like 10202003L is a long)");
		p.print("(Student) How do you use longs in programs?");
		p.printAnswer("Append an uppercase L to the number");
	}

}
