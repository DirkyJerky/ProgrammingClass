package me.yoerger.geoff.edu.progClass.mod7;

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
		return this.x * 100 | (this.y & this.x + this.y);
	}
}
