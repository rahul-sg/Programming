package Packages.rsengupta.MiscLibraries;
import Packages.rsengupta.MiscLibraries.Rectangle;

// Rectangular Prism and Cube
public class RectPrism extends Rectangle {
	public double height;
	public double volume;
	public boolean isCube;

	public RectPrism(double w, double l, double h) {
		super (w, l);
		height = h;
	}
	
	public boolean isCube() {
		return width == length;
	}

	public void volume() {
		if (isCube == true) {
			volume = width * width * width;
		} else {
			volume = width * length * height;
		}
	}

	public double getVolume() {
		return volume;
	}

	@Override
	public double getWidth() {
		return width;
	}
	
	@Override
	public double getLength() {	
		return length;
	}

	public double getHeight() {
		return height;
	}
}
