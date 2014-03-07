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

public class Drawer {
	private Picture thisPicture;
	private Graphics2D graphics;
	
	public Drawer(Picture canvas) {
		this.thisPicture = canvas;
		this.graphics = (Graphics2D) this.thisPicture.getGraphics();
	}
	
	public void drawHollow(Shape shape) {
		this.draw(shape, false);
	}
	public void draw(Shape shape) {
		this.draw(shape, true);
	}
	public void draw(Shape shape, boolean hollow) {
		this.draw(shape, Color.BLACK, hollow);
	}
	public void draw(Shape shape, Color color, boolean hollow) {
		Color curr = this.graphics.getColor();
		this.setColor(color);
		this.graphics.draw(shape);
		if(!hollow) this.graphics.fill(shape);
		this.setColor(curr);
	}
	public void drawLine(Color color, int thickness, Point2D first, Point2D second) {
		Stroke oldStroke = this.graphics.getStroke();
		this.graphics.setStroke(new BasicStroke(thickness));
		this.draw(new Line2D.Float(first, second), color, false);
		this.graphics.setStroke(oldStroke);
	}
	public void set(Color color, float lineWidth) {
		this.setColor(color);
		this.setLineWidth(lineWidth);
	}
	public void setRandom() {
		this.set(RandomColor.make(), new Random().nextInt(15));
	}
	public float setLineWidth(float len) {
		BasicStroke oldStroke = (BasicStroke) this.graphics.getStroke();
		this.graphics.setStroke(new BasicStroke(len));
		return oldStroke.getLineWidth();
	}
	// START REQ
	public void setColor(Color color) {
		this.graphics.setColor(color);
	}
	public void drawString(String string, int xPos, int yPos) {
		this.graphics.setFont(new Font("Helvetica",Font.BOLD,16));
		this.graphics.drawString(string,xPos,yPos);
	}
	public void  drawRect(Rectangle2D rect) {
		this.draw(rect);
	} 
	public void  fillRect(Rectangle2D rect) {
		this.graphics.fill(rect);
	}
	public void  drawOval(int x, int y, int width, int height) {
		this.graphics.drawOval(x, y, width, height);
	} 
	public void  fillOval(int x, int y, int width, int height) {
		this.graphics.fillOval(x, y, width, height);
	} 
	public void  drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		this.graphics.drawArc(x, y, width, height, startAngle, arcAngle);
	} 
	public void  fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		this.graphics.fillArc(x, y, width, height, startAngle, arcAngle);
	} 
}
