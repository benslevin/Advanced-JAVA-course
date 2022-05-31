//Worker class
//This class represents the thread array and the run function
public class ThreadArray extends Thread{

    private ArrayMonitor arrayMonitor;
    private int threadNumber;
    private int threadPosition;
    private static int numOfRepetitions;

    //Constructor
    public ThreadArray(ArrayMonitor arrayMonitor, int threadNumber, int threadPosition){
        this.arrayMonitor = arrayMonitor;
        this.threadNumber = threadNumber;
        this.threadPosition = threadPosition;
    }

    //Getter
    public int getThreadNumber() {
        return threadNumber;
    }

    //Getter
    public int getThreadPosition() {
        return threadPosition;
    }

    //Setter
    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    //Setter
    public static void setNumOfRepetitions(int number){
        numOfRepetitions = number;
    }

    //This function starts the threads and does the following functions
    //checks the cells (to see if the number needs updating), updates the number, and resets the variables in the monitor class
    @Override
    public void run(){
        super.run();
        for(int i = 0; i < numOfRepetitions; i++) {
            arrayMonitor.checkCells(getThreadPosition(), i+1);
            arrayMonitor.updateArray(getThreadPosition());
            arrayMonitor.resetVariables(getThreadPosition());
            //System.out.println("thread " + getThreadPosition() + " finished iteration " + i+1);
        }
        //System.out.println(getThreadPosition() + " Finished working");
    }
}
