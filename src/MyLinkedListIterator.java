import java.util.Iterator;

public class MyLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {
	// FIXME implement this
	// Implement the iterator for MyLinkedList.
	// You have to maintain the current position of the iterator.

	// Remove below annotation(@SuppressWarnings("unused")) after you implement this iterator.
	// This annotation tells compiler that "Do not warn me about this variable not being used".
	@SuppressWarnings("unused")
	private final MyLinkedList<T> l;

	public MyLinkedListIterator(MyLinkedList<T> myLinkedList) {
		this.l = myLinkedList;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public T next() {
		return null;
	}

	@Override
	public void remove() {
		// This code does not have to be modified.
		throw new UnsupportedOperationException();
	}
}
