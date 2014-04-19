package me.yoerger.geoff.edu.progClass.mod10;

/**
 * Enum to represent common durations of notes (4/4 time sig w/ 120 BPM)
 *
 */
public enum NoteDur {
	/**
	 * Represents a whole note (Two seconds)
	 */
	Whole(2000),
	/**
	 * Represents a half note (One second)
	 */
	Half(1000),
	/**
	 * Represents a dotted half note (One and a half second)
	 */
	HalfDotted(1000),
	/**
	 * Represents a quarter note (Half a second)
	 */
	Quarter(500),
	/**
	 * Represents a dotted quarter note (Three fourths a second)
	 */
	QuarterDotted(750),
	/**
	 * Represents an eigth note (Quarter of a second)
	 */
	Eigth(250),
	/**
	 * Represents a dotted eigth note (Three eigths of a second)
	 */
	EigthDotted(375),
	
	/**
	 * Repreasents a sixteenth note (Eigth of a second)
	 */
	Sixteenth(125);
	
	private NoteDur(int defaultTime) {
		this.time = defaultTime;
	}
	/**
	 * The normal time this note would play for on a 4/4 scale @ 120 BPM
	 */
	public final int time;
}
