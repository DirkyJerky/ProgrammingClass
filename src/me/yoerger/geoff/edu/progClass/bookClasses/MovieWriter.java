package me.yoerger.geoff.edu.progClass.bookClasses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.monte.media.avi.AVIOutputStream;

import me.yoerger.geoff.edu.progClass.bookClasses.ImageFormatException;

/**
 * Class to write out an AVI or Quicktime movie from a series of JPEG (jpg)
 * frames in a directory
 * 
 * @author Barb Ericson ericson@cc.gatech.edu
 * 
 *         Depreciated File.toURL() replaced with File.toURI().toURL() by Buck
 *         Scharfnorth 22 May 2008
 * 
 *         Modified writeQuicktime() and writeAVI() to check for appropriate
 *         endings (".mov" and ".avi") before appending them to the destination
 *         path. Also modified getOutputURL to check for "%20" in destination
 *         path. by Brian O'Neill 11 Aug 2008
 * 
 */
public class MovieWriter {
	// /////////////// fields ///////////////////////////

	/** the directory to read the frames from */
	private String framesDir = null;
	/** the number of frames per second */
	private int frameRate = 16;
	/** the name of the movie file */
	private String movieName = null;
	/** the output url for the movie */
	private String outputURL = null;

	// //////////////// constructors //////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public MovieWriter() {
		this.framesDir = FileChooser.pickADirectory();
		this.movieName = this.getMovieName();
		this.outputURL = this.getOutputURL();
	}

	/**
	 * Constructor that takes the directory that has the frames
	 * 
	 * @param dirPath
	 *            the full path for the directory that has the movie frames
	 */
	public MovieWriter(final String dirPath) {
		this.framesDir = dirPath;
		if (!this.framesDir.endsWith(File.separator)
				&& !this.framesDir.endsWith("/")) {
			this.framesDir += File.separator;
		}
		this.movieName = this.getMovieName();
		this.outputURL = this.getOutputURL();
	}

	/**
	 * Constructor that takes the frame rate
	 * 
	 * @param theFrameRate
	 *            the number of frames per second
	 */
	public MovieWriter(final int theFrameRate) {
		this.framesDir = FileChooser.pickADirectory();
		this.frameRate = theFrameRate;
		this.movieName = this.getMovieName();
		this.outputURL = this.getOutputURL();
	}

	/**
	 * Constructor that takes the frame rate and the directory that the frames
	 * are stored in
	 * 
	 * @param theFrameRate
	 *            the number of frames per second
	 * @param theFramesDir
	 *            the directory where the frames are
	 */
	public MovieWriter(final int theFrameRate, final String theFramesDir) {
		this.framesDir = theFramesDir;
		if (!this.framesDir.endsWith(File.separator)
				&& !this.framesDir.endsWith("/")) {
			this.framesDir += File.separator;
		}
		this.frameRate = theFrameRate;
		this.movieName = this.getMovieName();
		this.outputURL = this.getOutputURL();
	}

	/**
	 * Constructor that takes the directory with the frames the frame rate, and
	 * the output url (dir,name, and extendsion)
	 * 
	 * @param theFramesDir
	 *            the directory that holds the frame
	 * @param theFrameRate
	 *            the number of frames per second
	 * @param theOutputURL
	 *            the complete path name for the output movie
	 */
	public MovieWriter(final String theFramesDir, final int theFrameRate,
			final String theOutputURL) {
		this.framesDir = theFramesDir;
		if (!this.framesDir.endsWith(File.separator)
				&& !this.framesDir.endsWith("/")) {
			this.framesDir += File.separator;
		}
		this.frameRate = theFrameRate;
		this.outputURL = theOutputURL;
	}

	// ///////////////// methods //////////////////////////

	/**
	 * Method to get the movie name from the directory where the frames are
	 * stored
	 * 
	 * @return the name of the movie (like movie1)
	 */
	private String getMovieName() {
		File dir = new File(this.framesDir);
		return dir.getName();
	}

	/**
	 * Method to create the output URL from the directory the frames are stored
	 * in.
	 * 
	 * @return the URL for the output movie file
	 */
	private String getOutputURL() {
		File dir = null;
		URL myURL = null;
		if (this.framesDir != null) {
			try {
				dir = new File(this.framesDir + this.movieName);
				myURL = dir.toURI().toURL();
			} catch (Exception ex) {
			}
		}
		// return myURL.toString();
		return myURL.toString().replace("%20", " ");
	}

	/**
	 * Method to get the list of jpeg frames
	 * 
	 * @return a list of full path names for the frames of the movie
	 */
	@SuppressWarnings("unused")
	public List<String> getFrameNames() {
		File dir = new File(this.framesDir);
		String[] filesArray = dir.list();
		List<String> files = new ArrayList<String>();
		long lenFirst = 0;
		for (String fileName : filesArray) {
			// only continue if jpg picture
			if (fileName.indexOf(".jpg") >= 0) {
				File f = new File(this.framesDir + fileName);
				// check for imcomplete image
				if ((lenFirst == 0) || (f.length() > (lenFirst / 2))) {
					// image okay so far
					try {
						BufferedImage i = ImageIO.read(f);
						files.add(this.framesDir + fileName);
					} catch (Exception ex) {
						// if problem reading don't add it
					}
				}
				if (lenFirst == 0) {
					lenFirst = f.length();
				}
			}
		}
		return files;
	}

	/**
	 * Method to write the movie frames in AVI format
	 * 
	 * @throws ImageFormatException
	 */
	@SuppressWarnings("unused")
	public void writeAVI() {
		/*
		 * JMF Code no longer functioned for writing AVIs. Commented out and
		 * code below was written to use a different AVI writing library. BJD:
		 * 11-9-09
		 * 
		 * JpegImagesToMovie imageToMovie = new JpegImagesToMovie();
		 * List<String> frameNames = getFrameNames(); Picture p = new
		 * Picture((String) frameNames.get(0)); if(!outputURL.endsWith(".avi"))
		 * outputURL = outputURL + ".avi";
		 * imageToMovie.doItAVI(p.getWidth(),p.getHeight(),
		 * frameRate,frameNames,outputURL);
		 */

		// The code below utilizes Werner Randelshofer's AVIOutputStream
		// object to write an AVI movie from the list of frames. His code
		// is shared under the Creative Commons Attribution License
		// (see http://creativecommons.org/licenses/by/3.0/). More
		// information about that code can be found in the AVIDemo.jar
		// archive in the jars folder or at http://www.randelshofer.ch

		List<String> frameNames = this.getFrameNames();
		if (!this.outputURL.endsWith(".avi")) {
			this.outputURL = this.outputURL + ".avi";
		}
		try {
			Picture p = new Picture(frameNames.get(0));
		} catch (ImageFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// Convert the URL into a filename
			String filename = (new URL(this.outputURL)).getFile();

			// Setup the output stream
			AVIOutputStream AVIout = new AVIOutputStream(new File(filename));
			// AVIout.setCompressionQuality(1);
			// AVIout.setFrameRate(frameRate);
			// (AVIout).setVideoDimension(p.getWidth(), p.getHeight());

			// Write each frame
			for (int i = 0; i < frameNames.size(); i++) {
				// AVIout.writeFrame(new File(frameNames.get(i)));
				// TODO Fix this
			}

			// Close the output stream so the AVI has proper format
			AVIout.close();
		} catch (Exception e) {
		}

	}

	/**
	 * Method to write the movie frames as quicktime
	 * 
	 * @throws ImageFormatException
	 */
	public void writeQuicktime() {
		JpegImagesToMovie imageToMovie = new JpegImagesToMovie();
		List<String> frameNames = this.getFrameNames();
		Picture p = null;
		try {
			p = new Picture(frameNames.get(0));
		} catch (ImageFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!this.outputURL.endsWith(".mov")) {
			this.outputURL = this.outputURL + ".mov";
		}
		imageToMovie.doItQuicktime(p.getWidth(), p.getHeight(), this.frameRate,
				frameNames, this.outputURL);
	}

	public static void main(final String[] args) throws ImageFormatException {
		MovieWriter writer = new MovieWriter("c:/Temp/testmovie/");
		writer.writeQuicktime();
		writer.writeAVI();
	}
}
