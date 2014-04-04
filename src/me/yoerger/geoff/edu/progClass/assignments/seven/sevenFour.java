package me.yoerger.geoff.edu.progClass.assignments.seven;

import java.util.Stack;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import me.yoerger.geoff.edu.progClass.mod7.TurtleGraph;

/**
 * Assignment 7.4
 * Make a turtle graph showing results of a survey on what Operating System people prefer
 * @see TurtleGraph
 */
public class sevenFour implements Analysis{
	public static void main(String[] args) {
		World world = new World();
		Turtle turtle = new Turtle(10, 10, world);
		TurtleGraph graph = new TurtleGraph(turtle);
		Stack<Integer> data = new Stack<>();
		data.push(2);
		data.push(5);
		data.push(2);
		data.push(1);
		graph.setXcoord(200);
		graph.setYcoord(500);
		graph.draw(data, 500, 50);
		turtle.hide();
		System.out.println("People who prefer: Mac \t Windows \t Linux \t Other");
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the main point of this assignment. (Required)");
		printer.printAnswer("Draw a bar graph modeling some data.");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Using graphs are a way to model something that is easy to interpret and easy to see.");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to use java.util.Stack");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Making the turtle line up just right");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Make the data labels be printed on the graph, not the console.");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("By taking in data the user enters and using that.");
		
		printer.print("In general terms, how could you write a program to display this information as a pie chart?");
		printer.printAnswer("Draw a circle instead of a rectange, and find the percent value of the data instead of numbers");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to use stacks");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("Whats the benefits of using constricted Collections like Stacks??");
		
	} 

}
