package me.yoerger.geoff.edu.progClass.assignments.eight;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.common.base.Preconditions;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import me.yoerger.geoff.edu.progClass.mod7.Range;


public class eightProject implements Analysis{
	
	public final static long TIMEOUT = 250;
	public final static long FINAL_TIMEOUT = 5000;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Printer printer = new Printer();
//		printer.print("How much iterations do you want the fractal to go for?");
		printer.print("Be VERY CAREFUL what you input, you can very easily run your computer out of memory.");
		printer.print("If you input some wrong things, I will try stop me so I dont kill your computer.");
		printer.print("\n");
		printer.print("Enter the code for the degrees you want the duplicate turtles to be turned to." + "\n" +
				"An example is '20, -20, 40, -40'");
		
		String code = in.nextLine().trim();
		Preconditions.checkArgument(code.split(",").length <= 10, "To much input there buddy, try some less numbers");
		System.out.println("How long do you want the initial lines to be? (A good one is 25-75)");
		int phase = in.nextInt();
		Preconditions.checkArgument(phase <= 150, "Thats to big, try something smaller than 150");
		Preconditions.checkArgument(phase >= 10, "Thats to small, try something bigger than 10");
		System.out.println("What do you want the scale to be that is applied each iteration? (A good one is 0.90 - 0.70)");
		float SCALE = in.nextFloat();
		Preconditions.checkArgument(SCALE >= 0.5, "Thats to small, try something bigger than 0.5");
		Preconditions.checkArgument(SCALE < 1, "Thats to big, try something less than 1.0");
		Preconditions.checkArgument(phase * Math.pow(SCALE, 15) < 50, "Try something smaller.");
		in.close();
		String[] degs = code.split(",");
		
		List<Integer> splits = new ArrayList<>();
		

		int firstTurtleMove = 0;
		for(String degss : degs) {
			if(degss.trim() == "") {
				continue; // Ignore if blank
			}
			try {
				int intt = Integer.parseInt(degss.trim());
//				System.out.println(intt);
				if(!(firstTurtleMove == 0)) {
					splits.add(intt);
				} else {
					firstTurtleMove = intt;
//					System.out.println(firstTurtleMove + "--");
				}
			} catch (Exception e) {} // Nothing
		}
		
		

		World world = new World(500, 500);
		Turtle turtle = new Turtle(250, 450, world);
		normalize(turtle, phase);
		Thread.sleep(2000);
		
		Set<Turtle> iterTurtles = new HashSet<>();
		for(int i : new Range(25).range()) {
			if (!world.isShowing()) {
				System.exit(0);
			}
			if (phase < 10) {
				finish();
				System.exit(0);
			}
			phase *= SCALE;
			iterTurtles.addAll(world.getTurtleList());
			for(Turtle thisTurtle : iterTurtles) {
				
				for(int i1 : splits) {
					Turtle copy = copy(thisTurtle, world);
					copy.turn(i1);
					normalize(copy, phase);
				}
				thisTurtle.turn(firstTurtleMove);
			}
			for(Turtle moveTurtle : world.getTurtleList()) {
				moveTurtle.forward(phase);
			}
			Thread.sleep(TIMEOUT);
		}
		finish();
		System.exit(0);
		
	}

	public void printQuestions(Printer printer) {
		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printAnswer("Extend a previous assignment or make a new challenge, I did the first.");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Fractals take up a huge part of abstract geometry, this can help study them, make them, and analyze them.");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("Thi");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Why the turtles were not bieng copied, turns out I was using in.next() when I should have"
				+ "been using in.nextLine() because that input needed containted spaces.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Use a premade logger instead of System.out.print()");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("By making the fractal start on different positions to contemplate with different fractals.");
		
		printer.print("How did your Module Project help you extend the media computing concepts learned in this lesson?");
		printer.printAnswer("This one helped me strengthen my debuging and prompting skills.");
		
		printer.print("What did you like the most about your Module Project? What did you like the least?");
		printer.printAnswer("How much different things you can draw with it; The static colors");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How imagine the flow of the program to know figure out what wasnt working right.");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How do I get rid of all those exceptions in the other thread where the drawing happens.");
		
		
	}
	public static void normalize(Turtle t, int phase) {
		t.setPenColor(new Color(0, (phase * 10 >= 255 ? 255 : phase * 10), (phase * 10 >= 255 ? 255 : phase * 10)));
		t.setPenWidth(1);
		t.hide();
	}
	public static Turtle copy(Turtle t, World w) {

		Turtle copy = new Turtle(t.getXPos(), t.getYPos(), w);
		copy.turn(t.getHeading());
		return copy;
	}
	public static void finish() throws Exception {
		System.out.println("\n\n\n\n\n\n\n\n\n\n"); // Clear the screen a bit.
		System.out.println("Just ignore all that exception spam above me.");
		Thread.sleep(FINAL_TIMEOUT);
		System.exit(0);
	}

}
