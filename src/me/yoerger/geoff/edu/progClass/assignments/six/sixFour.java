package me.yoerger.geoff.edu.progClass.assignments.six;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;

/**
 * Assignment 6.4
 * Make a generatable scam letter
 */
public class sixFour implements Analysis{

	public static void main(String[] args) {
		HashMap<String, String> s = new HashMap<>(); // My motive is to put all constants in an easy to change array.
        ArrayList<String> map = new ArrayList<>();
        DateFormat dfYMD = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dfMD = new SimpleDateFormat("MM/dd");
        Date date = new Date();
		s.put("FI", "Bank Bank Inc.");
		s.put("RnameFirst", "Bobby");
		s.put("RnameLast", "Grail");
		s.put("Sname", "Banker Banks");
		s.put("$", "453.13");
		s.put("site", "http://bankbank.scam/");
        map.add(s.get("FI")); // Who ever did it as strings called "line1", I hate you
        map.add("To: " + s.get("RnameFirst") + " " + s.get("RnameLast"));
        map.add("From: " + s.get("Sname"));
        map.add("Date: " + dfYMD.format(date));
        map.add("\n");
        map.add("\tDear Mr/Mrs " + s.get("RnameLast") + ",");
        map.add("On " + dfMD.format(date) + " we noticed a suspicious withdrawal of $" + s.get("$") + " \nfrom your checking account.");
        map.add("If this information is not correct, someone \nunknown to you may have access to your account!");
        map.add("For your safety, please visit " + s.get("site") + " to \nverify your personal information.");
        map.add(s.get("RnameFirst") + ", once you have done this, our fraud \ndepartment will work to resolve this discrepancy."); 
        map.add("\n");
        map.add("Thank you,");  
		map.add("\t" + s.get("Sname"));
		
		for(String string : map) {
			System.out.println(string); // Much better, old way gave me a migrane
		}
		
	}

	public void printQuestions(Printer p) {
		p.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		p.printAnswer("Make a spam letter");
		
		p.print("Discuss how this assignment relates to a real-life situation. (Required)");
		p.printAnswer("Corrupt Companies do things like this all the time to trick people into stupid things.");
		
		p.print("Reflect on your growth as a programmer. (Required)");
		p.printAnswer("I learned that making one string per line and individually printing each on is Stupid");
		
		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printAnswer("Copy pasting all the individual lines that were terribly made into a map");
		
		p.print("Describe at least one thing that will be done differently in the future.");
		p.printAnswer("Hopefully whoever made the boilerplate will do it better next time...");
		
		p.print("Suggest how this assignment could be extended.");
		p.printAnswer("By asking the user for the scam infomation first, then printing it based on that.");
		
		p.print("What is a legitimate use for a program that uses a generic \"shell\" to customize large numbers of letters or documents");
		p.printAnswer("Mass-production instead of having to type every single letter.");
		
		p.print("What question(s) of your own did you answer while writing this program?");
		p.printAnswer("None");
		
		p.print("What unanswered question(s) do you have after writing this program?");
		p.printAnswer("How much better is it to use maps to store strings instead of institating every line on its own.");
		
	}

}
