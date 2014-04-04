package me.yoerger.geoff.edu.progClass.mod7;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Used to get a random color of the rainbow
 * @author yoerggeo000
 * @since Module 7
 */
public class RandomColor {

	private final static ArrayList<Color> colors = new ArrayList<>();
	/**
	 * @return A random color of the rainbow
	 */
	public static Color make() {
		colors.clear();
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.YELLOW);
		colors.add(new Color(138, 43, 226)); // Purple
		colors.add(Color.ORANGE);
		System.out.println(colors.size());
		Collections.shuffle(colors);
		return colors.get(1);
	}
}
