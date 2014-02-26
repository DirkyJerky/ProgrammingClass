package assignments.eight;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import mod7.Range;
import assignments.Analysis;
import assignments.Printer;
import bookClasses.Turtle;
import bookClasses.World;


public class eightProject implements Analysis{

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		World world = new World(500, 500);
		Turtle turtle = new Turtle(250, 250, world);
		Scanner in = new Scanner(System.in);
		Printer printer = new Printer();
//		normalize(turtle);
		printer.print("How much iterations do you want the fractal to go for?");
		int iters = in.nextInt();
		printer.print("Enter the code for the degrees you want the duplicate turtles to be turned to.");
		printer.print("e.x. '20, -20' will split the turtle into 2 turtles facing 20 degress to the left and right at each iteration");
		String code = in.next().trim();
		in.close();
		String[] degs = code.split(",");
		List<Integer> splits = new ArrayList<>();
		for(String degss : degs) {
			if(degss.trim() == "") {
				continue; // Ignore if blank
			}
			try {
				int intt = Integer.parseInt(degss.trim());
				splits.add(intt);
			} catch (Exception e) {} // Nothing
		}
		Set<Turtle> turtlez = new HashSet<>();
		turtlez.add(turtle);
		Set<Turtle> tempSet = new HashSet<>();
		for(int i : new Range(iters).range()) {
			turtlez = new HashSet<>();
			for(Turtle thisTurtle : turtlez) {
				for(int degress : splits) {
					Turtle newTurtle = new Turtle(thisTurtle.getXPos(), thisTurtle.getYPos(), world);
					normalize(newTurtle);
					newTurtle.turn(thisTurtle.getHeading());
					newTurtle.turn(degress);
					tempSet.add(newTurtle);
				}
			}
			turtlez.clear();
			turtlez.addAll(tempSet);
			tempSet.clear();
			Thread.sleep(1000);
		}
		
	}

	public void printQuestions(Printer printer) {
		// TODO Auto-generated method stub
		
	}
	public static void normalize(Turtle t) {
		t.setPenColor(Color.BLACK);
		t.setPenWidth(1);
		t.hide();
	}

}
