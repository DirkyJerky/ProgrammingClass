package me.yoerger.geoff.edu.progClass.mod9;

import java.awt.Graphics;
import java.awt.Graphics2D;

import me.yoerger.geoff.edu.progClass.bookClasses.Picture;

public class Scaler {
	private final Graphics2D graphics;

	public Scaler(Graphics graphics) {
		this.graphics = (Graphics2D) graphics;
	}

	public Scaler(Picture picture) {
		this.graphics = picture.createGraphics();
	}

	public Graphics apply(int w, int h) {
		return this.graphics; // TODO
	}
}
