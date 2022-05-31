import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Monitor class
//This function lets the threads use the functions of the threadArray and intArray
public class ArrayMonitor {

    private ThreadArray[] myThreadList;
    private int[] myIntArray;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private int doneChecking = 0;
    private int doneUpdating = 0;
    private int doneResetting = 0;
    private static int MAX;

    //Constructor
    public ArrayMonitor(ThreadArray[] myThreadList, int[] myIntArray){
        this.myThreadList = myThreadList;
        this.myIntArray = myIntArray;
    }

    //Sets the MAX value as the length of the array as given by the user
    public static void setMAX(int max){
        MAX = max;
    }

    //This function checks the cells to the right and left of the thread
    public void checkCells(int i, int repetition){
        if(i == myThreadList.length - 1){ //it's the last cell in the array
            //checking if bigger than right & left cell
            if((myThreadList[i].getThreadNumber() > myThreadList[0].getThreadNumber())
                    && (myThreadList[i].getThreadNumber() > myThreadList[i-1].getThreadNumber())){ //This thread is bigger than his right cell
                myIntArray[i] = -1;
                //checking if smaller than right & left cell
            } else if((myThreadList[i].getThreadNumber() < myThreadList[0].getThreadNumber())
                    && (myThreadList[i].getThreadNumber() < myThreadList[i-1].getThreadNumber())){//This thread is smaller than his right cell
                myIntArray[i] = 1;
            } //The numbers of the threads are in between or equals
        } else if (i == 0){ //it's the first cell in the array
            //checking if bigger than right & left cell
            if((myThreadList[i].getThreadNumber() > myThreadList[myThreadList.length - 1].getThreadNumber())
                    && (myThreadList[i].getThreadNumber() > myThreadList[i+1].getThreadNumber())){ //This thread is bigger than his right cell
                myIntArray[i] = -1;
                //checking if smaller than right & left cell
            } else if((myThreadList[i].getThreadNumber() < myThreadList[myThreadList.length - 1].getThreadNumber())
                    && (myThreadList[i].getThreadNumber() < myThreadList[i+1].getThreadNumber())){//This thread is smaller than his right cell
                myIntArray[i] = 1;
            } //The numbers of the threads are in between or equals
        } else {
            //checking if bigger than right & left cell
            if((myThreadList[i].getThreadNumber() > myThreadList[i+1].getThreadNumber())
                    && (myThreadList[i].getThreadNumber() > myThreadList[i-1].getThreadNumber())){ //This thread is bigger than his right cell
                myIntArray[i] = -1;
                //checking if smaller than right & left cell
            } else if((myThreadList[i].getThreadNumber() < myThreadList[i+1].getThreadNumber())
                    && (myThreadList[i].getThreadNumber() < myThreadList[i-1].getThreadNumber())){//This thread is smaller than his right cell
                myIntArray[i] = 1;
            } //The numbers of the threads are in between or equals
        }
        lock.lock();
        doneChecking++; //counter for stage 1 - how many threads finished checking the cells
        if(doneChecking % MAX == 0){//So that only one thread prints the array
            printArray(repetition);
        }
        try {
            if (doneChecking % MAX == 0) {
                cond.signalAll();
            }
        }
        finally {
            lock.unlock();
        }
    }

    //This function waits for all threads to check their neighbors and then updates the threads number
    public void updateArray(int pos) {
        lock.lock();
        try {
            while (doneChecking % MAX != 0) {//Only after all threads are done checking, we start updating
                cond.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        if (myIntArray[pos] == 1) {
            myThreadList[pos].setThreadNumber(myThreadList[pos].getThreadNumber() + 1);
            //System.out.println("thread " + myThreadList[pos] + " succeeded in updating the number");
        } else if (myIntArray[pos] == -1) {
            myThreadList[pos].setThreadNumber(myThreadList[pos].getThreadNumber() - 1);
            //System.out.println("thread " + myThreadList[pos] + " succeeded in updating the number");
        }
        lock.lock();
        doneUpdating++;//counter for stage 2 - how many threads finished updating the numbers
        try {
            if (doneUpdating % MAX == 0) {
                cond.signalAll();
            }
        }
        finally {
            lock.unlock();
        }
    }

    //This function resets the variables for the next iteration
    public void resetVariables(int pos){
        lock.lock();
        try {
            while (doneUpdating % MAX != 0) {//Only after all threads are done updating, we start resetting
                cond.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        myIntArray[pos] = 0;//resetting the value, so we can keep track of the changes to the thread array
        //System.out.println(myThreadList[pos] + " has reset his intArray");
        lock.lock();
        doneResetting++;//counter for stage 3 - how many threads finished resetting the value of the intArray
        try {
            if (doneResetting % MAX == 0) {
                cond.signalAll();
            }
        }
        finally {
            lock.unlock();
        }
    }

    //Prints the array
    public void printArray(int m){
        System.out.println("\nIteration " + m + ":");
        System.out.print("The current array is: {");
        for(int i = 0; i < myThreadList.length; i++){
            if(i != myThreadList.length - 1){
                System.out.print(myThreadList[i].getThreadNumber() + ", ");
            }
            else{
                System.out.print(myThreadList[i].getThreadNumber());
            }
        }
        System.out.println("}");
    }
}
