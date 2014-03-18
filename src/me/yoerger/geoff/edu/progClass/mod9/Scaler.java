package me.yoerger.geoff.edu.progClass.mod9;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import me.yoerger.geoff.edu.progClass.bookClasses.Picture;

@Deprecated
// Use the imgscalr lib instead!
public class Scaler {
	private final BufferedImage bi;

	public Scaler(Picture picture) {
		this(picture.getBufferedImage());
	}

	public Scaler(BufferedImage bi) {
		this.bi = bi;
	}

	public BufferedImage apply(int w, int h) {
		AffineTransform AffT = AffineTransform.getScaleInstance(w / this.bi.getWidth(),
		        h / this.bi.getHeight());
		AffineTransformOp AffTop = new AffineTransformOp(AffT,
		        AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		return AffTop.filter(this.bi, null);
	}
}
