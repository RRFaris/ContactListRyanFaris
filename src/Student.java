public class Student extends Person{
    // Instance variable
    private int grade;

    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        // Calls superclass constructor
        super(firstName, lastName, phoneNumber);

        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
