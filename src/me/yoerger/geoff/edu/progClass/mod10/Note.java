package me.yoerger.geoff.edu.progClass.mod10;

public enum Note {
	C(60),
	D(62),
	E(64),
	F(65),
	Fs(66),
	G(67),
	A(69),
	B(71),
	Ch(72),
	Dh(74),
	Eh(76),
	Fh(77),
	Gh(79);
	
	private Note(int MIDInum) {
		this.num = MIDInum;
	}
	public final int num;
}
