package me.yoerger.geoff.edu.progClass.assignments.six;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;

/**
 * Assignment 6.1
 * Give a pointer to the assignment
 */
public class sixOne implements Analysis {

	public static void main(String[] args) {
		System.out.println("https://docs.google.com/document/d/1kW6ewwnhUBPJTZ48t_bMLf16Lx8-j8f3V50SXibzEE8/edit?usp=sharing");
	}
	
	public void printQuestions(Printer p) {
		p.print("Why do you think there is such public misperception about computer science?");
		p.printAnswer("Because its so foreign and its growth is like none other.");
		
		p.print("At this point in the course, what is your personal definition of computer science?");
		p.printAnswer("Teaching computers to do what they were built to do.");
		
		p.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment.");
		p.printAnswer("To demonstrate how to preform tasks.");
		
		p.print("Discuss how this assignment relates to a real-life situation.");
		p.printAnswer("This assignment literally does model a real life situation.");
		
		p.print("Reflect on your ability to think algorithmically.");
		p.printAnswer("Ive been with computers for a while now, I think I can do it quite well.");
	}

}
