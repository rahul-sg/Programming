package Packages.rsengupta.MiscLibraries;
import Packages.rsengupta.MiscLibraries.ShapeLibrary;
import static java.lang.Math.sqrt;

// Triangle
public class Triangle extends ShapeLibrary {
	private double area;
	private String style;
	private double widSq = width * width;
	private double lenSq = length * length;

	public Triangle (double w, double l) {
		super(w, l);
		setStyleType();
		setArea();
	}

	private boolean isEquil() {
		return (Math.sqrt(widSq + lenSq) == width);
	}

	private void setStyleType() {
		if (isEquil() == true) {
			style = "Equilateral";
		} else {
			style = "Regular";
		}
	}

	protected void setArea() {
		area = (width * length) / 2;
	}

	// Add setPeri();
	
	protected void setPeri() {
		
	}

	public double getArea() {
		return area;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public String getStyle() {
		return style;
	}
}
