/**
 * 
 * @author mceberio
 * @student Oswaldo Escobedo, Username: oescobedo3
 *
 */

import java.io.*;
import java.util.Scanner;

public class Execute {

	/**
	 * 
	 * @param filename
	 * @return the number of students in the file called filename
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
    public static int numStudents(String filename) throws FileNotFoundException, IOException {

        //Filereader searches the file based on the string that we sent and buffered starts to read the file
        FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int studentCount = 0;
        int count = 0;

        //We have a while loop to stop when the textReader doesn't have any other line to read
        while(textReader.ready()){
            textReader.readLine();

            //Every 3 lines equals 1 student, therefore we use the multiple of 3 condition.
            if(count % 3 == 0){
                studentCount++;
            }
            count++;
        }
        /* MAKE SURE THAT THE NUMBER OF LINES IS CONSISTENT WITH WHAT YOU ARE EXPECTING 
         * FOR INSTANCE: IF THE NUMBER OF LINES IS NOT A MULTIPLE OF 3, THERE IS A PROBLEM
         */
        textReader.close();
    	return studentCount;
    }
    
    /**
     * 
     * @param filename
     * @return a 1D array of Students whose information was read in the file called filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Student[] readStudentInfo(String filename) throws FileNotFoundException, IOException {

        //Here we call the method numStudents, because we want to set the size equal to the number of students in size
    	int numStudents = numStudents(filename);
    	Student[] roster = new Student[numStudents];
    	FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int i = 0;

        while (textReader.ready()) {

            //For each line we assign it to its respective value
            String studentName = textReader.readLine().trim();
            String studentMajor = textReader.readLine().trim();
            String splitGrades = textReader.readLine().trim();

            //We need to split the string of grades in order to separate each of them...
            String[] tmp = splitGrades.split(" ");

            int[] grades = new int[tmp.length];

            for(int j = 0; j < grades.length; j++){

                //So we can change them from a string to an integer
                grades[j] = Integer.parseInt(tmp[j]);
            }

            //We set Roster to position i so we can store the information many positions
            roster[i] = new Student(studentName, studentMajor, grades);
            i++;

        }
        
        textReader.close();
        return roster;
    }

    public static void writeStudentsInfo(String filename) throws FileNotFoundException, IOException {

        File file = new File(filename);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter pr = new PrintWriter(br);

        Scanner scnr = new Scanner(System.in);

        pr.println();

        System.out.print("\n\nType your name: ");
        String name = scnr.nextLine();
        pr.println(name);

        System.out.print("Type your major: ");
        String major = scnr.nextLine();
        pr.println(major);

        System.out.println("Type your grades (After typing a grade hit \"Enter\"): ");

        //We set 6 as the size/quantity of grades that the user can write to a file.
        int[] grades = new int[6];

        //We use a for loop so the user can have the option to write a grade in a specific position.
        for(int i = 0; i < grades.length; i++) {
            grades[i] = scnr.nextInt();
            pr.print(grades[i] + " ");
        }

        pr.close();
        br.close();
        fr.close();
    }
 
    /**
     * 
     * @param roster: 1D array of Students
     * @return a 2D array of grades (each row corresponds to a student's list of grades)
     */
    public static int[][] gradeSheet(Student[] roster) {

        //We use a for loop to store the grades into a 2d array called grades.
        int[][] grades = new int[roster.length][];

        for(int i = 0; i < grades.length; i++){
            int[] grades1D = roster[i].getGrades();
            grades[i] = grades1D;
        }
    	
    	return grades;
    }
    
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @return the index of the row with the best average, 
     * which corresponds to the index of the Student with best average in roster
     */
    public static int bestStudentAverage(int[][] gradeSheet) {

        int index = 0;
        double sum;
        double maxAvg = Integer.MIN_VALUE;
        double currentAvg = 0.0;

        //We create a for loop to iterate through each student (or rows)
        for(int i = 0; i < gradeSheet.length; i++){
            sum = 0.0;

            //We create a nested for loop to iterate through the grades of student at position i
            for(int j = 0; j < gradeSheet[i].length; j++){
                sum += gradeSheet[i][j];
            }

            currentAvg = sum / gradeSheet[i].length;

            //If the average of the current student is bigger than tha max average then we set maxAverage to be currentAvg
            if(currentAvg > maxAvg) {
                maxAvg = currentAvg;
                //Therefore, we set index to be the student(i) who has the maxAvg in that moment
                index = i;
            }
        }
    	return index;
    }
	
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @return the index of the row with the best averageW, 
     * which corresponds to the index of the Student with best averageW in roster
     */
    public static int bestStudentAverageW(int[][] gradeSheet, int[] weights) {
    	// COMPLETE CODE HERE
        // YOUR CODE SHOULD MAKE USE OF METHOD averageW DEFINED FOR type Student
    	return 0;
    }
	
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @param major: a String representing the major of the Student
     * @return the index of the row with the best average, 
     * among the students with a major matching @param major,
     * which corresponds to the index of the Student with best average in roster
     */
    public static int bestStudentAverage(int[][] gradeSheet, String major, Student[] roster) {

        int index = 0;
        double sum;
        double maxAvg = Integer.MIN_VALUE;
        double currentAvg = 0.0;

        for(int i = 0; i < gradeSheet.length; i++){
            sum = 0.0;

            for(int j = 0; j < gradeSheet[i].length; j++){
                sum += gradeSheet[i][j];
            }

            currentAvg = sum / gradeSheet[i].length;

            //If the user has a better average than the maxAverage and the major is Computer Science, then proceed to enter the if statement
            if((currentAvg > maxAvg) && (major.equals(roster[i].getMajor()))) {
                maxAvg = currentAvg;
                index = i;
            }

        }
    	return index;
    }
	
    /**
     * 
     * @param gradeSheet: a 2D array of grades
     * @param major: a String representing the major of the Student
     * @return the index of the row with the best averageW, 
     * among the students with a major matching @param major,
     * which corresponds to the index of the Student with best averageW in roster
     */
    public static int bestStudentAverageW(int[][] gradeSheet, String major, Student[] roster, int[] weights) {
    	// COMPLETE CODE HERE
        // THE CODE HERE SHOULD BE VERY SIMILAR TO THE CODE OF THE OTHER METHOD bestStudentAverageW
    	return 0;
    }
	
    /**
     * 
     * @param grades: a 2D array of grades
     * @return the index of the column with the best average,
     * which corresponds to the assignment with the most success in the classroom
     */
    public static int bestAssignmentAverage(int[][] grades) {

        int index = 0;
        double sum;
        double maxAvg = Integer.MIN_VALUE;
        double currentAvg = 0.0;

        //We set the grades[0].length because we want to iterate through the columns
        for(int i = 0; i < grades[0].length; i++){
            sum = 0.0;

            //We set grades.length after because we want to check each grade from the students in the columns
            for(int j = 0; j < grades.length; j++){
                    sum += grades[j][i];
            }

            currentAvg = sum / grades[i].length;

            if(currentAvg > maxAvg){
                maxAvg = currentAvg;
                index = i;
            }
        }
    	return index + 1;
    }
	
    /**
     * 
     * @param grades: a 2D array of grades
     * @param major: a String representing the major of the Student
     * @return the index of the column with the best averageW, among only the rows 
     * that correspond to students with major @param major
     * which corresponds to the assignment with the most success in the classroom
     */
    public static int bestAssignmentAverage(int[][] grades, String major, Student[] roster) {

        int index = 0;
        double sum;
        double maxAvg = Integer.MIN_VALUE;
        double currentAvg = 0.0;
        int count;

        for(int i = 0; i < grades[0].length; i++){
            sum = 0.0;
            count = 0;

            for(int j = 0; j < grades.length; j++){
                if(roster[j].getMajor().equals(major)) {
                    sum += grades[j][i];
                    count++;
                }
            }

            currentAvg = sum / count;

            if(currentAvg > maxAvg){
                maxAvg = currentAvg;
                index = i;
            }
        }
        return index + 1;
    }

	
    /**
     * Main method: follow instructions within to test your above code 
     * @param args
     */
    public static void main(String[] args) throws Exception{

        // 1. Read the file studentsInfo.txt and generate a 1D array of Students called roster
        Student[] roster = readStudentInfo("C:\\Users\\oesco\\IdeaProjects\\CS2401 - WEEK34\\src\\studentsInfo.txt");
    	
    	// 2. Create a gradeSheet and call it grades
        int[][] grades = gradeSheet(roster);

    	// 3. Print out the gradeSheet
    	for(int i = 0; i < grades.length; i++){
    	    System.out.print((i + 1) + ". Grades: ");
    	    for(int j = 0; j < grades[i].length; j++){
    	        System.out.print(grades[i][j] + " ");
            }
    	    System.out.println();
        }
        System.out.println();

    	// 4. Identify the student with best average and print out the student's information
        System.out.print("The student with the best average among all is: " + roster[bestStudentAverage(grades)].getName());
    	System.out.println("");

    	// 5. Identify the computer science student with best average and print out the student's information
        System.out.print("The Computer Science student with the best average is: " + roster[bestStudentAverage(grades, "Computer Science", roster)].getName());
        System.out.println();

    	// 6. Identify the assignment with most success and print out which assignment this was
    	System.out.print("\nAssignment with more success: No. " + bestAssignmentAverage(grades) + "\n");

    	// 7. Identify the assignment with most success among computer science students and print out which assignment this was
        System.out.print("Assignment with more success among CS students is: No. " + bestAssignmentAverage(grades, "Computer Science", roster) + "\n");

    	// 8. Create a method called writeStudentsInfo, which will allow the professor to add the student's name, major and grades
        Scanner scnr = new Scanner(System.in);

        System.out.print("\nDo you want to add another student information? [Y/N]: ");
        System.out.print("\nOr press T to go to the test cases: ");

        //Here we start to give the user the option whether to add a new student, exit the program or to check the test cases in main
        char yesOrNo = scnr.next().charAt(0);

        switch(yesOrNo){
            case 'Y':
            case 'y':
                writeStudentsInfo("C:\\Users\\oesco\\IdeaProjects\\CS2401 - WEEK34\\src\\studentsInfo.txt");
            break;

            case 'T':
            case 't':
                System.out.println("\nWelcome to the test cases section!");

                Student testWithDouble = new Student();
                testWithDouble.setGrades(new int[]{155/2, 209/2, 191/2, 173/2, 200/2, 165/2});
                System.out.print("\nFirst Test Case (Edge Case): \nWe are going to test if dividing with integers leads to the same result as if it were a double!");
                System.out.print("\nGrades: {155/2, 264/3, 191/2, 173/2, 200/2, 165/2}");
                System.out.print("\nExpected: 91.1\nActual: " + testWithDouble.average() + "\n");

                Student onlyFourGrades = new Student();
                onlyFourGrades.setGrades(new int[]{90, 60, 75, 80});
                System.out.print("\nSecond Test Case (Edge Case): \nThe test is based on taking the average of 6 grades, so what will happen if the student only has 4 grades?");
                System.out.print("\nGrades: {90, 60, 75, 80}");
                System.out.print("\nExpected: 50.83 \nActual: " + onlyFourGrades.average() + "\n");

               Student twoMissingGrades = new Student();
               twoMissingGrades.setGrades(new int[]{80, 0, 100, 85, 75, 0});
               System.out.print("\nThird Test Case (Base Case): \nThe test is going to compute the average of a student that didn't submit assignment No. 2 and 6");
               System.out.print("\nGrades of the student: {80, 0, 100, 85, 75, 0}");
               System.out.print("\nExpected: 56.7 \nActual: " + twoMissingGrades.average() + "\n\n");
            break;

            default:
                System.exit(0);
            break;

        }
    }
}