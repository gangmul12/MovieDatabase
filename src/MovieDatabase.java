public class MovieDatabase {
	private MyLinkedList<Genre> genres;
	public MovieDatabase() {
		genres = new MyLinkedList<Genre>();
		
	}

	public void insert(String genre, String title){
		genres.add(new Genre(genre));
		MyLinkedListIterator<Genre> it = (MyLinkedListIterator<Genre>)genres.iterator();
		Genre target = null;
		while(it.hasNext()){
			target = it.next();
			if(target.equals(new Genre(genre))){
				break;
			}
		}
		target.getTitles().add(title);
		genres.printGenre();
		
	}

	public void delete(String genre, String title) {
		MyLinkedListIterator<Genre> it = (MyLinkedListIterator<Genre>)genres.iterator();
		Genre target = null;
		while(it.hasNext()){
			target = it.next();
			if(target.equals(new Genre(genre))){
				break;
			}
		}
		if(target==null) return;
		target.getTitles().remove(title);
		if(target.getTitles().isEmpty()){
			genres.remove(new Genre(genre));
		}
		genres.printGenre();
	}

	public MyLinkedList<QueryResult> search(String term) {
		// FIXME implement this
		// Search the given term from the MovieDatabase.
		// You should return a linked list of QueryResult.
		// The search command is handled at SearchCmd.java.
		// Printing functionality is provided for the sake of debugging.
		// This code should be removed before submitting your work.
		System.err.printf("[trace] SEARCH [%s]\n", term);

		MyLinkedList<QueryResult> results = new MyLinkedList<QueryResult>();

		return results;
	}
}
