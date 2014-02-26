package assignments.eight;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import mod7.Range;
import assignments.Analysis;
import assignments.Printer;
import bookClasses.Turtle;
import bookClasses.World;

public class eightOne implements Analysis{

	final static int LEN = 100;
	final static int TIMEOUT = 1000;
	final static float SCALE = 0.75F;
	final static Color FRACTAL_COLOR = Color.red;
	final static int FRACTAL_WIDTH = 2;
	
	@SuppressWarnings("unused") // For the console clearer below.
	public static void main(String[] args) throws Exception {
		
//		System.out.println("The other threads dont like all these turtles"
//				+ " drawing over each other,\nJust ignore the oncomming spam");
		final World world = new World();
		final Turtle starter = new Turtle(300, 400, world);
		starter.setPenColor(FRACTAL_COLOR);
		starter.hide();
		starter.setPenWidth(FRACTAL_WIDTH);
		int phase = LEN;
		final Set<Turtle> turtles = new HashSet<>();
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
		System.exit(0);
		
	}
	
	public static Turtle copy(Turtle t, World w) {

		Turtle copy = new Turtle(t.getXPos(), t.getYPos(), w);
		copy.turn(t.getHeading());
		return copy;
	}
	
	public static void normalize(Turtle t) {
		t.setPenColor(FRACTAL_COLOR);
		t.setPenWidth(FRACTAL_WIDTH);
		t.hide();
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the main point of this assignment. (Required)");
		printer.printTab("Draw a Fractal");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printTab("Fractals are a large part of abstract geometry, this allows you to change the scale to show different fractals if neccessary");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printTab("I learned to to uncuncurently iterate over a changing list.");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printTab("When I was iterating over all the turtles and adding new ones, it didnt like that. So I made a temp copy of the list in that state and used it instead.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printTab("Provide the option to show tohe animation or not. Same with the scale");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printTab("Do different fractals");
		
		printer.print("How could you create a fractal with different colors?");
		printer.printTab("Just change the static color field at the top of the source file");
		
		printer.print("How could you invert a fractal so that it is drawn in the opposite direction?");
		printer.printTab("turtle.turn(180) at the top.");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printTab("How to create a copy of a list that doesnt change");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printTab("How to stop the spam of the concurrent modification exceptions from the other threads.");
		
		
	}

}
