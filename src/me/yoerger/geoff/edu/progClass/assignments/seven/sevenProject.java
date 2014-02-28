package me.yoerger.geoff.edu.progClass.assignments.seven;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import me.yoerger.geoff.edu.progClass.mod7.CoordPair;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;
import me.yoerger.geoff.edu.progClass.mod7.Range;

public class sevenProject implements Analysis{
	final static int PADDING = 50;
	final static int SCALE = 40;
	final static int TIMEOUT = 1000; // Millis
	final static Random random = new Random(System.nanoTime());
	final static World world = new World();
	static Map<CoordPair, Turtle> turtles = new HashMap<>();

	public static void main(String[] args) {
		world.setBackground(Color.BLACK); // Should work, dont know why.
		for(int x : new Range(10).range()) {
			for(int y : new Range(10).range()) {
				Turtle thisTurtle = new Turtle(x * SCALE + PADDING, y * SCALE + PADDING, world);
				thisTurtle.setColor(Color.WHITE);
				thisTurtle.setPenDown(false);
				turtles.put(new CoordPair(x, y), thisTurtle);
				// I used the cood pairs just to make it have different keys for the hashSet.
				// Yay turtles
			}
		}
		Runnable runnable = new Runnable() {
			public void run() { 
				for(Turtle turtle : turtles.values()) {
					turtle.setBodyColor(randomColor());
					turtle.setShellColor(randomColor());
					turtle.turn((double) (random.nextInt(360)));
					turtle.forward(random.nextInt(5));
				}
			}
		};
		while(world.isShowing()) {
			runnable.run();
			try {
				Thread.sleep(TIMEOUT);
			} catch (Exception e) {
			//	e.printStackTrace(); Ignore
			}
		}
		System.exit(0);
	}
	public static Color randomColor() {
		return RandomColor.make();
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the main point of this assignment. (Required)");
		printer.printAnswer("Make a turtle dance floor.");
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("It doesnt really.... But color randomizers like one I made here could in theory be used in real dance floors.");
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to make an anonymous class that implements an interface (The Runnable)");
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Making the turtles turn in random fashions, and making them not  gradualy spread apart over time.");
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Next time I will use the bookClasses.World's built in list of Turtles");
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("By making the turtles go in patterns");
		printer.print("How did your Module Project help you extend the media computing concepts learned in this lesson?");
		printer.printAnswer("I learned how to use hashSets to make sure that I only have one copy of an identical object.");
		printer.print("What did you like the most about your Module Project? What did you like the least?");
		printer.printAnswer("The randomness, and that the turtles feet change colors independent of their body; THe fact that turtles can stay the same color through 2 frams.");
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to make random field accessors");
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to make the turtles colors be affected by their positions...");
	}
	

}
