package assignments.seven;

import java.awt.Color;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import mod7.RandomColor;

import com.google.common.base.Preconditions;

import assignments.Analysis;
import bookClasses.Turtle;
import bookClasses.World;

public class sevenFive implements Analysis{
	public static void main(String[] args) throws Exception {
		
		final int BOX_SIZE = 200;
		final int ANIM_SCALE = 5;
		final int TIMEOUT = 10;
		
		final int BORDER_LINE_WIDTH = 3;
		final int ANIM_LINE_WIDTH = 10;
		
		final Color ANIM_COLOR = Color.RED;
		final Color OUTLINE_COLOR = Color.GREEN;
		
		final boolean REVERSABLE = true;
		
		// Checks
		Preconditions.checkArgument(TIMEOUT >= 5, "Timeout less than 5");
		// The thread handler will hate you if you go less than 5.
		// The poor turtles will to.
		
		// Feel free to play around with the constants
		
		final World world = new World();
		final Turtle turtle = new Turtle(100, 300, world);
		final Turtle animTurtle = new Turtle(100, 300, world);
		final Random r = new Random(System.currentTimeMillis());
		
		turtle.hide();
		animTurtle.hide(); // Hide both the turtles
		turtle.faceUp(); 
		animTurtle.faceUp(); // Align them up
		turtle.setPenColor(OUTLINE_COLOR);
		animTurtle.setPenColor(ANIM_COLOR);
		turtle.setPenWidth(BORDER_LINE_WIDTH);
		animTurtle.setPenWidth(ANIM_LINE_WIDTH);
		
		for (int i = 0; i < 4; i++) { // Draw the outline for the animation
			turtle.forward(BOX_SIZE);
			turtle.turnRight();
		}
		
		final Vector<Integer> vector = new Vector<>();
		for (int i = 0; i < BOX_SIZE; i += ANIM_SCALE) {
			vector.add(i);
		}
		System.out.println("Close the window to stop the animation.");
		Runnable anim = new Runnable() {
			public void run() {
				if(REVERSABLE && r.nextBoolean()) {
					Collections.reverse(vector); // Spice it up a little bit
				}
				animTurtle.setPenColor(RandomColor.make());
				for(int point : vector) {
					animTurtle.getPen().clearPath();
					animTurtle.setPenDown(false);
					animTurtle.goTo(100, 300 - point);
					animTurtle.setPenDown(true);
					animTurtle.goTo(100 + point, 100);
					animTurtle.goTo(300, 100 + point);
					animTurtle.goTo(300 - point, 300);
					animTurtle.goTo(100, 300 - point);
					try {
						Thread.sleep(TIMEOUT);
					} catch (InterruptedException e) {} //Ignore 
				}
			}
		};
		while(world.isShowing()) {
			anim.run();
		}
		System.exit(0);
	}

}
