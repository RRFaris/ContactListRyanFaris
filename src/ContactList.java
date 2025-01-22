import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Declares an ArrayList of all Person objects
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("Select a type of contact to add:\n1. Student\n2. Athlete");
        int type = input.nextInt();
        input.nextLine();

        System.out.println("Please fill in the following information.");

        System.out.println("First Name:");
        String firstName = input.nextLine();

        System.out.println("Last Name:");
        String lastName = input.nextLine();

        System.out.println("Phone Number:");
        String phoneNumber = input.nextLine();

        if (type == 1) {
            System.out.println("Grade:");
            int grade = input.nextInt();

            Student s = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(s);
        }

        else {
            System.out.println("Sport:");
            String sport = input.nextLine();

            Athlete a = new Athlete(firstName, lastName, phoneNumber, sport);
            contacts.add(a);
        }
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public void sort(int sortBy) {
        String person1Info;
        String person2Info;
        int  length = contacts.size();

        // Bubble sort algorithm
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Person person1 = contacts.get(j);
                Person person2 = contacts.get(j + 1);

                if (sortBy == 0) {
                     person1Info = person1.getFirstName();
                     person2Info = person2.getFirstName();
                }

                else if(sortBy == 1) {
                     person1Info = person1.getLastName();
                     person2Info = person2.getLastName();
                }

                else {
                     person1Info = person1.getPhoneNumber();
                     person2Info = person2.getPhoneNumber();
                }

                if (person1Info.compareTo(person2Info) > 0) {
                    contacts.set(j, person2);
                    contacts.set(j + 1, person1);
                }
            }
        }
    }

    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for(Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for(Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for(Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int num = 0;
        do {
            System.out.println("""
                               Menu:
                               1. Add Contact
                               2. List All Contacts By First Name
                               3. List All Contacts By Last Name
                               4. List All Contacts by Phone Number
                               5. List All Students
                               6. Search By First Name
                               7. Search By Last Name
                               8. Search By Phone Number
                               0. Exit
                               """);
            num = input.nextInt();
            input.nextLine();

            if (num == 1)
                addContact();

            if (num == 2) {
                sort(0);
                printContacts();
            }

            if (num == 3) {
                sort(1);
                printContacts();
            }

            if (num == 4) {
                sort(3);
                printContacts();
            }

            if (num == 5)
                listStudents();

            if (num == 6) {
                System.out.println("Enter a name:");
                String firstName = input.nextLine();

                if (searchByFirstName(firstName) == null) {
                    System.out.println(firstName + " is not in the list");
                }
                else
                    System.out.println(searchByFirstName(firstName));
            }

            if (num == 7) {
                System.out.println("Enter a name:");
                String lastName = input.nextLine();

                if (searchByLastName(lastName) == null) {
                    System.out.println(lastName + " is not in the list");
                }
                else
                    System.out.println(searchByLastName(lastName));
            }

            if (num == 8) {
                System.out.println("Enter a number:");
                String phoneNumber = input.nextLine();

                if (searchByPhoneNumber(phoneNumber) == null) {
                    System.out.println(phoneNumber + " is not in the list");
                }
                else
                    System.out.println(searchByPhoneNumber(phoneNumber));
            }

        } while(num != 0);
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}
