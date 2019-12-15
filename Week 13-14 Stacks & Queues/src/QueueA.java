import java.util.Arrays;

public class QueueA<T extends Object> {
	/*	ATTRIBUTES: *********************************************
	 *  o	Head (an integer index)
	 * 	o	Tail (an integer index)
	 * 	o	Size
	 * 	o	Array of integers
	 */
	private int head;
	private int tail;
	private int size;
	private T[] queue;

	/* CONSTRUCTOR: *********************************************/
	public QueueA(int num) {
		queue = (T[]) new Object[num]; //new T[num];
		size = 0;
		head = -1;
		tail = 0;
	}
	
	/* GETTERS: *************************************************/
	/**
     * TODO 8
     * getSize
	 * @return the size
	 */

	// It returns the size of the queue.
	public int getQueueSize(){ return size; }
	
	/* OTHER METHODS: *******************************************
	 *	o	TODO 9: Enqueue: takes data and adds it to the queue if it is not full
	 * 	o	TODO 10: Dequeue: method that removes the head of the queue, if the queue is not empty, and returns this element
	 *	o	TODO 11: Peek: returns the head element of the queue (without removing it)
	 *	o	TODO 12: Clear: empties the queue
	 *	o	TODO 13: isEmpty: returns true if the queue is empty, false otherwise
	 * 	o	TODO 14: isFull: returns true if the queue is full, false otherwise
	 */
	public void enqueue(T data) {

		// If the queue is full then print a message and return.
		if(isFull()){
			System.out.println("\n\t\tQueue is full!");
			return;
		}
		// If head is equal to -1.
		if(head == -1) {
			// Then increment head by 1.
			head++;
			// Adds data to the first element of the array
			queue[head] = data;
		}
		else {
			// This module operation helps tail to go back to the beginning of the array in case
			// it has reached the end of the array.
			tail = (tail + 1) % queue.length;
			// We add data to the current queues tail position.
			queue[tail] = data;
			// Increments size by 1.
			size++;
		}
	}

	public T dequeue() {

		// If the queue is empty then print a message and then return null.
		if(isEmpty()){
			System.out.println("\n\t\tQueue is empty!");
			return null;
		}

		// We create a T temp variable to store the current head's value, so we cannot lose its data.
		T temp = queue[head];
		// We will make the head's value equal to null, to make it empty.
		queue[head] = null;
		// This module operation helps head to go back to the beginning of the array in case
		// it has reached the end of the array.
		head = (head + 1) % queue.length;
		// Decreases size by 1.
		size--;
		// Returns the data.
		return temp;

	}

	public void clear() {

		// We reset the values to how they were at the beginning.
		head = -1;
		tail = 0;
		size = 0;
		// We use the method fill to empty the queue.
		Arrays.fill(queue, null);
	}

	// We return the current head's value.
	public T peek() { return queue[head]; }

	// If queue at index head is equal to null then return true, else return false.
	public boolean isEmpty() { return queue[head] == null; }

	// If the max capacity and the size of the existing elements are the same then return true, else return false.
	public boolean isFull() { return queue.length == size; }

}
