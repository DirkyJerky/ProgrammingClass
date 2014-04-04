package me.yoerger.geoff.edu.progClass.assignments.seven;

import java.awt.Color;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;

/**
 * Assignment 7.2
 * Draw a turtle, with a turtle
 *
 */
public class sevenTwo implements Analysis{

	public static void main(String[] args) {
		final Color LIME = new Color(Integer.decode("#7CFC00"));
		final Color GREEN = new Color(Integer.decode("#458B00"));
		World w = new World();
		Turtle t = new Turtle(150, 400, w);
		t.setPenDown(false);
		t.setPenWidth(10);
		drawBox(t, 50, 50, LIME); // Begin hands, feet, and head
		go(t, 350, 400, true);
		drawBox(t, 50, 50, LIME);
		go(t, 100, 200, true);
		drawBox(t, 50, 50, LIME);
		go(t, 400, 200, true);
		drawBox(t, 50, 50, LIME);
		go(t, 250, 100, true);
		drawBox(t, 50, 50, LIME); // END
		t.setPenDown(true);
		t.setPenColor(GREEN);
		go(t, 150, 200, false); // Begin drawing outline of body
		go(t, 200, 350, false);
		go(t, 350, 350, false);
		go(t, 400, 200, false);
		go(t, 300, 100, false);
		go(t, 250, 100, false); // END
		go(t, 275, 250, true); // Align with center of drawing
		turnUp(t); // Turn to face up
	}
	static void drawBox(Turtle t, int height, int width, Color color) {
		t.setPenDown(true);
		t.setPenColor(color);
		turnUp(t);
		t.forward(height);
		t.turnRight();
		t.forward(width);
		t.turnRight();
		t.forward(height);
		t.turnRight();
		t.forward(width);
		
	}
	static void go(Turtle t, int x, int y, boolean silent) {
		if(silent) {
			t.setPenDown(false);
		}
		t.turnToFace(x, y);
		t.forward((int) t.getDistance(x, y));
		if(silent) {
			t.setPenDown(true);
		}
	}
	
	static void turnUp(Turtle t) {
		t.turnToFace(t.getXPos(), t.getYPos() - 1);
	}
	@Override
	public void printQuestions(Printer p) {
		p.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		p.printAnswer("Draw somthing with the turtle");
		
		p.print("Discuss how this assignment relates to a real-life situation. (Required)");
		p.printAnswer("If you had a robot with different colo0red pens, this could enable it to draw something.");
		
		p.print("Reflect on your growth as a programmer. (Required)");
		p.printAnswer("Not much.");
		
		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printAnswer("Drawing the boxes and get the coords right.");
		
		p.print("Describe at least one thing that will be done differently in the future.");
		p.printAnswer("Put the coord pairs in a List");
		
		p.print("Suggest how this assignment could be extended.");
		p.printAnswer("Draw more than one object.");
		
		p.print("If you were updating the Turtle class, what is one additional method you would include?");
		p.printAnswer("A Turtle.moveTo(int x, int y, boolean relative)");
		
		p.print("What question(s) of your own did you answer while writing this program?");
		p.printAnswer("None really");
		
		p.print("What unanswered question(s) do you have after writing this program?");
		p.printAnswer("How to store coord pairs in a list...");
		
	}

}
