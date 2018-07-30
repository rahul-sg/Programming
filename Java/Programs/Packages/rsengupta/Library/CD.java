package Packages.rsengupta.Library;

public class CD implements LibaryInterface {
	protected String title;
	protected String author;
	protected String isbn;
	protected String description;
	protected int borrowTime;

	protected boolean bluray;
	protected String artist;

	public CD (t, a, i, d, b, bl, ar) {
		title = t;
		author = a;
		isbn = i;
		description = d;
		borrowTime = b;
		bluray = bl;
		artist = ar;
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
}
