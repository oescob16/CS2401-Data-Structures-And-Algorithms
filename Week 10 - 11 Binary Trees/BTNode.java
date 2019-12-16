/*************************************************************************
 * This class is the blueprint of a binary node that wraps information of 
 * a generic type T, and that has 2 links to 2 potential "children" 
 * called left and right.
 * Most of the code is given to you. 
 * You are asked to complete a few TODOs as shown below. 
 * There are 3 TODOs in this file (TODO 1, TODO 2, and TODO 3).
 * You can only add code in the TODOs. You are not allowed to modify 
 * anything else in the code. 
 *************************************************************************/ 

public class BTNode<T> {

    private T data;
    private BTNode<T> left;
    private BTNode<T> right;
    
    // Constructors ****************************************************************
    public BTNode() {}
    
    public BTNode(T d) {
        data = d;
        left = null;
        right = null;
    }
    
    // Setters *********************************************************************
    public void setData(T d) {
        data = d;   
    }
    
    public void setLeft(BTNode<T> L) {
        left = L;
    }
    
    public void setRight(BTNode<T> R) {
        right = R;
    }
    
    // Getters **********************************************************************
    public T getData() {
        return data;   
    }
    
    public BTNode<T> getLeft() {
        return left;   
    }
    
    public BTNode<T> getRight() {
        return right;   
    }
    
    // Other methods ***************************************************************
    /* printNode prints the content of the current node */
    public void printNode() {
        System.out.println(data.toString());   
    }

    /* Height computes the height of the current node */
    public int height() {

        if (this == null) return -1;
        if (right == null && left == null) return 0;
        return 1 + Math.max(left.height(), right.height());

        /*if(this == null) { return -1; }
        if(right == null && left == null) { return 0; }

        int leftCount = 0;
        int rightCount = 0;

        if(right != null){
            rightCount = right.height();
        }
        if(left != null){
            leftCount = left.height();
        }
        return 1 + Math.max(rightCount, leftCount);
        */
    }
    
    /* TODO 1:
     * SizeBelow computes the number of nodes that are part of the subtree
     * originating at the current node (this), including this current node 
     * TODO 1. Complete the implementation of the method sizeBelow.
     * Your implementation must be RECURSIVE */
    public int sizeBelow() {

        // We initialize and declare two variables, which will help us to store the number of nodes.
        // In other words, it is a recursive counter.
        int leftCount = 0;
        int rightCount = 0;

        // If no such root (node) exists, then return 0.
        if(this == null) return 0;

        // If the root right node exist, then call the method, but now right will the root.
        if(right != null) { rightCount = right.sizeBelow(); }

        // If the root left node exist, then call the method, but now left will the root.
        if(left != null) { leftCount = left.sizeBelow(); }

        // After finishing all the method calls and if statements then return the root + right and left variables,
        // which holds the amount of nodes in the sub-tree.
        return 1 + rightCount + leftCount;
    }
    
    /* TODO 2:
     * hasLeft returns true if the current node (this) has a non null left child, 
     * false otherwise 
     * TODO 2. Complete the implementation of the method hasLeft.
     */

    // This method computes whether the current node has a left child or not.
    public boolean hasLeft() { return left != null; }
    
    /* TODO 3:
     * hasRight returns true if the current node (this) has a non null right child, 
     * false otherwise 
     * TODO 3. Complete the implementation of the method hasLeft.
     */
    // This method computes whether the current node has a right child or not.
    public boolean hasRight() { return right != null; }
}