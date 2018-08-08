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

	public Book (String t, String a, String d, String i, int b, String pu, double pr, int c) {
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

	public void setTitle(String t) {
		title = t;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String a) {
		author = a;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String i) {
		isbn = i;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		description = d;
	}
	
	public int getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(int bt) {
		borrowTime = bt;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String p) {
		publisher  = p;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pr) {
		price = pr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int c) {
		count = c;
	}
}
