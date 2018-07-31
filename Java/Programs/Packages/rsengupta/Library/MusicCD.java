package Packages.rsengupta.Library;

public class MusicCD extends CD implements LibraryInterface {
	protected int trackCount;
	protected String[] tracks;

	public MusicCD (String t, String a, String i, String d, int b, boolean bl, String ar, int tr, String[] tracks) {
		super(t, a, i, d, b, bl, ar);

		trackCount = tr;
		this.tracks. = tracks;
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

	public int getTrackCount() {
		return trackCount;
	}

	public String[] getTracks() {
		return tracks[];
	}

	public int getCount() {
		return count;
	}
}
