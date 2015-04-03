class Genre implements Comparable<Genre> {
	
	private String genre;
	private MyLinkedList<String> titles;
	// Implement a Genre class.
	// This class should hold the name of the genre.
	// This class should maintain a linked list of movie titles for this genre.
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
	//FIXME delete this method
	public void print(){
		MyLinkedListIterator<String> it = (MyLinkedListIterator<String>)this.titles.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
