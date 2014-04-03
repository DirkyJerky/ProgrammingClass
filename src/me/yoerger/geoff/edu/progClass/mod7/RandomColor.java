package me.yoerger.geoff.edu.progClass.mod7;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Used to get a random color of the rainbow
 * @author yoerggeo000
 * @since Module 7
 */
public class RandomColor {

	private final static Random random = new Random(System.nanoTime());
	private final static ArrayList<Color> colors = new ArrayList<>();
	{
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.BLUE);
		colors.add(Color.YELLOW);
		colors.add(new Color(138, 43, 226)); // Purple
		colors.add(Color.ORANGE);
	}
	/**
	 * @return A random color of the rainbow
	 */
	public static Color make() {
		return colors.get(random.nextInt(colors.size()));
	}
}
