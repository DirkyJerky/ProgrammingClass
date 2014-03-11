package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;
import me.yoerger.geoff.edu.progClass.mod9.Drawer;
import me.yoerger.geoff.edu.progClass.mod9.PictureUser;

public class nineThree extends PictureUser implements Analysis {
	// Enums!
	public enum Axis {
		X, Y;
	}

	public enum AxisSide {
		Left(Axis.X), Right(Axis.X), Top(Axis.Y), Bottom(Axis.Y);

		public Axis axis;

		private AxisSide(final Axis axis) {
			this.axis = axis;
		}
	}

	public static void main(final String[] args) {
		Picture tile = new Picture(50, 50);
		Drawer drawer = new Drawer(tile);
		drawer.set(Color.BLACK, 10);
		drawer.drawOval(20, 20, 20, 20);

		Picture canvas = new Picture((tile.getWidth() * 4) + 4,
				(tile.getHeight() * 4) + 4);
		for (Pixel pixel : tile.getPixels()) {
			copy(pixel, canvas, 0, 0);
		}
		mirrorPicture(canvas, AxisSide.Right);
		mirrorPicture(canvas, AxisSide.Bottom);
		canvas.show();

	}

	public static void mirrorPicture(final Picture pictureWithTile,
			final AxisSide directionSideOfPictureWithStuff) {
		double xCenter = (pictureWithTile.getWidth() / 2) + 1;
		double yCenter = (pictureWithTile.getHeight() / 2) + 1;
		switch (directionSideOfPictureWithStuff) {
		case Bottom:
			for (Pixel pixel : pictureWithTile.getPixels()) {
				if (pixel.getY() < yCenter) {
					continue;
				}
				copy(pixel, pictureWithTile, pixel.getX(),
						mirrorNum(pixel.getY(), yCenter));
			}

		case Top:
			for (Pixel pixel : pictureWithTile.getPixels()) {
				if (pixel.getY() > yCenter) {
					continue;
				}
				copy(pixel, pictureWithTile, pixel.getX(),
						mirrorNum(pixel.getY(), yCenter));
			}
		case Left:
			for (Pixel pixel : pictureWithTile.getPixels()) {
				if (pixel.getX() < xCenter) {
					continue;
				}
				copy(pixel, pictureWithTile, mirrorNum(pixel.getX(), yCenter),
						pixel.getY());
			}
		case Right:
			for (Pixel pixel : pictureWithTile.getPixels()) {
				if (pixel.getX() > xCenter) {
					continue;
				}
				copy(pixel, pictureWithTile, mirrorNum(pixel.getX(), yCenter),
						pixel.getY());
			}
		}

	}

	@Override
	public void printQuestions(final Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}

	public static void copy(final Pixel src, final Picture dst, final int xLoc,
			final int yLoc) {
		try {
			dst.getPixel(xLoc + 2, yLoc + 2).setColor(src.getColor());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(dst.toString() + "-=-" + xLoc + "-=-" + yLoc);
		} // Oh no! IDK
	}

	public static int mirrorNum(final int mirrorThis, final double median) {
		return (int) (median + (median - mirrorThis));
	}
}
