package me.yoerger.geoff.edu.progClass.bookClasses;

// import java.awt.font.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
// import java.text.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

import sun.awt.image.ImageFormatException;

/**
 * SpeechBalloon: this is used to represent objects in comic strips which are
 * used to show what a character is saying. The tip of tail points to the
 * character who is talking
 * 
 * @author Barb Ericson
 */
public class SpeechBalloon extends TextBalloon {

	// /////////// constructors //////////////////

	/**
	 * Constructor that takes the upper left, width, tail end, and message to
	 * display
	 * 
	 * @param uLeft
	 *            the upper left corner of a rectangle enclosing the balloon
	 * @param theWidth
	 *            the width of the enclosing rectangle
	 * @param tEnd
	 *            the point which is the end of the tail that shows who is
	 *            speaking
	 * @param theMessage
	 *            the message to display
	 */
	public SpeechBalloon(final Point uLeft, final int theWidth,
			final Point tEnd, final String theMessage) {
		super(uLeft, theWidth, tEnd, theMessage);
	}

	// ////////// methods ////////////////

	/**
	 * method to draw the tail of the balloon
	 * 
	 * @param ellipseHeight
	 *            the height of the ellipse
	 * @param fillColor
	 *            the color to bill the balloon with
	 * @param outlineColor
	 *            the color to outline the balloon with
	 * @param g2
	 *            the 2d graphics context
	 */
	@Override
	protected void drawTail(final int ellipseHeight, final Color fillColor,
			final Color outlineColor, final Graphics2D g2) {
		Point tailEnd = this.getTailEnd();
		Point upperLeft = this.getUpperLeft();
		int margin = this.getMargin();
		int halfWidth = this.getWidth() / 2;
		int topY = upperLeft.y + ellipseHeight;
		int startX = (upperLeft.x + halfWidth) - margin;
		int endX = upperLeft.x + halfWidth + margin;
		GeneralPath triangle = new GeneralPath(Path2D.WIND_EVEN_ODD, 3);
		triangle.moveTo(startX, topY);
		triangle.lineTo(endX, topY);
		triangle.lineTo(tailEnd.x, tailEnd.y);
		triangle.lineTo(startX, topY);
		g2.setColor(fillColor);
		g2.fill(triangle);
		g2.setColor(outlineColor);
		g2.draw(new Line2D.Double(tailEnd.x, tailEnd.y, startX, topY));
		g2.draw(new Line2D.Double(tailEnd.x, tailEnd.y, endX, topY));
	}

	public static void main(final String[] args) throws ImageFormatException {
		Picture p = new Picture(FileChooser.getMediaPath("horse.jpg"));
		Graphics g = p.getGraphics();
		Point ul = new Point(68, 24);
		Point te = new Point(182, 123);
		String message = "This is a test."
				+ "  Of a message with more than one line in it.";
		SpeechBalloon balloon = new SpeechBalloon(ul, 200, te, message);
		balloon.draw(g);
		p.show();
	}

} // end of SpeechBalloon class

