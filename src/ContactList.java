import java.util.ArrayList;

public class ContactList {
    // Declares an ArrayList of all Person objects
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // FINISH THIS METHOD
    public Person getContacts() {
        return null;
    }

    public void addContact(Person person) {
        contacts.add(person);
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public Person sort(int sortBy) {
        int  length = contacts.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length; j++) {
                Person person1 = contacts.get(j);
                Person person2 = contacts.get(j + 1);

                if (sortBy == 0) {
                    String person1Info = person1.getFirstName();
                    String person2Info = person2.getFirstName();
                }

                else if(sortBy == 1) {
                    String person1Info = person1.getLastName();
                    String person2Info = person2.getLastName();
                }

                else {
                    String person1Info = person1.getPhoneNumber();
                    String person2Info = person2.getPhoneNumber();
                }
                if (person1Info.compareTo(person2Info) > 0) {
                    Person temp = person1;
                    person1 = person2;
                    person2 = temp;
                }
            }
        }

    }

    public void listStudents() {

    }

    public void run() {

    }

}
