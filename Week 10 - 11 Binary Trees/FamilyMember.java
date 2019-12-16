/*************************************************************************
 * This class is the blueprint of a family member  
 * A family member has:
 *      - a first name, 
 *      - a last name, and 
 *      - a number of siblings 
 * You are not allowed to modify this code.
 *************************************************************************/ 

public class FamilyMember {
    private String fname;
    private String lname;
    private int siblings;
    
    // Constructors ****************************************************************
    public FamilyMember() {}
    
    public FamilyMember(String fn, String ln, int s) {
        fname = fn;
        lname = ln;
        siblings = s;
    }

    // Setters *********************************************************************
    public void setFName(String fn) {
        fname = fn;
    }
    
    public void setLName(String ln) {
        lname = ln;
    }
    
    public void setSiblings(int s) {
        siblings = s;
    }
    
    // Getters **********************************************************************
    public String getFName() {
        return fname;   
    }
    
    public String getLName() {
        return lname;   
    }
    
    public int getSiblings() {
        return siblings;   
    }
    
    // Other methods ***************************************************************
    public String toString() {
        return fname + " " + lname + ", who had: " + siblings + " siblings.";   
    }
}