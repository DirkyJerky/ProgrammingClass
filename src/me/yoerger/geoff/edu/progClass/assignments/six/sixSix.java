package me.yoerger.geoff.edu.progClass.assignments.six;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod6.BigIdea;

/**
 * Project Proposal for Module 6
 * @see BigIdea
 *
 */
public class sixSix implements Analysis{

	public static void main(String[] args) {
		BigIdea idea = new BigIdea(6, "Check to see if a class exists" );
		idea.setNewDesc("This will poll the specified versions JDK docs webpage, "
			+ "analyze it, and see if a certain class name exists, "
			+ "if it does return its URL");
		idea.print();
	}

	@Override
	public void printQuestions(Printer printer) {
		System.out.println("This is a Project proposal, no questions needed.");
		
	}

}
