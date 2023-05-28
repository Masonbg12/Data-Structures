import java.util.*;

// myBST class implements the tree data structure along with its methods
public class myBST<E extends Comparable<E> >{
	// datafields
	private myTreeNode<E> root;
	private int size;
	
	// size acessor
	public int getSize() {
		return this.size;
	}
	
	// insert() method inserts a new node into the tree
	public boolean insert(E s) {
		myTreeNode<E> newNode = new myTreeNode<E>(s);
		
		// creating root if it doesn't exist
		if(this.root == null)
			root = newNode;
		else {
			myTreeNode<E> parent = null;
			myTreeNode<E> current = root;
			
			// moving down the tree to find the correct place of the given value
			while(current != null) {
				if(s.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else if(s.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}
				else
					return false;	// duplicate node not allowed
			}
			// placing new node in tree
			if(s.compareTo(parent.element)< 0)
				parent.left = newNode;
			else
				parent.right = newNode;
		}
		// updating size and returning true for successful insertion
		size++;
		return true;
	}
	
	// search() method moves through the tree to find the key
	public boolean search(E key) {
		myTreeNode<E> current = root;
		
		// moving through the tree
		while(current != null) {
			if(key.compareTo(current.element) < 0)
				current = current.left;
			else if(key.compareTo(current.element)> 0)
				current = current.right;
			else 
				return true;		
		}
		return false;
	}
	
	void DFS() {
		DFS(this.root);
	}
	
	public myTreeNode<E> getRoot() {
		return this.root;
	}
	
	void DFS(myTreeNode<E> currNode) {
		if (currNode != null) {
			DFS(currNode.left);
			System.out.print(currNode.element);
			DFS(currNode.right);
		}
	}
	
	// traversing through tree recursively to print out all nodes in the tree
	public void BFSTraversal(myTreeNode<E> currNode) {
		// base case
		if (currNode == null)
			return;
		
		// recursive traversal
		BFSTraversal(currNode.left);
		System.out.print(currNode.element + " ");
		BFSTraversal(currNode.right);
	}
	
	public void DFSTraversal(myTreeNode<E> currNode) {
		System.out.print("In-Order Traversal: ");
		inOrder(currNode);
		System.out.println();
		
		System.out.print("Pre-Order Traversal: ");
		preOrder(currNode);
		System.out.println();
		
		System.out.print("Post-Order Traversal: ");
		postOrder(currNode);
		System.out.println();
	}
	
	private void postOrder(myTreeNode<E> currNode) {
		if (currNode == null)
			return;
		
		postOrder(currNode.left);
		postOrder(currNode.right);
		System.out.print(currNode.element + " ");
		
	}

	private void preOrder(myTreeNode<E> currNode) {
		if (currNode == null)
			return;
		
		System.out.print(currNode.element + " ");
		preOrder(currNode.left);
		preOrder(currNode.right);
	}

	private void inOrder(myTreeNode<E> currNode) {
		if (currNode == null)
			return;
		
		inOrder(currNode.left);
		System.out.print(currNode.element + " ");
		inOrder(currNode.right);
	}

	public boolean delete(E e) {
		myTreeNode<E> parent = root;
		myTreeNode<E> current = root;
		
		if (search(e)) {
			while(current.element != e) {
				if(e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else {
					parent = current;
					current = current.right;
				}
			}
		
			if (current.left == null) {	// case 1
				if (current == root)
					root = current.right;
				else {
					if (e.compareTo(parent.element)> 0)
						parent.right = current.right;
					else
						parent.left = current.right;
				}
			}
			else { // case 2
				myTreeNode<E> parentOfRightMost = current;
				myTreeNode<E> rightMost = current.left;
				
				while(rightMost != null) {
					parentOfRightMost = rightMost;
					rightMost = rightMost.right;
				}
				
				current.element = rightMost.element;
				
				if (!current.left.equals(rightMost))
					parentOfRightMost.right = rightMost.left;
				else
					parentOfRightMost.left = rightMost.left;
			}
			size--;
			return true;
		}
		else
			return false;
	}
	
	// print() method
	public void print() {
		BFSTraversal(root);
		System.out.println();
	}
}

// class myTreeNode holds the elment in the node along with the left and right Nodes
class myTreeNode<E>{
	// datafields
	E element;
	myTreeNode<E> left;
	myTreeNode<E> right;
	
	// overloaded constructor
	myTreeNode(E element){
		this.element = element;
	}
}