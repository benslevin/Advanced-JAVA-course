//This class is a person class, each person has an ID, first & last name and a date of birth
//This class implements the interface comparable
public class Person implements Comparable<Person>{

    private final String ID;
    private final String firstName;
    private final String lastName;
    private final String dateOfBirth;

    public Person(String ID, String firstName, String lastName, String dateOfBirth) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    //Overriding the compare to object to compare between 2 IDs' of different persons
    @Override
    public int compareTo(Person p) {
        if(this.ID.equals(p.ID)){//they are equals
            return 0;
        } else if(this.ID.compareTo(p.ID) > 0){//This is bigger than other person
            return 1;
        } else {//this is smaller than other person
            return -1;
        }
    }

    //Overriding toSting of Object to print out the person
    @Override
    public String toString() {
        return "\nPerson{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
