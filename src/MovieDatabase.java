public class MovieDatabase {
	//member state
	//genres : LinkedList that holds "Genre" in this database, node type is Genre
	private MyLinkedList<Genre> genres;
	
	//Constructor
	public MovieDatabase() {
		genres = new MyLinkedList<Genre>();
		
	}// Constructor end

	//member method
	
	public void insert(String genre, String title){
		genres.add(new Genre(genre));
		MyLinkedListIterator<Genre> it = (MyLinkedListIterator<Genre>)genres.iterator();
		Genre target = null;
		while(it.hasNext()){
			// if the insertion is the first insertion of this genre, this will be skipped
			// if it isn't, this loop starts to find Genre node at LinkedLinst "genres"
			target = it.next();
			if(target.equals(new Genre(genre))){
				break;
			}
		}
		target.getTitles().add(title);
			
	}// insert end

	public void delete(String genre, String title) {
		MyLinkedListIterator<Genre> it = (MyLinkedListIterator<Genre>)genres.iterator();
		Genre target = null;
		while(it.hasNext()){
			target = it.next();
			if(target.equals(new Genre(genre))){
				break;
			}
		}
		
		if(target==null) return; //if matching failed, ignore deletion
		target.getTitles().remove(title);
		if(target.getTitles().isEmpty()){
			genres.remove(new Genre(genre));
		}
		
	}// delete end

	public MyLinkedList<QueryResult> search(String term) {
		MyLinkedList<QueryResult> result = new MyLinkedList<QueryResult>();
		
		MyLinkedListIterator<Genre> git = (MyLinkedListIterator<Genre>)genres.iterator();

		while(git.hasNext()){
			Genre tempGenre = git.next();
			MyLinkedListIterator<String> sit = (MyLinkedListIterator<String>)tempGenre.getTitles().iterator();
			while(sit.hasNext()){
				//take iterations on every title node. if anything matched, add to result 
				String tempString = sit.next();
				
				if(term==null||tempString.contains(term))//term==null is for print method at PrintCmd
					result.add(new QueryResult(tempGenre.toString(), tempString));
			}
			
		}
		

		return result;
	}// search end
}//MovieDatabase end
