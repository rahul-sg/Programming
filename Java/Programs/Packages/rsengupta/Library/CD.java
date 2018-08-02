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

	public void setBorrowTime(int b) {
		borrowTime = b;
	}

	public boolean getBluray() {
		return bluray;
	}

	public void setBluray(boolean b) {
		bluray = b;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String a) {
		artist = a;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int c) {
		count = c;
	}
}
