import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<T> {
	// FIXME implement this
	final T item;

	public Node(T obj) {
		this.item = obj;
	}
}

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {
	// FIXME implement this
	// Implement a linked list.
	// This linked list should maintain the items in a sorted order.
	// This linked list should discard a duplicate.

	Node<T> head = null;

	@Override
	public Iterator<T> iterator() {
		// This code does not have to be modified.
		// Implement MyLinkedListIterator instead.
		return new MyLinkedListIterator<T>(this);
	}

	public boolean add(T obj) {
		// FIXME implement this
		head = new Node<T>(obj);
		return true;
	}

	public boolean remove(T obj) {
		// FIXME implement this
		throw new UnsupportedOperationException();
	}

	public int size() {
		// FIXME implement this
		return head != null ? 1 : 0;
	}

	public T first() {
		// FIXME implement this
		// This is a helper method.
		// You do not necessarily have to implement this but still might be useful to do so.
		if (head != null)
			return head.item;
		else
			throw new NoSuchElementException();
	}

	public T last() {
		// FIXME implement this
		// This is a helper method.
		// You do not necessarily have to implement this but still might be useful to do so.
		throw new UnsupportedOperationException();
	}
}
