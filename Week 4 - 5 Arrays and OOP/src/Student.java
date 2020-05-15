/**
 * 
 * @author mceberio
 * @student Oswaldo Escobedo, Username: oescobedo3
 *
 */

public class Student {

	private String name;
	private String major;
	private int[] grades;
	
	/* CONSTRUCTORS ***********************************************/
	public Student(){
	}

	public Student(String name, String major, int[] grades) {
		this.name = name;
		this.major = major;
		this.grades = grades;
	}

	/* GETTERS ****************************************************/
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * @return the grades
	 */
	public int[] getGrades() {
		return grades;
	}
	
	/* SETTERS ****************************************************/
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * @param grades the grades to set
	 */
	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	/* OTHER METHODS ***********************************************/
	/**
	 * prints out the name and major of the student
	 */
	public void print() {
    	System.out.print("~Name: " + name + " ~Major: " + major);
	}
	
	/**
	 * prints out the name, major, and grades of the student
	 */
	public void printAll() {
		print();
		System.out.print(" ~Grades: ");
		for(int i = 0; i < grades.length; i++){
			System.out.print(grades[i] + " ");
		}
		System.out.println();
	}
		
	/* BOTH METHODS BELOW NEED TO BE TESTED USING JUNIT TESTS: 3 tests per method ******/	
	/**
	 * Method average:
	 * @return the average of all grades in array grades (without weights)
	 */
	public double average() {
	    double sum = 0.0;

        for (int grade : grades) { sum += grade; }
		return (sum / grades.length);
	}

	/**
	 * Method averageW:
	 * @return the average of all grades in array grades (with weights)
	 */
	public double averageW(int[] weights) {

		double sum = 0.0;
		int sumW = 0;

		for (int i = 0; i < weights.length; i++) {
			sum += (grades[i] * weights[i]);
			sumW += weights[i];
		}

		//We divide the total sum by the total sum of weights
		return (sum / sumW);
	}


}
