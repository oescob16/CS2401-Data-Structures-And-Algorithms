import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Execute {

    /* buildNetwork:
     * This method is given to you. It reads information about advisors in a file and builds a tree of 
     * these advisors.
     */
	public static BTree<Person> buildNetwork(String filename) throws FileNotFoundException, IOException {
		BTree<Person> network = new BTree<Person>();
		 
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        String check;
        String[] line;
        String[] person;
        String name, email;
        while (textReader.ready()) {
        	check = textReader.readLine(); 
        	line = check.split(" ");
        	for (int i=0; i<line.length; i++) {
        		person = line[i].split(",");
        		name = person[0];
        		email = person[1];
        		Person advisor = new Person(name, email);
        		network.insertDataAtLocation(person[2], advisor);
        	}
        }
        
        textReader.close();
        		
		return network;
	}
	
    /*
     * TODO 15: traverseNetwork:
     * This method traverses a BTree in a pre-order fashion, using a Stack (type StackL 
     * that you completed earlier).
     */ 
	public static void traverseNetwork(BTree<Person> network) { // pre-Order

		// We create a BTNode to keep a reference of the tree
		BTNode reference = network.getRoot();

		// If this tree does not exist then return
		if(reference == null) { return; }

		// Else create an empty stack
		StackL s = new StackL();
		// Then push the tree
		s.push(reference);

		System.out.println("StackL Implementation: \n");

		// While the stack is not empty then keep looping.
		while(!s.isEmpty()){

			// We create a BTNode object to store the value of the current stack element
			BTNode val = (BTNode) s.peek();
			// This will print whatever the value of the current stack has.
			val.printNode();
			// This will pop the last element that entered the stack (LIFO).
			s.pop();

			// If val has a right node then push the element into the stack.
			if(val.hasRight()) { s.push(val.getRight()); }
			// If val has a left node then push the element into the stack.
			if(val.hasLeft()) { s.push(val.getLeft()); }
		}
    }
	
    /*
     * TODO 16: levelOrderTraversal:
     * This method traverses a BTree in a level-order fashion, using a Queue (type QueueA 
     * that you completed earlier).
     */ 
	public static void levelOrderTraversal(BTree<Person> network) { // level-Order

		// We create a BTNode to keep a reference of the tree.
		BTNode reference = network.getRoot();

		// If the tree is empty then return
		if(reference == null) { return; }

		// Else create a queue which has the size of the tree.
		QueueA q = new QueueA(network.getSize());
		// Then enqueue the reference.
		q.enqueue(reference);

		System.out.println("QueueA Implementation: \n");

		// While the queue is not empty then keep looping.
		while(!q.isEmpty()){

			// We create a BTNode object to store the value of the current stack element
			BTNode val = (BTNode) q.peek();
			// This will print whatever the value of the current stack has.
			val.printNode();
			// This will dequeue the first element that entered the queue (FIFO).
			q.dequeue();

			// If val has a left node then push the element into the queue.
			if(val.hasLeft()) { q.enqueue(val.getLeft()); }
			// If val has a right node then push the element into the queue..
			if(val.hasRight()) { q.enqueue(val.getRight()); }
		}
	}
	
    /*
     * TODO 17: exploreBranch:
     * This method traverses and prints the nodes of a given branch of a BTree
     * The branch is described by parameter directions, that is a string composed of letters 'L' and 'R'
     * 'L' indicates that we need to explore the branch going to the left subtree
     * 'R' indicates that we need to explore the branch going to the right subtree
     */ 
	public static void exploreBranch(BTree<Person> network, String directions) {

		// We create a BTNode of type person to traverse the tree.
		BTNode<Person> temp = network.getRoot();

		System.out.print("Explore Branch: \n\n");

		// We print the root of the tree.
		temp.printNode();

		// We will loop until we get to the end of the string.
		for(int i = 0; i < directions.length(); i++) {

			// If there is no left and we are currently looking for L, then print a message and break the loop.
			if( (!temp.hasLeft()) && directions.charAt(i) == 'L'){
				System.out.print("~ ERROR: We don't have a left, breaking exploreBranch...\n");
				break;
			}

			// If there is no right and we are currently looking for R, then print a message and break the loop.
			else if( (!temp.hasRight()) && directions.charAt(i) == 'R'){
				System.out.print("~ ERROR: We don't have a right, breaking the exploreBranch...\n");
				break;
			}

			// If we are currently looking for L, then get the left and print it.
			else if(directions.charAt(i) == 'L'){
				temp = temp.getLeft();
				temp.printNode();
			}

			// If we are currently looking for R, then get the right and print it.
			else if(directions.charAt(i) == 'R'){
				temp = temp.getRight();
				temp.printNode();
			}
		}
	}
	
	
    /*
     * TODO 18: complete the main method, according to the comment below
     */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = args[0];
        
        // Here we create a binary tree from the advisors listed in the above text file
		BTree<Person> network = buildNetwork(filename);
        // Once the BTree is built, we print it out
		network.print();
		System.out.println();
        
        // We traverse and print the BTree called network in a pre-order fashion
		traverseNetwork(network);
		System.out.println();
        
        // We print the branch of BTree network that is described by "LLRLRLR"
		exploreBranch(network,"LLRLRLR");
		System.out.println();
        
		// We traverse and print the BTree called network in a level-order fashion
		levelOrderTraversal(network);
		
	}
}
