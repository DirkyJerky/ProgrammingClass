package assignments.six;

import mod6.AdultContactInfo;
import mod6.ContactInfo;

public class sixTwo {

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

}
