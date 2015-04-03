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
		MyLinkedList<QueryResult> result = new MyLinkedList<QueryResult>();
		
		MyLinkedListIterator<Genre> git = (MyLinkedListIterator<Genre>)genres.iterator();

		while(git.hasNext()){
			Genre tempGenre = git.next();
			MyLinkedListIterator<String> sit = (MyLinkedListIterator<String>)tempGenre.getTitles().iterator();
			while(sit.hasNext()){
				String tempString = sit.next();
				
				if(term==null||tempString.contains(term))
					result.add(new QueryResult(tempGenre.toString(), tempString));
			}
			
		}
		

		return result;
	}
}
