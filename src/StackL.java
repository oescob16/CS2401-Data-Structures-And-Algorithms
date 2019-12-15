
public class StackL<T> {
	private Node<T> top;
	private int size;
	
    /* Constructors ****************************************************************
        TODO 1
        o	One default constructor
        o	One constructor that take a node and starts the stack with this node in it
     */

    // If nothing is passed to the instance, then set top equal to null and size to zero.
    public StackL(){}

    // If the user pass a node then set top to point to a node and increment size by 1.
    public StackL(Node<T> newNode){
		top = newNode;
		size++;
	}
	

    // Getters *********************************************************************
	/**
     * TODO 2
     * getSize
	 * @return the size
	 */

	// getStackSize returns the size of the stack
	public int getStackSize(){
		return size;
	}
	

    // Other methods ***************************************************************
	/* 	o	TODO 3: Push: takes data T (see Person.java) and adds it to the stack 
	 *	o	TODO 4: Pop: void method that removes the top element of the stack, if the stack is not empty
	 *	o	TODO 5: Peek: returns the top element of the stack (without removing it)
	 *	o	TODO 6: Clear: empties the stack
	 *	o	TODO 7: isEmpty: returns true if the stack is empty, false otherwise
	 */
	public void push(T data) {

		// Create a new node that contains data.
		Node<T> newNode = new Node<T>(data);
		// Create a temporary node which will help us add a new node. Because we don't want to lose the top reference.
		Node<T> temp = top;
		// If the stack is empty then proceed to add its first node.
		if(top == null) { top = newNode; }
		// This method call sets temp to point to the new node
		newNode.setNext(temp);
		// Then, sets top to point to the new node.
		top = newNode;
		// Increments size by 1.
		size++;

	}
	
	public void pop() {

		// If the stack is empty then return.
		if(top == null) { return; }
		// Top will now point to the second node, making it the new top and therefore, removing the first node.
		top = top.getNext();
		// Decreases size by 1.
		size--;
	}

	// This method returns the current top data.
	public T peek() { return top.getData(); }

	public void clear() {

		// We empty the stack.
		top = null;
		// Resets the size, making it zero.
		size = 0;
	}

	// If top point to nothing then return true. Otherwise, return false.
	public boolean isEmpty() { return top == null; }
	
}
