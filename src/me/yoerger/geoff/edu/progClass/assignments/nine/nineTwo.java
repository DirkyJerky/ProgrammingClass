package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;
import me.yoerger.geoff.edu.progClass.mod9.Drawer;

/**
 * Assignment 9.2
 * Draw a face
 * @see Drawer
 */
public class nineTwo implements Analysis {

	public static void main(String[] args) throws Exception {
		Picture canvas = new Picture(500, 500);
		canvas.setAllPixelsToAColor(Color.WHITE);
		drawTest(canvas);
		canvas.show();
		Thread.sleep(10000);
		System.exit(0);
	}

	/**
	 * @param pictre The picture to draw a random face on
	 */
	public static void drawTest(Picture pictre) {
		final Drawer drawer = new Drawer(pictre);
		Runnable run = new Runnable() {
			@Override
			public void run() {
				drawer.setRandom();
			}
		}; // Im tired today
		run.run();
		drawer.drawOval(100, 100, 50, 75);
		// Left eye

		run.run();
		drawer.fillOval(100, 100, 50, 75);
		// Fill left eye

		run.run();
		drawer.drawOval(300, 100, 50, 75);
		// Right eye

		run.run();
		drawer.fillOval(300, 100, 50, 75);
		// Fill right eye

		run.run();
		drawer.drawArc(50, 70, 200, 80, 70, 60);
		// Left Eyebrow

		run.run();
		drawer.drawArc(250, 70, 200, 80, 70, 60);
		// Right Eyebrow

		run.run();
		drawer.draw(new Rectangle(new Point(100, 300), new Dimension(300, 40)), RandomColor.make(),
		        false);
		// Mouth

		run.run();
		drawer.drawString("Nose", 200, 200);
		// Mouth

		run.run();
		drawer.drawLine(RandomColor.make(), 10, new Point2D.Float(100, 250), new Point2D.Float(100,
		        350));
		drawer.drawLine(RandomColor.make(), 15, new Point2D.Float(400, 250), new Point2D.Float(400,
		        350));
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("Describe the main point of this assignment. (Required)");
		printer.printAnswer("Make a drawing class");

		printer.print("Discuss how this assignment relates to a real-life situation. (Required)");
		printer.printAnswer("Photo editing tools place the algoritms iin one central location  where the user can use them easily");

		printer.print("Reflect on your growth as a programmer. (Required)");
		printer.printAnswer("I learned how to use variables in constrctors");

		printer.print("Describe the biggest problem encountered and how it was fixed.");
		printer.printAnswer("Making the picture update after editing.");

		printer.print("Describe at least one thing that will be done differently in the future.");
		printer.printAnswer("Don't use the bookClasses unless neccessary...");

		printer.print("Suggest how this assignment could be extended.");
		printer.printAnswer("By adding a more friendlier way to invoke the methods instead of some numbers");

		printer.print("What is the purpose of a private instance variable?");
		printer.printAnswer("To be able to access stuff from your invoker");

		printer.print("What is the purpose of a constructor?");
		printer.printAnswer("To make an object with stuff initialized");

		printer.print("What is one advantage of the OOP design?");
		printer.printAnswer("Easier to maintain, debug, and change");

		printer.print("What question(s) of your own did you answer while writing this program?");
		printer.printAnswer("How to make a static runnable to easily perform repetitive tasks");

		printer.print("What unanswered question(s) do you have after writing this program?");
		printer.printAnswer("How to use a constructor tto invoke a runnable without using dot notation?");

	}
}
