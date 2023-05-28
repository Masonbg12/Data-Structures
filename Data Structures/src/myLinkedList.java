
public class myLinkedList<E extends Comparable<E> > {
	private myNode<E> first;
	private myNode<E> last;
	private int size;
	
	// first acessor
	public myNode<E> getFirst() {
		return this.first;
	}
	
	// last acessor
	public myNode<E> getLast() {
		return this.last;
	}
	
	// size acessor
	public int getSize() {
		return this.size;
	}
	
	// isEmpty() checks if linked list is empty
	public boolean isEmpty() {
		return first == null;
	}
	
	// addFirst() adds new element to first position
	public void addFirst(E s) {
		myNode<E> newNode = new myNode<E>(s);
		if(isEmpty()) {
			last = newNode;
		}
		else {
			newNode.next = first;
		}
		first = newNode;
		size++;
	}

	// addLast() adds a new element to last position
	public void addLast(E s) {
		myNode<E> newNode = new myNode<E>(s);
		if(isEmpty()) 
			first = newNode;
		else
			last.next = newNode;
		
		last = newNode;
		size++;
	}
	
	// removeFirst() removes first element
	public void removeFirst() {
		if (!isEmpty()) {
			E temp = first.element;
			
			if (first == last) // only one element in the list
				first = last = null;
			else
				first = first.next;
			
			size--;
			System.out.print(temp + " is removed!");
		}
		else
			System.out.print("List is empty");
			
	}
	
	// removeLast() removes last element 
	public void removeLast() {
		if (!isEmpty()) {
			E temp = last.element;
			
			if (first == last)
				first = last = null;
			else {
				myNode<E> prev = first;
				while(prev.next != last)
					prev = prev.next;
				
				prev.next = null;
				last = prev;
			}
			size--;
			System.out.print(temp + " is removed!");
		}
		else
			System.out.print("List is empty");
	}
	
	// remove() removes key element
	@SuppressWarnings("unchecked")
	
	public void remove(String key) {
		if (search((E) key)) {
			myNode<E> prev = first;
			myNode<E> curr = first;
			while(curr != null && !curr.element.equals(key)) {
				prev = curr;
				curr = curr.next;
			}
			
			if (curr == first)
				removeFirst();
			else if (curr == last)
				removeLast();
			else {
				prev.next = curr.next;
				size--;
				System.out.println(key + " is removed!");
			}
		}
		else
			System.out.println(key + " is not in the list!");
	}
	
	// search() performs alinear search for key
	public boolean search(E key) {
		myNode pointer = first;
		
		while(pointer != null && pointer.element.compareTo(key) == 0)
			pointer = pointer.next;
		
		return pointer != null;
	}
	
	// print() prints out linked list
	public void print() {
		myNode<E> pointer = first;
		
		if (!isEmpty()) {
			System.out.print("| ");
			
			while(pointer != null) {
				System.out.print(pointer.element + " | ");
				pointer = pointer.next;
			}
			
			System.out.println();
		}
	}
}

// myNode is node class
class myNode<E extends Comparable<E> > {
	E element;
	myNode<E> next;
	
	myNode(E element) {
		this.element = element;
	}
}
