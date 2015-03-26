class Genre implements Comparable<Genre> {
	// FIXME implement this
	// Implement a Genre class.
	// This class should hold the name of the genre.
	// This class should maintain a linked list of movie titles for this genre.
	public Genre(String name) {
	}

	@Override
	public int compareTo(Genre other) {
		// TODO implement this
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (! (other instanceof Genre)) return false;

		// TODO implement by yourself to test equality,
		// or use 'Source' - 'Generate hashCode() and equals() ...'
		return true;
	}

	@Override
	public int hashCode() {
		// TODO implement by yourself,
		// or use 'Source' - 'Generate hashCode() and equals() ...'
		// MAKE SURE THAT THE IMPLEMENTATION IS COMPATIBLE WITH equals()
		return 0;
	}

	@Override
	public String toString() {
		return "";
	}
}
