package me.yoerger.geoff.edu.progClass.mod10;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import me.yoerger.geoff.edu.progClass.bookClasses.MidiPlayer;

/**
 * Represent a song
 * @author yoerggeo000
 *
 */
public class MusicScore {
	private List<Pair<NoteDur, Note>> notes;

	/**
	 * Make an empty instrumental song
	 */
	public MusicScore() {
		this.notes = new ArrayList<>();
	}
	
	/**
	 * @param note The note to add to this song
	 * @return If it was added succesfully
	 */
	public boolean add(Pair<NoteDur, Note> note) {
		return this.notes.add(note);
	}
	
	public boolean add(NoteDur note, Note notePitch) {
		return add(new Pair<NoteDur, Note>(note, notePitch));
	}
	
	/**
	 * @param notes A list of notes to add to the song
	 * @return If they were all added succesfully
	 */
	public boolean addAll(List<Pair<NoteDur, Note>> notes) {
		return this.notes.addAll(notes);
	}
	
	/**
	 * @return The notes in this song.
	 */
	public List<Pair<NoteDur, Note>> getNotes() {
		return notes;
	}
	
	
	
	/**
	 * Play our song
	 * @param player The player to play this song with
	 */
	public void play(MidiPlayer player) {
		for (Pair<NoteDur, Note> note : this.notes) {
			player.playNote(note.getValue1().num, note.getValue0().time);
		}
		
	}
}
