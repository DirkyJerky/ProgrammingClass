package assignments.seven;

import java.util.Stack;

import bookClasses.Turtle;
import bookClasses.World;
import mod7.TurtleGraph;

public class sevenFour {
	public static void main(String[] args) {
		World world = new World();
		Turtle turtle = new Turtle(10, 10, world);
		TurtleGraph graph = new TurtleGraph(turtle);
		Stack<Integer> data = new Stack<>();
		data.push(2);
		data.push(5);
		data.push(2);
		data.push(1);
		graph.setXcoord(200);
		graph.setYcoord(500);
		graph.draw(data, 500, 50);
		turtle.hide();
		System.out.println("People who prefer: Mac \t Windows \t Linux \t Other");
	}

}
