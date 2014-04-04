package me.yoerger.geoff.edu.progClass.assignments.eight;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod6.BigIdea;

/**
 * Project Proposal for Module 8 unit project
 * @see BigIdea
 * @see eightProject
 *
 */
public class eightSix implements Analysis {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigIdea eight = new BigIdea(8, "Better fractal generation - EXT 8.1");
		eight.setNewDesc("Here I will extend the fractal generation in assignment 8.1 so that it can take a custom color, width, and angle of generation.");
		eight.print();

	}
	/* (non-Javadoc)
	 * @see me.yoerger.geoff.edu.progClass.assignments.Analysis#printQuestions(me.yoerger.geoff.edu.progClass.assignments.Printer)
	 */
	@Override
	public void printQuestions(Printer printer) {
		printer.print("This is a Big Idea, no questions needed.");

	}

}
