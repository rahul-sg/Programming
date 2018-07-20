package Packages.rsengupta.MiscLibraries;

abstract class ShapeLibrary {
	public double width;
	public double length;

	public ShapeLibrary(double width, double length) {
		this.width = width;
		this.length = length;
	}

	abstract void setArea();
	abstract void setPeri();

}


