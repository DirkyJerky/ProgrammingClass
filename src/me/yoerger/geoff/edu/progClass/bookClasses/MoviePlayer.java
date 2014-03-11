package me.yoerger.geoff.edu.progClass.bookClasses;

import java.awt.BorderLayout;
// import java.awt.Image;
// import java.awt.event.*;
import java.awt.Container;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.awt.image.ImageFormatException;

/**
 * Class that can play movies from multiple frames Copyright Georgia Institute
 * of Technology 2007
 * 
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class MoviePlayer {

	// /////////////// fields ///////////////////////////

	private final JFrame frame = new JFrame("Movie Player");
	private final JLabel frameLabel = new JLabel("No images yet!");
	private AnimationPanel animationPanel = null;
	private String dir = null;

	// ////////////////// constructors ////////////////////

	/**
	 * Constructor that takes a list of pictures
	 * 
	 * @param pictureList
	 *            the list of pictures to show
	 */
	public MoviePlayer(final List<Picture> pictureList) {
		this.animationPanel = new AnimationPanel(pictureList);
		Picture p = pictureList.get(0);
		String fileName = p.getFileName();
		File f = new File(fileName);
		this.dir = f.getParent() + "/";
		this.init();
	}

	/**
	 * Constructor that takes a directory and shows a movie from it
	 * 
	 * @param directory
	 *            the directory with the frames
	 */
	public MoviePlayer(final String directory) {
		this.animationPanel = new AnimationPanel(directory);
		this.dir = directory;
		this.init();
	}

	/**
	 * Constructor to create a movie player by asking the user to pick the
	 * directory that contains the JPEG frames
	 */
	public MoviePlayer() {
		SimpleOutput.showInformation("Please pick a "
				+ "directory that contains the JPEG frames");
		String directory = FileChooser.pickADirectory();
		this.dir = directory;
		this.animationPanel = new AnimationPanel(directory);
		this.init();
	}

	// ///////////////////// methods ////////////////////////////

	/**
	 * Method to show the next image
	 */
	public void showNext() {
		this.animationPanel.showNext();
		this.frameLabel.setText("Frame Number "
				+ this.animationPanel.getCurrIndex());
		this.frame.repaint();
	}

	/**
	 * Method to show the previous image
	 */
	public void showPrevious() {
		this.animationPanel.showPrev();
		this.frameLabel.setText("Frame Number "
				+ this.animationPanel.getCurrIndex());
		this.frame.repaint();
	}

	/**
	 * Method to play the movie from the beginning
	 */
	public void playMovie() {
		this.frameLabel.setText("Playing Movie");
		this.frame.repaint();
		this.animationPanel.showAll();
		this.frameLabel.setText("Frame Number "
				+ this.animationPanel.getCurrIndex());
		this.frame.repaint();
	}

	/**
	 * Method to play the movie from the beginning
	 * 
	 * @param framesPerSecond
	 *            the number of frames to show per second
	 */
	public void playMovie(final int framesPerSecond) {
		this.animationPanel.setFramesPerSec(framesPerSecond);
		this.playMovie();
	}

	public void setFrameRate(final int rate) {
		this.animationPanel.setFramesPerSec(rate);
	}

	/**
	 * Method to delete all the frames before the current one
	 */
	public void delAllBefore() {
		this.animationPanel.removeAllBefore();
	}

	/**
	 * Method to delete all the frames after the current one
	 */
	public void delAllAfter() {
		this.animationPanel.removeAllAfter();
	}

	/**
	 * Method to write out the movie frames as a Quicktime movie
	 * 
	 * @throws ImageFormatException
	 */
	public void writeQuicktime() {

		MovieWriter writer = new MovieWriter(
				this.animationPanel.getFramesPerSec(), this.dir);
		writer.writeQuicktime();
	}

	/**
	 * Method to write out the movie frames as a Quicktime movie
	 * 
	 * @throws ImageFormatException
	 */
	public void writeAVI() {
		MovieWriter writer = new MovieWriter(
				this.animationPanel.getFramesPerSec(), this.dir);
		writer.writeAVI();
	}

	/**
	 * Method to add a picture to the movie
	 * 
	 * @param picture
	 *            the picture to add
	 */
	public void addPicture(final Picture picture) {
		this.animationPanel.add(picture);
		this.showNext();
	}

	/**
	 * Method to set up the gui
	 */
	@SuppressWarnings("unused")
	private void init() {
		this.frame.setAlwaysOnTop(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = this.frame.getContentPane();
		container.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();

		// add the animation panel
		container.add(this.animationPanel, BorderLayout.CENTER);

		// add the frame label to the north
		JPanel labelPanel = new JPanel();
		labelPanel.add(this.frameLabel);
		container.add(labelPanel, BorderLayout.NORTH);

		// add the button panel to the south
		container.add(new ButtonPanel(this), BorderLayout.SOUTH);

		// set the size of the frame
		this.frame.pack();

		// show the frame
		this.frame.setVisible(true);
	}

	/**
	 * Method to set the visibility of the frame
	 * 
	 * @param flag
	 *            the visibility of the frame
	 */
	public void setVisible(final boolean flag) {
		this.frame.setVisible(flag);
	}

	public static void main(final String[] args) {
		MoviePlayer moviePlayer = new MoviePlayer();
		// new MoviePlayer("c:/temp/movie4/");
		moviePlayer.playMovie(16);
	}

}
