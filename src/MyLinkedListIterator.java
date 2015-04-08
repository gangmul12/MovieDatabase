import java.util.Iterator;

public class MyLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {

	private final MyLinkedList<T> l;
	private Node<T> index;

	public MyLinkedListIterator(MyLinkedList<T> myLinkedList) {
		this.l = myLinkedList;
		this.index=l.getHead();
	}

	@Override
	public boolean hasNext() {
		if(index==null)
			return false;
		else return true;
	}

	@Override
	public T next() {
		T result = index.getItem();
		index=index.getNext();
		return result;
		
	}

	@Override
	public void remove() {
		
		throw new UnsupportedOperationException();
	}
}
