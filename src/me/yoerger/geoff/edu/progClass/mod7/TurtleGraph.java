package me.yoerger.geoff.edu.progClass.mod7;

import java.awt.Color;
import java.util.Stack;

import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;

public class TurtleGraph {
	private Turtle turtle;
	private int Xcoord;
	private int Ycoord;
	public final int PADDING = 25;
	public final int DATA_WIDTH = 50;
	public final int BORDER_WIDTH = 5;
	public final int DATA_LINE_WIDTH = 10;
	public final Color BORDER_COLOR = Color.BLACK;
	public final Color DATA_COLOR = Color.RED;
	public final int LABEL_PADDING = 15;
	
	public TurtleGraph(Turtle turtle) {
		this.turtle = turtle;
	}

	public int getYcoord() {
		return Ycoord;
	}

	public void setYcoord(int ycoord) {
		this.Ycoord = ycoord;
	}

	public int getXcoord() {
		return Xcoord;
	}
	
	public void setXcoord(int xcoord) {
		this.Xcoord = xcoord;
	}
	
	public void draw(Stack<Integer> data, int height, int scale) {
		this.turtle.setPenDown(false);
		int width = (DATA_WIDTH * data.size()) + (PADDING * (data.size() + 1));
		this.turtle.turnToFace(this.Xcoord, this.Ycoord);
		this.turtle.forward((int) this.turtle.getDistance(this.Xcoord, this.Ycoord));
		this.turtle.turnToFace(turtle.getXPos(), turtle.getYPos() - 1); // Face it up
		this.turtle.setPenDown(true);
		this.turtle.setPenColor(BORDER_COLOR);
		this.turtle.setPenWidth(BORDER_WIDTH);
		
		this.turtle.forward(height); // BEGIN graph border
		this.turtle.turnRight();
		this.turtle.forward(width);
		this.turtle.turnRight();
		this.turtle.forward(height);
		this.turtle.turnRight();
		this.turtle.forward(width);
		this.turtle.turnRight(); // END border
		
		this.turtle.turnRight();
		this.turtle.setPenColor(DATA_COLOR);
		this.turtle.setPenColor(DATA_COLOR);
		
		for(int theData : data) {
			this.turtle.setPenDown(false);
			this.turtle.forward(PADDING);
			this.turtle.turnLeft();
			this.turtle.setPenDown(true);
			this.turtle.forward(scale * theData);
			this.turtle.turnRight();
			this.turtle.forward(DATA_WIDTH);
			this.turtle.turnRight();
			this.turtle.forward(scale * theData);
			this.turtle.turnLeft();
		}
	}

}
