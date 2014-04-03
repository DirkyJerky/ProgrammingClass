package me.yoerger.geoff.edu.progClass.mod7;

/**
 * Used to make unique coord pairs with different hashcodes
 * @author yoerggeo000
 * @since Module 7
 */
public class CoordPair {
	
	private final int x;
	private final int y;
	
	/**
	 * @param x The x value of this coord pair
	 * @param y The y value of this coord pair
	 */
	public CoordPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return The x value of this coord pair
	 */
	public final int getX() {
		return this.x;
	}
	
	/**
	 * @return The y value of this coord pair
	 */
	public final int getY() {
		return this.y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.x * 100 | (this.y & this.x + this.y);
	}
}
