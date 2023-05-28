
public class myStack<E extends Comparable<E> > {
	private E top;
	myLinkedList<E> link = new myLinkedList<E>();
	
	public void pop() {
		link.removeFirst();
	}
	
	public void push(E element) {
		link.addFirst(element);
	}
	
	public E pick() {
		return link.getFirst().element;
	}
	
	public void print() {
		link.print();
	}
}
