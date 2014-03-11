package me.yoerger.geoff.edu.progClass.assignments.seven;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import sun.awt.image.ImageFormatException;

public class sevenOne implements Analysis {
	public static void main(final String[] args) throws ImageFormatException {
		int pixels = 0;
		System.out.println("Please choose your file.");
		Picture pictureObj = new Picture(FileChooser.pickAFile());

		// Picture pictureObj = new
		// Picture("P:\\Programming\\Externals\\Refs\\Maze_Background.jpg"); //
		// Me

		World worldObj = new World();
		worldObj.setPicture(pictureObj);

		Turtle turtle = new Turtle(23, 42, worldObj);
		turtle.setHeight(12);
		turtle.setWidth(12);
		turtle.setHeading(90);
		turtle.show();
		pixels += moveFor(turtle, 93);
		turtle.turnRight();
		pixels += moveFor(turtle, 38);
		turtle.turnLeft();
		pixels += moveFor(turtle, 195);
		turtle.turn(151);
		pixels += moveFor(turtle, 120);
		turtle.turn(-61);
		pixels += moveFor(turtle, 65);
		turtle.turn(60);
		pixels += moveFor(turtle, 25);
		turtle.turn(30);
		pixels += moveFor(turtle, 105);

		System.out.println("The turtle moved " + pixels + " Pixels.");
	}

	public static int moveFor(final Turtle t, final int pixels) {
		t.forward(pixels);
		return pixels;
	}

	@Override
	public void printQuestions(final Printer p) {
		p.print("Describe the me.yoerger.geoff.edu.progClass.main point of this assignment. (Required)");
		p.printAnswer("Make a turtle move through a maze, and count the number of pixels it takes.");

		p.print("Discuss how this assignment relates to a real-life situation. (Required)");
		p.printAnswer("If the turtle was a RC programmable car, and there was an obsticle course,.. yea.");

		p.print("Reflect on your growth as a programmer. (Required)");
		p.printAnswer("Nothing much here");

		p.print("Describe the biggest problem encountered and how it was fixed.");
		p.printAnswer("Tracking the pixels moved in the best was possible");

		p.print("Describe at least one thing that will be done differently in the future.");
		p.printAnswer("Put the movement instructions into a Queue<String>");

		p.print("Suggest how this assignment could be extended.");
		p.printAnswer("Make it interperet its surroundings and determine how to move");

		p.print("In very general terms, how could you program the turtle to find its way through the maze on its own?");
		p.printAnswer("Have it look at the walls, and use a premade maze solving algorithm");

		p.print("What question(s) of your own did you answer while writing this program?");
		p.printAnswer("None");

		p.print("What unanswered question(s) do you have after writing this program?");
		p.printAnswer("Whats the best way to convert a maze-algortithm to work with this.");

	}
}
