
public class myQueue<E extends Comparable<E> > {
	myLinkedList<E> link = new myLinkedList<E>();
	
	public E deque() {
		E temp = link.getFirst().element;
		link.removeFirst();
		return temp;
	}
	
	public void enque(E element) {
		link.addLast(element);
	}
	
	public void print() {
		link.print();
	}
}
