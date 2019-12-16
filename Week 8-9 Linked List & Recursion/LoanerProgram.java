/*************************************************************************
 * This file is where you will have to complete your assignment. 
 * Here, you will write methods that do the following:
 * 1/ read student loaner information from a file and build a linked list 
 *      of dossiers from there
 * 2/ identify a node that contains the dossier of a student with a given ID
 *      Your method is expected to be RECURSIVE
 * 3/ transfer the data from a linked list to an array
 * 4/ sort the data in the array of loaner dossiers between returned and 
 *      not returned laptops
 *      This method should be inspired by QUICK SORT
 * 5/ complete the main method as prompted
 * Note: in all your work below, you will be expected to use the methods 
 * already defined in the files provided to you (Student.java, Dossier.java,
 * Node.java, LList.java). You are not to redefined functionalities that 
 * already exist.
 *************************************************************************/ 

/**
 * 
 * @author mceberio
 * @student ... <-- FILL IN HERE WITH YOUR NAME
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoanerProgram {

    /**
     * TASK 1.
     * @param filename
     * @return a linked list of Loaner Dossiers whose information was read in the file called filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static LList<Dossier> readStudentInfo(String filename) throws FileNotFoundException, IOException {
		
    	LList<Dossier> loanerList = new LList<Dossier>();
    	
    	FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        Scanner scnr = new Scanner(System.in);

        // We type an empty string because we don't have majors available.
        String studentMajor = " ";

        // We declare a new Node of type Dossier
        Node<Dossier> newNode;

        // currLine is going to read the current line
        String currLine = textReader.readLine();

        while(textReader.ready()){

            // If currLine is equal to Dossier then store the information of the user in a Node.
            if(currLine.equals("Dossier")) {

                // studentName reads and stores the name of the user.
                String studentName = textReader.readLine().trim();
                // studentID reads and stores the ID of the user. Also, it converts the string into an integer.
                int studentID = Integer.parseInt(textReader.readLine().trim());
                // dateBorrowed reads and stores the date of when the user borrowed a laptop.
                int dateBorrowed = Integer.parseInt(textReader.readLine().trim());

                // infoStudent of type Student stores the name, ID, and major of the user and creates a new student.
                Student infoStudent = new Student(studentName, studentMajor, studentID);
                // newStudent of type Dossier stores infoStudent (of type student) and dateBorrowed (of type int), and creates a new Dossier.
                Dossier newStudent = new Dossier(infoStudent, dateBorrowed);
                // After all this process we proceed to create a new node that will store newStudent
                newNode = new Node<>(newStudent);
                //After storing the information we then add newNode to the linkedList called loanerList
                loanerList.addStart(newNode);

            }

            // If currLine equals update then update the information of the Dossier with the given info.
            else if(currLine.equals("Update")){

                // keyID is in charge of reading which ID is going to be updated.
                int keyID = Integer.parseInt(textReader.readLine().trim());
                // dateReturned is in charge of setting the date which the user returned the laptop
                int dateReturned = Integer.parseInt(textReader.readLine().trim());
                // updateOnDossier creates a Node of type Dossier which returns the node of the user that we are looking to update.
                Node<Dossier> updateOnDossier = findStudentWithGivenID(loanerList.getHead(), keyID);
                // updateOnDossier then updates and sets the given info to the Node.
                updateOnDossier.getData().setDateReturned(dateReturned);
            }

            // update currLine
            currLine = textReader.readLine();
        }
        textReader.close();
        return loanerList;
    }
 
    /* 
     * TASK 2.
     * Takes: a node of a Loaner Dossier and a student ID 
     * Returns: the node that corresponds to this given student's loan
     * This method MUST be used (called) within the above method: readStudentInfo
     */
    public static Node<Dossier> findStudentWithGivenID(Node<Dossier> myNode, int ID) {

        // If the current node is null then return null. Therefore, the given ID does not exist.
        if(myNode.getData() == null){
            return null;
        }

        // If the ID of the current node equals to the ID that we are looking for, then return node.
        if(myNode.getData().getStudent().getID() == (ID)){
            return myNode;
        }

        // Update node, this means that we are going to be on the next node.
        return findStudentWithGivenID(myNode.getNext(), ID);
    }
    
    /* 
     * TASK 3.
     * Takes: a linked list of Loaner Dossiers 
     * Returns: an array of the size of the linked list, and that contains the same data
     *      as the linked list
     */
    public static Dossier[] createArrayOfLoanerDossiers(LList<Dossier> myList) {

        // We declare a 1D array of type Dossier called loanerArray and the size will be the size of the linkedList
        Dossier[] loanerArray = new Dossier[myList.getSize()];

        // We assign index to 0, because we want to populate every element in the array
        int index = 0;
        // We create a temporary Node called temp, that will be in charge of traversing the linkedList
        Node temp = myList.getHead();

        // If temp is not equal then proceed to make the following operations
        while(temp != null){

            // Assign the data of the current node to the array at the current index
            loanerArray[index] = (Dossier) temp.getData();
            // We then proceed to move to the next node
            temp = temp.getNext();
            // Update index to store data at all the positions in the array.
            index++;
        }

        return loanerArray;
    }
    
    /* 
     * TASK 4.
     * Takes an array of Loaner Dossiers
     * Re-arranges this array so that all non-returned Dossiers are at the start of the array and all returned are at the end
     * Hint: use a Quick Sort like approach
     */
    public static void sortByNotReturned(Dossier[] myList) {

        int high = myList.length - 1;
        int low = 0;

        // i and j, are going to help us to traverse the array and swap elements
        int i = high;
        int j = high;

        // While j is bigger than or equal to low
        while(j >= low){

            // If the date returned of the current dossier is not equal to -1, then...
            if(myList[j].getDateReturned() != -1) {
                // Decrement i
                i--;
                // Create a temporary Dossier that holds the information of the current dossier
                Dossier temp = myList[i];
                // Swap elements
                myList[i] = myList[j];
                myList[j] = temp;
            }
            // Decrement j
            j--;
        }
        // Swap element that was missing to swap
        Dossier temp = myList[i];
        myList[i] = myList[high];
        myList[high] = temp;

    }

    public static void sortByNotReturnedByDate(Dossier[] myList){

        int high = myList.length - 1;
        int low = 0;

        // i and j, are going to help us to traverse the array and swap elements
        int i = high;
        int j = high;

        // Create oldestNotReturned that will hold the oldest date borrowed from users that have not returned
        // a laptop and oldestReturned will hold the oldest date borrowed from users that have returned the laptop.
        int oldestNotReturned = Integer.MAX_VALUE;
        int oldestReturned = Integer.MAX_VALUE;

        // While j is bigger than or equal to low.
        // Note: this first while loop is to sort the array by returned and not returned dossiers
        while(j >= low){

            // If the date returned of the current dossier is not equal to -1, then...
            if(myList[j].getDateReturned() != -1) {
                // Decrement i
                i--;
                // Create a temporary Dossier that holds the information of the current dossier
                Dossier temp = myList[i];
                // Swap elements
                myList[i] = myList[j];
                myList[j] = temp;

                // If the current dossier borrowed date is less than oldestReturned, then assign that value to oldestReturned
                if(myList[i].getDateBorrowed() < oldestReturned){
                    oldestReturned = myList[i].getDateBorrowed();
                }
            }

            // Else if the current dossier borrowed date is less than oldestNotReturned, then assign that value to oldestNotReturned
            if(myList[j].getDateBorrowed() < oldestNotReturned){
                oldestNotReturned = myList[j].getDateBorrowed();
            }
            // Decrement j
            j--;
        }

        // Swap element that was missing to swap
        Dossier temp = myList[i];
        myList[i] = myList[high];
        myList[high] = temp;

        // Now with the sorted array, we then proceed to sort the 2 sections (returned and not returned) to oldest
        // to recents.
        for(i = 0; i < myList.length - 1; i++){
            // If the current dossier has not returned the laptop and the date borrowed is oldest than oldestNotReturned
            if( (myList[i].getDateReturned() == -1) && (myList[i].getDateBorrowed() > oldestNotReturned) ){
                // Then assign oldestNotReturned to the current dossier
                oldestNotReturned = myList[i].getDateBorrowed();
                // Swap elements
                Dossier temp1 = myList[i];
                myList[i] = myList[i + 1];
                myList[i + 1] = temp1;
            }
            // Else if the current dossier has returned the laptop and the date borrowed is oldest than the oldestReturned
            else if( (myList[i].getDateReturned() != -1) && (myList[i].getDateBorrowed() > oldestReturned) ){
                // Then assign oldestReturn to the current dossier
                oldestReturned = myList[i].getDateBorrowed();
                // Swap elements
                Dossier temp2 = myList[i];
                myList[i] = myList[i + 1];
                myList[i + 1] = temp2;
            }
        }
    }

    public static boolean hasBorrowed(int ID, Dossier[] myList){

        // We create a for loop to iterate the 1D array of type Dossier
        for(int i = 0; i < myList.length; i++){

            //If the current user has not yet returned the laptop and the ID is the one that we are looking for then return true
            if((myList[i].getDateReturned() == -1) && (myList[i].getStudent().getID() == ID)){
                return true;
            }
        }
        // If the user has returned the laptop then return false.
        return false;
    }

    public static Student studentLongestPeriodBorrowed(Dossier[] myList){

        // maxPeriod is going to store which user kept a laptop for a long period of time.
        int maxPeriod = 0;
        // Create a new student called currStudent
        Student currStudent = new Student();

        // Create a for loop to visit each element
        for(int i = 0; i < myList.length; i++) {
            // If the current dossier equals -1, then do nothing and return to the condition
            if (myList[i].getDateReturned() == -1)
            {
                continue;
            }
            // Store the difference between the date returned and date borrowed
            int diffPeriod = myList[i].getDateReturned() - myList[i].getDateBorrowed();

            // If the diffPeriod is bigger than the maxPeriod, then store maxPeriod to diffPeriod
            if (diffPeriod > maxPeriod)
            {
                maxPeriod = diffPeriod;
                // If this is the longest period then set currStudent to the current dossier
                currStudent = myList[i].getStudent();
            }
        }
        return currStudent;
    }
    
    /*
     * TASK 5.
     * Complete the main method as prompted below
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Step 1. Create a linked list of dossiers from reading the file loanerInfo.txt
        String filename = "loanerInfo.txt";
        LList<Dossier> listOfDossiers = new LList<Dossier>();
        listOfDossiers = readStudentInfo(filename);

        // Step 2. Print the content of this linked list
        System.out.println("\n******* Print the content of the LinkedList of Dossiers ********\n");
        listOfDossiers.print();
        
        // Step 3. Create an array of dossiers from this linked list
        Dossier[] arrayOfDossiers = createArrayOfLoanerDossiers(listOfDossiers);

        // Step 4. Sort the dossiers between not_returned (first part of the array) and returned (last part of the array)
        sortByNotReturned(arrayOfDossiers);

        /*
        // Extra-Credit No. 1 - Create sortByNotReturnedByDate method
        // Note: Comment sortByNotReturned call and uncomment this Extra-Credit block of comments so you can see the result!!
        sortByNotReturnedByDate(arrayOfDossiers);
        */

        // Step 5. Print the content of the array
        System.out.println("\n******* Print the content of the sorted Array of Dossiers ********\n");

        for(int i = 0; i < arrayOfDossiers.length; i++){
            System.out.print(arrayOfDossiers[i].toString() + "\n");
        }

        // Extra-Credit No. 3 - Create hasBorrowed method
        System.out.print("**************** Extra-Credit No. 3 **************** \n\n");

        for(int i = 0; i < arrayOfDossiers.length; i++){
            System.out.println("Has " + arrayOfDossiers[i].getStudent().getName() + " borrowed a laptop? " + hasBorrowed(arrayOfDossiers[i].getStudent().getID(), arrayOfDossiers));
        }

        // Extra-Credit No. 4 - Create a method that identifies, among the dossiers of returned laptops, the student who kept
        //a laptop the longest
        System.out.print("\n**************** Extra-Credit No. 4 **************** \n");
        System.out.println("\nWhich student kept a laptop the longest? " + studentLongestPeriodBorrowed(arrayOfDossiers).getName());

    }
}
