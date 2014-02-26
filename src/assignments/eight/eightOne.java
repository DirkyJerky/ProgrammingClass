package assignments.eight;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import mod7.Range;
import assignments.Analysis;
import bookClasses.Turtle;
import bookClasses.World;

public class eightOne implements Analysis{

	final static int LEN = 100;
	final static int TIMEOUT = 1000;
	final static float SCALE = 0.85F;
	final static Color FRACTAL_COLOR = Color.red;
	final static int FRACTAL_WIDTH = 2;
	
	@SuppressWarnings("unused") // For the console clearer below.
	public static void main(String[] args) throws Exception {
		
		System.out.println("The other threads dont like all these turtles"
				+ " drawing over each other,\nJust ignore the oncomming spam");
		final World world = new World();
		final Turtle starter = new Turtle(300, 400, world);
		starter.setPenColor(FRACTAL_COLOR);
		starter.hide();
		starter.setPenWidth(FRACTAL_WIDTH);
		int phase = LEN;
		final Set<Turtle> turtles = new HashSet<>();
		turtles.add(starter);
		
		while(world.isShowing() && phase >= 10) {
			turtles.addAll(world.getTurtleList());
			for(Turtle t : turtles) {
				t.forward(phase);
				normalize(t);
				Turtle copy = copy(t, world);
				normalize(copy);
				copy.turnLeft();
				t.turnRight();
				
			}
			phase *= SCALE;
			Thread.sleep(TIMEOUT);
		}
		
		for( int i : new Range(10).range()) {
			System.out.print("\n");
		}
		
		System.out.println("Close the window to end the program");
		while(world.isShowing()) {} // Wait until the program is closed
		System.exit(0);
		
	}
	
	public static Turtle copy(Turtle t, World w) {

		Turtle copy = new Turtle(t.getXPos(), t.getYPos(), w);
		copy.turn(t.getHeading());
		return copy;
	}
	
	public static void normalize(Turtle t) {
		t.setPenColor(FRACTAL_COLOR);
		t.setPenWidth(FRACTAL_WIDTH);
		t.hide();
	}

}
