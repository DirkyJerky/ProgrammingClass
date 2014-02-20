package mod8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bookClasses.Picture;
import bookClasses.Pixel;

public class Effects {
	
	private Picture picture;
	
	public Effects(Picture picture) {
		this.picture = picture;
	}
	
	Pixel pixel;
	public Picture apply(String effect) {
		List<Integer> attributes = new ArrayList<>();
		int red;
		int green;
		int blue;
		boolean invR;
		boolean invG;
		boolean invB;
		if (effect != "inv") {
			for (String string : Arrays.asList(effect.split(","))) {
				int bytee = Integer.parseInt(string.trim()); 
//				System.out.println(bytee);
				attributes.add(bytee);
			}
			red = attributes.get(0);
			green = attributes.get(1);
			blue = attributes.get(2);
			invR = false;
			invG = false;
			invB = false;
		} else {
			red = 0;
			blue = 0;
			green = 0;
			invR = true;
			invG = true;
			invB = true;
		}
		
// DEBUG
//		System.out.println(red);
//		System.out.println(invR);
//		System.out.println(green);
//		System.out.println(invG);
//		System.out.println(blue);
//		System.out.println(invB);
		
		Picture copy = new Picture(this.picture);
		for (Pixel pixel : Arrays.asList(copy.getPixels())) {
			
        		if(invR) {
        			pixel.setRed(255 - pixel.getRed());
        		} else if (pixel.getRed() + red > 255) {
        			pixel.setRed(255);
        		} else {
        			pixel.setRed(pixel.getRed() + red);
        		}
        		
        		if(invG) {
        			pixel.setGreen(255 - pixel.getGreen());
        		} else if (pixel.getGreen() + green > 255) {
        			pixel.setGreen(255);
        		} else {
        			pixel.setGreen(pixel.getGreen() + green);
        		}
        		
        		if(invB) {
        			pixel.setBlue(255 - pixel.getBlue());
        		} else if (pixel.getBlue() + blue > 255) {
        			pixel.setBlue(255);
        		} else {
        			pixel.setBlue(pixel.getBlue() + blue);
        		}
        		
        }
		return copy;
	}
}
