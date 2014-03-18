package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Graphics;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;

import org.imgscalr.Scalr;

import sun.awt.image.ImageFormatException;

public class nineFour implements Analysis {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String fileLoc = "P:\\Programming\\Workspace\\ProgrammingClass\\etc\\Flowers.jpeg";
		// String fileLoc = FileChooser.pickAFile();
		Picture kTile;
		if (fileLoc == null) {
			kTile = new Picture(200, 200);
		} else {
			try {
				kTile = new Picture(fileLoc);
			} catch (ImageFormatException e) {
				kTile = new Picture(200, 200);
			}
		}
		Picture scaledPic = new Picture(Scalr.resize(kTile.getBufferedImage(), 250));
		// TODO: Find out how to mirror the image about a diagonal
		Picture diagonalMirror = new Picture(250, 250);
		// TODO: Create a canvas and mirror the first image to all sides
		Picture canvas = new Picture(500, 500);
		Graphics graphics = canvas.getGraphics();

	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
