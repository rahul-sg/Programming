package Packages.rsengupta.Library;

import Packages.rsengupta.Library.LibraryInterface;

public class CD implements LibraryInterface {
	protected String title;
	protected String author;
	protected String isbn;
	protected String description;
	protected int borrowTime;
	protected int count;

	protected boolean bluray;
	protected String artist;

	public CD (String t, String a, String i, String d, int b, boolean bl, String ar, int c) {
		title = t;
		author = a;
		isbn = i;
		description = d;
		borrowTime = b;
		bluray = bl;
		artist = ar;
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

	public boolean getBluray() {
		return bluray;
	}

	public String getArtist() {
		return artist;
	}

	public int getCount() {
		return count;
	}
}
