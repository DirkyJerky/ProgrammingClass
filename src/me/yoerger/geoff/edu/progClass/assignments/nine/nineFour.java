package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Graphics2D;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.mod9.Scaler;

public class nineFour implements Analysis {

	public static void main(String[] args) {
		Picture kTile = new Picture(200, 200);
		Graphics2D graphics = (Graphics2D) kTile.getGraphics();
		Scaler scaler = new Scaler(graphics);
		scaler.apply(200, 200);
		kTile.show();
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
