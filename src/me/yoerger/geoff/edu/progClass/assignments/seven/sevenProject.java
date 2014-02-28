package me.yoerger.geoff.edu.progClass.assignments.seven;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.bookClasses.Turtle;
import me.yoerger.geoff.edu.progClass.bookClasses.World;
import me.yoerger.geoff.edu.progClass.mod7.CoordPair;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;
import me.yoerger.geoff.edu.progClass.mod7.Range;

public class sevenProject implements Analysis{
	final static int PADDING = 50;
	final static int SCALE = 40;
	final static int TIMEOUT = 1000; // Millis
	final static Random random = new Random(System.nanoTime());
	final static World world = new World();
	static Map<CoordPair, Turtle> turtles = new HashMap<>();

	public static void main(String[] args) {
		world.setBackground(Color.BLACK); // Should work, dont know why.
		for(int x : new Range(10).range()) {
			for(int y : new Range(10).range()) {
				Turtle thisTurtle = new Turtle(x * SCALE + PADDING, y * SCALE + PADDING, world);
				thisTurtle.setColor(Color.WHITE);
				thisTurtle.setPenDown(false);
				turtles.put(new CoordPair(x, y), thisTurtle);
				// Yay turtles
			}
		}
		Runnable runnable = new Runnable() {
			public void run() { 
				for(Turtle turtle : turtles.values()) {
					turtle.setBodyColor(randomColor());
					turtle.setShellColor(randomColor());
					turtle.turn((double) (random.nextInt(360)));
					turtle.forward(random.nextInt(5));
				}
			}
		};
		while(world.isShowing()) {
			runnable.run();
			try {
				Thread.sleep(TIMEOUT);
			} catch (Exception e) {
			//	e.printStackTrace(); Ignore
			}
		}
		System.exit(0);
	}
	public static Color randomColor() {
		return RandomColor.make();
	}
	

}
