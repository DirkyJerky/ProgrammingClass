package me.yoerger.geoff.edu.progClass.mod9;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import me.yoerger.geoff.edu.progClass.bookClasses.Picture;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;

/**
 * A simple class for doing drawing functions with one method
 * @author yoerggeo000
 * @since Assignment 9.3
 */
public class Drawer {
	private Picture thisPicture;
	private Graphics2D graphics;
	
	/**
	 * @param canvas The canvas used to draw on
	 */
	public Drawer(Picture canvas) {
		this.thisPicture = canvas;
		this.graphics = (Graphics2D) this.thisPicture.getGraphics();
	}
	
	/**
	 * @param shape The shape to draw hollow on
	 */
	public void drawHollow(Shape shape) {
		this.draw(shape, false);
	}
	/**
	 * @param shape The shape to draw the fill in
	 */
	public void draw(Shape shape) {
		this.draw(shape, true);
	}
	/**
	 * @param shape The shape to draw
	 * @param hollow If it should be drawn hollow
	 */
	public void draw(Shape shape, boolean hollow) {
		this.draw(shape, Color.BLACK, hollow);
	}
	/**
	 * @param shape The shape to draw
	 * @param color The color to draw it with
	 * @param hollow If it should be drawn hollow
	 */
	public void draw(Shape shape, Color color, boolean hollow) {
		Color curr = this.graphics.getColor();
		this.setColor(color);
		this.graphics.draw(shape);
		if(!hollow) this.graphics.fill(shape);
		this.setColor(curr);
	}
	/**
	 * @param color The color to draw the line with
	 * @param thickness The line thickness
	 * @param first The first point of the line
	 * @param second The second point of the line
	 */
	public void drawLine(Color color, int thickness, Point2D first, Point2D second) {
		Stroke oldStroke = this.graphics.getStroke();
		this.graphics.setStroke(new BasicStroke(thickness));
		this.draw(new Line2D.Float(first, second), color, false);
		this.graphics.setStroke(oldStroke);
	}
	/**
	 * @param color The color to set the graphics to
	 * @param lineWidth The thickness to set the graphics to
	 */
	public void set(Color color, float lineWidth) {
		this.setColor(color);
		this.setLineWidth(lineWidth);
	}
	/**
	 * Randomize the color and linewidth
	 */
	public void setRandom() {
		this.set(RandomColor.make(), new Random().nextInt(15));
	}
	/**
	 * @param len The line width to set this drawer to
	 * @return The old line width
	 */
	public float setLineWidth(float len) {
		BasicStroke oldStroke = (BasicStroke) this.graphics.getStroke();
		this.graphics.setStroke(new BasicStroke(len));
		return oldStroke.getLineWidth();
	}
	// START REQ
	/**
	 * @param color The color to set
	 */
	public void setColor(Color color) {
		this.graphics.setColor(color);
	}
	/**
	 * @param string The string to draw on the canvas
	 * @param xPos The x Location
	 * @param yPos The y location
	 */
	public void drawString(String string, int xPos, int yPos) {
		this.graphics.setFont(new Font("Helvetica",Font.BOLD,16));
		this.graphics.drawString(string,xPos,yPos);
	}
	/**
	 * @param rect The rectangle to draw
	 */
	public void  drawRect(Rectangle2D rect) {
		this.draw(rect, true);
	} 
	/**
	 * @param rect The rectangle to fill
	 */
	public void  fillRect(Rectangle2D rect) {
		this.graphics.fill(rect);
	}
	/**
	 * @param x X Location of the oval
	 * @param y Y Location of the oval
	 * @param width Width of the bounding box
	 * @param height Height of the bounding box
	 */
	public void  drawOval(int x, int y, int width, int height) {
		this.graphics.drawOval(x, y, width, height);
	} 
	/**
	 * @param x X Location of the oval
	 * @param y Y Location of the oval
	 * @param width Width of the bounding box
	 * @param height Height of the bounding box
	 */
	public void  fillOval(int x, int y, int width, int height) {
		this.graphics.fillOval(x, y, width, height);
	} 
	/**
	 * @param x X Location of the arc
	 * @param y Y Location of the arc
	 * @param width Width of the bounding box
	 * @param height Height of the bounding box
	 * @param startAngle Starting angle of the bounding box
	 * @param arcAngle Finishing Angle
	 */
	public void  drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		this.graphics.drawArc(x, y, width, height, startAngle, arcAngle);
	} 
	/**
	 * @param x X Location of the arc
	 * @param y Y Location of the arc
	 * @param width Width of the bounding box
	 * @param height Height of the bounding box
	 * @param startAngle Starting angle of the bounding box
	 * @param arcAngle Finishing Angle
	 */
	public void  fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		this.graphics.fillArc(x, y, width, height, startAngle, arcAngle);
	} 
}
