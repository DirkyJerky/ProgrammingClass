package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
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
		Drawer drawer = new Drawer(pictre);
		drawer.set(Color.BLACK, 10);
		drawer.drawOval(100, 100, 50, 75);
		
		drawer.set(Color.BLUE, 3);
		drawer.fillOval(100, 100, 50, 75);
		// Do it again and again and again....
		drawer.set(Color.CYAN, 5);
		drawer.drawHollow(new Rectangle(new Point(10, 10), new Dimension(20,  40)));
	}
	
	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
		
		
	}
}
