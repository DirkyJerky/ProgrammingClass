package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;
import java.awt.geom.Arc2D;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;
import me.yoerger.geoff.edu.progClass.mod9.Drawer;
import me.yoerger.geoff.edu.progClass.mod9.PictureUser;

public class nineThree extends PictureUser implements Analysis {
	public final static int TILE_WIDTH = 100;

	public static void main(final String[] args) throws InterruptedException {
		Picture tile = new Picture(TILE_WIDTH, TILE_WIDTH);
		Drawer drawer = new Drawer(tile);
		drawer.set(Color.BLACK, 10);
		drawer.drawOval(20, 20, 20, 20);
		drawer.set(Color.RED, 4);
		drawer.drawOval(25, 25, 10, 10);
		drawer.setRandom();
		drawer.drawString("Program", 20, 70);
		drawer.setRandom();
		drawer.draw(new Arc2D.Float(40, 90, 50, 30, 0, 100, Arc2D.PIE), RandomColor.make(), true);

		Picture canvas = mirror4(tile);

		canvas.show();
		Thread.sleep(10000);
		System.exit(0);
	}

	public static int mirrorNum(int num, double mirrorLine) {
		DecimalFormat roundme = new DecimalFormat("#");
		roundme.setRoundingMode(RoundingMode.HALF_UP);
		double mirrorLineRounded = Double.parseDouble(roundme.format(mirrorLine * 2)) / 2;
		// Round to the nearest 1/2 place
		double RETURN = mirrorLineRounded + (mirrorLineRounded - num);
		return (int) RETURN;
	}

	public static Picture mirror4(Picture tile) {
		Picture canvas = new Picture((tile.getWidth() * 2), (tile.getHeight() * 2));
		for (Pixel pixel : tile.getPixels()) {
			if (pixel.getColor() == Color.WHITE) {
				continue;
			} // Ignore white
			Pixel topLeft = canvas.getPixel(pixel.getX(), pixel.getY());
			Pixel bottomLeft = canvas.getPixel(pixel.getX(),
			        mirrorNum(pixel.getY(), canvas.getHeight() / 2));
			Pixel topRight = canvas.getPixel(mirrorNum(pixel.getX(), canvas.getWidth() / 2),
			        pixel.getY());
			Pixel bottomRight = canvas.getPixel(mirrorNum(pixel.getX(), canvas.getWidth() / 2),
			        mirrorNum(pixel.getY(), canvas.getHeight() / 2));
			try {
				topLeft.setColor(pixel.getColor());
				bottomLeft.setColor(pixel.getColor());
				topRight.setColor(pixel.getColor());
				bottomRight.setColor(pixel.getColor());
			} catch (ArrayIndexOutOfBoundsException aioobe) {
				// Border does weird things......
			}
		}
		return canvas;
	}

	@Override
	public void printQuestions(final Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
