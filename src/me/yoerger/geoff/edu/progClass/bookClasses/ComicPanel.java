package me.yoerger.geoff.edu.progClass.bookClasses;

// import java.util.Iterator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import me.yoerger.geoff.edu.progClass.bookClasses.ImageFormatException;

/**
 * Class to create a comic panel. A comic panel will have a picture and can have
 * one or more text balloons. It uses a JLabel to show the picture.
 * 
 * @author Barb Ericson ericson@cc.gatech.edu Copyright 2005
 */
@SuppressWarnings("serial")
public class ComicPanel extends JPanel {
	// //////////// fields //////////////////

	/** the picture for the comic panel */
	private Picture picture = null;

	/** the list of text balloons */
	private final List<TextBalloon> textBalloonList = new ArrayList<TextBalloon>();
	// comment above and uncomment below for 1.4
	// private List textBalloonList =
	// new ArrayList();

	/** the label used to display the picture */
	private final JLabel pictureLabel = new JLabel();

	/** flag if line border for this panel */
	private final boolean lineBorder = true;

	// ////////////// constructors ////////////

	/**
	 * Constructor that takes just the picture to use
	 * 
	 * @param thePicture
	 *            the picture to use
	 */
	public ComicPanel(final Picture thePicture) {
		this.picture = thePicture;
		this.init();
	}

	// //////// methods //////////////////////////

	/**
	 * Method to initialize this panel
	 */
	private void init() {
		if (this.lineBorder) {
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			this.setBorder(border);
		}
		this.updateLabel();
		this.add(this.pictureLabel);
	}

	/**
	 * Method to update the label icon
	 */
	private void updateLabel() {
		Picture finalPicture = this.getFinalPicture();
		Icon icon = new ImageIcon(finalPicture.getImage());
		this.pictureLabel.setIcon(icon);
		this.repaint();
	}

	/**
	 * Method to add a text balloon to the panel
	 */
	public void add(final TextBalloon textBalloon) {
		this.textBalloonList.add(textBalloon);
		this.updateLabel();
	}

	/**
	 * Method to remove a text balloon from the panel
	 * 
	 * @param textBalloon
	 *            the text balloon to remove
	 */
	public void remove(final TextBalloon textBalloon) {
		this.textBalloonList.remove(textBalloon);
		this.updateLabel();
	}

	public Picture getFinalPicture() {
		Picture finalPicture = new Picture(this.picture);
		Graphics g = finalPicture.getGraphics();

		// loop through text balloons
		for (TextBalloon balloon : this.textBalloonList) {
			balloon.draw(g);
		}
		// comment out above and uncomment below for 1.4
		// Iterator listIterator = textBalloonList.iterator();
		// TextBalloon balloon = null;
		// while (listIterator.hasNext())
		// {
		// balloon = (TextBalloon) listIterator.next();
		// balloon.draw(g);
		// }
		return finalPicture;
	}

	/**
	 * Method to write out the comic panel
	 * 
	 * @param fileName
	 *            the full path name of the file to write. Be sure to include
	 *            .jpg or .bmp
	 */
	public void write(final String fileName) {
		Picture finalPicture = this.getFinalPicture();
		finalPicture.write(fileName);
	}

	public static void main(final String[] args) throws ImageFormatException {
		Picture p = new Picture(FileChooser.getMediaPath("MattJennyCorn.jpg"));
		ComicPanel panel = new ComicPanel(p);
		SpeechBalloon sBalloon = new SpeechBalloon(new Point(209, 18), 100,
				new Point(218, 149), "It sure is corny in here!");
		ThoughtBalloon tBalloon = new ThoughtBalloon(new Point(14, 60), 100,
				new Point(167, 226), "Oh, that was corny!");
		panel.add(sBalloon);
		panel.add(tBalloon);
		Picture finalPic = panel.getFinalPicture();
		finalPic.explore();
	}
}