import java.util.ArrayList;
import java.util.Scanner;
//This class is the main function of the program, it gets the values needed from the user, creates the array and the threads and prints the outcome
public class Main {

    private final static int MAX_VAL = 100;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Getting the size of the array and creating the array number of threads from user
        System.out.println("Please enter a number for the size of the array: ");
        int sizeOfArray = askUserForInput();
        Member m = new Member(generateArr(sizeOfArray));
        m.setNumOfMembers(sizeOfArray);
        System.out.print("The array generated is: {");
        m.printArray();
        //System.out.println("\nThe sum of the array is: " + m.calcSum());


        //Getting the number of threads from user
        System.out.println("\nPlease enter the number of threads you want to use: ");
        int numOfThreads = askUserForInput();
        System.out.println("The number of threads is: " + numOfThreads);

        //Creating the different threads
        MembersMerge[] membersMerges = new MembersMerge[numOfThreads];
        for(int i = 0; i < membersMerges.length; i++){
            membersMerges[i] = new MembersMerge(i, m);
        }
        //Starting the different threads
        for(int i = membersMerges.length-1; i >= 0; i--){
            membersMerges[i].start();
        }
        System.out.println("The sum of all members is: " + m.getLastMember());
        System.out.println("All threads completed their job, stopping program");
    }

    //This function asks the user for an integer as input for array size and number of threads
    private static int askUserForInput(){
        int number = 0;
        do{
            while(!scanner.hasNextInt()){
                System.out.println("That's not a valid number");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }

    //This function gets a number from the user and creates an array the size of the number of random numbers between 1 and 100
    private static ArrayList<Integer> generateArr(int number){
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < number; i++){
            arrList.add((int) ((Math.random()) * MAX_VAL));
        }
        return arrList;
    }
}
