package Packages.rsengupta.Library;

public class Book implements LibraryInterface {
	protected String title;
	protected String author;
	protected String isbn;
	protected String description;
	protected int borrowTime;

	protected String publisher;
	protected double price;

	public Book (t, a, i, d, b, pu, pr) {
		title = t;
		author = a;
		isbn = i;
		description = d;
		borrowTime = b;
		publisher = pu;
		price = pr;
	}

	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBorrowTime() {
		return borrowTime;
	}

	public String getPublisher() {
		return publisher;
	}

	public double getPrice() {
		return price;
	}
}
