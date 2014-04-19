package me.yoerger.geoff.edu.progClass.assignments.ten;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.MidiPlayer;
import me.yoerger.geoff.edu.progClass.mod10.MusicScore;
import me.yoerger.geoff.edu.progClass.mod10.Note;
import me.yoerger.geoff.edu.progClass.mod10.NoteDur;

/**
 * Assignment 10.2
 *
 */
public class tenTwo implements Analysis{

	public static void main(String[] args) {
	    
//	    int[] note = {60,60,67,67,69,69};
//	    int[] duration = {250,250,250,250,250,250};     
	      
	    MusicScore song = new MusicScore();
	    
	    song.add(NoteDur.EigthDotted, Note.G);
	    song.add(NoteDur.Sixteenth, Note.E);
	    
	    song.add(NoteDur.Quarter, Note.C);
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.G);
	    
	    song.add(NoteDur.Half, Note.Ch);
	    song.add(NoteDur.EigthDotted, Note.Eh);
	    song.add(NoteDur.Sixteenth, Note.Dh);
	    
	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.Fs);
	    
	    song.add(NoteDur.Half, Note.G);
	    song.add(NoteDur.Eigth, Note.G);
	    song.add(NoteDur.Eigth, Note.G);
	    
	    song.add(NoteDur.QuarterDotted, Note.Eh);
	    song.add(NoteDur.Sixteenth, Note.Dh);
	    song.add(NoteDur.Quarter, Note.Ch);
	    

	    song.add(NoteDur.Half, Note.B);
	    song.add(NoteDur.Eigth, Note.A);
	    song.add(NoteDur.Eigth, Note.B);

	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.G);
	    
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.C);
	    song.add(NoteDur.EigthDotted, Note.G);
	    song.add(NoteDur.Sixteenth, Note.E);
	    
	    song.add(NoteDur.Quarter, Note.C);
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.G);
	    
	    song.add(NoteDur.Half, Note.Ch);
	    song.add(NoteDur.EigthDotted, Note.Eh);
	    song.add(NoteDur.Sixteenth, Note.Dh);
	    
	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.Fs);
	    
	    song.add(NoteDur.Half, Note.G);
	    song.add(NoteDur.Eigth, Note.G);
	    song.add(NoteDur.Eigth, Note.G);
	    
	    song.add(NoteDur.QuarterDotted, Note.Eh);
	    song.add(NoteDur.Sixteenth, Note.Dh);
	    song.add(NoteDur.Quarter, Note.Ch);
	    
	    song.add(NoteDur.Half, Note.B);
	    song.add(NoteDur.Eigth, Note.A);
	    song.add(NoteDur.Eigth, Note.B);

	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.G);
	    
	    
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.C);
	    song.add(NoteDur.Eigth, Note.Eh);
	    song.add(NoteDur.Eigth, Note.Eh);

	    song.add(NoteDur.Quarter, Note.Eh);
	    song.add(NoteDur.Quarter, Note.Fh);
	    song.add(NoteDur.Quarter, Note.Gh);

	    song.add(NoteDur.Half, Note.Gh);
	    song.add(NoteDur.Eigth, Note.Fh);
	    song.add(NoteDur.Eigth, Note.Eh);
	    
	    song.add(NoteDur.Quarter, Note.Dh);
	    song.add(NoteDur.Quarter, Note.Eh);
	    song.add(NoteDur.Quarter, Note.Fh);

	    song.add(NoteDur.Half, Note.Fh);
	    song.add(NoteDur.Eigth, Note.Fh);
	    song.add(NoteDur.Eigth, Note.Fh);
	    
	    song.add(NoteDur.QuarterDotted, Note.Eh);
	    song.add(NoteDur.Sixteenth, Note.Dh);
	    song.add(NoteDur.Quarter, Note.Ch);
	    
	    song.add(NoteDur.Half, Note.B);
	    song.add(NoteDur.Eigth, Note.A);
	    song.add(NoteDur.Eigth, Note.B);

	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.E);
	    song.add(NoteDur.Quarter, Note.Fs);
	    
	    song.add(NoteDur.Half, Note.G);
	    song.add(NoteDur.Quarter, Note.G);
	    
	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Eigth, Note.Ch);
	    song.add(NoteDur.Eigth, Note.B);

	    song.add(NoteDur.Quarter, Note.A);
	    song.add(NoteDur.Quarter, Note.A);
	    song.add(NoteDur.Quarter, Note.A);
	    
	    
	    song.add(NoteDur.Quarter, Note.Dh);
	    song.add(NoteDur.Eigth, Note.Fh);
	    song.add(NoteDur.Eigth, Note.Eh);
	    song.add(NoteDur.Eigth, Note.Dh);
	    song.add(NoteDur.Eigth, Note.Ch);

	    song.add(NoteDur.Quarter, Note.Ch);
	    song.add(NoteDur.Quarter, Note.B);
	    song.add(NoteDur.Eigth, Note.G);
	    song.add(NoteDur.Eigth, Note.G);

	    song.add(NoteDur.QuarterDotted, Note.Ch);
	    song.add(NoteDur.Eigth, Note.Dh);
	    song.add(NoteDur.Eigth, Note.Eh);
	    song.add(NoteDur.Eigth, Note.Fh);
	    
	    song.add(NoteDur.Half, Note.G);
	    song.add(NoteDur.Eigth, Note.Ch);
	    song.add(NoteDur.Eigth, Note.Dh);

	    song.add(NoteDur.QuarterDotted, Note.Eh);
	    song.add(NoteDur.Eigth, Note.Fh);
	    song.add(NoteDur.Quarter, Note.Dh);
	    

	    song.add(NoteDur.HalfDotted, Note.Ch);
		
		MidiPlayer player = new MidiPlayer();
	    player.setInstrument(MidiPlayer.PIANO);
	    song.play(player);
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
		
		
	}

}
