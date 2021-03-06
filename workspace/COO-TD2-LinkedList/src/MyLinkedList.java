import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyLinkedList<E> {

	
	private Link<E> head = null;
	private int numberOfModifications = 0;
	
	public Link<E> getHead() {
		return head;
	}
	
	public int numberOfModifications(){
		return this.numberOfModifications;
	}

	public void setHead(Link<E> head) {
		this.head = head;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public Link<E> addFirst(E value){
		Link<E> newHead = new Link<E>(value, this.head);
		this.setHead(newHead);
		numberOfModifications ++;
		return newHead;
	}
	
	public Link<E> addLast(E value){
		if(this.isEmpty()){	return this.addFirst(value);	}
		Link<E> lastElement = this.head;
		Link<E> newLast = new Link<E>(value, null);
		Iterator<Link<E>> iterator = this.iterator();
		while(! iterator.hasNext()){
			lastElement = iterator.next();
		}
		lastElement.setNext(newLast);
		numberOfModifications++;
		return newLast;
	}
	
	public Link<E> remove(E elt){
		Link<E> iterator = this.head;
		Link<E> result;
		Link<E> previous = new Link<E>(null,this.head);
		while( iterator.value != elt){
			previous = iterator;
			iterator = iterator.getNext();
			if (iterator == null){
				return null;
			}
		}
		result = iterator;
		previous.setNext(iterator.getNext());
		return result;
	}
	
	public Link<E> removeFirst(){
		if(this.isEmpty()){
			return null;
		}
		Link<E> result = this.head;
		this.setHead(this.head.getNext());
		numberOfModifications++;
		return result;
	}
	
	public Link<E> removeLast(E value){
		if(this.isEmpty()){
			return null;
		}
		
		Link<E> iterator = this.head;
		while(! iterator.isPenultimate()){
			iterator = iterator.getNext();
		}
		Link<E> result = iterator.getNext();
		iterator.setNext( null );
		numberOfModifications ++;
		return result;
	}
	
	public boolean contains(E value){
		if(this.isEmpty()){
			return false;
		}
		return this.head.recursivelyContains(value);
	}

	public Iterator<Link<E>> iterator(){
		// create a dummy first element
		return new MyIterator<E>(new Link<E>(null, this.head), this);
	}
	
	public String toString(){
		String result = "";
		Iterator<Link<E>> iterator = this.iterator();
		while(iterator.hasNext()){
			Link<E> tmp = iterator.next();
			result = result + " -> " + tmp.toString();
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList<Integer> elt = new MyLinkedList<Integer>();
		elt.addLast(12);
		System.out.println("contiens 12 : " + elt.contains(12));
		elt.addLast(13);
		elt.addFirst(11);		
		System.out.println(elt);
		
	}
	
	private class Link<B>{
		private B value;
		private Link<B> next = null;
		

		
		public Link(B value){
			this.value = value;
		}
		
		public Link(B value, Link<B> next){
			this(value);
			this.next= next;
		}

		public B getValue() {
			return value;
		}
		
		public Link<B> getNext() {
			return next;
		}

		public void setNext(Link<B> next) {
			this.next = next;
		}
		
		public boolean recursivelyContains(B value){
			/* I assume this method is not called on an null element */
			
			if(this.isFinal()){
				return (this.getValue() == value);
			}
			return ((this.getValue() == value) || this.next.recursivelyContains(value));
		}
	
		public boolean isPenultimate(){
			return this.next.isFinal();
		}
		
		public boolean isFinal(){
			return this.next == null;
		}
	
		public String toString(){
			return value.toString();
		}
	
	}

	private class MyIterator<D> implements Iterator<Link<D>>{
		
		private Link<D> currentElement;
		private boolean canRemove = true;
		private int knowNumberOfModifications;
		private MyLinkedList<D> list;
		
		public MyIterator(Link<D> currentElement, MyLinkedList<D> list){
			this.currentElement = currentElement;
			this.list = list;
			this.knowNumberOfModifications = list.numberOfModifications();
		}
		
		public boolean canDoNext(){
			return this.knowNumberOfModifications == list.numberOfModifications();
		}
		
		public boolean hasNext(){
			if (currentElement == null) {return false;} 
			return (! currentElement.isFinal());
		}

		@Override
		public Link<D> next() throws NoSuchElementException{
			if (! this.hasNext()) {throw new NoSuchElementException();}
			if(!this.canDoNext()){
				throw new ConcurrentModificationException();
			}
			canRemove = true;
			currentElement = currentElement.getNext();
			//System.out.println(currentElement);
			return (currentElement);
		}

		@Override
		public void remove() throws IllegalStateException{
			if(! this.canRemove()){ throw new IllegalStateException();}
			canRemove = false;
			this.list.remove(currentElement.getValue());
			this.knowNumberOfModifications ++;
		}

		private boolean canRemove(){
			return (this.canRemove) & (! (currentElement == null));
		}
		
	}
}
