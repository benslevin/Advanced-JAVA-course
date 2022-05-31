import java.util.Scanner;
//This class generates an array of threads (the size is set by the user)
//Each threads gets a random number and compares the numbers to his neighbors
//If the number is bigger than both, he decreases the number, and if it's smaller than both he increases the number, else does nothing
public class Main {

    private final static int MAX_VAL = 100;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Getting the number of threads from user
        System.out.println("Please enter a number for the number of threads you want to use: ");
        int numOfThreads = askUserForInput();
        ThreadArray[] myThreadList = new ThreadArray[numOfThreads];//Array of threads the size of the user input
        int[] myIntArray = new int[numOfThreads];//Array of threads the size of the user input
        ArrayMonitor arrayMonitor = new ArrayMonitor(myThreadList, myIntArray);// sending the array to the monitor class
        ArrayMonitor.setMAX(numOfThreads);

        //Getting the number of rounds from user
        System.out.println("Please enter a number for the number of rounds you want the program to run: ");
        int numOfRounds = askUserForInput();
        ThreadArray.setNumOfRepetitions(numOfRounds);

        //Creating the threads
        for(int i = 0; i < numOfThreads; i++){
            myThreadList[i] = new ThreadArray(arrayMonitor, generateThreadNumber(), i);
        }

        //Starting the threads
        for(int i = numOfThreads - 1; i >= 0; i--){
            myThreadList[i].start();
        }
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

    //This function generates a random number from 1 to 100 and sends it to the constructor as the thread number
    private static int generateThreadNumber(){
        return ((int) (Math.random() * MAX_VAL));
    }
}
