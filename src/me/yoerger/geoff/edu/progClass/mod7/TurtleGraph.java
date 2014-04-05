package me.yoerger.geoff.edu.progClass.mod7;

import java.awt.Color;
import java.util.Stack;

import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;

/**
 * Used to represent and display a bar graph made with turtle graphics
 * 
 * @author yoerggeo000
 * @since Module 7
 */
public class TurtleGraph {
	private Turtle turtle;
	private int Xcoord;
	private int Ycoord;
	/**
	 * The length in pixels between each dataset in the bar graph
	 */
	public final int PADDING = 25;
	/**
	 * The width in pixels that the data bars are wide
	 */
	public final int DATA_WIDTH = 50;
	/**
	 * The line with of the border of the graph
	 */
	public final int BORDER_WIDTH = 5;
	/**
	 * The line with of the data bars
	 */
	public final int DATA_LINE_WIDTH = 10;
	/**
	 * The color the border line is drawn with
	 */
	public final Color BORDER_COLOR = Color.BLACK;
	/**
	 * The color the data bars are drawn with
	 */
	public final Color DATA_COLOR = Color.RED;

	/**
	 * @param turtle
	 *            The turtle used to graph
	 */
	public TurtleGraph(Turtle turtle) {
		this.turtle = turtle;
	}

	/**
	 * @return The Y coord that the graph is going to be placed at
	 * @see #setYcoord(int)
	 */
	public int getYcoord() {
		return this.Ycoord;
	}

	/**
	 * @param ycoord
	 *            The Y coord that the graph is going to be placed at
	 */
	public void setYcoord(int ycoord) {
		this.Ycoord = ycoord;
	}

	/**
	 * @return The X coord that the graph is going to be placed at
	 * @see #setXcoord(int)
	 */

	public int getXcoord() {
		return this.Xcoord;
	}

	/**
	 * @param xcoord
	 *            The X coord that the graph is going to be placed at
	 */
	public void setXcoord(int xcoord) {
		this.Xcoord = xcoord;
	}

	/**
	 * @param data
	 *            The list of data to be plotted
	 * @param height
	 *            The height of the graph
	 * @param scale
	 *            How much pixels one unit of data is in height
	 */
	public void draw(Stack<Integer> data, int height, int scale) {
		this.turtle.setPenDown(false);
		int width = (this.DATA_WIDTH * data.size())
		        + (this.PADDING * (data.size() + 1));
		this.turtle.turnToFace(this.Xcoord, this.Ycoord);
		this.turtle.forward((int) this.turtle.getDistance(this.Xcoord,
		        this.Ycoord));
		this.turtle
		        .turnToFace(this.turtle.getXPos(), this.turtle.getYPos() - 1); // Face
																			   // it
																			   // up
		this.turtle.setPenDown(true);
		this.turtle.setPenColor(this.BORDER_COLOR);
		this.turtle.setPenWidth(this.BORDER_WIDTH);

		this.turtle.forward(height); // BEGIN graph border
		this.turtle.turnRight();
		this.turtle.forward(width);
		this.turtle.turnRight();
		this.turtle.forward(height);
		this.turtle.turnRight();
		this.turtle.forward(width);
		this.turtle.turnRight(); // END border

		this.turtle.turnRight();
		this.turtle.setPenColor(this.DATA_COLOR);
		this.turtle.setPenColor(this.DATA_COLOR);

		for (int theData : data) {
			this.turtle.setPenDown(false);
			this.turtle.forward(this.PADDING);
			this.turtle.turnLeft();
			this.turtle.setPenDown(true);
			this.turtle.forward(scale * theData);
			this.turtle.turnRight();
			this.turtle.forward(this.DATA_WIDTH);
			this.turtle.turnRight();
			this.turtle.forward(scale * theData);
			this.turtle.turnLeft();
		}
	}

}
