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

public class nineTwo implements Analysis{

	public static void main(String[] args) throws Exception {
		Picture canvas = new Picture(500, 500);
		canvas.setAllPixelsToAColor(Color.WHITE);
		drawTest(canvas);
		canvas.show();
		Thread.sleep(10000);
		System.exit(0);
	}
	public static void drawTest(Picture pictre) {
		final Drawer drawer = new Drawer(pictre);
		Runnable run = new Runnable() {
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
		drawer.draw(new Rectangle(new Point(100, 300), new Dimension(300,  40)), RandomColor.make(), false);
		// Mouth
		
		run.run();
		drawer.drawString("Nose", 200, 200);
		// Mouth
		
		run.run();
		drawer.drawLine(RandomColor.make(), 10, new Point2D.Float(100, 250), new Point2D.Float(100, 350));
		drawer.drawLine(RandomColor.make(), 15, new Point2D.Float(400, 250), new Point2D.Float(400, 350));
	}
	
	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
	}
}
