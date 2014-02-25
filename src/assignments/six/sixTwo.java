package assignments.six;

import assignments.Analysis;
import assignments.Printer;
import mod6.AdultContactInfo;
import mod6.ContactInfo;

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
		p.print("Describe the main point of this assignment.");
		p.printTab("Make a simple contact information printer");
		p.print("Discuss how this assignment relates to a real-life situation.");
		p.printTab("If you need a contact placed anywhere, like on a letter.");
		p.print("Reflect on your growth as a programmer.");
		p.printTab("I learned how to make simple extensions to a type and how special primitives need suffixes, like long.");
		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printTab("Figuring out why it wasnt liking the phone number; It wasnt being treaded as a long.");
		p.print("Describe at least one thing that will be done differently in the future.");
		p.printTab("Split the phone number when its printed so you can distinguish the seperate parts");
		p.print("Suggest how this assignment could be extended.");
		p.printTab("Make a entire family contact page");
		p.print("What are your initial impressions of Java?");
		p.printTab("Flexable and very practical.");
		p.print("What question(s) of your own did you answer while writing this program?");
		p.printTab("How do you use longs in programs?");
		p.print("What unanswered question(s) do you have after writing this program?");
		p.printTab("How many premade types do the complier generate? (Like 10202003L is a long)");
		p.print("(Student) How do you use longs in programs?");
		p.printTab("Append an uppercase L to the number");
	}

}
