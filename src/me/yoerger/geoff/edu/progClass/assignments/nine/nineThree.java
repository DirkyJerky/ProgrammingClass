package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.mod9.PictureUser;

public class nineThree extends PictureUser implements Analysis {
	public static void main(final String[] args) throws InterruptedException {
		Picture tile = new Picture(50, 50);
		tile.getGraphics().setColor(Color.BLACK);
		tile.getGraphics().drawOval(20, 20, 20, 20);

		Picture canvas = new Picture(tile.getWidth() * 4, tile.getHeight() * 4);
		canvas.getGraphics().drawImage(tile.getImage(), 0, 0, null);
		canvas.repaint();
		canvas.show();
		// mirrorPicture

	}

	public static void mirrorPicture(final Picture pictureWithTile,
			final int xMirror, final int yMirror) {

	}

	@Override
	public void printQuestions(final Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
