package Packages.rsengupta.MiscLibraries;
import Packages.rsengupta.MiscLibraries.Triangle;

public class TriPrism extends Triangle {
	protected double height;
	private double volume;

	public TriPrism (double w, double l, double h) {
		super(w, l);
		height = h;
		setVolume();
		setStyleType();
	}
	
	private void setStyleType() {
		if (length == width) {
			style = "Square Based ";
		} else {
			style = "";
		}
	}
	
	protected void setVolume() {
		volume = (length * width * height) / 3;
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

	public String getStyle() {
		return style;
	}
}
