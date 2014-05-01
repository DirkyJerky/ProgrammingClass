package me.yoerger.geoff.edu.progClass.assignments.ten;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod6.BigIdea;

/**
 * Project Proposal for Module 6
 *
 */
public class tenSix implements Analysis {

	public static void main(String[] args) {
		BigIdea moduleTen = new BigIdea(10, "Create a JUnit testing suite");
		moduleTen.setNewDesc("Create a runnable class that runs the JUnit runner on all of \n"
				+ "my non-assignment classes");
	}
	
	@Override
	public void printQuestions(Printer printer) {
		printer.print("This is a Big Idea, no questions needed.");

	}
}
