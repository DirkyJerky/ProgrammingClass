package assignments.seven;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import assignments.Analysis;
import bookClasses.Turtle;
import bookClasses.World;

public class sevenThree implements Analysis{

	public static void main(String[] args) {
		List<Color> colorList = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			colorList.add(Color.BLACK);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.RED);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.GREEN);
		}
		for (int i = 0; i < 5; i++) {
			colorList.add(Color.ORANGE);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.BLUE);
		}
		for (int i = 0; i < 5; i++) { // Ew bright colors
			colorList.add(Color.YELLOW);
		}
		for (int i = 0; i < 10; i++) {
			colorList.add(Color.CYAN);
		}
		Collections.shuffle(colorList);
		World world = new World();
		Turtle turtle = new Turtle(10, 10, world);
		
		loop:
		for(int i = 0; i < 10; i++) { // Draw the boxes
			go(turtle, r.nextInt(390), r.nextInt(390), true); 
			if (colorList.get(i) == Color.BLACK) { // Dont want icky black squares now do we
				continue loop;
			}
			turtle.setPenWidth(r.nextInt(75) + 25);
			turtle.setPenColor(colorList.get(i));
			turnFromUp(turtle, r.nextInt(4) * 90);
			turtle.forward(r.nextInt(150));
			
		}
		
		turtle.setPenWidth(10);
		for (Color color : colorList) { // Draw the lines
			turtle.setPenColor(color);
			turtle.setPenWidth(r.nextInt(5));
			drawLineFromOrigin(turtle, r.nextInt(390) + 10 , r.nextBoolean());
		}
		turtle.setColor(Color.WHITE); // Hide the turtle into the background
		turtle.setShellColor(Color.WHITE);
		
		
	}
	static void drawLineFromOrigin(Turtle t, int coord, boolean isX) {
		int awaydeg;
		if(isX) {
			go(t, coord, 10, true);
			awaydeg = 180;
		} else {
			go(t, 10, coord, true);
			awaydeg = 90;
		}
		turnFromUp(t, awaydeg);
		t.forward(10000); // Draw that line from origin to edge
	}
	static void go(Turtle t, int x, int y, boolean silent) {
		boolean down = t.getPen().isPenDown();
		if(silent) {
			t.setPenDown(false);
		}
		t.turnToFace(x, y);
		t.forward((int) t.getDistance(x, y));
		if(silent) {
			t.setPenDown(down);
		}
	}
	static void turnFromUp(Turtle t, int deg) {
		t.turnToFace(t.getXPos(), t.getYPos() - 1);
		t.turn(deg);
	}

}
