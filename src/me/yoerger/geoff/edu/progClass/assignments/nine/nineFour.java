package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;

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
		double scaleRatio = Math.abs(kTile.getHeight() / kTile.getWidth());
		if (scaleRatio < 1) {
			scaleRatio = 1 / scaleRatio;
		}
		Picture scaledPic = new Picture(Scalr.crop(kTile.getBufferedImage(), 250, 250));
		// Shrink it as much as possible down to 250 without adding whitespace
		// and crop the extra
		AffineTransform topLeft = AffineTransform.getScaleInstance(1, 1);
		AffineTransform topRight = AffineTransform.getScaleInstance(-1, 1);
		AffineTransform bottomLeft = AffineTransform.getScaleInstance(1, -1);
		AffineTransform bottomRight = AffineTransform.getScaleInstance(-1, -1);
		Picture diagonalMirror = new Picture(250, 250);
		for (Pixel pixel : scaledPic.getPixels()) {
			diagonalMirror.getPixel(pixel.getY(), pixel.getX()).setColor(pixel.getColor());
			// Switch the x and y coords
		}
		scaledPic.show();
		diagonalMirror.show();
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
