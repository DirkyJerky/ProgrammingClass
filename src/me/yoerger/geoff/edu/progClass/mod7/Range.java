package me.yoerger.geoff.edu.progClass.mod7;

import java.util.Vector;
import java.lang.Integer;

import com.google.common.base.Preconditions;

/**
 * Used to make ranges of number like in Python!
 * @author yoerggeo000
 *
 */
public class Range {
	private Vector<Integer> range = new Vector<>();
	/**
	 * Make a range of numbers from x to y (Inc/Exc)
	 * @param x The lower bounds (exclusive)
	 * @param y The upper bounds (inclusive)
	 */
	public Range(int x, int y) {
		Preconditions.checkArgument(x < y);
		for(int i = x + 1; i <= y; i++) {
			range.add(i);
		}
	}
	/**
	 * Same as new Range(0, x)
	 * @param x The upper bounds of the range
	 */
	public Range(int x) {
		this(0, x);
	}
	
	/**
	 * @return The range of numbers
	 */
	public Vector<Integer> range() {
		return this.range;
	}
	
}
