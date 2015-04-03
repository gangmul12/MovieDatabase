import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<T> {
	
	final T item;
	private Node<T> next;

	public Node(T obj) {
		this.item = obj;
		this.next = null;
	}
	public Node(T obj, Node<T> nextNode){
		this.item = obj;
		this.next = nextNode;
	}
	
	public T getItem(){
		return item;
	}
	public void setNext(Node<T> nextNode){
		next = nextNode;
	}
	public Node<T> getNext(){
		return next;
	}
	
}

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {
	

	private Node<T> head = null;
	private int size=0;

	@Override
	public Iterator<T> iterator() {
		// This code does not have to be modified.
		// Implement MyLinkedListIterator instead.
		return new MyLinkedListIterator<T>(this);
	}
	public Node<T> getHead(){
		return head;
	}
	public boolean isEmpty(){
		return (size==0)? true : false;
	}

	public boolean add(T obj) {
		if(head==null){
				head = new Node<T>(obj);
				size++;
				return true;
		}
		else{
			
			Node<T> cursor = head;
			Node<T> prev = head;
			Node<T> newNode = new Node<T>(obj);
			
			while(cursor!=null&&cursor.getItem().compareTo(obj)<0){
				prev=cursor;
				cursor=cursor.getNext();			
			}
			
			if(cursor==null){
				prev.setNext(newNode);
				size++;
				return true;
			}
			
			if(cursor.getItem().compareTo(obj)==0)
				return true;
			else{
				if(cursor==head){
					newNode.setNext(head);
					head=newNode;
					size++;
					return true;
				}
				
				newNode.setNext(cursor);
				prev.setNext(newNode);
				size++;
				return true;
			}
			
				
		}
		
	}

	public boolean remove(T obj) {
		if(head==null)
			return true;
		else{
			Node<T> prev = head;
			Node<T> cursor = head;
			
			while(cursor!=null&&cursor.getItem().compareTo(obj)<0){
				prev=cursor;
				cursor=cursor.getNext();
			}
			if(cursor==null)
				return true;
			if(cursor.getItem().compareTo(obj)==0){
				if(prev==cursor){
					head=null;
					size--;
					return true;
				}
					
				prev.setNext(cursor.getNext());
				size--;
				return true;
			}
			else return true;
				
		}
	}

	public int size() {
		return size;
		
	}

	public T first() {
		
		
		if (head != null)
			return head.item;
		else
			throw new NoSuchElementException();
	}

	public T last() {
		if(head==null)
			throw new UnsupportedOperationException();
		else{
			Node<T> prev = head;
			for(int i=0; i<size-1; i++){
				prev=prev.getNext();
			}
			return prev.getNext().getItem();
		}
		
	}
	/*
	//FIXME delete this method
	public void print(){
		MyLinkedListIterator<T> it = (MyLinkedListIterator<T>)this.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	//FIXME delete this method
	public void printGenre(){
		MyLinkedListIterator<Genre> git = (MyLinkedListIterator<Genre>)this.iterator();

		while(git.hasNext()){
			Genre temp = git.next();
			MyLinkedListIterator<String> sit = (MyLinkedListIterator<String>)temp.getTitles().iterator();
			System.out.println(temp.toString());
			while(sit.hasNext()){
				System.out.println(sit.next());
			}
			
		}
	}*/
}
