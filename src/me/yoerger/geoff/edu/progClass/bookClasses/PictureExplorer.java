package me.yoerger.geoff.edu.progClass.bookClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import sun.awt.image.ImageFormatException;

/**
 * Displays a picture and lets you explore the picture by displaying the x, y,
 * red, green, and blue values of the pixel at the cursor when you click a mouse
 * button or press and hold a mouse button while moving the cursor. It also lets
 * you zoom in or out. You can also type in a x and y value to see the color at
 * that location.
 * 
 * Originally created for the Jython Environment for Students (JES). Modified to
 * work with DrJava by Barbara Ericson
 * 
 * Copyright Georgia Institute of Technology 2004
 * 
 * @author Keith McDermottt, gte047w@cc.gatech.edu
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class PictureExplorer implements MouseMotionListener, ActionListener,
		MouseListener {

	// current x and y index
	private int xIndex = 0;
	private int yIndex = 0;

	// Main gui variables
	private JFrame pictureFrame;
	private JScrollPane scrollPane;

	// information bar variables
	private JLabel xLabel;
	private JButton xPrevButton;
	private JButton yPrevButton;
	private JButton xNextButton;
	private JButton yNextButton;
	private JLabel yLabel;
	private JTextField xValue;
	private JTextField yValue;
	private JLabel rValue;
	private JLabel gValue;
	private JLabel bValue;
	private JLabel colorLabel;
	private JPanel colorPanel;

	// menu components
	private JMenuBar menuBar;
	private JMenu zoomMenu;
	private JMenuItem twentyFive;
	private JMenuItem fifty;
	private JMenuItem seventyFive;
	private JMenuItem hundred;
	private JMenuItem hundredFifty;
	private JMenuItem twoHundred;
	private JMenuItem fiveHundred;

	/** The picture being explored */
	private final DigitalPicture picture;

	/** The image icon used to display the picture */
	@SuppressWarnings("unused")
	private ImageIcon scrollImageIcon;

	/** The image display */
	private ImageDisplay imageDisplay;

	/** the zoom factor (amount to zoom) */
	private double zoomFactor;

	/** the number system to use, 0 means starting at 0, 1 means starting at 1 */
	private int numberBase = 0;

	/**
	 * Public constructor
	 * 
	 * @param picture
	 *            the picture to explore
	 */
	public PictureExplorer(final DigitalPicture picture) {
		// set the fields
		this.picture = picture;
		this.zoomFactor = 1;

		// create the window and set things up
		this.createWindow();
	}

	/**
	 * Changes the number system to start at one
	 */
	public void changeToBaseOne() {
		this.numberBase = 1;
	}

	/**
	 * Set the title of the frame
	 * 
	 * @param title
	 *            the title to use in the JFrame
	 */
	public void setTitle(final String title) {
		this.pictureFrame.setTitle(title);
	}

	/**
	 * Method to create and initialize the picture frame
	 */
	private void createAndInitPictureFrame() {
		this.pictureFrame = new JFrame(); // create the JFrame
		this.pictureFrame.setResizable(true); // allow the user to resize it
		this.pictureFrame.getContentPane().setLayout(new BorderLayout()); // use
																			// border
																			// layout
		this.pictureFrame
				.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // when
																				// close
																				// stop
		this.pictureFrame.setTitle(this.picture.getTitle());
		PictureExplorerFocusTraversalPolicy newPolicy = new PictureExplorerFocusTraversalPolicy();
		this.pictureFrame.setFocusTraversalPolicy(newPolicy);

	}

	/**
	 * Method to create the menu bar, menus, and menu items
	 */
	private void setUpMenuBar() {
		// create menu
		this.menuBar = new JMenuBar();
		this.zoomMenu = new JMenu("Zoom");
		this.twentyFive = new JMenuItem("25%");
		this.fifty = new JMenuItem("50%");
		this.seventyFive = new JMenuItem("75%");
		this.hundred = new JMenuItem("100%");
		this.hundred.setEnabled(false);
		this.hundredFifty = new JMenuItem("150%");
		this.twoHundred = new JMenuItem("200%");
		this.fiveHundred = new JMenuItem("500%");

		// add the action listeners
		this.twentyFive.addActionListener(this);
		this.fifty.addActionListener(this);
		this.seventyFive.addActionListener(this);
		this.hundred.addActionListener(this);
		this.hundredFifty.addActionListener(this);
		this.twoHundred.addActionListener(this);
		this.fiveHundred.addActionListener(this);

		// add the menu items to the menus
		this.zoomMenu.add(this.twentyFive);
		this.zoomMenu.add(this.fifty);
		this.zoomMenu.add(this.seventyFive);
		this.zoomMenu.add(this.hundred);
		this.zoomMenu.add(this.hundredFifty);
		this.zoomMenu.add(this.twoHundred);
		this.zoomMenu.add(this.fiveHundred);
		this.menuBar.add(this.zoomMenu);

		// set the menu bar to this menu
		this.pictureFrame.setJMenuBar(this.menuBar);
	}

	/**
	 * Create and initialize the scrolling image
	 */
	private void createAndInitScrollingImage() {
		this.scrollPane = new JScrollPane();

		BufferedImage bimg = this.picture.getBufferedImage();
		this.imageDisplay = new ImageDisplay(bimg);
		this.imageDisplay.addMouseMotionListener(this);
		this.imageDisplay.addMouseListener(this);
		this.imageDisplay
				.setToolTipText("Click a mouse button on a pixel to see the pixel information");
		this.scrollPane.setViewportView(this.imageDisplay);
		this.pictureFrame.getContentPane().add(this.scrollPane,
				BorderLayout.CENTER);
	}

	/**
	 * Creates the JFrame and sets everything up
	 */
	private void createWindow() {
		// create the picture frame and initialize it
		this.createAndInitPictureFrame();

		// set up the menu bar
		this.setUpMenuBar();

		// create the information panel
		this.createInfoPanel();

		// creates the scrollpane for the picture
		this.createAndInitScrollingImage();

		// show the picture in the frame at the size it needs to be
		this.pictureFrame.pack();
		this.pictureFrame.setVisible(true);
	}

	/**
	 * Method to set up the next and previous buttons for the pixel location
	 * information
	 */
	private void setUpNextAndPreviousButtons() {
		// create the image icons for the buttons
		Icon prevIcon = new ImageIcon(
				SoundExplorer.class.getResource("leftArrow.gif"),
				"previous index");
		Icon nextIcon = new ImageIcon(
				SoundExplorer.class.getResource("rightArrow.gif"), "next index");
		// create the arrow buttons
		this.xPrevButton = new JButton(prevIcon);
		this.xNextButton = new JButton(nextIcon);
		this.yPrevButton = new JButton(prevIcon);
		this.yNextButton = new JButton(nextIcon);

		// set the tool tip text
		this.xNextButton.setToolTipText("Click to go to the next x value");
		this.xPrevButton.setToolTipText("Click to go to the previous x value");
		this.yNextButton.setToolTipText("Click to go to the next y value");
		this.yPrevButton.setToolTipText("Click to go to the previous y value");

		// set the sizes of the buttons
		int prevWidth = prevIcon.getIconWidth() + 2;
		int nextWidth = nextIcon.getIconWidth() + 2;
		int prevHeight = prevIcon.getIconHeight() + 2;
		int nextHeight = nextIcon.getIconHeight() + 2;
		Dimension prevDimension = new Dimension(prevWidth, prevHeight);
		Dimension nextDimension = new Dimension(nextWidth, nextHeight);
		this.xPrevButton.setPreferredSize(prevDimension);
		this.yPrevButton.setPreferredSize(prevDimension);
		this.xNextButton.setPreferredSize(nextDimension);
		this.yNextButton.setPreferredSize(nextDimension);

		// handle previous x button press
		this.xPrevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				PictureExplorer.this.xIndex--;
				if (PictureExplorer.this.xIndex < 0) {
					PictureExplorer.this.xIndex = 0;
				}
				PictureExplorer.this.displayPixelInformation(
						PictureExplorer.this.xIndex,
						PictureExplorer.this.yIndex);
			}
		});

		// handle previous y button press
		this.yPrevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				PictureExplorer.this.yIndex--;
				if (PictureExplorer.this.yIndex < 0) {
					PictureExplorer.this.yIndex = 0;
				}
				PictureExplorer.this.displayPixelInformation(
						PictureExplorer.this.xIndex,
						PictureExplorer.this.yIndex);
			}
		});

		// handle next x button press
		this.xNextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				PictureExplorer.this.xIndex++;
				if (PictureExplorer.this.xIndex >= PictureExplorer.this.picture
						.getWidth()) {
					PictureExplorer.this.xIndex = PictureExplorer.this.picture
							.getWidth() - 1;
				}
				PictureExplorer.this.displayPixelInformation(
						PictureExplorer.this.xIndex,
						PictureExplorer.this.yIndex);
			}
		});

		// handle next y button press
		this.yNextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				PictureExplorer.this.yIndex++;
				if (PictureExplorer.this.yIndex >= PictureExplorer.this.picture
						.getHeight()) {
					PictureExplorer.this.yIndex = PictureExplorer.this.picture
							.getHeight() - 1;
				}
				PictureExplorer.this.displayPixelInformation(
						PictureExplorer.this.xIndex,
						PictureExplorer.this.yIndex);
			}
		});
	}

	/**
	 * Create the pixel location panel
	 * 
	 * @param labelFont
	 *            the font for the labels
	 * @return the location panel
	 */
	public JPanel createLocationPanel(final Font labelFont) {

		// create a location panel
		JPanel locationPanel = new JPanel();
		locationPanel.setLayout(new FlowLayout());
		Box hBox = Box.createHorizontalBox();

		// create the labels
		this.xLabel = new JLabel("X:");
		this.yLabel = new JLabel("Y:");

		// create the text fields
		this.xValue = new JTextField(Integer.toString(this.xIndex
				+ this.numberBase), 6);
		this.xValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PictureExplorer.this.displayPixelInformation(
						PictureExplorer.this.xValue.getText(),
						PictureExplorer.this.yValue.getText());
			}
		});
		this.yValue = new JTextField(Integer.toString(this.yIndex
				+ this.numberBase), 6);
		this.yValue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PictureExplorer.this.displayPixelInformation(
						PictureExplorer.this.xValue.getText(),
						PictureExplorer.this.yValue.getText());
			}
		});

		// set up the next and previous buttons
		this.setUpNextAndPreviousButtons();

		// set up the font for the labels
		this.xLabel.setFont(labelFont);
		this.yLabel.setFont(labelFont);
		this.xValue.setFont(labelFont);
		this.yValue.setFont(labelFont);

		// add the items to the vertical box and the box to the panel
		hBox.add(Box.createHorizontalGlue());
		hBox.add(this.xLabel);
		hBox.add(this.xPrevButton);
		hBox.add(this.xValue);
		hBox.add(this.xNextButton);
		hBox.add(Box.createHorizontalStrut(10));
		hBox.add(this.yLabel);
		hBox.add(this.yPrevButton);
		hBox.add(this.yValue);
		hBox.add(this.yNextButton);
		locationPanel.add(hBox);
		hBox.add(Box.createHorizontalGlue());

		return locationPanel;
	}

	/**
	 * Create the color information panel
	 * 
	 * @param labelFont
	 *            the font to use for labels
	 * @return the color information panel
	 */
	private JPanel createColorInfoPanel(final Font labelFont) {
		// create a color info panel
		JPanel colorInfoPanel = new JPanel();
		colorInfoPanel.setLayout(new FlowLayout());

		// get the pixel at the x and y
		Pixel pixel = new Pixel(this.picture, this.xIndex, this.yIndex);

		// create the labels
		this.rValue = new JLabel("R: " + pixel.getRed());
		this.gValue = new JLabel("G: " + pixel.getGreen());
		this.bValue = new JLabel("B: " + pixel.getBlue());

		// create the sample color panel and label
		this.colorLabel = new JLabel("Color at location: ");
		this.colorPanel = new JPanel();
		this.colorPanel.setBorder(new LineBorder(Color.black, 1));

		// set the color sample to the pixel color
		this.colorPanel.setBackground(pixel.getColor());

		// set the font
		this.rValue.setFont(labelFont);
		this.gValue.setFont(labelFont);
		this.bValue.setFont(labelFont);
		this.colorLabel.setFont(labelFont);
		this.colorPanel.setPreferredSize(new Dimension(25, 25));

		// add items to the color information panel
		colorInfoPanel.add(this.rValue);
		colorInfoPanel.add(this.gValue);
		colorInfoPanel.add(this.bValue);
		colorInfoPanel.add(this.colorLabel);
		colorInfoPanel.add(this.colorPanel);

		return colorInfoPanel;
	}

	/**
	 * Creates the North JPanel with all the pixel location and color
	 * information
	 */
	private void createInfoPanel() {
		// create the info panel and set the layout
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout());

		// create the font
		Font largerFont = new Font(infoPanel.getFont().getName(), infoPanel
				.getFont().getStyle(), 14);

		// create the pixel location panel
		JPanel locationPanel = this.createLocationPanel(largerFont);

		// create the color informaiton panel
		JPanel colorInfoPanel = this.createColorInfoPanel(largerFont);

		// add the panels to the info panel
		infoPanel.add(BorderLayout.NORTH, locationPanel);
		infoPanel.add(BorderLayout.SOUTH, colorInfoPanel);

		// add the info panel
		this.pictureFrame.getContentPane().add(BorderLayout.NORTH, infoPanel);
	}

	/**
	 * Method to check that the current position is in the viewing area and if
	 * not scroll to center the current position if possible
	 */
	@SuppressWarnings("unused")
	public void checkScroll() {
		// get the x and y position in pixels
		int xPos = (int) (this.xIndex * this.zoomFactor);
		int yPos = (int) (this.yIndex * this.zoomFactor);

		// only do this if the image is larger than normal
		if (this.zoomFactor > 1) {

			// get the rectangle that defines the current view
			JViewport viewport = this.scrollPane.getViewport();
			Rectangle rect = viewport.getViewRect();
			int rectMinX = (int) rect.getX();
			int rectWidth = (int) rect.getWidth();
			int rectMaxX = (rectMinX + rectWidth) - 1;
			int rectMinY = (int) rect.getY();
			int rectHeight = (int) rect.getHeight();
			int rectMaxY = (rectMinY + rectHeight) - 1;

			// get the maximum possible x and y index
			int maxIndexX = (int) (this.picture.getWidth() * this.zoomFactor)
					- rectWidth - 1;
			int maxIndexY = (int) (this.picture.getHeight() * this.zoomFactor)
					- rectHeight - 1;

			// calculate how to position the current position in the middle of
			// the viewing
			// area
			int viewX = xPos - (rectWidth / 2);
			int viewY = yPos - (rectHeight / 2);

			// reposition the viewX and viewY if outside allowed values
			if (viewX < 0) {
				viewX = 0;
			} else if (viewX > maxIndexX) {
				viewX = maxIndexX;
			}
			if (viewY < 0) {
				viewY = 0;
			} else if (viewY > maxIndexY) {
				viewY = maxIndexY;
			}

			// move the viewport upper left point
			viewport.scrollRectToVisible(new Rectangle(viewX, viewY, rectWidth,
					rectHeight));
		}
	}

	/**
	 * Zooms in the on picture by scaling the image. It is extremely memory
	 * intensive.
	 * 
	 * @param factor
	 *            the amount to zoom by
	 */
	public void zoom(final double factor) {
		// save the current zoom factor
		this.zoomFactor = factor;

		// calculate the new width and height and get an image that size
		int width = (int) (this.picture.getWidth() * this.zoomFactor);
		int height = (int) (this.picture.getHeight() * this.zoomFactor);
		BufferedImage bimg = this.picture.getBufferedImage();

		// set the scroll image icon to the new image
		this.imageDisplay.setImage(bimg.getScaledInstance(width, height,
				Image.SCALE_DEFAULT));
		this.imageDisplay.setCurrentX((int) (this.xIndex * this.zoomFactor));
		this.imageDisplay.setCurrentY((int) (this.yIndex * this.zoomFactor));
		this.imageDisplay.revalidate();
		this.checkScroll(); // check if need to reposition scroll
	}

	/**
	 * Repaints the image on the scrollpane.
	 */
	public void repaint() {
		this.pictureFrame.repaint();
	}

	// ****************************************//
	// Event Listeners //
	// ****************************************//

	/**
	 * Called when the mouse is dragged (button held down and moved)
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseDragged(final MouseEvent e) {
		this.displayPixelInformation(e);
	}

	/**
	 * Method to check if the given x and y are in the picture
	 * 
	 * @param x
	 *            the horiztonal value
	 * @param y
	 *            the vertical value
	 * @return true if the x and y are in the picture and false otherwise
	 */
	private boolean isLocationInPicture(final int x, final int y) {
		boolean result = false; // the default is false
		if ((x >= 0) && (x < this.picture.getWidth()) && (y >= 0)
				&& (y < this.picture.getHeight())) {
			result = true;
		}

		return result;
	}

	/**
	 * Method to display the pixel information from the passed x and y but also
	 * converts x and y from strings
	 * 
	 * @param xString
	 *            the x value as a string from the user
	 * @param yString
	 *            the y value as a string from the user
	 */
	public void displayPixelInformation(final String xString,
			final String yString) {
		int x = -1;
		int y = -1;
		try {
			x = Integer.parseInt(xString);
			x = x - this.numberBase;
			y = Integer.parseInt(yString);
			y = y - this.numberBase;
		} catch (Exception ex) {
		}

		if ((x >= 0) && (y >= 0)) {
			this.displayPixelInformation(x, y);
		}
	}

	/**
	 * Method to display pixel information for the passed x and y
	 * 
	 * @param pictureX
	 *            the x value in the picture
	 * @param pictureY
	 *            the y value in the picture
	 */
	private void displayPixelInformation(final int pictureX, final int pictureY) {
		// check that this x and y is in range
		if (this.isLocationInPicture(pictureX, pictureY)) {
			// save the current x and y index
			this.xIndex = pictureX;
			this.yIndex = pictureY;

			// get the pixel at the x and y
			Pixel pixel = new Pixel(this.picture, this.xIndex, this.yIndex);

			// set the values based on the pixel
			this.xValue
					.setText(Integer.toString(this.xIndex + this.numberBase));
			this.yValue
					.setText(Integer.toString(this.yIndex + this.numberBase));
			this.rValue.setText("R: " + pixel.getRed());
			this.gValue.setText("G: " + pixel.getGreen());
			this.bValue.setText("B: " + pixel.getBlue());
			this.colorPanel.setBackground(new Color(pixel.getRed(), pixel
					.getGreen(), pixel.getBlue()));

		} else {
			this.clearInformation();
		}

		// notify the image display of the current x and y
		this.imageDisplay.setCurrentX((int) (this.xIndex * this.zoomFactor));
		this.imageDisplay.setCurrentY((int) (this.yIndex * this.zoomFactor));
	}

	/**
	 * Method to display pixel information based on a mouse event
	 * 
	 * @param e
	 *            a mouse event
	 */
	private void displayPixelInformation(final MouseEvent e) {

		// get the cursor x and y
		int cursorX = e.getX();
		int cursorY = e.getY();

		// get the x and y in the original (not scaled image)
		int pictureX = (int) ((cursorX / this.zoomFactor) + this.numberBase);
		int pictureY = (int) ((cursorY / this.zoomFactor) + this.numberBase);

		// display the information for this x and y
		this.displayPixelInformation(pictureX, pictureY);

	}

	/**
	 * Method to clear the labels and current color and reset the current index
	 * to -1
	 */
	private void clearInformation() {
		this.xValue.setText("N/A");
		this.yValue.setText("N/A");
		this.rValue.setText("R: N/A");
		this.gValue.setText("G: N/A");
		this.bValue.setText("B: N/A");
		this.colorPanel.setBackground(Color.black);
		this.xIndex = -1;
		this.yIndex = -1;
	}

	/**
	 * Method called when the mouse is moved with no buttons down
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseMoved(final MouseEvent e) {
	}

	/**
	 * Method called when the mouse is clicked
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseClicked(final MouseEvent e) {
		this.displayPixelInformation(e);
	}

	/**
	 * Method called when the mouse button is pushed down
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mousePressed(final MouseEvent e) {
		this.displayPixelInformation(e);
	}

	/**
	 * Method called when the mouse button is released
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseReleased(final MouseEvent e) {
	}

	/**
	 * Method called when the component is entered (mouse moves over it)
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseEntered(final MouseEvent e) {
	}

	/**
	 * Method called when the mouse moves over the component
	 * 
	 * @param e
	 *            the mouse event
	 */
	@Override
	public void mouseExited(final MouseEvent e) {
	}

	/**
	 * Method to enable all menu commands
	 */
	private void enableZoomItems() {
		this.twentyFive.setEnabled(true);
		this.fifty.setEnabled(true);
		this.seventyFive.setEnabled(true);
		this.hundred.setEnabled(true);
		this.hundredFifty.setEnabled(true);
		this.twoHundred.setEnabled(true);
		this.fiveHundred.setEnabled(true);
	}

	/**
	 * Controls the zoom menu bar
	 * 
	 * @param a
	 *            the ActionEvent
	 */
	@Override
	public void actionPerformed(final ActionEvent a) {

		if (a.getActionCommand().equals("Update")) {
			this.repaint();
		}

		if (a.getActionCommand().equals("25%")) {
			this.zoom(.25);
			this.enableZoomItems();
			this.twentyFive.setEnabled(false);
		}

		if (a.getActionCommand().equals("50%")) {
			this.zoom(.50);
			this.enableZoomItems();
			this.fifty.setEnabled(false);
		}

		if (a.getActionCommand().equals("75%")) {
			this.zoom(.75);
			this.enableZoomItems();
			this.seventyFive.setEnabled(false);
		}

		if (a.getActionCommand().equals("100%")) {
			this.zoom(1.0);
			this.enableZoomItems();
			this.hundred.setEnabled(false);
		}

		if (a.getActionCommand().equals("150%")) {
			this.zoom(1.5);
			this.enableZoomItems();
			this.hundredFifty.setEnabled(false);
		}

		if (a.getActionCommand().equals("200%")) {
			this.zoom(2.0);
			this.enableZoomItems();
			this.twoHundred.setEnabled(false);
		}

		if (a.getActionCommand().equals("500%")) {
			this.zoom(5.0);
			this.enableZoomItems();
			this.fiveHundred.setEnabled(false);
		}
	}

	/**
	 * Test Main. It will ask you to pick a file and then show it
	 * 
	 * @throws ImageFormatException
	 */
	@SuppressWarnings("unused")
	public static void main(final String args[]) throws ImageFormatException {
		Picture p = new Picture(FileChooser.pickAFile());
		PictureExplorer test = new PictureExplorer(p);

	}

	/**
	 * Class for establishing the focus for the textfields
	 */
	private class PictureExplorerFocusTraversalPolicy extends
			FocusTraversalPolicy {

		/**
		 * Method to get the next component for focus
		 */
		@Override
		public Component getComponentAfter(final Container focusCycleRoot,
				final Component aComponent) {
			if (aComponent.equals(PictureExplorer.this.xValue)) {
				return PictureExplorer.this.yValue;
			} else {
				return PictureExplorer.this.xValue;
			}
		}

		/**
		 * Method to get the previous component for focus
		 */
		@Override
		public Component getComponentBefore(final Container focusCycleRoot,
				final Component aComponent) {
			if (aComponent.equals(PictureExplorer.this.xValue)) {
				return PictureExplorer.this.yValue;
			} else {
				return PictureExplorer.this.xValue;
			}
		}

		@Override
		public Component getDefaultComponent(final Container focusCycleRoot) {
			return PictureExplorer.this.xValue;
		}

		@Override
		public Component getLastComponent(final Container focusCycleRoot) {
			return PictureExplorer.this.yValue;
		}

		@Override
		public Component getFirstComponent(final Container focusCycleRoot) {
			return PictureExplorer.this.xValue;
		}
	}

}