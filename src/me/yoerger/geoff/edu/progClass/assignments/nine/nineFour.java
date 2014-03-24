package me.yoerger.geoff.edu.progClass.assignments.nine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.FileChooser;
import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.bookClasses.Pixel;

import org.imgscalr.Scalr;

import sun.awt.image.ImageFormatException;

public class nineFour implements Analysis {
	private final static int TILE_WIDTH = 250;
	private static Picture ERROR_PICTURE = new Picture(TILE_WIDTH, TILE_WIDTH);
	static {
		ERROR_PICTURE.setAllPixelsToAColor(Color.red);
		ERROR_PICTURE.drawString("No Picture", 25, 25);
	}

	public enum Corner {
		TOP_LEFT(0, 0),
		TOP_RIGHT(1, 0),
		BOTTOM_LEFT(0, 1),
		BOTTOM_RIGHT(1, 1);

		private int xScale;
		private int yScale;

		private Corner(int xScale, int yScale) {
			this.xScale = xScale;
			this.yScale = yScale;
		}

		public int getX(int scale) {
			return this.xScale * scale;
		}

		public int getY(int scale) {
			return this.yScale * scale;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// String fileLoc =
		// "/Users/Geoff/git/DirkyJerky/ProgrammingClass/etc/Flowers.jpeg";
		System.out
		        .println("Please select a small picture that is around 250 pixels wide.");
		String fileLoc = FileChooser.pickAFile();
		Picture kTile;
		if (fileLoc == null) {
			kTile = new Picture(ERROR_PICTURE);
		} else {
			try {
				kTile = new Picture(fileLoc);
			} catch (ImageFormatException e) {
				kTile = new Picture(ERROR_PICTURE);
			}
		}

		// Flip across the bottom left to top right diagonal
		Pixel oppositePixel;
		for (Pixel pixel : kTile.getPixels()) {
			try {
				oppositePixel = kTile.getPixel(TILE_WIDTH - pixel.getY(),
				        TILE_WIDTH - pixel.getX());
				if (oppositePixel.getColor().equals(pixel.getColor())) {
					continue;
				} else {
					oppositePixel.setColor(pixel.getColor());
				}
			} catch (ArrayIndexOutOfBoundsException ae) {}
			// Ignore the out of bounds stuff because the bounds in the
			// bookClasses.Picture are very strange
		}
		for (Pixel pixel : kTile.getPixels()) {
			try {
				oppositePixel = kTile.getPixel(pixel.getY(),
				        pixel.getX());
				if (oppositePixel.getColor().equals(pixel.getColor())) {
					continue;
				} else {
					oppositePixel.setColor(pixel.getColor());
				}
			} catch (ArrayIndexOutOfBoundsException ae) {}
			// Ignore the out of bounds stuff because the bounds in the
			// bookClasses.Picture are very strange
		}
		Picture scaledPic = new Picture(Scalr.crop(kTile.getBufferedImage(),
		        TILE_WIDTH, TILE_WIDTH));
		BufferedImage scaledPicBI = scaledPic.getBufferedImage();
		// Shrink it as much as possible down to 250 without adding whitespace
		// and crop the extra
		Map<Corner, Object> transforms = new HashMap<>();
		transforms.put(Corner.TOP_LEFT, AffineTransform.getScaleInstance(1, 1));
		transforms.put(Corner.TOP_RIGHT,
		        AffineTransform.getScaleInstance(-1, 1));
		transforms.put(Corner.BOTTOM_LEFT,
		        AffineTransform.getScaleInstance(1, -1));
		transforms.put(Corner.BOTTOM_RIGHT,
		        AffineTransform.getScaleInstance(-1, -1));
		((AffineTransform) transforms.get(Corner.TOP_RIGHT)).translate(
		        -scaledPicBI.getWidth(null), 0);
		((AffineTransform) transforms.get(Corner.BOTTOM_LEFT)).translate(0,
		        -scaledPicBI.getWidth(null));
		((AffineTransform) transforms.get(Corner.BOTTOM_RIGHT)).translate(
		        -scaledPicBI.getWidth(null), -scaledPicBI.getWidth(null));
		for (Corner corner : Corner.values()) {
			transforms.put(corner, new AffineTransformOp(
			        ((AffineTransform) transforms.get(corner)),
			        AffineTransformOp.TYPE_NEAREST_NEIGHBOR));
			transforms.put(corner, ((AffineTransformOp) transforms.get(corner))
			        .filter(scaledPicBI, null));

		}

		// scaledPic.show();
		Picture canvas = new Picture(TILE_WIDTH * 2, TILE_WIDTH * 2);
		Graphics graphics = canvas.getGraphics();
		for (Corner corner : Corner.values()) {
			BufferedImage bImage = (BufferedImage) transforms.get(corner);
			graphics.drawImage(bImage, corner.getX(TILE_WIDTH),
			        corner.getY(TILE_WIDTH), null);
		}
		canvas.show();
		Thread.sleep(10000);
		System.exit(0);
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");

	}
}
