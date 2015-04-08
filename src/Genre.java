class Genre implements Comparable<Genre> {
	
	//genre : holds genre name
	//titles : LinkedList that holds title(String type) of movie at this genre
	private String genre;
	private MyLinkedList<String> titles;
	
	
	
	public Genre(String name) {
		this.genre=name;
		this.titles = new MyLinkedList<String>();
	}
	
	public String getName(){
		return genre;
	}
	public MyLinkedList<String> getTitles(){
		return titles;
	}
	

	@Override
	public int compareTo(Genre other) {
		return this.getName().compareTo(other.getName());
		
	}

	@Override
	//Genre is only equal to other object when each name is same
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return genre;
	}
	
}
