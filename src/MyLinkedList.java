import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<T> {
	//MEMBER VARIABLE
	
	final T item;
	private Node<T> next;
	
	//CONSTRUCTOR
	public Node(T obj) {
		this.item = obj;
		this.next = null;
	}
	public Node(T obj, Node<T> nextNode){
		this.item = obj;
		this.next = nextNode;
	}
	
	//MEMBER METHOD
	public T getItem(){
		return item;
	}
	public void setNext(Node<T> nextNode){
		next = nextNode;
	}
	public Node<T> getNext(){
		return next;
	}
	
}//CLASS NODE END

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {
	
	//MEMBER STATE
	private Node<T> head = null;
	private int size=0;
	
	//MEMBER METHOD
	@Override
	public Iterator<T> iterator() {
		
		return new MyLinkedListIterator<T>(this);
	}
	public Node<T> getHead(){
		return head;
	}
	public boolean isEmpty(){
		return (size==0)? true : false;
	}

	public boolean add(T obj) {
		//FIRST ADD
		if(head==null){
				head = new Node<T>(obj);
				size++;
				return true;
		}
		else{
			//prev is followed by cursor
			Node<T> cursor = head;
			Node<T> prev = head;
			Node<T> newNode = new Node<T>(obj);
			
			while(cursor!=null&&cursor.getItem().compareTo(obj)<0){
				prev=cursor;
				cursor=cursor.getNext();			
			}
			
			if(cursor==null){//add at the first place
				prev.setNext(newNode);
				size++;
				return true;
			}
			
			if(cursor.getItem().compareTo(obj)==0)
				return true;//if there is duplication
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
	}// add end

	public boolean remove(T obj) {
		if(head==null) // if list is empty
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
			if(cursor.getItem().compareTo(obj)==0){// if a node matched, the delete
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
}