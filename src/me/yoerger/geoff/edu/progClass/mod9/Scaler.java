package me.yoerger.geoff.edu.progClass.mod9;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import me.yoerger.geoff.edu.progClass.bookClasses.Picture;

/**
 * @author yoerggeo000
 * @Deprecated Use the imgscalr lib instead!
 */
@Deprecated
public class Scaler {
	private final BufferedImage bi;

	/**
	 * @param picture The picture to scale
	 */
	public Scaler(Picture picture) {
		this(picture.getBufferedImage());
	}

	/**
	 * @param bi The buffered image to scale
	 */
	public Scaler(BufferedImage bi) {
		this.bi = bi;
	}

	/**
	 * @param w The width to scale
	 * @param h The hieght to scale
	 * @return The scaled image
	 */
	public BufferedImage apply(int w, int h) {
		AffineTransform AffT = AffineTransform.getScaleInstance(w / this.bi.getWidth(),
		        h / this.bi.getHeight());
		AffineTransformOp AffTop = new AffineTransformOp(AffT,
		        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return AffTop.filter(this.bi, null);
	}
}
