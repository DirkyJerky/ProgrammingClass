package me.yoerger.geoff.edu.progClass.mod7;

import java.util.Vector;
import java.lang.Integer;

import com.google.common.base.Preconditions;

@SuppressWarnings({ })
public class Range {
	private Vector<Integer> range = new Vector<>();
	public Range(int x, int y) {
		Preconditions.checkArgument(x < y);
		for(int i = x + 1; i <= y; i++) {
			range.add(i);
		}
	}
	public Range(int x) {
		this(0, x);
	}
	
	public Vector<Integer> range() {
		return this.range;
	}
	
}
