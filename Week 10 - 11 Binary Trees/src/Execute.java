/*************************************************************************
 * In this file, you get to use the blueprints you have participated in
 * creating (BTNode, BTree). 
 * Namely, in this file, you are going to manipulate binary trees. 
 * Most of the code is given to you. 
 *      - The main method is given to you. 
 *      - A set of helper methods are also provided to you: you may or 
 *        may not elect to use them, it is fine. 
 * There is 1 TODO in this file: TODO 6.
 * Note: You can only add code in the TODOs. You are not allowed to modify 
 * anything else in the code. 
 *************************************************************************/ 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Execute {

    /* TODO 6: 
     * Method readFamilyIntoTree: 
     * Takes a file name and reads this file with family information, 
     * creates and fills a linked-list-based tree with family member information.
     * Note: Father-line nodes go to the left and Mother-line nodes go to the right
     ****************************************************************************************/
    public static BTree<FamilyMember> readFamilyIntoTree(String filename) throws FileNotFoundException, IOException {
        
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        // Create an empty binary tree of Family Members
        BTree<FamilyMember> Tree = new BTree<FamilyMember>();

        // While there is a line to read, keep looping.
        while(textReader.ready()){

            // Declare currFamilyMember of type FamilyMember, to store the current family member information.
            FamilyMember currFamilyMember;
            // Declare positionInBTree to store the position of the curr family member.
            String positionInBTree;

            // We proceed to read the whole line.
            String currLine = textReader.readLine();

            // Because there may be more than one family member in the line, then separate each member.
            String[] splitMembers = currLine.split(" ");

            // If there is more than one member in the current line then enter the for loop, to store each members info.
            for(int i = 0; i < splitMembers.length; i++){

                // We split the info of the current member
                String[] currMember = processLine(splitMembers[i]);
                // We proceed to store the info of the current member into FamilyMember
                currFamilyMember = new FamilyMember(currMember[0], currMember[1], Integer.parseInt(currMember[2]));
                // We store the location in the BTree into positionInBTree
                positionInBTree = currMember[3];
                // We proceed to call the method insertDataLocation to create a new BTNode with the info of the
                // current member and set this member (node) into the corresponding position in the BTree.
                Tree.insertDataAtLocation(positionInBTree, currFamilyMember);
            }
        }
        textReader.close();

        // We update the size of the BTree
        Tree.resetSize();
        // We update the height of the BTree
        Tree.resetHeight();

        // Return the resulting filled tree
        return Tree;

    }
            
    
    /****************************************************************************************   
     * Main Method: DO NOT MODIFY THE MAIN METHOD
     ****************************************************************************************/    
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = args[0];

        // Creates a linked-list-based tree directly from reading the file:
        BTree<FamilyMember> Tree = readFamilyIntoTree(filename);
        // Prints out the content of the linked-list-based tree:
        Tree.print();
        //Tree.inOrderTraversal();
        //Tree.postOrderTraversal();
        
        System.out.println("Tree size = " + Tree.getSize());
        System.out.println("Tree height = " + Tree.getHeight());
        System.out.println();
        System.out.println();
    }

    
    
    /************************************************************************************
     * HELPER METHODS: ******************************************************************
     ************************************************************************************/

    /* Method processLine:
     * This method is given a String that is one element of the line in the text file for be read.
     * The element is of the following form: <String>-<String>,<int>,<String>
     * Example of such an element: John-Doe,3,LLR
     * It processes this element and produces an array of 4 strings: 
     * [first name, last name, number of siblings, location in the array where it should be stored]
     * In the case of the above example, we would produce the following array: [John, Doe, 3, LLR]
     */
    public static String[] processLine(String element) {
        String[] result = new String[4];

        String[] member = element.split(",");
        String[] name = member[0].split("-");
        result[0] = name[0];
        result[1] = name[1];
        result[2] = member[1];
        result[3] = member[2];

        return result;
    }

    /* Method countLines: 
     * This method takes a file name as a parameter and 
     * returns the number of lines in this file (an int)
     */
    public static int countLines(String filename) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int counter = 0;
        // As long as there is something to read in the file...
        while (textReader.ready()) {
            // we increase our line counter
            counter++;
            // read the line and move to the next to check if there is something to read (the while condition)
            textReader.readLine();   
        }
        
        textReader.close();
        return counter;
    }


}
