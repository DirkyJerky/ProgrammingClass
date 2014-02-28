package me.yoerger.geoff.edu.progClass.mod7;

import java.math.BigInteger;

public class CoordPair {
	
	private final int x;
	private final int y;
	
	public CoordPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public final int getX() {
		return this.x;
	}
	
	public final int getY() {
		return this.y;
	}
	
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	@Override
	public int hashCode() {
		BigInteger x = new BigInteger(String.valueOf(this.x));
		BigInteger y = new BigInteger(String.valueOf(this.y));
		return x.xor(y).hashCode();
	}
}
