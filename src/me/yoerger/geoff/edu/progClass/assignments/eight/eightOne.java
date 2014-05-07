package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import me.yoerger.geoff.edu.progClass.mod7.Range;

/**
 * Assignment 8.1
 *
 */
public class eightOne implements Analysis{

	/**
	 * The starting length of the fractal segments
	 */
	final static int LEN = 100;
	/**
	 * The amount of time to wait between animations
	 */
	final static int TIMEOUT = 1000;
	/**
	 * The amount to multipy the scale by each frame
	 */
	final static float SCALE = 0.75F;
	/**
	 * The color to make the fractal
	 */
	final static Color FRACTAL_COLOR = Color.red;
	/**
	 * The width of the fractal lines
	 */
	final static int FRACTAL_WIDTH = 2;
	
	/**
	 * @param args
	 * @throws InterruptedException if bad stuff happens in the thread
	 */
	@SuppressWarnings("unused") // For the console clearer below.
	public static void main(String[] args) throws InterruptedException {
		
//		System.out.println("The other threads dont like all these turtles"
//				+ " drawing over each other,\nJust ignore the oncomming spam");
		World world = new World();
		Turtle starter = new Turtle(300, 400, world);
		starter.setPenColor(FRACTAL_COLOR);
		starter.hide();
		starter.setPenWidth(FRACTAL_WIDTH);
		int phase = LEN;
		Set<Turtle> turtles = new HashSet<>();
		turtles.add(starter);
		
		while(world.isShowing() && phase >= 10) {
			turtles.addAll(world.getTurtleList());
			for(Turtle t : turtles) {
				t.forward(phase);
				normalize(t);
				Turtle copy = copy(t, world);
				normalize(copy);
				copy.turnLeft();
				t.turnRight();
				
			}
			phase *= SCALE;
			Thread.sleep(TIMEOUT);
		}
		
		for( int i : new Range(10).range()) {
			System.out.print("\n");
		}
		
		System.out.println("Close the window to end the program");
		while(world.isShowing()) {} // Wait until the program is closed
		
	}
	
	/**
	 * Duplicate a turtle
	 * @param t the original turtle
	 * @param w the world to copy the new turtle to
	 * @return the copied turtle
	 */
	public static Turtle copy(Turtle t, World w) {

		Turtle copy = new Turtle(t.getXPos(), t.getYPos(), w);
		copy.turn(t.getHeading());
		return copy;
	}
	
	/**
	 * Reset a turtles attributes
	 * @param t The turtle that needs to be normalized
	 */
	public static void normalize(Turtle t) {
		t.setPenColor(FRACTAL_COLOR);
		t.setPenWidth(FRACTAL_WIDTH);
//		t.hide();
	}

	/*
	 * @see me.yoerger.geoff.edu.progClass.assignments.Analysis#printQuestions(me.yoerger.geoff.edu.progClass.assignments.Printer)
	 */
	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printAnswer("Draw a Fractal");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Fractals are a large part of abstract geometry, this allows you to change the scale to show different fractals if neccessary");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned to to uncuncurently iterate over a changing list.");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("When I was iterating over all the turtles and adding new ones, it didnt like that. So I made a temp copy of the list in that state and used it instead.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Provide the option to show tohe animation or not. Same with the scale");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("Do different fractals");
		
		printer.print("How could you create a fractal with different colors?");
		printer.printAnswer("Just change the static color field at the top of the source file");
		
		printer.print("How could you invert a fractal so that it is drawn in the opposite direction?");
		printer.printAnswer("turtle.turn(180) at the top.");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to create a copy of a list that doesnt change");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to stop the spam of the concurrent modification exceptions from the other threads.");
		
		
	}

}
