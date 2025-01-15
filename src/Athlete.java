public class Athlete extends Person{
    // Instance variables
    private String sport;

    // Constructor
    public Athlete(String firstName, String lastName, String phoneNumber, String sport) {
        // Calls superclass constructor
        super(firstName, lastName, phoneNumber);

        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return super.toString() + " " + sport;
    }
}
