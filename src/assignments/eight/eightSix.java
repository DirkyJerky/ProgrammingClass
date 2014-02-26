package assignments.eight;

import mod6.BigIdea;
import assignments.Analysis;
import assignments.Printer;

public class eightSix implements Analysis {
	public static void main(String[] args) {
		BigIdea eight = new BigIdea(8, "Better fractal generation - EXT 8.1");
		eight.setNewDesc("Here I will extend the fractal generation in assignment 8.1 so that it can take a custom color, width, and angle of generation.");
		eight.print();

	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("This is a Big Idea, no questions needed.");

	}

}
