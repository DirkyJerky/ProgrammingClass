package me.yoerger.geoff.edu.progClass.mod10;

import me.yoerger.geoff.edu.progClass.bookClasses.MidiPlayer;

/**
 * Represents the main notes played on a treble clef scale.
 * @author yoerggeo000
 *
 */
public enum Note {
	/**
	 * C4
	 */
	C(60),
	/**
	 * D4
	 */
	D(62),
	/**
	 * E4
	 */
	E(64),
	/**
	 * F4
	 */
	F(65),
	/**
	 * F#4
	 */
	Fs(66),
	/**
	 * G4
	 */
	G(67),
	/**
	 * A5
	 */
	A(69),
	/**
	 * B5
	 */
	B(71),
	/**
	 * C5
	 */
	Ch(72),
	/**
	 * D5
	 */
	Dh(74),
	/**
	 * E5
	 */
	Eh(76),
	/**
	 * F5
	 */
	Fh(77),
	/**
	 * G5
	 */
	Gh(79);
	
	private Note(int MIDInum) {
		this.num = MIDInum;
	}
	/**
	 * Midi note number for this note
	 * @see me.yoerger.geoff.edu.progClass.bookClasses.MidiPlayer#playNote(int, int)
	 */
	public final int num;
}
