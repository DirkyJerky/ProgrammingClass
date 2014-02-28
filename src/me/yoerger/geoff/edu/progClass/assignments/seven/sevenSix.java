package me.yoerger.geoff.edu.progClass.assignments.seven;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod6.BigIdea;

public class sevenSix implements Analysis{

	public static void main(String[] args) {
		BigIdea idea = new BigIdea(6, "Make a turtle dance floor");
		idea.setNewDesc("Make a grid of color changing turtles that turn "
				+ "random directions and make a pretty drawing");
		idea.print();

	}
	public void printQuestions(Printer printer) {
		System.out.println("This is a Project proposal, no questions needed.");
		
	}
}
