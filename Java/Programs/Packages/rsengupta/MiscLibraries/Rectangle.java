package Packages.rsengupta.MiscLibraries;
import Packages.rsengupta.MiscLibraries.ShapeLibrary;

// Rectangle and Square
public class Rectangle extends ShapeLibrary {
	private double area;
	private double perimeter;
	private boolean isSquare;

	public Rectangle(double w, double l) {
		super(w, l);
		setArea();
		setPeri();
	}

	public boolean isSquare() {
		return width == length;
	}

	protected void setArea() {
		if (isSquare == true) {
			area = width * width;
		} else {
			area = width * length;
		}
	}

	protected void setPeri() {
		if (isSquare == true) {	
			perimeter = 4 * width;
		} else {
			perimeter = 2 * (length + width);
		}
	}

	public double getArea() {
		return area;
	}

	public double getPeri() {
		return perimeter;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}
}
