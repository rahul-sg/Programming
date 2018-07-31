package Packages.rsengupta.Library;

public class Book implements LibraryInterface {
	protected String title;
	protected String author;
	protected String isbn;
	protected String description;
	protected int borrowTime;
	protected int count;

	protected String publisher;
	protected double price;

	public Book (String t, String a, String i, String d, int b, String pu, double pr, int c) {
		title = t;
		author = a;
		isbn = i;
		description = d;
		borrowTime = b;
		publisher = pu;
		price = pr;
		count = c;
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

	public int getCount() {
		return count;
	}
}
