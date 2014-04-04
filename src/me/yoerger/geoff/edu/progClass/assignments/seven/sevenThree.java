package me.yoerger.geoff.edu.progClass.assignments.seven;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;

/**
 * Assignment 7.3
 * Make random assortments of colored boxes and lines
 * @see RandomColor
 */
public class sevenThree implements Analysis{

	public static void main(String[] args) {
		List<Color> colorList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			colorList.add(Color.BLACK);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.RED);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.GREEN);
		}
		for (int i = 0; i < 5; i++) {
			colorList.add(Color.ORANGE);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.BLUE);
		}
		for (int i = 0; i < 5; i++) { // Ew bright colors
			colorList.add(Color.YELLOW);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.CYAN);
		}
		Collections.shuffle(colorList);
		World world = new World();
		Turtle turtle = new Turtle(10, 10, world);
		
		loop:
		for(int i = 0; i < 10; i++) { // Draw the boxes
			go(turtle, r.nextInt(390), r.nextInt(390), true); 
			if (colorList.get(i) == Color.BLACK) { // Dont want icky black squares now do we
				continue loop;
			}
			turtle.setPenWidth(r.nextInt(75) + 25);
			turtle.setPenColor(colorList.get(i));
			turnFromUp(turtle, r.nextInt(4) * 90);
			turtle.forward(r.nextInt(150));
			
		}
		
		turtle.setPenWidth(10);
		for (Color color : colorList) { // Draw the lines
			turtle.setPenColor(color);
			turtle.setPenWidth(r.nextInt(5));
			drawLineFromOrigin(turtle, r.nextInt(390) + 10 , r.nextBoolean());
		}
		turtle.hide(); // Hide the turtle into the background
		
		
		
	}
	static void drawLineFromOrigin(Turtle t, int coord, boolean isX) {
		int awaydeg;
		if(isX) {
			go(t, coord, 10, true);
			awaydeg = 180;
		} else {
			go(t, 10, coord, true);
			awaydeg = 90;
		}
		turnFromUp(t, awaydeg);
		t.forward(10000); // Draw that line from origin to edge
	}
	static void go(Turtle t, int x, int y, boolean silent) {
		boolean down = t.getPen().isPenDown();
		if(silent) {
			t.setPenDown(false);
		}
		t.turnToFace(x, y);
		t.forward((int) t.getDistance(x, y));
		if(silent) {
			t.setPenDown(down);
		}
	}
	static void turnFromUp(Turtle t, int deg) {
		t.turnToFace(t.getXPos(), t.getYPos() - 1);
		t.turn(deg);
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		printer.printAnswer("Make abstract art using");
		
		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("It really doesnt besides the fact that programs like these can be used to generate more abstract art, or even modified to meet requirements.");
		
		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to use static methods to preform repetitive tasks");
		
		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Figuring out why it was going the wrong direction, turned out that the turtle was upsidedown. I solved it by adding a timeout and not hiding the turtle.");
		
		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Give the user options on what is generated.");
		
		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("By making some lines overlap and some not");
		
		printer.print("In general, what would it take to write a program that automatically creates Mondrian art?");
		printer.printAnswer("Not much");
		
		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to  make the turtle goto varialbe locations with one call.");
		
		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to easily add all the colors into the Arraylist instead of using for loops?");
		
		
		
	}
	

}
