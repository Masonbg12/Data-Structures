

// myArrayList class implements certain methods from the ArrayList class and rewrites them
public class myArrayList<E extends Comparable<E> > {
	
	private E[] list;
	private int capacity = 4;
	private int size;
	
	// default constructor
	@SuppressWarnings("unchecked")
	
	public myArrayList() {
		this.list = (E[]) (new Object[this.capacity]);
	}
	
	// overloaded constructor
	@SuppressWarnings("unchecked")
	
	public myArrayList(int capacity) {
		// ensuring the capacity is at least 4
		if (capacity > 4)
			this.capacity = capacity;
		
		this.list = (E[]) (new Object[this.capacity]);
	}
	
	// size acessor
	public int getSize() {
		return this.size;
	}
	
	// isEmpty() checks to see if the size of the list is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// add(String) adds a new element to the end of the list and tests to make sure the capacity is 
	// not overrun
	public void add(E s) {
		if (size >= capacity)
			resize(capacity * 2);
		
		list[size] = s;
		size++;
	}
	
	// search() accepts a String key and performs a linear search for the key which either returns
	// the index or -1 if not found
	public int search(E key) {
		for(int i = 0; i < size; i++)
			if (list[i].compareTo(key) == 0)
				return i;
		
		return -1;
	}
	
	// add(String, int) adds a new element to the specified index while again checking the capacity and size
	// then moving all of the elements after the new element over one spot and then placing the new element
	public void add(E s, int index) {
		if (index >= 0 && index < size) {
			if (size >= capacity)
				resize(this.capacity * 2);
			
			for(int k = size - 1; k >= index; k--)
				list[k + 1] = list[k];
			
			list[index] = s;
			size++;
		}
		else
			System.out.println("index " + index + " is out of range.");
	}
	
	// remove(int) calls remove(String) after checking if the user index is within the list range
	public void remove(int i) {
		if (!isEmpty() && i >= 0 && i < size)
			remove(list[i]);
	}
	
	// remove(String) removes an element by searching for the passed in String in the list then moving all
	// of the elements after the one being removed down one element so the element is overwritten finally 
	// the capacity is checked for size issues
	public void remove(E s) {
		int index = search(s);
		
		if (index != -1) {
			E temp = list[index];
			
			for(int k = index + 1; k <= size; k++)
				list[k - 1] = list[k];
			
			size--;
			
			if (size != 0 && capacity / size >= 4)
				resize(capacity / 2);
			System.out.println(temp + " removed!");
		}
		else
			System.out.println(s + " is not in the list!");
	}
	
	// remove() removes the last element from the list while making the last element null and checking
	// capacity again
	public void remove() {
		if (!isEmpty()) {
			size--;
			E temp = list[size];
			list[size] = null;
			if (size != 0 && capacity / size >= 4)
				resize(capacity / 2);
			System.out.println(temp + " removed!");
		}
		else
			System.out.println("list is empty.");
	}
	
	// resize() changes the capacity, takes the old list and places it in a new list of length capacity
	@SuppressWarnings("unchecked")
	
	public void resize(int capacity) {
		this.capacity = capacity;
		
		E[] temp = list;
		list = (E[]) (new Object[this.capacity]);
		for (int i = 0; i < this.size; i++)
			this.list[i] = temp[i];
	}
	
	// print() linearly prints out the list's elments with a "|" seperating them
	public void print() {
		System.out.print(" |");
		
		for(int i = 0; i < capacity; i++)
			System.out.print(list[i] + " | ");
		
		System.out.println();
	}
}
