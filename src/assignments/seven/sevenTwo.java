package assignments.seven;

import java.awt.Color;

import bookClasses.Turtle;
import bookClasses.World;

public class sevenTwo {

	public static void main(String[] args) {
		final Color LIME = new Color(Integer.decode("#7CFC00"));
		final Color GREEN = new Color(Integer.decode("#458B00"));
		World w = new World();
		Turtle t = new Turtle(150, 400, w);
		t.setPenDown(false);
		t.setPenWidth(10);
		drawBox(t, 50, 50, LIME); // Begin hands, feet, and head
		go(t, 350, 400, true);
		drawBox(t, 50, 50, LIME);
		go(t, 100, 200, true);
		drawBox(t, 50, 50, LIME);
		go(t, 400, 200, true);
		drawBox(t, 50, 50, LIME);
		go(t, 250, 100, true);
		drawBox(t, 50, 50, LIME); // END
		t.setPenDown(true);
		t.setPenColor(GREEN);
		go(t, 150, 200, false); // Begin drawing outline of body
		go(t, 200, 350, false);
		go(t, 350, 350, false);
		go(t, 400, 200, false);
		go(t, 300, 100, false);
		go(t, 250, 100, false); // END
		go(t, 275, 250, true); // Align with center of drawing
		turnUp(t); // Turn to face up
	}
	static void drawBox(Turtle t, int height, int width, Color color) {
		t.setPenDown(true);
		t.setPenColor(color);
		turnUp(t);
		t.forward(height);
		t.turnRight();
		t.forward(width);
		t.turnRight();
		t.forward(height);
		t.turnRight();
		t.forward(width);
		
	}
	static void go(Turtle t, int x, int y, boolean silent) {
		if(silent) {
			t.setPenDown(false);
		}
		t.turnToFace(x, y);
		t.forward((int) t.getDistance(x, y));
		if(silent) {
			t.setPenDown(true);
		}
	}
	
	static void turnUp(Turtle t) {
		t.turnToFace(t.getXPos(), t.getYPos() - 1);
	}

}
