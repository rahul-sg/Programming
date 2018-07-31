package Packages.rsengupta.Library;

public DVD extends CD implements LibraryInterface {
	protected String releaseDate;
	protected String director;

	public DVD (String t, String a, String i, String d, int b, boolean bl, String ar, String r, String d) {
		super (t, a, i, d, b, bl, ar);

		releaseDate = r;
		director = d;
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

	public String artist() {
		return artist;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public int getCount() {
		return count;
	}
}
