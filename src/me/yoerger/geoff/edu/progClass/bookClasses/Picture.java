package me.yoerger.geoff.edu.progClass.bookClasses;

// import java.awt.*;
// import java.awt.font.*;
//import java.awt.geom.*;
import java.awt.image.BufferedImage;
//import java.text.*;
//import java.util.*;
//import java.util.List; // resolves problem with java.awt.List and java.util.List

import sun.awt.image.ImageFormatException;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	// /////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 * @throws ImageFormatException
	 */
	public Picture(final String fileName) throws ImageFormatException {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param width
	 *            the width of the desired picture
	 * @param height
	 *            the height of the desired picture
	 */
	public Picture(final int width, final int height) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 */
	public Picture(final Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(final BufferedImage image) {
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	@Override
	public String toString() {
		String output = "Picture, filename " + this.getFileName() + " height "
				+ this.getHeight() + " width " + this.getWidth();
		return output;

	}

	public static void main(final String[] args) throws ImageFormatException {
		String fileName = FileChooser.pickAFile();
		Picture pictObj = new Picture(fileName);
		pictObj.explore();
	}

} // this } is the end of class Picture, put all new methods before this
