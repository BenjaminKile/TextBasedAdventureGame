public class Node {

    private int ID;
    private int StudentID;
    private String firstname;
    private String surname;
    private int age;
    private String programme;

    public Node() {
    }

    public Node(int ID, int studentID, String firstname, String surname, int age, String programme) {
        this.ID = ID;
        StudentID = studentID;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.programme = programme;
    }

    public int getID() {return ID; }
    public void setID(int ID) {this.ID = ID; }

    public int getStudentID() { return StudentID;}
    public void setStudentID(int studentID) {StudentID = studentID; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname;}

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getProgramme() { return programme; }
    public void setProgramme(String programme) { this.programme = programme; }

    @Override
    public String toString() {
        return "Node - " +
                "ID:" + ID +
                ", StudentID:" + StudentID +
                ", firstname:'" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", age:" + age +
                ", programme:'" + programme + '\'';
    }
}
