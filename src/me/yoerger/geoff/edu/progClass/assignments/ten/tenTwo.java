package me.yoerger.geoff.edu.progClass.assignments.ten;

import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.bookClasses.MidiPlayer;
import me.yoerger.geoff.edu.progClass.mod7.Range;

/**
 * Assignment 10.2
 *
 */
public class tenTwo implements Analysis{

	public static void main(String[] args) {
		MidiPlayer player1 = new MidiPlayer();
	    player1.setInstrument(MidiPlayer.PIANO);
	    
	    int[] note = {60,60,67,67,69,69};
	    int[] duration = {250,250,250,250,250,250};     
	      
	    for(int i : new Range(-1, 5).range()) {
	    	player1.playNote(note[i], duration[i]);
	    }
	}

	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
		
		
	}

}
