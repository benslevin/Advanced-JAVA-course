import java.util.Scanner;

//This Main Class tests the other classes
public class Main {

    private static final int SIZE = 10;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[SIZE];
        Integer[] arr2 = new Integer[SIZE];
        Integer[] arr3 = new Integer[SIZE];

        setRandomIntegers(arr1);
        setRandomIntegers(arr2);
        setRandomIntegers(arr3);

        Sets<Integer> set1 = new Sets<Integer>(arr1);
        Sets<Integer> set2 = new Sets<Integer>(arr2);
        Sets<Integer> set3 = new Sets<Integer>(arr3);


        System.out.println("##########################################################################################");
        System.out.println("Testing seif B:");

        //Union of set1 and set2
        System.out.println("\nTesting union: ");
        System.out.println("The numbers in set1 are: " + set1); // before union
        System.out.println("The numbers in set2 are: " + set2); // before union
        System.out.print("The union of set1 and set2 is: ");
        set1.union(set2);
        System.out.println(set1); // after union

        //Intersect of set1 and set3
        System.out.println("\nTesting intersect: ");
        System.out.println("The numbers in set1 are: " + set1); // before intersect
        System.out.println("The numbers in set3 are: " + set3); // before intersect
        System.out.println("The intersect of set1 and set3 is: ");
        set1.intersect(set3);
        System.out.println(set1); // after intersection

        //Testing subset
        System.out.println("\nTesting subset: ");
        System.out.println("Set1 :" + set1);
        System.out.println("Set2 :" + set2);
        System.out.println("Set3 :" + set3);
        Sets<Integer> set4 = new Sets<Integer>();
        //getting 2 numbers from user
        System.out.println("Please enter 2 integers between 0 and 100: ");
        for(int i = 0; i < 2; i++){
            while (!scanner.hasNextInt()){
                System.out.print("That's not a valid input, please enter a valid number: ");
                scanner.next();
            }
            set4.insert(scanner.nextInt());
        }
        System.out.println("The numbers in set4 are: " + set4);
        if(set1.isSubset(set4)){
            System.out.println("Set1 :" + set1);
            System.out.println("Set 4 is a subset of set 1");
        } else if(set2.isSubset(set4)){
            System.out.println("Set2 :" + set2);
            System.out.println("Set 4 is a subset of set 2");
        } else if(set3.isSubset(set4)) {
            System.out.println("Set3 :" + set3);
            System.out.println("Set 4 is a subset of set 3");
        } else {
            System.out.println("Set 4 is not a subset of any existing set");
        }

        //Testing isMember + insert + delete
        System.out.println("\nTesting isMember + insert + delete: ");
        System.out.println("Please enter a number between 0 and 100: ");
        int userInput = 0;
        while(!scanner.hasNextInt()){
            System.out.print("That's not a valid input, please enter a valid number: ");
            scanner.next();
        }
        userInput = scanner.nextInt();
        System.out.println("Is the user input a member of set1? \nThe answer is: " + set1.isMember(userInput));
        System.out.println("Set2 contains: " + set2); // before insert
        set2.insert(userInput);
        System.out.println("After inserting user input set2 contains: " + set2); // after insert
        System.out.println("Set3 contains: " + set3); // before insert
        set3.delete(userInput);
        System.out.println("After inserting user input set3 contains: " + set3); // after insert

        System.out.println("\n##########################################################################################");
        System.out.println("Testing seif C:");

        Person person1 = new Person("1", "Bob", "Dylan", "24/05/1941");
        Person person2 = new Person("2", "Leonard", "Cohen", "21/09/1934");
        Person person3 = new Person("3", "Johnny", "Cash", "26/02/1932");
        Person person4 = new Person("4", "Elvis", "Presley", "8/01/1935");
        Person person5 = new Person("5", "willie", "Nelson", "29/04/1933");
        Person[] persons = {person1,person2,person3,person4,person5};
        Sets<Person> set5 = new Sets<Person>(persons);
        System.out.println(set5);//Printing the person set

        System.out.print("\nThe smallest value in the set is: ");
        System.out.print(Comparing.minValue(set5));//Printing the outcome of the smallest Person in the set

    }

    //A private function that helps set 10 random numbers in the sets
    private static void setRandomIntegers(Integer[] arr){
        for(int i = 0; i < SIZE; i++){
            arr[i] = (int) (Math.random() * 100); //inserts 10 random numbers between 0 and 100
        }
    }
}
