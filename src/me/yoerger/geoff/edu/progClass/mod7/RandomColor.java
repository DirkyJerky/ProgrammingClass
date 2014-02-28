package me.yoerger.geoff.edu.progClass.mod7;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class RandomColor {

	final static Random random = new Random(System.nanoTime());
	final static ArrayList<Color> colors = new ArrayList<>();
	public static Color make() {
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.YELLOW);
		colors.add(new Color(138, 43, 226)); // Purple
		colors.add(Color.ORANGE);
		return colors.get(random.nextInt(colors.size()));
	}
}
