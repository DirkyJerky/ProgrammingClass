package me.yoerger.geoff.edu.progClass.assignments.nine;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.mod6.BigIdea;

public class nineSix implements Analysis {

	public static void main(String[] args) {
		BigIdea idea = new BigIdea(9, "IDK yet");
		idea.setNewDesc("I need to redo this project");
		idea.print();
	}
	
	
	
	
	@Override
	public void printQuestions(Printer printer) {
		printer.print("This is a Big Idea, no questions needed.");

	}


}
